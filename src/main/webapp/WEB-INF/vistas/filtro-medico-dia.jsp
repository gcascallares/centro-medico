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
	
		<button class="btn btn-lg btn-primary btn-block" id="botonMedico">Elegir por Medico</button>
		<input type="hidden" value="${especialidadId}" id="especialidadId">
		<button class="btn btn-lg btn-primary btn-block" id="botonDia">Elegir por Dia</button>
		
	</div>
	
	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<script src="js/filtro-medico-dia.js" type="text/javascript"></script>
	
</body>

</html>