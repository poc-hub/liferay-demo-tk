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

import com.takenaka.exception.NoSuchTriggerMeetingException;
import com.takenaka.model.TriggerMeeting;
import com.takenaka.model.impl.TriggerMeetingImpl;
import com.takenaka.model.impl.TriggerMeetingModelImpl;
import com.takenaka.service.persistence.TriggerMeetingPersistence;
import com.takenaka.service.persistence.impl.constants.takenakaPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the trigger meeting service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sanjay.Panchal
 * @generated
 */
@Component(service = TriggerMeetingPersistence.class)
public class TriggerMeetingPersistenceImpl
	extends BasePersistenceImpl<TriggerMeeting>
	implements TriggerMeetingPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TriggerMeetingUtil</code> to access the trigger meeting persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TriggerMeetingImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByfindByMeetingId;
	private FinderPath _finderPathCountByfindByMeetingId;

	/**
	 * Returns the trigger meeting where meetingId = &#63; or throws a <code>NoSuchTriggerMeetingException</code> if it could not be found.
	 *
	 * @param meetingId the meeting ID
	 * @return the matching trigger meeting
	 * @throws NoSuchTriggerMeetingException if a matching trigger meeting could not be found
	 */
	@Override
	public TriggerMeeting findByfindByMeetingId(String meetingId)
		throws NoSuchTriggerMeetingException {

		TriggerMeeting triggerMeeting = fetchByfindByMeetingId(meetingId);

		if (triggerMeeting == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("meetingId=");
			msg.append(meetingId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchTriggerMeetingException(msg.toString());
		}

		return triggerMeeting;
	}

	/**
	 * Returns the trigger meeting where meetingId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param meetingId the meeting ID
	 * @return the matching trigger meeting, or <code>null</code> if a matching trigger meeting could not be found
	 */
	@Override
	public TriggerMeeting fetchByfindByMeetingId(String meetingId) {
		return fetchByfindByMeetingId(meetingId, true);
	}

	/**
	 * Returns the trigger meeting where meetingId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param meetingId the meeting ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching trigger meeting, or <code>null</code> if a matching trigger meeting could not be found
	 */
	@Override
	public TriggerMeeting fetchByfindByMeetingId(
		String meetingId, boolean useFinderCache) {

		meetingId = Objects.toString(meetingId, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {meetingId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByfindByMeetingId, finderArgs, this);
		}

		if (result instanceof TriggerMeeting) {
			TriggerMeeting triggerMeeting = (TriggerMeeting)result;

			if (!Objects.equals(meetingId, triggerMeeting.getMeetingId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_TRIGGERMEETING_WHERE);

			boolean bindMeetingId = false;

			if (meetingId.isEmpty()) {
				query.append(_FINDER_COLUMN_FINDBYMEETINGID_MEETINGID_3);
			}
			else {
				bindMeetingId = true;

				query.append(_FINDER_COLUMN_FINDBYMEETINGID_MEETINGID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindMeetingId) {
					qPos.add(meetingId);
				}

				List<TriggerMeeting> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByfindByMeetingId, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {meetingId};
							}

							_log.warn(
								"TriggerMeetingPersistenceImpl.fetchByfindByMeetingId(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					TriggerMeeting triggerMeeting = list.get(0);

					result = triggerMeeting;

					cacheResult(triggerMeeting);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByfindByMeetingId, finderArgs);
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
			return (TriggerMeeting)result;
		}
	}

	/**
	 * Removes the trigger meeting where meetingId = &#63; from the database.
	 *
	 * @param meetingId the meeting ID
	 * @return the trigger meeting that was removed
	 */
	@Override
	public TriggerMeeting removeByfindByMeetingId(String meetingId)
		throws NoSuchTriggerMeetingException {

		TriggerMeeting triggerMeeting = findByfindByMeetingId(meetingId);

		return remove(triggerMeeting);
	}

	/**
	 * Returns the number of trigger meetings where meetingId = &#63;.
	 *
	 * @param meetingId the meeting ID
	 * @return the number of matching trigger meetings
	 */
	@Override
	public int countByfindByMeetingId(String meetingId) {
		meetingId = Objects.toString(meetingId, "");

		FinderPath finderPath = _finderPathCountByfindByMeetingId;

		Object[] finderArgs = new Object[] {meetingId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TRIGGERMEETING_WHERE);

			boolean bindMeetingId = false;

			if (meetingId.isEmpty()) {
				query.append(_FINDER_COLUMN_FINDBYMEETINGID_MEETINGID_3);
			}
			else {
				bindMeetingId = true;

				query.append(_FINDER_COLUMN_FINDBYMEETINGID_MEETINGID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindMeetingId) {
					qPos.add(meetingId);
				}

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

	private static final String _FINDER_COLUMN_FINDBYMEETINGID_MEETINGID_2 =
		"triggerMeeting.meetingId = ?";

	private static final String _FINDER_COLUMN_FINDBYMEETINGID_MEETINGID_3 =
		"(triggerMeeting.meetingId IS NULL OR triggerMeeting.meetingId = '')";

	public TriggerMeetingPersistenceImpl() {
		setModelClass(TriggerMeeting.class);

		setModelImplClass(TriggerMeetingImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("meetingSeqno", "MEETING_SEQNO");
		dbColumnNames.put("groupId", "GROUP_ID");
		dbColumnNames.put("meetingId", "MEETING_ID");
		dbColumnNames.put("meetingTitle", "MEETING_TITLE");
		dbColumnNames.put("issuer", "ISSUER");
		dbColumnNames.put("meetingType", "MEETINGTYPE");
		dbColumnNames.put("meetDate", "MEET_DATE");
		dbColumnNames.put("participant", "PARTICIPANT");
		dbColumnNames.put("meetingPlace", "MEETING_PLACE");
		dbColumnNames.put("meetingSummary", "MEETING_SUMMARY");
		dbColumnNames.put("createdBy", "CREATED_BY");
		dbColumnNames.put("createdOn", "CREATED_ON");
		dbColumnNames.put("modifiedBy", "MODIFIED_BY");
		dbColumnNames.put("modifiedOn", "MODIFIED_ON");
		dbColumnNames.put("isActive", "IS_ACTIVE");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the trigger meeting in the entity cache if it is enabled.
	 *
	 * @param triggerMeeting the trigger meeting
	 */
	@Override
	public void cacheResult(TriggerMeeting triggerMeeting) {
		entityCache.putResult(
			entityCacheEnabled, TriggerMeetingImpl.class,
			triggerMeeting.getPrimaryKey(), triggerMeeting);

		finderCache.putResult(
			_finderPathFetchByfindByMeetingId,
			new Object[] {triggerMeeting.getMeetingId()}, triggerMeeting);

		triggerMeeting.resetOriginalValues();
	}

	/**
	 * Caches the trigger meetings in the entity cache if it is enabled.
	 *
	 * @param triggerMeetings the trigger meetings
	 */
	@Override
	public void cacheResult(List<TriggerMeeting> triggerMeetings) {
		for (TriggerMeeting triggerMeeting : triggerMeetings) {
			if (entityCache.getResult(
					entityCacheEnabled, TriggerMeetingImpl.class,
					triggerMeeting.getPrimaryKey()) == null) {

				cacheResult(triggerMeeting);
			}
			else {
				triggerMeeting.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all trigger meetings.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TriggerMeetingImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the trigger meeting.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TriggerMeeting triggerMeeting) {
		entityCache.removeResult(
			entityCacheEnabled, TriggerMeetingImpl.class,
			triggerMeeting.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((TriggerMeetingModelImpl)triggerMeeting, true);
	}

	@Override
	public void clearCache(List<TriggerMeeting> triggerMeetings) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TriggerMeeting triggerMeeting : triggerMeetings) {
			entityCache.removeResult(
				entityCacheEnabled, TriggerMeetingImpl.class,
				triggerMeeting.getPrimaryKey());

			clearUniqueFindersCache(
				(TriggerMeetingModelImpl)triggerMeeting, true);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, TriggerMeetingImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		TriggerMeetingModelImpl triggerMeetingModelImpl) {

		Object[] args = new Object[] {triggerMeetingModelImpl.getMeetingId()};

		finderCache.putResult(
			_finderPathCountByfindByMeetingId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByfindByMeetingId, args, triggerMeetingModelImpl,
			false);
	}

	protected void clearUniqueFindersCache(
		TriggerMeetingModelImpl triggerMeetingModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				triggerMeetingModelImpl.getMeetingId()
			};

			finderCache.removeResult(_finderPathCountByfindByMeetingId, args);
			finderCache.removeResult(_finderPathFetchByfindByMeetingId, args);
		}

		if ((triggerMeetingModelImpl.getColumnBitmask() &
			 _finderPathFetchByfindByMeetingId.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				triggerMeetingModelImpl.getOriginalMeetingId()
			};

			finderCache.removeResult(_finderPathCountByfindByMeetingId, args);
			finderCache.removeResult(_finderPathFetchByfindByMeetingId, args);
		}
	}

	/**
	 * Creates a new trigger meeting with the primary key. Does not add the trigger meeting to the database.
	 *
	 * @param meetingSeqno the primary key for the new trigger meeting
	 * @return the new trigger meeting
	 */
	@Override
	public TriggerMeeting create(long meetingSeqno) {
		TriggerMeeting triggerMeeting = new TriggerMeetingImpl();

		triggerMeeting.setNew(true);
		triggerMeeting.setPrimaryKey(meetingSeqno);

		return triggerMeeting;
	}

	/**
	 * Removes the trigger meeting with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param meetingSeqno the primary key of the trigger meeting
	 * @return the trigger meeting that was removed
	 * @throws NoSuchTriggerMeetingException if a trigger meeting with the primary key could not be found
	 */
	@Override
	public TriggerMeeting remove(long meetingSeqno)
		throws NoSuchTriggerMeetingException {

		return remove((Serializable)meetingSeqno);
	}

	/**
	 * Removes the trigger meeting with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the trigger meeting
	 * @return the trigger meeting that was removed
	 * @throws NoSuchTriggerMeetingException if a trigger meeting with the primary key could not be found
	 */
	@Override
	public TriggerMeeting remove(Serializable primaryKey)
		throws NoSuchTriggerMeetingException {

		Session session = null;

		try {
			session = openSession();

			TriggerMeeting triggerMeeting = (TriggerMeeting)session.get(
				TriggerMeetingImpl.class, primaryKey);

			if (triggerMeeting == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTriggerMeetingException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(triggerMeeting);
		}
		catch (NoSuchTriggerMeetingException noSuchEntityException) {
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
	protected TriggerMeeting removeImpl(TriggerMeeting triggerMeeting) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(triggerMeeting)) {
				triggerMeeting = (TriggerMeeting)session.get(
					TriggerMeetingImpl.class,
					triggerMeeting.getPrimaryKeyObj());
			}

			if (triggerMeeting != null) {
				session.delete(triggerMeeting);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (triggerMeeting != null) {
			clearCache(triggerMeeting);
		}

		return triggerMeeting;
	}

	@Override
	public TriggerMeeting updateImpl(TriggerMeeting triggerMeeting) {
		boolean isNew = triggerMeeting.isNew();

		if (!(triggerMeeting instanceof TriggerMeetingModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(triggerMeeting.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					triggerMeeting);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in triggerMeeting proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TriggerMeeting implementation " +
					triggerMeeting.getClass());
		}

		TriggerMeetingModelImpl triggerMeetingModelImpl =
			(TriggerMeetingModelImpl)triggerMeeting;

		Session session = null;

		try {
			session = openSession();

			if (triggerMeeting.isNew()) {
				session.save(triggerMeeting);

				triggerMeeting.setNew(false);
			}
			else {
				triggerMeeting = (TriggerMeeting)session.merge(triggerMeeting);
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
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			entityCacheEnabled, TriggerMeetingImpl.class,
			triggerMeeting.getPrimaryKey(), triggerMeeting, false);

		clearUniqueFindersCache(triggerMeetingModelImpl, false);
		cacheUniqueFindersCache(triggerMeetingModelImpl);

		triggerMeeting.resetOriginalValues();

		return triggerMeeting;
	}

	/**
	 * Returns the trigger meeting with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the trigger meeting
	 * @return the trigger meeting
	 * @throws NoSuchTriggerMeetingException if a trigger meeting with the primary key could not be found
	 */
	@Override
	public TriggerMeeting findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTriggerMeetingException {

		TriggerMeeting triggerMeeting = fetchByPrimaryKey(primaryKey);

		if (triggerMeeting == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTriggerMeetingException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return triggerMeeting;
	}

	/**
	 * Returns the trigger meeting with the primary key or throws a <code>NoSuchTriggerMeetingException</code> if it could not be found.
	 *
	 * @param meetingSeqno the primary key of the trigger meeting
	 * @return the trigger meeting
	 * @throws NoSuchTriggerMeetingException if a trigger meeting with the primary key could not be found
	 */
	@Override
	public TriggerMeeting findByPrimaryKey(long meetingSeqno)
		throws NoSuchTriggerMeetingException {

		return findByPrimaryKey((Serializable)meetingSeqno);
	}

	/**
	 * Returns the trigger meeting with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param meetingSeqno the primary key of the trigger meeting
	 * @return the trigger meeting, or <code>null</code> if a trigger meeting with the primary key could not be found
	 */
	@Override
	public TriggerMeeting fetchByPrimaryKey(long meetingSeqno) {
		return fetchByPrimaryKey((Serializable)meetingSeqno);
	}

	/**
	 * Returns all the trigger meetings.
	 *
	 * @return the trigger meetings
	 */
	@Override
	public List<TriggerMeeting> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TriggerMeeting> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<TriggerMeeting> findAll(
		int start, int end,
		OrderByComparator<TriggerMeeting> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<TriggerMeeting> findAll(
		int start, int end, OrderByComparator<TriggerMeeting> orderByComparator,
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

		List<TriggerMeeting> list = null;

		if (useFinderCache) {
			list = (List<TriggerMeeting>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TRIGGERMEETING);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TRIGGERMEETING;

				sql = sql.concat(TriggerMeetingModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<TriggerMeeting>)QueryUtil.list(
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
	 * Removes all the trigger meetings from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TriggerMeeting triggerMeeting : findAll()) {
			remove(triggerMeeting);
		}
	}

	/**
	 * Returns the number of trigger meetings.
	 *
	 * @return the number of trigger meetings
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TRIGGERMEETING);

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
		return "MEETING_SEQNO";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TRIGGERMEETING;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TriggerMeetingModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the trigger meeting persistence.
	 */
	@Activate
	public void activate() {
		TriggerMeetingModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		TriggerMeetingModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TriggerMeetingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TriggerMeetingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByfindByMeetingId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TriggerMeetingImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByfindByMeetingId",
			new String[] {String.class.getName()},
			TriggerMeetingModelImpl.MEETINGID_COLUMN_BITMASK);

		_finderPathCountByfindByMeetingId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByfindByMeetingId",
			new String[] {String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(TriggerMeetingImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.takenaka.model.TriggerMeeting"),
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

	private static final String _SQL_SELECT_TRIGGERMEETING =
		"SELECT triggerMeeting FROM TriggerMeeting triggerMeeting";

	private static final String _SQL_SELECT_TRIGGERMEETING_WHERE =
		"SELECT triggerMeeting FROM TriggerMeeting triggerMeeting WHERE ";

	private static final String _SQL_COUNT_TRIGGERMEETING =
		"SELECT COUNT(triggerMeeting) FROM TriggerMeeting triggerMeeting";

	private static final String _SQL_COUNT_TRIGGERMEETING_WHERE =
		"SELECT COUNT(triggerMeeting) FROM TriggerMeeting triggerMeeting WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "triggerMeeting.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TriggerMeeting exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TriggerMeeting exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TriggerMeetingPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"meetingSeqno", "groupId", "meetingId", "meetingTitle", "issuer",
			"meetingType", "meetDate", "participant", "meetingPlace",
			"meetingSummary", "createdBy", "createdOn", "modifiedBy",
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