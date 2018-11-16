<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Turnos disponibles</title>
<link href="${context}/css/bootstrap.min.css" rel="stylesheet">
<link href="${context}/css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<script> 
	var context = "${context}";
</script>
<body>
	<div class="container">
		<h1>Medico Id: ${turno.medicoId}</h1>
		<h1>Especialidad Id: ${turno.especialidadId}</h1>
		<h1>Horario: ${turno.horario}</h1>
		<h1>Fecha: ${turno.fecha}</h1>
		<h3> <a href="${context}/turno">Volver</a> </h3>
	</div>

	<script src="../js/jquery-3.3.1.min.js"></script>
	<script src="../js/bootstrap.min.js" type="text/javascript"></script>
	<script src="../js/filtro-medico-dia.js" type="text/javascript"></script>

</body>
</html>