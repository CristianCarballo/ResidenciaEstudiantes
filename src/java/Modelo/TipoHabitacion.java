package Modelo;

public class TipoHabitacion {

    private int id;
    private String descripcion;
    private int capacidad;
    private float precio;

    @Override
    public String toString() {
        return "TipoHabitacion{" + "id=" + id + ", descripcion=" + descripcion + ", capacidad=" + capacidad + ", precio=" + precio + '}';
    }

    public TipoHabitacion(int id, String descripcion, int capacidad, float precio) {
        this.id = id;
        this.descripcion = descripcion;
        this.capacidad = capacidad;
        this.precio = precio;
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

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
