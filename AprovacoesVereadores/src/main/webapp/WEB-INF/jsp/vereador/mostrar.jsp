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
				<h2>Vereadores Cadastrados</h2>
			</div>
			<div class="table-responsive">
				<table class="table table-bordered table-hover ">
					<tr>
						<th class="text-center">#</th>
						<th class="text-center">Nome</th>
						<th class="text-center">Partido</th>
						<th class="text-center">Projetos apresentados</th>
						<th class="text-center">Projetos aprovados</th>
						<th class="text-center">Desempenho (em %)</th>
						<th></th>
						<th></th>
					</tr>
					<c:forEach var="v" items="${vereadores}">

						<tr>
							<td class="text-center">${v.codigo}</td>
							<td>${v.nome}</td>
							<td>${v.partido.nome}</td>
							<td>${v.qtdeProjetosApresentados}</td>
							<td>${v.qtdeProjetosAprovados}</td>
							<td>${v.desempenho}</td>
							<td><a
								href="<c:url value = "/vereador/editar/${v.codigo}"/>"><button
										class="btn btn-primary">
										<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
									</button></a></td>
							<td><a
								href="<c:url value = "/vereador/excluir/${v.codigo}"/>"><button
										class="btn btn-danger">
										<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
									</button></a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<br> <a href="<c:url value = "/vereador/cadastro"/>"><button
					class="btn btn-default">Cadastrar novo vereador</button></a> <a
				href="<c:url value = "/partido/cadastro"/>"><button
					class="btn btn-success">Cadastrar Partido</button></a> <a
				href="<c:url value = "/partido/mostrar"/>"><button
					class="btn btn-info">Partidos cadastrados</button></a> <a
				href="<c:url value = "/projetos/cadastro"/>"><button
					class="btn btn-warning">Cadastrar projetos</button></a>

		</div>
	</div>
</body>
</html>