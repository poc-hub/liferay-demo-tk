<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ include file="/init.jsp"%>
<%@page import="java.util.*"%>
<%@page import="com.takenaka.model.TriggerMeeting"%>
<%@page import="com.takenaka.service.*"%>
<%@page import="java.text.*"%>
<%@page import="com.takenaka.model.TriggerMeeting"%>
<%@page import="com.takenaka.service.*"%>
<%@page import="com.takenaka.model.TriggerMeetingDetails"%>
<%@page import="com.takenaka.service.*"%>

<style>


.hide_column {
    display : none;
}
</style>
<!-- <p>
	<b><liferay-ui:message key="meetingcontroller.caption" /></b>
</p> -->
<!-- <portlet:actionURL name="SearchAction" var="searchVar" /> -->

<script type="text/javascript" charset="utf8" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.css">
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.js"></script>

<%
	int totalMeetings = TriggerMeetingLocalServiceUtil.getTriggerMeetingsCount();
	List<TriggerMeeting> Meetins = TriggerMeetingLocalServiceUtil.getTriggerMeetings(0, totalMeetings);
	System.out.println("---e---e---e->" + Meetins.size());
%>
<portlet:renderURL var="select">
	<portlet:param name="mvcPath" value="/CreateDCR.jsp"/>
</portlet:renderURL>
<aui:script>
<%-- function save(){
//alert("Calling save");
 AUI().use('aui-base','aui-io-request', function(A){
       
       var MeetingType=A.one("#<portlet:namespace />meetingType").get('value');
        var MeetingId=A.one("#<portlet:namespace />meetingId").get('value');
        var Issuer=A.one("#<portlet:namespace />issuer").get('value');
        var MeetingFrmDate=A.one("#<portlet:namespace />meetingFrmDate").get('value');
        var MeetingToDate=A.one("#<portlet:namespace />meetingToDate").get('value');
        var MeetingTitle=A.one("#<portlet:namespace />meetingTitle").get('value');
      //  alert(MeetingType);
        
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
               // alert(data[0].MeetingId);
                 var sno = 1;
				var i = 0;
				var j = 0;
				document.getElementById("Data").innerHTML = "";
             	var html = "<table class='table' id='default' ><thead><tr><th scope='col'></th><th scope='col'><liferay-ui:message key="from-meetingIndex-srno" /></th><th scope='col'><liferay-ui:message key="from-meetingIndex-meetingid" /></th><th scope='col'> <liferay-ui:message key="from-meetingIndex-issuer" /></th><th scope='col'><liferay-ui:message key="from-meetingIndex-meetingdate" /></th><th scope='col'><liferay-ui:message key="from-meetingIndex-meetingtype" /></th><th scope='col'><liferay-ui:message key="from-meetingIndex-meetingtitle"/></th><th scope='col'><liferay-ui:message key="from-createmeeting-floor" /></th><th scope='col'><liferay-ui:message key="from-createmeeting-items" /></th><th scope='col'><liferay-ui:message key="from-createmeeting-action" /></th>  <th scope='col' style='display:none;'></th><th scope='col' style='display:none;'></th>  </tr></thead><tbody>"; 
		
		for (i = 0; i < data.length; i++) { 
			
			var internal;
			
			if( data[i].MeetingType  == "from-internal"){
			internal ="Internal";
			}else{
			internal ="External";
			}
			html = html + "<tr><td><input type='radio' name='radioAjax' value='' /></th><td>"+ sno + "</td><td>" + data[i].MeetingId + "</td><td>" + data[i].Issuer + "</td><td>" + data[i].MeetingDate + "</td><td>" + internal + "</td><td>" + data[i].MeetingTitle + "</td><td>" + data[i].Floor + "</td><td>" + data[i].Items + "</td><td>" + data[i].Action + "</td><td style='display:none;'>" + data[i].dueDate + "</td><td style='display:none;'>" + data[i].person + "</td></tr>";
			
			 sno++; 
			 }
			  html = html + "</tbody></table>"
			  html = html + "<input type='button' class='btn  btn-secondary'  style='margin-top: 15px;margin-left: 15px;' value='Select' onclick='getAjaxPopUpdata();' />"
			$('#Data').html(html);
			$('#Data').show();
			$('#default').hide();
			$('#sltBtn').hide(); 
			
                }
            }
        });
        
        });
} --%>

function save(){

			 $("#getPopUpdata").hide();
			  $("#getAjaxPopUpdata").show();

	        var MeetingId=$("#<portlet:namespace />meetingId").val();
	        var MeetingType=$("#<portlet:namespace />meetingType").val();
	        var Issuer=$("#<portlet:namespace />issuer").val();
	        var MeetingFromDate=$("#<portlet:namespace />meetingFrmDate").val();
	        var MeetingToDate=$("#<portlet:namespace />meetingToDate").val();
	        var MeetingTitle=$("#<portlet:namespace />meetingTitle").val();
	        console.log(MeetingId);
	        console.log(MeetingToDate);
	        console.log(MeetingFromDate);
	          if(MeetingType=="" && MeetingId=="" && Issuer=="" && MeetingFromDate=="" && MeetingToDate=="" && MeetingTitle==""){
			alert("Please fill atleast one field");
			}        
			else{
			
  var table = $('#default').DataTable();
  var ajaxUrl = '<%=saveDataUrl%>';
 
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
					'targets': 0,
					'searchable':false,
					'orderable':false,
					'className': 'dt-body-center',
					'render': function (data, type, full, meta){
					return '<input type="radio" name="radioAjax" value=""'
					+ $('<div/>').text(data).html() + '">';
},
},


    { targets: 10,
      className: "hide_column"
    },
    
     { targets: 11,
      className: "hide_column"
    },

]
                   

});

}
}
</aui:script>
<aui:form name="meetingPopup">
	<div class="container">
		<div class="row">
			<div class="col-sm">
				<div class="form-group">
					<aui:select label="from-meetingIndex-meetingtype" name="Meeting Type"
						id="meetingType">
						<aui:option value=""></aui:option>
						<aui:option value="from-internal"><label><liferay-ui:message key="from-internal" /></label></aui:option>
						<aui:option value="from-external"><label><liferay-ui:message key="from-external" /></label></aui:option>
					</aui:select>
				</div>

			</div>
			<div class="col-sm">
				<div class="form-group">
					<aui:input label="from-meetingIndex-meetingid" type="text" name="Meeting Id"
						id="meetingId" />
					<!-- <input type="text"
						class="form-control" id="meetingId" name="MeetingId"> -->
				</div>
			</div>
			<div class="col-sm">
				<div class="form-group">
					<aui:input label="from-meetingIndex-issuer" type="text" name="Issuer" id="issuer" />
					<!-- <input type="text"
						class="form-control" id="issuer" name="Issuer"> -->
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-sm">
				<div class="form-group">
					<aui:input label="from-meetingIndex-meetingdatefrom" type="date"
						name="Meeting_From_Date" id="meetingFrmDate" onchange="valStartDate()" />
					<!-- <input
						class="form-control" type="date" value="" id="meetingFrmDate"
						name="MeetingFromDate"> -->
				</div>
			</div>
			<div class="col-sm">
				<div class="form-group">
					<aui:input label="from-meetingIndex-meetingdateto" type="date"
						name="Meeting_To_Date" id="meetingToDate" onchange="valEndDate()"/>
					<!-- <input
						class="form-control" type="date" value="" id="meetingToDate"
						name="MeetingToDate"> -->
				</div>
			</div>
			<div class="col-sm">
				<div class="form-group">
					<aui:input label="from-meetingIndex-meetingtitle" type="text" name="Meeting Title"
						id="meetingTitle" />
					<!-- <input type="text"
						class="form-control" id="meetingTitle" name="MeetingTitle"> -->
				</div>
			</div>
		</div>
		<aui:button type="button" name="saveButton" value="from-meetingpopup-search"
			onclick="save();" />
	</div>
</aui:form>
</form>

<div style="margin-top: 30px;margin-left: 50px;">
<table class="table" id="default">
	<thead>
		<tr>
			<th scope="col"></th>
			<th scope="col"> <liferay-ui:message key="from-meetingIndex-srno" /> </th>
			<th scope="col"> <liferay-ui:message key="from-meetingIndex-meetingid" /> </th>
			<th scope="col"> <liferay-ui:message key="from-meetingIndex-issuer" /> </th>
			<th scope="col"> <liferay-ui:message key="from-meetingIndex-meetingdate" /> </th>
			<th scope="col"> <liferay-ui:message key="from-meetingIndex-meetingtype" /> </th>
			<th scope="col"> <liferay-ui:message key="from-meetingIndex-meetingtitle"/> </th>
			<th scope="col"> <liferay-ui:message key="from-createmeeting-floor" /> </th>
			<th scope="col"> <liferay-ui:message key="from-createmeeting-items" /> </th>
			<th scope="col"> <liferay-ui:message key="from-createmeeting-action" /> </th>
			<th scope="col" style="display:none;"></th>
			<th scope="col" style="display:none;"></th>
		</tr>
	</thead>
	<tbody>
		<%!int j = 1;%>
		<%
			String frmDate;
			String resDate;
			if (!Meetins.isEmpty()) {
				for (TriggerMeeting tm : Meetins) {
					List<TriggerMeetingDetails> MeetinsDetails = new ArrayList<TriggerMeetingDetails>();
					//Adding Trigger Meeting table data
					// Adding Meeting Trigger Meeting table data
					if (tm.getMeetDate() != null) {
						SimpleDateFormat dfdate = new SimpleDateFormat("yyyy-MM-dd");
						SimpleDateFormat sdfdate = new SimpleDateFormat("MM-dd-yyyy");
					   String fDate = dfdate.format(tm.getMeetDate());
					   frmDate = sdfdate.format(dfdate.parse(fDate));
					} else {
						frmDate = "";
					}
				
					MeetinsDetails
							.addAll(TriggerMeetingDetailsLocalServiceUtil.findByMeetingSeqnoList(tm.getMeetingSeqno()));
					for (TriggerMeetingDetails tmd : MeetinsDetails) {
						
						if (tmd.getRESPONSE_DUEDATE() != null) {
							SimpleDateFormat rddate = new SimpleDateFormat("yyyy-MM-dd");
							SimpleDateFormat srddate = new SimpleDateFormat("MM-dd-yyyy");
						   String rDate = rddate.format(tmd.getRESPONSE_DUEDATE());
						   resDate = srddate.format(rddate.parse(rDate));
						} else {
							resDate = "";
						}
		%>
		<tr>
			<td><input type="radio" name="radio" value="<%=tm.getMeetingSeqno()%>" /></td>
			<td><%=j%></td>
			<td><%=tm.getMeetingId()%></td>
			<td><%=tm.getIssuer()%></td>
			<td><%=frmDate%></td>
			<td>
			<%
				if(tm.getMeetingType().equalsIgnoreCase("from-internal")){
				%>
				<label><liferay-ui:message key="from-internal" /></label><%-- <%=MeetinInfo.getMeetingType() %> --%></option>
				<%}else{%>
				<label><liferay-ui:message key="from-external" /></label><%-- <%=MeetinInfo.getMeetingType() %> --%></option>
				<%}%>
			
			</td>
			<td><%=tm.getMeetingTitle()%></td>
			<td><%=tmd.getFloor()%></td>
			<td><%=tmd.getItem()%></td>
			<td><%=tmd.getActions()%></td>
			<td style="display:none;"><%=resDate%></td>
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
</div>
<div id="Data"></div>
<br>
<div id="sltBtn">
<div class="row" style="margin-left: 30px;">
			<div class="col-sm">
				<div class="form-group">
<input type="button" class="btn  btn-secondary" id="getPopUpdata" value="<%=LanguageUtil.get(request, "from-meetingpopup-select") %>" onclick="getPopUpdata();" />

<input type="button" class="btn  btn-secondary"  id="getAjaxPopUpdata" value="<%=LanguageUtil.get(request, "from-meetingpopup-select") %>" onclick="getAjaxPopUpdata();"  style="display:none;" />
<input type="button" class="btn  btn-secondary"  value="<%=LanguageUtil.get(request, "from-meetingpopup-reset") %>"  onclick="resetValues();" />

</div>
</div>
</div>
</
</div>
<script type="text/javascript">

AUI().ready('aui-module', function(A){
	document.getElementById('<portlet:namespace />meetingToDate').valueAsDate = "";
	document.getElementById('<portlet:namespace />meetingFrmDate').valueAsDate = "";
	
});


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
	//	alert("ele.length" + ele.length);

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
			var ExpectedDueDate = window.opener.document.getElementById("<portlet:namespace/>ExpectedDueDate");
			
			if(dueDate ==null ||dueDate == ""){
				ExpectedDueDate.value = "";
			}else{
				var date = dueDate;
				var yourdate = dueDate.split("-");
				var mydate =yourdate[2]+"-"+yourdate[0]+"-"+yourdate[1];
				ExpectedDueDate.value = mydate;
			}
			
			/* alert(dueDate); */
			//ExpectedDueDate.value = dueDate.toString();
			//alert(ExpectedDueDate.value + ExpectedDueDate.value.toString());
			
			var PersoninCharge = window.opener.document.getElementById("PersoninCharge");
			PersoninCharge.value = personInCharge;
		} 
		window.close();
	}
////////////////////Method for Ajax table call//////////////////////
function getAjaxPopUpdata() {
		//alert("getAjaxPopUpdata");
		if (window.opener != null && !window.opener.closed) {
		//	alert("opener");
		var ele = document.getElementsByName('radioAjax');
		var meetId="";
		var floor="";
		var items="";
		var action="";
		var dueDate="";
		var personInCharge="";
	//	alert("ele.length" + ele.length);

		for (j = 0; j < ele.length; j++) {
			if (ele[j].checked) {
				//alert("J---"+j);
				//alert(document.getElementById("ajaxTable").rows[i + 1].innerHTML);
				//alert("Meeting Id"+ document.getElementById("default").rows[i + 1].cells[2].innerHTML);
				//alert("floor"+ document.getElementById("default").rows[i + 1].cells[7].innerHTML);
				  meetId= document.getElementById("default").rows[j+1].cells[2].innerHTML;
				  console.log(meetId);
		          floor = document.getElementById("default").rows[j+1].cells[7].innerHTML;
		          console.log(floor);
		          items= document.getElementById("default").rows[j+1].cells[8].innerHTML;
		          console.log(items);
		          action = document.getElementById("default").rows[j+1].cells[9].innerHTML;
		          console.log(action);
		           
		          dueDate= document.getElementById("default").rows[j+1].cells[11].innerHTML;
		           console.log(dueDate); 
		           personInCharge = document.getElementById("default").rows[j+1].cells[10].innerHTML;
		           console.log(personInCharge);
		            
		            
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
			//alert(Action);
			Action.value = action;
			
			var ExpectedDueDate = window.opener.document.getElementById("<portlet:namespace />ExpectedDueDate");
			//alert(dueDate);
			//alert(ExpectedDueDate);
			//ExpectedDueDate.value = dueDate.toString();
			//$("#ExpectedDueDate").val('2020-08-03');mm-dd-yyyy
			if(dueDate ==null ||dueDate == ""){
				ExpectedDueDate.value = "";
			}else{
				var date = dueDate;
				var yourdate = dueDate.split("-");
				var mydate =yourdate[2]+"-"+yourdate[0]+"-"+yourdate[1];
				ExpectedDueDate.value = mydate;
			}
			
			var date = dueDate;
			var yourdate = dueDate.split("-");
			var mydate =yourdate[2]+"-"+yourdate[0]+"-"+yourdate[1];
			ExpectedDueDate.value = mydate;
			var PersoninCharge = window.opener.document.getElementById("PersoninCharge");
			PersoninCharge.value = personInCharge;
			
			
		} 
		window.close();
	}
</script>
<aui:script>

var valuer;
function valStartDate(){
	console.log("Insiade start");
    AUI().use('aui-base','aui-io-request', function(A){
       
        var MeetingFromDate=A.one("#<portlet:namespace/>meetingFrmDate").get('value');
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
        boundingBox: '#<portlet:namespace/>meetingPopup',
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
                                    	$(".customRuleForEndDate").closest("div").remove();
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
        boundingBox: '#<portlet:namespace/>meetingPopup',
        fieldStrings: fieldStrings,
        rules: rules,
        showAllMessages: true
      }
    );
  }
);
 
}
function resetValues(){
	document.getElementById('<portlet:namespace/>meetingType').value="";
	document.getElementById('<portlet:namespace/>meetingId').value="";
	document.getElementById('<portlet:namespace/>issuer').value="";
	document.getElementById('<portlet:namespace/>meetingFrmDate').value="";
	document.getElementById('<portlet:namespace/>meetingToDate').value="";
	document.getElementById('<portlet:namespace/>meetingTitle').value="";
	
}
</aui:script>