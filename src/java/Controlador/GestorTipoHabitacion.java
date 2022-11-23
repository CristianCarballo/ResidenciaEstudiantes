package Controlador;

import Modelo.TipoHabitacion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GestorTipoHabitacion extends Gestor {

    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private TipoHabitacion tipoHabitacion;

    public GestorTipoHabitacion() {
        preparedStatement = null;
        tipoHabitacion = null;
        resultSet = null;
    }

    @Override
    public ArrayList listar() {
        ArrayList<TipoHabitacion> lista = new ArrayList<>();
        try {
            resultSet = this.openSQLQuery("select * from tipoHabitacion");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String descripcion = resultSet.getString(2);
                int capacidad = resultSet.getInt(3);
                float precio = resultSet.getFloat(4);
                tipoHabitacion = new TipoHabitacion(id, descripcion, capacidad, precio);
                lista.add(tipoHabitacion);
            }
            this.closeSQLQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return lista;
    }

    public TipoHabitacion getTipoHabitacionById(int idTipoHabitacion) {
        try {
            resultSet = this.openSQLQuery("select * from TipoHabitacion where idTipoHabitacion = " + idTipoHabitacion);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String descripcion = resultSet.getString(2);
                int capacidad = resultSet.getInt(3);
                float precio = resultSet.getFloat(4);
                tipoHabitacion = new TipoHabitacion(id, descripcion, capacidad, precio);
            }
            this.closeSQLQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return tipoHabitacion;
    }

    @Override
    public void insert(Object objeto) {
        try {
            tipoHabitacion = (TipoHabitacion) objeto;
            preparedStatement = this.openSQLNoQuery("insert into tipoHabitacion values (?,?,?)");
            preparedStatement.setString(1, tipoHabitacion.getDescripcion());
            preparedStatement.setInt(2, tipoHabitacion.getCapacidad());
            preparedStatement.setFloat(3, tipoHabitacion.getPrecio());
            preparedStatement.execute();
            this.closeSQLNoQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void update(Object objeto) {
        try {
            tipoHabitacion = (TipoHabitacion) objeto;
            preparedStatement = this.openSQLNoQuery("update tipoHabitacion set descripcion = ?, capacidad = ?, precio = ? where idTipoHabitacion = ?");
            preparedStatement.setString(1, tipoHabitacion.getDescripcion());
            preparedStatement.setInt(2, tipoHabitacion.getCapacidad());
            preparedStatement.setFloat(3, tipoHabitacion.getPrecio());
            preparedStatement.setInt(4, tipoHabitacion.getId());
            preparedStatement.execute();
            this.closeSQLNoQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void delete(Object objeto) {
        try {
            tipoHabitacion = (TipoHabitacion) objeto;
            preparedStatement = this.openSQLNoQuery("delete tipoHabitacion where idTipoHabitacion = ?");
            preparedStatement.setInt(1, tipoHabitacion.getId());
            preparedStatement.execute();
            this.closeSQLNoQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

}
