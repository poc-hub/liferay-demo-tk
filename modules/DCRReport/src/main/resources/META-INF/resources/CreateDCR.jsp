<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ include file="/init.jsp" %>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>



<portlet:actionURL name="DCRAction" var="submitDCR" />


<%-- <portlet:renderURL var="meetingPopUp" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/meetingPopUp.jsp"/>
</portlet:renderURL> --%>

<portlet:renderURL var="popupUrl" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/meetingPopUp.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="cancelSubmit">
	<portlet:param name="mvcPath" value="/view.jsp"/>
</portlet:renderURL>
<!-- <liferay-ui:success key="success" message="Your Action Completed Successfully..."/> -->

<%-- <portlet:renderURL var=”popupUrl” windowState=”<%=LiferayWindowState.POP_UP.toString() %>”>
<portlet:param name=”mvcPath” value=”/meetingPopUp.jsp”/>
</portlet:renderURL>  --%>

<aui:form name="meetingIndexForm" enctype="multipart/form-data" method="POST" action="${submitDCR}" >
    <div class="row">
        <div class="col-sm">
        
        <aui:input type="text" label="from-dcrNew-project" name="Project" value="<%=LanguageUtil.get(request, "Traditional-Architecture") %>" id="Project" readonly="readonly" style="background-color: #f1f2f5;" />
        
        </div>
        <div class="col-sm">
        <aui:input type="text" label="from-dcrNew-issuer" name="IssuerNew" value="<%= themeDisplay.getUser().getFullName() %>" id="IssuerNew" readonly="readonly" style="background-color: #f1f2f5;"/>
        </div>
        <div class="col-sm">
        
        <aui:input type="text" label="from-dcrNew-createdon" name="Created On" value="<%= formatDate%>" id="Created On" readonly="readonly" style="background-color: #f1f2f5;"/>
        
        </div>
        <div class="col-sm">&nbsp;</div>
    </div>
    <div class="row">
        <div class="col-sm">
         <!-- <p>DESIGN CHANGE RECORD CREATION</p> -->
         <legend><liferay-ui:message key="from-dcrNew-designchangerecordcreation" /></legend>
        </div>
    </div>
    <div class="row">
        <div class="col-sm">
      <!--   <label><liferay-ui:message key="from-dcrIndex-reasonforchange" /></label> -->
        <aui:select  label="from-dcrNew-changetype"  name="ChangeType" id="ChangeType">
						<aui:option value="from-dcrNew-design"><label><liferay-ui:message key="from-dcrNew-design" /></label></aui:option>
						<aui:option value="from-dcrNew-construction"><label><liferay-ui:message key="from-dcrNew-construction" /></label></aui:option>
						<aui:option value="from-dcrNew-facility"><label><liferay-ui:message key="from-dcrNew-facility" /></label></aui:option>
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
        <aui:select label="from-dcrNew-reasonforchange" name="ReasonforChange" id="ReasonforChange" onchange="ReasonforChange()">
						<aui:option value="from-dcrNew-custrequested"><label><liferay-ui:message key="from-dcrNew-custrequested" /></aui:option>
						<aui:option value="from-dcrNew-legal"><label><liferay-ui:message key="from-dcrNew-legal" /></aui:option>
						<aui:option value="from-dcrNew-designimprov"><label><liferay-ui:message key="from-dcrNew-designimprov" /></aui:option>
						<aui:option value="from-dcrNew-consImprov"><label><liferay-ui:message key="from-dcrNew-consImprov" /></aui:option>
						<aui:option value="from-dcrNew-others"><label><liferay-ui:message key="from-dcrNew-others" /></aui:option>
					</aui:select></div>
        <div class="col-sm"><aui:input type="text" label="from-dcrNew-others" name="Others" id="Others "/></div>
        <div class="col-sm">
        <!-- <label><liferay-ui:message key="from-dcrNew-rangeofdisclosure"/></label> -->
        <aui:select label="from-dcrNew-rangeofdisclosure" name="Rangeofdisclosure" id="Rangeofdisclosure">
		<aui:option value="from-internal"><label><liferay-ui:message key="from-internal" /></label></aui:option>
		<aui:option value="from-customer"><label><liferay-ui:message key="from-customer" /></label></aui:option>
		<aui:option value="from-partner"><label><liferay-ui:message key="from-partner" /></label></aui:option>
		
					</aui:select>
		</div>
    </div>

    <div class="row">
        <div class="col-sm">
            <div class="row">
                <div class="col-sm pl-2 pr-2"><label class="control-label">&nbsp;</label>
                    <%-- <aui:button href="${meetingPopUp}" useDialog="true" value="Get Meeting" />	 --%>				
                    <!-- <aui:button type="button" name="GeteetingItem" id="GeteetingItem" value=""	onclick="getMeeting();" /> -->
                    <%-- <aui:button href="${meetingPopUp}" value="Get Meeting" /> --%>
                   <!--  <input type="button" class="btn btn-secondary" value="Get Meeting" onclick="getMeetingData()" /> -->
                    
              <input type="button" class="btn btn-secondary" onclick="javascript:getMeetingData();" value="<%=LanguageUtil.get(request, "from-dcrNew-getmeetingitem") %>" ><!-- <liferay-ui:message key="from-dcrNew-getmeetingitem" /> --></input><br>
                    
                </div>
                <div class="col-sm pl-2 pr-2"><label><liferay-ui:message key="from-dcrNew-meetid" /></label>
                    <input type="text" class="form-control" id="meetingId" name="meetingId" readonly="readonly" style="background-color: #f1f2f5;"></div>
                <div class="col-sm pl-2 pr-2">
                <label><liferay-ui:message key="from-dcrNew-floor" /></label>
                    <input type="text" class="form-control" id="Floor" name="Floor"></div>
                <div class="col-sm pl-2 pr-2"><label><liferay-ui:message key="from-dcrNew-itemdetails" /></label>
                    <input type="text" class="form-control" id="ItemDetails" name="ItemDetails"></div>
            </div>
            <div class="row">
                <div class="col-sm pl-2 pr-2"><label><liferay-ui:message key="from-dcrNew-action" /></label>
                    <input type="text" class="form-control" id="Action" name="Action"></div>
                <div class="col-sm pl-2 pr-2"><!-- <label><liferay-ui:message key="from-dcrNew-expectedduedate" /></label> -->
                    <aui:input type="date"  label="from-dcrNew-expectedduedate" class="form-control" id="ExpectedDueDate" name="ExpectedDueDate"> </aui:input></div>
                <div class="col-sm pl-2 pr-2"><label><liferay-ui:message key="from-dcrNew-personIn" /></label>
                    <input type="text" class="form-control" id="PersoninCharge" name="PersoninCharge"></div>
            </div>
        </div>
        <div class="col-sm">
            <div class="row">
                <div class="col-sm"><aui:input type="textarea" label="from-dcrNew-originaldesign" name="OriginalDesgin" id="OriginalDesgin" >
                  <aui:validator  name="required" errorMessage="Please fill this field"></aui:validator>
                </aui:input></div>
                <div class="col-sm"><aui:input type="textarea" label="from-dcrNew-changedesign" name="ChangeDesgin" id="ChangeDesgin" >
                  <aui:validator  name="required" errorMessage="Please fill this field"></aui:validator>
                </aui:input></div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-sm">
  <!--       <label><liferay-ui:message key="from-dcrNew-changetype" /></label> -->
        <aui:select  label="from-dcrNew-designcosttype" name="DesignCostType" id="DesignCostType">
						<aui:option value="from-dcrNew-increase"><label><liferay-ui:message key="from-dcrNew-increase" /></label></aui:option>
						<aui:option value="from-dcrNew-decrease"><label><liferay-ui:message key="from-dcrNew-decrease" /></label></aui:option>
						<aui:option value="from-dcrNew-none"><label><liferay-ui:message key="from-dcrNew-none" /></label></aui:option>
					</aui:select></div>
        <div class="col-sm">
        	<aui:input type="number" label="from-dcrNew-designcost	" name="DesignCost" id="DesignCost" />
        </div>
        <div class="col-sm">
        <aui:select label="from-dcrNew-constructioncostType" name="ConstructionCostType" id="ConstructionCostType">
        
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
            <aui:button  type="submit" value="from-dcrNew-save"></aui:button>
            <aui:button type="button" onClick="<%=cancelSubmit.toString() %>" value="from-dcrNew-cancel"/>
        </div></div>
        
    </div>

</aui:form>


<script type="text/javascript">

function ReasonforChange(){
	var valuea =document.getElementById('<portlet:namespace />ReasonforChange').value;
	if(valuea == "from-dcrNew-others"){
		document.getElementById('<portlet:namespace />Others').disabled = false;
	}else{
		document.getElementById('<portlet:namespace />Others').disabled = true;
	}
	
}


AUI().ready('aui-module', function(A){
	//document.getElementById('<portlet:namespace />ExpectedDueDate').valueAsDate = new Date();
});


  /*    var popup; */
    function getMeetingData() {
	  console.log("hello am here");
	  /* alert("getMeetingData"); */
        var organizationWindow = window.open('<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="mvcPath" value="/meetingPopUp.jsp"/><portlet:param name="redirect" value="#"/></portlet:renderURL>',
                'title',
               'directories=no, height=600, location=no, menubar=no, resizable=yes,scrollbars=yes, status=no, toolbar=no, width=1280');
               organizationWindow.focus();
    } 
  
</script>