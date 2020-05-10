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
 * Provides the local service utility for DesignChangeDetails. This utility wraps
 * <code>com.takenaka.service.impl.DesignChangeDetailsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Sanjay.Panchal
 * @see DesignChangeDetailsLocalService
 * @generated
 */
public class DesignChangeDetailsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.takenaka.service.impl.DesignChangeDetailsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the design change details to the database. Also notifies the appropriate model listeners.
	 *
	 * @param designChangeDetails the design change details
	 * @return the design change details that was added
	 */
	public static com.takenaka.model.DesignChangeDetails addDesignChangeDetails(
		com.takenaka.model.DesignChangeDetails designChangeDetails) {

		return getService().addDesignChangeDetails(designChangeDetails);
	}

	/**
	 * Creates a new design change details with the primary key. Does not add the design change details to the database.
	 *
	 * @param dcrChangeSeqno the primary key for the new design change details
	 * @return the new design change details
	 */
	public static com.takenaka.model.DesignChangeDetails
		createDesignChangeDetails(long dcrChangeSeqno) {

		return getService().createDesignChangeDetails(dcrChangeSeqno);
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
	 * Deletes the design change details from the database. Also notifies the appropriate model listeners.
	 *
	 * @param designChangeDetails the design change details
	 * @return the design change details that was removed
	 */
	public static com.takenaka.model.DesignChangeDetails
		deleteDesignChangeDetails(
			com.takenaka.model.DesignChangeDetails designChangeDetails) {

		return getService().deleteDesignChangeDetails(designChangeDetails);
	}

	/**
	 * Deletes the design change details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dcrChangeSeqno the primary key of the design change details
	 * @return the design change details that was removed
	 * @throws PortalException if a design change details with the primary key could not be found
	 */
	public static com.takenaka.model.DesignChangeDetails
			deleteDesignChangeDetails(long dcrChangeSeqno)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteDesignChangeDetails(dcrChangeSeqno);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.takenaka.model.impl.DesignChangeDetailsModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.takenaka.model.impl.DesignChangeDetailsModelImpl</code>.
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

	public static com.takenaka.model.DesignChangeDetails
		fetchDesignChangeDetails(long dcrChangeSeqno) {

		return getService().fetchDesignChangeDetails(dcrChangeSeqno);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the design change details with the primary key.
	 *
	 * @param dcrChangeSeqno the primary key of the design change details
	 * @return the design change details
	 * @throws PortalException if a design change details with the primary key could not be found
	 */
	public static com.takenaka.model.DesignChangeDetails getDesignChangeDetails(
			long dcrChangeSeqno)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getDesignChangeDetails(dcrChangeSeqno);
	}

	public static java.util.List<com.takenaka.model.DesignChangeDetails>
		getDesignChangeDetailsByFilter(
			String rfcId, String issuer, String rangeOfDisclosure,
			String changeRequestby, String approvalStatus,
			String constructionStatus, String expensePayment,
			java.util.Date dCRInitiatedStr, java.util.Date dCRInitiatedEnd) {

		return getService().getDesignChangeDetailsByFilter(
			rfcId, issuer, rangeOfDisclosure, changeRequestby, approvalStatus,
			constructionStatus, expensePayment, dCRInitiatedStr,
			dCRInitiatedEnd);
	}

	/**
	 * Returns a range of all the design change detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.takenaka.model.impl.DesignChangeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of design change detailses
	 * @param end the upper bound of the range of design change detailses (not inclusive)
	 * @return the range of design change detailses
	 */
	public static java.util.List<com.takenaka.model.DesignChangeDetails>
		getDesignChangeDetailses(int start, int end) {

		return getService().getDesignChangeDetailses(start, end);
	}

	/**
	 * Returns the number of design change detailses.
	 *
	 * @return the number of design change detailses
	 */
	public static int getDesignChangeDetailsesCount() {
		return getService().getDesignChangeDetailsesCount();
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
	 * Updates the design change details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param designChangeDetails the design change details
	 * @return the design change details that was updated
	 */
	public static com.takenaka.model.DesignChangeDetails
		updateDesignChangeDetails(
			com.takenaka.model.DesignChangeDetails designChangeDetails) {

		return getService().updateDesignChangeDetails(designChangeDetails);
	}

	public static DesignChangeDetailsLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<DesignChangeDetailsLocalService, DesignChangeDetailsLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			DesignChangeDetailsLocalService.class);

		ServiceTracker
			<DesignChangeDetailsLocalService, DesignChangeDetailsLocalService>
				serviceTracker =
					new ServiceTracker
						<DesignChangeDetailsLocalService,
						 DesignChangeDetailsLocalService>(
							 bundle.getBundleContext(),
							 DesignChangeDetailsLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}