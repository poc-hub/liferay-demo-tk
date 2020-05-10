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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import com.takenaka.exception.NoSuchprojgaiyoException;
import com.takenaka.model.impl.projgaiyoImpl;
import com.takenaka.model.impl.projgaiyoModelImpl;
import com.takenaka.model.projgaiyo;
import com.takenaka.service.persistence.impl.constants.takenakaPersistenceConstants;
import com.takenaka.service.persistence.projgaiyoPersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the projgaiyo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sanjay.Panchal
 * @generated
 */
@Component(service = projgaiyoPersistence.class)
public class projgaiyoPersistenceImpl
	extends BasePersistenceImpl<projgaiyo> implements projgaiyoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>projgaiyoUtil</code> to access the projgaiyo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		projgaiyoImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the projgaiyos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching projgaiyos
	 */
	@Override
	public List<projgaiyo> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the projgaiyos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>projgaiyoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of projgaiyos
	 * @param end the upper bound of the range of projgaiyos (not inclusive)
	 * @return the range of matching projgaiyos
	 */
	@Override
	public List<projgaiyo> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the projgaiyos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>projgaiyoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of projgaiyos
	 * @param end the upper bound of the range of projgaiyos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching projgaiyos
	 */
	@Override
	public List<projgaiyo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<projgaiyo> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the projgaiyos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>projgaiyoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of projgaiyos
	 * @param end the upper bound of the range of projgaiyos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching projgaiyos
	 */
	@Override
	public List<projgaiyo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<projgaiyo> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<projgaiyo> list = null;

		if (useFinderCache) {
			list = (List<projgaiyo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (projgaiyo projgaiyo : list) {
					if (!uuid.equals(projgaiyo.getUuid())) {
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

			query.append(_SQL_SELECT_PROJGAIYO_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(projgaiyoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				list = (List<projgaiyo>)QueryUtil.list(
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
	 * Returns the first projgaiyo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching projgaiyo
	 * @throws NoSuchprojgaiyoException if a matching projgaiyo could not be found
	 */
	@Override
	public projgaiyo findByUuid_First(
			String uuid, OrderByComparator<projgaiyo> orderByComparator)
		throws NoSuchprojgaiyoException {

		projgaiyo projgaiyo = fetchByUuid_First(uuid, orderByComparator);

		if (projgaiyo != null) {
			return projgaiyo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchprojgaiyoException(msg.toString());
	}

	/**
	 * Returns the first projgaiyo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching projgaiyo, or <code>null</code> if a matching projgaiyo could not be found
	 */
	@Override
	public projgaiyo fetchByUuid_First(
		String uuid, OrderByComparator<projgaiyo> orderByComparator) {

		List<projgaiyo> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last projgaiyo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching projgaiyo
	 * @throws NoSuchprojgaiyoException if a matching projgaiyo could not be found
	 */
	@Override
	public projgaiyo findByUuid_Last(
			String uuid, OrderByComparator<projgaiyo> orderByComparator)
		throws NoSuchprojgaiyoException {

		projgaiyo projgaiyo = fetchByUuid_Last(uuid, orderByComparator);

		if (projgaiyo != null) {
			return projgaiyo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchprojgaiyoException(msg.toString());
	}

	/**
	 * Returns the last projgaiyo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching projgaiyo, or <code>null</code> if a matching projgaiyo could not be found
	 */
	@Override
	public projgaiyo fetchByUuid_Last(
		String uuid, OrderByComparator<projgaiyo> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<projgaiyo> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the projgaiyos before and after the current projgaiyo in the ordered set where uuid = &#63;.
	 *
	 * @param groupId the primary key of the current projgaiyo
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next projgaiyo
	 * @throws NoSuchprojgaiyoException if a projgaiyo with the primary key could not be found
	 */
	@Override
	public projgaiyo[] findByUuid_PrevAndNext(
			long groupId, String uuid,
			OrderByComparator<projgaiyo> orderByComparator)
		throws NoSuchprojgaiyoException {

		uuid = Objects.toString(uuid, "");

		projgaiyo projgaiyo = findByPrimaryKey(groupId);

		Session session = null;

		try {
			session = openSession();

			projgaiyo[] array = new projgaiyoImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, projgaiyo, uuid, orderByComparator, true);

			array[1] = projgaiyo;

			array[2] = getByUuid_PrevAndNext(
				session, projgaiyo, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected projgaiyo getByUuid_PrevAndNext(
		Session session, projgaiyo projgaiyo, String uuid,
		OrderByComparator<projgaiyo> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROJGAIYO_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

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
			query.append(projgaiyoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(projgaiyo)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<projgaiyo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the projgaiyos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (projgaiyo projgaiyo :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(projgaiyo);
		}
	}

	/**
	 * Returns the number of projgaiyos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching projgaiyos
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROJGAIYO_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
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

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"projgaiyo.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(projgaiyo.uuid IS NULL OR projgaiyo.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the projgaiyo where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchprojgaiyoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching projgaiyo
	 * @throws NoSuchprojgaiyoException if a matching projgaiyo could not be found
	 */
	@Override
	public projgaiyo findByUUID_G(String uuid, long groupId)
		throws NoSuchprojgaiyoException {

		projgaiyo projgaiyo = fetchByUUID_G(uuid, groupId);

		if (projgaiyo == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchprojgaiyoException(msg.toString());
		}

		return projgaiyo;
	}

	/**
	 * Returns the projgaiyo where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching projgaiyo, or <code>null</code> if a matching projgaiyo could not be found
	 */
	@Override
	public projgaiyo fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the projgaiyo where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching projgaiyo, or <code>null</code> if a matching projgaiyo could not be found
	 */
	@Override
	public projgaiyo fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof projgaiyo) {
			projgaiyo projgaiyo = (projgaiyo)result;

			if (!Objects.equals(uuid, projgaiyo.getUuid()) ||
				(groupId != projgaiyo.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_PROJGAIYO_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<projgaiyo> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					projgaiyo projgaiyo = list.get(0);

					result = projgaiyo;

					cacheResult(projgaiyo);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByUUID_G, finderArgs);
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
			return (projgaiyo)result;
		}
	}

	/**
	 * Removes the projgaiyo where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the projgaiyo that was removed
	 */
	@Override
	public projgaiyo removeByUUID_G(String uuid, long groupId)
		throws NoSuchprojgaiyoException {

		projgaiyo projgaiyo = findByUUID_G(uuid, groupId);

		return remove(projgaiyo);
	}

	/**
	 * Returns the number of projgaiyos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching projgaiyos
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PROJGAIYO_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"projgaiyo.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(projgaiyo.uuid IS NULL OR projgaiyo.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"projgaiyo.groupId = ?";

	public projgaiyoPersistenceImpl() {
		setModelClass(projgaiyo.class);

		setModelImplClass(projgaiyoImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("groupId", "GROUP_ID");
		dbColumnNames.put("projNm", "PROJ_NM");
		dbColumnNames.put("projNmKana", "PROJ_NM_KANA");
		dbColumnNames.put("kenchikuNusiCd", "KENCHIKU_NUSI_CD");
		dbColumnNames.put("kenchikuNusiNm", "KENCHIKU_NUSI_NM");
		dbColumnNames.put("kenchikuChiCd", "KENCHIKU_CHI_CD");
		dbColumnNames.put("kenchikuChiNm", "KENCHIKU_CHI_NM");
		dbColumnNames.put("tatemonoYoto1", "TATEMONO_YOTO1");
		dbColumnNames.put("tatemonoYoto2", "TATEMONO_YOTO2");
		dbColumnNames.put("tatemonoYoto3", "TATEMONO_YOTO3");
		dbColumnNames.put("kaisuB", "KAISU_B");
		dbColumnNames.put("kaisuF", "KAISU_F");
		dbColumnNames.put("kaisuP", "KAISU_P");
		dbColumnNames.put("kozoShubetu1", "KOZO_SHUBETU1");
		dbColumnNames.put("kozoShubetu2", "KOZO_SHUBETU2");
		dbColumnNames.put("kozoShubetu3", "KOZO_SHUBETU3");
		dbColumnNames.put("nobeyukaMenseki", "NOBEYUKA_MENSEKI");
		dbColumnNames.put("kenchikuMenseki", "KENCHIKU_MENSEKI");
		dbColumnNames.put("chakkoBi", "CHAKKO_BI");
		dbColumnNames.put("shunkoBi", "SHUNKO_BI");
		dbColumnNames.put("sekkeiKb", "SEKKEI_KB");
		dbColumnNames.put("sekoKb", "SEKO_KB");
		dbColumnNames.put("sagyoshoChiku", "SAGYOSHO_CHIKU");
		dbColumnNames.put("updDate", "UPD_DATE");
		dbColumnNames.put("updTime", "UPD_TIME");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the projgaiyo in the entity cache if it is enabled.
	 *
	 * @param projgaiyo the projgaiyo
	 */
	@Override
	public void cacheResult(projgaiyo projgaiyo) {
		entityCache.putResult(
			entityCacheEnabled, projgaiyoImpl.class, projgaiyo.getPrimaryKey(),
			projgaiyo);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {projgaiyo.getUuid(), projgaiyo.getGroupId()},
			projgaiyo);

		projgaiyo.resetOriginalValues();
	}

	/**
	 * Caches the projgaiyos in the entity cache if it is enabled.
	 *
	 * @param projgaiyos the projgaiyos
	 */
	@Override
	public void cacheResult(List<projgaiyo> projgaiyos) {
		for (projgaiyo projgaiyo : projgaiyos) {
			if (entityCache.getResult(
					entityCacheEnabled, projgaiyoImpl.class,
					projgaiyo.getPrimaryKey()) == null) {

				cacheResult(projgaiyo);
			}
			else {
				projgaiyo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all projgaiyos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(projgaiyoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the projgaiyo.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(projgaiyo projgaiyo) {
		entityCache.removeResult(
			entityCacheEnabled, projgaiyoImpl.class, projgaiyo.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((projgaiyoModelImpl)projgaiyo, true);
	}

	@Override
	public void clearCache(List<projgaiyo> projgaiyos) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (projgaiyo projgaiyo : projgaiyos) {
			entityCache.removeResult(
				entityCacheEnabled, projgaiyoImpl.class,
				projgaiyo.getPrimaryKey());

			clearUniqueFindersCache((projgaiyoModelImpl)projgaiyo, true);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, projgaiyoImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		projgaiyoModelImpl projgaiyoModelImpl) {

		Object[] args = new Object[] {
			projgaiyoModelImpl.getUuid(), projgaiyoModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, projgaiyoModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		projgaiyoModelImpl projgaiyoModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				projgaiyoModelImpl.getUuid(), projgaiyoModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((projgaiyoModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				projgaiyoModelImpl.getOriginalUuid(),
				projgaiyoModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}
	}

	/**
	 * Creates a new projgaiyo with the primary key. Does not add the projgaiyo to the database.
	 *
	 * @param groupId the primary key for the new projgaiyo
	 * @return the new projgaiyo
	 */
	@Override
	public projgaiyo create(long groupId) {
		projgaiyo projgaiyo = new projgaiyoImpl();

		projgaiyo.setNew(true);
		projgaiyo.setPrimaryKey(groupId);

		String uuid = PortalUUIDUtil.generate();

		projgaiyo.setUuid(uuid);

		return projgaiyo;
	}

	/**
	 * Removes the projgaiyo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupId the primary key of the projgaiyo
	 * @return the projgaiyo that was removed
	 * @throws NoSuchprojgaiyoException if a projgaiyo with the primary key could not be found
	 */
	@Override
	public projgaiyo remove(long groupId) throws NoSuchprojgaiyoException {
		return remove((Serializable)groupId);
	}

	/**
	 * Removes the projgaiyo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the projgaiyo
	 * @return the projgaiyo that was removed
	 * @throws NoSuchprojgaiyoException if a projgaiyo with the primary key could not be found
	 */
	@Override
	public projgaiyo remove(Serializable primaryKey)
		throws NoSuchprojgaiyoException {

		Session session = null;

		try {
			session = openSession();

			projgaiyo projgaiyo = (projgaiyo)session.get(
				projgaiyoImpl.class, primaryKey);

			if (projgaiyo == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchprojgaiyoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(projgaiyo);
		}
		catch (NoSuchprojgaiyoException noSuchEntityException) {
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
	protected projgaiyo removeImpl(projgaiyo projgaiyo) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(projgaiyo)) {
				projgaiyo = (projgaiyo)session.get(
					projgaiyoImpl.class, projgaiyo.getPrimaryKeyObj());
			}

			if (projgaiyo != null) {
				session.delete(projgaiyo);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (projgaiyo != null) {
			clearCache(projgaiyo);
		}

		return projgaiyo;
	}

	@Override
	public projgaiyo updateImpl(projgaiyo projgaiyo) {
		boolean isNew = projgaiyo.isNew();

		if (!(projgaiyo instanceof projgaiyoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(projgaiyo.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(projgaiyo);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in projgaiyo proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom projgaiyo implementation " +
					projgaiyo.getClass());
		}

		projgaiyoModelImpl projgaiyoModelImpl = (projgaiyoModelImpl)projgaiyo;

		if (Validator.isNull(projgaiyo.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			projgaiyo.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (projgaiyo.isNew()) {
				session.save(projgaiyo);

				projgaiyo.setNew(false);
			}
			else {
				projgaiyo = (projgaiyo)session.merge(projgaiyo);
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
			Object[] args = new Object[] {projgaiyoModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((projgaiyoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					projgaiyoModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {projgaiyoModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, projgaiyoImpl.class, projgaiyo.getPrimaryKey(),
			projgaiyo, false);

		clearUniqueFindersCache(projgaiyoModelImpl, false);
		cacheUniqueFindersCache(projgaiyoModelImpl);

		projgaiyo.resetOriginalValues();

		return projgaiyo;
	}

	/**
	 * Returns the projgaiyo with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the projgaiyo
	 * @return the projgaiyo
	 * @throws NoSuchprojgaiyoException if a projgaiyo with the primary key could not be found
	 */
	@Override
	public projgaiyo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchprojgaiyoException {

		projgaiyo projgaiyo = fetchByPrimaryKey(primaryKey);

		if (projgaiyo == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchprojgaiyoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return projgaiyo;
	}

	/**
	 * Returns the projgaiyo with the primary key or throws a <code>NoSuchprojgaiyoException</code> if it could not be found.
	 *
	 * @param groupId the primary key of the projgaiyo
	 * @return the projgaiyo
	 * @throws NoSuchprojgaiyoException if a projgaiyo with the primary key could not be found
	 */
	@Override
	public projgaiyo findByPrimaryKey(long groupId)
		throws NoSuchprojgaiyoException {

		return findByPrimaryKey((Serializable)groupId);
	}

	/**
	 * Returns the projgaiyo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param groupId the primary key of the projgaiyo
	 * @return the projgaiyo, or <code>null</code> if a projgaiyo with the primary key could not be found
	 */
	@Override
	public projgaiyo fetchByPrimaryKey(long groupId) {
		return fetchByPrimaryKey((Serializable)groupId);
	}

	/**
	 * Returns all the projgaiyos.
	 *
	 * @return the projgaiyos
	 */
	@Override
	public List<projgaiyo> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the projgaiyos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>projgaiyoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of projgaiyos
	 * @param end the upper bound of the range of projgaiyos (not inclusive)
	 * @return the range of projgaiyos
	 */
	@Override
	public List<projgaiyo> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the projgaiyos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>projgaiyoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of projgaiyos
	 * @param end the upper bound of the range of projgaiyos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of projgaiyos
	 */
	@Override
	public List<projgaiyo> findAll(
		int start, int end, OrderByComparator<projgaiyo> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the projgaiyos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>projgaiyoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of projgaiyos
	 * @param end the upper bound of the range of projgaiyos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of projgaiyos
	 */
	@Override
	public List<projgaiyo> findAll(
		int start, int end, OrderByComparator<projgaiyo> orderByComparator,
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

		List<projgaiyo> list = null;

		if (useFinderCache) {
			list = (List<projgaiyo>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PROJGAIYO);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROJGAIYO;

				sql = sql.concat(projgaiyoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<projgaiyo>)QueryUtil.list(
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
	 * Removes all the projgaiyos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (projgaiyo projgaiyo : findAll()) {
			remove(projgaiyo);
		}
	}

	/**
	 * Returns the number of projgaiyos.
	 *
	 * @return the number of projgaiyos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PROJGAIYO);

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
		return "GROUP_ID";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PROJGAIYO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return projgaiyoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the projgaiyo persistence.
	 */
	@Activate
	public void activate() {
		projgaiyoModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		projgaiyoModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, projgaiyoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, projgaiyoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, projgaiyoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, projgaiyoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			projgaiyoModelImpl.UUID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, projgaiyoImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			projgaiyoModelImpl.UUID_COLUMN_BITMASK |
			projgaiyoModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(projgaiyoImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.takenaka.model.projgaiyo"),
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

	private static final String _SQL_SELECT_PROJGAIYO =
		"SELECT projgaiyo FROM projgaiyo projgaiyo";

	private static final String _SQL_SELECT_PROJGAIYO_WHERE =
		"SELECT projgaiyo FROM projgaiyo projgaiyo WHERE ";

	private static final String _SQL_COUNT_PROJGAIYO =
		"SELECT COUNT(projgaiyo) FROM projgaiyo projgaiyo";

	private static final String _SQL_COUNT_PROJGAIYO_WHERE =
		"SELECT COUNT(projgaiyo) FROM projgaiyo projgaiyo WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "projgaiyo.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No projgaiyo exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No projgaiyo exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		projgaiyoPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "groupId", "projNm", "projNmKana", "kenchikuNusiCd",
			"kenchikuNusiNm", "kenchikuChiCd", "kenchikuChiNm", "tatemonoYoto1",
			"tatemonoYoto2", "tatemonoYoto3", "kaisuB", "kaisuF", "kaisuP",
			"kozoShubetu1", "kozoShubetu2", "kozoShubetu3", "nobeyukaMenseki",
			"kenchikuMenseki", "chakkoBi", "shunkoBi", "sekkeiKb", "sekoKb",
			"sagyoshoChiku", "updDate", "updTime"
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