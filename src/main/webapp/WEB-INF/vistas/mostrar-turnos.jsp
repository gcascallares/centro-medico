<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Turnos disponibles</title>
<link href="${context}/css/bootstrap.min.css" rel="stylesheet">
<link href="${context}/css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">


		<form:form action="${context}/reservar-turno" method="POST" modelAttribute = "turno">
			<h3 class="form-signin-heading">Lista de turnos disponibles</h3>
			<hr class="colorgraph">
			<br>
			<select name="horario" id="">
				<c:forEach items="${listaDeTurnos}" var="t">
					<option value="${t}">${t}</option>
					<!-- El value despues va a ser el ID del medico -->
				</c:forEach>
			</select>
			<input type="hidden" value="${medicoId}" name="medicoId">
			<input type="hidden" value="${especialidadId}" name="especialidadId">
			<br>
			<button class="btn btn-primary" Type="Submit" />Reservar</button>
			<br>
			<button class="btn btn-lg btn-primary btn-block" id="atras">Atras</button>
		</form:form>
	</div>


	<script src="${context}/js/jquery-3.3.1.min.js"></script>
	<script src="${context}/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="${context}/js/elegir-especialidad.js" type="text/javascript"></script>
</body>
</html>