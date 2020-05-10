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

package com.takenaka.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.takenaka.model.TriggerMeetingDetails;
import com.takenaka.service.base.TriggerMeetingDetailsLocalServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the trigger meeting details local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.takenaka.service.TriggerMeetingDetailsLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Sanjay.Panchal
 * @see TriggerMeetingDetailsLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.takenaka.model.TriggerMeetingDetails",
	service = AopService.class
)
public class TriggerMeetingDetailsLocalServiceImpl
	extends TriggerMeetingDetailsLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.takenaka.service.TriggerMeetingDetailsLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.takenaka.service.TriggerMeetingDetailsLocalServiceUtil</code>.
	 */
	
	public TriggerMeetingDetails findByMeetingSeqno(Long meetingSeqno) throws PortalException {
		return this.triggerMeetingDetailsPersistence.findByfindByMeetingSeqno(meetingSeqno);
	}
	
	
	public List<TriggerMeetingDetails> findByMeetingSeqnoList(long meetingSeqno) {
			return this.triggerMeetingDetailsPersistence.findByfindByMeetingSeqnoList(meetingSeqno);
		}
	
	
}