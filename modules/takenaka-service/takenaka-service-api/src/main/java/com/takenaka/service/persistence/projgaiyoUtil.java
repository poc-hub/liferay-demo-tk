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

import com.takenaka.model.projgaiyo;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the projgaiyo service. This utility wraps <code>com.takenaka.service.persistence.impl.projgaiyoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sanjay.Panchal
 * @see projgaiyoPersistence
 * @generated
 */
public class projgaiyoUtil {

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
	public static void clearCache(projgaiyo projgaiyo) {
		getPersistence().clearCache(projgaiyo);
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
	public static Map<Serializable, projgaiyo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<projgaiyo> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<projgaiyo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<projgaiyo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<projgaiyo> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static projgaiyo update(projgaiyo projgaiyo) {
		return getPersistence().update(projgaiyo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static projgaiyo update(
		projgaiyo projgaiyo, ServiceContext serviceContext) {

		return getPersistence().update(projgaiyo, serviceContext);
	}

	/**
	 * Returns all the projgaiyos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching projgaiyos
	 */
	public static List<projgaiyo> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the projgaiyos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>projgaiyoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of projgaiyos
	 * @param end the upper bound of the range of projgaiyos (not inclusive)
	 * @return the range of matching projgaiyos
	 */
	public static List<projgaiyo> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the projgaiyos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>projgaiyoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of projgaiyos
	 * @param end the upper bound of the range of projgaiyos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching projgaiyos
	 */
	public static List<projgaiyo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<projgaiyo> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the projgaiyos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>projgaiyoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of projgaiyos
	 * @param end the upper bound of the range of projgaiyos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching projgaiyos
	 */
	public static List<projgaiyo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<projgaiyo> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first projgaiyo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching projgaiyo
	 * @throws NoSuchprojgaiyoException if a matching projgaiyo could not be found
	 */
	public static projgaiyo findByUuid_First(
			String uuid, OrderByComparator<projgaiyo> orderByComparator)
		throws com.takenaka.exception.NoSuchprojgaiyoException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first projgaiyo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching projgaiyo, or <code>null</code> if a matching projgaiyo could not be found
	 */
	public static projgaiyo fetchByUuid_First(
		String uuid, OrderByComparator<projgaiyo> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last projgaiyo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching projgaiyo
	 * @throws NoSuchprojgaiyoException if a matching projgaiyo could not be found
	 */
	public static projgaiyo findByUuid_Last(
			String uuid, OrderByComparator<projgaiyo> orderByComparator)
		throws com.takenaka.exception.NoSuchprojgaiyoException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last projgaiyo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching projgaiyo, or <code>null</code> if a matching projgaiyo could not be found
	 */
	public static projgaiyo fetchByUuid_Last(
		String uuid, OrderByComparator<projgaiyo> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the projgaiyos before and after the current projgaiyo in the ordered set where uuid = &#63;.
	 *
	 * @param groupId the primary key of the current projgaiyo
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next projgaiyo
	 * @throws NoSuchprojgaiyoException if a projgaiyo with the primary key could not be found
	 */
	public static projgaiyo[] findByUuid_PrevAndNext(
			long groupId, String uuid,
			OrderByComparator<projgaiyo> orderByComparator)
		throws com.takenaka.exception.NoSuchprojgaiyoException {

		return getPersistence().findByUuid_PrevAndNext(
			groupId, uuid, orderByComparator);
	}

	/**
	 * Removes all the projgaiyos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of projgaiyos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching projgaiyos
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the projgaiyo where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchprojgaiyoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching projgaiyo
	 * @throws NoSuchprojgaiyoException if a matching projgaiyo could not be found
	 */
	public static projgaiyo findByUUID_G(String uuid, long groupId)
		throws com.takenaka.exception.NoSuchprojgaiyoException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the projgaiyo where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching projgaiyo, or <code>null</code> if a matching projgaiyo could not be found
	 */
	public static projgaiyo fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the projgaiyo where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching projgaiyo, or <code>null</code> if a matching projgaiyo could not be found
	 */
	public static projgaiyo fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the projgaiyo where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the projgaiyo that was removed
	 */
	public static projgaiyo removeByUUID_G(String uuid, long groupId)
		throws com.takenaka.exception.NoSuchprojgaiyoException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of projgaiyos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching projgaiyos
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Caches the projgaiyo in the entity cache if it is enabled.
	 *
	 * @param projgaiyo the projgaiyo
	 */
	public static void cacheResult(projgaiyo projgaiyo) {
		getPersistence().cacheResult(projgaiyo);
	}

	/**
	 * Caches the projgaiyos in the entity cache if it is enabled.
	 *
	 * @param projgaiyos the projgaiyos
	 */
	public static void cacheResult(List<projgaiyo> projgaiyos) {
		getPersistence().cacheResult(projgaiyos);
	}

	/**
	 * Creates a new projgaiyo with the primary key. Does not add the projgaiyo to the database.
	 *
	 * @param groupId the primary key for the new projgaiyo
	 * @return the new projgaiyo
	 */
	public static projgaiyo create(long groupId) {
		return getPersistence().create(groupId);
	}

	/**
	 * Removes the projgaiyo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupId the primary key of the projgaiyo
	 * @return the projgaiyo that was removed
	 * @throws NoSuchprojgaiyoException if a projgaiyo with the primary key could not be found
	 */
	public static projgaiyo remove(long groupId)
		throws com.takenaka.exception.NoSuchprojgaiyoException {

		return getPersistence().remove(groupId);
	}

	public static projgaiyo updateImpl(projgaiyo projgaiyo) {
		return getPersistence().updateImpl(projgaiyo);
	}

	/**
	 * Returns the projgaiyo with the primary key or throws a <code>NoSuchprojgaiyoException</code> if it could not be found.
	 *
	 * @param groupId the primary key of the projgaiyo
	 * @return the projgaiyo
	 * @throws NoSuchprojgaiyoException if a projgaiyo with the primary key could not be found
	 */
	public static projgaiyo findByPrimaryKey(long groupId)
		throws com.takenaka.exception.NoSuchprojgaiyoException {

		return getPersistence().findByPrimaryKey(groupId);
	}

	/**
	 * Returns the projgaiyo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param groupId the primary key of the projgaiyo
	 * @return the projgaiyo, or <code>null</code> if a projgaiyo with the primary key could not be found
	 */
	public static projgaiyo fetchByPrimaryKey(long groupId) {
		return getPersistence().fetchByPrimaryKey(groupId);
	}

	/**
	 * Returns all the projgaiyos.
	 *
	 * @return the projgaiyos
	 */
	public static List<projgaiyo> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the projgaiyos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>projgaiyoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of projgaiyos
	 * @param end the upper bound of the range of projgaiyos (not inclusive)
	 * @return the range of projgaiyos
	 */
	public static List<projgaiyo> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the projgaiyos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>projgaiyoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of projgaiyos
	 * @param end the upper bound of the range of projgaiyos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of projgaiyos
	 */
	public static List<projgaiyo> findAll(
		int start, int end, OrderByComparator<projgaiyo> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the projgaiyos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>projgaiyoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of projgaiyos
	 * @param end the upper bound of the range of projgaiyos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of projgaiyos
	 */
	public static List<projgaiyo> findAll(
		int start, int end, OrderByComparator<projgaiyo> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the projgaiyos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of projgaiyos.
	 *
	 * @return the number of projgaiyos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static projgaiyoPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<projgaiyoPersistence, projgaiyoPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(projgaiyoPersistence.class);

		ServiceTracker<projgaiyoPersistence, projgaiyoPersistence>
			serviceTracker =
				new ServiceTracker<projgaiyoPersistence, projgaiyoPersistence>(
					bundle.getBundleContext(), projgaiyoPersistence.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}