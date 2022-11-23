package Modelo;

import java.util.Date;

public class DetalleAlquiler {

    private int id;
    private Alquiler alquiler;
    private Inquilino inquilino;
    private Date fechaIngreso;
    private Date fechaSalida;

    public DetalleAlquiler(Alquiler alquiler, Inquilino inquilino, Date fechaIngreso, Date fechaSalida) {
        this.alquiler = alquiler;
        this.inquilino = inquilino;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
    }

    @Override
    public String toString() {
        return "DetalleAlquiler{" + "id=" + id + ", alquiler=" + alquiler + ", inquilino=" + inquilino + ", fechaIngreso=" + fechaIngreso + ", fechaSalida=" + fechaSalida + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Alquiler getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(Alquiler alquiler) {
        this.alquiler = alquiler;
    }

    public Inquilino getInquilino() {
        return inquilino;
    }

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public DetalleAlquiler(int id, Alquiler alquiler, Inquilino inquilino, Date fechaIngreso, Date fechaSalida) {
        this.id = id;
        this.alquiler = alquiler;
        this.inquilino = inquilino;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
    }

    public java.sql.Date sqlStartDate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
