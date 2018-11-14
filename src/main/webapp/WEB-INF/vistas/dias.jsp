
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
<link href="${context}/js/jquery-ui/jquery-ui.min.css" rel="stylesheet" >
<style>
	.container{
		width: 60%;
		margin: 0px auto;
		background-color: grey;
	}
</style>

<script>
///GUARDO LA LISTA CON LOS ID DE DIAS EN JAVASCRIPT
	var dias = new Array();
	<c:forEach items="${dias}" var="dia"> 
	   dias.push(${dia});
	</c:forEach> 
</script>
<title>Elija su Fecha</title>

</head>

<body>
	<div class="container">
		<input type"hidden" value="${especialidadId}" id="especialidadId" hidden>
		<input type"hidden" value="${medicoId}" id="medicoId" hidden>
		<br>
		<br>
		<br>

		<input type="text" id="datepicker">
		
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		
		<a class="btn btn-lg btn-primary btn-block" id="botonSiguiente">Continuar</a>
		<br>
		<button class="btn btn-lg btn-primary btn-block" id="atras">Atras</button>
		
	</div>
	
	<script src="${context}/js/jquery-3.3.1.min.js"></script>
	<script src="${context}/js/bootstrap.min.js" type="text/javascript"></script>
  	<script src="${context}/js/jquery-ui/jquery-ui.min.js"></script>
	<script src="${context}/js/elegir-dia.js" type="text/javascript"></script>
	<script src="${context}/js/moment.js" type="text/javascript"></script>
	
	
</body>

</html>