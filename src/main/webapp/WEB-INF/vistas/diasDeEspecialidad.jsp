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

     <title>Eliga su Fecha</title>

 	<!-- Bootstrap -->
    <link href="${context}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${context}/css/dataTables.bootstrap4.css" rel="stylesheet">

    <!-- Font Awesome-->
    <link href="${context}/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    
    <!-- Estilo que se aplica a todas las Vistas-->
    <link href="${context}/css/sb-admin.css" rel="stylesheet">
    
    <!-- Estilo que se aplica a todas las Vistas-->
    <link href="${context}/js/jquery-ui/jquery-ui.min.css" rel="stylesheet" >
	
	<link rel="shortcut icon" type="image/x-icon" href="${context}/img/Logo.ico" />

</head>

<script> 


///GUARDO LA LISTA CON LOS ID DE DIAS EN JAVASCRIPT
	var dias = new Array();
	<c:forEach items="${dias}" var="dia"> 
	   dias.push(${dia});
	</c:forEach> 
	
	var context = "${context}";
	
</script>

<body id="page-top">


	  <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

      <a class="navbar-brand mr-1" href="#"><img src="${context}/img/logo3.png"></a>

      <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
        <i class="fas fa-bars"></i>
      </button>

      <!-- Barra de Busqueda -->
      <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
        <div class="input-group">
          <input type="text" class="form-control" placeholder="Buscar" aria-label="Search" aria-describedby="basic-addon2">
          <div class="input-group-append">
            <button class="btn btn-primary" type="button">
              <i class="fas fa-search"></i>
            </button>
          </div>
        </div>
      </form>

      <!-- Desplegable del usuario -->
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
            <i class="fas fa-mobile-alt"></i></i>
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
          
          
          
          
          
          

          <!-- Contenido de la Pagina -->
        		
        		
		        <input type"hidden" value="${especialidadId}" id="especialidadId" hidden>
				<input type"hidden" value="${medicoId}" id="medicoId" hidden>
				<h3 class="form-signin-heading">Elija su Fecha</h3>
				<br>
				<br>
				<br>
		
				<input type="text" id="datepicker">
				
				<div id="mensajeDia" class="errores">Por favor seleccione alguna de las fechas disponibles</div>
				
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
				<br>
				<br>
				
				<a class="btn btn-lg btn-primary btn-block" id="siguiente">Continuar</a>
				<br>
				<button type="button" class="btn btn-lg btn-primary btn-block" id="atras">Atras</button>
 			



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
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body">Seleccione la opcion "Cerrar" que esta debajo si esta listo para cerrar su sesion </div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
            <a class="btn btn-primary" href="#">Cerrar</a>
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
    <script src="${context}/js/elegir-dia-de-especialidad.js" type="text/javascript"></script>

  	<!-- Estilo que se aplica en todas las vistas-->
    <script src="${context}/js/jquery/sb-admin.min.js"></script>
	
	<!-- Jquery UI-->
	<script src="${context}/js/jquery-ui/jquery-ui.min.js"></script>
	
	<!-- Moments JS-->
	<script src="${context}/js/moment.js" type="text/javascript"></script>
	
</body>

</html>