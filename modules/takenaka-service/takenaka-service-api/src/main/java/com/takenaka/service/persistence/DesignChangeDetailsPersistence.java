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

import com.takenaka.exception.NoSuchDesignChangeDetailsException;
import com.takenaka.model.DesignChangeDetails;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the design change details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sanjay.Panchal
 * @see DesignChangeDetailsUtil
 * @generated
 */
@ProviderType
public interface DesignChangeDetailsPersistence
	extends BasePersistence<DesignChangeDetails> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DesignChangeDetailsUtil} to access the design change details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the design change details in the entity cache if it is enabled.
	 *
	 * @param designChangeDetails the design change details
	 */
	public void cacheResult(DesignChangeDetails designChangeDetails);

	/**
	 * Caches the design change detailses in the entity cache if it is enabled.
	 *
	 * @param designChangeDetailses the design change detailses
	 */
	public void cacheResult(
		java.util.List<DesignChangeDetails> designChangeDetailses);

	/**
	 * Creates a new design change details with the primary key. Does not add the design change details to the database.
	 *
	 * @param dcrChangeSeqno the primary key for the new design change details
	 * @return the new design change details
	 */
	public DesignChangeDetails create(long dcrChangeSeqno);

	/**
	 * Removes the design change details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dcrChangeSeqno the primary key of the design change details
	 * @return the design change details that was removed
	 * @throws NoSuchDesignChangeDetailsException if a design change details with the primary key could not be found
	 */
	public DesignChangeDetails remove(long dcrChangeSeqno)
		throws NoSuchDesignChangeDetailsException;

	public DesignChangeDetails updateImpl(
		DesignChangeDetails designChangeDetails);

	/**
	 * Returns the design change details with the primary key or throws a <code>NoSuchDesignChangeDetailsException</code> if it could not be found.
	 *
	 * @param dcrChangeSeqno the primary key of the design change details
	 * @return the design change details
	 * @throws NoSuchDesignChangeDetailsException if a design change details with the primary key could not be found
	 */
	public DesignChangeDetails findByPrimaryKey(long dcrChangeSeqno)
		throws NoSuchDesignChangeDetailsException;

	/**
	 * Returns the design change details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dcrChangeSeqno the primary key of the design change details
	 * @return the design change details, or <code>null</code> if a design change details with the primary key could not be found
	 */
	public DesignChangeDetails fetchByPrimaryKey(long dcrChangeSeqno);

	/**
	 * Returns all the design change detailses.
	 *
	 * @return the design change detailses
	 */
	public java.util.List<DesignChangeDetails> findAll();

	/**
	 * Returns a range of all the design change detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignChangeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of design change detailses
	 * @param end the upper bound of the range of design change detailses (not inclusive)
	 * @return the range of design change detailses
	 */
	public java.util.List<DesignChangeDetails> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the design change detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignChangeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of design change detailses
	 * @param end the upper bound of the range of design change detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of design change detailses
	 */
	public java.util.List<DesignChangeDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DesignChangeDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the design change detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignChangeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of design change detailses
	 * @param end the upper bound of the range of design change detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of design change detailses
	 */
	public java.util.List<DesignChangeDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DesignChangeDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the design change detailses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of design change detailses.
	 *
	 * @return the number of design change detailses
	 */
	public int countAll();

}