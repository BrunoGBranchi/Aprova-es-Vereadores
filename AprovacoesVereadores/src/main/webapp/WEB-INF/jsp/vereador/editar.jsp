<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<c:url value="/resource/Bootstrap/css/bootstrap.css"/>" rel="stylesheet" type="text/css">
<title>Editando vereador...</title>
</head>
<body>
<div class="container">
<h2>Editar vereador</h2>
	<form class="form-horizontal" action= '<c:url value="/vereador/editando"></c:url>'  method= "post">
		<div class="form-group">
			<input type="hidden" name="vereador.codigo" value="${vereadores.codigo}"/>
			<label>Nome: </label> <input type="text" name="vereador.nome" value="${vereadores.nome}" />
		</div>
		<div class="form-group">
						<label class="col-sm-2 control-label">Time 1: </label>
						<div class="col-sm-10">
							<select class="form-control" name="partida.time1">
								<option value="${vereadores.partido.nome}"></option>
								<c:forEach var="p" items="${partidos}">
									<option value="${p.codigo}">${p.nome}</option>
								</c:forEach>
							</select>
						</div>
					</div>
		<input class="btn btn-success" type="submit" name="Enviar" />
	</form>
	<a href = "<c:url value = "/vereador/mostrar"/>"><button class="btn btn-primary">Listar vereadores</button></a>
</div>
</body>
</html>