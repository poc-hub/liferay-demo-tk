<%@ include file="/init.jsp"%>
<%@page import="java.util.*"%>
<%@page import="com.takenaka.model.TriggerMeeting"%>
<%@page import="com.takenaka.service.*"%>
<%@page import="java.text.*"%>

<!--<script type="text/javascript" src="<%request.getContextPath();%>/js/main.js"></script>  -->

 <!-- <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet"> -->
 <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.css">
  
 <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> -->
 
 
   
 <!-- <p>
	<b><liferay-ui:message key="meetingcontroller.caption" /></b>
</p> -->
<!-- <portlet:actionURL name="SearchAction" var="searchVar" /> -->
<!-- <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.css">
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.js/data-senna-track='temporary'"></script>
 -->

 <portlet:actionURL name="AddDetailsMeeting" var="addDetailsMeetingajax">
</portlet:actionURL>
  
 
<aui:script>
function save(){
	        var MeetingId=$("#<portlet:namespace />meetingId").val();
	        var MeetingType=$("#<portlet:namespace />meetingType").val();
	        var Issuer=$("#<portlet:namespace />issuer").val();
	        var MeetingFromDate=$("#<portlet:namespace />meetingFromDate").val();
	        var MeetingToDate=$("#<portlet:namespace />meetingToDate").val();
	        var MeetingTitle=$("#<portlet:namespace />meetingTitle").val();
	        console.log(MeetingId);
	        console.log(MeetingToDate);
	        console.log(MeetingFromDate);
	          if(MeetingType=="" && MeetingId=="" && Issuer=="" && MeetingFromDate=="" && MeetingToDate=="" && MeetingTitle==""){
			alert("Please select atleast one field");
			}        
			else{
			
  var table = $('#default').DataTable();
  var ajaxUrl = '<%=saveDataUrl%>';
  var createUrl = '<%=addDetailsMeetingajax%>';
  var requestType = "search";
  ajaxUrl = ajaxUrl+ "&MeetingType="+MeetingType;
  ajaxUrl = ajaxUrl + "&MeetingId="+MeetingId;
  ajaxUrl = ajaxUrl + "&Issuer="+Issuer;
  ajaxUrl = ajaxUrl+ "&MeetingFromDate="+MeetingFromDate;
  ajaxUrl = ajaxUrl + "&MeetingToDate="+MeetingToDate;
  ajaxUrl = ajaxUrl + "&MeetingTitle="+MeetingTitle;
  $('#default').dataTable().fnDestroy();
  $('#default').dataTable( {
                    "ajax": ajaxUrl,
                    "bFilter": false,
                    'columnDefs': [{
                         'targets': 1,
                         'searchable':false,
                         'orderable':false,
                         'className': 'dt-body-center',
                         'render': function (data, type, full, meta){
                         var createUrl1=createUrl+"&MeetingId="+data;
                           var  data1 = '<a href="' + createUrl1 + '">' + data + '</a>';
                           return data1;
                         }
                    }]
                    
                                         });
  
}
}

//$('#mtng_indx_tabl').DataTable();
  //$('#mtng_indx_tabl_filter').hide();
  

 var valuer;
function valStartDate(){
	console.log("Insiade start");
    AUI().use('aui-base','aui-io-request', function(A){
       
        var MeetingFromDate=A.one("#<portlet:namespace/>meetingFromDate").get('value');
        console.log(MeetingFromDate);
        valuer = new Date(Date.parse(MeetingFromDate,"MMM dd yyyy"));
        console.log(new Date());
        console.log(valuer);
        });
        
        
        AUI().use('aui-form-validator',
  function(A) {
  var DEFAULTS_FORM_VALIDATOR = A.config.FormValidator;
                         A.mix(
                                    DEFAULTS_FORM_VALIDATOR.RULES,
                                    {
                                    customRuleForEndDate:function (val, fieldNode, ruleValue) {
                                  $(".customRuleForEndDate").closest("div").remove();
                                  		value = new Date(Date.parse(val,"MMM dd yyyy"));
                                  
                                  		if(value > new Date()) {
                                  			return false;
                                  		}
                                  		else {
                                  			return true;
                                  		}
                                       }, 
                                    },
                                    true
                        );
                         A.mix(
                                    DEFAULTS_FORM_VALIDATOR.STRINGS,
                                    {
                                                customRuleForEndDate:"Meeting date should be today or day before",
                                    },
                                    true
                        );
    var rules = {
      <portlet:namespace/>Meeting_From_Date: {
      	customRuleForEndDate: true
      },
    };

    var fieldStrings = {};
    new A.FormValidator(
      {
        boundingBox: '#<portlet:namespace/>dateForm',
        fieldStrings: fieldStrings,
        rules: rules,
        showAllMessages: true
      }
    );
  }
);
        
}


function valEndDate() {
	console.log("Insiade end");
AUI().use('aui-form-validator',
  function(A) {
  var DEFAULTS_FORM_VALIDATOR = A.config.FormValidator;
                         A.mix(
                                    DEFAULTS_FORM_VALIDATOR.RULES,
                                    {
                                    customRuleForEndDate:function (val, fieldNode, ruleValue) {
                                  		value = new Date(Date.parse(val,"MMM dd yyyy"));
                                  		$(".customRuleForEndDate").closest("div").remove();
                                  		if(value < valuer) {
                                  			console.log(value);
                                  			console.log(valuer);
                                  			return false;
                                  		}
                                  		else {
                                  			return true;
                                  		}
                                       }, 
                                    },
                                    true
                        );
                         A.mix(
                                    DEFAULTS_FORM_VALIDATOR.STRINGS,
                                    {
                                                customRuleForEndDate:"Meeting end date should be on or after start date",
                                    },
                                    true
                        );
    var rules = {
     <portlet:namespace/>Meeting_To_Date: {
      	customRuleForEndDate: true
      },
    };

    var fieldStrings = {};
    new A.FormValidator(
      {
        boundingBox: '#<portlet:namespace/>dateForm',
        fieldStrings: fieldStrings,
        rules: rules,
        showAllMessages: true
      }
    );
  }
);
 
}
function reset(){
//alert("Hello Rest")
document.getElementById("<portlet:namespace/>meetingType").value="";
document.getElementById("<portlet:namespace/>meetingId").value="";
document.getElementById("<portlet:namespace/>issuer").value="";
document.getElementById("<portlet:namespace/>meetingFromDate").value="";
document.getElementById("<portlet:namespace/>meetingToDate").value="";
document.getElementById("<portlet:namespace/>meetingTitle").value="";
       
}
</aui:script>
 <aui:form name="dateForm" id="myForm">
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
					<aui:input type="date" pattern="\d{1,2}/\d{1,2}/\d{4}" name="Meeting_From_Date" id="meetingFromDate" 
					 label="from-meetingIndex-meetingdatefrom" onchange="valStartDate()">     					
					</aui:input>
					 <!-- <input
						class="form-control" type="date" value="" id="meetingFrmDate"
						name="MeetingFromDate">  -->
				</div>
			</div>
			<div class="col-sm">
				<div class="form-group">
					<aui:input type="date" name="Meeting_To_Date" id="meetingToDate" 
					label="from-meetingIndex-meetingdateto" onchange="valEndDate()" />
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
		<div class="row">
		<div class="col-sm-2"></div>
		<div class="col-sm-2"></div>
		<div class="col-sm-2"></div>
		<div class="col-sm-2"></div>
			<div class="col-sm-4">
			<aui:button class="btn btn-secondary mb-2" style=" margin:0px 0px 10px 0px; width:60%; color:black;float:right;pxbackground-color:#F0F0F0;" 
			type="button" name="saveButton" value="from-meetingIndex-search" onclick="save();" />
			</div>
			</div>
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
<%i = 1;%>
<div id="Data"></div>
<br>

<div class="row">
	<div class="col-sm-2"></div>
	<div class="col-sm-4">

		<aui:button-row>
			<aui:button style="width:100%;
			background-color:#F0F0F0;color:black;margin:0px 50px 0px 0px;" onClick="<%=createMeeting.toString()%>"
				class="btn btn-secondary mt-1" value="from-meetingIndex-create"></aui:button>
		</aui:button-row>


	</div>
	<div class="col-sm-4">
		<center>
			<aui:button style="width:100%;color:black;background-color:#F0F0F0;;
		margin:20px 0px 0px 75px;" type="button"
				class="btn btn-secondary mt-1" value="from-meetingIndex-reset" onclick="reset()"></aui:button>
			
			<!-- <button type="button" class="btn btn-secondary" value="from-meetingIndex-reset"></button> -->
		</center>
	</div>
	<div class="col-sm-2"></div>
</div>

</div>
