<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<link href="${context}/css/bootstrap.min.css" rel="stylesheet">
<link href="${context}/css/inicio-medico.css" rel="stylesheet">
<link href="${context}/css/bootstrap-theme.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenido "Medico"</title>
</head>
<body>

<div class="container">

		
		
			<h2 class="form-signin-heading" id="titulo">Bienvenido "Medico"</h2>
			
			<hr class="colorgraph">
			
			<br>
  
  			<h3 class="form-signin-heading" id="sub-titulo">Turnos del dia</h3>
			
        	
				<c:forEach items="${listaTurnos}" var="Turnos">
				
					<h5>${Turno.paciente}</h5>
					<h5>${Turno.hora}</h5>
					<h5>${Turno.dia}</h5>
					<h5>${Turno.estado}</h5>
					
					
				</c:forEach>	
						
			
			
			<br>
			
	</div>

	<script src="${context}/js/jquery-3.3.1.min.js"></script>
	<script src="${context}/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="${context}/js/inicio-medico.js" type="text/javascript"></script>


</body>
</html>