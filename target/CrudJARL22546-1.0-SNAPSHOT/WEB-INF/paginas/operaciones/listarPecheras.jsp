<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="en_US"/>
<section id="pecheras">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4> Listado de camisetas</h4>
                    </div>
                    <table class="table table-stripped">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Club</th>
                                <th>Jugador</th>
                                <th>Dorsal</th>
                                <th>Año</th>
                                <th>Precio</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var = "pechera" items = "${pecheras}" varStatus="status">
                                <tr>
                                    <td>${status.count}</td>
                                    <td>${pechera.club}</td>
                                    <td>${pechera.jugador}</td>
                                    <td>${pechera.dorsal}</td>
                                    <td>${pechera.año}</td>
                                    <td><fmt:formatNumber value="${pechera.precio} " type="currency"/> USD</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/servletControlador?accion=editar&idPechera=${pechera.idpechera}" class="btn btn-secondary">
                                            <i class="fas fa-angle-double-right"></i>
                                            Editar 
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card text-center bg-danger text-white mb-3">
                    <div class="card-body">
                        <h3>Stock de camisetas</h3>
                        <h4 class="display-4"><i class="fas fa-users"></i> ${totalCamisetas}</h4>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<jsp:include page="/WEB-INF/paginas/operaciones/agregarPechera.jsp"/>