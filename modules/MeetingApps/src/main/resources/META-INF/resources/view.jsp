<%@ include file="/init.jsp"%>
<%@page import="java.util.*"%>
<%@page import="com.takenaka.model.TriggerMeeting"%>
<%@page import="com.takenaka.service.*"%>
<%@page import="java.text.*"%>

<script type="text/javascript" src="<%request.getContextPath();%>/js/main.js"></script>
<!-- <p>
	<b><liferay-ui:message key="meetingcontroller.caption" /></b>
</p> -->
<!-- <portlet:actionURL name="SearchAction" var="searchVar" /> -->
<link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet"> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

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
$('#mtng_indx_tabl').DataTable();
  $('#mtng_indx_tabl_filter').hide();
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
</aui:script>
<!-- <style>
table.dataTable{clear:both;margin-top:6px !important;margin-bottom:6px !important;max-width:none !important;border-collapse:separate !important}table.dataTable td,table.dataTable th{-webkit-box-sizing:content-box;box-sizing:content-box}table.dataTable td.dataTables_empty,table.dataTable th.dataTables_empty{text-align:center}table.dataTable.nowrap th,table.dataTable.nowrap td{white-space:nowrap}div.dataTables_wrapper div.dataTables_length label{font-weight:normal;text-align:left;white-space:nowrap}div.dataTables_wrapper div.dataTables_length select{width:75px;display:inline-block}div.dataTables_wrapper div.dataTables_filter{text-align:right}div.dataTables_wrapper div.dataTables_filter label{font-weight:normal;white-space:nowrap;text-align:left}div.dataTables_wrapper div.dataTables_filter input{margin-left:0.5em;display:inline-block;width:auto}div.dataTables_wrapper div.dataTables_info{padding-top:8px;white-space:nowrap}div.dataTables_wrapper div.dataTables_paginate{margin:0;white-space:nowrap;text-align:right}div.dataTables_wrapper div.dataTables_paginate ul.pagination{margin:2px 0;white-space:nowrap}div.dataTables_wrapper div.dataTables_processing{position:absolute;top:50%;left:50%;width:200px;margin-left:-100px;margin-top:-26px;text-align:center;padding:1em 0}table.dataTable thead>tr>th.sorting_asc,table.dataTable thead>tr>th.sorting_desc,table.dataTable thead>tr>th.sorting,table.dataTable thead>tr>td.sorting_asc,table.dataTable thead>tr>td.sorting_desc,table.dataTable thead>tr>td.sorting{padding-right:30px}table.dataTable thead>tr>th:active,table.dataTable thead>tr>td:active{outline:none}table.dataTable thead .sorting,table.dataTable thead .sorting_asc,table.dataTable thead .sorting_desc,table.dataTable thead .sorting_asc_disabled,table.dataTable thead .sorting_desc_disabled{cursor:pointer;position:relative}table.dataTable thead .sorting:after,table.dataTable thead .sorting_asc:after,table.dataTable thead .sorting_desc:after,table.dataTable thead .sorting_asc_disabled:after,table.dataTable thead .sorting_desc_disabled:after{position:absolute;bottom:8px;right:8px;display:block;font-family:'Glyphicons Halflings';opacity:0.5}table.dataTable thead .sorting:after{opacity:0.2;content:"\e150"}table.dataTable thead .sorting_asc:after{content:"\e155"}table.dataTable thead .sorting_desc:after{content:"\e156"}table.dataTable thead .sorting_asc_disabled:after,table.dataTable thead .sorting_desc_disabled:after{color:#eee}div.dataTables_scrollHead table.dataTable{margin-bottom:0 !important}div.dataTables_scrollBody>table{border-top:none;margin-top:0 !important;margin-bottom:0 !important}div.dataTables_scrollBody>table>thead .sorting:after,div.dataTables_scrollBody>table>thead .sorting_asc:after,div.dataTables_scrollBody>table>thead .sorting_desc:after{display:none}div.dataTables_scrollBody>table>tbody>tr:first-child>th,div.dataTables_scrollBody>table>tbody>tr:first-child>td{border-top:none}div.dataTables_scrollFoot>.dataTables_scrollFootInner{box-sizing:content-box}div.dataTables_scrollFoot>.dataTables_scrollFootInner>table{margin-top:0 !important;border-top:none}@media screen and (max-width: 767px){div.dataTables_wrapper div.dataTables_length,div.dataTables_wrapper div.dataTables_filter,div.dataTables_wrapper div.dataTables_info,div.dataTables_wrapper div.dataTables_paginate{text-align:center}}table.dataTable.table-condensed>thead>tr>th{padding-right:20px}table.dataTable.table-condensed .sorting:after,table.dataTable.table-condensed .sorting_asc:after,table.dataTable.table-condensed .sorting_desc:after{top:6px;right:6px}table.table-bordered.dataTable th,table.table-bordered.dataTable td{border-left-width:0}table.table-bordered.dataTable th:last-child,table.table-bordered.dataTable th:last-child,table.table-bordered.dataTable td:last-child,table.table-bordered.dataTable td:last-child{border-right-width:0}table.table-bordered.dataTable tbody th,table.table-bordered.dataTable tbody td{border-bottom-width:0}div.dataTables_scrollHead table.table-bordered{border-bottom-width:0}div.table-responsive>div.dataTables_wrapper>div.row{margin:0}div.table-responsive>div.dataTables_wrapper>div.row>div[class^="col-"]:first-child{padding-left:0}div.table-responsive>div.dataTables_wrapper>div.row>div[class^="col-"]:last-child{padding-right:0}
</style> -->
<aui:form name="dateForm">
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
					<aui:input type="date" name="Meeting_From_Date" id="meetingFromDate" onchange="valStartDate()" label="from-meetingIndex-meetingdatefrom">     					
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
			<aui:button type="button" name="saveButton" value="from-meetingIndex-search" onclick="save();" />
	</div>
</aui:form>
</form>
<table class="table" id="mtng_indx_tabl">
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
			<aui:button style="width:100%;background-color:#D3D3D3;margin:0px 50px 0px 0px;" onClick="<%=createMeeting.toString()%>"
				value="from-meetingIndex-create"></aui:button>
		</aui:button-row>


	</div>
	<div class="col-sm-4">
		<center>
			<aui:button style="width:100%;background-color:#D3D3D3;
		margin:20px 0px 0px 75px;" type="reset"
				class="btn btn-secondary" value="from-meetingIndex-reset"></aui:button>
			
			<!-- <button type="button" class="btn btn-secondary" value="from-meetingIndex-reset"></button> -->
		</center>
	</div>
	<div class="col-sm-2"></div>
</div>

</div>
