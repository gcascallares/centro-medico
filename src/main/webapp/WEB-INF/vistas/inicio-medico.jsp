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

<meta charset="utf-8">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Bootstrap -->
    <link href="${context}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${context}/css/dataTables.bootstrap4.css" rel="stylesheet">

    <!-- Font Awesome-->
    <link href="${context}/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    
    <!-- Estilo que se aplica a todas las Vistas-->
    <link href="${context}/css/sb-admin.css" rel="stylesheet">
    
    <link rel="shortcut icon" type="image/x-icon" href="${context}/img/Logo.ico" />

	<title>Bienvenido Medico</title>

</head>

<script> 
	var context = "${context}";
</script>

<body id="page-top">


	  <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

      <a class="navbar-brand mr-1" href="#"><img src="${context}/img/logo3.png"></a>

      <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
        <i class="fas fa-bars fa-2x" style="color: white;"></i>
      </button>
      
      <!-- Desplegable del usuario -->
      <div class="ml-auto">
      <ul class="navbar-nav ml-auto ml-md-0">
        <li class="nav-item dropdown no-arrow">
          <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-2x fa-user-circle fa-fw"></i>
          </a>
          <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
            <a class="dropdown-item" href="#">Ajustes</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">Cerrar Sesion</a>
          </div>
        </li>
      </ul>
	</div>
    </nav>

    <div id="wrapper">

      <!-- Barra del costado -->
      <ul class="sidebar navbar-nav">
       <li class="nav-item">
          <a class="nav-link" href="${context}/Inicio">
            <i class="fas fa-home"></i>
            <span>  Inicio</span>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${context}/mostrarTurnosPorDia/${medicoId}">
            <i class="fas fa-file-signature"></i>
            <span>Todos los Turnos</span>
          </a>
        </li>
         <li class="nav-item">
          <a class="nav-link" href="${context}/mostrarTurnosDeProximoDiaLaboral/${medicoId}">
            <i class="fas fa-file-signature"></i>
            <span>Turnos del proximo dia Laboral</span>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${context}/generarAtencion">
            <i class="fab fa-creative-commons-nd"></i>
            <span> Atenciones</span></a>
        </li>
      </ul>

      <div id="content-wrapper">

        <div class="container-fluid">

          <!--Menu Hamburguesa -->
          <ol class="breadcrumb">
            <li class="breadcrumb-item">
              <a href="#">Solicitar Turno</a>
            </li>
          </ol>
     </div>     
          
          
          
          
          

          <!-- Contenido de la Pagina -->
        	
        	<h2 class="form-signin-heading" id="titulo">Bienvenido Dr. ${medico.nombre}</h2>
			
			<hr class="colorgraph">
			
			<br>
  
  			<c:if test="${fn:length(listaTurnos) != 0}">
				<h3 class="form-signin-heading text-center" id="sub-titulo">Turnos del dia ${fecha}</h3>
			</c:if>
  			
			<c:if test="${fn:length(listaTurnos) == 0}">
				<div class="text-center mt-5"><h2>No hay mas turnos por hoy</h2></div>
			</c:if>
        	<div id="turnos">
				<c:forEach items="${listaTurnos}" var="Turnos">
					<div class="card w-50 mx-auto mt-4 mb-4">
					  <h5 class="card-header">Numero de turno: <span id="turno-${Turnos.id}">${Turnos.id}<span></h5>
					  <div class="card-body">
					    <h5 class="card-title">Paciente: ${Turnos.paciente.nombre} ${Turnos.paciente.apellido}</h5>
					    <h5 class="card-title">DNI: ${Turnos.paciente.dni}</h5>
					    <h5 class="card-title">Horario: ${Turnos.horario}</h5>
					<c:if test = "${Turnos.estudio == null}">
					<div class="d-flex justify-content-center mt-4">
					<button type="button" class="btn btn-primary mb-5 mr-4" data-toggle="modal" data-target="#turno${Turnos.id}">
					  Dejar comentario
					</button>
					<button type="button" class="btn btn-primary mb-5" data-toggle="modal" data-target="#derivar">
					  Derivar
					</button>
					</div>
					</c:if>
					<!-- Button trigger modal -->
					<c:if test = "${Turnos.estudio != null}">
					<div class="text-center">
						<button class="btn btn-success mb-5" onclick="atender(${Turnos.id},${consultorioId},${medico.id})" id="atendido-${Turnos.id}">Atendido</button>  
			        </div>
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
					      	<div class="text-center"><h5>Inserta el tipo de estudio / consulta realizada</h5></div>
								<div class="form-group text-center">
								
								  <select id="estudio">
        		
						        		<option value="0" selected disabled>Seleccione una opción</option>
					        		
										<c:forEach items="${listaEstudios}" var="Estudio">
										
											
											<option value="${Estudio.id}">${Estudio.nombre}</option>
											
										</c:forEach>	
												
									</select>
								  
								  <br><br>
								
								  <label for="comment">Descripcion</label>
								  <textarea class="form-control" rows="5" id="comentario"></textarea>
								  
								</div>					      
						 </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
					        <button type="button" class="btn btn-primary" onclick="guardarComentario(${Turnos.id},${consultorioId},${medico.id})" id="guardar">Guardar</button>
					      </div>
					    </div>
					  </div>
					</div>		
					
					</div>
					</div>
					
				
			
				<div class="modal fade" id="derivar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
					  <div class="modal-dialog" role="document">
					    <div class="modal-content">
					      <div class="modal-header">
					        <h5 class="modal-title" id="titleTurno${Turnos.id}">Derivar</h5>
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					          <span aria-hidden="true">&times;</span>
					        </button>
					      </div>
					      <div class="modal-body">
								<div class="form-group text-center">
								  <label for="comment">Seleccione el medico al que desea derivar</label>
								  
        							<select id="medico">
        		
        								<option value="0" disabled selected>Seleccione una opción</option>
        		
											<c:forEach items="${listaMedicos}" var="medico">
					
										<option value="${medico.id}">Dr/a. ${medico.nombre} - ${medico.especialidad.nombreEspecialidad}</option>
					
											</c:forEach>	
						
									</select>
								</div>					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
					        <button type="button" class="btn btn-primary" onclick="guardarDerivacion(${Turnos.paciente.id},${consultorioId},${medico.id})" id="guardarDerivacion">Aceptar</button>
					      </div>
					    </div>
					  </div>
					</div>					
					</c:forEach>		
					</div>	
			<br>
 			
 			
 			
 			
 			

      </div>
      <!-- /.content-wrapper -->

    </div>
    <!-- /#wrapper -->

   <!--Boton para ir a arriba-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fas fa-angle-up"></i>
    </a>

    <!-- Modal de cierre de sesio-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Seguro que quiere cerrar session</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">x</span>
            </button>
          </div>
          <div class="modal-body">Seleccione la opcion "Cerrar" que esta debajo si esta listo para cerrar su sesion </div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
            <a class="btn btn-primary" href="${context}/cerrarSesion">Cerrar</a>
          </div>
        </div>
      </div>
    </div>
	
	<script> 
	
	function atender(idTurno,idConsultorio,idMedico){
		
		window.location.href = window.context+"/turno/atendido/" + idTurno + "/" + idConsultorio + "/" + idMedico;
		
	}
	
	function guardarComentario(idTurno,idConsultorio,idMedico){
		
		var estudio = $("#estudio option:selected").val();
		var mensaje = $("#comentario").val();
		
		window.location.href = window.context+"/turno/guardarComentario/" + idTurno + "/" + idConsultorio + "/" + idMedico+ "/" + estudio + "/" + mensaje;
	}
	
	function guardarDerivacion(idPaciente,idConsultorio,idMedico){
		
		var medicoADerivar = $("#medico option:selected").val();
		window.location.href = window.context+"/turno/guardarDerivacion/" + idConsultorio + "/" + idMedico + "/" + idPaciente + "/" + medicoADerivar;
		
	}
		
	</script>
	
	 <!-- Bootstrap core y JavaScript-->
    <script src="${context}/js/jquery/jquery.min.js"></script>
    <script src="${context}/js/bootstrap/bootstrap.bundle.min.js"></script>

    <!--Jquery-->
    <script src="${context}/js/jquery-3.3.1.min.js"></script>
    <script src="${context}/js/jquery/jquery.easing.min.js"></script>
    <script src="${context}/js/inicio-medico.js" type="text/javascript"></script>

  	<!-- Estilo que se aplica en todas las vistas-->
    <script src="${context}/js/jquery/sb-admin.min.js"></script>
	
</body>

</html>