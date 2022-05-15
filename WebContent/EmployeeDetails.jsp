<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@page import="model.Employee"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee management</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/main.js"></script>
</head>
<body>
	<nav class="navbar navbar-dark bg-dark">


		<a class="navbar-brand" href="#">ElectroGrid System </a>
		  <form class="form-inline">
			<a href="index.jsp"><input id="btnHome" name="btnHome"
				type="button" value="Home" class="btn btn-lg btn-outline-primary"></a>

			<!-- &nbsp &nbsp &nbsp<input id="btnLogout" name="btnLogout" type="button"
				value="Logout" class="btn btn-lg btn-outline-primary"> -->
		</form>  
	</nav>

	<div class="container">
		<div class="row">
			<div class="col-8">
				<br>
				<h2>Employee Management</h2>
				 	
				 	<form id="formItem" name="formItem" >


		Employee Code:
		<input id="employee_code" name="employee_code" type="text" class="form-control form-control-sm" ><br>
		 Employee Name :
		<input id="empName" name="empName" type="text" class="form-control form-control-sm"><br>
		 Address:
		<input id="address" name="address" type="text" class="form-control form-control-sm"><br>
	    Mobile Number:
		<input id="telepohneNo" name="telepohneNo" type="text"class="form-control form-control-sm"><br>
		 
	
 
		<br>
		
		<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary">
		<input type="hidden" id="hidempIDSave" name="hidempIDSave"
					value="">
		
		
</form> 
				


						
						
				<div id="alertSuccess" class="alert alert-success"></div>
				<div id="alertError" class="alert alert-danger"></div>

				<br> <br>
				<div id="divItemsGrid">
					<%
						Employee payObj = new Employee();
						out.print(payObj.readEmployee());
						

					%>
				</div>

			</div>
		</div>

	</div>

</body>
</html>