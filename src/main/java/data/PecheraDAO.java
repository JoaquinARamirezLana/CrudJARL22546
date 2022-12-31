package data;

import static data.Conexion.*;
import model.Pechera;
import java.sql.*;
import java.util.*;

public class PecheraDAO {

    private static final String SQL_SELECT = "SELECT * FROM pecheras";
    private static final String SQL_SELECT_BY_ID = "SELECT idpechera, club, jugador, dorsal, año, precio FROM pecheras WHERE idpechera = ?";
    private static final String SQL_INSERT = "INSERT INTO pecheras(club, jugador, dorsal, año, precio) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE pecheras SET club = ?, jugador = ?, dorsal = ?, año = ?, precio = ? WHERE idpechera = ?";
    private static final String SQL_DELETE = "DELETE FROM pecheras WHERE idpechera = ?";

    public List<Pechera> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Pechera pechera = null;
        List<Pechera> pecheras = new ArrayList();

        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idpechera = rs.getInt(1);
                String club = rs.getString("club");
                String jugador = rs.getString("jugador");
                int dorsal = rs.getInt("dorsal");
                int año = rs.getInt("año");
                double precio = rs.getDouble("precio");

                pechera = new Pechera(idpechera, club, jugador, dorsal, año, precio);

                pecheras.add(pechera);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return pecheras;
    }

    public int insertar(Pechera pechera) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, pechera.getClub());
            stmt.setString(2, pechera.getJugador());
            stmt.setInt(3, pechera.getDorsal());
            stmt.setInt(4, pechera.getAño());
            stmt.setDouble(5, pechera.getPrecio());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int actualizar(Pechera pechera){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, pechera.getClub());
            stmt.setString(2, pechera.getJugador());
            stmt.setInt(3, pechera.getDorsal());
            stmt.setInt(4, pechera.getAño());
            stmt.setDouble(5, pechera.getPrecio());
            stmt.setInt(6, pechera.getIdpechera());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int eliminar(int idpechera) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();

            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setInt(1, idpechera);
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public Pechera seleccionarPorId(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Pechera pechera = null;

        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idpechera = rs.getInt("idpechera");
                String jugador = rs.getString("jugador");
                String club = rs.getString("club");
                int dorsal = rs.getInt("dorsal");
                int año = rs.getInt("año");
                double precio = rs.getDouble("precio");

                pechera = new Pechera(idpechera, club, jugador, dorsal, año, precio);

            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return pechera;
    }

}
