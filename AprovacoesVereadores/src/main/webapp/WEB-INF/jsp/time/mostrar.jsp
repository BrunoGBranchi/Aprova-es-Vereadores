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
				<h2>Times Cadastrados</h2>
				</div>
				<div class="table-responsive">
					<table class="table table-bordered table-hover ">
						<tr>
							<th class="text-center">#</th>
							<th class="text-center">Nome</th>
							<th></th>
							<th></th>
						</tr>
						<c:forEach var="t" items="${times}">

							<tr>
								<td class="text-center">${t.codigo}</td>
								<td>${t.nome}</td>
								<td><a href="<c:url value = "/time/editar/${t.codigo}"/>"><button
											class="btn btn-primary">
											<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
										</button></a></td>
								<td><a href="<c:url value = "/time/excluir/${t.codigo}"/>"><button
											class="btn btn-danger">
											<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
										</button></a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<br>
				<a href="<c:url value = "/time/cadastro"/>"><button
						class="btn btn-default">Cadastrar novo time</button></a> <a
					href="<c:url value = "/partida/cadastro"/>"><button
						class="btn btn-success">Cadastrar Partida</button></a> <a
					href="<c:url value = "/partida/mostrar"/>"><button
						class="btn btn-info">Tabela/Partidas cadastradas</button></a>
			
		</div>
	</div>
</body>
</html>