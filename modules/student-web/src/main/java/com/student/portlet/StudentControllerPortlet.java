package com.student.portlet;

import com.student.constants.StudentControllerPortletKeys;
import com.student.service.model.Student;
import com.student.service.service.StudentLocalServiceUtil;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

/**
 * @author Sanjay
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=Student",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=StudentInformation",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/viewStudent.jsp",
		"javax.portlet.name=" + StudentControllerPortletKeys.STUDENTCONTROLLER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class StudentControllerPortlet extends MVCPortlet {
	
	public void addStudent(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, ParseException {
		
		
		long id=CounterLocalServiceUtil.increment(Student.class.getName());
		Student studentObj =  StudentLocalServiceUtil.createStudent(id);
		
		String studentName = ParamUtil.getString(actionRequest, "studentName"); 
		String studentNickName = ParamUtil.getString(actionRequest, "studentNickName"); 
		long studentMobNo =ParamUtil.getLong(actionRequest, "studentMobNo"); 
		boolean gender = ParamUtil.getBoolean(actionRequest, "gender"); 
		int studentAge = ParamUtil.getInteger(actionRequest, "studentAge"); 
		String studentDOB = ParamUtil.getString(actionRequest, "studentDOB");
		//System.out.println("dob  ======" + studentDOB);
		
		Date dob=new SimpleDateFormat("yyyy-MM-dd").parse(studentDOB);
		
		
		studentObj.setStudentName(studentName);
		studentObj.setStudentNickName(studentNickName);
		studentObj.setStudentMobNo(studentMobNo);
		studentObj.setStudentGender(gender);
		studentObj.setStudentAge(studentAge);
		studentObj.setStudentDOB(dob);
		
		StudentLocalServiceUtil.addStudent(studentObj);
		
		SessionMessages.add(actionRequest, "added-Student"); 
		
	}
	
	public void updateStudent(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, ParseException {
		
		long studentId  = ParamUtil.getLong(actionRequest, "studentId"); 
		String studentName = ParamUtil.getString(actionRequest, "studentName"); 
		String studentNickName = ParamUtil.getString(actionRequest, "studentNickName"); 
		long studentMobNo =ParamUtil.getLong(actionRequest, "studentMobNo"); 
		boolean gender = ParamUtil.getBoolean(actionRequest, "gender"); 
		int studentAge = ParamUtil.getInteger(actionRequest, "studentAge"); 
		//String studentDOB = ParamUtil.getString(actionRequest, "studentDOB");
		//System.out.println("dob  ======" + studentDOB);
		
		//Student studentObj;
		try {
			Student studentObj = StudentLocalServiceUtil.getStudent(studentId);
			//Date dob=new SimpleDateFormat("yyyy-MM-dd").parse(studentDOB);
			studentObj.setStudentName(studentName);
			studentObj.setStudentNickName(studentNickName);
			studentObj.setStudentMobNo(studentMobNo);
			studentObj.setStudentGender(gender);
			studentObj.setStudentAge(studentAge);
			//studentObj.setStudentDOB(dob);
			
			StudentLocalServiceUtil.updateStudent(studentObj);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		SessionMessages.add(actionRequest, "updated-Student");
	}
	public void deleteStudent(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		
		long studentId = ParamUtil.getLong(actionRequest, "studentId");
		try {
			StudentLocalServiceUtil.deleteStudent(studentId);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SessionMessages.add(actionRequest, "deleted-Student");
	}
	
}