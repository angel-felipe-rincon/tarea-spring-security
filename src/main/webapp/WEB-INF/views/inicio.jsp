<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inicio</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 40px;
}

a {
	margin-right: 15px;
}
</style>
</head>
<body>
  <h1>Bienvenido, <c:out value="${username}"/></h1>
  <p>Tus roles:
    <c:forEach var="r" items="${roles}"><b><c:out value="${r}"/></b> </c:forEach>
  </p>

  <p>
    <a href="/productos">Ver productos</a>
    <a href="/productos/nuevo">Nuevo producto</a>
  </p>

  <form action="/logout" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <button type="submit">Cerrar sesión</button>
  </form>
</body>
</html>