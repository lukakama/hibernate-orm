/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * Copyright (c) 2010, Red Hat Inc. or third-party contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Red Hat Inc.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package org.hibernate.type;

import java.net.URL;

import org.hibernate.dialect.Dialect;
import org.hibernate.type.descriptor.java.UrlTypeDescriptor;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;

/**
 * A type that maps between {@link java.sql.Types#VARCHAR VARCHAR} and {@link URL}
 *
 * @author Steve Ebersole
 */
public class UrlType extends AbstractSingleColumnStandardBasicType<URL> implements DiscriminatorType<URL> {
	public static final UrlType INSTANCE = new UrlType();

	public UrlType() {
		super( VarcharTypeDescriptor.INSTANCE, UrlTypeDescriptor.INSTANCE );
	}

	public String getName() {
		return "url";
	}

	@Override
	protected boolean registerUnderJavaType() {
		return true;
	}

	@Override
	public String toString(URL value) {
		return UrlTypeDescriptor.INSTANCE.toString( value );
	}

	public String objectToSQLString(URL value, Dialect dialect) throws Exception {
		return StringType.INSTANCE.objectToSQLString( toString( value ), dialect );
	}

	public URL stringToObject(String xml) throws Exception {
		return UrlTypeDescriptor.INSTANCE.fromString( xml );
	}
}
