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

package com.takenaka.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;

import com.takenaka.exception.NoSuchTriggerMeetingDetailsException;
import com.takenaka.model.TriggerMeetingDetails;
import com.takenaka.model.impl.TriggerMeetingDetailsImpl;
import com.takenaka.model.impl.TriggerMeetingDetailsModelImpl;
import com.takenaka.service.persistence.TriggerMeetingDetailsPersistence;
import com.takenaka.service.persistence.impl.constants.takenakaPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the trigger meeting details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sanjay.Panchal
 * @generated
 */
@Component(service = TriggerMeetingDetailsPersistence.class)
public class TriggerMeetingDetailsPersistenceImpl
	extends BasePersistenceImpl<TriggerMeetingDetails>
	implements TriggerMeetingDetailsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TriggerMeetingDetailsUtil</code> to access the trigger meeting details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TriggerMeetingDetailsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByfindByMeetingSeqno;
	private FinderPath _finderPathCountByfindByMeetingSeqno;

	/**
	 * Returns the trigger meeting details where meetingSeqno = &#63; or throws a <code>NoSuchTriggerMeetingDetailsException</code> if it could not be found.
	 *
	 * @param meetingSeqno the meeting seqno
	 * @return the matching trigger meeting details
	 * @throws NoSuchTriggerMeetingDetailsException if a matching trigger meeting details could not be found
	 */
	@Override
	public TriggerMeetingDetails findByfindByMeetingSeqno(long meetingSeqno)
		throws NoSuchTriggerMeetingDetailsException {

		TriggerMeetingDetails triggerMeetingDetails = fetchByfindByMeetingSeqno(
			meetingSeqno);

		if (triggerMeetingDetails == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("meetingSeqno=");
			msg.append(meetingSeqno);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchTriggerMeetingDetailsException(msg.toString());
		}

		return triggerMeetingDetails;
	}

	/**
	 * Returns the trigger meeting details where meetingSeqno = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param meetingSeqno the meeting seqno
	 * @return the matching trigger meeting details, or <code>null</code> if a matching trigger meeting details could not be found
	 */
	@Override
	public TriggerMeetingDetails fetchByfindByMeetingSeqno(long meetingSeqno) {
		return fetchByfindByMeetingSeqno(meetingSeqno, true);
	}

	/**
	 * Returns the trigger meeting details where meetingSeqno = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param meetingSeqno the meeting seqno
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching trigger meeting details, or <code>null</code> if a matching trigger meeting details could not be found
	 */
	@Override
	public TriggerMeetingDetails fetchByfindByMeetingSeqno(
		long meetingSeqno, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {meetingSeqno};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByfindByMeetingSeqno, finderArgs, this);
		}

		if (result instanceof TriggerMeetingDetails) {
			TriggerMeetingDetails triggerMeetingDetails =
				(TriggerMeetingDetails)result;

			if (meetingSeqno != triggerMeetingDetails.getMeetingSeqno()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_TRIGGERMEETINGDETAILS_WHERE);

			query.append(_FINDER_COLUMN_FINDBYMEETINGSEQNO_MEETINGSEQNO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(meetingSeqno);

				List<TriggerMeetingDetails> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByfindByMeetingSeqno, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {meetingSeqno};
							}

							_log.warn(
								"TriggerMeetingDetailsPersistenceImpl.fetchByfindByMeetingSeqno(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					TriggerMeetingDetails triggerMeetingDetails = list.get(0);

					result = triggerMeetingDetails;

					cacheResult(triggerMeetingDetails);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByfindByMeetingSeqno, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (TriggerMeetingDetails)result;
		}
	}

	/**
	 * Removes the trigger meeting details where meetingSeqno = &#63; from the database.
	 *
	 * @param meetingSeqno the meeting seqno
	 * @return the trigger meeting details that was removed
	 */
	@Override
	public TriggerMeetingDetails removeByfindByMeetingSeqno(long meetingSeqno)
		throws NoSuchTriggerMeetingDetailsException {

		TriggerMeetingDetails triggerMeetingDetails = findByfindByMeetingSeqno(
			meetingSeqno);

		return remove(triggerMeetingDetails);
	}

	/**
	 * Returns the number of trigger meeting detailses where meetingSeqno = &#63;.
	 *
	 * @param meetingSeqno the meeting seqno
	 * @return the number of matching trigger meeting detailses
	 */
	@Override
	public int countByfindByMeetingSeqno(long meetingSeqno) {
		FinderPath finderPath = _finderPathCountByfindByMeetingSeqno;

		Object[] finderArgs = new Object[] {meetingSeqno};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TRIGGERMEETINGDETAILS_WHERE);

			query.append(_FINDER_COLUMN_FINDBYMEETINGSEQNO_MEETINGSEQNO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(meetingSeqno);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_FINDBYMEETINGSEQNO_MEETINGSEQNO_2 =
			"triggerMeetingDetails.meetingSeqno = ?";

	private FinderPath _finderPathWithPaginationFindByfindByMeetingSeqnoList;
	private FinderPath _finderPathWithoutPaginationFindByfindByMeetingSeqnoList;
	private FinderPath _finderPathCountByfindByMeetingSeqnoList;

	/**
	 * Returns all the trigger meeting detailses where meetingSeqno = &#63;.
	 *
	 * @param meetingSeqno the meeting seqno
	 * @return the matching trigger meeting detailses
	 */
	@Override
	public List<TriggerMeetingDetails> findByfindByMeetingSeqnoList(
		long meetingSeqno) {

		return findByfindByMeetingSeqnoList(
			meetingSeqno, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<TriggerMeetingDetails> findByfindByMeetingSeqnoList(
		long meetingSeqno, int start, int end) {

		return findByfindByMeetingSeqnoList(meetingSeqno, start, end, null);
	}

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
	@Override
	public List<TriggerMeetingDetails> findByfindByMeetingSeqnoList(
		long meetingSeqno, int start, int end,
		OrderByComparator<TriggerMeetingDetails> orderByComparator) {

		return findByfindByMeetingSeqnoList(
			meetingSeqno, start, end, orderByComparator, true);
	}

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
	@Override
	public List<TriggerMeetingDetails> findByfindByMeetingSeqnoList(
		long meetingSeqno, int start, int end,
		OrderByComparator<TriggerMeetingDetails> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByfindByMeetingSeqnoList;
				finderArgs = new Object[] {meetingSeqno};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByfindByMeetingSeqnoList;
			finderArgs = new Object[] {
				meetingSeqno, start, end, orderByComparator
			};
		}

		List<TriggerMeetingDetails> list = null;

		if (useFinderCache) {
			list = (List<TriggerMeetingDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TriggerMeetingDetails triggerMeetingDetails : list) {
					if (meetingSeqno !=
							triggerMeetingDetails.getMeetingSeqno()) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TRIGGERMEETINGDETAILS_WHERE);

			query.append(_FINDER_COLUMN_FINDBYMEETINGSEQNOLIST_MEETINGSEQNO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(TriggerMeetingDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(meetingSeqno);

				list = (List<TriggerMeetingDetails>)QueryUtil.list(
					q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first trigger meeting details in the ordered set where meetingSeqno = &#63;.
	 *
	 * @param meetingSeqno the meeting seqno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trigger meeting details
	 * @throws NoSuchTriggerMeetingDetailsException if a matching trigger meeting details could not be found
	 */
	@Override
	public TriggerMeetingDetails findByfindByMeetingSeqnoList_First(
			long meetingSeqno,
			OrderByComparator<TriggerMeetingDetails> orderByComparator)
		throws NoSuchTriggerMeetingDetailsException {

		TriggerMeetingDetails triggerMeetingDetails =
			fetchByfindByMeetingSeqnoList_First(
				meetingSeqno, orderByComparator);

		if (triggerMeetingDetails != null) {
			return triggerMeetingDetails;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("meetingSeqno=");
		msg.append(meetingSeqno);

		msg.append("}");

		throw new NoSuchTriggerMeetingDetailsException(msg.toString());
	}

	/**
	 * Returns the first trigger meeting details in the ordered set where meetingSeqno = &#63;.
	 *
	 * @param meetingSeqno the meeting seqno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trigger meeting details, or <code>null</code> if a matching trigger meeting details could not be found
	 */
	@Override
	public TriggerMeetingDetails fetchByfindByMeetingSeqnoList_First(
		long meetingSeqno,
		OrderByComparator<TriggerMeetingDetails> orderByComparator) {

		List<TriggerMeetingDetails> list = findByfindByMeetingSeqnoList(
			meetingSeqno, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last trigger meeting details in the ordered set where meetingSeqno = &#63;.
	 *
	 * @param meetingSeqno the meeting seqno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trigger meeting details
	 * @throws NoSuchTriggerMeetingDetailsException if a matching trigger meeting details could not be found
	 */
	@Override
	public TriggerMeetingDetails findByfindByMeetingSeqnoList_Last(
			long meetingSeqno,
			OrderByComparator<TriggerMeetingDetails> orderByComparator)
		throws NoSuchTriggerMeetingDetailsException {

		TriggerMeetingDetails triggerMeetingDetails =
			fetchByfindByMeetingSeqnoList_Last(meetingSeqno, orderByComparator);

		if (triggerMeetingDetails != null) {
			return triggerMeetingDetails;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("meetingSeqno=");
		msg.append(meetingSeqno);

		msg.append("}");

		throw new NoSuchTriggerMeetingDetailsException(msg.toString());
	}

	/**
	 * Returns the last trigger meeting details in the ordered set where meetingSeqno = &#63;.
	 *
	 * @param meetingSeqno the meeting seqno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trigger meeting details, or <code>null</code> if a matching trigger meeting details could not be found
	 */
	@Override
	public TriggerMeetingDetails fetchByfindByMeetingSeqnoList_Last(
		long meetingSeqno,
		OrderByComparator<TriggerMeetingDetails> orderByComparator) {

		int count = countByfindByMeetingSeqnoList(meetingSeqno);

		if (count == 0) {
			return null;
		}

		List<TriggerMeetingDetails> list = findByfindByMeetingSeqnoList(
			meetingSeqno, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the trigger meeting detailses before and after the current trigger meeting details in the ordered set where meetingSeqno = &#63;.
	 *
	 * @param meetingdetailSeqno the primary key of the current trigger meeting details
	 * @param meetingSeqno the meeting seqno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trigger meeting details
	 * @throws NoSuchTriggerMeetingDetailsException if a trigger meeting details with the primary key could not be found
	 */
	@Override
	public TriggerMeetingDetails[] findByfindByMeetingSeqnoList_PrevAndNext(
			long meetingdetailSeqno, long meetingSeqno,
			OrderByComparator<TriggerMeetingDetails> orderByComparator)
		throws NoSuchTriggerMeetingDetailsException {

		TriggerMeetingDetails triggerMeetingDetails = findByPrimaryKey(
			meetingdetailSeqno);

		Session session = null;

		try {
			session = openSession();

			TriggerMeetingDetails[] array = new TriggerMeetingDetailsImpl[3];

			array[0] = getByfindByMeetingSeqnoList_PrevAndNext(
				session, triggerMeetingDetails, meetingSeqno, orderByComparator,
				true);

			array[1] = triggerMeetingDetails;

			array[2] = getByfindByMeetingSeqnoList_PrevAndNext(
				session, triggerMeetingDetails, meetingSeqno, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TriggerMeetingDetails getByfindByMeetingSeqnoList_PrevAndNext(
		Session session, TriggerMeetingDetails triggerMeetingDetails,
		long meetingSeqno,
		OrderByComparator<TriggerMeetingDetails> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TRIGGERMEETINGDETAILS_WHERE);

		query.append(_FINDER_COLUMN_FINDBYMEETINGSEQNOLIST_MEETINGSEQNO_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TriggerMeetingDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(meetingSeqno);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						triggerMeetingDetails)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<TriggerMeetingDetails> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the trigger meeting detailses where meetingSeqno = &#63; from the database.
	 *
	 * @param meetingSeqno the meeting seqno
	 */
	@Override
	public void removeByfindByMeetingSeqnoList(long meetingSeqno) {
		for (TriggerMeetingDetails triggerMeetingDetails :
				findByfindByMeetingSeqnoList(
					meetingSeqno, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(triggerMeetingDetails);
		}
	}

	/**
	 * Returns the number of trigger meeting detailses where meetingSeqno = &#63;.
	 *
	 * @param meetingSeqno the meeting seqno
	 * @return the number of matching trigger meeting detailses
	 */
	@Override
	public int countByfindByMeetingSeqnoList(long meetingSeqno) {
		FinderPath finderPath = _finderPathCountByfindByMeetingSeqnoList;

		Object[] finderArgs = new Object[] {meetingSeqno};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TRIGGERMEETINGDETAILS_WHERE);

			query.append(_FINDER_COLUMN_FINDBYMEETINGSEQNOLIST_MEETINGSEQNO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(meetingSeqno);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_FINDBYMEETINGSEQNOLIST_MEETINGSEQNO_2 =
			"triggerMeetingDetails.meetingSeqno = ?";

	public TriggerMeetingDetailsPersistenceImpl() {
		setModelClass(TriggerMeetingDetails.class);

		setModelImplClass(TriggerMeetingDetailsImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("meetingdetailSeqno", "MEETINGDETAIL_SEQNO");
		dbColumnNames.put("meetingSeqno", "MEETING_SEQNO");
		dbColumnNames.put("category", "CATEGORY");
		dbColumnNames.put("floor", "FLOOR");
		dbColumnNames.put("item", "ITEM");
		dbColumnNames.put("actions", "ACTIONS");
		dbColumnNames.put("personInCharge", "PERSON_IN_CHARGE");
		dbColumnNames.put("createdBy", "CREATED_BY");
		dbColumnNames.put("createdOn", "CREATED_ON");
		dbColumnNames.put("modifiedBy", "MODIFIED_BY");
		dbColumnNames.put("modifiedOn", "MODIFIED_ON");
		dbColumnNames.put("isActive", "IS_ACTIVE");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the trigger meeting details in the entity cache if it is enabled.
	 *
	 * @param triggerMeetingDetails the trigger meeting details
	 */
	@Override
	public void cacheResult(TriggerMeetingDetails triggerMeetingDetails) {
		entityCache.putResult(
			entityCacheEnabled, TriggerMeetingDetailsImpl.class,
			triggerMeetingDetails.getPrimaryKey(), triggerMeetingDetails);

		finderCache.putResult(
			_finderPathFetchByfindByMeetingSeqno,
			new Object[] {triggerMeetingDetails.getMeetingSeqno()},
			triggerMeetingDetails);

		triggerMeetingDetails.resetOriginalValues();
	}

	/**
	 * Caches the trigger meeting detailses in the entity cache if it is enabled.
	 *
	 * @param triggerMeetingDetailses the trigger meeting detailses
	 */
	@Override
	public void cacheResult(
		List<TriggerMeetingDetails> triggerMeetingDetailses) {

		for (TriggerMeetingDetails triggerMeetingDetails :
				triggerMeetingDetailses) {

			if (entityCache.getResult(
					entityCacheEnabled, TriggerMeetingDetailsImpl.class,
					triggerMeetingDetails.getPrimaryKey()) == null) {

				cacheResult(triggerMeetingDetails);
			}
			else {
				triggerMeetingDetails.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all trigger meeting detailses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TriggerMeetingDetailsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the trigger meeting details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TriggerMeetingDetails triggerMeetingDetails) {
		entityCache.removeResult(
			entityCacheEnabled, TriggerMeetingDetailsImpl.class,
			triggerMeetingDetails.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(TriggerMeetingDetailsModelImpl)triggerMeetingDetails, true);
	}

	@Override
	public void clearCache(
		List<TriggerMeetingDetails> triggerMeetingDetailses) {

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TriggerMeetingDetails triggerMeetingDetails :
				triggerMeetingDetailses) {

			entityCache.removeResult(
				entityCacheEnabled, TriggerMeetingDetailsImpl.class,
				triggerMeetingDetails.getPrimaryKey());

			clearUniqueFindersCache(
				(TriggerMeetingDetailsModelImpl)triggerMeetingDetails, true);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, TriggerMeetingDetailsImpl.class,
				primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		TriggerMeetingDetailsModelImpl triggerMeetingDetailsModelImpl) {

		Object[] args = new Object[] {
			triggerMeetingDetailsModelImpl.getMeetingSeqno()
		};

		finderCache.putResult(
			_finderPathCountByfindByMeetingSeqno, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByfindByMeetingSeqno, args,
			triggerMeetingDetailsModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		TriggerMeetingDetailsModelImpl triggerMeetingDetailsModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				triggerMeetingDetailsModelImpl.getMeetingSeqno()
			};

			finderCache.removeResult(
				_finderPathCountByfindByMeetingSeqno, args);
			finderCache.removeResult(
				_finderPathFetchByfindByMeetingSeqno, args);
		}

		if ((triggerMeetingDetailsModelImpl.getColumnBitmask() &
			 _finderPathFetchByfindByMeetingSeqno.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				triggerMeetingDetailsModelImpl.getOriginalMeetingSeqno()
			};

			finderCache.removeResult(
				_finderPathCountByfindByMeetingSeqno, args);
			finderCache.removeResult(
				_finderPathFetchByfindByMeetingSeqno, args);
		}
	}

	/**
	 * Creates a new trigger meeting details with the primary key. Does not add the trigger meeting details to the database.
	 *
	 * @param meetingdetailSeqno the primary key for the new trigger meeting details
	 * @return the new trigger meeting details
	 */
	@Override
	public TriggerMeetingDetails create(long meetingdetailSeqno) {
		TriggerMeetingDetails triggerMeetingDetails =
			new TriggerMeetingDetailsImpl();

		triggerMeetingDetails.setNew(true);
		triggerMeetingDetails.setPrimaryKey(meetingdetailSeqno);

		return triggerMeetingDetails;
	}

	/**
	 * Removes the trigger meeting details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param meetingdetailSeqno the primary key of the trigger meeting details
	 * @return the trigger meeting details that was removed
	 * @throws NoSuchTriggerMeetingDetailsException if a trigger meeting details with the primary key could not be found
	 */
	@Override
	public TriggerMeetingDetails remove(long meetingdetailSeqno)
		throws NoSuchTriggerMeetingDetailsException {

		return remove((Serializable)meetingdetailSeqno);
	}

	/**
	 * Removes the trigger meeting details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the trigger meeting details
	 * @return the trigger meeting details that was removed
	 * @throws NoSuchTriggerMeetingDetailsException if a trigger meeting details with the primary key could not be found
	 */
	@Override
	public TriggerMeetingDetails remove(Serializable primaryKey)
		throws NoSuchTriggerMeetingDetailsException {

		Session session = null;

		try {
			session = openSession();

			TriggerMeetingDetails triggerMeetingDetails =
				(TriggerMeetingDetails)session.get(
					TriggerMeetingDetailsImpl.class, primaryKey);

			if (triggerMeetingDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTriggerMeetingDetailsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(triggerMeetingDetails);
		}
		catch (NoSuchTriggerMeetingDetailsException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected TriggerMeetingDetails removeImpl(
		TriggerMeetingDetails triggerMeetingDetails) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(triggerMeetingDetails)) {
				triggerMeetingDetails = (TriggerMeetingDetails)session.get(
					TriggerMeetingDetailsImpl.class,
					triggerMeetingDetails.getPrimaryKeyObj());
			}

			if (triggerMeetingDetails != null) {
				session.delete(triggerMeetingDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (triggerMeetingDetails != null) {
			clearCache(triggerMeetingDetails);
		}

		return triggerMeetingDetails;
	}

	@Override
	public TriggerMeetingDetails updateImpl(
		TriggerMeetingDetails triggerMeetingDetails) {

		boolean isNew = triggerMeetingDetails.isNew();

		if (!(triggerMeetingDetails instanceof
				TriggerMeetingDetailsModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(triggerMeetingDetails.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					triggerMeetingDetails);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in triggerMeetingDetails proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TriggerMeetingDetails implementation " +
					triggerMeetingDetails.getClass());
		}

		TriggerMeetingDetailsModelImpl triggerMeetingDetailsModelImpl =
			(TriggerMeetingDetailsModelImpl)triggerMeetingDetails;

		Session session = null;

		try {
			session = openSession();

			if (triggerMeetingDetails.isNew()) {
				session.save(triggerMeetingDetails);

				triggerMeetingDetails.setNew(false);
			}
			else {
				triggerMeetingDetails = (TriggerMeetingDetails)session.merge(
					triggerMeetingDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				triggerMeetingDetailsModelImpl.getMeetingSeqno()
			};

			finderCache.removeResult(
				_finderPathCountByfindByMeetingSeqnoList, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByfindByMeetingSeqnoList, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((triggerMeetingDetailsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByfindByMeetingSeqnoList.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					triggerMeetingDetailsModelImpl.getOriginalMeetingSeqno()
				};

				finderCache.removeResult(
					_finderPathCountByfindByMeetingSeqnoList, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByfindByMeetingSeqnoList,
					args);

				args = new Object[] {
					triggerMeetingDetailsModelImpl.getMeetingSeqno()
				};

				finderCache.removeResult(
					_finderPathCountByfindByMeetingSeqnoList, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByfindByMeetingSeqnoList,
					args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, TriggerMeetingDetailsImpl.class,
			triggerMeetingDetails.getPrimaryKey(), triggerMeetingDetails,
			false);

		clearUniqueFindersCache(triggerMeetingDetailsModelImpl, false);
		cacheUniqueFindersCache(triggerMeetingDetailsModelImpl);

		triggerMeetingDetails.resetOriginalValues();

		return triggerMeetingDetails;
	}

	/**
	 * Returns the trigger meeting details with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the trigger meeting details
	 * @return the trigger meeting details
	 * @throws NoSuchTriggerMeetingDetailsException if a trigger meeting details with the primary key could not be found
	 */
	@Override
	public TriggerMeetingDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTriggerMeetingDetailsException {

		TriggerMeetingDetails triggerMeetingDetails = fetchByPrimaryKey(
			primaryKey);

		if (triggerMeetingDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTriggerMeetingDetailsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return triggerMeetingDetails;
	}

	/**
	 * Returns the trigger meeting details with the primary key or throws a <code>NoSuchTriggerMeetingDetailsException</code> if it could not be found.
	 *
	 * @param meetingdetailSeqno the primary key of the trigger meeting details
	 * @return the trigger meeting details
	 * @throws NoSuchTriggerMeetingDetailsException if a trigger meeting details with the primary key could not be found
	 */
	@Override
	public TriggerMeetingDetails findByPrimaryKey(long meetingdetailSeqno)
		throws NoSuchTriggerMeetingDetailsException {

		return findByPrimaryKey((Serializable)meetingdetailSeqno);
	}

	/**
	 * Returns the trigger meeting details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param meetingdetailSeqno the primary key of the trigger meeting details
	 * @return the trigger meeting details, or <code>null</code> if a trigger meeting details with the primary key could not be found
	 */
	@Override
	public TriggerMeetingDetails fetchByPrimaryKey(long meetingdetailSeqno) {
		return fetchByPrimaryKey((Serializable)meetingdetailSeqno);
	}

	/**
	 * Returns all the trigger meeting detailses.
	 *
	 * @return the trigger meeting detailses
	 */
	@Override
	public List<TriggerMeetingDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<TriggerMeetingDetails> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<TriggerMeetingDetails> findAll(
		int start, int end,
		OrderByComparator<TriggerMeetingDetails> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<TriggerMeetingDetails> findAll(
		int start, int end,
		OrderByComparator<TriggerMeetingDetails> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<TriggerMeetingDetails> list = null;

		if (useFinderCache) {
			list = (List<TriggerMeetingDetails>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TRIGGERMEETINGDETAILS);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TRIGGERMEETINGDETAILS;

				sql = sql.concat(TriggerMeetingDetailsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<TriggerMeetingDetails>)QueryUtil.list(
					q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the trigger meeting detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TriggerMeetingDetails triggerMeetingDetails : findAll()) {
			remove(triggerMeetingDetails);
		}
	}

	/**
	 * Returns the number of trigger meeting detailses.
	 *
	 * @return the number of trigger meeting detailses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TRIGGERMEETINGDETAILS);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "MEETINGDETAIL_SEQNO";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TRIGGERMEETINGDETAILS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TriggerMeetingDetailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the trigger meeting details persistence.
	 */
	@Activate
	public void activate() {
		TriggerMeetingDetailsModelImpl.setEntityCacheEnabled(
			entityCacheEnabled);
		TriggerMeetingDetailsModelImpl.setFinderCacheEnabled(
			finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			TriggerMeetingDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			TriggerMeetingDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByfindByMeetingSeqno = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			TriggerMeetingDetailsImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByfindByMeetingSeqno", new String[] {Long.class.getName()},
			TriggerMeetingDetailsModelImpl.MEETINGSEQNO_COLUMN_BITMASK);

		_finderPathCountByfindByMeetingSeqno = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByfindByMeetingSeqno", new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByfindByMeetingSeqnoList = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			TriggerMeetingDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByfindByMeetingSeqnoList",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByfindByMeetingSeqnoList =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				TriggerMeetingDetailsImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByfindByMeetingSeqnoList",
				new String[] {Long.class.getName()},
				TriggerMeetingDetailsModelImpl.MEETINGSEQNO_COLUMN_BITMASK);

		_finderPathCountByfindByMeetingSeqnoList = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByfindByMeetingSeqnoList",
			new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(TriggerMeetingDetailsImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = takenakaPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.takenaka.model.TriggerMeetingDetails"),
			true);
	}

	@Override
	@Reference(
		target = takenakaPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = takenakaPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_TRIGGERMEETINGDETAILS =
		"SELECT triggerMeetingDetails FROM TriggerMeetingDetails triggerMeetingDetails";

	private static final String _SQL_SELECT_TRIGGERMEETINGDETAILS_WHERE =
		"SELECT triggerMeetingDetails FROM TriggerMeetingDetails triggerMeetingDetails WHERE ";

	private static final String _SQL_COUNT_TRIGGERMEETINGDETAILS =
		"SELECT COUNT(triggerMeetingDetails) FROM TriggerMeetingDetails triggerMeetingDetails";

	private static final String _SQL_COUNT_TRIGGERMEETINGDETAILS_WHERE =
		"SELECT COUNT(triggerMeetingDetails) FROM TriggerMeetingDetails triggerMeetingDetails WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"triggerMeetingDetails.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TriggerMeetingDetails exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TriggerMeetingDetails exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TriggerMeetingDetailsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"meetingdetailSeqno", "meetingSeqno", "category", "floor", "item",
			"actions", "personInCharge", "createdBy", "createdOn", "modifiedBy",
			"modifiedOn", "isActive"
		});

	static {
		try {
			Class.forName(takenakaPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}