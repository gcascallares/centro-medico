<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="context" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Registrarse</title>

    <!-- Bootstrap -->
    <link href="${context}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${context}/css/dataTables.bootstrap4.css" rel="stylesheet">

    <!-- Font Awesome-->
    <link href="${context}/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    
    <!-- Estilo que se aplica a todas las Vistas-->
    <link href="${context}/css/sb-admin.css" rel="stylesheet">
    
	<link rel="shortcut icon" type="image/x-icon" href="${context}/img/Logo.ico" />


  </head>

  <script> 
	
	var context = "${context}";
	
  </script>
  

  <body class="bg-dark">

    <div class="container">
      <div class="card card-register mx-auto mt-5">
        <div class="card-header">Registrarse</div>
        <div class="card-body">
        
       	 <img alt="" src="img/logo3.png">
          <br>
          <br>
        
          <form:form action="registrarUsuario" method="POST" modelAttribute="paciente">
          
            <div class="form-group">
              <div class="form-row">
                <div class="col-md-6">
                  <div class="form-label-group">
                    <form:input type="text" id="firstName" class="form-control" placeholder="Nombre" required="required" autofocus="autofocus" path="nombre"/>
                    <label for="firstName">Nombre</label>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-label-group">
                    <form:input type="text" id="lastName" class="form-control" placeholder="Apellido" required="required" path="apellido"/>
                    <label for="lastName">Apellido</label>
                  </div>
                </div>
              </div>
            </div>
            <div class="form-group">
              <div class="form-label-group">
                <form:input type="email" id="inputEmail" class="form-control" placeholder="centroMedico@gmil.com" required="required" path="email"/>
                <label for="inputEmail">Correo Electronico</label>
              </div>
            </div>
            <div class="form-group">
              <div class="form-row">
                <div class="col-md-6">
                  <div class="form-label-group">
                    <form:input type="text" id="inputPassword" class="form-control" placeholder="D.N.I" required="required" path="dni"/>
                    <label for="inputPassword">D.N.I</label>
                  </div>
                </div>
              </div>
            </div>
            
            <input type="submit" class="btn btn-primary btn-block" value="Continuar"></input>
            
          </form:form>
          
          
          <div class="text-center">
            <a class="d-block small mt-3" href="#">¿Ya estas registrado?</a>
            <a class="d-block small" href="#">¿Olvidaste tu contraseña?</a>
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

  	<!-- Estilo que se aplica en todas las vistas-->
    <script src="${context}/js/jquery/sb-admin.min.js"></script>
	
  </body>

</html>
