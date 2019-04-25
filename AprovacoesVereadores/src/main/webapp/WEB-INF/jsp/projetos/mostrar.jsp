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
				<h2>Projetos cadastrados</h2>
			</div>
			<div class="table-responsive">
				<table class="table table-bordered table-hover">
					<tr>
						<th class="text-center">#</th>
						<th class="text-center">Nome</th>
						<th class="text-center">Vereador</th>
						<th class="text-center">Situação</th>
						<th class="text-center">Avaliação</th>
						<th></th>
					</tr>
					<c:forEach var="pr" items="${projetos}">

						<tr>
							<td class="text-center">${pr.codigo}</td>
							<td>${pr.nome}</td>
							<td>${pr.vereador.nome}</td>
							<td>${pr.apresentado}</td>
							<td>${pr.aprovado}</td>

							<td><a
								href="<c:url value = "/projetos/excluir/${pr.codigo}"/>"><button
										class="btn btn-danger">Excluir</button></a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<br> <a href="<c:url value = "/vereador/cadastro"/>"><button
					class="btn btn-default">Cadastrar novo vereador</button></a> <a
				href="<c:url value = "/vereador/mostrar"/>"><button
					class="btn btn-info">Listar vereadores</button></a> <a
				href="<c:url value = "/projeto/cadastro"/>"><button
					class="btn btn-success">Cadastrar novo Projeto</button></a>
		</div>
	</div>
</body>
</html>