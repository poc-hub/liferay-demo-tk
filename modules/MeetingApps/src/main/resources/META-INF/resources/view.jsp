<%@ include file="/init.jsp"%>
<%@page import="java.util.*"%>
<%@page import="com.takenaka.model.TriggerMeeting"%>
<%@page import="com.takenaka.service.*"%>
<%@page import="java.text.*"%>

<!--<script type="text/javascript" src="<%request.getContextPath();%>/js/main.js"></script>  -->

<!-- <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet"> 
 --><!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> -->

 <script src="../js/datatable.js" type="text/javascript"></script> 
 
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>  
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
        var MeetingFromDate=A.one("#<portlet:namespace />meetingFromDate").get('value');
        var MeetingToDate=A.one("#<portlet:namespace />meetingToDate").get('value');
        var MeetingTitle=A.one("#<portlet:namespace />meetingTitle").get('value');
       
        //alert(MeetingType);
			if(MeetingType=="" && MeetingId=="" && Issuer=="" && MeetingFromDate=="" && MeetingToDate=="" && MeetingTitle==""){
			alert("Please enter atleast one field");
			}        

        A.io.request('<%=saveDataUrl%>',{
            dataType: 'json',
            method: 'POST',
            data: { <portlet:namespace />MeetingType: MeetingType,
                     <portlet:namespace />MeetingId: MeetingId,
                     <portlet:namespace />Issuer: Issuer,
                     <portlet:namespace />MeetingFromDate: MeetingFromDate,
                     <portlet:namespace />MeetingToDate: MeetingToDate,
                     <portlet:namespace />MeetingTitle: MeetingTitle},
            on: {
            success: function() {
                var data=this.get('responseData');
                // Actions to be performed on success
   				alert(data);
                alert(data[0].MeetingId);
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
//$('#mtng_indx_tabl').DataTable();
  //$('#mtng_indx_tabl_filter').hide();
  
$('#default').DataTable();
$('#default_filter').hide();
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
<!-- <script>
function reset(){
	alert("Reset Method");
	
	document.getElementById("myForm").reset();
}
</script> -->
 <style>
/*
 * Table styles
 */
table.dataTable {
  width: 100%;
  margin: 0 auto;
  clear: both;
  border-collapse: separate;
  border-spacing: 0;
  /*
   * Header and footer styles
   */
  /*
   * Body styles
   */
}
table.dataTable thead th,
table.dataTable tfoot th {
  font-weight: bold;
}
table.dataTable thead th,
table.dataTable thead td {
  padding: 10px 18px;
  border-bottom: 1px solid #111;
}
table.dataTable thead th:active,
table.dataTable thead td:active {
  outline: none;
}
table.dataTable tfoot th,
table.dataTable tfoot td {
  padding: 10px 18px 6px 18px;
  border-top: 1px solid #111;
}
table.dataTable thead .sorting,
table.dataTable thead .sorting_asc,
table.dataTable thead .sorting_desc,
table.dataTable thead .sorting_asc_disabled,
table.dataTable thead .sorting_desc_disabled {
  cursor: pointer;
  *cursor: hand;
  background-repeat: no-repeat;
  background-position: center right;
}
table.dataTable thead .sorting {
  background-image: url("../images/sort_both.png");
}
table.dataTable thead .sorting_asc {
  background-image: url("../images/sort_asc.png");
}
table.dataTable thead .sorting_desc {
  background-image: url("../images/sort_desc.png");
}
table.dataTable thead .sorting_asc_disabled {
  background-image: url("../images/sort_asc_disabled.png");
}
table.dataTable thead .sorting_desc_disabled {
  background-image: url("../images/sort_desc_disabled.png");
}
table.dataTable tbody tr {
  background-color: #ffffff;
}
table.dataTable tbody tr.selected {
  background-color: #B0BED9;
}
table.dataTable tbody th,
table.dataTable tbody td {
  padding: 8px 10px;
}
table.dataTable.row-border tbody th, table.dataTable.row-border tbody td, table.dataTable.display tbody th, table.dataTable.display tbody td {
  border-top: 1px solid #ddd;
}
table.dataTable.row-border tbody tr:first-child th,
table.dataTable.row-border tbody tr:first-child td, table.dataTable.display tbody tr:first-child th,
table.dataTable.display tbody tr:first-child td {
  border-top: none;
}
table.dataTable.cell-border tbody th, table.dataTable.cell-border tbody td {
  border-top: 1px solid #ddd;
  border-right: 1px solid #ddd;
}
table.dataTable.cell-border tbody tr th:first-child,
table.dataTable.cell-border tbody tr td:first-child {
  border-left: 1px solid #ddd;
}
table.dataTable.cell-border tbody tr:first-child th,
table.dataTable.cell-border tbody tr:first-child td {
  border-top: none;
}
table.dataTable.stripe tbody tr.odd, table.dataTable.display tbody tr.odd {
  background-color: #f9f9f9;
}
table.dataTable.stripe tbody tr.odd.selected, table.dataTable.display tbody tr.odd.selected {
  background-color: #acbad4;
}
table.dataTable.hover tbody tr:hover, table.dataTable.display tbody tr:hover {
  background-color: #f6f6f6;
}
table.dataTable.hover tbody tr:hover.selected, table.dataTable.display tbody tr:hover.selected {
  background-color: #aab7d1;
}
table.dataTable.order-column tbody tr > .sorting_1,
table.dataTable.order-column tbody tr > .sorting_2,
table.dataTable.order-column tbody tr > .sorting_3, table.dataTable.display tbody tr > .sorting_1,
table.dataTable.display tbody tr > .sorting_2,
table.dataTable.display tbody tr > .sorting_3 {
  background-color: #fafafa;
}
table.dataTable.order-column tbody tr.selected > .sorting_1,
table.dataTable.order-column tbody tr.selected > .sorting_2,
table.dataTable.order-column tbody tr.selected > .sorting_3, table.dataTable.display tbody tr.selected > .sorting_1,
table.dataTable.display tbody tr.selected > .sorting_2,
table.dataTable.display tbody tr.selected > .sorting_3 {
  background-color: #acbad5;
}
table.dataTable.display tbody tr.odd > .sorting_1, table.dataTable.order-column.stripe tbody tr.odd > .sorting_1 {
  background-color: #f1f1f1;
}
table.dataTable.display tbody tr.odd > .sorting_2, table.dataTable.order-column.stripe tbody tr.odd > .sorting_2 {
  background-color: #f3f3f3;
}
table.dataTable.display tbody tr.odd > .sorting_3, table.dataTable.order-column.stripe tbody tr.odd > .sorting_3 {
  background-color: whitesmoke;
}
table.dataTable.display tbody tr.odd.selected > .sorting_1, table.dataTable.order-column.stripe tbody tr.odd.selected > .sorting_1 {
  background-color: #a6b4cd;
}
table.dataTable.display tbody tr.odd.selected > .sorting_2, table.dataTable.order-column.stripe tbody tr.odd.selected > .sorting_2 {
  background-color: #a8b5cf;
}
table.dataTable.display tbody tr.odd.selected > .sorting_3, table.dataTable.order-column.stripe tbody tr.odd.selected > .sorting_3 {
  background-color: #a9b7d1;
}
table.dataTable.display tbody tr.even > .sorting_1, table.dataTable.order-column.stripe tbody tr.even > .sorting_1 {
  background-color: #fafafa;
}
table.dataTable.display tbody tr.even > .sorting_2, table.dataTable.order-column.stripe tbody tr.even > .sorting_2 {
  background-color: #fcfcfc;
}
table.dataTable.display tbody tr.even > .sorting_3, table.dataTable.order-column.stripe tbody tr.even > .sorting_3 {
  background-color: #fefefe;
}
table.dataTable.display tbody tr.even.selected > .sorting_1, table.dataTable.order-column.stripe tbody tr.even.selected > .sorting_1 {
  background-color: #acbad5;
}
table.dataTable.display tbody tr.even.selected > .sorting_2, table.dataTable.order-column.stripe tbody tr.even.selected > .sorting_2 {
  background-color: #aebcd6;
}
table.dataTable.display tbody tr.even.selected > .sorting_3, table.dataTable.order-column.stripe tbody tr.even.selected > .sorting_3 {
  background-color: #afbdd8;
}
table.dataTable.display tbody tr:hover > .sorting_1, table.dataTable.order-column.hover tbody tr:hover > .sorting_1 {
  background-color: #eaeaea;
}
table.dataTable.display tbody tr:hover > .sorting_2, table.dataTable.order-column.hover tbody tr:hover > .sorting_2 {
  background-color: #ececec;
}
table.dataTable.display tbody tr:hover > .sorting_3, table.dataTable.order-column.hover tbody tr:hover > .sorting_3 {
  background-color: #efefef;
}
table.dataTable.display tbody tr:hover.selected > .sorting_1, table.dataTable.order-column.hover tbody tr:hover.selected > .sorting_1 {
  background-color: #a2aec7;
}
table.dataTable.display tbody tr:hover.selected > .sorting_2, table.dataTable.order-column.hover tbody tr:hover.selected > .sorting_2 {
  background-color: #a3b0c9;
}
table.dataTable.display tbody tr:hover.selected > .sorting_3, table.dataTable.order-column.hover tbody tr:hover.selected > .sorting_3 {
  background-color: #a5b2cb;
}
table.dataTable.no-footer {
  border-bottom: 1px solid #111;
}
table.dataTable.nowrap th, table.dataTable.nowrap td {
  white-space: nowrap;
}
table.dataTable.compact thead th,
table.dataTable.compact thead td {
  padding: 4px 17px 4px 4px;
}
table.dataTable.compact tfoot th,
table.dataTable.compact tfoot td {
  padding: 4px;
}
table.dataTable.compact tbody th,
table.dataTable.compact tbody td {
  padding: 4px;
}
table.dataTable th.dt-left,
table.dataTable td.dt-left {
  text-align: left;
}
table.dataTable th.dt-center,
table.dataTable td.dt-center,
table.dataTable td.dataTables_empty {
  text-align: center;
}
table.dataTable th.dt-right,
table.dataTable td.dt-right {
  text-align: right;
}
table.dataTable th.dt-justify,
table.dataTable td.dt-justify {
  text-align: justify;
}
table.dataTable th.dt-nowrap,
table.dataTable td.dt-nowrap {
  white-space: nowrap;
}
table.dataTable thead th.dt-head-left,
table.dataTable thead td.dt-head-left,
table.dataTable tfoot th.dt-head-left,
table.dataTable tfoot td.dt-head-left {
  text-align: left;
}
table.dataTable thead th.dt-head-center,
table.dataTable thead td.dt-head-center,
table.dataTable tfoot th.dt-head-center,
table.dataTable tfoot td.dt-head-center {
  text-align: center;
}
table.dataTable thead th.dt-head-right,
table.dataTable thead td.dt-head-right,
table.dataTable tfoot th.dt-head-right,
table.dataTable tfoot td.dt-head-right {
  text-align: right;
}
table.dataTable thead th.dt-head-justify,
table.dataTable thead td.dt-head-justify,
table.dataTable tfoot th.dt-head-justify,
table.dataTable tfoot td.dt-head-justify {
  text-align: justify;
}
table.dataTable thead th.dt-head-nowrap,
table.dataTable thead td.dt-head-nowrap,
table.dataTable tfoot th.dt-head-nowrap,
table.dataTable tfoot td.dt-head-nowrap {
  white-space: nowrap;
}
table.dataTable tbody th.dt-body-left,
table.dataTable tbody td.dt-body-left {
  text-align: left;
}
table.dataTable tbody th.dt-body-center,
table.dataTable tbody td.dt-body-center {
  text-align: center;
}
table.dataTable tbody th.dt-body-right,
table.dataTable tbody td.dt-body-right {
  text-align: right;
}
table.dataTable tbody th.dt-body-justify,
table.dataTable tbody td.dt-body-justify {
  text-align: justify;
}
table.dataTable tbody th.dt-body-nowrap,
table.dataTable tbody td.dt-body-nowrap {
  white-space: nowrap;
}

table.dataTable,
table.dataTable th,
table.dataTable td {
  box-sizing: content-box;
}

/*
 * Control feature layout
 */
.dataTables_wrapper {
  position: relative;
  clear: both;
  *zoom: 1;
  zoom: 1;
}
.dataTables_wrapper .dataTables_length {
  float: left;
}
.dataTables_wrapper .dataTables_filter {
  float: right;
  text-align: right;
}
.dataTables_wrapper .dataTables_filter input {
  margin-left: 0.5em;
}
.dataTables_wrapper .dataTables_info {
  clear: both;
  float: left;
  padding-top: 0.755em;
}
.dataTables_wrapper .dataTables_paginate {
  float: right;
  text-align: right;
  padding-top: 0.25em;
}
.dataTables_wrapper .dataTables_paginate .paginate_button {
  box-sizing: border-box;
  display: inline-block;
  min-width: 1.5em;
  padding: 0.5em 1em;
  margin-left: 2px;
  text-align: center;
  text-decoration: none !important;
  cursor: pointer;
  *cursor: hand;
  color: #333 !important;
  border: 1px solid transparent;
  border-radius: 2px;
}
.dataTables_wrapper .dataTables_paginate .paginate_button.current, .dataTables_wrapper .dataTables_paginate .paginate_button.current:hover {
  color: #333 !important;
  border: 1px solid #979797;
  background-color: white;
  background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, white), color-stop(100%, #dcdcdc));
  /* Chrome,Safari4+ */
  background: -webkit-linear-gradient(top, white 0%, #dcdcdc 100%);
  /* Chrome10+,Safari5.1+ */
  background: -moz-linear-gradient(top, white 0%, #dcdcdc 100%);
  /* FF3.6+ */
  background: -ms-linear-gradient(top, white 0%, #dcdcdc 100%);
  /* IE10+ */
  background: -o-linear-gradient(top, white 0%, #dcdcdc 100%);
  /* Opera 11.10+ */
  background: linear-gradient(to bottom, white 0%, #dcdcdc 100%);
  /* W3C */
}
.dataTables_wrapper .dataTables_paginate .paginate_button.disabled, .dataTables_wrapper .dataTables_paginate .paginate_button.disabled:hover, .dataTables_wrapper .dataTables_paginate .paginate_button.disabled:active {
  cursor: default;
  color: #666 !important;
  border: 1px solid transparent;
  background: transparent;
  box-shadow: none;
}
.dataTables_wrapper .dataTables_paginate .paginate_button:hover {
  color: white !important;
  border: 1px solid #111;
  background-color: #585858;
  background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #585858), color-stop(100%, #111));
  /* Chrome,Safari4+ */
  background: -webkit-linear-gradient(top, #585858 0%, #111 100%);
  /* Chrome10+,Safari5.1+ */
  background: -moz-linear-gradient(top, #585858 0%, #111 100%);
  /* FF3.6+ */
  background: -ms-linear-gradient(top, #585858 0%, #111 100%);
  /* IE10+ */
  background: -o-linear-gradient(top, #585858 0%, #111 100%);
  /* Opera 11.10+ */
  background: linear-gradient(to bottom, #585858 0%, #111 100%);
  /* W3C */
}
.dataTables_wrapper .dataTables_paginate .paginate_button:active {
  outline: none;
  background-color: #2b2b2b;
  background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #2b2b2b), color-stop(100%, #0c0c0c));
  /* Chrome,Safari4+ */
  background: -webkit-linear-gradient(top, #2b2b2b 0%, #0c0c0c 100%);
  /* Chrome10+,Safari5.1+ */
  background: -moz-linear-gradient(top, #2b2b2b 0%, #0c0c0c 100%);
  /* FF3.6+ */
  background: -ms-linear-gradient(top, #2b2b2b 0%, #0c0c0c 100%);
  /* IE10+ */
  background: -o-linear-gradient(top, #2b2b2b 0%, #0c0c0c 100%);
  /* Opera 11.10+ */
  background: linear-gradient(to bottom, #2b2b2b 0%, #0c0c0c 100%);
  /* W3C */
  box-shadow: inset 0 0 3px #111;
}
.dataTables_wrapper .dataTables_paginate .ellipsis {
  padding: 0 1em;
}
.dataTables_wrapper .dataTables_processing {
  position: absolute;
  top: 50%;
  left: 50%;
  width: 100%;
  height: 40px;
  margin-left: -50%;
  margin-top: -25px;
  padding-top: 20px;
  text-align: center;
  font-size: 1.2em;
  background-color: white;
  background: -webkit-gradient(linear, left top, right top, color-stop(0%, rgba(255, 255, 255, 0)), color-stop(25%, rgba(255, 255, 255, 0.9)), color-stop(75%, rgba(255, 255, 255, 0.9)), color-stop(100%, rgba(255, 255, 255, 0)));
  background: -webkit-linear-gradient(left, rgba(255, 255, 255, 0) 0%, rgba(255, 255, 255, 0.9) 25%, rgba(255, 255, 255, 0.9) 75%, rgba(255, 255, 255, 0) 100%);
  background: -moz-linear-gradient(left, rgba(255, 255, 255, 0) 0%, rgba(255, 255, 255, 0.9) 25%, rgba(255, 255, 255, 0.9) 75%, rgba(255, 255, 255, 0) 100%);
  background: -ms-linear-gradient(left, rgba(255, 255, 255, 0) 0%, rgba(255, 255, 255, 0.9) 25%, rgba(255, 255, 255, 0.9) 75%, rgba(255, 255, 255, 0) 100%);
  background: -o-linear-gradient(left, rgba(255, 255, 255, 0) 0%, rgba(255, 255, 255, 0.9) 25%, rgba(255, 255, 255, 0.9) 75%, rgba(255, 255, 255, 0) 100%);
  background: linear-gradient(to right, rgba(255, 255, 255, 0) 0%, rgba(255, 255, 255, 0.9) 25%, rgba(255, 255, 255, 0.9) 75%, rgba(255, 255, 255, 0) 100%);
}
.dataTables_wrapper .dataTables_length,
.dataTables_wrapper .dataTables_filter,
.dataTables_wrapper .dataTables_info,
.dataTables_wrapper .dataTables_processing,
.dataTables_wrapper .dataTables_paginate {
  color: #333;
}
.dataTables_wrapper .dataTables_scroll {
  clear: both;
}
.dataTables_wrapper .dataTables_scroll div.dataTables_scrollBody {
  *margin-top: -1px;
  -webkit-overflow-scrolling: touch;
}
.dataTables_wrapper .dataTables_scroll div.dataTables_scrollBody > table > thead > tr > th, .dataTables_wrapper .dataTables_scroll div.dataTables_scrollBody > table > thead > tr > td, .dataTables_wrapper .dataTables_scroll div.dataTables_scrollBody > table > tbody > tr > th, .dataTables_wrapper .dataTables_scroll div.dataTables_scrollBody > table > tbody > tr > td {
  vertical-align: middle;
}
.dataTables_wrapper .dataTables_scroll div.dataTables_scrollBody > table > thead > tr > th > div.dataTables_sizing,
.dataTables_wrapper .dataTables_scroll div.dataTables_scrollBody > table > thead > tr > td > div.dataTables_sizing, .dataTables_wrapper .dataTables_scroll div.dataTables_scrollBody > table > tbody > tr > th > div.dataTables_sizing,
.dataTables_wrapper .dataTables_scroll div.dataTables_scrollBody > table > tbody > tr > td > div.dataTables_sizing {
  height: 0;
  overflow: hidden;
  margin: 0 !important;
  padding: 0 !important;
}
.dataTables_wrapper.no-footer .dataTables_scrollBody {
  border-bottom: 1px solid #111;
}
.dataTables_wrapper.no-footer div.dataTables_scrollHead table.dataTable,
.dataTables_wrapper.no-footer div.dataTables_scrollBody > table {
  border-bottom: none;
}
.dataTables_wrapper:after {
  visibility: hidden;
  display: block;
  content: "";
  clear: both;
  height: 0;
}

@media screen and (max-width: 767px) {
  .dataTables_wrapper .dataTables_info,
  .dataTables_wrapper .dataTables_paginate {
    float: none;
    text-align: center;
  }
  .dataTables_wrapper .dataTables_paginate {
    margin-top: 0.5em;
  }
}
@media screen and (max-width: 640px) {
  .dataTables_wrapper .dataTables_length,
  .dataTables_wrapper .dataTables_filter {
    float: none;
    text-align: center;
  }
  .dataTables_wrapper .dataTables_filter {
    margin-top: 0.5em;
  }
}
</style>
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
					<aui:input type="date" name="Meeting_From_Date" id="meetingFromDate" 
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
			<aui:button style="width:14.25%;background-color:#F0F0F0;;margin:0px 50px 0px 1000px;" type="button" name="saveButton" value="from-meetingIndex-search" onclick="save();" />
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
			<aui:button style="width:100%;background-color:#F0F0F0;;margin:0px 50px 0px 0px;" onClick="<%=createMeeting.toString()%>"
				value="from-meetingIndex-create"></aui:button>
		</aui:button-row>


	</div>
	<div class="col-sm-4">
		<center>
			<aui:button style="width:100%;background-color:#F0F0F0;;
		margin:20px 0px 0px 75px;" type="button"
				class="btn btn-secondary" value="from-meetingIndex-reset" onclick="reset()"></aui:button>
			
			<!-- <button type="button" class="btn btn-secondary" value="from-meetingIndex-reset"></button> -->
		</center>
	</div>
	<div class="col-sm-2"></div>
</div>

</div>
