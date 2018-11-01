<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-theme.min.css" rel="stylesheet">
<style>
	.container{
		width: 60%;
		margin: 0px auto;
	}
</style>
<title>Elija su especialidad</title>
</head>
<body>
	<div class="container">
		<form:form action="obtener-turnos" method="POST"
			modelAttribute="">
			<h3 class="form-signin-heading">Elija su especialidad</h3>
			<hr class="colorgraph">
			<br>
  
        	<select name="" id="">
        	
				<c:forEach items="${listaEsp}" var="Especialidad">
				
					<option value="">${Especialidad.nombreEspecialidad}</option>
					<!-- El value despues va a ser el ID del medico -->
				</c:forEach>
				
			</select>
			<br>
			
			<button class="btn btn-lg btn-primary btn-block" Type="Submit" >Siguiente</button>
			
		</form:form>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>