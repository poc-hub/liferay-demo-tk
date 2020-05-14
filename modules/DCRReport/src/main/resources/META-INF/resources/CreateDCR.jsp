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
        <div class="col-sm">
        
        <aui:input type="text" label="from-dcrNew-project" name="Project" value="Takenaka" id="Project" readonly="readonly" />
        
        </div>
        <div class="col-sm">
        <aui:input type="text" label="from-dcrNew-issuer" name="Issuer" value="<%= themeDisplay.getUser().getScreenName() %>" id="Issuer" readonly="readonly" />
        </div>
        <div class="col-sm">
        
        <aui:input type="text" label="from-dcrNew-createdon" name="Created On" value="<%= formatDate%>" id="Created On" readonly="readonly" />
        
        </div>
        <div class="col-sm">&nbsp;</div>
    </div>
    <div class="row">
        <div class="col-sm">
        <!-- <p>DESIGN CHANGE RECORD CREATION</p> -->
        <label><liferay-ui:message key="from-dcrNew-designchangerecordcreation" /></label>
        </div>
    </div>
    <div class="row">
        <div class="col-sm">
      <!--   <label><liferay-ui:message key="from-dcrIndex-reasonforchange" /></label> -->
        <aui:select  label="from-dcrIndex-reasonforchange"  name="ChangeType" id="ChangeType">
						<aui:option value="from-dcrNew-design"><label><liferay-ui:message key="from-dcrNew-design" /></label></aui:option>
						<aui:option value="from-dcrNew-construction"><label><liferay-ui:message key="from-dcrNew-construction" /></label></aui:option>
						<aui:option value="from-dcrNew-facility"><label><liferay-ui:message key="from-dcrIndex-reasonforchange" /></label></aui:option>
					</aui:select></div>
        <div class="col-sm">
        <!-- <label><liferay-ui:message key="from-dcrIndex-changerequestedby" /></label> -->
        <aui:select label="from-dcrIndex-changerequestedby" name="ChangeRequestedBy" id="ChangeRequestedBy">
						<aui:option value="from-customer"><label><liferay-ui:message key="from-customer" /></label></aui:option>
						<aui:option value="from-partner"><label><liferay-ui:message key="from-partner" /></label></aui:option>
						<aui:option value="from-internal"><label><liferay-ui:message key="from-internal" /></label></aui:option>
					</aui:select></div>
        <div class="col-sm">
        <!-- <label><liferay-ui:message key="from-dcrNew-reasonforchange" /></label> -->
        <aui:select label="from-dcrNew-reasonforchange" name="ReasonforChange" id="ReasonforChange" onchange="otherField()">
						<aui:option value="from-dcrNew-custrequested"><label><liferay-ui:message key="from-dcrNew-custrequested" /></aui:option>
						<aui:option value="from-dcrNew-legal"><label><liferay-ui:message key="from-dcrNew-legal" /></aui:option>
						<aui:option value="from-dcrNew-designimprov"><label><liferay-ui:message key="from-dcrNew-designimprov" /></aui:option>
						<aui:option value="from-dcrNew-consImprov"><label><liferay-ui:message key="from-dcrNew-consImprov" /></aui:option>
						<aui:option value="from-dcrNew-others"><label><liferay-ui:message key="from-dcrNew-others" /></aui:option>
					</aui:select></div>
        <div class="col-sm"><input type="text" label="from-dcrNew-others" name="Others" id="Others" disabled/></div>
        <div class="col-sm">
        <!-- <label><liferay-ui:message key="from-dcrNew-rangeofdisclosure"/></label> -->
        <aui:select label="from-dcrNew-rangeofdisclosure" name="Rangeofdisclosure" id="Rangeofdisclosure">
		<aui:option value="from-customer"><label><liferay-ui:message key="from-customer" /></label></aui:option>
		<aui:option value="from-partner"><label><liferay-ui:message key="from-partner" /></label></aui:option>
		<aui:option value="from-internal"><label><liferay-ui:message key="from-internal" /></label></aui:option>
					</aui:select>
		</div>
    </div>

    <div class="row">
        <div class="col-sm">
            <div class="row">
                <div class="col-sm"><label class="control-label">&nbsp;</label>
                    <%-- <aui:button href="${meetingPopUp}" useDialog="true" value="Get Meeting" />	 --%>				
                    <!-- <aui:button type="button" name="GeteetingItem" id="GeteetingItem" value=""	onclick="getMeeting();" /> -->
                    <%-- <aui:button href="${meetingPopUp}" value="Get Meeting" /> --%>
                    <input type="button" class="btn btn-secondary" value="Get Meeting" onclick="getMeetingData()" />
                </div>
                <div class="col-sm"><label><liferay-ui:message key="from-dcrNew-meetid" /></label>
                    <input type="text" class="form-control" id="meetingId" name="meetingId"></div>
                <div class="col-sm">
                <label><liferay-ui:message key="from-dcrNew-floor" /></label>
                    <input type="text" class="form-control" id="Floor" name="Floor"></div>
                <div class="col-sm"><label><liferay-ui:message key="from-dcrNew-itemdetails" /></label>
                    <input type="text" class="form-control" id="ItemDetails" name="ItemDetails"></div>
            </div>
            <div class="row">
                <div class="col-sm"><label><liferay-ui:message key="from-dcrNew-action" /></label>
                    <input type="text" class="form-control" id="Action" name="Action"></div>
                <div class="col-sm"><label><liferay-ui:message key="from-dcrNew-expectedduedate" /></label>
                    <input type="text" class="form-control" id="ExpectedDueDate" name="ExpectedDueDate"></div>
                <div class="col-sm"><label><liferay-ui:message key="from-dcrNew-personIn" /></label>
                    <input type="text" class="form-control" id="PersoninCharge" name="PersoninCharge"></div>
            </div>
        </div>
        <div class="col-sm">
            <div class="row">
                <div class="col-sm"><aui:input type="textarea" label="from-dcrNew-originaldesign" name="OriginalDesgin" id="OriginalDesgin" >
                <aui:validator  name="required" errorMessage="Please fill this field"></aui:validator>
                </aui:input></div>
                <div class="col-sm"><aui:input type="textarea" label="from-dcrNew-changedesign" 
                name="ChangeDesgin" id="ChangeDesgin" >
                <aui:validator  name="required" errorMessage="Please fill this field"> </aui:validator>
                </aui:input></div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-sm">
  <!--       <label><liferay-ui:message key="from-dcrNew-changetype" /></label> -->
        <aui:select  label="from-dcrNew-changetype" name="DesignCostType" id="DesignCostType">
						<aui:option value="from-dcrNew-increase"><label><liferay-ui:message key="from-dcrNew-increase" /></label></aui:option>
						<aui:option value="from-dcrNew-decrease"><label><liferay-ui:message key="from-dcrNew-decrease" /></label></aui:option>
						<aui:option value="from-dcrNew-none"><label><liferay-ui:message key="from-dcrNew-none" /></label></aui:option>
					</aui:select></div>
        <div class="col-sm">
        	<aui:input type="number" label="from-dcrNew-designcost	" name="DesignCost" id="DesignCost" />
        </div>
        <div class="col-sm">
        <aui:select label="Construction Cost Type" name="ConstructionCostType" id="ConstructionCostType">
        
			<aui:option value="from-dcrNew-increase"><label><liferay-ui:message key="from-dcrNew-increase" /></label></aui:option>
			<aui:option value="from-dcrNew-decrease"><label><liferay-ui:message key="from-dcrNew-decrease" /></label></aui:option>
			<aui:option value="from-dcrNew-none"><label><liferay-ui:message key="from-dcrNew-none" /></label></aui:option>
		</aui:select>
		</div>
        <div class="col-sm">
        	<aui:input type="number" label="from-dcrNew-constructioncost" name="ConstructionCost" id="ConstructionCost" />
        </div>
        <div class="col-sm">
        <!--  <label><liferay-ui:message key="from-dcrNew-expensepayment" /></label> -->
        <aui:select label="from-dcrNew-expensepayment" name="ExpensePayment" id="ExpensePayment">
			<aui:option value="from-dcrNew-yes"><label><liferay-ui:message key="from-dcrNew-yes" /></label></aui:option>
			<aui:option value="from-dcrNew-no"><label><liferay-ui:message key="from-dcrNew-no" /></label></aui:option>
		</aui:select>
		</div>
    </div>

    <div class="row">
        <div class="col-sm"><aui:input type="file" label="from-dcrNew-attachment1" name="Attachment1" id="Attachment1" /></div>
        <div class="col-sm"><aui:input type="file" label="from-dcrNew-attachment3" name="Attachment3" id="Attachment3" /></div>
    </div>
    <div class="row">
        <div class="col-sm"><aui:input type="file" label="from-dcrNew-attachment2" name="Attachment2" id="Attachment2 " /></div>
        <div class="col-sm"><aui:input type="file" label="from-dcrNew-attachment4" name="Attachment4" id="Attachment4" /></div>
    </div>

    <div class="row">
        <div class="col-sm"><div class="form-group">
            <button class="btn btn-primary" type="button">Submit</button>
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
 function otherField() {
    	var value = document.getElementById("<portlet:namespace/>ReasonforChange").value;
    	alert(value);
    	if(value == "from-dcrNew-others"){
    		 document.getElementById("Others").removeAttribute("disabled");
    		  }
    	else{
    		document.getElementById(Others).disabled= true;
    	}
    	}
</script>