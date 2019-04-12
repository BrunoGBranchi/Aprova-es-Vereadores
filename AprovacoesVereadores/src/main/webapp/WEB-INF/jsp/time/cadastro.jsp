<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="<c:url value="/resource/Bootstrap/css/bootstrap.css"/>"
	rel="stylesheet" type="text/css">
<title>Cadastrar um time</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-sm-offset-3">

				<h2>Cadastrar time</h2>
				<form class="form-horizontal"
					action='<c:url value="/time/enviar"></c:url>' method="post">
					<div class="form-group">
						<label class="col-sm-2 control-label">Nome: </label>
						<div class="col-sm-10">
							<input class="form-control" type="text" name="time.nome" />
						</div>
						<br>
						<div class="form-group">
							<input class="btn btn-success" type="submit" name="Enviar" />
						</div>
					</div>
				</form>
				<a href="<c:url value = "/time/mostrar"/>"><button
						class="btn btn-primary">Listar times</button></a>
			</div>
		</div>
	</div>
</body>
</html>