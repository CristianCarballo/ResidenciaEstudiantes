package Modelo;

import java.util.ArrayList;

public class Habitacion {

    private int id;
    private TipoHabitacion tipoHabitacion;
    private String descripcion;
    private ArrayList<Foto> fotos;
    private float precioPorDia;
    private int disponibilidad;

    @Override
    public String toString() {
        return tipoHabitacion.getDescripcion() + " - Precio por día: " + precioPorDia + " - Disponibilidad: " + disponibilidad;
    }

    public Habitacion(int id, TipoHabitacion tipoHabitacion, String descripcion, float precioPorDia, ArrayList<Foto> fotos, int disponibilidad) {
        this.id = id;
        this.tipoHabitacion = tipoHabitacion;
        this.descripcion = descripcion;
        this.precioPorDia = precioPorDia;
        this.fotos = fotos;
        this.disponibilidad = disponibilidad;
    }

    public Habitacion(int id, TipoHabitacion tipoHabitacion, String descripcion, ArrayList<Foto> fotos) {
        this.id = id;
        this.tipoHabitacion = tipoHabitacion;
        this.descripcion = descripcion;
        this.fotos = fotos;
    }

    public Habitacion() {
        this.id = -5;
        this.tipoHabitacion = null;
        this.descripcion = "";
        this.fotos = null;
        this.precioPorDia = 0;
        this.disponibilidad = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public ArrayList<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(Foto foto) {
        fotos.add(foto);
    }

    public float getPrecioPorDia() {
        return precioPorDia;
    }

    public void setPrecioPorDia(float precioPorDia) {
        this.precioPorDia = precioPorDia;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

}
