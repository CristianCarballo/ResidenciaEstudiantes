package Modelo;

public class ViewRecaudacionHabitacion {
    private int idHabitacion;
    private TipoHabitacion tipoHabitacion;
    private float recaudacionHabitacion;

    public ViewRecaudacionHabitacion(int idHabitacion, TipoHabitacion tipoHabitacion, float recaudacionHabitacion) {
        this.idHabitacion = idHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.recaudacionHabitacion = recaudacionHabitacion;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public float getRecaudacionHabitacion() {
        return recaudacionHabitacion;
    }

    public void setRecaudacionHabitacion(float recaudacionHabitacion) {
        this.recaudacionHabitacion = recaudacionHabitacion;
    }
}
