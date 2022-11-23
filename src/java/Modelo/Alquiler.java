package Modelo;

import Controlador.GestorDetalleAlquiler;
import java.util.Date;

public class Alquiler {

    private int id;
    private Habitacion habitacion;
    private Date fecha;
    private float precio;
    private Pago pago;

    @Override
    public String toString() {
        DetalleAlquiler da = new GestorDetalleAlquiler().getDetalleAlquilerByIdAlquiler(id);
        return da.getInquilino().getApellido() + " " + da.getInquilino().getNombre() + " - Habitación: " + habitacion.getTipoHabitacion().getDescripcion() + " - Fecha alquiler: " + fecha + " - A pagar: " + precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public Alquiler(int id, Habitacion habitacion, Date fecha, float precio, Pago pago) {
        this.id = id;
        this.habitacion = habitacion;
        this.fecha = fecha;
        this.precio = precio;
        this.pago = pago;
    }

    public Alquiler(Habitacion habitacion, Date fecha, float precio) {
        this.habitacion = habitacion;
        this.fecha = fecha;
        this.precio = precio;
    }
}
