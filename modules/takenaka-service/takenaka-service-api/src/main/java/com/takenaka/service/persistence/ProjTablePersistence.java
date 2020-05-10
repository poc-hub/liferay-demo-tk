/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.takenaka.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.takenaka.exception.NoSuchProjTableException;
import com.takenaka.model.ProjTable;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the proj table service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sanjay.Panchal
 * @see ProjTableUtil
 * @generated
 */
@ProviderType
public interface ProjTablePersistence extends BasePersistence<ProjTable> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProjTableUtil} to access the proj table persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the proj table in the entity cache if it is enabled.
	 *
	 * @param projTable the proj table
	 */
	public void cacheResult(ProjTable projTable);

	/**
	 * Caches the proj tables in the entity cache if it is enabled.
	 *
	 * @param projTables the proj tables
	 */
	public void cacheResult(java.util.List<ProjTable> projTables);

	/**
	 * Creates a new proj table with the primary key. Does not add the proj table to the database.
	 *
	 * @param recId the primary key for the new proj table
	 * @return the new proj table
	 */
	public ProjTable create(long recId);

	/**
	 * Removes the proj table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param recId the primary key of the proj table
	 * @return the proj table that was removed
	 * @throws NoSuchProjTableException if a proj table with the primary key could not be found
	 */
	public ProjTable remove(long recId) throws NoSuchProjTableException;

	public ProjTable updateImpl(ProjTable projTable);

	/**
	 * Returns the proj table with the primary key or throws a <code>NoSuchProjTableException</code> if it could not be found.
	 *
	 * @param recId the primary key of the proj table
	 * @return the proj table
	 * @throws NoSuchProjTableException if a proj table with the primary key could not be found
	 */
	public ProjTable findByPrimaryKey(long recId)
		throws NoSuchProjTableException;

	/**
	 * Returns the proj table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param recId the primary key of the proj table
	 * @return the proj table, or <code>null</code> if a proj table with the primary key could not be found
	 */
	public ProjTable fetchByPrimaryKey(long recId);

	/**
	 * Returns all the proj tables.
	 *
	 * @return the proj tables
	 */
	public java.util.List<ProjTable> findAll();

	/**
	 * Returns a range of all the proj tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of proj tables
	 * @param end the upper bound of the range of proj tables (not inclusive)
	 * @return the range of proj tables
	 */
	public java.util.List<ProjTable> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the proj tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of proj tables
	 * @param end the upper bound of the range of proj tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of proj tables
	 */
	public java.util.List<ProjTable> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjTable>
			orderByComparator);

	/**
	 * Returns an ordered range of all the proj tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of proj tables
	 * @param end the upper bound of the range of proj tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of proj tables
	 */
	public java.util.List<ProjTable> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjTable>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the proj tables from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of proj tables.
	 *
	 * @return the number of proj tables
	 */
	public int countAll();

}