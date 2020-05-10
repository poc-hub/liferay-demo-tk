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
 * Provides the local service utility for TriggerMeeting. This utility wraps
 * <code>com.takenaka.service.impl.TriggerMeetingLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Sanjay.Panchal
 * @see TriggerMeetingLocalService
 * @generated
 */
public class TriggerMeetingLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.takenaka.service.impl.TriggerMeetingLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the trigger meeting to the database. Also notifies the appropriate model listeners.
	 *
	 * @param triggerMeeting the trigger meeting
	 * @return the trigger meeting that was added
	 */
	public static com.takenaka.model.TriggerMeeting addTriggerMeeting(
		com.takenaka.model.TriggerMeeting triggerMeeting) {

		return getService().addTriggerMeeting(triggerMeeting);
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
	 * Creates a new trigger meeting with the primary key. Does not add the trigger meeting to the database.
	 *
	 * @param meetingSeqno the primary key for the new trigger meeting
	 * @return the new trigger meeting
	 */
	public static com.takenaka.model.TriggerMeeting createTriggerMeeting(
		long meetingSeqno) {

		return getService().createTriggerMeeting(meetingSeqno);
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
	 * Deletes the trigger meeting with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param meetingSeqno the primary key of the trigger meeting
	 * @return the trigger meeting that was removed
	 * @throws PortalException if a trigger meeting with the primary key could not be found
	 */
	public static com.takenaka.model.TriggerMeeting deleteTriggerMeeting(
			long meetingSeqno)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteTriggerMeeting(meetingSeqno);
	}

	/**
	 * Deletes the trigger meeting from the database. Also notifies the appropriate model listeners.
	 *
	 * @param triggerMeeting the trigger meeting
	 * @return the trigger meeting that was removed
	 */
	public static com.takenaka.model.TriggerMeeting deleteTriggerMeeting(
		com.takenaka.model.TriggerMeeting triggerMeeting) {

		return getService().deleteTriggerMeeting(triggerMeeting);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.takenaka.model.impl.TriggerMeetingModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.takenaka.model.impl.TriggerMeetingModelImpl</code>.
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

	public static com.takenaka.model.TriggerMeeting fetchTriggerMeeting(
		long meetingSeqno) {

		return getService().fetchTriggerMeeting(meetingSeqno);
	}

	public static com.takenaka.model.TriggerMeeting findByMeetingId(
			String meetingId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().findByMeetingId(meetingId);
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
	 * Returns the trigger meeting with the primary key.
	 *
	 * @param meetingSeqno the primary key of the trigger meeting
	 * @return the trigger meeting
	 * @throws PortalException if a trigger meeting with the primary key could not be found
	 */
	public static com.takenaka.model.TriggerMeeting getTriggerMeeting(
			long meetingSeqno)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getTriggerMeeting(meetingSeqno);
	}

	public static java.util.List<com.takenaka.model.TriggerMeeting>
		getTriggerMeetingByFilter(
			String meetingType, String meetingId, String issuer,
			String meetingTitle, java.util.Date meetDateStr,
			java.util.Date meetDateEnd) {

		return getService().getTriggerMeetingByFilter(
			meetingType, meetingId, issuer, meetingTitle, meetDateStr,
			meetDateEnd);
	}

	/**
	 * Returns a range of all the trigger meetings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.takenaka.model.impl.TriggerMeetingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trigger meetings
	 * @param end the upper bound of the range of trigger meetings (not inclusive)
	 * @return the range of trigger meetings
	 */
	public static java.util.List<com.takenaka.model.TriggerMeeting>
		getTriggerMeetings(int start, int end) {

		return getService().getTriggerMeetings(start, end);
	}

	/**
	 * Returns the number of trigger meetings.
	 *
	 * @return the number of trigger meetings
	 */
	public static int getTriggerMeetingsCount() {
		return getService().getTriggerMeetingsCount();
	}

	/**
	 * Updates the trigger meeting in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param triggerMeeting the trigger meeting
	 * @return the trigger meeting that was updated
	 */
	public static com.takenaka.model.TriggerMeeting updateTriggerMeeting(
		com.takenaka.model.TriggerMeeting triggerMeeting) {

		return getService().updateTriggerMeeting(triggerMeeting);
	}

	public static TriggerMeetingLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<TriggerMeetingLocalService, TriggerMeetingLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			TriggerMeetingLocalService.class);

		ServiceTracker<TriggerMeetingLocalService, TriggerMeetingLocalService>
			serviceTracker =
				new ServiceTracker
					<TriggerMeetingLocalService, TriggerMeetingLocalService>(
						bundle.getBundleContext(),
						TriggerMeetingLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}