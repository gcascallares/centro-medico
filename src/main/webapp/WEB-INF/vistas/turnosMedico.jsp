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
          <a class="nav-link" href="${context}/${medicoId}/index-medico/${consultorioId}">
            <i class="fas fa-home"></i>
            <span>Inicio</span>
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

 			<c:if test="${fn:length(listaTodosLosTurnos) != 0}">
				<h3 class="form-signin-heading text-center" id="sub-titulo">Todos Los Turnos</h3>
			</c:if>
  			
			<c:if test="${fn:length(listaTodosLosTurnos) == 0}">
				<div class="text-center mt-5"><h2>No hay turnos</h2></div>
			</c:if>
   <br>
   <c:forEach items="${listaTodosLosTurnos}" var="Turnos">
   <div class="card w-10 mx-auto mt-2 mb-2">
   
   						<h5 class="card-header">Paciente: ${Turnos.paciente.nombre} ${Turnos.paciente.apellido}</h5>
   						 <div class="card-body">
					    <h5 class="card-title">DNI: ${Turnos.paciente.dni}</h5>
					    <h5 class="card-title">Fecha: ${Turnos.fecha}</h5>
					    <h5 class="card-title">Horario: ${Turnos.horario}</h5>
					    <h5 class="card-title">Estado del turno: ${Turnos.estado}</h5>
					    </div>
   </div>
   </c:forEach>
   

    </div>




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