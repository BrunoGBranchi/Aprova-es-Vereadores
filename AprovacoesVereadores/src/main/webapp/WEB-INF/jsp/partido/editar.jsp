<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resource/Bootstrap/css/bootstrap.css"/>"
	rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<title>Editando partido...</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-sm-offset-3">
				<h2 class="text-center">Editando partido</h2>

				<form class="form-horizontal"
					action='<c:url value="/partido/editando"></c:url>' method="post">

					<input type="hidden" name="partido.codigo"
						value="${partidos.codigo}" />
					
					<div class="form-group">
						<label class="col-sm-2 control-label">Numero:</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" name="partido.numero" value="${partidos.numero}" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label">Nome:</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" name="partido.nome" value="${partidos.nome}"/>
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