<%@ include file="/init.jsp" %>


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
</style>

<portlet:resourceURL var="usersObjectArrayURL">
            <portlet:param name="cmd" value="jsonUserObjectArray"/>
</portlet:resourceURL>

<p>Meeting Index Page UI under construction</p>


<aui:button-row>
			<aui:button onClick="<%=createDCR.toString()%>"
				value="Create"></aui:button>
		</aui:button-row>
		
		
<button type="button" id="approveButton" onclick="serch();">Search</button>


<h2>Yokohama Municipal Corporation</h2>

<table id="userTable" class="display" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th>SR.</th>
                <th>Change Requested By</th>
                <th>DCR ID</th>
                <th>Item</th>
                <th>Action</th>
                <th>Floor</th>
				<th>Design</th>
				<th>Construction</th>
				<th>Expense</th>
				<th>DCR Initiation Date</th>
				<th>Approve Status</th>
		    </tr>
        </thead>
</table>		

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

 
/*  $(#approveButton).click(function(){
	 
	 alert("Hello");
	  
  
 } ); */		
<%--   function  serch(){
	  
	  alert("Hello");
	  
	  
	  var table = $('#userTable').DataTable();
	  var ajaxUrl = '<%=usersObjectArrayURL%>';
	  var query = "123";
	  var requestType = "search";
	  ajaxUrl = ajaxUrl + "&query="+query;
	  ajaxUrl = ajaxUrl + "&requestType="+requestType;
	  table.clear.draw();
	  $('#userTable').dataTable().fnDestroy();
	  
	  
  } --%>
  
			
 </script>

