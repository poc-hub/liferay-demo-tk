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
 * Provides a wrapper for {@link TriggerMeetingDetailsLocalService}.
 *
 * @author Sanjay.Panchal
 * @see TriggerMeetingDetailsLocalService
 * @generated
 */
public class TriggerMeetingDetailsLocalServiceWrapper
	implements ServiceWrapper<TriggerMeetingDetailsLocalService>,
			   TriggerMeetingDetailsLocalService {

	public TriggerMeetingDetailsLocalServiceWrapper(
		TriggerMeetingDetailsLocalService triggerMeetingDetailsLocalService) {

		_triggerMeetingDetailsLocalService = triggerMeetingDetailsLocalService;
	}

	/**
	 * Adds the trigger meeting details to the database. Also notifies the appropriate model listeners.
	 *
	 * @param triggerMeetingDetails the trigger meeting details
	 * @return the trigger meeting details that was added
	 */
	@Override
	public com.takenaka.model.TriggerMeetingDetails addTriggerMeetingDetails(
		com.takenaka.model.TriggerMeetingDetails triggerMeetingDetails) {

		return _triggerMeetingDetailsLocalService.addTriggerMeetingDetails(
			triggerMeetingDetails);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _triggerMeetingDetailsLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new trigger meeting details with the primary key. Does not add the trigger meeting details to the database.
	 *
	 * @param meetingdetailSeqno the primary key for the new trigger meeting details
	 * @return the new trigger meeting details
	 */
	@Override
	public com.takenaka.model.TriggerMeetingDetails createTriggerMeetingDetails(
		long meetingdetailSeqno) {

		return _triggerMeetingDetailsLocalService.createTriggerMeetingDetails(
			meetingdetailSeqno);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _triggerMeetingDetailsLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the trigger meeting details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param meetingdetailSeqno the primary key of the trigger meeting details
	 * @return the trigger meeting details that was removed
	 * @throws PortalException if a trigger meeting details with the primary key could not be found
	 */
	@Override
	public com.takenaka.model.TriggerMeetingDetails deleteTriggerMeetingDetails(
			long meetingdetailSeqno)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _triggerMeetingDetailsLocalService.deleteTriggerMeetingDetails(
			meetingdetailSeqno);
	}

	/**
	 * Deletes the trigger meeting details from the database. Also notifies the appropriate model listeners.
	 *
	 * @param triggerMeetingDetails the trigger meeting details
	 * @return the trigger meeting details that was removed
	 */
	@Override
	public com.takenaka.model.TriggerMeetingDetails deleteTriggerMeetingDetails(
		com.takenaka.model.TriggerMeetingDetails triggerMeetingDetails) {

		return _triggerMeetingDetailsLocalService.deleteTriggerMeetingDetails(
			triggerMeetingDetails);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _triggerMeetingDetailsLocalService.dynamicQuery();
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

		return _triggerMeetingDetailsLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _triggerMeetingDetailsLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _triggerMeetingDetailsLocalService.dynamicQuery(
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

		return _triggerMeetingDetailsLocalService.dynamicQueryCount(
			dynamicQuery);
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

		return _triggerMeetingDetailsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.takenaka.model.TriggerMeetingDetails fetchTriggerMeetingDetails(
		long meetingdetailSeqno) {

		return _triggerMeetingDetailsLocalService.fetchTriggerMeetingDetails(
			meetingdetailSeqno);
	}

	@Override
	public com.takenaka.model.TriggerMeetingDetails findByMeetingSeqno(
			Long meetingSeqno)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _triggerMeetingDetailsLocalService.findByMeetingSeqno(
			meetingSeqno);
	}

	@Override
	public java.util.List<com.takenaka.model.TriggerMeetingDetails>
		findByMeetingSeqnoList(long meetingSeqno) {

		return _triggerMeetingDetailsLocalService.findByMeetingSeqnoList(
			meetingSeqno);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _triggerMeetingDetailsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _triggerMeetingDetailsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _triggerMeetingDetailsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _triggerMeetingDetailsLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the trigger meeting details with the primary key.
	 *
	 * @param meetingdetailSeqno the primary key of the trigger meeting details
	 * @return the trigger meeting details
	 * @throws PortalException if a trigger meeting details with the primary key could not be found
	 */
	@Override
	public com.takenaka.model.TriggerMeetingDetails getTriggerMeetingDetails(
			long meetingdetailSeqno)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _triggerMeetingDetailsLocalService.getTriggerMeetingDetails(
			meetingdetailSeqno);
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
	@Override
	public java.util.List<com.takenaka.model.TriggerMeetingDetails>
		getTriggerMeetingDetailses(int start, int end) {

		return _triggerMeetingDetailsLocalService.getTriggerMeetingDetailses(
			start, end);
	}

	/**
	 * Returns the number of trigger meeting detailses.
	 *
	 * @return the number of trigger meeting detailses
	 */
	@Override
	public int getTriggerMeetingDetailsesCount() {
		return _triggerMeetingDetailsLocalService.
			getTriggerMeetingDetailsesCount();
	}

	/**
	 * Updates the trigger meeting details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param triggerMeetingDetails the trigger meeting details
	 * @return the trigger meeting details that was updated
	 */
	@Override
	public com.takenaka.model.TriggerMeetingDetails updateTriggerMeetingDetails(
		com.takenaka.model.TriggerMeetingDetails triggerMeetingDetails) {

		return _triggerMeetingDetailsLocalService.updateTriggerMeetingDetails(
			triggerMeetingDetails);
	}

	@Override
	public TriggerMeetingDetailsLocalService getWrappedService() {
		return _triggerMeetingDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		TriggerMeetingDetailsLocalService triggerMeetingDetailsLocalService) {

		_triggerMeetingDetailsLocalService = triggerMeetingDetailsLocalService;
	}

	private TriggerMeetingDetailsLocalService
		_triggerMeetingDetailsLocalService;

}