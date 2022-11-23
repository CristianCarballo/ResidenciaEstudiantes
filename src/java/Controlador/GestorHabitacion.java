package Controlador;

import Modelo.Foto;
import Modelo.Habitacion;
import Modelo.TipoHabitacion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GestorHabitacion extends Gestor {

    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private Habitacion habitacion;
    private final GestorTipoHabitacion gestorTipoHabitacion;
    private final GestorFoto gestorFoto;
    private TipoHabitacion tipoHabitacion;

    public GestorHabitacion() {
        resultSet = null;
        preparedStatement = null;
        habitacion = null;
        gestorTipoHabitacion = new GestorTipoHabitacion();
        gestorFoto = new GestorFoto();
        tipoHabitacion = null;
    }

    @Override
    public ArrayList listar() {
        ArrayList<Habitacion> lista = new ArrayList<>();
        try {
            resultSet = this.openSQLQuery("select * from vw_habitacion_listaConPrecioPorDiayDisponibilidad order by 5");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String descripcion = resultSet.getString(2);
                tipoHabitacion = gestorTipoHabitacion.getTipoHabitacionById(resultSet.getInt(3));
                float precioPorDia = resultSet.getFloat(4);
                ArrayList<Foto> fotos = gestorFoto.getFotosById(id);
                int disponibilidad = resultSet.getInt(5);
                habitacion = new Habitacion(id, tipoHabitacion, descripcion, precioPorDia, fotos, disponibilidad);
                lista.add(habitacion);
            }
            this.closeSQLQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return lista;
    }

    public Habitacion getHabitacionMenorPrecio() {
        try {
            resultSet = this.openSQLQuery("select * from vw_habitacion_menor_precio");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                tipoHabitacion = gestorTipoHabitacion.getTipoHabitacionById(resultSet.getInt(3));
                String descripcion = resultSet.getString(2);
                float precioPorDia = resultSet.getFloat(4);
                ArrayList<Foto> fotos = gestorFoto.getFotosById(id);
                int disponibilidad = resultSet.getInt(5);
                habitacion = new Habitacion(id, tipoHabitacion, descripcion, precioPorDia, fotos, disponibilidad);
            }
            this.closeSQLQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return habitacion;
    }

    public Habitacion getHabitacionById(int idHabitacion) {
        try {
            resultSet = this.openSQLQuery("select * from vw_habitacion_listaConPrecioPorDiayDisponibilidad where idHabitacion = " + idHabitacion);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                tipoHabitacion = gestorTipoHabitacion.getTipoHabitacionById(resultSet.getInt(3));
                String descripcion = resultSet.getString(2);
                float precioPorDia = resultSet.getFloat(4);
                ArrayList<Foto> fotos = gestorFoto.getFotosById(id);
                int disponibilidad = resultSet.getInt(5);
                habitacion = new Habitacion(id, tipoHabitacion, descripcion, precioPorDia, fotos, disponibilidad);
            }
            this.closeSQLQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return habitacion;
    }

    @Override
    public void insert(Object objeto) {
        try {
            habitacion = (Habitacion) objeto;
            preparedStatement = this.openSQLNoQuery("insert into habitacion values (?,?)");
            preparedStatement.setInt(1, habitacion.getTipoHabitacion().getId());
            preparedStatement.setString(2, habitacion.getDescripcion());
            preparedStatement.execute();
            this.closeSQLNoQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void update(Object objeto) {
        try {
            habitacion = (Habitacion) objeto;
            preparedStatement = this.openSQLNoQuery("update habitacion set idTipoHabitacion = ?, descripcion = ? where id = ?");
            preparedStatement.setInt(1, habitacion.getTipoHabitacion().getId());
            preparedStatement.setString(2, habitacion.getDescripcion());
            preparedStatement.setInt(3, habitacion.getId());
            preparedStatement.execute();
            this.closeSQLNoQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void delete(Object objeto) {
        try {
            habitacion = (Habitacion) objeto;
            preparedStatement = this.openSQLNoQuery("delete habitacion where id = ?");
            preparedStatement.setInt(1, habitacion.getId());
            preparedStatement.execute();
            this.closeSQLNoQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
