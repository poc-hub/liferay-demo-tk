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

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.takenaka.model.TriggerMeetingDetails;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for TriggerMeetingDetails. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Sanjay.Panchal
 * @see TriggerMeetingDetailsLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface TriggerMeetingDetailsLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TriggerMeetingDetailsLocalServiceUtil} to access the trigger meeting details local service. Add custom service methods to <code>com.takenaka.service.impl.TriggerMeetingDetailsLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	 * Adds the trigger meeting details to the database. Also notifies the appropriate model listeners.
	 *
	 * @param triggerMeetingDetails the trigger meeting details
	 * @return the trigger meeting details that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public TriggerMeetingDetails addTriggerMeetingDetails(
		TriggerMeetingDetails triggerMeetingDetails);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new trigger meeting details with the primary key. Does not add the trigger meeting details to the database.
	 *
	 * @param meetingdetailSeqno the primary key for the new trigger meeting details
	 * @return the new trigger meeting details
	 */
	@Transactional(enabled = false)
	public TriggerMeetingDetails createTriggerMeetingDetails(
		long meetingdetailSeqno);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the trigger meeting details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param meetingdetailSeqno the primary key of the trigger meeting details
	 * @return the trigger meeting details that was removed
	 * @throws PortalException if a trigger meeting details with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public TriggerMeetingDetails deleteTriggerMeetingDetails(
			long meetingdetailSeqno)
		throws PortalException;

	/**
	 * Deletes the trigger meeting details from the database. Also notifies the appropriate model listeners.
	 *
	 * @param triggerMeetingDetails the trigger meeting details
	 * @return the trigger meeting details that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public TriggerMeetingDetails deleteTriggerMeetingDetails(
		TriggerMeetingDetails triggerMeetingDetails);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.takenaka.model.impl.TriggerMeetingDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.takenaka.model.impl.TriggerMeetingDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TriggerMeetingDetails fetchTriggerMeetingDetails(
		long meetingdetailSeqno);

	public TriggerMeetingDetails findByMeetingSeqno(Long meetingSeqno)
		throws PortalException;

	public List<TriggerMeetingDetails> findByMeetingSeqnoList(
		long meetingSeqno);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Returns the trigger meeting details with the primary key.
	 *
	 * @param meetingdetailSeqno the primary key of the trigger meeting details
	 * @return the trigger meeting details
	 * @throws PortalException if a trigger meeting details with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TriggerMeetingDetails getTriggerMeetingDetails(
			long meetingdetailSeqno)
		throws PortalException;

	/**
	 * Returns a range of all the trigger meeting detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.takenaka.model.impl.TriggerMeetingDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trigger meeting detailses
	 * @param end the upper bound of the range of trigger meeting detailses (not inclusive)
	 * @return the range of trigger meeting detailses
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TriggerMeetingDetails> getTriggerMeetingDetailses(
		int start, int end);

	/**
	 * Returns the number of trigger meeting detailses.
	 *
	 * @return the number of trigger meeting detailses
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTriggerMeetingDetailsesCount();

	/**
	 * Updates the trigger meeting details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param triggerMeetingDetails the trigger meeting details
	 * @return the trigger meeting details that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public TriggerMeetingDetails updateTriggerMeetingDetails(
		TriggerMeetingDetails triggerMeetingDetails);

}