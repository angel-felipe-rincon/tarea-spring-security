<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Producto</title>
</head>
<body>
	<h1>Editar Producto</h1>
	<form
		action="${pageContext.request.contextPath}/productos/actualizar/${producto.id}"
		method="post">
		Nombre: <input type="text" name="nombre" value="${producto.nombre}" /><br />
		Precio: <input type="text" name="precio" value="${producto.precio}" /><br />
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<input type="submit" value="Actualizar" />
	</form>
	<a href="/productos">Volver a la lista</a>
</body>
</html>