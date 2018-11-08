<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../../css/bootstrap.min.css" rel="stylesheet">
<link href="../../css/bootstrap-theme.min.css" rel="stylesheet">
<style>
	.container{
		width: 60%;
		margin: 0px auto;
	}
</style>
<title>Elija su Medico</title>
</head>
<body>
	<div class="container">
		<form:form action="" method="POST" modelAttribute="">
			<h3 class="form-signin-heading">Elija su Medico</h3>
			<hr class="colorgraph">
			<br>
  
        	<select id="">
				<c:forEach items="${listaMedicos}" var="Medico">
					<option value="${Medico.id}">${Medico.nombre}</option>
				</c:forEach>			
			</select>
			<br>
			<a class="btn btn-lg btn-primary btn-block" id="botonSiguienteEspecialidad">Siguiente con JS</a>
<!-- 			<button class="btn btn-lg btn-primary btn-block" Type="Submit" >Siguiente</button>
 -->		</form:form>
		
	</div>
	<script src="../../js/jquery-3.3.1.min.js"></script>
	<script src="../../js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>