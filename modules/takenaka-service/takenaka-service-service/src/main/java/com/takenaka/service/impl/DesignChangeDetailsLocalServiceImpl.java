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
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.takenaka.model.DesignChangeDetails;
import com.takenaka.service.DesignChangeDetailsLocalServiceUtil;
import com.takenaka.service.base.DesignChangeDetailsLocalServiceBaseImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the design change details local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.takenaka.service.DesignChangeDetailsLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Sanjay.Panchal
 * @see DesignChangeDetailsLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.takenaka.model.DesignChangeDetails",
	service = AopService.class
)
public class DesignChangeDetailsLocalServiceImpl
	extends DesignChangeDetailsLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.takenaka.service.DesignChangeDetailsLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.takenaka.service.DesignChangeDetailsLocalServiceUtil</code>.
	 */
	
	
	
	/*
	 * add by sanjay
	 */
	
	
	public List<DesignChangeDetails> getDesignChangeDetailsByFilter(String rfcId,String issuer,
			String rangeOfDisclosure,String changeRequestby,String approvalStatus,String constructionStatus,String expensePayment,Date dCRInitiatedStr, Date dCRInitiatedEnd){
		
		List<DesignChangeDetails> designChangeDetailsObj = new ArrayList<DesignChangeDetails>();
		
		
		DynamicQuery dynamicQuery = DesignChangeDetailsLocalServiceUtil.dynamicQuery();
		
		Criterion criterion =  null;
		
		if(Validator.isNotNull(rfcId)) {
			criterion = RestrictionsFactoryUtil.like("rfcId", "%"+rfcId+"%");
		}
		
		
		
		
		if(Validator.isNotNull(issuer)) {
			if(null == criterion) {
				criterion = RestrictionsFactoryUtil.like("issuer", "%"+issuer+"%");
			} else {
				criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.like("issuer", "%"+issuer+"%")); 
			}
			
		}
		
		if(Validator.isNotNull(rangeOfDisclosure)) {
			if(null == criterion) {
				criterion = RestrictionsFactoryUtil.like("rangeOfDisclosure", "%"+rangeOfDisclosure+"%");
			} else {
				criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.like("meetingId", "%"+rangeOfDisclosure+"%")); 
			}
			
		}
		
		
		if(Validator.isNotNull(changeRequestby)) {
			if(null == criterion) {
				criterion = RestrictionsFactoryUtil.like("changeRequestby", "%"+changeRequestby+"%");
			} else {
				criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.like("changeRequestby", "%"+changeRequestby+"%")); 
			}
			
		}
		
		//Approval
		if(Validator.isNotNull(approvalStatus)) {
			if(null == criterion) {
				criterion = RestrictionsFactoryUtil.like("approvalStatus", "%"+approvalStatus+"%");
			} else {
				criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.like("approvalStatus", "%"+approvalStatus+"%")); 
			}
			
		}
		
		//Construction
		
		if(Validator.isNotNull(constructionStatus)) {
			if(null == criterion) {
				criterion = RestrictionsFactoryUtil.like("constructionStatus", "%"+constructionStatus+"%");
			} else {
				criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.like("constructionStatus", "%"+constructionStatus+"%")); 
			}
			
		}
		
		//Expense Payment manage by 
		
		if(Validator.isNotNull(expensePayment)) {
			if(null == criterion) {
				criterion = RestrictionsFactoryUtil.like("expensePayment", "%"+expensePayment+"%");
			} else {
				criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.like("expensePayment", "%"+expensePayment+"%")); 
			}
			
		}
		


		
		
		if(Validator.isNotNull(dCRInitiatedStr) && Validator.isNotNull(dCRInitiatedEnd)) {
			if(null == criterion) {
				criterion = RestrictionsFactoryUtil.between("createdOn", dCRInitiatedStr, dCRInitiatedEnd);
			} else {
				criterion = RestrictionsFactoryUtil.and(criterion, 
						RestrictionsFactoryUtil.between("createdOn", dCRInitiatedStr, dCRInitiatedEnd)); 
			}
		} else if(Validator.isNotNull(dCRInitiatedStr) && Validator.isNull(dCRInitiatedEnd)) {
			if(null == criterion) {
				criterion = RestrictionsFactoryUtil.ge("createdOn", dCRInitiatedStr);
			} else {
				criterion = RestrictionsFactoryUtil.and(criterion, 
						RestrictionsFactoryUtil.ge("createdOn", dCRInitiatedStr)); 
			}
		}  else if(Validator.isNull(dCRInitiatedStr) && Validator.isNotNull(dCRInitiatedEnd)) {
			if(null == criterion) {
				criterion = RestrictionsFactoryUtil.le("createdOn", dCRInitiatedEnd);
			} else {
				criterion = RestrictionsFactoryUtil.and(criterion, 
						RestrictionsFactoryUtil.le("createdOn", dCRInitiatedEnd)); 
			}
		}
		
		dynamicQuery.add(criterion);
		
		designChangeDetailsObj = DesignChangeDetailsLocalServiceUtil.dynamicQuery(dynamicQuery);
		return designChangeDetailsObj;
		
	}
	
	
	
	
}