package model;

public class Pechera {
    
    private int idpechera;
    private String club;
    private String jugador;
    private int dorsal;
    private int año;
    private double precio;

    public Pechera(int idpechera, String club, String jugador, int dorsal, int año, double precio) {
        this.idpechera = idpechera;
        this.club = club;
        this.jugador = jugador;
        this.dorsal = dorsal;
        this.año = año;
        this.precio = precio;
    }

    public Pechera(String club, String jugador, int dorsal, int año, double precio) {
        this.club = club;
        this.jugador = jugador;
        this.dorsal = dorsal;
        this.año = año;
        this.precio = precio;
    }

    public Pechera() {
    }

    public int getIdpechera() {
        return idpechera;
    }

    public void setIdpechera(int idpechera) {
        this.idpechera = idpechera;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Pechera{" + "club=" + club + ", jugador=" + jugador + ", dorsal=" + dorsal + ", a\u00f1o=" + año + ", precio=" + precio + '}';
    }

}
