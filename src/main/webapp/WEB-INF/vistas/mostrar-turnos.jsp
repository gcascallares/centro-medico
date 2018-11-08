<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Turnos disponibles</title>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">


		<form:form action="reservar-turno" method="POST" modelAttribute="Turno">
			<h3 class="form-signin-heading">Lista de turnos disponibles</h3>
			<hr class="colorgraph">
			<br>
			<select name="" id="">
				<c:forEach items="${listaDeTurnos}" var="t">
					<option value="1" path="medico.nombre">${t}- Dr/a. ${nombreMedico}</option>
					<!-- El value despues va a ser el ID del medico -->
				</c:forEach>
			</select>
			<button class="btn btn-primary" Type="Submit" />Reservar</button>
		</form:form>
	</div>


	<script src="../js/jquery-3.3.1.min.js"></script>
	<script src="../js/bootstrap.min.js" type="text/javascript"></script>
	<script src="../js/elegir-especialidad.js" type="text/javascript"></script>
</body>
</html>