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

		
		
			<h2 class="form-signin-heading" id="titulo">Bienvenido Doctor ${medico.nombre}</h2>
			
			<hr class="colorgraph">
			
			<br>
  
  			<h3 class="form-signin-heading" id="sub-titulo">Turnos del dia ${fecha}</h3>
			
        	
				<c:forEach items="${listaTurnos}" var="Turnos">
					
					<h5>IdTurno: ${Turnos.id}</h5>
					<h5>Nombre: ${Turnos.paciente.nombre} ${Turnos.paciente.apellido}</h5>
					<h5>DNI: ${Turnos.paciente.dni} </h5>
					<h5>Horario: ${Turnos.horario}</h5>
					<h4>--------------------</h4>
				
					<br>					
				</c:forEach>	
						
			
			
			<br>
			
	</div>

	<script src="${context}/js/jquery-3.3.1.min.js"></script>
	<script src="${context}/js/bootstrap.min.js" type="text/javascript"></script>


</body>
</html>