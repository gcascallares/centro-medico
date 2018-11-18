<%@page language="java" contentType="text/html; charset=ISO-8859-1"
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

<title>Elija su paciente</title>

</head>
<script> 
	var context = "${context}";
</script>
<body>
	<div class="container">
		<form:form action="${context}/modificarestadoturno/{id}" method="POST">
		
			<h3 class="form-signin-heading">Elija el turno a modificar</h3>
			
			<hr class="colorgraph">
			
			<br>
       	
				<c:forEach items="${listaturnos}" var="turno">
				
					<h3><input type="submit" path="id" value="${turno.id}" name="id">TURNO: ${turno.estado} ${turno.fecha} ${turno.horario}</h3></input></br>

				</c:forEach>	
			
			<br>
			
 	</form:form>
 						
 	<a href="${context}/turno"><button  class="btn btn-lg btn-primary btn-block" Type="button" >Sacar  turno</button></a>
 	<a href="${context}/buscadorPaciente"><button  class="btn btn-lg btn-primary btn-block" Type="button" >Volver</button></a>
	</div>
	
	<script src="${context}/js/jquery-3.3.1.min.js"></script>
	<script src="${context}/js/bootstrap.min.js" type="text/javascript"></script>
	
</body>

</html>