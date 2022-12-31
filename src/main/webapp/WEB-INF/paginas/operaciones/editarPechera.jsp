<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://kit.fontawesome.com/0bf3a884f9.js" crossorigin="anonymous"></script>
        <title>Editar stock camisetas</title>     
    </head>
    <body>
        <jsp:include page="../comunes/cabecera.jsp"/>
        <form action="${pageContext.request.contextPath}/servletControlador?accion=modificar&idPechera=${pechera.idpechera}" method="POST" class="was-validated">
            <jsp:include page="../comunes/botonesNavegacionEditar.jsp"/>

            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Modificar camiseta</h4>
                                </div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="club">Club</label>
                                        <input type="text" class="form-control" name="club" value="${pechera.club}" required/>
                                    </div>
                                    <div class="form-group">
                                        <label for="jugador">Jugador</label>
                                        <input type="text" class="form-control" name="jugador" value="${pechera.jugador}" required/>
                                    </div>
                                    <div class="form-group">
                                        <label for="dorsal">Dorsal</label>
                                        <input type="number" class="form-control" name="dorsal" value="${pechera.dorsal}" required/>
                                    </div>
                                    <div class="form-group">
                                        <label for="año">Año</label>
                                        <input type="number" class="form-control" name="año" value="${pechera.año}" required/>
                                    </div>
                                    <div class="form-group">
                                        <label for="precio">Precio</label>
                                        <input type="number" class="form-control" name="precio" value="${pechera.precio}" required/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </form>
        <jsp:include page="../comunes/pieDePagina.jsp"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
