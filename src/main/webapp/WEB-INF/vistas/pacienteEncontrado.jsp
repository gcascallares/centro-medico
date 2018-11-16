<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>

<head>

<meta charset="ISO-8859-1">
<link href="${context}/css/bootstrap.min.css" rel="stylesheet">
<link href="${context}/css/bootstrap-theme.min.css" rel="stylesheet">

<style>
	.container{
		width: 60%;
		margin: 0px auto;
		background-color: grey;
	}
</style>

<title>Turnos del paciente</title>

</head>
<script> 
	var context = "${context}";
</script>
<body>
	<div class="container">
		<form:form action="modificarestadoturno" method="POST" modelAttribute="">
		
			<h3 class="form-signin-heading">Elija turno a gestionar</h3>
			
			<hr class="colorgraph">
			
			<br>

				<c:forEach items="${listaturnopaciente}" var="turno">
				
					<option value="${Turno.id}">${Turno.dia}${Turno.horario}${Turno.estado}</option>
					
				</c:forEach>	
			
			<br>
			
			<button class="btn btn-lg btn-primary btn-block" Type="Submit" >Modificar Estado</button>
			
 	</form:form>
		
	</div>
	
	<script src="${context}/js/jquery-3.3.1.min.js"></script>
	<script src="${context}/js/bootstrap.min.js" type="text/javascript"></script>
	
</body>

</html>