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

<title>Buscador Pacientes</title>

</head>

<body>
	<div class="container">
			<h3 class="form-signin-heading">Ingrese Paciente buscado</h3>
			<hr class="colorgraph">
			<br>
		<div class="search d-flex justify-content-center mt-4">
		
			<form action="${context}/buscarpacientespordni/{dni}" method="POST">
			
				<input path="dni" name="dni" Type="number"></input><br>
				<button class="btn btn-lg btn-primary btn-block" Type="Submit" >Buscar por dni</button>
 			</form>
 			
 		</div>
	</div>
	
	<script src="${context}/js/bootstrap.min.js" type="text/javascript"></script>
	
</body>

</html>