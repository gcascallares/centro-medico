<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

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
<script> 
	var context = "${context}";
</script>
<body>

<div class="container">

		
		
			<h2 class="form-signin-heading" id="titulo">Bienvenido Doctor ${medico.nombre}</h2>
			
			<hr class="colorgraph">
			
			<br>
  
  			<c:if test="${fn:length(listaTurnos) != 0}">
				<h3 class="form-signin-heading" id="sub-titulo">Turnos del dia ${fecha}</h3>
			</c:if>
  			
			<c:if test="${fn:length(listaTurnos) == 0}">
				<div class="text-center mt-5"><h2>No hay mas turnos por hoy</h2></div>
			</c:if>
        	<div id="turnos">
				<c:forEach items="${listaTurnos}" var="Turnos">
					
					<h5>IdTurno: <span id="turno-${Turnos.id}">${Turnos.id}<span></h5>
					<h5>Nombre: ${Turnos.paciente.nombre} ${Turnos.paciente.apellido}</h5>
					<h5>DNI: ${Turnos.paciente.dni} </h5>
					<h5>Horario: ${Turnos.horario}</h5>
					<h4>--------------------</h4>
					<c:if test = "${Turnos.descripcion == null}">
					<button type="button" class="btn btn-primary mb-5" data-toggle="modal" data-target="#turno${Turnos.id}">
					  Dejar comentario
					</button>
					</c:if>
					<!-- Button trigger modal -->
					<c:if test = "${Turnos.descripcion != null}">
						<button class="btn btn-success mb-5" onclick="atender(${Turnos.id},${consultorioId},${medico.id})" id="atendido-${Turnos.id}">Atendido</button>  
			        </c:if>
					

<!-- Modal -->
					<div class="modal fade" id="turno${Turnos.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
					  <div class="modal-dialog" role="document">
					    <div class="modal-content">
					      <div class="modal-header">
					        <h5 class="modal-title" id="titleTurno${Turnos.id}">Deje su comentario</h5>
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					          <span aria-hidden="true">&times;</span>
					        </button>
					      </div>
					      <div class="modal-body">
								<div class="form-group">
								  <label for="comment">Descripcion</label>
								  <textarea class="form-control" rows="5" id="comentario"></textarea>
								</div>					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
					        <button type="button" class="btn btn-primary" onclick="guardarComentario(${Turnos.id},${consultorioId},${medico.id})" id="guardar">Guardar</button>
					      </div>
					    </div>
					  </div>
					</div>					
				</c:forEach>	
			</div>		
			
			
			<br>
			
	</div>
	<script> 
		function atender(idTurno,idConsultorio,idMedico){
			window.location.href = window.context+"/turno/atendido/" + idTurno + "/" + idConsultorio + "/" + idMedico;
		}
		function guardarComentario(idTurno,idConsultorio,idMedico){
			var mensaje = $("#comentario").val();
			window.location.href = window.context+"/turno/guardarComentario/" + idTurno + "/" + idConsultorio + "/" + idMedico+ "/" + mensaje;
		}
	</script>
	<script src="${context}/js/jquery-3.3.1.min.js" type="text/javascript"></script>
	<script src="${context}/js/bootstrap/bootstrap.min.js" type="text/javascript"></script>
	<script src="${context}/js/inicio-medico.js" type="text/javascript"></script>


</body>
</html>