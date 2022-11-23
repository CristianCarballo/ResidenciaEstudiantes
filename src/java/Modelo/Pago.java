package Modelo;

import java.util.Date;

public class Pago {

    private int id;
    private Date fecha;

    public Pago(Date date) {
        fecha = date;
    }

    @Override
    public String toString() {
        return "Pago{" + "id=" + id + ", fecha=" + fecha + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Pago(int id, Date fecha) {
        this.id = id;
        this.fecha = fecha;
    }
}
