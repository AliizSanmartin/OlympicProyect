<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ingresar deportista</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="css/estilos.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<h1>Ingresar ciclista olímpico</h1>
	<%!public String obtieneAtributo(HttpServletRequest request, String nombre) {
		String valor = (String) request.getAttribute(nombre);
		if (valor == null) {
			valor = "";
		}
		return valor;
	}%>
	<h6><%=obtieneAtributo(request, "valError")%></h6>
	<form method="post" action="Registro">
		<table class="table table-hover table-dark">

			<tr>
				<td>Nombre</td>
				<td><input type="text" class="form-control" name="nombre"
					value="<%=obtieneAtributo(request, "valNombre")%>" /></td>
			</tr>
			<tr>
				<td>Tipo de medalla</td>
				<td><input type="text" class="form-control" name="medalla"
					value="<%=obtieneAtributo(request, "valMedalla")%>" /></td>
			</tr>
			<tr>
				<td>Fecha</td>
				<td><input type="text" class="form-control" name="fecha"
					value="<%=obtieneAtributo(request, "valFecha")%>" /></td>
			</tr>
			<tr>
				<td><input type="submit" class="btn btn-primary btn-block"
					value="Guardar" /></td>
			</tr>

		</table>
	</form>
	<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>