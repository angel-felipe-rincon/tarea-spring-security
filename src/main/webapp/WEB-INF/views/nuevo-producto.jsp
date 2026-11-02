<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Nuevo Producto</title>
</head>
<body>
    <h1>Agregar Nuevo Producto</h1>
    <form action="guardar" method="post">
        Nombre: <input type="text" name="nombre"/><br/>
        Precio: <input type="text" name="precio"/><br/>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Guardar"/>
    </form>
    <a href="/productos">Volver a la lista</a>
</body>
</html>