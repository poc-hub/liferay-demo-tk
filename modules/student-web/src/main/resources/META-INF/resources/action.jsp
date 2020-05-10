<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.student.service.model.Student"%>
<%@ include file="/init.jsp"%>

<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>

<%
	ResultRow row = (ResultRow) request
			.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	Student studentObj = (Student) row.getObject();
%>

<liferay-ui:icon-menu>
	<portlet:actionURL name="deleteStudent" var="deleteURL">
		<portlet:param name="studentId"
			value="<%=String.valueOf(studentObj.getStudentId())%>" />
	</portlet:actionURL>
	
	<portlet:actionURL name="viewBook" var="viewURL">
		<portlet:param name="studentId"
			value="<%=String.valueOf(studentObj.getStudentId())%>" />
	</portlet:actionURL>
	
	<portlet:actionURL  var="updateStudent" name="updateStudent">
		<portlet:param name="studentId"	value="<%=String.valueOf(studentObj.getStudentId())%>" />
	</portlet:actionURL>
	
	<liferay-ui:icon image="view" message="View" url="<%=viewURL.toString()%>" />
	
	<liferay-ui:icon image="view" message="Edit" url="<%=updateStudent.toString()%>" />
	
	<liferay-ui:icon-delete image="delete" message="Delete" url="<%=deleteURL.toString()%>" />

</liferay-ui:icon-menu>
