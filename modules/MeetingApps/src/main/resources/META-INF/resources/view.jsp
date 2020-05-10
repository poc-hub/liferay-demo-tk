<%@ include file="/init.jsp"%>
<%@page import="java.util.*"%>
<%@page import="com.takenaka.model.TriggerMeeting"%>
<%@page import="com.takenaka.service.*"%>
<%@page import="java.text.*"%>
<!-- <p>
	<b><liferay-ui:message key="meetingcontroller.caption" /></b>
</p> -->
<!-- <portlet:actionURL name="SearchAction" var="searchVar" /> -->

<aui:script>
function save(){
    AUI().use('aui-base','aui-io-request', function(A){
       
       var MeetingType=A.one("#<portlet:namespace />meetingType").get('value');
        var MeetingId=A.one("#<portlet:namespace />meetingId").get('value');
        var Issuer=A.one("#<portlet:namespace />issuer").get('value');
        var MeetingFrmDate=A.one("#<portlet:namespace />meetingFrmDate").get('value');
        var MeetingToDate=A.one("#<portlet:namespace />meetingToDate").get('value');
        var MeetingTitle=A.one("#<portlet:namespace />meetingTitle").get('value');
        //alert(MeetingType);
        

        A.io.request('<%=saveDataUrl%>',{
            dataType: 'json',
            method: 'POST',
            data: { <portlet:namespace />MeetingType: MeetingType,
                     <portlet:namespace />MeetingId: MeetingId,
                     <portlet:namespace />Issuer: Issuer,
                     <portlet:namespace />MeetingFrmDate: MeetingFrmDate,
                     <portlet:namespace />MeetingToDate: MeetingToDate,
                     <portlet:namespace />MeetingTitle: MeetingTitle},
            on: {
            success: function() {
                var data=this.get('responseData');
                // Actions to be performed on success
                var dataReceivedSuccess = data.dataReceivedMessage;
              //  alert(data[0].MeetingId);
                var sno = 1;
				var i = 0;
             	var html = "<table class='table'><thead><tr><th scope='col'>Sr. No</th><th scope='col'>Meeting Id</th><th scope='col'>Issuer</th><th scope='col'>Meeting Date</th><th scope='col'>Metting Type</th><th scope='col'>Meeting Title</th></tr></thead><tbody>"; 
		
		for (i = 0; i < data.length; i++) { 
		html= html + "<portlet:actionURL name='AddDetailsMeeting' var='addDetailsMeeting'><portlet:param name='meetingId' value=''></portlet:param></portlet:actionURL>";
			html = html + "<tr><td>"+ sno + "</td><td><a href='<%=addDetailsMeeting.toString()%>'>" + data[i].MeetingId + "</a></td><td>" + data[i].Issuer + "</td><td>" + data[i].MeetingDate + "</td><td>" + data[i].MeetingDateMeetingDate + "</td><td>" + data[i].MeetingTitle + "</td></tr>";
			 sno++; 
			 }
			  html = html + "</tbody></table>"
			$('#Data').html(html);
			$('#Data').show();
			$('#default').hide();
			
                }
            }
        });
   
    });
}

</aui:script>
<aui:form>
	<div class="container">
		<div class="row">
			<div class="col-sm">
				<div class="form-group">
					<aui:select name="Meeting Type" id="meetingType" label="from-meetingIndex-meetingtype">
						<aui:option value="">Choose...</aui:option>
						<aui:option value="from-internal"><label><liferay-ui:message key="from-internal" /></label></aui:option>
						<aui:option value="from-external"><label><liferay-ui:message key="from-external" /></label></aui:option>
					</aui:select>
					<!-- <select class="custom-select"
						id="meetingType" name="MeetingType">
						<option selected>Choose...</option>
						<option value="Internal">Internal</option>
						<option value="External">External</option>

					</select>
 -->
				</div>

			</div>
			<div class="col-sm">
				<div class="form-group">
					<aui:input type="text" name="Meeting Id" id="meetingId"  label="from-meetingIndex-meetingid"/>
					<!-- <input type="text"
						class="form-control" id="meetingId" name="MeetingId"> -->
				</div>
			</div>
			<div class="col-sm">
				<div class="form-group">
					<aui:input type="text" name="Issuer" id="issuer" label="from-meetingIndex-issuer" />
					<!-- <input type="text"
						class="form-control" id="issuer" name="Issuer"> -->
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-sm">
				<div class="form-group">
					<aui:input type="date" name="Meeting From Date" id="meetingFrmDate" label="from-meetingIndex-meetingdatefrom" />
					<!-- <input
						class="form-control" type="date" value="" id="meetingFrmDate"
						name="MeetingFromDate"> -->
				</div>
			</div>
			<div class="col-sm">
				<div class="form-group">
					<aui:input type="date" name="Meeting To Date" id="meetingToDate" label="from-meetingIndex-meetingdateto" />
					<!-- <input
						class="form-control" type="date" value="" id="meetingToDate"
						name="MeetingToDate"> -->
				</div>
			</div>
			<div class="col-sm">
				<div class="form-group">
					<aui:input type="text" name="Meeting Title" id="meetingTitle" label="from-meetingIndex-meetingtitle" />
					<!-- <input type="text"
						class="form-control" id="meetingTitle" name="MeetingTitle"> -->
				</div>
			</div>
		</div>
			<aui:button type="button" name="saveButton" value="from-meetingIndex-search" onclick="save();" />
	</div>
</aui:form>
</form>
<table class="table" id="default">
	<thead>
		<tr>
			<th scope="col"><label><liferay-ui:message key="from-meetingIndex-srno" /></th>
			<th scope="col"><label><liferay-ui:message key="from-meetingIndex-meetingid" /></th>
			<th scope="col"><label><liferay-ui:message key="from-meetingIndex-issuer" /></th>
			<th scope="col"><label><liferay-ui:message key="from-meetingIndex-meetingdate" /></th>
			<th scope="col"><label><liferay-ui:message key="from-meetingIndex-meetingtype" /></th>
			<th scope="col"><label><liferay-ui:message key="from-meetingIndex-meetingtitle" /></th>
		</tr>
	</thead>
	<tbody>
		<%!int i = 1;%>
		<%
			for (TriggerMeeting tm : Meetins) {
				String formatDate=null;
				if(tm.getMeetDate()!=null){
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					SimpleDateFormat sdf2 = new SimpleDateFormat("MM-dd-yyyy");
				   String formatedDate = df.format(tm.getMeetDate());
				   formatDate = sdf2.format(df.parse(formatedDate));
				}
				else{
					formatDate="";
				}
		%>
		<portlet:actionURL name="AddDetailsMeeting" var="addDetailsMeeting">
	<portlet:param name="meetingId" value="<%=(tm.getMeetingId())%>"></portlet:param>
</portlet:actionURL>

		<tr>
			<th scope="row"><%=i%></th>
			<td><a href="<%=addDetailsMeeting.toString()%>"><%=tm.getMeetingId()%></a></td>
			<td><%=tm.getIssuer()%></td>
			<td><%=formatDate%></td>
			<td>
				<%
								if(tm.getMeetingType().equalsIgnoreCase("from-internal")){
									%>
									<label><liferay-ui:message key="from-internal" /></label><%-- <%=MeetinInfo.getMeetingType() %> --%></option>
								<%}else{%>
									<label><liferay-ui:message key="from-external" /></label><%-- <%=MeetinInfo.getMeetingType() %> --%></option>
								<%}%>
			
			<%-- <%=tm.getMeetingType()%> --%></td>
			<td><%=tm.getMeetingTitle()%></td>
		</tr>
		<%
			i = i + 1;
			}
		%>
	</tbody>
</table>
<div id="Data"></div>
<br>

<div class="row">
	<div class="col-sm-2"></div>
	<div class="col-sm-4">

		<aui:button-row>
			<aui:button onClick="<%=createMeeting.toString()%>"
				value="from-meetingIndex-create"></aui:button>
		</aui:button-row>


	</div>
	<div class="col-sm-4">
		<center>
			<aui:button type="reset"
				class="btn btn-secondary" value="from-meetingIndex-reset"></aui:button>
			
			<!-- <button type="button" class="btn btn-secondary" value="from-meetingIndex-reset"></button> -->
		</center>
	</div>
	<div class="col-sm-2"></div>
</div>

</div>
