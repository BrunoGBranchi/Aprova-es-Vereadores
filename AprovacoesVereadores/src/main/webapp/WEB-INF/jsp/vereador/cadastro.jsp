<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="<c:url value="/resource/Bootstrap/css/bootstrap.css"/>"
	rel="stylesheet" type="text/css">
<title>Cadastrar um vereador</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-sm-offset-3">

				<h2>Cadastrar vereador</h2>
				<form class="form-horizontal"
					action='<c:url value="/vereador/enviar"></c:url>' method="post">
					<div class="form-group">
						<label class="col-sm-2 control-label">Nome: </label>
						<div class="col-sm-10">
							<input class="form-control" type="text" name="vereador.nome" />
						</div>
					</div>
					<br>
					
					<div class="form-group">
						<label class="col-sm-2 control-label">Partido: </label>
						<div class="col-sm-10">
							<select class="form-control" name="vereador.partido.codigo">
								<c:forEach var="partido" items="${partidos}">
									<option value="${partido.codigo}">${partido.nome}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					
					<div class="form-group">
						<input class="btn btn-success" type="submit" name="Enviar" />
					</div>
				</form>
				<a href="<c:url value = "/vereador/mostrar"/>"><button
						class="btn btn-primary">Listar vereadores</button></a>
			</div>
		</div>
	</div>
</body>
</html>