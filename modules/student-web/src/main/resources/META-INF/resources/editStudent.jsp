<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.student.service.service.StudentLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.student.service.model.Student"%>
<%@ include file="/init.jsp" %>

<!-- <p>
	<b><liferay-ui:message key="studentcontroller.caption"/></b>
</p> -->

  <%-- <%=addStudentURL.toString()%> --%>
 	 <%
		long id = Long.parseLong(request.getParameter("studentId"));
 	    System.out.print("idddddddddddd"+id);
  		Student studentObj= StudentLocalServiceUtil.getStudent(id);
	%>
  
 <portlet:actionURL name="updateStudent" var="updateStudentURL"></portlet:actionURL>

<aui:form name="fmm"  method="post" action="${updateStudentURL}">

<!-- <div class="form-group col-md-6">
      <label for="inputEmail4">Email</label>
      <input type="email" class="form-control" id="inputEmail4" placeholder="Email">
    </div> -->
	 <aui:input type="hidden"   name="studentId"  value="<%=studentObj.getStudentId() %>"/>
	
	 <div class="form-row">
		 <div class="form-group col-md-6">
			<aui:input type="text"   name="studentName" label="STUDENT NAME" value="<%=studentObj.getStudentName() %>"/>
		 </div>
		 
		 <div class="form-group col-md-6">
			<aui:input type="text" name="studentNickName" label="STUDENT NICK NAME" value="<%=studentObj.getStudentNickName() %>"/>
		 </div>
	</div>
	
	
	 <div class="form-row">
	  	<div class="form-group col-md-12">
			<aui:input type="text" name="studentMobNo" label="STUDENT MOB NO" value="<%=studentObj.getStudentMobNo() %>"/>
		</div>
	</div>
	
	 <div class="form-row">
	 <div class="form-group col-md-6">
	 <!-- <label>Gender</label>
		<aui:input type="radio"  name="gender"  value="true" checked="true" >Male</aui:input>
		<aui:input  type="radio" name="gender"  value="false" >Female</aui:input>	 -->
		<label>Gender</label>
		<aui:field-wrapper name="Gender">
										
			<%if(studentObj.getStudentGender() == true){%>
			<aui:input name="Gender" type="radio" label="Male" value="true" checked="true"></aui:input>
			<aui:input name="Gender" type="radio" label="Female" value="false"></aui:input>
			<% }
			else{%>
			<aui:input name="Gender" type="radio" label="Male" value="true" ></aui:input>
			<aui:input name="Gender" type="radio" label="Female" value="false" checked="true"></aui:input>
			<% }%>
			
		</aui:field-wrapper>
	 </div>
	</div>	
	
	 <div class="form-row">
		 <div class="form-group col-md-6">
			<aui:input type="text" name="studentAge" label="STUDENT AGE" value="<%=studentObj.getStudentAge()%>"/>
		 </div>
		 <div class="form-group col-md-6">
		 <%
		/*  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		 Date parsed =  new Date(studentObj.getStudentDOB());
		 System.out.print(studentObj.getStudentDOB());
		 
		 Date formatt = studentObj.getStudentDOB();
		 format= studentObj.getStudentDOB();
		 System.out.print("dsfffsfddd" +formatt); */
		 
		 //Date dob = new SimpleDateFormat("yyyy-MM-dd").parse(studentObj.getStudentDOB());
		 %>
		 
			<aui:input type="text" name="studentDOB" label="STUDENT DOB" value="<%=studentObj.getStudentDOB() %>"/>
			
			
		 </div>
	</div>	
	
	
	
	
	
	
	<!-- <aui:input name="isbn" label="ISBN">
		 <aui:validator name="digits"/>
	</aui:input>
	
	<aui:input name="price" label="Price">
		 <aui:validator name="digits"/>
	</aui:input> -->
	
	
	<aui:button-row>
        <aui:button name="addStudent" type="submit" value="Update"  />
    </aui:button-row>
		
</aui:form>