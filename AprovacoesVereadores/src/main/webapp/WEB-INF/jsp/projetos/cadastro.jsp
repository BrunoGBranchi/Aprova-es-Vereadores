<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="<c:url value="/resource/Bootstrap/css/bootstrap.css"/>"
	rel="stylesheet" type="text/css">
<title>Cadastrar um projeto</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-sm-offset-3">

				<h2 class="text-center">Cadastrar projeto</h2>
				<form class="form-horizontal"
					action='<c:url value="/projetos/enviar"></c:url>' method="post">

					<div class="form-group">
						<label class="col-sm-2 control-label">Nome:</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" name="projeto.nome"
								placeholder="Nome do projeto: Ex.: Legalização de armas" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label">Vereador:</label>
						<div class="col-sm-10">
							<select class="form-control" name="projeto.vereador.codigo">
								<option>Selecione</option>
								<c:forEach var="v" items="${vereadores}">
									<option value="${v.codigo}">${v.nome}</option>
								</c:forEach>
							</select>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label">Situação:</label>
						<div class="col-sm-10">
							<label class="radio-inline"> <input
								type="radio" name="projeto.apresentado" value="true">Apresentado
							</label> <label class="radio-inline"> <input
								type="radio" name="projeto.apresentado" value="false">
								Não apresentado
							</label>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label">Avaliação:</label>
						<div class="col-sm-10">
							<label class="radio-inline"> <input
								type="radio" name="projeto.aprovado" value="true">Aprovado
							</label> <label class="radio-inline"> <input
								type="radio" name="projeto.aprovado" value="false"> Não
								aprovado
							</label>
						</div>
					</div>
					<div class="form-group">
						<input class="btn btn-success" type="submit" name="Cadastrar" />
					</div>
				</form>
				<a href="<c:url value = "/projetos/mostrar"/>">
					<button class="btn btn-primary">Ver projetos cadastradas</button>
				</a>
			</div>
		</div>
	</div>
</body>
</html>