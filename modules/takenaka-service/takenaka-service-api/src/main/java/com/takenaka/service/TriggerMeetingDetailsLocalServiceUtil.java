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
 * Provides the local service utility for TriggerMeetingDetails. This utility wraps
 * <code>com.takenaka.service.impl.TriggerMeetingDetailsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Sanjay.Panchal
 * @see TriggerMeetingDetailsLocalService
 * @generated
 */
public class TriggerMeetingDetailsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.takenaka.service.impl.TriggerMeetingDetailsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the trigger meeting details to the database. Also notifies the appropriate model listeners.
	 *
	 * @param triggerMeetingDetails the trigger meeting details
	 * @return the trigger meeting details that was added
	 */
	public static com.takenaka.model.TriggerMeetingDetails
		addTriggerMeetingDetails(
			com.takenaka.model.TriggerMeetingDetails triggerMeetingDetails) {

		return getService().addTriggerMeetingDetails(triggerMeetingDetails);
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
	 * Creates a new trigger meeting details with the primary key. Does not add the trigger meeting details to the database.
	 *
	 * @param meetingdetailSeqno the primary key for the new trigger meeting details
	 * @return the new trigger meeting details
	 */
	public static com.takenaka.model.TriggerMeetingDetails
		createTriggerMeetingDetails(long meetingdetailSeqno) {

		return getService().createTriggerMeetingDetails(meetingdetailSeqno);
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
	 * Deletes the trigger meeting details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param meetingdetailSeqno the primary key of the trigger meeting details
	 * @return the trigger meeting details that was removed
	 * @throws PortalException if a trigger meeting details with the primary key could not be found
	 */
	public static com.takenaka.model.TriggerMeetingDetails
			deleteTriggerMeetingDetails(long meetingdetailSeqno)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteTriggerMeetingDetails(meetingdetailSeqno);
	}

	/**
	 * Deletes the trigger meeting details from the database. Also notifies the appropriate model listeners.
	 *
	 * @param triggerMeetingDetails the trigger meeting details
	 * @return the trigger meeting details that was removed
	 */
	public static com.takenaka.model.TriggerMeetingDetails
		deleteTriggerMeetingDetails(
			com.takenaka.model.TriggerMeetingDetails triggerMeetingDetails) {

		return getService().deleteTriggerMeetingDetails(triggerMeetingDetails);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.takenaka.model.impl.TriggerMeetingDetailsModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.takenaka.model.impl.TriggerMeetingDetailsModelImpl</code>.
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

	public static com.takenaka.model.TriggerMeetingDetails
		fetchTriggerMeetingDetails(long meetingdetailSeqno) {

		return getService().fetchTriggerMeetingDetails(meetingdetailSeqno);
	}

	public static com.takenaka.model.TriggerMeetingDetails findByMeetingSeqno(
			Long meetingSeqno)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().findByMeetingSeqno(meetingSeqno);
	}

	public static java.util.List<com.takenaka.model.TriggerMeetingDetails>
		findByMeetingSeqnoList(long meetingSeqno) {

		return getService().findByMeetingSeqnoList(meetingSeqno);
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
	 * Returns the trigger meeting details with the primary key.
	 *
	 * @param meetingdetailSeqno the primary key of the trigger meeting details
	 * @return the trigger meeting details
	 * @throws PortalException if a trigger meeting details with the primary key could not be found
	 */
	public static com.takenaka.model.TriggerMeetingDetails
			getTriggerMeetingDetails(long meetingdetailSeqno)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getTriggerMeetingDetails(meetingdetailSeqno);
	}

	/**
	 * Returns a range of all the trigger meeting detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.takenaka.model.impl.TriggerMeetingDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trigger meeting detailses
	 * @param end the upper bound of the range of trigger meeting detailses (not inclusive)
	 * @return the range of trigger meeting detailses
	 */
	public static java.util.List<com.takenaka.model.TriggerMeetingDetails>
		getTriggerMeetingDetailses(int start, int end) {

		return getService().getTriggerMeetingDetailses(start, end);
	}

	/**
	 * Returns the number of trigger meeting detailses.
	 *
	 * @return the number of trigger meeting detailses
	 */
	public static int getTriggerMeetingDetailsesCount() {
		return getService().getTriggerMeetingDetailsesCount();
	}

	/**
	 * Updates the trigger meeting details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param triggerMeetingDetails the trigger meeting details
	 * @return the trigger meeting details that was updated
	 */
	public static com.takenaka.model.TriggerMeetingDetails
		updateTriggerMeetingDetails(
			com.takenaka.model.TriggerMeetingDetails triggerMeetingDetails) {

		return getService().updateTriggerMeetingDetails(triggerMeetingDetails);
	}

	public static TriggerMeetingDetailsLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<TriggerMeetingDetailsLocalService, TriggerMeetingDetailsLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			TriggerMeetingDetailsLocalService.class);

		ServiceTracker
			<TriggerMeetingDetailsLocalService,
			 TriggerMeetingDetailsLocalService> serviceTracker =
				new ServiceTracker
					<TriggerMeetingDetailsLocalService,
					 TriggerMeetingDetailsLocalService>(
						 bundle.getBundleContext(),
						 TriggerMeetingDetailsLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}