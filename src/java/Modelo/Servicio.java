package Modelo;

public class Servicio {

    private int id;
    private String descripcion;
    private float precio;

    @Override
    public String toString() {
        return descripcion + " - $" + precio;
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

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Servicio(int id, String descripcion, float precio) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
    }
}
