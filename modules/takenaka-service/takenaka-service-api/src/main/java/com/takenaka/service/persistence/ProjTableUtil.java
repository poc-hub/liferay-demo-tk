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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.takenaka.model.ProjTable;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the proj table service. This utility wraps <code>com.takenaka.service.persistence.impl.ProjTablePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sanjay.Panchal
 * @see ProjTablePersistence
 * @generated
 */
public class ProjTableUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(ProjTable projTable) {
		getPersistence().clearCache(projTable);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, ProjTable> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProjTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProjTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProjTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProjTable> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProjTable update(ProjTable projTable) {
		return getPersistence().update(projTable);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProjTable update(
		ProjTable projTable, ServiceContext serviceContext) {

		return getPersistence().update(projTable, serviceContext);
	}

	/**
	 * Caches the proj table in the entity cache if it is enabled.
	 *
	 * @param projTable the proj table
	 */
	public static void cacheResult(ProjTable projTable) {
		getPersistence().cacheResult(projTable);
	}

	/**
	 * Caches the proj tables in the entity cache if it is enabled.
	 *
	 * @param projTables the proj tables
	 */
	public static void cacheResult(List<ProjTable> projTables) {
		getPersistence().cacheResult(projTables);
	}

	/**
	 * Creates a new proj table with the primary key. Does not add the proj table to the database.
	 *
	 * @param recId the primary key for the new proj table
	 * @return the new proj table
	 */
	public static ProjTable create(long recId) {
		return getPersistence().create(recId);
	}

	/**
	 * Removes the proj table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param recId the primary key of the proj table
	 * @return the proj table that was removed
	 * @throws NoSuchProjTableException if a proj table with the primary key could not be found
	 */
	public static ProjTable remove(long recId)
		throws com.takenaka.exception.NoSuchProjTableException {

		return getPersistence().remove(recId);
	}

	public static ProjTable updateImpl(ProjTable projTable) {
		return getPersistence().updateImpl(projTable);
	}

	/**
	 * Returns the proj table with the primary key or throws a <code>NoSuchProjTableException</code> if it could not be found.
	 *
	 * @param recId the primary key of the proj table
	 * @return the proj table
	 * @throws NoSuchProjTableException if a proj table with the primary key could not be found
	 */
	public static ProjTable findByPrimaryKey(long recId)
		throws com.takenaka.exception.NoSuchProjTableException {

		return getPersistence().findByPrimaryKey(recId);
	}

	/**
	 * Returns the proj table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param recId the primary key of the proj table
	 * @return the proj table, or <code>null</code> if a proj table with the primary key could not be found
	 */
	public static ProjTable fetchByPrimaryKey(long recId) {
		return getPersistence().fetchByPrimaryKey(recId);
	}

	/**
	 * Returns all the proj tables.
	 *
	 * @return the proj tables
	 */
	public static List<ProjTable> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<ProjTable> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<ProjTable> findAll(
		int start, int end, OrderByComparator<ProjTable> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<ProjTable> findAll(
		int start, int end, OrderByComparator<ProjTable> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the proj tables from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of proj tables.
	 *
	 * @return the number of proj tables
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProjTablePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ProjTablePersistence, ProjTablePersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ProjTablePersistence.class);

		ServiceTracker<ProjTablePersistence, ProjTablePersistence>
			serviceTracker =
				new ServiceTracker<ProjTablePersistence, ProjTablePersistence>(
					bundle.getBundleContext(), ProjTablePersistence.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}