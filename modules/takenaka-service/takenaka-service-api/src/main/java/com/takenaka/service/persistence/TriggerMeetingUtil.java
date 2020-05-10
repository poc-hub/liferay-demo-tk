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

import com.takenaka.model.TriggerMeeting;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the trigger meeting service. This utility wraps <code>com.takenaka.service.persistence.impl.TriggerMeetingPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sanjay.Panchal
 * @see TriggerMeetingPersistence
 * @generated
 */
public class TriggerMeetingUtil {

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
	public static void clearCache(TriggerMeeting triggerMeeting) {
		getPersistence().clearCache(triggerMeeting);
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
	public static Map<Serializable, TriggerMeeting> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TriggerMeeting> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TriggerMeeting> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TriggerMeeting> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TriggerMeeting> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TriggerMeeting update(TriggerMeeting triggerMeeting) {
		return getPersistence().update(triggerMeeting);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TriggerMeeting update(
		TriggerMeeting triggerMeeting, ServiceContext serviceContext) {

		return getPersistence().update(triggerMeeting, serviceContext);
	}

	/**
	 * Returns the trigger meeting where meetingId = &#63; or throws a <code>NoSuchTriggerMeetingException</code> if it could not be found.
	 *
	 * @param meetingId the meeting ID
	 * @return the matching trigger meeting
	 * @throws NoSuchTriggerMeetingException if a matching trigger meeting could not be found
	 */
	public static TriggerMeeting findByfindByMeetingId(String meetingId)
		throws com.takenaka.exception.NoSuchTriggerMeetingException {

		return getPersistence().findByfindByMeetingId(meetingId);
	}

	/**
	 * Returns the trigger meeting where meetingId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param meetingId the meeting ID
	 * @return the matching trigger meeting, or <code>null</code> if a matching trigger meeting could not be found
	 */
	public static TriggerMeeting fetchByfindByMeetingId(String meetingId) {
		return getPersistence().fetchByfindByMeetingId(meetingId);
	}

	/**
	 * Returns the trigger meeting where meetingId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param meetingId the meeting ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching trigger meeting, or <code>null</code> if a matching trigger meeting could not be found
	 */
	public static TriggerMeeting fetchByfindByMeetingId(
		String meetingId, boolean useFinderCache) {

		return getPersistence().fetchByfindByMeetingId(
			meetingId, useFinderCache);
	}

	/**
	 * Removes the trigger meeting where meetingId = &#63; from the database.
	 *
	 * @param meetingId the meeting ID
	 * @return the trigger meeting that was removed
	 */
	public static TriggerMeeting removeByfindByMeetingId(String meetingId)
		throws com.takenaka.exception.NoSuchTriggerMeetingException {

		return getPersistence().removeByfindByMeetingId(meetingId);
	}

	/**
	 * Returns the number of trigger meetings where meetingId = &#63;.
	 *
	 * @param meetingId the meeting ID
	 * @return the number of matching trigger meetings
	 */
	public static int countByfindByMeetingId(String meetingId) {
		return getPersistence().countByfindByMeetingId(meetingId);
	}

	/**
	 * Caches the trigger meeting in the entity cache if it is enabled.
	 *
	 * @param triggerMeeting the trigger meeting
	 */
	public static void cacheResult(TriggerMeeting triggerMeeting) {
		getPersistence().cacheResult(triggerMeeting);
	}

	/**
	 * Caches the trigger meetings in the entity cache if it is enabled.
	 *
	 * @param triggerMeetings the trigger meetings
	 */
	public static void cacheResult(List<TriggerMeeting> triggerMeetings) {
		getPersistence().cacheResult(triggerMeetings);
	}

	/**
	 * Creates a new trigger meeting with the primary key. Does not add the trigger meeting to the database.
	 *
	 * @param meetingSeqno the primary key for the new trigger meeting
	 * @return the new trigger meeting
	 */
	public static TriggerMeeting create(long meetingSeqno) {
		return getPersistence().create(meetingSeqno);
	}

	/**
	 * Removes the trigger meeting with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param meetingSeqno the primary key of the trigger meeting
	 * @return the trigger meeting that was removed
	 * @throws NoSuchTriggerMeetingException if a trigger meeting with the primary key could not be found
	 */
	public static TriggerMeeting remove(long meetingSeqno)
		throws com.takenaka.exception.NoSuchTriggerMeetingException {

		return getPersistence().remove(meetingSeqno);
	}

	public static TriggerMeeting updateImpl(TriggerMeeting triggerMeeting) {
		return getPersistence().updateImpl(triggerMeeting);
	}

	/**
	 * Returns the trigger meeting with the primary key or throws a <code>NoSuchTriggerMeetingException</code> if it could not be found.
	 *
	 * @param meetingSeqno the primary key of the trigger meeting
	 * @return the trigger meeting
	 * @throws NoSuchTriggerMeetingException if a trigger meeting with the primary key could not be found
	 */
	public static TriggerMeeting findByPrimaryKey(long meetingSeqno)
		throws com.takenaka.exception.NoSuchTriggerMeetingException {

		return getPersistence().findByPrimaryKey(meetingSeqno);
	}

	/**
	 * Returns the trigger meeting with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param meetingSeqno the primary key of the trigger meeting
	 * @return the trigger meeting, or <code>null</code> if a trigger meeting with the primary key could not be found
	 */
	public static TriggerMeeting fetchByPrimaryKey(long meetingSeqno) {
		return getPersistence().fetchByPrimaryKey(meetingSeqno);
	}

	/**
	 * Returns all the trigger meetings.
	 *
	 * @return the trigger meetings
	 */
	public static List<TriggerMeeting> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the trigger meetings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TriggerMeetingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trigger meetings
	 * @param end the upper bound of the range of trigger meetings (not inclusive)
	 * @return the range of trigger meetings
	 */
	public static List<TriggerMeeting> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the trigger meetings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TriggerMeetingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trigger meetings
	 * @param end the upper bound of the range of trigger meetings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of trigger meetings
	 */
	public static List<TriggerMeeting> findAll(
		int start, int end,
		OrderByComparator<TriggerMeeting> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the trigger meetings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TriggerMeetingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trigger meetings
	 * @param end the upper bound of the range of trigger meetings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of trigger meetings
	 */
	public static List<TriggerMeeting> findAll(
		int start, int end, OrderByComparator<TriggerMeeting> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the trigger meetings from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of trigger meetings.
	 *
	 * @return the number of trigger meetings
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TriggerMeetingPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<TriggerMeetingPersistence, TriggerMeetingPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			TriggerMeetingPersistence.class);

		ServiceTracker<TriggerMeetingPersistence, TriggerMeetingPersistence>
			serviceTracker =
				new ServiceTracker
					<TriggerMeetingPersistence, TriggerMeetingPersistence>(
						bundle.getBundleContext(),
						TriggerMeetingPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}