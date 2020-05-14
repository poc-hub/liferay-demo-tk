<%@ include file="/init.jsp"%>
 
 <%-- <script type="text/javascript" src="<%request.getContextPath();%>/js/main.js"></script> --%>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	
	document.getElementById('meetingDate').valueAsDate = new Date();
	document.getElementById('expectedDueDate').valueAsDate = new Date();
	/* var header = document.getElementById("myDIV");
	var btns = header.getElementsByClassName("step");
	for (var i = 0; i < btns.length; i++) {
	  btns[i].addEventListener("click", function() {
	  var current = document.getElementsByClassName("active");
	  current[0].className = current[0].className.replace(" active", "step");
	  this.className += " active";
	  });
	}
	 */
	
  });

</script>

<aui:script>
function dateChange(){
	console.log("inside method");
	var val=document.getElementById("meetingDate").value;
	var value = new Date(Date.parse(val,"MMM dd yyyy"));
    console.log("INside aui");
    var valuer=new Date();
    if(value > valuer) {
    	//document.getElementById("meetingDate").value("");
    	
        alert("Meeting Date should be today or before");
        $("#meetingDate").val("");
        document.getElementById("validationspan").innerHTML("Please fill date field");
         }
}
function newFunction() {
            document.getElementById("newForm").reset();
         }

</aui:script>
 
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
 --><style>
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
	float: right;
	background-color: #15A3E6 ;
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

<portlet:actionURL name="meetingAction" var="submitMeeting" />

<!-- <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css"> -->
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<div class="container">

<!-- 	<div class="stepwizard col-md-offset-3">
		<div class="stepwizard-row setup-panel">
			<div class="stepwizard-step">
				<a href="#step-1" type="button" class="btn btn-primary">
				<label><liferay-ui:message key="from-createmeeting-meetinginformation" /></label></a>
				<p></p>
			</div>
			<div class="stepwizard-step">
				<a href="#step-2" type="button" class="btn btn-default"
					disabled="disabled"><label><liferay-ui:message key="from-createmeeting-meetingdetails" /></label></a>
				<p></p>
			</div>
		</div>
	</div> -->
		<div class="stepwizard col-md-offset-3" >
		<div class="stepwizard-row setup-panel" id="myDIV" >
			<div class="stepwizard-step">
				<a href="#step-1" type="button" class="btn btn-primary active">
				<label><liferay-ui:message key="from-createmeeting-meetinginformation" /></label></a>
				<p></p>
			</div>
			<div class="stepwizard-step">
				<a href="#step-2" type="button"  class="btn btn-default active"
					disabled="disabled"><label><liferay-ui:message key="from-createmeeting-meetingdetails" /></label></a>
				<p></p>
			</div>
		</div>
	</div>

	<form name="meetingIndexForm" action="${submitMeeting}" method="POST" id="newForm">
		<div class="row setup-content" id="step-1">
			<div class="container">
				<div class="row">
					<div class="col-sm">
						<div class="form-group">
							<label for="usr">Project</label> <input type="text"
								class="form-control" id="project" name="Project"
								value="Takenaka" readonly="readonly">
						</div>
					</div>

					<div class="col-sm">
						<div class="form-group">
							<label><liferay-ui:message key="from-createmeeting-meetingid" /></label> <input type="text"
								class="form-control" id="meetingId" name="MeetingId" value=""
								readonly="readonly">
						</div>
					</div>

					<div class="col-sm">
						<div class="form-group">
							<label class="mandatory"><liferay-ui:message key="from-createmeeting-issuer" /></label> <input type="text"
								class="form-control" id="issuer" name="Issuer" required>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm">
						<div class="form-group">
							<label class="mandatory"><liferay-ui:message key="from-createmeeting-meetingtype" /></label> <select
								class="custom-select" id="meetingType" name="MeetingType">
								<option selected>Choose...</option>
								<option value="from-internal"><label><liferay-ui:message key="from-internal" /></label></option>
								<option value="from-external"><label><liferay-ui:message key="from-external" /></label></option>
							</select>
						</div>
					</div>

					<div class="col-sm">
						<div class="form-group">
							<label class="mandatory"><liferay-ui:message key="from-createmeeting-meetingdate" /></label> <input type="date"
								class="form-control" id="meetingDate" name="MeetingDate" onchange="dateChange()" required>
								<span class="validationspan"></span>
						</div>
					</div>

					<div class="col-sm">
						<div class="form-group">
							<label class="mandatory"><liferay-ui:message key="from-createmeeting-meetingplace" /></label><input type="text"
								class="form-control" id="meetingPlace" name="MeetingPlace" required>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm">
						<div class="form-group">
							<label class="mandatory"><liferay-ui:message key="from-createmeeting-meetingtitle" /></label> <input type="text"
								class="form-control" id="meetingTitle" name="MeetingTitle" required>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm">
						<div class="form-group">
							<label class="mandatory"><liferay-ui:message key="from-createmeeting-meetingparticipants" /></label> <input type="text"
								style="height:75px" class="form-control" id="meetingParticipants"
								name="MeetingParticipants" required>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-sm">
						<div class="form-group">
							<label><liferay-ui:message key="from-createmeeting-meetingsummary" /></label><input type="text"
								style="height:150px" class="form-control" id="meetingSummary" name="MeetingSummary">
						</div>
					</div>
				</div>
				
				<!-- added by <div class="row">
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
							<button class="btn btn-primary nextBtn btn-lg pull-right"
								type="button">Next</button>
						</div>
					</div>
				</div> -->
				</div>
				<div class="container">
				<div class="row">
					
					<div class="col-sm-4">
						<div class="form-group">
							<button type="reset" style="width:100%;color:black;background-color:#F0F0F0;" class="btn btn-default" type=" button" onclick="newFunction()"><label><liferay-ui:message key="from-createmeeting-reset" /></label></button>
						</div>
					</div>
					<div class="col-sm-4">
			<aui:button style="width:100%;color:black;background-color:#F0F0F0;" onClick="<%=indexMeeting.toString()%>"
				value="from-createmeeting-cancel"></aui:button>
		
						<%-- <div class="form-group">
							<button style="width:100%;color:black;background-color:#F0F0F0;" class="btn btn-default" type="button" onClick="<%=indexMeeting.toString()%>"><label><liferay-ui:message key="from-createmeeting-cancel" /></label></button>
						</div> --%>
					</div>
					 <div class="col-sm-4">
						<div class="form-group">
							<button style="width:100%;color:black;background-color:#F0F0F0;" class="btn btn-default nextBtn"
								type="button">Next</button>
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
						
							<tr>
								<td><label class="mandatory"><liferay-ui:message key="from-createmeeting-category" /></label> <select
									id="category" name="Category">
										<option value="from-createmeeting-dcr"><label><liferay-ui:message key="from-createmeeting-dcr" /></label></option>
										<option value="from-createmeeting-other"><label><liferay-ui:message key="from-createmeeting-other" /></label></option>
								</select></td>
								<td><label class="mandatory"><liferay-ui:message key="from-createmeeting-floor" /></label>  <input type="text" id="floor"
									name="Floor" required></td>
								<td><label class="mandatory"><liferay-ui:message key="from-createmeeting-items" /></label> <input type="text" id="items"
									name="Items" required></td>
								<td><label class="mandatory"><liferay-ui:message key="from-createmeeting-action" /></label> <input type="text" id="action"
									name="Action" required></td>
								<td><label class="mandatory"><liferay-ui:message key="from-createmeeting-duedate" /></label> 
								<input type="date"
									value="" id="expectedDueDate" name="ExpectedDueDate" required></td>
								<td><label class="mandatory"><liferay-ui:message key="from-createmeeting-personIncharge" /></label> <input type="text"
									id="persionInCharge" name="PersionInCharge" required></td>
									<td><button style="display:none;" type="button" class="btn btn-primary" id="remove" value="Remove"><label></label></button></td>

							</tr>
						</tbody>

						<tbody>
						
						
					</table>
					</div>
					<p id="test"></p>
					<div class="col-sm">
					<!-- <liferay-ui:message key="from-createmeeting-additems" /> -->
						<button type="button"
							style="float: right;" onclick="addRow()" class="btn add_btn">
							<i class="fa fa-plus" aria-hidden="true"></i><label></label>
							</button></div>
							
					
				</div>
				<div class="container">
				<div class="row">
					<div class="col-sm-4">
						<div class="form-group">
							<button style="width:100%;color:black;background-color:#F0F0F0;
							margin: 50px 0px 0px 0px;" class="btn btn-default" type="button" onclick="newFunction()">Reset</button>
						</div>
					</div>
					<div class="col-sm-4">
						
							<aui:button style="width:100%;color:black;background-color:#F0F0F0;
							margin: 50px 0px 0px 0px;" onClick="<%=indexMeeting.toString()%>"
				value="from-createmeeting-cancel"></aui:button>
						
					</div>
					<div class="col-sm-4">
						<div class="form-group">
							<button style="width:100%;color:black;background-color:#F0F0F0;
							margin: 50px 0px 0px 0px;" class="btn btn-default" type="submit">Submit</button>
						
						</div>
					</div>
				</div>
					</div>
				
			</div>
	</form>
</div>

