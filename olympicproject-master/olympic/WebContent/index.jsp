<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Olimpiadas</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="css/estilos.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>

	<div class="container">
		<div class="row"><h4>Elija un deporte:</H4></div> 
		<div class="row">
			<div class="col-sm"></div>
			<div class="col-sm">
				<form method="get" action="Listar">
					<input type="submit" value="Ciclistas"
						class="btn btn-primary btn-block">
				</form>
				<br/>
				<form method="get" action="ListarAtletismo">
					<input type="submit" value="Atletas"
						class="btn btn-primary btn-block">
				</form>
				<br/>
				<form method="get" action="ListarPatinaje">
					<input type="submit" value="Patinadores"
						class="btn btn-primary btn-block">
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>