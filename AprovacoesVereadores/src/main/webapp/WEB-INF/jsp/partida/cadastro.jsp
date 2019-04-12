<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="<c:url value="/resource/Bootstrap/css/bootstrap.css"/>"
	rel="stylesheet" type="text/css">
<title>Cadastrar uma partida</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-sm-offset-3">

				<h2 class="text-center">Cadastrar partida</h2>
				<form class="form-horizontal"
					action='<c:url value="/partida/enviar"></c:url>' method="post">
					<div class="form-group">
						<label class="col-sm-2 control-label">Time 1: </label>
						<div class="col-sm-10">
							<select class="form-control" name="partida.time1.codigo">
								<option>Selecione</option>
								<c:forEach var="t" items="${times}">
									<option value="${t.codigo}">${t.nome}</option>
								</c:forEach>
							</select>

						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Pontuação:</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" name="partida.pontuacao1" />
						</div>
					</div>


					<div class="form-group">
						<label class="col-sm-2 control-label">Time 2: </label>
						<div class="col-sm-10">
							<select class="form-control" name="partida.time2.codigo">
								<option>Selecione</option>
								<c:forEach var="t" items="${times}">
									<option value="${t.codigo}">${t.nome}</option>
								</c:forEach>
							</select>
						</div>

					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Pontuação:</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" name="partida.pontuacao2" />
						</div>
					</div>
					<div class="form-group">
						<input class="btn btn-success" type="submit" name="Cadastrar" />
					</div>
				</form>
				<a href="<c:url value = "/partida/mostrar"/>">
					<button class="btn btn-primary">Ver partidas cadastradas</button>
				</a>
			</div>
		</div>
	</div>
</body>
</html>