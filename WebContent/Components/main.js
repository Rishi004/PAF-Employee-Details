$(document).ready(function()
{
	if ($("#alertSuccess").text().trim() == "")
	{
		$("#alertSuccess").hide();
	}
	$("#alertError").hide();

});

//SAVE ============================================

$(document).on("click", "#btnSave", function(event) {
	// Clear alerts---------------------
	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide();
	// Form validation-------------------
	var status = validateItemForm();
	if (status != true)
	{
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}
	// If valid------------------------
	var type = ($("#hidempIDSave").val() == "") ? "POST" : "PUT";
	$.ajax({
		url : "EmployeeAPI",
		type : "type",
		data : $("#formItem").serialize(),
		dataType : "text",
		complete : function(response, status)
		{
			onItemSaveComplete(response.responseText, status);
		}
	});

});

function onItemSaveComplete(response, status) {
	if (status == "success") {
		window.location.reload();
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success")
		{
			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();
			$("#divItemsGrid").html(resultSet.data);

		} else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error") {
		$("#alertError").text("Error while saving.");
		$("#alertError").show();
	} else {
		$("#alertError").text("Unknown error while saving..");
		$("#alertError").show();
	}

	$("#hidempIDSave").val("");
	$("#formItem")[0].reset();
}

//UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event) {

	$("#hidempIDSave").val($(this).data("itemid"));
	
	$("#employee_code").val($(this).closest("tr").find('td:eq(0)').text());
	$("#empName").val($(this).closest("tr").find('td:eq(1)').text());
	$("#address").val($(this).closest("tr").find('td:eq(2)').text());
	$("#telepohneNo").val($(this).closest("tr").find('td:eq(3)').text());

});

//delete====================================================
$(document).on("click", ".btnRemove", function(event) {
	$.ajax({
		url : "EmployeeAPI",
		type : "DELETE",
		data : "employee_id=" + $(this).data("itemid"),
		dataType : "text",
		complete : function(response, status) {
			onItemDeleteComplete(response.responseText, status);
		}
	});
});

function onItemDeleteComplete(response, status) {
	if (status == "success") {
		window.location.reload();
		//window.location.reload();
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success") {
			$("#alertSuccess").text("Successfully deleted.");
			$("#alertSuccess").show();
			$("#divItemsGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error") {
		$("#alertError").text("Error while deleting.");
		$("#alertError").show();
	} else {
		$("#alertError").text("Unknown error while deleting..");
		$("#alertError").show();
	}
}
//CLIENT-MODEL================================================================
function validateItemForm() {
	if ($("#payment_code").val().trim() == "") {
		return "Insert Payment code.";
	}
	
	if ($("#empName").val().trim() == "") {
		return "Insert Name.";
	}

	if ($("#address").val().trim() == "") {
		return "Insert address.";
	}
	
	var tmpPrice = $("#amount").val().trim();
	if (!$.isNumeric(telepohneNo)) {
		return "Insert a numerical value for mobile number.";
	}

	if ($("#empId").val().trim() == "") {
		return "Insert Employee ID.";	

	}	
	
	return true;
}
