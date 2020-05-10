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

import com.takenaka.model.DesignChangeDetails;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the design change details service. This utility wraps <code>com.takenaka.service.persistence.impl.DesignChangeDetailsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sanjay.Panchal
 * @see DesignChangeDetailsPersistence
 * @generated
 */
public class DesignChangeDetailsUtil {

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
	public static void clearCache(DesignChangeDetails designChangeDetails) {
		getPersistence().clearCache(designChangeDetails);
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
	public static Map<Serializable, DesignChangeDetails> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DesignChangeDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DesignChangeDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DesignChangeDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DesignChangeDetails> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DesignChangeDetails update(
		DesignChangeDetails designChangeDetails) {

		return getPersistence().update(designChangeDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DesignChangeDetails update(
		DesignChangeDetails designChangeDetails,
		ServiceContext serviceContext) {

		return getPersistence().update(designChangeDetails, serviceContext);
	}

	/**
	 * Caches the design change details in the entity cache if it is enabled.
	 *
	 * @param designChangeDetails the design change details
	 */
	public static void cacheResult(DesignChangeDetails designChangeDetails) {
		getPersistence().cacheResult(designChangeDetails);
	}

	/**
	 * Caches the design change detailses in the entity cache if it is enabled.
	 *
	 * @param designChangeDetailses the design change detailses
	 */
	public static void cacheResult(
		List<DesignChangeDetails> designChangeDetailses) {

		getPersistence().cacheResult(designChangeDetailses);
	}

	/**
	 * Creates a new design change details with the primary key. Does not add the design change details to the database.
	 *
	 * @param dcrChangeSeqno the primary key for the new design change details
	 * @return the new design change details
	 */
	public static DesignChangeDetails create(long dcrChangeSeqno) {
		return getPersistence().create(dcrChangeSeqno);
	}

	/**
	 * Removes the design change details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dcrChangeSeqno the primary key of the design change details
	 * @return the design change details that was removed
	 * @throws NoSuchDesignChangeDetailsException if a design change details with the primary key could not be found
	 */
	public static DesignChangeDetails remove(long dcrChangeSeqno)
		throws com.takenaka.exception.NoSuchDesignChangeDetailsException {

		return getPersistence().remove(dcrChangeSeqno);
	}

	public static DesignChangeDetails updateImpl(
		DesignChangeDetails designChangeDetails) {

		return getPersistence().updateImpl(designChangeDetails);
	}

	/**
	 * Returns the design change details with the primary key or throws a <code>NoSuchDesignChangeDetailsException</code> if it could not be found.
	 *
	 * @param dcrChangeSeqno the primary key of the design change details
	 * @return the design change details
	 * @throws NoSuchDesignChangeDetailsException if a design change details with the primary key could not be found
	 */
	public static DesignChangeDetails findByPrimaryKey(long dcrChangeSeqno)
		throws com.takenaka.exception.NoSuchDesignChangeDetailsException {

		return getPersistence().findByPrimaryKey(dcrChangeSeqno);
	}

	/**
	 * Returns the design change details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dcrChangeSeqno the primary key of the design change details
	 * @return the design change details, or <code>null</code> if a design change details with the primary key could not be found
	 */
	public static DesignChangeDetails fetchByPrimaryKey(long dcrChangeSeqno) {
		return getPersistence().fetchByPrimaryKey(dcrChangeSeqno);
	}

	/**
	 * Returns all the design change detailses.
	 *
	 * @return the design change detailses
	 */
	public static List<DesignChangeDetails> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the design change detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignChangeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of design change detailses
	 * @param end the upper bound of the range of design change detailses (not inclusive)
	 * @return the range of design change detailses
	 */
	public static List<DesignChangeDetails> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the design change detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignChangeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of design change detailses
	 * @param end the upper bound of the range of design change detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of design change detailses
	 */
	public static List<DesignChangeDetails> findAll(
		int start, int end,
		OrderByComparator<DesignChangeDetails> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the design change detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignChangeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of design change detailses
	 * @param end the upper bound of the range of design change detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of design change detailses
	 */
	public static List<DesignChangeDetails> findAll(
		int start, int end,
		OrderByComparator<DesignChangeDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the design change detailses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of design change detailses.
	 *
	 * @return the number of design change detailses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DesignChangeDetailsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<DesignChangeDetailsPersistence, DesignChangeDetailsPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			DesignChangeDetailsPersistence.class);

		ServiceTracker
			<DesignChangeDetailsPersistence, DesignChangeDetailsPersistence>
				serviceTracker =
					new ServiceTracker
						<DesignChangeDetailsPersistence,
						 DesignChangeDetailsPersistence>(
							 bundle.getBundleContext(),
							 DesignChangeDetailsPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}