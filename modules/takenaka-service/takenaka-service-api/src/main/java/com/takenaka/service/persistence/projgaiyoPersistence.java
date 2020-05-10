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

import com.takenaka.exception.NoSuchprojgaiyoException;
import com.takenaka.model.projgaiyo;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the projgaiyo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sanjay.Panchal
 * @see projgaiyoUtil
 * @generated
 */
@ProviderType
public interface projgaiyoPersistence extends BasePersistence<projgaiyo> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link projgaiyoUtil} to access the projgaiyo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the projgaiyos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching projgaiyos
	 */
	public java.util.List<projgaiyo> findByUuid(String uuid);

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
	public java.util.List<projgaiyo> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<projgaiyo> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<projgaiyo>
			orderByComparator);

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
	public java.util.List<projgaiyo> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<projgaiyo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first projgaiyo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching projgaiyo
	 * @throws NoSuchprojgaiyoException if a matching projgaiyo could not be found
	 */
	public projgaiyo findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<projgaiyo>
				orderByComparator)
		throws NoSuchprojgaiyoException;

	/**
	 * Returns the first projgaiyo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching projgaiyo, or <code>null</code> if a matching projgaiyo could not be found
	 */
	public projgaiyo fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<projgaiyo>
			orderByComparator);

	/**
	 * Returns the last projgaiyo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching projgaiyo
	 * @throws NoSuchprojgaiyoException if a matching projgaiyo could not be found
	 */
	public projgaiyo findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<projgaiyo>
				orderByComparator)
		throws NoSuchprojgaiyoException;

	/**
	 * Returns the last projgaiyo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching projgaiyo, or <code>null</code> if a matching projgaiyo could not be found
	 */
	public projgaiyo fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<projgaiyo>
			orderByComparator);

	/**
	 * Returns the projgaiyos before and after the current projgaiyo in the ordered set where uuid = &#63;.
	 *
	 * @param groupId the primary key of the current projgaiyo
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next projgaiyo
	 * @throws NoSuchprojgaiyoException if a projgaiyo with the primary key could not be found
	 */
	public projgaiyo[] findByUuid_PrevAndNext(
			long groupId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<projgaiyo>
				orderByComparator)
		throws NoSuchprojgaiyoException;

	/**
	 * Removes all the projgaiyos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of projgaiyos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching projgaiyos
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the projgaiyo where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchprojgaiyoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching projgaiyo
	 * @throws NoSuchprojgaiyoException if a matching projgaiyo could not be found
	 */
	public projgaiyo findByUUID_G(String uuid, long groupId)
		throws NoSuchprojgaiyoException;

	/**
	 * Returns the projgaiyo where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching projgaiyo, or <code>null</code> if a matching projgaiyo could not be found
	 */
	public projgaiyo fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the projgaiyo where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching projgaiyo, or <code>null</code> if a matching projgaiyo could not be found
	 */
	public projgaiyo fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the projgaiyo where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the projgaiyo that was removed
	 */
	public projgaiyo removeByUUID_G(String uuid, long groupId)
		throws NoSuchprojgaiyoException;

	/**
	 * Returns the number of projgaiyos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching projgaiyos
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Caches the projgaiyo in the entity cache if it is enabled.
	 *
	 * @param projgaiyo the projgaiyo
	 */
	public void cacheResult(projgaiyo projgaiyo);

	/**
	 * Caches the projgaiyos in the entity cache if it is enabled.
	 *
	 * @param projgaiyos the projgaiyos
	 */
	public void cacheResult(java.util.List<projgaiyo> projgaiyos);

	/**
	 * Creates a new projgaiyo with the primary key. Does not add the projgaiyo to the database.
	 *
	 * @param groupId the primary key for the new projgaiyo
	 * @return the new projgaiyo
	 */
	public projgaiyo create(long groupId);

	/**
	 * Removes the projgaiyo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupId the primary key of the projgaiyo
	 * @return the projgaiyo that was removed
	 * @throws NoSuchprojgaiyoException if a projgaiyo with the primary key could not be found
	 */
	public projgaiyo remove(long groupId) throws NoSuchprojgaiyoException;

	public projgaiyo updateImpl(projgaiyo projgaiyo);

	/**
	 * Returns the projgaiyo with the primary key or throws a <code>NoSuchprojgaiyoException</code> if it could not be found.
	 *
	 * @param groupId the primary key of the projgaiyo
	 * @return the projgaiyo
	 * @throws NoSuchprojgaiyoException if a projgaiyo with the primary key could not be found
	 */
	public projgaiyo findByPrimaryKey(long groupId)
		throws NoSuchprojgaiyoException;

	/**
	 * Returns the projgaiyo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param groupId the primary key of the projgaiyo
	 * @return the projgaiyo, or <code>null</code> if a projgaiyo with the primary key could not be found
	 */
	public projgaiyo fetchByPrimaryKey(long groupId);

	/**
	 * Returns all the projgaiyos.
	 *
	 * @return the projgaiyos
	 */
	public java.util.List<projgaiyo> findAll();

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
	public java.util.List<projgaiyo> findAll(int start, int end);

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
	public java.util.List<projgaiyo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<projgaiyo>
			orderByComparator);

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
	public java.util.List<projgaiyo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<projgaiyo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the projgaiyos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of projgaiyos.
	 *
	 * @return the number of projgaiyos
	 */
	public int countAll();

}