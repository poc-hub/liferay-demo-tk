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
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.Validator;
import com.takenaka.model.TriggerMeeting;
import com.takenaka.service.TriggerMeetingLocalServiceUtil;
import com.takenaka.service.base.TriggerMeetingLocalServiceBaseImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the trigger meeting local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.takenaka.service.TriggerMeetingLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Sanjay.Panchal
 * @see TriggerMeetingLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.takenaka.model.TriggerMeeting",
	service = AopService.class
)
public class TriggerMeetingLocalServiceImpl
	extends TriggerMeetingLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.takenaka.service.TriggerMeetingLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.takenaka.service.TriggerMeetingLocalServiceUtil</code>.
	 */
	
	public List<TriggerMeeting> getTriggerMeetingByFilter(String meetingType,String meetingId,
			String issuer,String meetingTitle,Date meetDateStr, Date meetDateEnd){
		
		List<TriggerMeeting> triggerMeetings = new ArrayList<TriggerMeeting>();
		
		
		//ClassLoader classLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),"portletClassLoader");
		
		/*
		 * DynamicQuery dynamicQuery =
		 * DynamicQueryFactoryUtil.forClass(TriggerMeeting.class,"",
		 * PortalClassLoaderUtil.getClassLoader());
		 */
		
		DynamicQuery dynamicQuery = TriggerMeetingLocalServiceUtil.dynamicQuery();
		
		Criterion criterion =  null;
		
		if(Validator.isNotNull(meetingType)) {
			criterion = RestrictionsFactoryUtil.like("meetingType", "%"+meetingType+"%");
		}
		
		
		if(Validator.isNotNull(meetingId)) {
			if(null == criterion) {
				criterion = RestrictionsFactoryUtil.like("meetingId", "%"+meetingId+"%");
			} else {
				criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.like("meetingId", "%"+meetingId+"%")); 
			}
			
		}
		
		if(Validator.isNotNull(issuer)) {
			if(null == criterion) {
				criterion = RestrictionsFactoryUtil.like("issuer", "%"+issuer+"%");
			} else {
				criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.like("issuer", "%"+issuer+"%")); 
			}
			
		}
		
		if(Validator.isNotNull(meetingTitle)) {
			if(null == criterion) {
				criterion = RestrictionsFactoryUtil.like("meetingTitle", "%"+meetingTitle+"%");
			} else {
				criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.like("meetingTitle", "%"+meetingTitle+"%")); 
			}
			
		}
		
		if(Validator.isNotNull(meetDateStr) && Validator.isNotNull(meetDateEnd)) {
			if(null == criterion) {
				criterion = RestrictionsFactoryUtil.between("meetDate", meetDateStr, meetDateEnd);
			} else {
				criterion = RestrictionsFactoryUtil.and(criterion, 
						RestrictionsFactoryUtil.between("meetDate", meetDateStr, meetDateEnd)); 
			}
		} else if(Validator.isNotNull(meetDateStr) && Validator.isNull(meetDateEnd)) {
			if(null == criterion) {
				criterion = RestrictionsFactoryUtil.ge("meetDate", meetDateStr);
			} else {
				criterion = RestrictionsFactoryUtil.and(criterion, 
						RestrictionsFactoryUtil.ge("meetDate", meetDateStr)); 
			}
		}  else if(Validator.isNull(meetDateStr) && Validator.isNotNull(meetDateEnd)) {
			if(null == criterion) {
				criterion = RestrictionsFactoryUtil.le("meetDate", meetDateEnd);
			} else {
				criterion = RestrictionsFactoryUtil.and(criterion, 
						RestrictionsFactoryUtil.le("meetDate", meetDateEnd)); 
			}
		}
		
		dynamicQuery.add(criterion);
		
		triggerMeetings = TriggerMeetingLocalServiceUtil.dynamicQuery(dynamicQuery);
		return triggerMeetings;
		
	}
	
	
	
	
	public TriggerMeeting findByMeetingId(String meetingId) throws PortalException {
		return this.triggerMeetingPersistence.findByfindByMeetingId(meetingId);
	}
	
	
}