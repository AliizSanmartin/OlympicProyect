<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
	<%@ page import="epn.modelo.DeportistaAtletismo" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar deportista</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="css/estilos.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<h1>Editar información de un atleta.</h1>
	<%!
	public String obtieneAtributo(HttpServletRequest request, String nombre) {
		String valor = (String) request.getAttribute(nombre);
		if (valor == null) {
			valor = "";
		}

		return valor;
	}%>
	<form method="post" action="ActualizarAtleta">
		<table class="table table-hover table-dark">
			<tr>
				<th>id</th>
				<th>Nombre</th>
				<th>Tipo de medalla</th>
				<th>Fecha</th>
			</tr>
			<%
			DeportistaAtletismo dep;
			dep = (DeportistaAtletismo)request.getAttribute("dep");
			%>
			<tr>
				<td><input name="id" value="<%=dep.getId()%>" readonly></td>
				<td><input type="text" name="nombre" value="<%=dep.getNombre().trim()%>"></td>
				<td><input type="text" name="medalla" value="<%=dep.getMedalla().trim()%>"></td>
				<td><input type="text" name="fecha" value="<%=dep.getFecha().trim()%>"></td>
			</tr>
			<tr>
				<td><input type="submit" class="btn btn-primary btn-block" value="Actualizar" /></td>
			</tr>
		</table>
	</form>
	<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>