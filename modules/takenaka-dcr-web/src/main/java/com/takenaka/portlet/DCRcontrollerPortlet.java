package com.takenaka.portlet;

import com.takenaka.constants.DCRcontrollerPortletKeys;
import com.takenaka.model.DesignChangeDetails;
import com.takenaka.model.TriggerMeeting;
import com.takenaka.service.DesignChangeDetailsLocalServiceUtil;
import com.takenaka.service.TriggerMeetingLocalServiceUtil;
import com.takenaka.service.TriggerMeetingServiceUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionList;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

/**
 * @author Sanjay
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=DCRcontroller", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + DCRcontrollerPortletKeys.DCRCONTROLLER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class DCRcontrollerPortlet extends MVCPortlet {

	
	
	
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		List<TriggerMeeting> userList = TriggerMeetingLocalServiceUtil.getTriggerMeetingByFilter("meetingType", "meetingId", "issuer"," meetingTitle",new Date(), new Date());
		
		
		
		
		//List<DesignChangeDetails> obj = DesignChangeDetailsLocalServiceUtil.getDesignChangeDetailsByFilter(rfcId, issuer, rangeOfDisclosure, changeRequestby, approvalStatus, constructionStatus, expensePayment, dCRInitiatedStr, dCRInitiatedEnd)
		
		
	}
	
	/*
	 * public void processAction(ActionRequest actionRequest, ActionResponse
	 * actionResponse) throws IOException, PortletException {
	 */

		/*// meetingId
		// issuer
		// meetDate
		// meetingTitle

		// meetingType

		// DynamicQuery dynamicQuery =
		// DynamicQueryFactoryUtil.forClass(TriggerMeeting.class,
		// PortalClassLoaderUtil.getClassLoader());

		String meetingId = "meetingId";
		String issuer = "issuer";
		String meetingTitle = "meetingTitle";
		String meetingType = "meetingType";
		String meetDateStr = "meetDateStr";
		String meetDateEnd = "meetDateEnd";
		// issuer
		// meetDate
		// meetingTitle
		// meetingType
		
		 * ProjectionList projectionList = ProjectionFactoryUtil.projectionList();
		 * Criterion criterion = null; //criterion =
		 * RestrictionsFactoryUtil.eq("firstName", "Test");
		 * 
		 * if(Validator.isNotNull(meetingId)) {
		 * dynamicQuery.add(PropertyFactoryUtil.forName("meetingId").eq(meetingId));
		 * //criterion = RestrictionsFactoryUtil.eq("meetingId", meetingId);
		 * 
		 * }
		 * 
		 * if(Validator.isNotNull(issuer)) { criterion =
		 * RestrictionsFactoryUtil.eq("issuer", issuer);
		 * dynamicQuery.add(PropertyFactoryUtil.forName("meetingId").eq(meetingId));
		 * 
		 * } if(Validator.isNotNull(meetingTitle)) {
		 * 
		 * } if(Validator.isNotNull(meetingType)) {
		 * 
		 * }
		 * 
		 * 
		 * 
		 * //ProjectionList projectionList = ProjectionFactoryUtil.projectionList();
		 * projectionList.add(ProjectionFactoryUtil.property("userId"));
		 * projectionList.add(ProjectionFactoryUtil.property("firstName"));
		 * dynamicQuery.setProjection(projectionList);
		 * 
		 * //List<User> userList = UserLocalServiceUtil.dynamicQuery(dynamicQuery);
		  
		//List<TriggerMeeting> userList = TriggerMeetingLocalServiceUtil.dynamicQuery(dynamicQuery);

		List<String> meetingTypee = new ArrayList<String>();
		meetingTypee.add("sadsad");
		meetingTypee.add("xsasdas");
		meetingTypee.add("sasdas");

		Junction junction = null;
		junction = RestrictionsFactoryUtil.conjunction();
		Property property = null;
		DynamicQuery dynamicQuery = null;
		if (Validator.isNotNull(meetingId)) {
			property = PropertyFactoryUtil.forName("meetingId");
			String value = (new StringBuilder("%")).append(meetingId).append("%").toString();
			junction.add(property.like(value));
		}
		if (Validator.isNotNull(issuer)) {
			property = PropertyFactoryUtil.forName("issuer");
			junction.add(property.eq(issuer));
		}
		property = PropertyFactoryUtil.forName("meetingType");
		if (Validator.isNotNull(meetingType)) {
			meetingTypee = new ArrayList<String>();
			meetingTypee.add(meetingType);
		}
		junction.add(property.eq(meetingType));

		if (Validator.isNotNull(meetDateStr) && Validator.isNotNull(meetDateEnd)) {
			//meetDateStr = ParamUtil.getDate(renderRequest, "registrationStartDate", new SimpleDateFormat("dd/MM/yyyy"));
			junction.add(RestrictionsFactoryUtil.ge("registrationDate", meetDateStr));

			meetDateEnd = ParamUtil.getDate(renderRequest, "registrationEndDate", new SimpleDateFormat("dd/MM/yyyy"));
			Calendar searchDate = Calendar.getInstance();
			searchDate.setTime(meetDateEnd);
			searchDate.set(Calendar.HOUR, 23);
			searchDate.set(Calendar.MINUTE, 59);
			searchDate.set(Calendar.SECOND, 59);
			searchDate.set(Calendar.MILLISECOND, 59);
			junction.add(RestrictionsFactoryUtil.le("registrationDate", searchDate.getTime()));
		} else if (Validator.isNotNull(meetDateStr)) {
			//meetDateStr = ParamUtil.getDate(renderRequest, "registrationStartDate", new SimpleDateFormat("dd/MM/yyyy"));
			junction.add(RestrictionsFactoryUtil.ge("registrationDate", meetDateStr));
			Calendar searchDate = Calendar.getInstance();
			searchDate.setTime(meetDateStr);
			searchDate.set(Calendar.HOUR, 23);
			searchDate.set(Calendar.MINUTE, 59);
			searchDate.set(Calendar.SECOND, 59);
			searchDate.set(Calendar.MILLISECOND, 59);
			junction.add(RestrictionsFactoryUtil.le("registrationDate", searchDate.getTime()));
		} else if (Validator.isNotNull(meetDateEnd)) {
			//meetDateEnd = ParamUtil.getDate(renderRequest, "registrationEndDate", new SimpleDateFormat("dd/MM/yyyy"));
			junction.add(RestrictionsFactoryUtil.ge("registrationDate", meetDateEnd));

			Calendar searchDatee = Calendar.getInstance();
			searchDatee.setTime(meetDateEnd);
			searchDatee.set(Calendar.HOUR, 23);
			searchDatee.set(Calendar.MINUTE, 59);
			searchDatee.set(Calendar.SECOND, 59);
			searchDatee.set(Calendar.MILLISECOND, 59);
			junction.add(RestrictionsFactoryUtil.le("registrationDate", searchDatee.getTime()));
		}

		
		 * ClassLoader classLoader = (ClassLoader)
		 * PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), //
		 * "portletClassLoader");
		 		dynamicQuery = DynamicQueryFactoryUtil.forClass(TriggerMeeting.class);
		dynamicQuery.add(junction);
		
		List<TriggerMeeting> userList = TriggerMeetingLocalServiceUtil.dynamicQuery(dynamicQuery);
		//carrierDetailList = TriggerMeetingLocalServiceUtil.dynamicQuery(dynamicQuery);

	}*/

}