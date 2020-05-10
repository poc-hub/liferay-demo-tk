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

import com.takenaka.exception.NoSuchTriggerMeetingDetailsException;
import com.takenaka.model.TriggerMeetingDetails;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the trigger meeting details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sanjay.Panchal
 * @see TriggerMeetingDetailsUtil
 * @generated
 */
@ProviderType
public interface TriggerMeetingDetailsPersistence
	extends BasePersistence<TriggerMeetingDetails> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TriggerMeetingDetailsUtil} to access the trigger meeting details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the trigger meeting details where meetingSeqno = &#63; or throws a <code>NoSuchTriggerMeetingDetailsException</code> if it could not be found.
	 *
	 * @param meetingSeqno the meeting seqno
	 * @return the matching trigger meeting details
	 * @throws NoSuchTriggerMeetingDetailsException if a matching trigger meeting details could not be found
	 */
	public TriggerMeetingDetails findByfindByMeetingSeqno(long meetingSeqno)
		throws NoSuchTriggerMeetingDetailsException;

	/**
	 * Returns the trigger meeting details where meetingSeqno = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param meetingSeqno the meeting seqno
	 * @return the matching trigger meeting details, or <code>null</code> if a matching trigger meeting details could not be found
	 */
	public TriggerMeetingDetails fetchByfindByMeetingSeqno(long meetingSeqno);

	/**
	 * Returns the trigger meeting details where meetingSeqno = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param meetingSeqno the meeting seqno
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching trigger meeting details, or <code>null</code> if a matching trigger meeting details could not be found
	 */
	public TriggerMeetingDetails fetchByfindByMeetingSeqno(
		long meetingSeqno, boolean useFinderCache);

	/**
	 * Removes the trigger meeting details where meetingSeqno = &#63; from the database.
	 *
	 * @param meetingSeqno the meeting seqno
	 * @return the trigger meeting details that was removed
	 */
	public TriggerMeetingDetails removeByfindByMeetingSeqno(long meetingSeqno)
		throws NoSuchTriggerMeetingDetailsException;

	/**
	 * Returns the number of trigger meeting detailses where meetingSeqno = &#63;.
	 *
	 * @param meetingSeqno the meeting seqno
	 * @return the number of matching trigger meeting detailses
	 */
	public int countByfindByMeetingSeqno(long meetingSeqno);

	/**
	 * Returns all the trigger meeting detailses where meetingSeqno = &#63;.
	 *
	 * @param meetingSeqno the meeting seqno
	 * @return the matching trigger meeting detailses
	 */
	public java.util.List<TriggerMeetingDetails> findByfindByMeetingSeqnoList(
		long meetingSeqno);

	/**
	 * Returns a range of all the trigger meeting detailses where meetingSeqno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TriggerMeetingDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param meetingSeqno the meeting seqno
	 * @param start the lower bound of the range of trigger meeting detailses
	 * @param end the upper bound of the range of trigger meeting detailses (not inclusive)
	 * @return the range of matching trigger meeting detailses
	 */
	public java.util.List<TriggerMeetingDetails> findByfindByMeetingSeqnoList(
		long meetingSeqno, int start, int end);

	/**
	 * Returns an ordered range of all the trigger meeting detailses where meetingSeqno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TriggerMeetingDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param meetingSeqno the meeting seqno
	 * @param start the lower bound of the range of trigger meeting detailses
	 * @param end the upper bound of the range of trigger meeting detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trigger meeting detailses
	 */
	public java.util.List<TriggerMeetingDetails> findByfindByMeetingSeqnoList(
		long meetingSeqno, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TriggerMeetingDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the trigger meeting detailses where meetingSeqno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TriggerMeetingDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param meetingSeqno the meeting seqno
	 * @param start the lower bound of the range of trigger meeting detailses
	 * @param end the upper bound of the range of trigger meeting detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trigger meeting detailses
	 */
	public java.util.List<TriggerMeetingDetails> findByfindByMeetingSeqnoList(
		long meetingSeqno, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TriggerMeetingDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first trigger meeting details in the ordered set where meetingSeqno = &#63;.
	 *
	 * @param meetingSeqno the meeting seqno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trigger meeting details
	 * @throws NoSuchTriggerMeetingDetailsException if a matching trigger meeting details could not be found
	 */
	public TriggerMeetingDetails findByfindByMeetingSeqnoList_First(
			long meetingSeqno,
			com.liferay.portal.kernel.util.OrderByComparator
				<TriggerMeetingDetails> orderByComparator)
		throws NoSuchTriggerMeetingDetailsException;

	/**
	 * Returns the first trigger meeting details in the ordered set where meetingSeqno = &#63;.
	 *
	 * @param meetingSeqno the meeting seqno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trigger meeting details, or <code>null</code> if a matching trigger meeting details could not be found
	 */
	public TriggerMeetingDetails fetchByfindByMeetingSeqnoList_First(
		long meetingSeqno,
		com.liferay.portal.kernel.util.OrderByComparator<TriggerMeetingDetails>
			orderByComparator);

	/**
	 * Returns the last trigger meeting details in the ordered set where meetingSeqno = &#63;.
	 *
	 * @param meetingSeqno the meeting seqno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trigger meeting details
	 * @throws NoSuchTriggerMeetingDetailsException if a matching trigger meeting details could not be found
	 */
	public TriggerMeetingDetails findByfindByMeetingSeqnoList_Last(
			long meetingSeqno,
			com.liferay.portal.kernel.util.OrderByComparator
				<TriggerMeetingDetails> orderByComparator)
		throws NoSuchTriggerMeetingDetailsException;

	/**
	 * Returns the last trigger meeting details in the ordered set where meetingSeqno = &#63;.
	 *
	 * @param meetingSeqno the meeting seqno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trigger meeting details, or <code>null</code> if a matching trigger meeting details could not be found
	 */
	public TriggerMeetingDetails fetchByfindByMeetingSeqnoList_Last(
		long meetingSeqno,
		com.liferay.portal.kernel.util.OrderByComparator<TriggerMeetingDetails>
			orderByComparator);

	/**
	 * Returns the trigger meeting detailses before and after the current trigger meeting details in the ordered set where meetingSeqno = &#63;.
	 *
	 * @param meetingdetailSeqno the primary key of the current trigger meeting details
	 * @param meetingSeqno the meeting seqno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trigger meeting details
	 * @throws NoSuchTriggerMeetingDetailsException if a trigger meeting details with the primary key could not be found
	 */
	public TriggerMeetingDetails[] findByfindByMeetingSeqnoList_PrevAndNext(
			long meetingdetailSeqno, long meetingSeqno,
			com.liferay.portal.kernel.util.OrderByComparator
				<TriggerMeetingDetails> orderByComparator)
		throws NoSuchTriggerMeetingDetailsException;

	/**
	 * Removes all the trigger meeting detailses where meetingSeqno = &#63; from the database.
	 *
	 * @param meetingSeqno the meeting seqno
	 */
	public void removeByfindByMeetingSeqnoList(long meetingSeqno);

	/**
	 * Returns the number of trigger meeting detailses where meetingSeqno = &#63;.
	 *
	 * @param meetingSeqno the meeting seqno
	 * @return the number of matching trigger meeting detailses
	 */
	public int countByfindByMeetingSeqnoList(long meetingSeqno);

	/**
	 * Caches the trigger meeting details in the entity cache if it is enabled.
	 *
	 * @param triggerMeetingDetails the trigger meeting details
	 */
	public void cacheResult(TriggerMeetingDetails triggerMeetingDetails);

	/**
	 * Caches the trigger meeting detailses in the entity cache if it is enabled.
	 *
	 * @param triggerMeetingDetailses the trigger meeting detailses
	 */
	public void cacheResult(
		java.util.List<TriggerMeetingDetails> triggerMeetingDetailses);

	/**
	 * Creates a new trigger meeting details with the primary key. Does not add the trigger meeting details to the database.
	 *
	 * @param meetingdetailSeqno the primary key for the new trigger meeting details
	 * @return the new trigger meeting details
	 */
	public TriggerMeetingDetails create(long meetingdetailSeqno);

	/**
	 * Removes the trigger meeting details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param meetingdetailSeqno the primary key of the trigger meeting details
	 * @return the trigger meeting details that was removed
	 * @throws NoSuchTriggerMeetingDetailsException if a trigger meeting details with the primary key could not be found
	 */
	public TriggerMeetingDetails remove(long meetingdetailSeqno)
		throws NoSuchTriggerMeetingDetailsException;

	public TriggerMeetingDetails updateImpl(
		TriggerMeetingDetails triggerMeetingDetails);

	/**
	 * Returns the trigger meeting details with the primary key or throws a <code>NoSuchTriggerMeetingDetailsException</code> if it could not be found.
	 *
	 * @param meetingdetailSeqno the primary key of the trigger meeting details
	 * @return the trigger meeting details
	 * @throws NoSuchTriggerMeetingDetailsException if a trigger meeting details with the primary key could not be found
	 */
	public TriggerMeetingDetails findByPrimaryKey(long meetingdetailSeqno)
		throws NoSuchTriggerMeetingDetailsException;

	/**
	 * Returns the trigger meeting details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param meetingdetailSeqno the primary key of the trigger meeting details
	 * @return the trigger meeting details, or <code>null</code> if a trigger meeting details with the primary key could not be found
	 */
	public TriggerMeetingDetails fetchByPrimaryKey(long meetingdetailSeqno);

	/**
	 * Returns all the trigger meeting detailses.
	 *
	 * @return the trigger meeting detailses
	 */
	public java.util.List<TriggerMeetingDetails> findAll();

	/**
	 * Returns a range of all the trigger meeting detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TriggerMeetingDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trigger meeting detailses
	 * @param end the upper bound of the range of trigger meeting detailses (not inclusive)
	 * @return the range of trigger meeting detailses
	 */
	public java.util.List<TriggerMeetingDetails> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the trigger meeting detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TriggerMeetingDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trigger meeting detailses
	 * @param end the upper bound of the range of trigger meeting detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of trigger meeting detailses
	 */
	public java.util.List<TriggerMeetingDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TriggerMeetingDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the trigger meeting detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TriggerMeetingDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trigger meeting detailses
	 * @param end the upper bound of the range of trigger meeting detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of trigger meeting detailses
	 */
	public java.util.List<TriggerMeetingDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TriggerMeetingDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the trigger meeting detailses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of trigger meeting detailses.
	 *
	 * @return the number of trigger meeting detailses
	 */
	public int countAll();

}