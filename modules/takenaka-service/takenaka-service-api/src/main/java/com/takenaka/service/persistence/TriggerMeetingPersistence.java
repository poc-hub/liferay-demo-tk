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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.takenaka.exception.NoSuchTriggerMeetingException;
import com.takenaka.model.TriggerMeeting;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the trigger meeting service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sanjay.Panchal
 * @see TriggerMeetingUtil
 * @generated
 */
@ProviderType
public interface TriggerMeetingPersistence
	extends BasePersistence<TriggerMeeting> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TriggerMeetingUtil} to access the trigger meeting persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the trigger meeting where meetingId = &#63; or throws a <code>NoSuchTriggerMeetingException</code> if it could not be found.
	 *
	 * @param meetingId the meeting ID
	 * @return the matching trigger meeting
	 * @throws NoSuchTriggerMeetingException if a matching trigger meeting could not be found
	 */
	public TriggerMeeting findByfindByMeetingId(String meetingId)
		throws NoSuchTriggerMeetingException;

	/**
	 * Returns the trigger meeting where meetingId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param meetingId the meeting ID
	 * @return the matching trigger meeting, or <code>null</code> if a matching trigger meeting could not be found
	 */
	public TriggerMeeting fetchByfindByMeetingId(String meetingId);

	/**
	 * Returns the trigger meeting where meetingId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param meetingId the meeting ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching trigger meeting, or <code>null</code> if a matching trigger meeting could not be found
	 */
	public TriggerMeeting fetchByfindByMeetingId(
		String meetingId, boolean useFinderCache);

	/**
	 * Removes the trigger meeting where meetingId = &#63; from the database.
	 *
	 * @param meetingId the meeting ID
	 * @return the trigger meeting that was removed
	 */
	public TriggerMeeting removeByfindByMeetingId(String meetingId)
		throws NoSuchTriggerMeetingException;

	/**
	 * Returns the number of trigger meetings where meetingId = &#63;.
	 *
	 * @param meetingId the meeting ID
	 * @return the number of matching trigger meetings
	 */
	public int countByfindByMeetingId(String meetingId);

	/**
	 * Caches the trigger meeting in the entity cache if it is enabled.
	 *
	 * @param triggerMeeting the trigger meeting
	 */
	public void cacheResult(TriggerMeeting triggerMeeting);

	/**
	 * Caches the trigger meetings in the entity cache if it is enabled.
	 *
	 * @param triggerMeetings the trigger meetings
	 */
	public void cacheResult(java.util.List<TriggerMeeting> triggerMeetings);

	/**
	 * Creates a new trigger meeting with the primary key. Does not add the trigger meeting to the database.
	 *
	 * @param meetingSeqno the primary key for the new trigger meeting
	 * @return the new trigger meeting
	 */
	public TriggerMeeting create(long meetingSeqno);

	/**
	 * Removes the trigger meeting with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param meetingSeqno the primary key of the trigger meeting
	 * @return the trigger meeting that was removed
	 * @throws NoSuchTriggerMeetingException if a trigger meeting with the primary key could not be found
	 */
	public TriggerMeeting remove(long meetingSeqno)
		throws NoSuchTriggerMeetingException;

	public TriggerMeeting updateImpl(TriggerMeeting triggerMeeting);

	/**
	 * Returns the trigger meeting with the primary key or throws a <code>NoSuchTriggerMeetingException</code> if it could not be found.
	 *
	 * @param meetingSeqno the primary key of the trigger meeting
	 * @return the trigger meeting
	 * @throws NoSuchTriggerMeetingException if a trigger meeting with the primary key could not be found
	 */
	public TriggerMeeting findByPrimaryKey(long meetingSeqno)
		throws NoSuchTriggerMeetingException;

	/**
	 * Returns the trigger meeting with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param meetingSeqno the primary key of the trigger meeting
	 * @return the trigger meeting, or <code>null</code> if a trigger meeting with the primary key could not be found
	 */
	public TriggerMeeting fetchByPrimaryKey(long meetingSeqno);

	/**
	 * Returns all the trigger meetings.
	 *
	 * @return the trigger meetings
	 */
	public java.util.List<TriggerMeeting> findAll();

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
	public java.util.List<TriggerMeeting> findAll(int start, int end);

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
	public java.util.List<TriggerMeeting> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TriggerMeeting>
			orderByComparator);

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
	public java.util.List<TriggerMeeting> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TriggerMeeting>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the trigger meetings from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of trigger meetings.
	 *
	 * @return the number of trigger meetings
	 */
	public int countAll();

}