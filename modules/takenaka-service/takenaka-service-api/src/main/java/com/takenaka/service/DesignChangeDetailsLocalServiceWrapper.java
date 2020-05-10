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
 * Provides a wrapper for {@link DesignChangeDetailsLocalService}.
 *
 * @author Sanjay.Panchal
 * @see DesignChangeDetailsLocalService
 * @generated
 */
public class DesignChangeDetailsLocalServiceWrapper
	implements DesignChangeDetailsLocalService,
			   ServiceWrapper<DesignChangeDetailsLocalService> {

	public DesignChangeDetailsLocalServiceWrapper(
		DesignChangeDetailsLocalService designChangeDetailsLocalService) {

		_designChangeDetailsLocalService = designChangeDetailsLocalService;
	}

	/**
	 * Adds the design change details to the database. Also notifies the appropriate model listeners.
	 *
	 * @param designChangeDetails the design change details
	 * @return the design change details that was added
	 */
	@Override
	public com.takenaka.model.DesignChangeDetails addDesignChangeDetails(
		com.takenaka.model.DesignChangeDetails designChangeDetails) {

		return _designChangeDetailsLocalService.addDesignChangeDetails(
			designChangeDetails);
	}

	/**
	 * Creates a new design change details with the primary key. Does not add the design change details to the database.
	 *
	 * @param dcrChangeSeqno the primary key for the new design change details
	 * @return the new design change details
	 */
	@Override
	public com.takenaka.model.DesignChangeDetails createDesignChangeDetails(
		long dcrChangeSeqno) {

		return _designChangeDetailsLocalService.createDesignChangeDetails(
			dcrChangeSeqno);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _designChangeDetailsLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the design change details from the database. Also notifies the appropriate model listeners.
	 *
	 * @param designChangeDetails the design change details
	 * @return the design change details that was removed
	 */
	@Override
	public com.takenaka.model.DesignChangeDetails deleteDesignChangeDetails(
		com.takenaka.model.DesignChangeDetails designChangeDetails) {

		return _designChangeDetailsLocalService.deleteDesignChangeDetails(
			designChangeDetails);
	}

	/**
	 * Deletes the design change details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dcrChangeSeqno the primary key of the design change details
	 * @return the design change details that was removed
	 * @throws PortalException if a design change details with the primary key could not be found
	 */
	@Override
	public com.takenaka.model.DesignChangeDetails deleteDesignChangeDetails(
			long dcrChangeSeqno)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _designChangeDetailsLocalService.deleteDesignChangeDetails(
			dcrChangeSeqno);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _designChangeDetailsLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _designChangeDetailsLocalService.dynamicQuery();
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

		return _designChangeDetailsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.takenaka.model.impl.DesignChangeDetailsModelImpl</code>.
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

		return _designChangeDetailsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.takenaka.model.impl.DesignChangeDetailsModelImpl</code>.
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

		return _designChangeDetailsLocalService.dynamicQuery(
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

		return _designChangeDetailsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _designChangeDetailsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.takenaka.model.DesignChangeDetails fetchDesignChangeDetails(
		long dcrChangeSeqno) {

		return _designChangeDetailsLocalService.fetchDesignChangeDetails(
			dcrChangeSeqno);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _designChangeDetailsLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the design change details with the primary key.
	 *
	 * @param dcrChangeSeqno the primary key of the design change details
	 * @return the design change details
	 * @throws PortalException if a design change details with the primary key could not be found
	 */
	@Override
	public com.takenaka.model.DesignChangeDetails getDesignChangeDetails(
			long dcrChangeSeqno)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _designChangeDetailsLocalService.getDesignChangeDetails(
			dcrChangeSeqno);
	}

	@Override
	public java.util.List<com.takenaka.model.DesignChangeDetails>
		getDesignChangeDetailsByFilter(
			String rfcId, String issuer, String rangeOfDisclosure,
			String changeRequestby, String approvalStatus,
			String constructionStatus, String expensePayment,
			java.util.Date dCRInitiatedStr, java.util.Date dCRInitiatedEnd) {

		return _designChangeDetailsLocalService.getDesignChangeDetailsByFilter(
			rfcId, issuer, rangeOfDisclosure, changeRequestby, approvalStatus,
			constructionStatus, expensePayment, dCRInitiatedStr,
			dCRInitiatedEnd);
	}

	/**
	 * Returns a range of all the design change detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.takenaka.model.impl.DesignChangeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of design change detailses
	 * @param end the upper bound of the range of design change detailses (not inclusive)
	 * @return the range of design change detailses
	 */
	@Override
	public java.util.List<com.takenaka.model.DesignChangeDetails>
		getDesignChangeDetailses(int start, int end) {

		return _designChangeDetailsLocalService.getDesignChangeDetailses(
			start, end);
	}

	/**
	 * Returns the number of design change detailses.
	 *
	 * @return the number of design change detailses
	 */
	@Override
	public int getDesignChangeDetailsesCount() {
		return _designChangeDetailsLocalService.getDesignChangeDetailsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _designChangeDetailsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _designChangeDetailsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _designChangeDetailsLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the design change details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param designChangeDetails the design change details
	 * @return the design change details that was updated
	 */
	@Override
	public com.takenaka.model.DesignChangeDetails updateDesignChangeDetails(
		com.takenaka.model.DesignChangeDetails designChangeDetails) {

		return _designChangeDetailsLocalService.updateDesignChangeDetails(
			designChangeDetails);
	}

	@Override
	public DesignChangeDetailsLocalService getWrappedService() {
		return _designChangeDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		DesignChangeDetailsLocalService designChangeDetailsLocalService) {

		_designChangeDetailsLocalService = designChangeDetailsLocalService;
	}

	private DesignChangeDetailsLocalService _designChangeDetailsLocalService;

}