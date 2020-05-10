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
 * Provides a wrapper for {@link ProjTableLocalService}.
 *
 * @author Sanjay.Panchal
 * @see ProjTableLocalService
 * @generated
 */
public class ProjTableLocalServiceWrapper
	implements ProjTableLocalService, ServiceWrapper<ProjTableLocalService> {

	public ProjTableLocalServiceWrapper(
		ProjTableLocalService projTableLocalService) {

		_projTableLocalService = projTableLocalService;
	}

	/**
	 * Adds the proj table to the database. Also notifies the appropriate model listeners.
	 *
	 * @param projTable the proj table
	 * @return the proj table that was added
	 */
	@Override
	public com.takenaka.model.ProjTable addProjTable(
		com.takenaka.model.ProjTable projTable) {

		return _projTableLocalService.addProjTable(projTable);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projTableLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new proj table with the primary key. Does not add the proj table to the database.
	 *
	 * @param recId the primary key for the new proj table
	 * @return the new proj table
	 */
	@Override
	public com.takenaka.model.ProjTable createProjTable(long recId) {
		return _projTableLocalService.createProjTable(recId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projTableLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the proj table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param recId the primary key of the proj table
	 * @return the proj table that was removed
	 * @throws PortalException if a proj table with the primary key could not be found
	 */
	@Override
	public com.takenaka.model.ProjTable deleteProjTable(long recId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projTableLocalService.deleteProjTable(recId);
	}

	/**
	 * Deletes the proj table from the database. Also notifies the appropriate model listeners.
	 *
	 * @param projTable the proj table
	 * @return the proj table that was removed
	 */
	@Override
	public com.takenaka.model.ProjTable deleteProjTable(
		com.takenaka.model.ProjTable projTable) {

		return _projTableLocalService.deleteProjTable(projTable);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _projTableLocalService.dynamicQuery();
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

		return _projTableLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.takenaka.model.impl.ProjTableModelImpl</code>.
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

		return _projTableLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.takenaka.model.impl.ProjTableModelImpl</code>.
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

		return _projTableLocalService.dynamicQuery(
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

		return _projTableLocalService.dynamicQueryCount(dynamicQuery);
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

		return _projTableLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.takenaka.model.ProjTable fetchProjTable(long recId) {
		return _projTableLocalService.fetchProjTable(recId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _projTableLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _projTableLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _projTableLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projTableLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the proj table with the primary key.
	 *
	 * @param recId the primary key of the proj table
	 * @return the proj table
	 * @throws PortalException if a proj table with the primary key could not be found
	 */
	@Override
	public com.takenaka.model.ProjTable getProjTable(long recId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projTableLocalService.getProjTable(recId);
	}

	/**
	 * Returns a range of all the proj tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.takenaka.model.impl.ProjTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of proj tables
	 * @param end the upper bound of the range of proj tables (not inclusive)
	 * @return the range of proj tables
	 */
	@Override
	public java.util.List<com.takenaka.model.ProjTable> getProjTables(
		int start, int end) {

		return _projTableLocalService.getProjTables(start, end);
	}

	/**
	 * Returns the number of proj tables.
	 *
	 * @return the number of proj tables
	 */
	@Override
	public int getProjTablesCount() {
		return _projTableLocalService.getProjTablesCount();
	}

	/**
	 * Updates the proj table in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param projTable the proj table
	 * @return the proj table that was updated
	 */
	@Override
	public com.takenaka.model.ProjTable updateProjTable(
		com.takenaka.model.ProjTable projTable) {

		return _projTableLocalService.updateProjTable(projTable);
	}

	@Override
	public ProjTableLocalService getWrappedService() {
		return _projTableLocalService;
	}

	@Override
	public void setWrappedService(ProjTableLocalService projTableLocalService) {
		_projTableLocalService = projTableLocalService;
	}

	private ProjTableLocalService _projTableLocalService;

}