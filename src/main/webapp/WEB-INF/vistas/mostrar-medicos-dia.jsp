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
	}
</style>
<title>Elija su Medico</title>
</head>
<script> 
	var context = "${context}";
</script>
<body>
	<div class="container">
		<form:form action="" method="POST">
			<h3 class="form-signin-heading">Elija su Medico</h3>
			<hr class="colorgraph">
			<br>
  
        	<select id="medicos">
        	
				<c:forEach items="${listaDeMedicos}" var="Medico">
				
					<option value="${Medico.id}">${Medico.nombre}</option>
				</c:forEach>			
			</select>
			
			<br>
			<input type="hidden" value="${fecha}" id="fecha">
			<input type="hidden" value="${especialidadId}" id="especialidadId">
			<input type="hidden" value="${diaId}" id="diaId">
			<br>
			<a class="btn btn-lg btn-primary btn-block" id="botonSiguienteMedico">Continuar</a>
			<br>
			<button class="btn btn-lg btn-primary btn-block" id="atras">Atras</button>
		</form:form>
		
	</div>
	<script src="${context}/js/jquery-3.3.1.min.js"></script>
	<script src="${context}/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="${context}/js/medicoPorDia.js" type="text/javascript"></script>
</body>
</html>