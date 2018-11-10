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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Elija su consultorio</title>
</head>
<body>

<div class="container">

		<form:form action="/index-medico/{consultorioId}" method="POST" modelAttribute="consultorio">
		
			<h3 class="form-signin-heading">Elija un consultorio</h3>
			
			<hr class="colorgraph">
			
			<br>
  
        	<select id="consultorio">
        	
				<c:forEach items="${listaConsultorios}" var="Consultorio">
				
					<option value="${Consultorio.id}">${Consultorio.numero}</option>
					
				</c:forEach>	
						
			</select>
			
			<br>
			
			<a class="btn btn-lg btn-primary btn-block" id="botonSiguienteConsultorio">Siguiente con JS</a>
			<!--<button class="btn btn-lg btn-primary btn-block" Type="Submit" >Siguiente</button>-->
			
 	</form:form>
		
	</div>
	
	<script src="${context}/js/jquery-3.3.1.min.js"></script>
	<script src="${context}/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="${context}/js/elegir-consultorio.js" type="text/javascript"></script>

</body>
</html>