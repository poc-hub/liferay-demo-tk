<%@page import="com.takenaka.model.TriggerMeetingDetails"%>
<%@ include file="/init.jsp"%>
<%@page import="java.util.*"%>
<%@page import="com.takenaka.model.TriggerMeeting"%>
<%@page import="com.takenaka.service.*"%>
<%@page import="java.text.*"%>

<!-- <script>
var header = document.getElementById("myDIV");
var btns = header.getElementsByClassName("step");
for (var i = 0; i < btns.length; i++) {
  btns[i].addEventListener("click", function() {
  var current = document.getElementsByClassName("active");
  current[0].className = current[0].className.replace(" active", "step");
  this.className += " active";
  });
}
</script>
 -->

<style>
body {
	margin-top: 20px;
}

.stepwizard-step p {
	margin-top: 10px;
}

.stepwizard-row {
	display: table-row;
}

.stepwizard {
	display: table;
	width: 90%;
	position: relative;
}

.stepwizard-step button[disabled] {
	opacity: 1 !important;
	filter: alpha(opacity = 100) !important;
}

.stepwizard-row:before {
	top: 14px;
	bottom: 0;
	position: absolute;
	content: " ";
	width: 100%;
	height: 1px;
	background-color: #ccc;
	z-order: 0;
}

.stepwizard-step {
	display: table-cell;
	text-align: center;
	position: relative;
}

.btn-circle {
	width: 30px;
	height: 30px;
	text-align: center;
	padding: 6px 0;
	font-size: 12px;
	line-height: 1.428571429;
	border-radius: 15px;
}

.close_icon {
	cursor: pointer;
}

.add_btn {
	background-color: #15A3E6;
	float: right;
}
.mandatory:after{
content: " *";
color: red;
}
.btn {
background-color: #C1B8B6;
  border: none;
  color: white;
  padding: 12px 16px;
  font-size: 16px;
  cursor: pointer;
}
.step{
background-color: #15A3E6 ;
}

/* Darker background on mouse-over */
.step:hover {
  background-color: #C1B8B6;
}
.active{
 background-color: #C1B8B6;
}


</style>


   
   <%
 TriggerMeeting MeetinInfo =(TriggerMeeting)request.getAttribute("MeetingInfo");
List<TriggerMeetingDetails> MeetingDetails = (List<TriggerMeetingDetails>)request.getAttribute("MeetingDetails");

String formatDate=null;
if(MeetinInfo.getMeetDate()!=null){
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf2 = new SimpleDateFormat("MM-dd-yyyy");
    String formatedDate = df.format(MeetinInfo.getMeetDate());
    formatDate = sdf2.format(df.parse(formatedDate));
}
else{
	formatDate="";
}
%>



<div class="container">

<!-- 	<div class="stepwizard col-md-offset-3">
		<div class="stepwizard-row setup-panel">
			<div class="stepwizard-step">
				<a href="#step-1" type="button" class="btn btn-primary">
				<label><liferay-ui:message key="from-createmeeting-meetinginformation" /></label>
				</a>
				<p></p>
			</div>
			<div class="stepwizard-step">
				<a href="#step-2" type="button" class="btn btn-default"
					disabled="disabled">
					<label><liferay-ui:message key="from-createmeeting-meetingdetails" /></label>
				</a>
				<p></p>
			</div>
		</div>
	</div> -->
	
	
	<div class="stepwizard col-md-offset-3" id="myDIV">
		<div class="stepwizard-row setup-panel">
			<div class="stepwizard-step">
				<a href="#step-1" type="button" class="btn btn-primary mt-1 active">
				<label style="color:white"><liferay-ui:message key="from-createmeeting-meetinginformation" /></label></a>
				<p></p>
			</div>
			<div class="stepwizard-step">
				<a href="#step-2" type="button" class="btn btn-default mt-1 active"
					disabled="disabled"><label style="color:white"><liferay-ui:message key="from-createmeeting-meetingdetails" /></label></a>
				<p></p>
			</div>
		</div>
	</div>
	
	

	<form name="meetingIndexForm">
		<div class="row setup-content" id="step-1">
			<div class="container">
				<div class="row">
					<div class="col-sm">
						<div class="form-group">
							<label><liferay-ui:message key="from-createmeeting-project" /></label> <input type="text"
								class="form-control" id="project" name="Project"
								value="<liferay-ui:message key="from-createmeeting-projectName" />" disabled>
						</div>
					</div>

					<div class="col-sm">
						<div class="form-group">
							<label><liferay-ui:message key="from-createmeeting-meetingid" /></label> <input type="text"
								class="form-control" id="meetingId" name="MeetingId" value="<%=MeetinInfo.getMeetingId() %>"
								 readonly="readonly" disabled="true">
						</div>
					</div>

					<div class="col-sm">
						<div class="form-group">
							<label><liferay-ui:message key="from-createmeeting-issuer" /></label> <input type="text"
								class="form-control" id="issuer" name="Issuer" disabled="true" value="<%=MeetinInfo.getIssuer() %>" readonly="readonly"
								>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm">
						<div class="form-group">
							<label for="usr"><liferay-ui:message key="from-createmeeting-meetingtype" /></label> <select
								class="custom-select" id="meetingType" name="MeetingType" disabled="true">
								
								<%
								if(MeetinInfo.getMeetingType().equalsIgnoreCase("from-internal")){
									%>
									<option selected ><label><liferay-ui:message key="from-internal" /></label><%-- <%=MeetinInfo.getMeetingType() %> --%></option>
								<%}else{%>
									<option selected ><label><liferay-ui:message key="from-external" /></label><%-- <%=MeetinInfo.getMeetingType() %> --%></option>
								<%}%>
								<!-- <option value="Internal"></option>
								<option value="External">External</option> -->
							</select>
						</div>
					</div>
					<div class="col-sm">
						<div class="form-group">
							<label><liferay-ui:message key="from-createmeeting-meetingdate" /></label> <input type="text"
								class="form-control" id="meetingDate" name="MeetingDate" value="<%=formatDate %>" disabled="true" readonly="readonly"
								>
						</div>
					</div>

					<div class="col-sm">
						<div class="form-group">
							<label><liferay-ui:message key="from-createmeeting-meetingplace" /></label> <input type="text"
								class="form-control" id="meetingPlace" name="MeetingPlace" value="<%=MeetinInfo.getMeetingPlace() %>" disabled="true" readonly="readonly"
								>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm">
						<div class="form-group">
							<label><liferay-ui:message key="from-createmeeting-meetingtitle" /></label> <input type="text"
								class="form-control" id="meetingTitle" name="MeetingTitle" value="<%=MeetinInfo.getMeetingTitle() %>" disabled="true" readonly="readonly">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm">
						<div class="form-group">
							<label><liferay-ui:message key="from-createmeeting-meetingparticipants" /></label><input type="text"
								class="form-control" id="meetingParticipants" disabled="true" 
								name="MeetingParticipants" value="<%=MeetinInfo.getParticipant() %>" readonly="readonly">
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-sm">
						<div class="form-group">
							<label><liferay-ui:message key="from-createmeeting-meetingsummary" /></label>
							 <textarea class="form-control" id="meetingSummary" name="MeetingSummary" disabled="true" readonly="readonly"><%=MeetinInfo.getMeetingSummary() %></textarea>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm">
						<div class="form-group">
							<!-- <button class="btn btn-primary type=" button" onclick="#">Draft</button> -->
						</div>
					</div>
					<div class="col-sm">
						<div class="form-group">
							<!-- <button class="btn btn-primary type=" button" onclick="#">Reset</button> -->
						</div>
					</div>
					<div class="col-sm">
						<div class="form-group">
							<!-- <button class="btn btn-primary type="button">Cancel</button> -->
						</div>
					</div>
					<div class="col-sm">
						<div class="form-group">
							<button style="width:100%;color:black;background-color:#F0F0F0;" class="btn mb-1 btn-secondary nextBtn btn-lg pull-right"
								type="button"><label><b><liferay-ui:message key="from-createmeeting-next" /></b></label></button>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="row setup-content" id="step-2" style="overflow-x:auto;">
			<div class="container">

				<div class="row" style="overflow-x:auto;">
					<table class="table table-striped dsng_chng_tabl"
						id="rsn_fr_chng_tabl">

						<tbody>
						<%
						if(!MeetingDetails.isEmpty()){
			for (TriggerMeetingDetails tm : MeetingDetails) {
				String formatExpDate=null;
				if(tm.getRESPONSE_DUEDATE()!=null){
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					SimpleDateFormat sdf2 = new SimpleDateFormat("MM-dd-yyyy");
				    String formatedDate = df.format(tm.getRESPONSE_DUEDATE());
				    formatExpDate = sdf2.format(df.parse(formatedDate));
				}
				else{
					formatExpDate="";
				}
				
		%>
							<tr>
								<td><label><liferay-ui:message key="from-createmeeting-category" /></label> <select
									id="category" name="Category" disabled="true">
										<%-- <option value="DCR"><%=tm.getCategory() %></option> --%>
										
								<%
								if(tm.getCategory().equalsIgnoreCase("from-createmeeting-dcr")){
									%>
									<option value="from-createmeeting-dcr"><label><liferay-ui:message key="from-createmeeting-dcr" /></label></option>
									
									<%-- <label><liferay-ui:message key="from-internal" /></label><%=MeetinInfo.getMeetingType() %></option> --%>
								<%}else{%>
								
									<%-- <option value="DCR"><%=tm.getCategory() %></option> --%>
									
									<option value="from-createmeeting-other"><label><liferay-ui:message key="from-createmeeting-other" /></label></option>
									
									<%-- <label><liferay-ui:message key="from-external" /></label><%=MeetinInfo.getMeetingType() %></option> --%>
								<%}%>
										
										
										<!-- <option value="Other">Other</option> -->
								</select></td>
								<td><label><liferay-ui:message key="from-createmeeting-floor" /></label> <input type="text" id="floor" disabled="true"
									name="Floor" value="<%=tm.getFloor() %>" readonly="readonly"></td>
								<td><label><liferay-ui:message key="from-createmeeting-items" /></label> 
								<input type="text" id="items" disabled="true"
									name="Items" value="<%=tm.getItem() %>" readonly="readonly"></td>
								<td><label><liferay-ui:message key="from-createmeeting-action" /></label> 
								<input type="text" id="action" disabled="true"
									name="Action" value="<%=tm.getActions() %>" readonly="readonly"></td>
								<%-- <td><label>Expected Due Date</label> <input type="text"
									value="" id="expectedDueDate" name="ExpectedDueDate" value="<%=formatExpDate %>" readonly="readonly"></td> --%>
									<td><label><liferay-ui:message key="from-createmeeting-duedate" /></label>
									 <input type="text" disabled="true"
									id="expectedDueDate" name="expectedDueDate" value="<%=formatExpDate %>" readonly="readonly"></td>
								<td><label><liferay-ui:message key="from-createmeeting-personIncharge" /></label> 
								<input type="text" disabled="true"
									id="persionInCharge" name="PersionInCharge" value="<%=tm.getPersonInCharge() %>" readonly="readonly"></td>
									<!-- <td><input type="button" value="Remove"></td> -->

							</tr>
							<%
			}
						}
							%>
						</tbody>

					</table>
					<p id="test"></p>
					<div class="col-sm">
						<!-- <button type="button" class="btn btn-primary add_btn"
							style="float: right;" onclick="addRow()">Add More</button> --></div>
							
					</div>
				</div>

				<!-- <div class="row">
					<div class="col-sm">
						<div class="form-group">
							<button class="btn btn-primary type=" button" onclick="#">Draft</button>
						</div>
					</div>
					<div class="col-sm">
						<div class="form-group">
							<button class="btn btn-primary type=" button" onclick="#">Reset</button>
						</div>
					</div>
					<div class="col-sm">
						<div class="form-group">
							<button class="btn btn-primary type="button">Cancel</button>
						</div>
					</div>
					<div class="col-sm">
						<div class="form-group">
							<button class="btn btn-primary type="button">Submit</button>
						</div>
					</div>
				</div> -->

			</div>
	</form>
</div>