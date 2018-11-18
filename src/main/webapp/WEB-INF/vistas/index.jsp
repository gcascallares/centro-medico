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

    <title>Centro Medico</title>

     <!-- Bootstrap -->
    <link href="${context}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${context}/css/dataTables.bootstrap4.css" rel="stylesheet">

    <!-- Font Awesome-->
    <link href="${context}/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    
    <!-- Estilo que se aplica a todas las Vistas-->
    <link href="${context}/css/sb-admin.css" rel="stylesheet">

  </head>

	<script> 
		var context = "${context}";
	</script>

 <body id="page-top">

    <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

      <a class="navbar-brand mr-1" href="#"><img src="img/logo3.png"></a>

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
          <a class="nav-link" href="${context}/centroMedico">
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
              <a href="#">Inicio</a>
            </li>
          </ol>
          
          
          
          
          
          

          <!-- Contenido de la Pagina -->
        	<div class="jumbotron feature" id="banner">
        		<div class="container">
        			<h1><span class="glyphicon glyphicon-plus"></span> Centro Medico</h1>
        			<p>Que tu medicina sea tu alimento, y el alimento tu medicina</p>
        			<p><a class="btn btn-primary" href="${context}/turno">Solicitar Turno</a></p>
        		</div>
        	</div>

            <!-- Header -->
            <div class="container">
                <div class="row">
                    <div class="col-xs-12">
                        <h1 class="text-center">Especialidades</h1>
                        <p class="lead text-center">Contamos con la ultima tecnologia, un equipo de profecionales que se encargargan 
                        de poder solucionar todos los problemas de nuestros pacientes, pudiendo ofrecer servicios de alta calidad</p>
                    </div>
                </div>
            </div>

            <!-- Especialidades -->
        	<div class="container-fluid">
                <div class="row promo">
                	<a href="#">
        				<div class="col-md-16 promo-item " id="cardiologia">
        					<h3>
        						<i class="fas fa-heartbeat"></i> Cardiologia
        					</h3>
        				</div>
                    </a>
                    <a href="#">
        				<div class="col-md-12 promo-item " id="laboratorio">
        					<h3>
        						<i class="fas fa-vials"></i> Laboratorio
        					</h3>
        				</div>
                    </a>
        			
        			<a href="#">
        				<div class="col-md-12 promo-item " id="radiologia">
        					<h3>
        						<i class="fas fa-x-ray"></i> Radiologia
        					</h3>
        				</div>
                    </a>
                </div>
            </div>
        	
        	
        	<div class="container text-center">
        		<h1>Horarios de Atencion</h1>
        		<p class="lead">Lunes: 8:00 a 20:00<br>
        						Martes: 8:00 a 20:00<br>
        						Miercoles: 10:00 a 18:00<br>
        						Jueves: 8:00 a 20:00<br>
        						Viernes: 8:00 a 17:00</p>
        	</div><!--/.container-->
        	
        	<br>
        	<!-- Footer -->
        	<footer>
        	
        		<h1 class="text-center">Encuentranos</h1>

        		<!-- Map -->
        		<div class="footer-map">
        			<iframe src="https://www.google.com/maps/embed?pb=!1m10!1m8!1m3!1d13134.54267974602!2d-58.62869475!3d-34.6133732!3m2!1i1024!2i768!4f13.1!5e0!3m2!1ses!2sar!4v1542486246251" style="width: 100%; height: 100%;" ></iframe>
        		</div>	


        			
        			<div class="container">
        				<div class="row">
        					<div class="col-sm-12 footer-info-item text-center">
        						<p class="lead">
        							Florencio Varela 1800, San justo, Buenos Aires
        						</p>
        						<h2>Contactanos</h2>
        						<p class="lead"><span class="glyphicon glyphicon-phone-alt"></span><i class="fas fa-phone"></i> +54 (11) 5478 - 9867<br>
        						mediCenter@gmail.com</p>
        					</div>
        				</div>
        			</div>
				<br>
				<br>
				
        		<!-- Footer Links -->
        		<div class="footer-info">
        			<div class="container">
        				<div class="row">
        					<div class="col-sm-4 footer-info-item">
        						<h3>Informacion</h3>
        						<ul class="list-unstyled">
        							<li><a href="#">Nosotros</a></li>
        							<li><a href="#">Servicion al Consumidor</a></li>
        							<li><a href="#">Politicas de Privacidad</a></li>
        							<li><a href="#">Mapa del Sitio</a></li>
        							<li><a href="#">Consultas</a></li>
        						</ul>
        					</div>
        					<div class="col-sm-4 footer-info-item">
        						<h3>Mi Cuenta</h3>
        						<ul class="list-unstyled">
        							<li><a href="#">Iniciar Sesion</a></li>
        							<li><a href="#">Derivaciones</a></li>
        							<li><a href="#">Turnos</a></li>
        							<li><a href="#">Resultados Medicos</a></li>
        							<li><a href="#">Ayuda</a></li>
        						</ul>	
        					</div>
        					<div class="col-sm-4 footer-info-item">
        						<h3><span class="glyphicon glyphicon-list-alt"></span> Noticias</h3>
        						<p>Inicia Sesion para estar informado con lo ultimo!!</p>
        						<div class="input-group">
        							<input type="email" class="form-control" placeholder="Ingresa tu correo electronico">
        							<span class="input-group-btn">
        								<button class="btn btn-primary" type="button">
        									Subcribite
        								</button>
        							</span>
        						</div>
        					</div>
        				</div><!-- /.row -->
        			</div><!-- /.container -->
                </div>
                
        	</footer>

                </div>
                <!-- /.container-fluid -->

                <!-- Sticky Footer -->
                <footer class="sticky-footer">
                  <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                      <span>Copyright © Taller Web 1 2018</span>
                    </div>
                  </div>
                </footer>

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

    <!-- Core plugin JavaScript-->
    <script src="${context}/js/jquery/jquery.easing.min.js"></script>

    <!-- Estilo que se aplica en todas las vistas-->
    <script src="${context}/js/jquery/sb-admin.min.js"></script>

  </body>

</html>
