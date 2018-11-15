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

<title>Elija su paciente</title>

</head>
<script> 
	var context = "${context}";
</script>
<body>
	<div class="container">
		<form:form action="/buscarpacientes" method="POST" modelAttribute="">
		
			<h3 class="form-signin-heading">Elija su paciente</h3>
			
			<hr class="colorgraph">
			
			<br>
  
        	<select id="paciente">
        	
				<c:forEach items="${listapacientes}" var="paciente">
				
					<option value="${Paciente.dni}">${Paciente.nombre}${Paciente.apellido}${Paciente.dni}</option>
					
				</c:forEach>	
						
			</select>
			
			<br>
			
			<button class="btn btn-lg btn-primary btn-block" Type="Submit" >Siguiente</button>
			
 	</form:form>
		
	</div>
	
	<script src="${context}/js/jquery-3.3.1.min.js"></script>
	<script src="${context}/js/bootstrap.min.js" type="text/javascript"></script>
	
</body>

</html>