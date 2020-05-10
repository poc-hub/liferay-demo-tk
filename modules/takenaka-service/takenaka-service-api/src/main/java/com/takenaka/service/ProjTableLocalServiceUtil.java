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

package com.takenaka.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for ProjTable. This utility wraps
 * <code>com.takenaka.service.impl.ProjTableLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Sanjay.Panchal
 * @see ProjTableLocalService
 * @generated
 */
public class ProjTableLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.takenaka.service.impl.ProjTableLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the proj table to the database. Also notifies the appropriate model listeners.
	 *
	 * @param projTable the proj table
	 * @return the proj table that was added
	 */
	public static com.takenaka.model.ProjTable addProjTable(
		com.takenaka.model.ProjTable projTable) {

		return getService().addProjTable(projTable);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			createPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new proj table with the primary key. Does not add the proj table to the database.
	 *
	 * @param recId the primary key for the new proj table
	 * @return the new proj table
	 */
	public static com.takenaka.model.ProjTable createProjTable(long recId) {
		return getService().createProjTable(recId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the proj table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param recId the primary key of the proj table
	 * @return the proj table that was removed
	 * @throws PortalException if a proj table with the primary key could not be found
	 */
	public static com.takenaka.model.ProjTable deleteProjTable(long recId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteProjTable(recId);
	}

	/**
	 * Deletes the proj table from the database. Also notifies the appropriate model listeners.
	 *
	 * @param projTable the proj table
	 * @return the proj table that was removed
	 */
	public static com.takenaka.model.ProjTable deleteProjTable(
		com.takenaka.model.ProjTable projTable) {

		return getService().deleteProjTable(projTable);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.takenaka.model.impl.ProjTableModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.takenaka.model.impl.ProjTableModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.takenaka.model.ProjTable fetchProjTable(long recId) {
		return getService().fetchProjTable(recId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the proj table with the primary key.
	 *
	 * @param recId the primary key of the proj table
	 * @return the proj table
	 * @throws PortalException if a proj table with the primary key could not be found
	 */
	public static com.takenaka.model.ProjTable getProjTable(long recId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getProjTable(recId);
	}

	/**
	 * Returns a range of all the proj tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.takenaka.model.impl.ProjTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of proj tables
	 * @param end the upper bound of the range of proj tables (not inclusive)
	 * @return the range of proj tables
	 */
	public static java.util.List<com.takenaka.model.ProjTable> getProjTables(
		int start, int end) {

		return getService().getProjTables(start, end);
	}

	/**
	 * Returns the number of proj tables.
	 *
	 * @return the number of proj tables
	 */
	public static int getProjTablesCount() {
		return getService().getProjTablesCount();
	}

	/**
	 * Updates the proj table in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param projTable the proj table
	 * @return the proj table that was updated
	 */
	public static com.takenaka.model.ProjTable updateProjTable(
		com.takenaka.model.ProjTable projTable) {

		return getService().updateProjTable(projTable);
	}

	public static ProjTableLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ProjTableLocalService, ProjTableLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ProjTableLocalService.class);

		ServiceTracker<ProjTableLocalService, ProjTableLocalService>
			serviceTracker =
				new ServiceTracker
					<ProjTableLocalService, ProjTableLocalService>(
						bundle.getBundleContext(), ProjTableLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}