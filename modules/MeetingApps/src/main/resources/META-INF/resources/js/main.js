$(document)
		.ready(
				function() {
					// alert("Page Loading");
					var navListItems = $('div.setup-panel div a'), allWells = $('.setup-content'), allNextBtn = $('.nextBtn');

					allWells.hide();
					$('#Data').hide();
					// createTable();

					navListItems.click(function(e) {
						e.preventDefault();
						var $target = $($(this).attr('href')), $item = $(this);

						if (!$item.hasClass('disabled')) {
							navListItems.removeClass('btn-primary').addClass(
									'btn-default');
							$item.addClass('btn-primary');
							allWells.hide();
							$target.show();
							$target.find('input:eq(0)').focus();
						}
					});

					allNextBtn
							.click(function() {
								var curStep = $(this).closest(".setup-content"), curStepBtn = curStep
										.attr("id"), nextStepWizard = $(
										'div.setup-panel div a[href="#'
												+ curStepBtn + '"]').parent()
										.next().children("a"), curInputs = curStep
										.find("input[type='text'],input[type='url']"), isValid = true;

								$(".form-group").removeClass("has-error");
								for (var i = 0; i < curInputs.length; i++) {
									if (!curInputs[i].validity.valid) {
										isValid = false;
										$(curInputs[i]).closest(".form-group")
												.addClass("has-error");
									}
								}

								if (isValid)
									nextStepWizard.removeAttr('disabled')
											.trigger('click');
							});

					$('div.setup-panel div a.btn-primary').trigger('click');

					$(document).on("click", ".close_icon", function() {
						// alert("Called")
						$(this).parents("tr:first").remove();
					})
				});

// /Form Dynamic Field
var counter = 1;
function addFunction() {
	alert("add funtion Loading");
	var res = '<tr>'
			+ '<td>'
			+ '<div class="form-group">'
			+ '<div class="form-group col-md-12">'
			+ '<label for="itm_dtls">Category</label>'
			+ '<select class="custom-select" id="category" name="category">'
			+ '<option selected>Choose...</option>'
			+ '<option value="Design Type">DCR</option>'
			+ '<option value="External">Other</option>'
			+ '</select>'
			+ '</div>'
			+ '</div>'
			+ '</td>'
			+ '<td>'
			+ '<div class="form-group">'
			+ '<div class="form-group col-md-12">'
			+ '<label for="itm_dtls">Floor</label>'
			+ '<input type="text" id="floor" name="Floor" class="form-control" />'
			+ '</div>'
			+ '</div>'
			+ '</td>'
			+ '<td>'
			+ '<div class="form-group">'
			+ '<div class="form-group col-md-12">'
			+ '<label for="itm_dtls">Items</label>'
			+ '<input type="text" id="items" name="Items" class="form-control" />'
			+ '</div>'
			+ '</div>'
			+ '</td>'
			+ '<td>'
			+ '<div class="form-group">'
			+ '<div class="form-group col-md-12">'
			+ '<label for="itm_dtls">Action</label>'
			+ '<input type="text" id="action" name="Action" class="form-control" />'
			+ '</div>'
			+ '</div>'
			+ '</td>'
			+ '<td>'
			+ '<div class="form-group">'
			+ '<div class="form-group col-md-12">'
			+ '<label for="itm_dtls">Expected Due Date</label>'
			+ '<input type="date" id="expectedDueDate" name="ExpectedDueDate" class="form-control" />'
			+ '</div>'
			+ '</div>'
			+ '</td>'
			+ '<td>'
			+ '<div class="form-group">'
			+ '<div class="form-group col-md-12">'
			+ '<label for="chngs_exp">Persion In Charge</label>'
			+ '<input type="text" id="persionInCharge" name="PersionInCharge" class="form-control" />'
			+ '</div>' + '</div>' +

			'</td>' + '<td class="close_icon">Delete</td>' + '</tr>'
	$("#rsn_fr_chng_tabl").append(res)
}

var arrHead = new Array(); // array for header.
arrHead = [ 'Category', 'Floor', 'Items', 'Action', 'Expected Due Date',
		'Persion In Charge', '' ];

// first create TABLE structure with the headers.
/*
 * function createTable() { alert("Create table"); var empTable =
 * document.createElement('table'); empTable.setAttribute('id', 'empTable'); //
 * table id.
 * 
 * var tr = empTable.insertRow(-1); for (var h = 0; h < arrHead.length; h++) {
 * var th = document.createElement('th'); // create table headers th.innerHTML =
 * arrHead[h]; tr.appendChild(th); }
 * 
 * var div = document.getElementById('cont'); div.appendChild(empTable); // add
 * the TABLE to the container. }
 */

// now, add a new to the TABLE.
var catagoryCounter=1;
var FloorCounter=1;
var ItemsCounter=1;
var ActionCounter=1;
var ExpecteDateCounter=1;
var PersionCounter=1;
function addRow() {
	var empTab = document.getElementById('rsn_fr_chng_tabl');

	var rowCnt = empTab.rows.length; // table row count.
	var tr = empTab.insertRow(rowCnt); // the table row.
	tr = empTab.insertRow(rowCnt);

	for (var c = 0; c < arrHead.length; c++) {
		var td = document.createElement('td'); // table definition.
		td = tr.insertCell(c);
		
		if (c == 6) {      // the last column.
            // add a button in every new row in the last column.
            var button = document.createElement('input');

            // set input attributes.
            button.setAttribute('type', 'button');
            button.setAttribute('value', 'Remove');

            // add button's 'onclick' event.
            button.setAttribute('onclick', 'removeRow(this)');
            var label = document.createElement("label");
			label.innerHTML = " ";
			
			td.appendChild(label);

            td.appendChild(button);
        }
		
		else if (c == 0){
		// Add catagory dropdown


			  var values = ["DCR", "Other"];

			  var select = document.createElement("select");
			  select.name = "Category"+catagoryCounter;
			  select.id = "category"
			  for (const val of values) {
			    var option = document.createElement("option");
			    option.value = val;
			    option.text = val.charAt(0).toUpperCase() + val.slice(1);
			    select.appendChild(option);
			  }

			  var label = document.createElement("label");
			  label.innerHTML = "Category:"
			  label.htmlFor = "Category";

			  td.appendChild(label).appendChild(select);
			  catagoryCounter++;
		}
		else if (c == 1){
			// Add floor
			var floor = document.createElement('input');
			floor.name = "Floor"+FloorCounter;
			floor.id = "floor";
			floor.setAttribute('type', 'text');
			floor.setAttribute('value', '');
			var label = document.createElement("label");
			label.innerHTML = "Floor";
			
			td.appendChild(label);
			td.appendChild(floor);
			FloorCounter++;
		}
		
		else if (c == 2){
			// Add
			var Items = document.createElement('input');
			Items.name = "Items"+ItemsCounter;
			Items.id = "items";
			Items.setAttribute('type', 'text');
			Items.setAttribute('value', '');
			var label = document.createElement("label");
			label.innerHTML = "Items";
			
			td.appendChild(label);
			td.appendChild(Items);
			ItemsCounter++;
		}
		
		else if (c == 3){
			var Action = document.createElement('input');
			Action.name = "Action"+ActionCounter;
			Action.id = "action";
			Action.setAttribute('type', 'text');
			Action.setAttribute('value', '');
			var label = document.createElement("label");
			label.innerHTML = "Action";
			
			td.appendChild(label);
			td.appendChild(Action);
			ActionCounter++;
		}
		else if(c == 4){
			var ExpectedDueDate = document.createElement('input');
			ExpectedDueDate.name = "ExpectedDueDate"+ExpecteDateCounter;
			ExpectedDueDate.id = "expectedDueDate";
			ExpectedDueDate.setAttribute('type', 'date');
			ExpectedDueDate.setAttribute('value', '');
			var label = document.createElement("label");
			label.innerHTML = "Expected Due Date";
			
			td.appendChild(label);
			td.appendChild(ExpectedDueDate);
			ExpecteDateCounter++;
		}
        else {
        	var PersionInCharge = document.createElement('input');
        	PersionInCharge.name = "PersionInCharge"+PersionCounter;
        	PersionInCharge.id = "persionInCharge";
        	PersionInCharge.setAttribute('type', 'text');
        	PersionInCharge.setAttribute('value', '');
        	var label = document.createElement("label");
			label.innerHTML = "Persion In Charge";
			
			td.appendChild(label);
			td.appendChild(PersionInCharge);
			PersionCounter++;
        }
	}
	
// Add values
	// addValue();
}

// delete TABLE row function.
function removeRow(oButton) {
	var empTab = document.getElementById('rsn_fr_chng_tabl');
	empTab.deleteRow(oButton.parentNode.parentNode.rowIndex); // button -> td
																// -> tr.
}
