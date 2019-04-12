<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<c:url value="/resource/Bootstrap/css/bootstrap.css"/>" rel="stylesheet" type="text/css">
<title>Editando time...</title>
</head>
<body>
<div class="container">
<h2>Editar time</h2>
	<form class="form-horizontal" action= '<c:url value="/time/editando"></c:url>'  method= "post">
		<div class="form-group">
			<input type="hidden" name="time.codigo" value="${times.codigo}"/>
			<label>Nome: </label> <input type="text" name="time.nome" value="${times.nome}" />
			<input class="btn btn-success" type="submit" name="Enviar" />
		</div>
	</form>
	<a href = "<c:url value = "/time/mostrar"/>"><button class="btn btn-primary">Listar times</button></a>
</div>
</body>
</html>