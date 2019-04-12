<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="<c:url value="/resource/Bootstrap/css/bootstrap.css"/>"
	rel="stylesheet" type="text/css">
<title>Times</title>
</head>
<body>
	<div class="container">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h2>Partidas cadastradas</h2>
			</div>
			<div class="table-responsive">
				<table class="table table-bordered table-hover">
					<tr>
						<th class="text-center">#</th>
						<th class="text-center">Time 1</th>
						<th class="text-center">Pontuação</th>
						<th class="text-center">X</th>
						<th class="text-center">Pontuação</th>
						<th class="text-center">Time 2</th>
						<th></th>
						<th></th>
					</tr>
					<c:forEach var="p" items="${partidas}">

						<tr>
							<td class="text-center">${p.codigo}</td>
							<td>${p.time1.nome}</td>
							<td>${p.pontuacao1}</td>
							<td class="text-center">X</td>
							<td>${p.pontuacao2}</td>
							<td>${p.time2.nome}</td>
							<td><a href="<c:url value = "/partida/editar/${p.codigo}"/>"><button
										class="btn btn-primary">Editar</button></a></td>
							<td><a
								href="<c:url value = "/partida/excluir/${p.codigo}"/>"><button
										class="btn btn-danger">Excluir</button></a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<br> <a href="<c:url value = "/time/cadastro"/>"><button
					class="btn btn-default">Cadastrar novo time</button></a> <a
				href="<c:url value = "/partida/cadastro"/>"><button
					class="btn btn-success">Cadastrar Partida</button></a> <a
				href="<c:url value = "/time/mostrar"/>"><button
					class="btn btn-info">Listar times</button></a>
		</div>

		<div class="panel panel-success">
			<div class="panel-heading">
				<h2>Pontuações</h2>
			</div>
			<div class="table-responsive">
				<table class="table table-bordered table-hover">
					<tr>
						<th class="text-center">Time</th>
						<th class="text-center">Pontuação</th>
					</tr>
					<c:forEach var="t" items="${times}">
						<tr>
							<td>${t.nome}</td>
							<td>${t.pontuacao}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>

	</div>
</body>
</html>