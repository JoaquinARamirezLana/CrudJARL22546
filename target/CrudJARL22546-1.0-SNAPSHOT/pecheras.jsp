<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://kit.fontawesome.com/0bf3a884f9.js" crossorigin="anonymous"></script>
        <title>Tienda de Camisetas</title>     
    </head>
    <body>
        <jsp:include page="WEB-INF/paginas/comunes/cabecera.jsp"/>
        <jsp:include page="WEB-INF/paginas/comunes/botonesNavegacion.jsp"/>
        <jsp:include page="WEB-INF/paginas/operaciones/listarPecheras.jsp"/>
        <jsp:include page="WEB-INF/paginas/comunes/pieDePagina.jsp"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
