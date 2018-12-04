<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Elija su Turno</title>

 	<!-- Bootstrap -->
    <link href="${context}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${context}/css/dataTables.bootstrap4.css" rel="stylesheet">

    <!-- Font Awesome-->
    <link href="${context}/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    
    <!-- Estilo que se aplica a todas las Vistas-->
    <link href="${context}/css/sb-admin.css" rel="stylesheet">
    
    <link rel="shortcut icon" type="image/x-icon" href="${context}/img/Logo.ico" />

<<<<<<< HEAD
=======

>>>>>>> branch 'master' of https://github.com/ignacrescenzo/centro-medico.git
</head>
<<<<<<< HEAD

<script> 
	var context = "${context}";
</script>

<body id="page-top">
=======
>>>>>>> branch 'master' of https://github.com/ignacrescenzo/centro-medico.git

<script> 
	var context = "${context}";
</script>

<<<<<<< HEAD
	  <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

      <a class="navbar-brand mr-1" href="#"><img src="${context}/img/logo3.png"></a>

      <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle">
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
          <a class="nav-link" href="#">
            <i class="fas fa-file-signature"></i>
            <span>  Turnos</span>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">
            <i class="fab fa-creative-commons-nd"></i>
            <span>  Derivaciones</span></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">
            <i class="fas fa-mobile-alt"></i>
            <span>  Contacto</span></a>
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
        	
        	<form:form action="${context}/reservar-turno" method="POST" modelAttribute = "turno">
        	
=======
<body id="page-top">

	  <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

      <a class="navbar-brand mr-1" href="#"><img src="${context}/img/logo3.png"></a>

      <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle">
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
          <a class="nav-link" href="${context}/Home">
            <i class="fas fa-home"></i>
            <span>  Inicio</span>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${context}/misTurnos">
            <i class="fas fa-file-signature"></i>
            <span> Mis Turnos</span>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${context}/mostrarhistoriaclinica">
            <i class="fas fa-history"></i>
            <span> Historia Clinica</span>
          </a>
        </li>
         <li class="nav-item">
          <a class="nav-link" href="${context}/derivacion/${usuarioId}">
            <i class="fab fa-creative-commons-nd"></i>
            <span>  Derivaciones</span></a>
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
          
         
          
          
          
          

          <!-- Contenido de la Pagina -->
        	
        	<form:form action="${context}/reservar-turno" method="POST" modelAttribute = "turno">
>>>>>>> branch 'master' of https://github.com/ignacrescenzo/centro-medico.git
			<h3 class="form-signin-heading">Lista de turnos disponibles para el dia ${fecha}</h3>
			<hr class="colorgraph">
			<br>
			
				
				
				
<<<<<<< HEAD
=======
				<div class="w-75 p-3 text-center mx-auto" >
>>>>>>> branch 'master' of https://github.com/ignacrescenzo/centro-medico.git
				<c:forEach items="${listaDeTurnos}" var="t">
<<<<<<< HEAD
				
							  <div class="btn-group btn-group-toggle" data-toggle="buttons" style="margin-left: 15px;">
							  <label class="btn btn-secondary active" style="background-color: #1e9edb;">
							    <input type="radio" name="horario" autocomplete="off" value="${t}" checked > ${t}
							  </label>
							</div>

=======
							    <label class="mr-4"><input type="radio" name="horario" value="${t}" > ${t}</label>
							    
>>>>>>> branch 'master' of https://github.com/ignacrescenzo/centro-medico.git
				</c:forEach>
<<<<<<< HEAD
				
				
				
			<div> <h2 id="mensajeVacio">  </h2> </div>
			
=======
				</div>
				
				
			<div> <h2 id="mensajeVacio">  </h2> </div>
>>>>>>> branch 'master' of https://github.com/ignacrescenzo/centro-medico.git
			<input type="hidden" value="${fecha}" name="fecha">
			<input type="hidden" value="${medicoId}" name="medicoId">
			<input type="hidden" value="${especialidadId}" name="especialidadId">
			<br>
<<<<<<< HEAD
			
			<button class="btn btn-primary" id="reservar" Type="Submit">Reservar</button>
			
=======
			<div class="text-center">
				<button class="btn btn-primary" id="reservar" Type="Submit">Reservar</button>
			</div>
>>>>>>> branch 'master' of https://github.com/ignacrescenzo/centro-medico.git
			<br>
			<br>
			<button class="btn btn-lg btn-primary btn-block" type="button" id="atras">Atras</button>
			
			</form:form>
 			

      </div>
      <!-- /.content-wrapper -->
<<<<<<< HEAD

    </div>
    <!-- /#wrapper -->

=======
      
      	<footer class="sticky-footer" >
				<div class="col-xs-12 col-sm-12 progress-container">
				    <div class="progress progress-striped active">
				        <div class="progress-bar progress-bar-success" style="width:80%">80%</div>
				    </div>
				</div>	
        </footer>

    </div>
    <!-- /#wrapper -->
	</div> 
	
>>>>>>> branch 'master' of https://github.com/ignacrescenzo/centro-medico.git
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
	
	 <!-- Bootstrap core y JavaScript-->
    <script src="${context}/js/jquery/jquery.min.js"></script>
    <script src="${context}/js/bootstrap/bootstrap.bundle.min.js"></script>

    <!--Jquery-->
    <script src="${context}/js/jquery-3.3.1.min.js"></script>
    <script src="${context}/js/jquery/jquery.easing.min.js"></script>
    <script src="${context}/js/mostrar-turnos.js" type="text/javascript"></script>

  	<!-- Estilo que se aplica en todas las vistas-->
    <script src="${context}/js/jquery/sb-admin.min.js"></script>
    
	
<<<<<<< HEAD
	
=======
>>>>>>> branch 'master' of https://github.com/ignacrescenzo/centro-medico.git
</body>

</html>