<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta charset="ISO-8859-1">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-theme.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style>
	.container{
		width: 60%;
		margin: 0px auto;
		margin-top: 30px;
	}

</style>

<title>Elija medico o día</title>

</head>

<body>
		<div class="container">
		
		<input type="text" id="especilidadId" value="${especialidadId}" hidden>
		
		<a href="/turno/medico/{especialidadId}"><button class="btn btn-lg btn-primary btn-block" id="botonMedico">Elegir por Medico</button></a>
		
		<button class="btn btn-lg btn-primary btn-block" id="botonDia">Elegir por Dia</button>
		
		</div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<script src="js/elegir-especialidad.js" type="text/javascript"></script>

</body>

</html>