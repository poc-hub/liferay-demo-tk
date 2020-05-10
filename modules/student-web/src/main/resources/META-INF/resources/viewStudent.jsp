<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.RenderResponse"%>
<%@page import="com.student.service.service.StudentLocalServiceUtil"%>
<%@page import="com.student.service.model.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>

<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ include file="/init.jsp"%>

 		<portlet:renderURL var="addStudentURL">
			<portlet:param name="mvcPath" value="/addStudent.jsp" />
		</portlet:renderURL>

		<aui:button href="${addStudentURL}" value="Add Student"/> 

<%
 List<Student> studentObj =StudentLocalServiceUtil.getStudents(-1,-1);
 //System.out.println(users.size());
%>

<liferay-ui:success key="added-Student" message="Student Added Successfully"/>
<liferay-ui:success key="deleted-Student" message="Student Deleted Successfully"/>
<liferay-ui:success key="updated-Student" message="Student Updated Successfully"/>


<liferay-ui:search-container total="<%=studentObj.size()%>" var="searchContainer" delta="10" deltaConfigurable="true"  iteratorURL="<%=renderResponse.createRenderURL() %>"
 	  emptyResultsMessage="Oops. There Are No student To Display, Please add student details">
  
 <liferay-ui:search-container-results results="<%=ListUtil.subList(studentObj, searchContainer.getStart(),searchContainer.getEnd())%>" />
  <liferay-ui:search-container-row className="com.student.service.model.Student" modelVar="studentt" keyProperty="studentId" >
   
   <liferay-ui:search-container-column-text name="Student Name"    		property="studentName" />
   <liferay-ui:search-container-column-text name="Student Nick Name"    property="studentNickName" />
   <liferay-ui:search-container-column-text name="Student MobNo"    	property="studentMobNo" />
   <liferay-ui:search-container-column-text name="Student Gender"    	property="studentGender" />
   
   <liferay-ui:search-container-column-text name="Student Age"    		property="studentAge" />
   <liferay-ui:search-container-column-text name="Student DOB"    		property="studentDOB" />
   
   <liferay-ui:search-container-column-text name="Action">
		<%-- <portlet:actionURL name="delete" var="delete" >
			<portlet:param name="id" value="<%=String.valueOf(student.getId()) %>"/>
		</portlet:actionURL>
		
		<aui:button type="button" onClick="<%=delete.toString() %>" value="Delete"/> --%>
		
		<portlet:renderURL var="addStudent" >
			<portlet:param name="jspPage" value="/editStudent.jsp"/>
			<portlet:param name="studentId" value="<%=String.valueOf(studentt.getStudentId())%>"/>
		</portlet:renderURL>	
			
		<aui:button  type="button" onClick="${addStudent}" value="Edit"> </aui:button> 
		
		<portlet:actionURL name="deleteStudent" var="deleteStudentURL" >
		<% String id =String.valueOf(studentt.getStudentId()); %>
			<portlet:param name="studentId" value="<%=String.valueOf(studentt.getStudentId())%>"/>
		</portlet:actionURL>
		<aui:button type="button" onClick="${deleteStudentURL}" value="Delete"/>
		
		<%-- <liferay-ui:search-container-column-jsp path="/action.jsp"  /> --%>

</liferay-ui:search-container-column-text>
   
   
   
  </liferay-ui:search-container-row>
 <liferay-ui:search-iterator />

</liferay-ui:search-container>