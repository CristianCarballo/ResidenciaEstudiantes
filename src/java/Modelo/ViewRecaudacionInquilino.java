package Modelo;

public class ViewRecaudacionInquilino {

    private int idInquilino;
    private String nombreInquilino;
    private String apellidoInquilino;
    private float recaudacionInquilino;

    public ViewRecaudacionInquilino(int idInquilino, String nombreInquilino, String apellidoInquilino, float recaudacionInquilino) {
        this.idInquilino = idInquilino;
        this.nombreInquilino = nombreInquilino;
        this.apellidoInquilino = apellidoInquilino;
        this.recaudacionInquilino = recaudacionInquilino;
    }

    public int getIdInquilino() {
        return idInquilino;
    }

    public void setIdInquilino(int idInquilino) {
        this.idInquilino = idInquilino;
    }

    public String getNombreInquilino() {
        return nombreInquilino;
    }

    public void setNombreInquilino(String nombreInquilino) {
        this.nombreInquilino = nombreInquilino;
    }
    
    public String getApellidoInquilino() {
        return apellidoInquilino;
    }

    public void setApellidoInquilino(String apellidoInquilino) {
        this.apellidoInquilino = apellidoInquilino;
    }

    public float getRecaudacionInquilino() {
        return recaudacionInquilino;
    }

    public void setRecaudacionInquilino(float recaudacionInquilino) {
        this.recaudacionInquilino = recaudacionInquilino;
    }

}
