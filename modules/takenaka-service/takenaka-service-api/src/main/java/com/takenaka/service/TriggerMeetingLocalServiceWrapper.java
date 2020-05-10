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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TriggerMeetingLocalService}.
 *
 * @author Sanjay.Panchal
 * @see TriggerMeetingLocalService
 * @generated
 */
public class TriggerMeetingLocalServiceWrapper
	implements ServiceWrapper<TriggerMeetingLocalService>,
			   TriggerMeetingLocalService {

	public TriggerMeetingLocalServiceWrapper(
		TriggerMeetingLocalService triggerMeetingLocalService) {

		_triggerMeetingLocalService = triggerMeetingLocalService;
	}

	/**
	 * Adds the trigger meeting to the database. Also notifies the appropriate model listeners.
	 *
	 * @param triggerMeeting the trigger meeting
	 * @return the trigger meeting that was added
	 */
	@Override
	public com.takenaka.model.TriggerMeeting addTriggerMeeting(
		com.takenaka.model.TriggerMeeting triggerMeeting) {

		return _triggerMeetingLocalService.addTriggerMeeting(triggerMeeting);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _triggerMeetingLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new trigger meeting with the primary key. Does not add the trigger meeting to the database.
	 *
	 * @param meetingSeqno the primary key for the new trigger meeting
	 * @return the new trigger meeting
	 */
	@Override
	public com.takenaka.model.TriggerMeeting createTriggerMeeting(
		long meetingSeqno) {

		return _triggerMeetingLocalService.createTriggerMeeting(meetingSeqno);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _triggerMeetingLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the trigger meeting with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param meetingSeqno the primary key of the trigger meeting
	 * @return the trigger meeting that was removed
	 * @throws PortalException if a trigger meeting with the primary key could not be found
	 */
	@Override
	public com.takenaka.model.TriggerMeeting deleteTriggerMeeting(
			long meetingSeqno)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _triggerMeetingLocalService.deleteTriggerMeeting(meetingSeqno);
	}

	/**
	 * Deletes the trigger meeting from the database. Also notifies the appropriate model listeners.
	 *
	 * @param triggerMeeting the trigger meeting
	 * @return the trigger meeting that was removed
	 */
	@Override
	public com.takenaka.model.TriggerMeeting deleteTriggerMeeting(
		com.takenaka.model.TriggerMeeting triggerMeeting) {

		return _triggerMeetingLocalService.deleteTriggerMeeting(triggerMeeting);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _triggerMeetingLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _triggerMeetingLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _triggerMeetingLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _triggerMeetingLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _triggerMeetingLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _triggerMeetingLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.takenaka.model.TriggerMeeting fetchTriggerMeeting(
		long meetingSeqno) {

		return _triggerMeetingLocalService.fetchTriggerMeeting(meetingSeqno);
	}

	@Override
	public com.takenaka.model.TriggerMeeting findByMeetingId(String meetingId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _triggerMeetingLocalService.findByMeetingId(meetingId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _triggerMeetingLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _triggerMeetingLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _triggerMeetingLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _triggerMeetingLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the trigger meeting with the primary key.
	 *
	 * @param meetingSeqno the primary key of the trigger meeting
	 * @return the trigger meeting
	 * @throws PortalException if a trigger meeting with the primary key could not be found
	 */
	@Override
	public com.takenaka.model.TriggerMeeting getTriggerMeeting(
			long meetingSeqno)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _triggerMeetingLocalService.getTriggerMeeting(meetingSeqno);
	}

	@Override
	public java.util.List<com.takenaka.model.TriggerMeeting>
		getTriggerMeetingByFilter(
			String meetingType, String meetingId, String issuer,
			String meetingTitle, java.util.Date meetDateStr,
			java.util.Date meetDateEnd) {

		return _triggerMeetingLocalService.getTriggerMeetingByFilter(
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
	@Override
	public java.util.List<com.takenaka.model.TriggerMeeting> getTriggerMeetings(
		int start, int end) {

		return _triggerMeetingLocalService.getTriggerMeetings(start, end);
	}

	/**
	 * Returns the number of trigger meetings.
	 *
	 * @return the number of trigger meetings
	 */
	@Override
	public int getTriggerMeetingsCount() {
		return _triggerMeetingLocalService.getTriggerMeetingsCount();
	}

	/**
	 * Updates the trigger meeting in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param triggerMeeting the trigger meeting
	 * @return the trigger meeting that was updated
	 */
	@Override
	public com.takenaka.model.TriggerMeeting updateTriggerMeeting(
		com.takenaka.model.TriggerMeeting triggerMeeting) {

		return _triggerMeetingLocalService.updateTriggerMeeting(triggerMeeting);
	}

	@Override
	public TriggerMeetingLocalService getWrappedService() {
		return _triggerMeetingLocalService;
	}

	@Override
	public void setWrappedService(
		TriggerMeetingLocalService triggerMeetingLocalService) {

		_triggerMeetingLocalService = triggerMeetingLocalService;
	}

	private TriggerMeetingLocalService _triggerMeetingLocalService;

}