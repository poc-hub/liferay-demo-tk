<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.document.library.kernel.util.DLUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.repository.model.Folder"%>
<%@page import="com.liferay.document.library.kernel.model.DLFolderConstants"%>
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
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<%
String ROOT_FOLDER_NAME = "File_Upload";
String ROOT_FOLDER_DESCRIPTION = "Test Descprition";
long PARENT_FOLDER_ID = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
long receivedData=Long.parseLong(request.getParameter("recordId"));
String sreceivedData=Long.toString(receivedData);
System.out.println(receivedData);
DesignChangeDetails designChangeDetails=DesignChangeDetailsLocalServiceUtil.fetchDesignChangeDetails(receivedData);

System.out.println(designChangeDetails);


String Urls[]={"","","",""};
String filenames[]={"","","",""};

try{
	Folder folder=DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), PARENT_FOLDER_ID, ROOT_FOLDER_NAME);
	long array[]=new long[4];
	
	array[0]=designChangeDetails.getAttachmentId1();
	array[1]=designChangeDetails.getAttachmentId2();
	array[2]=designChangeDetails.getAttachmentId3();
	array[3]=designChangeDetails.getAttachmentId4();
	
	int i=0;
	//try{
		List<FileEntry> fileEntry=DLAppServiceUtil.getFileEntries(themeDisplay.getScopeGroupId(), folder.getFolderId());



for(FileEntry file:fileEntry){
			
			for(int j=0;j<array.length;j++){
				if(file.getFileEntryId()==array[j]){
					String temp=file.getFileName();
					int index=temp.indexOf('_');
					filenames[i]=temp.substring(index+1);
					Urls[i]=DLUtil.getPreviewURL(file, file.getFileVersion(), themeDisplay, "");
					i++;
				}
					
					//System.out.println(filenames[i]);
					
				}
			
		
	
	
	}
	}catch(Exception e){
		System.out.println(e);
	}
%>
<portlet:actionURL name="dcrViewAction" var="submitDCRView">
	<portlet:param name="ID" value="<%=sreceivedData%>"/>
</portlet:actionURL>
<portlet:renderURL var="dcrIndexURL">
	<portlet:param name="mvcPath" value="/view.jsp"/>
</portlet:renderURL>
<portlet:actionURL name="dcrConstruction" var="dcrConstructionURL">
	<portlet:param name="ID" value="<%=sreceivedData%>"/>
</portlet:actionURL>


<%if(designChangeDetails.getApprovalStatus().equalsIgnoreCase("Approved-key")){%>

<aui:form name="meetingIndexForm" method="POST" enctype="multipart/form-data" action="${dcrConstructionURL}" >

<div style="/* border: blue; */border-color: #0b5fff;border-style: solid;padding: 15px;border-width: thin;">
   <fieldset disabled="disabled" id="fieldSet">
   <div class="row">
        	<div class="col-sm">
        	<center><legend style="background-color: #f1f2f5;background-color: gray;color: white;"><liferay-ui:message key="from-dcrview-designchange" /></legend></center>
        	</div>
   </div>
   
    <div class="row">
        <div class="col-sm">
        
        <aui:input type="text" label="from-dcrNew-project" name="Project" value="<%=LanguageUtil.get(request, "Traditional-Architecture") %>" id="Project" readonly="readonly" style="background-color: #f1f2f5;"/>
        
        </div>
        <div class="col-sm">
        <aui:input type="text" label="from-dcrNew-issuer" name="IssuerNew" value="<%=themeDisplay.getUser().getFullName() %>" id="IssuerNew" readonly="readonly" style="background-color: #f1f2f5;"/>
        </div>
        <div class="col-sm">
        
        <aui:input type="text" label="from-dcrNew-createdon" name="Created On" value="<%= formatDate%>" id="Created On" readonly="readonly" style="background-color: #f1f2f5;" />
        
        </div>
        <div class="col-sm">&nbsp;</div>
    </div>
    <div class="row">
        <div class="col-sm">
         <!-- <p>DESIGN CHANGE RECORD CREATION</p> -->
        <center><legend style="background-color: #f1f2f5;"><liferay-ui:message key="from-dcrNew-designchangerecordcreation" /></legend></center>
        </div>
    </div>
    <div class="row">
        <div class="col-sm">
      <!--   <label><liferay-ui:message key="from-dcrIndex-reasonforchange" /></label> -->
        <aui:select  label="from-dcrNew-changetype"  name="ChangeType" id="ChangeType" value="<%=designChangeDetails.getChangeType() %>">
						<aui:option value="from-dcrNew-design"><label><liferay-ui:message key="from-dcrNew-design" /></label></aui:option>
						<aui:option value="from-dcrNew-construction"><label><liferay-ui:message key="from-dcrNew-construction" /></label></aui:option>
						<aui:option value="from-dcrNew-facility"><label><liferay-ui:message key="from-dcrNew-facility" /></label></aui:option>
					</aui:select></div>
        <div class="col-sm">
        <!-- <label><liferay-ui:message key="from-dcrIndex-changerequestedby" /></label> -->
        <aui:select label="from-dcrIndex-changerequestedby" name="ChangeRequestedBy" id="ChangeRequestedBy" value="<%=designChangeDetails.getChangeRequestby() %>">
						<aui:option value="from-customer"><label><liferay-ui:message key="from-customer" /></label></aui:option>
						<aui:option value="from-partner"><label><liferay-ui:message key="from-partner" /></label></aui:option>
						<aui:option value="from-internal"><label><liferay-ui:message key="from-internal" /></label></aui:option>
					</aui:select></div>
        <div class="col-sm">
        <!-- <label><liferay-ui:message key="from-dcrNew-reasonforchange" /></label> -->
        <aui:select label="from-dcrNew-reasonforchange" name="ReasonforChange" id="ReasonforChange" value="<%=designChangeDetails.getRfcId() %>" onchange="ReasonforChange()">
						<aui:option value="from-dcrNew-custrequested"><label><liferay-ui:message key="from-dcrNew-custrequested" /></aui:option>
						<aui:option value="from-dcrNew-legal"><label><liferay-ui:message key="from-dcrNew-legal" /></aui:option>
						<aui:option value="from-dcrNew-designimprov"><label><liferay-ui:message key="from-dcrNew-designimprov" /></aui:option>
						<aui:option value="from-dcrNew-consImprov"><label><liferay-ui:message key="from-dcrNew-consImprov" /></aui:option>
						<aui:option value="from-dcrNew-others"><label><liferay-ui:message key="from-dcrNew-others" /></aui:option>
					</aui:select></div>
        <div class="col-sm"><aui:input type="text" label="from-dcrNew-others" name="Others" value="<%=designChangeDetails.getRfcOthers() %>" id="Others" disabled="disabled"/></div>
        <div class="col-sm">
        <!-- <label><liferay-ui:message key="from-dcrNew-rangeofdisclosure"/></label> -->
        <aui:select label="from-dcrNew-rangeofdisclosure" name="Rangeofdisclosure" id="Rangeofdisclosure" value="<%=designChangeDetails.getRangeOfDisclosure() %>">
		<aui:option value="from-customer"><label><liferay-ui:message key="from-customer" /></label></aui:option>
		<aui:option value="from-partner"><label><liferay-ui:message key="from-partner" /></label></aui:option>
		<aui:option value="from-internal"><label><liferay-ui:message key="from-internal" /></label></aui:option>
					</aui:select>
		</div>
    </div>

    <div class="row">
        <div class="col-sm">
            <div class="row">
                <div class="col-sm pl-2 pr-2" ><label class="control-label">&nbsp;</label>
                    <%-- <aui:button href="${meetingPopUp}" useDialog="true" value="Get Meeting" />	 --%>				
                    <!-- <aui:button type="button" name="GeteetingItem" id="GeteetingItem" value=""	onclick="getMeeting();" /> -->
                    <%-- <aui:button href="${meetingPopUp}" value="Get Meeting" /> --%>
                   <!--  <input type="button" class="btn btn-secondary" value="Get Meeting" onclick="getMeetingData()" /> -->
                    
              <input type="button" style="color: #FFF;background-color: #0b5fff;border-color: #0b5fff;box-shadow: none;"  class="btn btn-secondary" onclick="javascript:getMeetingData();" value="<%=LanguageUtil.get(request, "from-dcrNew-getmeetingitem") %>" ><!-- <liferay-ui:message key="from-dcrNew-getmeetingitem" /> --></input><br>
                    
                </div>
                <div class="col-sm pl-2 pr-2"><label><liferay-ui:message key="from-dcrNew-meetid" /></label>
                    <input type="text" class="form-control" id="meetingId" name="meetingId" readonly="readonly" value="<%=designChangeDetails.getMeetingId()%>" style="background-color: #f1f2f5;"></div>
                <div class="col-sm pl-2 pr-2">
                <label><liferay-ui:message key="from-dcrNew-floor" /></label>
                    <input type="text" class="form-control" id="Floor" name="Floor" value="<%=designChangeDetails.getFloor()%>"></div>
                <div class="col-sm pl-2 pr-2"><label><liferay-ui:message key="from-dcrNew-itemdetails" /></label>
                    <input type="text" class="form-control" id="ItemDetails" name="ItemDetails" value="<%=designChangeDetails.getItem()%>"></div>
            </div>
            <div class="row">
                <div class="col-sm pl-2 pr-2"><label><liferay-ui:message key="from-dcrNew-action" /></label>
                    <input type="text" class="form-control" id="Action" name="Action" value="<%=designChangeDetails.getAction() %>"></div>
                <div class="col-sm pl-2 pr-2"><label><liferay-ui:message key="from-dcrNew-expectedduedate" /></label>
                    <input type="date" class="form-control" id="ExpectedDueDate" name="ExpectedDueDate" value="<%=designChangeDetails.getResponsePeriod()%>"></div>
                <div class="col-sm pl-2 pr-2"><label><liferay-ui:message key="from-dcrNew-personIn" /></label>
                    <input type="text" class="form-control" id="PersoninCharge" name="PersoninCharge" value="<%=designChangeDetails.getPersonInCharge()%>"></div>
            </div>
        </div>
        <div class="col-sm">
            <div class="row">
                <div class="col-sm"><aui:input type="textarea" label="from-dcrNew-originaldesign" name="OriginalDesgin" id="OriginalDesgin" value="<%=designChangeDetails.getOriginaldesginDetail() %>"><aui:validator  name="required" errorMessage="Please fill this field"></aui:validator>
                </aui:input></div>
                <div class="col-sm"><aui:input type="textarea" label="from-dcrNew-changedesign" name="ChangeDesgin" id="ChangeDesgin" value="<%=designChangeDetails.getChangeDetail() %>" ><aui:validator  name="required" errorMessage="Please fill this field"></aui:validator>
                </aui:input></div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-sm">
  <!--       <label><liferay-ui:message key="from-dcrNew-changetype" /></label> -->
        <aui:select  label="from-dcrNew-designcosttype" name="DesignCostType" id="DesignCostType" value="<%=designChangeDetails.getEstdesignCosttype() %>">
						<aui:option value="from-dcrNew-increase"><label><liferay-ui:message key="from-dcrNew-increase" /></label></aui:option>
						<aui:option value="from-dcrNew-decrease"><label><liferay-ui:message key="from-dcrNew-decrease" /></label></aui:option>
						<aui:option value="from-dcrNew-none"><label><liferay-ui:message key="from-dcrNew-none" /></label></aui:option>
					</aui:select></div>
        <div class="col-sm">
        	<aui:input type="number" label="from-dcrNew-designcost	" name="DesignCost" id="DesignCost" value="<%=designChangeDetails.getEstdesignCost() %>"/>
        </div>
        <div class="col-sm">
        <aui:select label="from-dcrNew-constructioncostType" name="ConstructionCostType" id="ConstructionCostType" value="<%=designChangeDetails.getEstconstructionCosttype() %>">
        
			<aui:option value="from-dcrNew-increase"><label><liferay-ui:message key="from-dcrNew-increase" /></label></aui:option>
			<aui:option value="from-dcrNew-decrease"><label><liferay-ui:message key="from-dcrNew-decrease" /></label></aui:option>
			<aui:option value="from-dcrNew-none"><label><liferay-ui:message key="from-dcrNew-none" /></label></aui:option>
		</aui:select>
		</div>
        <div class="col-sm">
        	<aui:input type="number" label="from-dcrNew-constructioncost" name="ConstructionCost" id="ConstructionCost" value="<%=designChangeDetails.getEstconstructionCost() %>" />
        </div>
        <div class="col-sm">
        <!--  <label><liferay-ui:message key="from-dcrNew-expensepayment" /></label> -->
        <aui:select label="from-dcrNew-expensepayment" name="ExpensePayment" id="ExpensePayment" value="<%=designChangeDetails.getExpenseAjustmentDivision() %>">
			<aui:option value="from-dcrNew-yes"><label><liferay-ui:message key="from-dcrNew-yes" /></label></aui:option>
			<aui:option value="from-dcrNew-no"><label><liferay-ui:message key="from-dcrNew-no" /></label></aui:option>
		</aui:select>
		</div>
    </div>
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
        <div class="col-sm"><aui:input type="file" label="from-dcrNew-attachment1" name="Attachment1" id="Attachment1"  /></div>
        <div class="col-sm"><aui:input type="file" label="from-dcrNew-attachment3" name="Attachment3" id="Attachment3"  /></div>
    </div>
    <div class="row">
        <div class="col-sm"><aui:input type="file" label="from-dcrNew-attachment2" name="Attachment2" id="Attachment2 " /></div>
        <div class="col-sm"><aui:input type="file" label="from-dcrNew-attachment4" name="Attachment4" id="Attachment4" /></div>
    </div>
    </fieldset>
	
	<div class="row">
	
	
		 <div class="col-sm"><aui:select label="from-dcrview-constructionstatus" class="form-control" name="Construction" id="Construction" value="<%=designChangeDetails.getConstructionStatus() %>">
		 	<aui:option value=""></aui:option>
		 	<aui:option value="from-dcrview-beforeconstruction"><label><liferay-ui:message key="from-dcrview-beforeconstruction" /></label></aui:option>
		 	<aui:option value="from-dcrview-underconstruction"><label><liferay-ui:message key="from-dcrview-underconstruction" /></label></aui:option>
		 	<aui:option value="from-dcrview-complete"><label><liferay-ui:message key="from-dcrview-complete" /></label></aui:option>
		 </aui:select>
		 </div>
		 
	
	<%if(null == designChangeDetails.getConstructionDate()){%>
	
	<div class="col-sm">
		<aui:input type="date" class="form-control" label="from-dcrview-constructionstatusdate" name="constructiondate" id="constructiondate" value=""/>
	</div>
	
	<% }else{%>
		<%
		Date a = designChangeDetails.getConstructionDate(); 
	// MM/dd/yyyy
		SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
		String strDate= formatter.format(a);
		System.out.print("sanjay"+ strDate );
		%>
	
	<div class="col-sm">
		<aui:input type="date" class="form-control" label="from-dcrview-constructionstatusdate" name="constructiondate" id="constructiondate" value="<%=strDate %>"/>
	</div>
	<%} %> 
	
	
	</div>
	
    <div class="row">
        <div class="col-sm"><div class="form-group">
        <aui:button-row>
            <aui:button type="submit" id="btn_submit" value="from-dcrNew-save" ></aui:button>
            <aui:button type="button" style="color: #FFF;background-color: #0b5fff;border-color: #0b5fff;box-shadow: none;" onClick="<%=dcrIndexURL.toString()%>" value="from-dcrNew-cancel"></aui:button>
            
        </aui:button-row>
            
        </div></div>
    </div>
    </div>

	
</aui:form>


<%}else{%>
<aui:form name="meetingIndexForm" method="POST" enctype="multipart/form-data" action="${submitDCRView}" >

<div style="/* border: blue; */border-color: #0b5fff;border-style: solid;padding: 15px;border-width: thin;">

   <fieldset disabled="disabled" id="fieldSet">
   
   <div class="row">
        	<div class="col-sm">
        	<center><legend style="background-color: #f1f2f5;background-color: gray;color: white;"><liferay-ui:message key="from-dcrview-designchange" /></legend></center>
        	</div>
        </div>
   
    <div class="row">
        <div class="col-sm">
        
        <aui:input type="text" label="from-dcrNew-project" name="Project" value="<%=LanguageUtil.get(request, "Traditional-Architecture") %>" id="Project" readonly="readonly" style="background-color: #f1f2f5;"/>
        
        </div>
        <div class="col-sm">
        <aui:input type="text" label="from-dcrNew-issuer" name="IssuerNew" value="<%=themeDisplay.getUser().getFullName() %>" id="IssuerNew" readonly="readonly" style="background-color: #f1f2f5;"/>
        </div>
        <div class="col-sm">
        
        <aui:input type="text" label="from-dcrNew-createdon" name="Created On" value="<%= formatDate%>" id="Created On" readonly="readonly" style="background-color: #f1f2f5;" />
        
        </div>
        <div class="col-sm">&nbsp;</div>
    </div>
    <div class="row">
        <div class="col-sm">
         <!-- <p>DESIGN CHANGE RECORD CREATION</p> -->
        <center><legend style="background-color: #f1f2f5;"><liferay-ui:message key="from-dcrNew-designchangerecordcreation" /></legend></center>
        </div>
    </div>
    <div class="row">
        <div class="col-sm">
      <!--   <label><liferay-ui:message key="from-dcrIndex-reasonforchange" /></label> -->
        <aui:select  label="from-dcrNew-changetype"  name="ChangeType" id="ChangeType" value="<%=designChangeDetails.getChangeType() %>">
						<aui:option value="from-dcrNew-design"><label><liferay-ui:message key="from-dcrNew-design" /></label></aui:option>
						<aui:option value="from-dcrNew-construction"><label><liferay-ui:message key="from-dcrNew-construction" /></label></aui:option>
						<aui:option value="from-dcrNew-facility"><label><liferay-ui:message key="from-dcrNew-facility" /></label></aui:option>
					</aui:select></div>
        <div class="col-sm">
        <!-- <label><liferay-ui:message key="from-dcrIndex-changerequestedby" /></label> -->
        <aui:select label="from-dcrIndex-changerequestedby" name="ChangeRequestedBy" id="ChangeRequestedBy" value="<%=designChangeDetails.getChangeRequestby() %>">
						<aui:option value="from-customer"><label><liferay-ui:message key="from-customer" /></label></aui:option>
						<aui:option value="from-partner"><label><liferay-ui:message key="from-partner" /></label></aui:option>
						<aui:option value="from-internal"><label><liferay-ui:message key="from-internal" /></label></aui:option>
					</aui:select></div>
        <div class="col-sm">
        <!-- <label><liferay-ui:message key="from-dcrNew-reasonforchange" /></label> -->
        <aui:select label="from-dcrNew-reasonforchange" name="ReasonforChange" id="ReasonforChange" value="<%=designChangeDetails.getRfcId() %>" onchange="ReasonforChange()">
						<aui:option value="from-dcrNew-custrequested"><label><liferay-ui:message key="from-dcrNew-custrequested" /></aui:option>
						<aui:option value="from-dcrNew-legal"><label><liferay-ui:message key="from-dcrNew-legal" /></aui:option>
						<aui:option value="from-dcrNew-designimprov"><label><liferay-ui:message key="from-dcrNew-designimprov" /></aui:option>
						<aui:option value="from-dcrNew-consImprov"><label><liferay-ui:message key="from-dcrNew-consImprov" /></aui:option>
						<aui:option value="from-dcrNew-others"><label><liferay-ui:message key="from-dcrNew-others" /></aui:option>
					</aui:select></div>
        <div class="col-sm"><aui:input type="text" label="from-dcrNew-others" name="Others" value="<%=designChangeDetails.getRfcOthers() %>" id="Others "/></div>
        <div class="col-sm">
        <!-- <label><liferay-ui:message key="from-dcrNew-rangeofdisclosure"/></label> -->
        <aui:select label="from-dcrNew-rangeofdisclosure" name="Rangeofdisclosure" id="Rangeofdisclosure" value="<%=designChangeDetails.getRangeOfDisclosure() %>">
		<aui:option value="from-customer"><label><liferay-ui:message key="from-customer" /></label></aui:option>
		<aui:option value="from-partner"><label><liferay-ui:message key="from-partner" /></label></aui:option>
		<aui:option value="from-internal"><label><liferay-ui:message key="from-internal" /></label></aui:option>
					</aui:select>
		</div>
    </div>

    <div class="row">
        <div class="col-sm">
            <div class="row">
                <div class="col-sm pl-2 pr-2" ><label class="control-label">&nbsp;</label>
                    <%-- <aui:button href="${meetingPopUp}" useDialog="true" value="Get Meeting" />	 --%>				
                    <!-- <aui:button type="button" name="GeteetingItem" id="GeteetingItem" value=""	onclick="getMeeting();" /> -->
                    <%-- <aui:button href="${meetingPopUp}" value="Get Meeting" /> --%>
                   <!--  <input type="button" class="btn btn-secondary" value="Get Meeting" onclick="getMeetingData()" /> -->
                    
              <input type="button" style="color: #FFF;background-color: #0b5fff;border-color: #0b5fff;box-shadow: none;" class="btn btn-secondary" onclick="javascript:getMeetingData();" value="<%=LanguageUtil.get(request, "from-dcrNew-getmeetingitem") %>" ><!-- <liferay-ui:message key="from-dcrNew-getmeetingitem" /> --></input><br>
                    
                </div>
                <div class="col-sm pl-2 pr-2"><label><liferay-ui:message key="from-dcrNew-meetid" /></label>
                    <input type="text" class="form-control" id="meetingId" name="meetingId" readonly="readonly" value="<%=designChangeDetails.getMeetingId()%>" style="background-color: #f1f2f5;"></div>
                <div class="col-sm pl-2 pr-2">
                <label><liferay-ui:message key="from-dcrNew-floor" /></label>
                    <input type="text" class="form-control" id="Floor" name="Floor" value="<%=designChangeDetails.getFloor()%>"></div>
                <div class="col-sm pl-2 pr-2"><label><liferay-ui:message key="from-dcrNew-itemdetails" /></label>
                    <input type="text" class="form-control" id="ItemDetails" name="ItemDetails" value="<%=designChangeDetails.getItem()%>"></div>
            </div>
            <div class="row">
                <div class="col-sm pl-2 pr-2"><label><liferay-ui:message key="from-dcrNew-action" /></label>
                    <input type="text" class="form-control" id="Action" name="Action" value="<%=designChangeDetails.getAction() %>"></div>
                <div class="col-sm pl-2 pr-2"><label><liferay-ui:message key="from-dcrNew-expectedduedate" /></label>
                    <input type="date" class="form-control" id="ExpectedDueDate" name="ExpectedDueDate" value="<%=designChangeDetails.getResponsePeriod()%>"></div>
                <div class="col-sm pl-2 pr-2"><label><liferay-ui:message key="from-dcrNew-personIn" /></label>
                    <input type="text" class="form-control" id="PersoninCharge" name="PersoninCharge" value="<%=designChangeDetails.getPersonInCharge()%>"></div>
            </div>
        </div>
        <div class="col-sm">
            <div class="row">
                <div class="col-sm"><aui:input type="textarea" label="from-dcrNew-originaldesign" name="OriginalDesgin" id="OriginalDesgin" value="<%=designChangeDetails.getOriginaldesginDetail() %>"><aui:validator  name="required" errorMessage="Please fill this field"></aui:validator>
                </aui:input></div>
                <div class="col-sm"><aui:input type="textarea" label="from-dcrNew-changedesign" name="ChangeDesgin" id="ChangeDesgin" value="<%=designChangeDetails.getChangeDetail() %>" ><aui:validator  name="required" errorMessage="Please fill this field"></aui:validator>
                </aui:input></div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-sm">
  <!--       <label><liferay-ui:message key="from-dcrNew-changetype" /></label> -->
        <aui:select  label="from-dcrNew-designcosttype" name="DesignCostType" id="DesignCostType" value="<%=designChangeDetails.getEstdesignCosttype() %>">
						<aui:option value="from-dcrNew-increase"><label><liferay-ui:message key="from-dcrNew-increase" /></label></aui:option>
						<aui:option value="from-dcrNew-decrease"><label><liferay-ui:message key="from-dcrNew-decrease" /></label></aui:option>
						<aui:option value="from-dcrNew-none"><label><liferay-ui:message key="from-dcrNew-none" /></label></aui:option>
					</aui:select></div>
        <div class="col-sm">
        	<aui:input type="number" label="from-dcrNew-designcost	" name="DesignCost" id="DesignCost" value="<%=designChangeDetails.getEstdesignCost() %>"/>
        </div>
        <div class="col-sm">
        <aui:select label="from-dcrNew-constructioncostType" name="ConstructionCostType" id="ConstructionCostType" value="<%=designChangeDetails.getEstconstructionCosttype() %>">
        
			<aui:option value="from-dcrNew-increase"><label><liferay-ui:message key="from-dcrNew-increase" /></label></aui:option>
			<aui:option value="from-dcrNew-decrease"><label><liferay-ui:message key="from-dcrNew-decrease" /></label></aui:option>
			<aui:option value="from-dcrNew-none"><label><liferay-ui:message key="from-dcrNew-none" /></label></aui:option>
		</aui:select>
		</div>
        <div class="col-sm">
        	<aui:input type="number" label="from-dcrNew-constructioncost" name="ConstructionCost" id="ConstructionCost" value="<%=designChangeDetails.getEstconstructionCost() %>" />
        </div>
        <div class="col-sm">
        <!--  <label><liferay-ui:message key="from-dcrNew-expensepayment" /></label> -->
        <aui:select label="from-dcrNew-expensepayment" name="ExpensePayment" id="ExpensePayment" value="<%=designChangeDetails.getExpenseAjustmentDivision() %>">
			<aui:option value="from-dcrNew-yes"><label><liferay-ui:message key="from-dcrNew-yes" /></label></aui:option>
			<aui:option value="from-dcrNew-no"><label><liferay-ui:message key="from-dcrNew-no" /></label></aui:option>
		</aui:select>
		</div>
    </div>
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
        <div class="col-sm"><aui:input type="file" label="from-dcrNew-attachment1" name="Attachment1" id="Attachment1"  /></div>
        <div class="col-sm"><aui:input type="file" label="from-dcrNew-attachment3" name="Attachment3" id="Attachment3"  /></div>
    </div>
    <div class="row">
        <div class="col-sm"><aui:input type="file" label="from-dcrNew-attachment2" name="Attachment2" id="Attachment2 " /></div>
        <div class="col-sm"><aui:input type="file" label="from-dcrNew-attachment4" name="Attachment4" id="Attachment4" /></div>
    </div>
    
    
	
	
   
           
            <aui:button-row>

	 <!--<button class="btn btn-primary type="button"  id="btn_edit">Edit</button>  onclick="saveEnable()" -->
	   <aui:button  type="submit" id="btn_submit" value="from-dcrNew-save" ></aui:button>
		</fieldset>	   
	 	<aui:button style="color: #FFF;background-color: #0b5fff;border-color: #0b5fff;box-shadow: none;" onclick="editEnable();" value="from-dcrview-edit">
	 	</aui:button>

	 <!--<button class="btn btn-primary type="button"id="btn_cancel" onClick="< %=dcrIndexURL.toString()%>" >Cancel</button>  -->
	 
	 	<aui:button style="color: #FFF;background-color: #0b5fff;border-color: #0b5fff;box-shadow: none;"  onClick="<%=dcrIndexURL.toString()%>" value="from-dcrNew-cancel">
	 	</aui:button>


</aui:button-row>
        
    </div>
    

	
</aui:form>
<%} %>

<%-- <aui:button-row>

	 <!--<button class="btn btn-primary type="button"  id="btn_edit">Edit</button>  onclick="saveEnable()" -->
	  
	 	<aui:button  onclick="editEnable();" value="from-dcrview-edit">
	 	</aui:button>

	 <!--<button class="btn btn-primary type="button"id="btn_cancel" onClick="< %=dcrIndexURL.toString()%>" >Cancel</button>  -->
	 
	 	<aui:button  onClick="<%=dcrIndexURL.toString()%>" value="from-dcrNew-cancel">
	 	</aui:button>


</aui:button-row> --%>
<aui:script>
 function editEnable(){
 	 
	 var bt_submit = document.getElementById('fieldSet');
	  
	 
	 bt_submit.disabled=false;
	 
  }
  
</aui:script>
<script type="text/javascript">


function ReasonforChange(){
	var valuea =document.getElementById('<portlet:namespace />ReasonforChange').value;
	if(valuea == "from-dcrNew-others"){
		document.getElementById('<portlet:namespace />Others').disabled = false;
	}else{
		document.getElementById('<portlet:namespace />Others').disabled = true;
	}
	
}

  /*    var popup; */
    function getMeetingData() {
	  console.log("hello am here");
	  /* alert("getMeetingData"); */
        var organizationWindow = window.open('<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="mvcPath" value="/meetingPopUp.jsp"/><portlet:param name="redirect" value="#"/></portlet:renderURL>',
                'title',
               'directories=no, height=600, location=no, menubar=no, resizable=yes,scrollbars=yes, status=no, toolbar=no, width=1280');
               organizationWindow.focus();
    }
  
    /* AUI().ready('aui-module', function(A){
    	document.getElementById('<portlet:namespace />ExpectedDueDate').valueAsDate = new Date();
    }); */
 
</script>