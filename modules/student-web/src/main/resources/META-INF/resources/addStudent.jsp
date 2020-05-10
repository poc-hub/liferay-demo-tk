<%@ include file="/init.jsp" %>

<!-- <p>
	<b><liferay-ui:message key="studentcontroller.caption"/></b>
</p> -->

  <%-- <%=addStudentURL.toString()%> --%>
  

<portlet:actionURL name="addStudent" var="addStudentURL"></portlet:actionURL>

<aui:form name="fm"  method="post" action="${addStudentURL}">

<!-- <div class="form-group col-md-6">
      <label for="inputEmail4">Email</label>
      <input type="email" class="form-control" id="inputEmail4" placeholder="Email">
    </div> -->

	
	 <div class="form-row">
		 <div class="form-group col-md-6">
			<aui:input type="text"   name="studentName" label="STUDENT NAME" placeholder="Name"/>
		 </div>
		 
		 <div class="form-group col-md-6">
			<aui:input type="text" name="studentNickName" label="STUDENT NICK NAME" placeholder="Nick Name"/>
		 </div>
	</div>
	
	
	 <div class="form-row">
	  	<div class="form-group col-md-12">
			<aui:input type="text" name="studentMobNo" label="STUDENT MOB NO" placeholder="Mobile No"/>
		</div>
	</div>
	
	 <div class="form-row">
	 <div class="form-group col-md-6">
	 <!-- <label>Gender</label>
		<aui:input type="radio"  name="gender"  value="true" checked="true" >Male</aui:input>
		<aui:input  type="radio" name="gender"  value="false" >Female</aui:input>	 -->
		<label>Gender</label>
		<aui:field-wrapper name="Gender">
						<aui:input name="gender" type="radio" label="Male" value="true"></aui:input>
						<aui:input name="gender" type="radio" label="Female" value="false"></aui:input>
		</aui:field-wrapper>
	 </div>
	</div>	
	
	 <div class="form-row">
		 <div class="form-group col-md-6">
			<aui:input type="text" name="studentAge" label="STUDENT AGE" placeholder="Age"/>
		 </div>
		 <div class="form-group col-md-6">
			<aui:input type="date" name="studentDOB" label="STUDENT DOB" placeholder="DOB"/>
		 </div>
	</div>	
	
	
	<!-- <aui:input name="isbn" label="ISBN">
		 <aui:validator name="digits"/>
	</aui:input>
	
	<aui:input name="price" label="Price">
		 <aui:validator name="digits"/>
	</aui:input> -->
	
	
	<aui:button-row>
        <aui:button name="addStudent" type="submit" value="Submit"  />
    </aui:button-row>
		
</aui:form>