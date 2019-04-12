<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resource/Bootstrap/css/bootstrap.css"/>"
	rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<title>Editando partida...</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-sm-offset-3">
				<h2 class="text-center">Editando partida</h2>

				<form class="form-horizontal"
					action='<c:url value="/partida/editando"></c:url>' method="post">

					<input type="hidden" name="partida.codigo"
						value="${partidas.codigo}" />

					<div class="form-group">
						<label class="col-sm-2 control-label">Time 1: </label>
						<div class="col-sm-10">
							<select class="form-control" name="partida.time1">
								<option value="${partidas.time1}"></option>
								<c:forEach var="t" items="${times}">
									<option value="${t.nome}">${t.nome}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Pontuação: </label>
						<div class="col-sm-10">
							<input class="form-control" type="text" name="partida.pontuacao1"
								value="${partidas.pontuacao1}" />
						</div>
					</div>






					<div class="form-group">
						<label class="col-sm-2 control-label">Time 2: </label>
						<div class="col-sm-10">
							<select class="form-control" name="partida.time2">
								<option value="${partidas.time2}"></option>
								<c:forEach var="t" items="${times}">
									<option value="${t.nome}">${t.nome}</option>
								</c:forEach>
							</select>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label">Pontuação: </label>
						<div class="col-sm-10">
							<input class="form-control" type="text" name="partida.pontuacao2"
								value="${partidas.pontuacao2}" />
						</div>
					</div>
					<div class="form-group">
						<input class="btn btn-success" type="submit" name="Alterar" /> <a
							href="<c:url value = "/partida/mostrar"/>"><button
								class="btn btn-primary">Listar partidas</button></a>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>