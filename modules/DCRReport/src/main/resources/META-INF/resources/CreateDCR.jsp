<%@ include file="/init.jsp" %>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<portlet:actionURL name="DCRAction" var="submitDCR" />


<%-- <portlet:renderURL var="meetingPopUp" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/meetingPopUp.jsp"/>
</portlet:renderURL> --%>
<portlet:renderURL var="meetingPopUp">
    <portlet:param name="mvcPath" value="/meetingPopUp.jsp"></portlet:param>
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
    <div class="row">
        <div class="col-sm"><aui:input type="text" label="Project" name="Project" value="Takenaka" id="Project" readonly="readonly" /></div>
        <div class="col-sm"><aui:input type="text" label="Issuer" name="Issuer" value="<%= themeDisplay.getUser().getScreenName() %>" id="Issuer" readonly="readonly" /></div>
        <div class="col-sm"><aui:input type="text" label="Created On" name="Created On" value="<%= formatDate%>" id="Created On" readonly="readonly" /></div>
        <div class="col-sm">&nbsp;</div>
    </div>
    <div class="row">
        <div class="col-sm"><p>DESIGN CHANGE RECORD CREATION</p></div>
    </div>
    <div class="row">
        <div class="col-sm"><aui:select label="Change Type" name="ChangeType" id="ChangeType">
						<aui:option value="Design">Design</aui:option>
						<aui:option value="Construction">Construction</aui:option>
						<aui:option value="Facility">Facility</aui:option>
					</aui:select></div>
        <div class="col-sm"><aui:select label="Change Requested By" name="ChangeRequestedBy" id="ChangeRequestedBy">
						<aui:option value="Customer">Customer</aui:option>
						<aui:option value="Patner">Patner</aui:option>
						<aui:option value="Internal">Internal</aui:option>
					</aui:select></div>
        <div class="col-sm"><aui:select label="Reason for Change" name="ReasonforChange" id="ReasonforChange">
						<aui:option value="Customer">Customer Requested</aui:option>
						<aui:option value="Patner">Legal/Government</aui:option>
						<aui:option value="Internal">Design Improvement</aui:option>
						<aui:option value="Patner">Construction Improvement</aui:option>
						<aui:option value="Internal">Others</aui:option>
					</aui:select></div>
        <div class="col-sm"><aui:input type="text" label="Others" name="Others" id="Others" /></div>
        <div class="col-sm"><aui:select label="Range of disclosure" name="Rangeofdisclosure" id="Rangeofdisclosure">
						<aui:option value="Customer">Customer</aui:option>
						<aui:option value="Patner">Patner</aui:option>
						<aui:option value="Internal">Internal</aui:option>
					</aui:select></div>
    </div>

    <div class="row">
        <div class="col-sm">
            <div class="row">
                <div class="col-sm"><label class="control-label">&nbsp;</label>
                    <%-- <aui:button href="${meetingPopUp}" useDialog="true" value="Get Meeting" />	 --%>				
                    <!-- <aui:button type="button" name="GeteetingItem" id="GeteetingItem" value=""	onclick="getMeeting();" /> -->
                    <%-- <aui:button href="${meetingPopUp}" value="Get Meeting" /> --%>
                    <input type="button" value="Get Meeting" onclick="getMeetingData()" /><br>
                </div>
                <div class="col-sm"><label for="usr">Meeting Id</label>
                    <input type="text" class="form-control" id="meetingId" name="meetingId"></div>
                <div class="col-sm"><label for="usr">Floor</label>
                    <input type="text" class="form-control" id="Floor" name="Floor"></div>
                <div class="col-sm"><label for="usr">Item Details</label>
                    <input type="text" class="form-control" id="ItemDetails" name="ItemDetails"></div>
            </div>
            <div class="row">
                <div class="col-sm"><label for="usr">Action</label>
                    <input type="text" class="form-control" id="Action" name="Action"></div>
                <div class="col-sm"><label for="usr">Expected DueDate</label>
                    <input type="text" class="form-control" id="ExpectedDueDate" name="ExpectedDueDate"></div>
                <div class="col-sm"><label for="usr">Personin Charge</label>
                    <input type="text" class="form-control" id="PersoninCharge" name="PersoninCharge"></div>
            </div>
        </div>
        <div class="col-sm">
            <div class="row">
                <div class="col-sm"><aui:input type="textarea" label="Original Desgin" name="OriginalDesgin" id="OriginalDesgin" /></div>
                <div class="col-sm"><aui:input type="textarea" label="Change Desgin" name="ChangeDesgin" id="ChangeDesgin" /></div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-sm"><aui:select label="Design Cost Type" name="DesignCostType" id="DesignCostType">
						<aui:option value="Increase">Increase</aui:option>
						<aui:option value="Decrease">Decrease</aui:option>
						<aui:option value="None">None</aui:option>
					</aui:select></div>
        <div class="col-sm"><aui:input type="number" label="Design Cost" name="DesignCost" id="DesignCost" /></div>
        <div class="col-sm"><aui:select label="Construction Cost Type" name="ConstructionCostType" id="ConstructionCostType">
						<aui:option value="Increase">Increase</aui:option>
						<aui:option value="Decrease">Decrease</aui:option>
						<aui:option value="None">None</aui:option>
					</aui:select></div>
        <div class="col-sm"><aui:input type="number" label="Construction Cost" name="ConstructionCost" id="ConstructionCost" /></div>
        <div class="col-sm"><aui:select label="Expense Payment" name="ExpensePayment" id="ExpensePayment">
						<aui:option value="Yes">Yes</aui:option>
						<aui:option value="No">No</aui:option>
					</aui:select></div>
    </div>

    <div class="row">
        <div class="col-sm"><aui:input type="file" label="Attachment1" name="Attachment1" id="Attachment1" /></div>
        <div class="col-sm"><aui:input type="file" label="Attachment3" name="Attachment3" id="Attachment3" /></div>
    </div>
    <div class="row">
        <div class="col-sm"><aui:input type="file" label="Attachment2" name="Attachment2" id="Attachment2 " /></div>
        <div class="col-sm"><aui:input type="file" label="Attachment4" name="Attachment4" id="Attachment4" /></div>
    </div>

    <div class="row">
        <div class="col-sm"><div class="form-group">
            <button class="btn btn-primary type="button">Submit</button>
        </div></div>
    </div>

</form>

<script type="text/javascript">
    var popup;
    function getMeetingData() {
   	 // alert("getMeetingData");
           var organizationWindow = window.open('<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="mvcPath" value="/meetingPopUp.jsp"/><portlet:param name="redirect" value="#"/></portlet:renderURL>',
                   'title',
                  'directories=no, height=600, location=no, menubar=no, resizable=yes,scrollbars=yes, status=no, toolbar=no, width=1280');
                  organizationWindow.focus();
       }
</script>