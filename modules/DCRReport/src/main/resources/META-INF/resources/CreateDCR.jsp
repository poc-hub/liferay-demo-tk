<%@ include file="/init.jsp" %>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<portlet:actionURL name="DCRAction" var="submitDCR" />


<portlet:renderURL var="meetingPopUp" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/meetingPopUp.jsp"/>
</portlet:renderURL>

<liferay-ui:success key="success" message="Your Action Completed Successfully..."/>

<%-- <portlet:renderURL var=”popupUrl” windowState=”<%=LiferayWindowState.POP_UP.toString() %>”>
<portlet:param name=”mvcPath” value=”/meetingPopUp.jsp”/>
</portlet:renderURL>  --%>

<aui:script>
function getMeeting(){
alert("Calling getMeeting");
<%-- AUI().use('aui-base', function(A) {
A.one('#<portlet:namespace />GeteetingItem').on('click', function(event){
AUI().use('aui-dialog', 'aui-io', function(A) {
    var dialog = new A.Dialog({
    title: 'Upload Details',
    centered: true,
    modal: true,
    width: 500,
    height: 400,
    }).plug(A.Plugin.IO, {uri: '<%=popupUrl%>'}).render();

});
});
});
  --%>
 }</aui:script>

<form name="meetingIndexForm" action="${submitDCR}" method="POST">
<aui:input type="text" label="Project" name="Project" value="Takenaka" id="Project" readonly="readonly" />
<aui:input type="text" label="Issuer" name="Issuer" value="<%= themeDisplay.getUser().getScreenName() %>" id="Issuer" readonly="readonly" />
<aui:input type="text" label="Created On" name="Created On" value="<%= formatDate%>" id="Created On" readonly="readonly" />
<p>DESIGN CHANGE RECORD CREATION</p>

<aui:select label="Change Type" name="ChangeType" id="ChangeType">
						<aui:option value="Design">Design</aui:option>
						<aui:option value="Construction">Construction</aui:option>
						<aui:option value="Facility">Facility</aui:option>
					</aui:select>
<aui:select label="Change Requested By" name="ChangeRequestedBy" id="ChangeRequestedBy">
						<aui:option value="Customer">Customer</aui:option>
						<aui:option value="Patner">Patner</aui:option>
						<aui:option value="Internal">Internal</aui:option>
					</aui:select>
<aui:select label="Reason for Change" name="ReasonforChange" id="ReasonforChange">
						<aui:option value="Customer">Customer Requested</aui:option>
						<aui:option value="Patner">Legal/Government</aui:option>
						<aui:option value="Internal">Design Improvement</aui:option>
						<aui:option value="Patner">Construction Improvement</aui:option>
						<aui:option value="Internal">Others</aui:option>
					</aui:select>
<aui:input type="text" label="Others" name="Others" id="Others" />
<aui:select label="Range of disclosure" name="Rangeofdisclosure" id="Rangeofdisclosure">
						<aui:option value="Customer">Customer</aui:option>
						<aui:option value="Patner">Patner</aui:option>
						<aui:option value="Internal">Internal</aui:option>
					</aui:select>
<aui:button href="${meetingPopUp}" useDialog="true" value="Get Meeting Item" />					
<!-- <aui:button type="button" name="GeteetingItem" id="GeteetingItem" value=""	onclick="getMeeting();" /> -->

<aui:input type="text" label="MeetID" name="MeetID" id="MeetID" value="ABCD" readonly="readonly"/>
<aui:input type="text" label="Floor" name="Floor" id="Floor" />
<aui:input type="text" label="Item Details" name="ItemDetails" id="ItemDetails" />
<aui:input type="text" label="Action" name="Action" id="Action" />
<aui:input type="date" label="Expected Due Date" name="ExpectedDueDate" id="ExpectedDueDate" />
<aui:input type="text" label="Person in Charge" name="PersoninCharge" id="PersoninCharge " />
<aui:input type="textarea" label="Original Desgin" name="OriginalDesgin" id="OriginalDesgin" />
<aui:input type="textarea" label="Change Desgin" name="ChangeDesgin" id="ChangeDesgin" />
<aui:select label="Design Cost Type" name="DesignCostType" id="DesignCostType">
						<aui:option value="Increase">Increase</aui:option>
						<aui:option value="Decrease">Decrease</aui:option>
						<aui:option value="None">None</aui:option>
					</aui:select>
<aui:input type="number" label="Design Cost" name="DesignCost" id="DesignCost" />
<aui:select label="Construction Cost Type" name="ConstructionCostType" id="ConstructionCostType">
						<aui:option value="Increase">Increase</aui:option>
						<aui:option value="Decrease">Decrease</aui:option>
						<aui:option value="None">None</aui:option>
					</aui:select>
<aui:input type="number" label="Construction Cost" name="ConstructionCost" id="ConstructionCost" />
<aui:select label="Expense Payment" name="ExpensePayment" id="ExpensePayment">
						<aui:option value="Yes">Yes</aui:option>
						<aui:option value="No">No</aui:option>
					</aui:select>

<aui:input type="file" label="Attachment1" name="Attachment1" id="Attachment1" />
<aui:input type="file" label="Attachment2" name="Attachment2" id="Attachment2 " />
<aui:input type="file" label="Attachment3" name="Attachment3" id="Attachment3" />
<aui:input type="file" label="Attachment4" name="Attachment4" id="Attachment4" />

<div class="form-group">
							<button class="btn btn-primary type="button">Submit</button>
						</div>



</form>

<%-- <portlet:actionURL var="uplaodURL" name="uploadDocument"></portlet:actionURL>
<portlet:actionURL var="downloadURL" name="downloadFiles"></portlet:actionURL>

<b>Please Upload a Document</b> 

<form action="${uplaodURL}" method="post" enctype="multipart/form-data">
<input type="file" name="uploadedFile">
<input type="Submit" name="Submit">
</form>

<a href="${downloadURL}">Download Files</a> --%>

