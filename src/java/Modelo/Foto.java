package Modelo;

public class Foto {

    private int id;
    private String descripcion;

    public Foto(String fileName) {
        descripcion = fileName;
    }

    @Override
    public String toString() {
        return descripcion;
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

    public Foto(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }
}
