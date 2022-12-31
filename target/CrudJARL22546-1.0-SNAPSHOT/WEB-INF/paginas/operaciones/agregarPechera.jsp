<div class="modal fade" id="agregarPecheraModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Camiseta</h5>
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            <form action="${pageContext.request.contextPath}/servletControlador?accion=insertar" method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="club">Club</label>
                        <input type="text" class="form-control" name="club" required/>
                    </div>
                    <div class="form-group">
                        <label for="jugador">Jugador</label>
                        <input type="text" class="form-control" name="jugador" required/>
                    </div>
                    <div class="form-group">
                        <label for="dorsal">Dorsal</label>
                        <input type="number" class="form-control" name="dorsal" required/>
                    </div>
                    <div class="form-group">
                        <label for="año">Año</label>
                        <input type="number" class="form-control" name="año" required/>
                    </div>
                    <div class="form-group">
                        <label for="precio">Precio</label>
                        <input type="number" class="form-control" name="precio" required/>
                    </div>                    
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button>
                </div>
            </form>
        </div>
    </div>
</div>
