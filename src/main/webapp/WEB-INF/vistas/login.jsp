<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="context" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

  <head>

   	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Iniciar Sesion</title>

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
	
  <body background="img/login.jpg" style="background-size: cover;">

    <div class="container">
      <div class="card card-login mx-auto mt-5">
        <div class="card-header">Iniciar Sesion</div>
        <div class="card-body">
        
          <img alt="" src="img/logo3.png">
          <br>
          <br>
        
          <form:form action="Inicio" method="POST" modelAttribute="usuario">
          
            <div class="form-group">
              <div class="form-label-group">
                <form:input type="text" id="inputEmail" class="form-control" placeholder="D.N.I" required="required" autofocus="autofocus" path="dni"/>
                <label for="inputEmail">D.N.I</label>
              </div>
            </div>
            
            
            <div class="form-group mt-3">
              <div class="form-label-group">
                <form:input type="password" id="inputPassword" class="form-control" placeholder="Contraseña" required="required" path="password"/>
                <label for="inputPassword">Contraseña</label>
              </div>
            </div>
            
            
           	<button type="submit" class="btn btn-primary btn-block">Iniciar</button>
            
          </form:form>
          
		  <c:if test="${not empty error}">
		  		 <h4 class="text-center mt-5"><span style="color: red;">${error}</span></h4>
		  </c:if>	
          
          <div class="text-center">
            <a class="d-block small mt-3" href="${context}/Registrar">Registrarse</a>
            <a class="d-block small" href="#">¿Olvidaste tu Contraseña?</a>
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
