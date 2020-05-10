<%@ include file="/init.jsp"%>
<%@page import="java.util.*"%>
<%@page import="com.takenaka.model.TriggerMeeting"%>
<%@page import="com.takenaka.service.*"%>
<%@page import="java.text.*"%>
<!-- <p>
	<b><liferay-ui:message key="meetingcontroller.caption" /></b>
</p> -->
<!-- <portlet:actionURL name="SearchAction" var="searchVar" /> -->
<%
//int totalMeetings = TriggerMeetingLocalServiceUtil.getTriggerMeetingsCount();
List<TriggerMeeting> Meetins = TriggerMeetingLocalServiceUtil.getTriggerMeetings(0, 10);
System.out.println ("---e---e---e->"+Meetins.size());
%>
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
					<aui:select label="Meeting Type" name="Meeting Type" id="meetingType">
						<aui:option value="">Choose...</aui:option>
						<aui:option value="Internal">Internal</aui:option>
						<aui:option value="External">External</aui:option>
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
					<aui:input label="Meeting Id" type="text" name="Meeting Id" id="meetingId" />
					<!-- <input type="text"
						class="form-control" id="meetingId" name="MeetingId"> -->
				</div>
			</div>
			<div class="col-sm">
				<div class="form-group">
					<aui:input label="Issuer" type="text" name="Issuer" id="issuer" />
					<!-- <input type="text"
						class="form-control" id="issuer" name="Issuer"> -->
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-sm">
				<div class="form-group">
					<aui:input label="Meeting From Date" type="date" name="Meeting From Date" id="meetingFrmDate" />
					<!-- <input
						class="form-control" type="date" value="" id="meetingFrmDate"
						name="MeetingFromDate"> -->
				</div>
			</div>
			<div class="col-sm">
				<div class="form-group">
					<aui:input label="Meeting To Date" type="date" name="Meeting To Date" id="meetingToDate" />
					<!-- <input
						class="form-control" type="date" value="" id="meetingToDate"
						name="MeetingToDate"> -->
				</div>
			</div>
			<div class="col-sm">
				<div class="form-group">
					<aui:input label="Meeting Title" type="text" name="Meeting Title" id="meetingTitle" />
					<!-- <input type="text"
						class="form-control" id="meetingTitle" name="MeetingTitle"> -->
				</div>
			</div>
		</div>
			<aui:button type="button" name="saveButton" value="Search"	onclick="save();" />
	</div>
</aui:form>
</form>
<table class="table" id="default">
	<thead>
		<tr>
			<th scope="col">Sr. No</th>
			<th scope="col">Meeting Id</th>
			<th scope="col">Issuer</th>
			<th scope="col">Meeting Date</th>
			<th scope="col">Metting Type</th>
			<th scope="col">Meeting Title</th>
		</tr>
	</thead>
	<tbody>
		<%!int j = 1;%>
		<%
			for (TriggerMeeting tm : Meetins) {
				String formatDaten=null;
				if(tm.getMeetDate()!=null){
					SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
					SimpleDateFormat sdfn = new SimpleDateFormat("MM-dd-yyyy");
				   String formatedDaten = sdf1.format(tm.getMeetDate());
				   formatDaten = sdfn.format(sdf1.parse(formatedDaten));
				}
				else{
					formatDaten="";
				}
		%>
		<portlet:actionURL name="AddDetailsMeeting" var="addDetailsMeeting">
	<portlet:param name="meetingId" value="<%=(tm.getMeetingId())%>"></portlet:param>
</portlet:actionURL>

		<tr>
			<th scope="row"><%=j%></th>
			<td><a href="<%=addDetailsMeeting.toString()%>"><%=tm.getMeetingId()%></a></td>
			<td><%=tm.getIssuer()%></td>
			<td><%=formatDaten%></td>
			<td><%=tm.getMeetingType()%></td>
			<td><%=tm.getMeetingTitle()%></td>
		</tr>
		<%
			j = j + 1;
			}
		%>
	</tbody>
</table>
<div id="Data"></div>
<br>

<%-- <div class="row">
	<div class="col-sm-2"></div>
	<div class="col-sm-4">

		<aui:button-row>
			<aui:button onClick="<%=createMeeting.toString()%>"
				value="Create New Meeting"></aui:button>
		</aui:button-row>


	</div>
	<div class="col-sm-4">
		<center>
			<button type="button" class="btn btn-secondary">Reset Search
				Field</button>
		</center>
	</div>
	<div class="col-sm-2"></div>
</div> --%>

</div>
