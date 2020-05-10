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
 * Provides a wrapper for {@link projgaiyoLocalService}.
 *
 * @author Sanjay.Panchal
 * @see projgaiyoLocalService
 * @generated
 */
public class projgaiyoLocalServiceWrapper
	implements projgaiyoLocalService, ServiceWrapper<projgaiyoLocalService> {

	public projgaiyoLocalServiceWrapper(
		projgaiyoLocalService projgaiyoLocalService) {

		_projgaiyoLocalService = projgaiyoLocalService;
	}

	/**
	 * Adds the projgaiyo to the database. Also notifies the appropriate model listeners.
	 *
	 * @param projgaiyo the projgaiyo
	 * @return the projgaiyo that was added
	 */
	@Override
	public com.takenaka.model.projgaiyo addprojgaiyo(
		com.takenaka.model.projgaiyo projgaiyo) {

		return _projgaiyoLocalService.addprojgaiyo(projgaiyo);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projgaiyoLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new projgaiyo with the primary key. Does not add the projgaiyo to the database.
	 *
	 * @param groupId the primary key for the new projgaiyo
	 * @return the new projgaiyo
	 */
	@Override
	public com.takenaka.model.projgaiyo createprojgaiyo(long groupId) {
		return _projgaiyoLocalService.createprojgaiyo(groupId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projgaiyoLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the projgaiyo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupId the primary key of the projgaiyo
	 * @return the projgaiyo that was removed
	 * @throws PortalException if a projgaiyo with the primary key could not be found
	 */
	@Override
	public com.takenaka.model.projgaiyo deleteprojgaiyo(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projgaiyoLocalService.deleteprojgaiyo(groupId);
	}

	/**
	 * Deletes the projgaiyo from the database. Also notifies the appropriate model listeners.
	 *
	 * @param projgaiyo the projgaiyo
	 * @return the projgaiyo that was removed
	 */
	@Override
	public com.takenaka.model.projgaiyo deleteprojgaiyo(
		com.takenaka.model.projgaiyo projgaiyo) {

		return _projgaiyoLocalService.deleteprojgaiyo(projgaiyo);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _projgaiyoLocalService.dynamicQuery();
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

		return _projgaiyoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.takenaka.model.impl.projgaiyoModelImpl</code>.
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

		return _projgaiyoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.takenaka.model.impl.projgaiyoModelImpl</code>.
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

		return _projgaiyoLocalService.dynamicQuery(
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

		return _projgaiyoLocalService.dynamicQueryCount(dynamicQuery);
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

		return _projgaiyoLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.takenaka.model.projgaiyo fetchprojgaiyo(long groupId) {
		return _projgaiyoLocalService.fetchprojgaiyo(groupId);
	}

	/**
	 * Returns the projgaiyo matching the UUID and group.
	 *
	 * @param uuid the projgaiyo's UUID
	 * @param groupId the primary key of the group
	 * @return the matching projgaiyo, or <code>null</code> if a matching projgaiyo could not be found
	 */
	@Override
	public com.takenaka.model.projgaiyo fetchprojgaiyoByUuidAndGroupId(
		String uuid, long groupId) {

		return _projgaiyoLocalService.fetchprojgaiyoByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _projgaiyoLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _projgaiyoLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _projgaiyoLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projgaiyoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the projgaiyo with the primary key.
	 *
	 * @param groupId the primary key of the projgaiyo
	 * @return the projgaiyo
	 * @throws PortalException if a projgaiyo with the primary key could not be found
	 */
	@Override
	public com.takenaka.model.projgaiyo getprojgaiyo(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projgaiyoLocalService.getprojgaiyo(groupId);
	}

	/**
	 * Returns the projgaiyo matching the UUID and group.
	 *
	 * @param uuid the projgaiyo's UUID
	 * @param groupId the primary key of the group
	 * @return the matching projgaiyo
	 * @throws PortalException if a matching projgaiyo could not be found
	 */
	@Override
	public com.takenaka.model.projgaiyo getprojgaiyoByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projgaiyoLocalService.getprojgaiyoByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the projgaiyos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.takenaka.model.impl.projgaiyoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of projgaiyos
	 * @param end the upper bound of the range of projgaiyos (not inclusive)
	 * @return the range of projgaiyos
	 */
	@Override
	public java.util.List<com.takenaka.model.projgaiyo> getprojgaiyos(
		int start, int end) {

		return _projgaiyoLocalService.getprojgaiyos(start, end);
	}

	/**
	 * Returns the number of projgaiyos.
	 *
	 * @return the number of projgaiyos
	 */
	@Override
	public int getprojgaiyosCount() {
		return _projgaiyoLocalService.getprojgaiyosCount();
	}

	/**
	 * Updates the projgaiyo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param projgaiyo the projgaiyo
	 * @return the projgaiyo that was updated
	 */
	@Override
	public com.takenaka.model.projgaiyo updateprojgaiyo(
		com.takenaka.model.projgaiyo projgaiyo) {

		return _projgaiyoLocalService.updateprojgaiyo(projgaiyo);
	}

	@Override
	public projgaiyoLocalService getWrappedService() {
		return _projgaiyoLocalService;
	}

	@Override
	public void setWrappedService(projgaiyoLocalService projgaiyoLocalService) {
		_projgaiyoLocalService = projgaiyoLocalService;
	}

	private projgaiyoLocalService _projgaiyoLocalService;

}