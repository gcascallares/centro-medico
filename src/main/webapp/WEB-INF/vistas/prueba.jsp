<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${listaMedicos}" var="Medico">
					<option value="" path="">${Medico.nombre}</option>
				</c:forEach>	
</body>
</html>