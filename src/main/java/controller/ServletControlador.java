package controller;

import data.PecheraDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Pechera;

@WebServlet("/servletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String accionJava = req.getParameter("accion");
        if (accionJava != null) {
            switch (accionJava) {
                case "editar":
                    editarPechera(req, res);
                    break;
                case "eliminar":
                    eliminarPechera(req, res);
                    break;
                default:
                    accionDefault(req, res);
                    break;
            }
        } else {
            accionDefault(req, res);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String accionJava = req.getParameter("accion");
        if (accionJava != null) {
            switch (accionJava) {
                case "insertar":
                    insertarPechera(req, res);
                    break;
                case "modificar":
                    modificarPechera(req, res);
                    break;
                default:
                    accionDefault(req, res);
                    break;
            }
        } else {
            accionDefault(req, res);
        }
    }

    private void accionDefault(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        List<Pechera> pecheras = new PecheraDAO().seleccionar();
        HttpSession sesion = req.getSession();
        sesion.setAttribute("pecheras", pecheras);
        sesion.setAttribute("totalCamisetas", pecheras.size());
        res.sendRedirect("pecheras.jsp");
    }

    private void insertarPechera(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String club = req.getParameter("club");
        String jugador = req.getParameter("jugador");
        int dorsal = 0, año = 0;
        double precio = 0;
        String dorsalString = req.getParameter("dorsal");
        if (dorsalString != null && !dorsalString.equals("")) {
            dorsal = Integer.parseInt(dorsalString);
        }
        String añoString = req.getParameter("año");
        if (añoString != null && !añoString.equals("")) {
            año = Integer.parseInt(añoString);
        }
        String precioString = req.getParameter("precio");
        if (precioString != null && !precioString.equals("")) {
            precio = Double.parseDouble(precioString);
        }
        Pechera pechera = new Pechera(club, jugador, dorsal, año, precio);
        accionDefault(req, res);
    }

    private void editarPechera(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int idpechera = Integer.parseInt(req.getParameter("idPechera"));

        Pechera pechera = new PecheraDAO().seleccionarPorId(idpechera);

        req.setAttribute("pechera", pechera);
        String jspEditar = "/WEB-INF/paginas/operaciones/editarPechera.jsp";

        req.getRequestDispatcher(jspEditar).forward(req, res);
    }

    private void modificarPechera(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        int idpechera = Integer.parseInt(req.getParameter("idPechera"));
        String club = req.getParameter("club");
        String jugador = req.getParameter("jugador");
        int dorsal = 0, año = 0;
        double precio = 0;
        String dorsalString = req.getParameter("dorsal");
        if (dorsalString != null && !dorsalString.equals("")) {
            dorsal = Integer.parseInt(dorsalString);
        }
        String añoString = req.getParameter("año");
        if (añoString != null && !añoString.equals("")) {
            año = Integer.parseInt(añoString);
        }
        String precioString = req.getParameter("precio");
        if (precioString != null && !precioString.equals("")) {
            precio = Double.parseDouble(precioString);
        }
        Pechera pechera = new Pechera(idpechera, club, jugador, dorsal, año, precio);
        accionDefault(req, res);
    }

    private void eliminarPechera (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int idpechera = Integer.parseInt(req.getParameter("idPechera"));
        accionDefault(req, res);
    }
    
}
