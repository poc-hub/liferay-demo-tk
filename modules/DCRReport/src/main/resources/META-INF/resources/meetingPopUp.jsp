<%@ include file="/init.jsp"%>
<%@page import="java.util.*"%>
<%@page import="com.takenaka.model.TriggerMeeting"%>
<%@page import="com.takenaka.service.*"%>
<%@page import="java.text.*"%>
<%@page import="com.takenaka.model.TriggerMeeting"%>
<%@page import="com.takenaka.service.*"%>
<%@page import="com.takenaka.model.TriggerMeetingDetails"%>
<%@page import="com.takenaka.service.*"%>
<!-- <p>
	<b><liferay-ui:message key="meetingcontroller.caption" /></b>
</p> -->
<!-- <portlet:actionURL name="SearchAction" var="searchVar" /> -->
<%
	int totalMeetings = TriggerMeetingLocalServiceUtil.getTriggerMeetingsCount();
	List<TriggerMeeting> Meetins = TriggerMeetingLocalServiceUtil.getTriggerMeetings(0, totalMeetings);
	System.out.println("---e---e---e->" + Meetins.size());
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
             	var html = "<table class='table'>
		<thead>
			<tr>
				<th scope='col'>Sr. No</th>
				<th scope='col'>Meeting Id</th>
				<th scope='col'>Issuer</th>
				<th scope='col'>Meeting Date</th>
				<th scope='col'>Metting Type</th>
				<th scope='col'>Meeting Title</th>
			</tr>
		</thead>
		<tbody>
			"; for (i = 0; i < data.length; i++) { html= html + "
			<portlet:actionURL name='AddDetailsMeeting' var='addDetailsMeeting'>
				<portlet:param name='meetingId' value=''></portlet:param>
			</portlet:actionURL>
			"; html = html + "
			<tr>
				<td>"+ sno + "</td>
				<td><a href='<%=addDetailsMeeting.toString()%>'>" +
						data[i].MeetingId + "</a></td>
				<td>" + data[i].Issuer + "</td>
				<td>" + data[i].MeetingDate + "</td>
				<td>" + data[i].MeetingDateMeetingDate + "</td>
				<td>" + data[i].MeetingTitle + "</td>
			</tr>
			"; sno++; } html = html + "
		</tbody>
	</table>"
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
					<aui:select label="Meeting Type" name="Meeting Type"
						id="meetingType">
						<aui:option value="">Choose...</aui:option>
						<aui:option value="Internal">Internal</aui:option>
						<aui:option value="External">External</aui:option>
					</aui:select>
				</div>

			</div>
			<div class="col-sm">
				<div class="form-group">
					<aui:input label="Meeting Id" type="text" name="Meeting Id"
						id="meetingId" />
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
					<aui:input label="Meeting From Date" type="date"
						name="Meeting From Date" id="meetingFrmDate" />
					<!-- <input
						class="form-control" type="date" value="" id="meetingFrmDate"
						name="MeetingFromDate"> -->
				</div>
			</div>
			<div class="col-sm">
				<div class="form-group">
					<aui:input label="Meeting To Date" type="date"
						name="Meeting To Date" id="meetingToDate" />
					<!-- <input
						class="form-control" type="date" value="" id="meetingToDate"
						name="MeetingToDate"> -->
				</div>
			</div>
			<div class="col-sm">
				<div class="form-group">
					<aui:input label="Meeting Title" type="text" name="Meeting Title"
						id="meetingTitle" />
					<!-- <input type="text"
						class="form-control" id="meetingTitle" name="MeetingTitle"> -->
				</div>
			</div>
		</div>
		<aui:button type="button" name="saveButton" value="Search"
			onclick="save();" />
	</div>
</aui:form>
</form>
<table class="table" id="default">
	<thead>
		<tr>
			<th scope="col"></th>
			<th scope="col">Sr. No</th>
			<th scope="col">Meeting Id</th>
			<th scope="col">Issuer</th>
			<th scope="col">Meeting Date</th>
			<th scope="col">Metting Type</th>
			<th scope="col">Meeting Title</th>
			<th scope="col">Floor</th>
			<th scope="col">Item</th>
			<th scope="col">Action</th>
		</tr>
	</thead>
	<tbody>
		<%!int j = 1;%>
		<%
			String frmDate;
			if (!Meetins.isEmpty()) {
				for (TriggerMeeting tm : Meetins) {
					List<TriggerMeetingDetails> MeetinsDetails = new ArrayList<TriggerMeetingDetails>();
					//Adding Trigger Meeting table data
					// Adding Meeting Trigger Meeting table data
					if (tm.getMeetDate() != null) {
						frmDate = tm.getMeetDate().toString();
					} else {
						frmDate = "";
					}
					MeetinsDetails
							.addAll(TriggerMeetingDetailsLocalServiceUtil.findByMeetingSeqnoList(tm.getMeetingSeqno()));
					for (TriggerMeetingDetails tmd : MeetinsDetails) {
		%>
		<portlet:actionURL name="AddDetailsMeeting" var="addDetailsMeeting">
			<portlet:param name="meetingId" value="<%=(tm.getMeetingId())%>"></portlet:param>
		</portlet:actionURL>

		<tr>
			<th scope="row"><input type="radio" name="radio" value="<%=j%>" /></th>
			<th scope="row"><%=j%></th>
			<td><%=tm.getMeetingId()%></td>
			<td><%=tm.getIssuer()%></td>
			<td><%=frmDate%></td>
			<td><%=tm.getMeetingType()%></td>
			<td><%=tm.getMeetingTitle()%></td>
			<td><%=tmd.getFloor()%></td>
			<td><%=tmd.getItem()%></td>
			<td><%=tmd.getActions()%></td>
			<td style="display:none;"><%=tmd.getRESPONSE_DUEDATE()%></td>
			<td style="display:none;"><%=tmd.getPersonInCharge()%></td>
			
		</tr>
		<%
			j = j + 1;
					}
				}
			}
		%>
	</tbody>
</table>
<div id="Data"></div>
<br>
<input type="button" value="Select" onclick="getPopUpdata();" />
<input type="button" value="Reset" onclick="" />
<script type="text/javascript">
	function getPopUpdata() {
		//alert("getPopUpdata");
		if (window.opener != null && !window.opener.closed) {
			//alert("opener");
		var ele = document.getElementsByName('radio');
		var meetId="";
		var floor="";
		var items="";
		var action="";
		var dueDate="";
		var personInCharge="";
		//alert("ele.length" + ele.length);

		for (i = 0; i < ele.length; i++) {
			if (ele[i].checked) {
				//alert(document.getElementById("default").rows[i + 1].innerHTML);
				//alert("Meeting Id"+ document.getElementById("default").rows[i + 1].cells[2].innerHTML);
				//alert("floor"+ document.getElementById("default").rows[i + 1].cells[7].innerHTML);
				  meetId= document.getElementById("default").rows[i+1].cells[2].innerHTML;
		          floor = document.getElementById("default").rows[i+1].cells[7].innerHTML;
		          items= document.getElementById("default").rows[i+1].cells[8].innerHTML;
		          action = document.getElementById("default").rows[i+1].cells[9].innerHTML;
		           dueDate= document.getElementById("default").rows[i+1].cells[10].innerHTML;
		           personInCharge = document.getElementById("default").rows[i+1].cells[11].innerHTML;
		            
		           /*  alert("meetId"+meetId);
		             alert("floor"+floor);
		            alert("items"+items);
		            alert("action"+action);
		            alert("dueDate"+dueDate);
		            alert("personInCharge"+personInCharge); */
			}
		}
		 
			var MeetId = window.opener.document.getElementById("meetingId");
			MeetId.value = meetId;
			var Floor = window.opener.document.getElementById("Floor");
			Floor.value = floor; 
			var ItemDetails = window.opener.document.getElementById("ItemDetails");
			ItemDetails.value = items;
			var Action = window.opener.document.getElementById("Action");
			Action.value = action;
			var ExpectedDueDate = window.opener.document.getElementById("ExpectedDueDate");
			ExpectedDueDate.value = dueDate;
			var PersoninCharge = window.opener.document.getElementById("PersoninCharge");
			PersoninCharge.value = personInCharge;
		}
		window.close();
	}
</script>
