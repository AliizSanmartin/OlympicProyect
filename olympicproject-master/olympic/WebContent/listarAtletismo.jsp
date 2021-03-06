<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<%@ page import="java.util.List" %>
	<%@ page import="epn.modelo.DeportistaAtletismo" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de medallistas</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="css/estilos.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<h1>Lista de los atletistas con medallas.</h1>
	<a href='http://localhost:8080/olympic/registroAtleta.jsp' class="btn btn-outline-primary btn-block">Ingresar medallista</a>
	<table class="table table-borderless table-dark">
		<tr>
			<th>id</th>
			<th>Nombre</th>
			<th>Tipo de medalla</th>
			<th>Fecha</th>
		</tr>
		<%
			List<DeportistaAtletismo> dep;
			dep = (List<DeportistaAtletismo>) request.getAttribute("dep");
			for (DeportistaAtletismo d : dep){
		%>
		<tr>
			<td><%=d.getId()%></td>
			<td><%=d.getNombre()%></td>
			<td><%=d.getMedalla()%></td>
			<td><%=d.getFecha()%></td>
			<td><a href="EditarAtleta?id=<%=d.getId()%>">Editar</a></td>
			<td><a href="EliminarAtleta?id=<%=d.getId()%>">Eliminar</a></td>
		</tr>
		<%} %>
	</table>
	<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>