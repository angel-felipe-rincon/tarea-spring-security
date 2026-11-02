<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Productos</title>
</head>
<body>
	<h1>Lista de Productos</h1>

	<p>
		<a href="/">Volver al inicio</a>
	</p>

	<table border="1">
		<tr>
			<th>ID</th>
			<th>Nombre</th>
			<th>Precio</th>
			<th>Acciones</th>
		</tr>
		<c:forEach var="producto" items="${productos}">
			<tr>
				<td>${producto.id}</td>
				<td>${producto.nombre}</td>
				<td>${producto.precio}</td>
				<td><a href="/productos/editar/${producto.id}">Editar</a> | <a
					href="/productos/eliminar/${producto.id}">Eliminar</a></td>
			</tr>
		</c:forEach>
	</table>

	<p>
		<a href="/productos/nuevo">Agregar un nuevo producto</a>
	</p>
</body>
</html>