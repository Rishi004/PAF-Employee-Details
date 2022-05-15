<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.Employee"%>

<!DOCTYPE html>
<html>
<head>


<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Welcome</title>

<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>



<!-- WEB FONTS -->
<link
	href='http://fonts.googleapis.com/css?family=Roboto:100,300,100italic,400,300italic'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300'
	rel='stylesheet' type='text/css'>

<!-- BOOTSTRAP -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- FONT AWESOME -->
<link rel="stylesheet" href="css/font-awesome.min.css">
<!-- CUSTOM STYLING -->
<link href="css/styles.css" rel="stylesheet">
<!-- PRELOADER -->
<link href="css/loader.css" rel="stylesheet">

</head>

<body>
	<nav class="navbar navbar-dark bg-dark">

		<a class="navbar-brand" href="#">ElectroGrid System</a> &nbsp &nbsp
		&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
		&nbsp &nbsp &nbsp &nbsp &nbsp
		<form class="form-inline">
			<a href="EmployeeDetails.jsp"><button
					class="btn btn-primary btn-lg" type="button">&nbsp
					&nbsp Employee Details &nbsp &nbsp</button></a> 
					

		</form>
	</nav>


	<!-- HEADER -->
	<section id="header">
		<div class="container">
			<div class="row text-center">
				<div class="col-md-8">

					<h1 class="white-text">Welcome to ElectroGrid System</h1>
					<h5 class="white-text">ElectroGrid (EG) is the company who maintains the power grid of the country. They have a system to
monitor the power consumption of the users, generate the monthly bills and automatically send to the
users, and accept the online payments from the users. </h5>
					<img alt="" src="images/logo.jpg">
					<div id="countdown" class="white-text"></div>
				</div>
			</div>
		</div>
		<div class="animation">
			<a class="arrow-down-animation" data-scroll href="#about"><i
				class="fa fa-angle-down"></i></a>
		</div>
	</section>
	<!-- HEADER ENDS -->



	<!-- FOOTER -->
	<footer id="footer">
		<div class="container">
			<div class="row text-center">
				<p>
					&copy; 2022 ElectroGrid System <span class="social"> &nbsp&nbsp<a
						href="#"><i class="fa fa-facebook-square"></i></a>&nbsp &nbsp <a href="#">
								<i class="fa fa-twitter-square"></i></a>&nbsp &nbsp <a href="#">
							<i class="fa fa-google-plus-square"></i></a>
					</span>
				</p>
			</div>
		</div>
	</footer>
	<!-- FOOTER ENDS -->


	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
	<!-- SMOOTH SCROLL -->
	<script src="js/smooth-scroll.min.js"></script>
	<!-- PARALLAX IMG -->
	<script src="js/jquery.parallax-1.1.3.js"></script>
	<!-- SCROLL REVEAL -->
	<script src="js/scrollReveal.min.js"></script>
	<!-- FUNCTIONS -->
	<script src="js/functions.js"></script>

</body>
</html>

</html>