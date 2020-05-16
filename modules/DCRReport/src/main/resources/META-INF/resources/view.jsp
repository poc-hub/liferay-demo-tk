<%@ include file="/init.jsp" %>

<portlet:renderURL var="viewDCR">
	<portlet:param name="mvcPath" value="/viewDCR.jsp"/>
	
</portlet:renderURL> 

<portlet:renderURL var="approvalChange">
	<portlet:param name="mvcPath" value="/itemApproval.jsp"/>
</portlet:renderURL>

<portlet:actionURL name="reqApproval" var="submitApproval"/>

<script type="text/javascript" charset="utf8" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.css">
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.js"></script>



<style>
.message-container{
padding:10px;
margin:2px;
display:none;
background: rgba(128, 128, 128, 0.33);
border: 1px solid #0A0A0C;
}

table.dataTable thead th, table.dataTable thead td {
padding: 10px 15px !important;
border-bottom: 1px solid #111 ;
}
</style>

<portlet:resourceURL var="usersObjectArrayURL" id="usersObjects">
<portlet:param name="cmd" value="jsonUserObjectArray"/>
</portlet:resourceURL>

<aui:form name="dcrIndexSearch">
	<div class="container">
		<div class="row">
			<div class="col-sm">
				<div class="form-group">
				
				<!-- <aui:input type="text" label="from-dcrIndex-reasonforchange"  name="ReasonforChange" id="ReasonforChange"  /> -->
				
					 <aui:select label="from-dcrIndex-reasonforchange" name="ReasonforChange" id="ReasonforChange">
					 <aui:option value=""></aui:option>
						<aui:option value="from-dcrNew-custrequested"><label><liferay-ui:message key="from-dcrNew-custrequested" /></aui:option>
						<aui:option value="from-dcrNew-legal"><label><liferay-ui:message key="from-dcrNew-legal" /></aui:option>
						<aui:option value="from-dcrNew-designimprov"><label><liferay-ui:message key="from-dcrNew-designimprov" /></aui:option>
						<aui:option value="from-dcrNew-consImprov"><label><liferay-ui:message key="from-dcrNew-consImprov" /></aui:option>
						<aui:option value="from-dcrNew-others"><label><liferay-ui:message key="from-dcrNew-others" /></aui:option>
					</aui:select> 
					
					
					</div>
					</div>
					<div class="col-sm">
					<div class="form-group">
					<aui:input type="text" label="from-dcrview-issuer" name="Issuer" id="Issuer"  />
					</div>
					</div>
					<div class="col-sm">
					<div class="form-group">
					
					<!-- <aui:input type="text" label="from-dcrNew-rangeofdisclosure" name="Rangeofdisclosure" id="Rangeofdisclosure"/> -->
					
					 <aui:select label="from-dcrNew-rangeofdisclosure" name="Rangeofdisclosure" id="Rangeofdisclosure">
					 <aui:option value=""></aui:option>
						<aui:option value="from-customer"><label><liferay-ui:message key="from-customer" /></label></aui:option>
						<aui:option value="from-partner"><label><liferay-ui:message key="from-partner" /></label></aui:option>
						<aui:option value="from-internal"><label><liferay-ui:message key="from-internal" /></label></aui:option>
					</aui:select>
					</div>
					</div>
					<div class="col-sm">
					<div class="form-group">
					
					<!-- <aui:input type="text" label="from-dcrNew-changerequestedby" name="ChangeRequestedBy" id="ChangeRequestedBy"/> -->
					
					 <aui:select label="from-dcrNew-changerequestedby" name="ChangeRequestedBy" id="ChangeRequestedBy">
					 <aui:option value=""></aui:option>
						<aui:option value="from-customer"><label><liferay-ui:message key="from-customer" /></label></aui:option>
						<aui:option value="from-partner"><label><liferay-ui:message  key="from-partner" /></label></aui:option>
						<aui:option value="from-internal"><label><liferay-ui:message key="from-internal" /></label></aui:option>
					</aui:select> 
					
					</div>
					</div>
					</div>
					<div class="row">
					<div class="col-sm">
					<div class="form-group">
					<aui:input type="date" name="DCR_from_date"  id="dcrFromDate"  label="from-dcrIndex-initiatedFrom" onchange="valStartDate()"/>
					</div>
					</div>
					<div class="col-sm">
					<div class="form-group">
					<aui:input type="date" name="DCR_to_date" id="dcrToDate"   label="from-dcrIndex-initiatedto" onchange="valEndDate()"/>
					</div>
					</div>
					<div class="col-sm">
					<div class="form-group">
					<!-- <aui:input type="text" label="from-dcrIndex-approvalstatus" name="Approval" id="Approval"  /> -->
					
					<aui:select label="from-dcrIndex-approvalstatus" name="Approval" id="Approval">
						<aui:option value=""></aui:option>
      					<aui:option value="from-itemapproval-yes"><label><liferay-ui:message key="from-itemapproval-yes" /></label></aui:option>
      					<aui:option value="from-itemapproval-no"><label><liferay-ui:message key="from-itemapproval-no" /></label></aui:option>
      				</aui:select>
      				
					</div>
					</div>
					<div class="col-sm">
					<div class="form-group">
					<aui:input type="text" label="from-dcrview-constructionstatus" name="ConstructionStatus" id="ConstructionStatus"  />
					
					
					<!-- <aui:select label="Construction Status" name="CustomerApproval" id="CustomerApproval">
      					<aui:option value="from-itemapproval-yes"><label><liferay-ui:message key="from-itemapproval-yes" /></label></aui:option>
      					<aui:option value="from-itemapproval-no"><label><liferay-ui:message key="from-itemapproval-no" /></label></aui:option>
      				</aui:select> -->
					
					</div>
					</div>
					</div>
					<div class="row">
					<div class="col-sm">
					<div class="form-group">
					<!-- <aui:input type="text" label="from-dcrview-expensepayment" name="ExpensePayment" id="ExpensePayment"  /> -->
					
					 <aui:select label="from-dcrNew-expensepayment" name="ExpensePayment" id="ExpensePayment">
					 <aui:option value=""></aui:option>
					<aui:option value="from-dcrNew-yes"><label><liferay-ui:message key="from-dcrNew-yes" /></label></aui:option>
					<aui:option value="from-dcrNew-no"><label><liferay-ui:message key="from-dcrNew-no" /></label></aui:option>
					</aui:select>
					</div>
					</div>
					<div class="col-sm">
					<div class="form-group">
						<!-- value="from-dcrIndex-search" -->
						<aui:button class="btn  btn-secondary" type="button" id="approveButton" onclick="serch();" style="
						    margin-bottom: -64px;" value="from-dcrIndex-search"></aui:button>					
					</div>
					
					
					</div>
					<div class="col-sm">
					<div class="form-group">
					<aui:button class="btn  btn-secondary"  style="margin-left: -110px;margin-top: 25px;" type="reset" value="from-meetingpopup-reset"></aui:button>
					<!-- &nbsp; -->
					</div>
					</div>
					<div class="col-sm">
					&nbsp;
					</div>
					
</aui:form>

<div class="container">
<div class="row">
	<div class="col-sm">

<table id="userTable" class="display" cellspacing="0" width="100%">
<thead>
<tr>
<th><!-- <label><liferay-ui:message key="from-dcrIndex-srno" /></label> --></th>
<th><label><liferay-ui:message key="from-dcrIndex-changerequestedby"/></label></th>
<th><label><liferay-ui:message key="from-dcrIndex-dcrid" /></label></th>
<th><label><liferay-ui:message key="from-dcrIndex-items" /></label></th>
<th><label><liferay-ui:message key="from-dcrIndex-action" /></label></th>
<th><label><liferay-ui:message key="from-dcrIndex-floor" /></label></th>
<th><label><liferay-ui:message key="from-dcrIndex-design" /></label></th>
<th><label><liferay-ui:message key="from-dcrIndex-construction" /></label></th>
<th><label><liferay-ui:message key="from-dcrIndex-expense" /></label></th>
<th><label><liferay-ui:message key="from-dcrIndex-initiationdate" /></label></th>
<th><label><liferay-ui:message key="from-dcrIndex-approvalstatus" /></label></th>
</tr>
</thead>
</table>
</div>
</div>
</div>

<script>


$(document).ready(function() {
$('#userTable').dataTable( {
"ajax": "<%=usersObjectArrayURL%>",
"bFilter": false,
'columnDefs': [{
'targets': 0,
'searchable':false,
'orderable':false,
'className': 'dt-body-center',
'render': function (data, type, full, meta){
return '<input type="checkbox" name="id[]" value="'
+ $('<div/>').text(data).html() + '">';
}
}]
} );

} );


/* $(#approveButton).click(function(){

alert("Hello");


} ); */
function serch(){


/*
 * ReasonforChange
 Issuer
 Rangeofdisclosure
 ChangeRequestedBy
 dcrFromDate
 dcrToDate
 Approval
 ConstructionStatus
 ExpensePayment
 */
var reasonForChange=document.getElementById("<portlet:namespace/>ReasonforChange").value;
var issuer=document.getElementById('<portlet:namespace/>Issuer').value;
var rangeOfDisclosure=document.getElementById('<portlet:namespace/>Rangeofdisclosure').value;
var changeReqBy=document.getElementById('<portlet:namespace/>ChangeRequestedBy').value;
var dcrFromDate=document.getElementById('<portlet:namespace/>dcrFromDate').value;
var dcrToDate=document.getElementById('<portlet:namespace/>dcrToDate').value;
var approval=document.getElementById('<portlet:namespace/>Approval').value;
var construction=document.getElementById('<portlet:namespace/>ConstructionStatus').value;
var expensePayment=document.getElementById('<portlet:namespace/>ExpensePayment').value;
if(reasonForChange=="" && issuer=="" && rangeOfDisclosure=="" && 
		changeReqBy=="" && dcrFromDate=="" && dcrToDate=="" && approval=="" && 
		construction=="" && expensePayment==""){
	alert("Please enter atleast one field");
}
else{
	console.log('before printing elements');
	console.log("Hello"+reasonForChange+issuer+rangeOfDisclosure+changeReqBy+dcrFromDate+dcrToDate+approval+construction+expensePayment);
	var table = $('#userTable').DataTable();
	var ajaxUrl = '<%=usersObjectArrayURL%>';
	var query = "123";
	var requestType = "search";
	ajaxUrl = ajaxUrl + "&query="+query;
	ajaxUrl = ajaxUrl + "&requestType="+requestType+"&reasonForChange="+reasonForChange+"&issuer="+issuer+"&rangeOfDisclosure="+rangeOfDisclosure+"&changeReqBy="+changeReqBy+"&dcrFromDate="+dcrFromDate+"&dcrToDate="+dcrToDate+"&approval="+approval+"&construction="+construction+"&expensePayment="+expensePayment;

	$('#userTable').dataTable().fnDestroy();
	$('#userTable').dataTable( {
		"ajax": ajaxUrl,
		"bFilter": false,
		'columnDefs': [{
		'targets': 0,
		'searchable':false,
		'orderable':false,
		'className': 'dt-body-center',
		'render': function (data, type, full, meta){
		return '<input type="checkbox" name="id[]"   value="'
		+ $('<div/>').text(data).html() + '">';
		}
		}]
		});


	console.log($("input[type='checkbox']").val());

}
}
function myFunction(){
	
	var i=0;
	$('input[type=checkbox]').each(function (){
		//this.checked? i++ : ;
		if(this.checked){
			i++;
		}
	})
	var value1="";
	if(i>1){
		alert("Please select a single Item!");
	}
	else if(i==1){
		
		$('input[type=checkbox]').each(function (){
			if(value1==""){
				
				//this.checked? (value1=this.value) : "";
				if(this.checked){
					var str=this.value;
					var str2=str.split(",");
					value1=str2[0];
				}
				}
		});	
		var renderUrl="<%=viewDCR %>";
		renderUrl+="&recordId="+value1;
		window.location.href=renderUrl;	
	}else{
		alert('Please select a record!');
	}
	
	
	
	
	
	
	
	console.log(value1);
	
	
	
	//console.log('reached point 1');

	//console.log('reached point 2');

	//console.log('reached point 3');
	
	
}
/* function init() {
  
	document.getElementById("<portlet:namespace/>ReasonforChange").value="";
	document.getElementById('<portlet:namespace/>Issuer').value="";
	document.getElementById('<portlet:namespace/>Rangeofdisclosure').value="";
	document.getElementById('<portlet:namespace/>ChangeRequestedBy').value="";
	document.getElementById('<portlet:namespace/>dcrFromDate').value="";
	document.getElementById('<portlet:namespace/>dcrToDate').value="";
	document.getElementById('<portlet:namespace/>Approval').value="";
	document.getElementById('<portlet:namespace/>ConstructionStatus').value="";
	document.getElementById('<portlet:namespace/>ExpensePayment').value="";
}
window.onload = init */
var valuer;
function valStartDate(){
	console.log("Insiade start");
    AUI().use('aui-base','aui-io-request', function(A){
       
        var MeetingFromDate=A.one("#<portlet:namespace/>dcrFromDate").get('value');
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
      <portlet:namespace/>DCR_from_date: {
      	customRuleForEndDate: true
      },
    };

    var fieldStrings = {};
    new A.FormValidator(
      {
        boundingBox: '#<portlet:namespace/>dcrIndexSearch',
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
     <portlet:namespace/>DCR_to_date: {
      	customRuleForEndDate: true
      },
    };

    var fieldStrings = {};
    new A.FormValidator(
      {
        boundingBox: '#<portlet:namespace/>dcrIndexSearch',
        fieldStrings: fieldStrings,
        rules: rules,
        showAllMessages: true
      }
    );
  }
);
 
}

function approvalFucntion(){
	var i=0;
	$('input[type=checkbox]').each(function (){
		//this.checked? i++ : ;
		if(this.checked){
			i++;
		}
	})
	if(i>0){
		var index=0;
		var str="";
		var str2="";
		var recordarray=new Array(i);
		$('input[type=checkbox]').each(function (){
			//this.checked? i++ : ;
			if(this.checked){
				str=this.value;
				str2=str.split(",");
				recordarray[index]=str2[0];
				index++;
			}
		})
		var actionUrl="<%=submitApproval%>";
		actionUrl+="&size="+recordarray.length;
		for(var j=0;j<recordarray.length;j++){
			
			actionUrl+="&element"+j+"="+recordarray[j];
			
		}
		console.log(actionUrl);
		window.location.href=actionUrl;
		
	}else{
		alert('Please select atleast one record to continue');
	}
	
}
function approvalStatusChange(){
	var i=0;
	$('input[type=checkbox]').each(function (){
		//this.checked? i++ : ;
		if(this.checked){
			i++;
		}
	})
	var value1="";
	if(i>1){
		alert("Please select a single Item!");
	}
	else if(i==1){
		var str="";
		var str2="";
		var str3="";
		var str4="";
		var str5="";
		$('input[type=checkbox]').each(function (){
			if(value1==""){
				
				//this.checked? (value1=this.value) : "";
				if(this.checked){
					str=this.value;
					str2=str.split(",");
					str3=str2[0];
					str4=str2[1];
					str5=str2[2];
				}	
			}
		});
		//console.log(str3);
		//console.log(str4);
		if(str4==0){
			alert("Kindly select a record with approval number");
		}
		else{
			if(str5=="Approved-key"){
				alert('Record already approved !');
			}else{
				var renderUrl="<%=approvalChange%>";
				renderUrl+="&chngSeqNo="+str3;
				window.location.href=renderUrl;
			}
				
		}
		//var renderUrl="< %=approvalChange%>";
		//render
	}
	else{
		alert('Please select a record!');
	}
}
AUI().ready('aui-module', function(A){
	//document.getElementById('<portlet:namespace />dcrFromDate').valueAsDate = "";
	//document.getElementById('<portlet:namespace />dcrToDate').valueAsDate = "";
	document.getElementById('<portlet:namespace/>Rangeofdisclosure').value="";
	document.getElementById('<portlet:namespace />ExpensePayment').value = "";
	document.getElementById('<portlet:namespace />Approval').value = "";
	document.getElementById('<portlet:namespace />ConstructionStatus').value = "";
	document.getElementById("<portlet:namespace/>ReasonforChange").value;
	document.getElementById('<portlet:namespace/>ChangeRequestedBy').value="";
	document.getElementById('<portlet:namespace/>Issuer').value="";
});
AUI().use('aui-base',function(A){
	
	A.one('#<portlet:namespace/>Reset').on('click',function(){
		//document.getElementById('<portlet:namespace />dcrFromDate').valueAsDate = "";
		//document.getElementById('<portlet:namespace />dcrToDate').valueAsDate = "";
		document.getElementById('<portlet:namespace/>Rangeofdisclosure').value="";
		document.getElementById('<portlet:namespace />ExpensePayment').value = "";
		document.getElementById('<portlet:namespace />Approval').value = "";
		document.getElementById('<portlet:namespace />ConstructionStatus').value = "";
		document.getElementById("<portlet:namespace/>ReasonforChange").value;
		document.getElementById('<portlet:namespace/>ChangeRequestedBy').value="";
		document.getElementById('<portlet:namespace/>Issuer').value="";
	});
	
});

</script>

<aui:button-row>
<aui:button onClick="<%=createDCR.toString()%>"
value="from-dcrIndex-create"></aui:button>
<aui:button onClick="myFunction();"
value="from-dcrIndex-view"></aui:button>
<aui:button onCLick="approvalFucntion();" value="from-dcrIndex-reqapproval">
</aui:button>
<aui:button onClick="approvalStatusChange();" value="from-dcrIndex-approvalstatuschange">
</aui:button>

</aui:button-row>
