<%@page import="java.util.List"%>
<%@page import="com.liferay.document.library.kernel.model.DLFolderConstants"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.repository.model.Folder"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.document.library.kernel.util.DLUtil"%>
<%@page import="javax.portlet.PortletSession"%>
<%@page import="com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.document.library.kernel.model.DLFileEntry"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.liferay.document.library.kernel.service.DLAppServiceUtil"%>
<%@page import="java.io.File"%>
<%@page import="com.takenaka.service.DesignChangeDetailsLocalServiceUtil"%>
<%@page import="com.takenaka.model.DesignChangeDetails"%>
<%@ include file="/init.jsp" %>

<%
String ROOT_FOLDER_NAME = "File_Upload";
String ROOT_FOLDER_DESCRIPTION = "Test Descprition";
long PARENT_FOLDER_ID = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
long chngSeqNo=Long.parseLong(request.getParameter("chngSeqNo"));
DesignChangeDetails dcd=DesignChangeDetailsLocalServiceUtil.fetchDesignChangeDetails(chngSeqNo);
String chngSeqNoStr=Long.toString(chngSeqNo);
String[] Urls={"","","",""};
String[] filenames={"","","",""};
//ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
try{
	Folder folder=DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), PARENT_FOLDER_ID, ROOT_FOLDER_NAME);

	long array[]=new long[4];

	array[0]=dcd.getAttachmentId1();
	array[1]=dcd.getAttachmentId2();
	array[2]=dcd.getAttachmentId3();
	array[3]=dcd.getAttachmentId4();

	
	int i=0;
	List<FileEntry> fileEntry=DLAppServiceUtil.getFileEntries(themeDisplay.getScopeGroupId(), folder.getFolderId());



	for(FileEntry file:fileEntry){
		//if(file.getFileEntryId()==arra){
			//Urls[i]=DLUtil.getPreviewURL(file, file.getFileVersion(), themeDisplay, "");
			//i++;
		//}
		for(int j=0;j<array.length;j++){
			if(file.getFileEntryId()==array[j]){
				String temp=file.getFileName();
				int index=temp.indexOf('_');
				filenames[i]=temp.substring(index+1);
				Urls[i]=DLUtil.getPreviewURL(file, file.getFileVersion(), themeDisplay, "");
				i++;
			}
		}
	}
}catch(Exception e){
	System.out.println("FOlder not found");
}
//DLUtil.getPreviewURL(fileEntry, fileVersion, themeDisplay, queryString);




%>
<portlet:actionURL name="submitApprovall" var="submitApprovallURL">
	<portlet:param name="chngSeqNo" value="<%=chngSeqNoStr %>"/>
</portlet:actionURL>

<portlet:renderURL var="viewDCR">
	<portlet:param name="mvcPath" value="/view.jsp"/>
</portlet:renderURL> 
<script type="text/javascript">
<!--

//-->
AUI().ready('aui-module', function(A){
	
	document.getElementById('<portlet:namespace />ApprovalDate').valueAsDate = new Date();
	document.getElementById('<portlet:namespace />CustomerDate').valueAsDate = new Date();
	
});
</script>

<aui:form name="meetingIndexForm" method="POST" action="${submitApprovallURL}" >
   <fieldset disabled="disabled" id="fieldSet">
    <div class="row">
        <div class="col-sm">
          <label><liferay-ui:message key="from-dcrNew-designchangerecordcreation" /></label>
          </div>
          </div>
          <div class="row">
        <div class="col-sm">
         <aui:select  label="from-dcrview-changetype"  name="ChangeType" id="ChangeType" value="<%=dcd.getChangeType() %>"> <!-- value="< %=designChangeDetails.getChangeType() %>" -->
						<aui:option value="from-dcrNew-design"><label><liferay-ui:message key="from-dcrNew-design" /></label></aui:option>
						<aui:option value="from-dcrNew-construction"><label><liferay-ui:message key="from-dcrNew-construction" /></label></aui:option>
						<aui:option value="from-dcrNew-facility"><label><liferay-ui:message key="from-dcrNew-facility" /></label></aui:option>
					</aui:select>
		</div>
		  <div class="col-sm">
        <!-- <label><liferay-ui:message key="from-dcrIndex-changerequestedby" /></label> -->
        <aui:select label="from-dcrIndex-changerequestedby" name="ChangeRequestedBy" id="ChangeRequestedBy" value="<%=dcd.getChangeRequestby() %>"> <!-- value="< %=designChangeDetails.getChangeRequestby() %>" -->
						<aui:option value="from-customer"><label><liferay-ui:message key="from-customer" /></label></aui:option>
						<aui:option value="from-partner"><label><liferay-ui:message key="from-partner" /></label></aui:option>
						<aui:option value="from-internal"><label><liferay-ui:message key="from-internal" /></label></aui:option>
					</aui:select>
		</div>
		 <div class="col-sm">
        <!-- <label><liferay-ui:message key="from-dcrNew-reasonforchange" /></label> -->
        <aui:select label="from-dcrNew-reasonforchange" name="ReasonforChange" id="ReasonforChange" value="<%=dcd.getRfcId() %>" > <!-- value="< %=designChangeDetails.getRfcId() %>" -->
						<aui:option value="from-dcrNew-custrequested"><label><liferay-ui:message key="from-dcrNew-custrequested" /></aui:option>
						<aui:option value="from-dcrNew-legal"><label><liferay-ui:message key="from-dcrNew-legal" /></aui:option>
						<aui:option value="from-dcrNew-designimprov"><label><liferay-ui:message key="from-dcrNew-designimprov" /></aui:option>
						<aui:option value="from-dcrNew-consImprov"><label><liferay-ui:message key="from-dcrNew-consImprov" /></aui:option>
						<aui:option value="from-dcrNew-others"><label><liferay-ui:message key="from-dcrNew-others" /></aui:option>
					</aui:select>
		</div>
		 <div class="col-sm"><aui:input type="text" label="from-dcrNew-others" name="Others" id="Others" disabled="true" value="<%=dcd.getRfcOthers() %>" /></div>
		  <div class="col-sm">
        <!-- <label><liferay-ui:message key="from-dcrNew-rangeofdisclosure"/></label> -->
        <aui:select label="from-dcrNew-rangeofdisclosure" name="Rangeofdisclosure" id="Rangeofdisclosure" value="<%=dcd.getRangeOfDisclosure() %>">
		<aui:option value="from-internal"><label><liferay-ui:message key="from-internal" /></label></aui:option>
		<aui:option value="from-customer"><label><liferay-ui:message key="from-customer" /></label></aui:option>
		<aui:option value="from-partner"><label><liferay-ui:message key="from-partner" /></label></aui:option>
		
					</aui:select>
		</div>
		</div>
		<div class="row">
        <div class="col-sm">
            <div class="row">
             <div class="col-sm"><label><liferay-ui:message key="from-dcrNew-meetid" /></label>
                    <input type="text" class="form-control" id="meetingId" name="meetingId" readonly="readonly" value="<%=dcd.getMeetingId()%>"></div>
                <div class="col-sm">
                <label><liferay-ui:message key="from-dcrNew-floor" /></label>
                    <input type="text" class="form-control" id="Floor" name="Floor" value="<%=dcd.getFloor()%>"></div>
                <div class="col-sm"><label><liferay-ui:message key="from-dcrNew-itemdetails" /></label>
                    <input type="text" class="form-control" id="ItemDetails" name="ItemDetails" value="<%=dcd.getItem() %>"></div>
            </div>
             <div class="row">
                <div class="col-sm"><label><liferay-ui:message key="from-dcrNew-action" /></label>
                    <input type="text" class="form-control" id="Action" name="Action" value="<%=dcd.getAction()%>"></div>
                <div class="col-sm"><label><liferay-ui:message key="from-dcrNew-expectedduedate" /></label>
                    <input type="text" class="form-control" id="ExpectedDueDate" name="ExpectedDueDate" value="<%=dcd.getResponsePeriod()%>"></div>
                <div class="col-sm"><label><liferay-ui:message key="from-dcrNew-personIn" /></label>
                    <input type="text" class="form-control" id="PersoninCharge" name="PersoninCharge" value="<%=dcd.getPersonInCharge()%>"></div>
            </div>
        </div>
         <div class="col-sm">
            <div class="row">
                <div class="col-sm"><aui:input type="textarea" label="from-dcrNew-originaldesign" name="OriginalDesgin" id="OriginalDesgin" value="<%=dcd.getOriginaldesginDetail() %>" >
                <aui:validator  name="required" errorMessage="Please fill this field"></aui:validator>
                </aui:input></div>
                <div class="col-sm"><aui:input type="textarea" label="from-dcrNew-changedesign" name="ChangeDesgin" id="ChangeDesgin" value="<%=dcd.getChangeDetail() %>" >
                <aui:validator  name="required" errorMessage="Please fill this field"></aui:validator>
                </aui:input></div>
            </div>
        </div>
        </div>
         <div class="row">
        <div class="col-sm">
  <!--       <label><liferay-ui:message key="from-dcrNew-changetype" /></label> -->
        <aui:select  label="from-dcrNew-designcosttype" name="DesignCostType" id="DesignCostType" value="<%=dcd.getEstdesignCosttype() %>">
						<aui:option value="from-dcrNew-increase"><label><liferay-ui:message key="from-dcrNew-increase" /></label></aui:option>
						<aui:option value="from-dcrNew-decrease"><label><liferay-ui:message key="from-dcrNew-decrease" /></label></aui:option>
						<aui:option value="from-dcrNew-none"><label><liferay-ui:message key="from-dcrNew-none" /></label></aui:option>
					</aui:select></div>
        <div class="col-sm">
        	<aui:input type="number" label="from-dcrNew-designcost	" name="DesignCost" id="DesignCost" value="<%=dcd.getEstdesignCost() %>"/>
        </div>
        <div class="col-sm">
        <aui:select label="from-dcrNew-constructioncostType" name="ConstructionCostType" id="ConstructionCostType" value="<%=dcd.getEstconstructionCosttype() %>">
        
			<aui:option value="from-dcrNew-increase"><label><liferay-ui:message key="from-dcrNew-increase" /></label></aui:option>
			<aui:option value="from-dcrNew-decrease"><label><liferay-ui:message key="from-dcrNew-decrease" /></label></aui:option>
			<aui:option value="from-dcrNew-none"><label><liferay-ui:message key="from-dcrNew-none" /></label></aui:option>
		</aui:select>
		</div>
		 <div class="col-sm">
        	<aui:input type="number" label="from-dcrNew-constructioncost" name="ConstructionCost" id="ConstructionCost" value="<%=dcd.getEstconstructionCost() %>" />
        </div>
        <div class="col-sm">
        <!--  <label><liferay-ui:message key="from-dcrNew-expensepayment" /></label> -->
        <aui:select label="from-dcrNew-expensepayment" name="ExpensePayment" id="ExpensePayment" value="<%=dcd.getExpenseAjustmentDivision() %>">
			<aui:option value="from-dcrNew-yes"><label><liferay-ui:message key="from-dcrNew-yes" /></label></aui:option>
			<aui:option value="from-dcrNew-no"><label><liferay-ui:message key="from-dcrNew-no" /></label></aui:option>
		</aui:select>
		</div>
    </div>
    </fieldset>
      <label><liferay-ui:message key="from-itemapproval-attachedFiles" /></label>
	<div class="row">
 
       <div class="col-sm">
     	<a href="<%=Urls[0] %>"><%=filenames[0] %></a>
     </div>
       <div class="col-sm">
     <a href="<%=Urls[1] %>"><%=filenames[1] %></a>
     </div>
     
      
      <div class="col-sm">
      <a href="<%=Urls[2] %>"><%=filenames[2] %></a>
     </div>
       <div class="col-sm">
     <a href="<%=Urls[3] %>"><%=filenames[3] %></a>
     </div>
     
	</div>
     <div class="row">
      <div class="col-sm">
     <aui:input type="number" name="Approval number" label="from-itemapproval-approvalno" readonly="readonly" value="<%=dcd.getApprovalNo() %>" style="background-color: #f1f2f5;"></aui:input>
     </div>


		<%
			if(null == dcd.getApprovalStatus() || "" == dcd.getApprovalStatus()) {
		%>
		<div class="col-sm">
			<aui:select label="from-itemapproval-approval" name="Approval"
				id="Approval">
				<aui:option value="Approved-key">
					<label><liferay-ui:message key="Approved-key" /></label>
				</aui:option>
				<aui:option value="Cancel-key">
					<label><liferay-ui:message key="Cancel-key" /></label>
				</aui:option>
			</aui:select>
		</div>
		<%
			} else {
		%>
		<div class="col-sm">
			<aui:select label="from-itemapproval-approval" name="Approval"
				id="Approval" value="<%=dcd.getApprovalStatus()%>">
				<aui:option value="Approved-key">
					<label><liferay-ui:message key="Approved-key" /></label>
				</aui:option>
				<aui:option value="Cancel-key">
					<label><liferay-ui:message key="Cancel-key" /></label>
				</aui:option>
			</aui:select>
		</div>
		<%
			}
		%>

		<div class="col-sm">
			<aui:input type="date" label="from-itemapproval-ApprovalDate" name="ApprovalDate" id="ApprovalDate"
				>
			</aui:input>
		</div>

		<%
			if (null == dcd.getClientApprovalStatus() || "" == dcd.getClientApprovalStatus()) {
		%>
		<div class="col-sm">
			<aui:select label="from-itemapproval-custapproval"
				name="CustomerApproval" id="CustomerApproval">
				<aui:option value="Approved-key">
					<label><liferay-ui:message key="Approved-key" /></label>
				</aui:option>
				<aui:option value="Cancel-key">
					<label><liferay-ui:message key="Cancel-key" /></label>
				</aui:option>
			</aui:select>
		</div>

		<%
			} else {
		%>

		<div class="col-sm">
			<aui:select label="from-itemapproval-custapproval"
				name="CustomerApproval" id="CustomerApproval"
				value="<%=dcd.getClientApprovalStatus()%>">
				<aui:option value="Approved-key">
					<label><liferay-ui:message key="Approved-key" /></label>
				</aui:option>
				<aui:option value="Cancel-key">
					<label><liferay-ui:message key="Cancel-key" /></label>
				</aui:option>
			</aui:select>
		</div>
		<%
			}
		%>

		<div class="col-sm">
      <aui:input type="date" name="CustomerDate" id="CustomerDate" label="from-itemapproval-CustomerDate"  >
      </aui:input>
	  </div>
      
      </div>
      
      <aui:button-row>
      
      <aui:button type="submit"  value="from-dcrNew-save"></aui:button>
      <aui:button style="color: #FFF;background-color: #0b5fff;border-color: #0b5fff;box-shadow: none;" onClick="<%=viewDCR.toString() %>" value="from-dcrNew-cancel"/>
     </aui:button-row>
     
       </aui:form>
     