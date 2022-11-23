package Controlador;

import Modelo.Servicio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GestorServicio extends Gestor {

    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private Servicio servicio;

    public GestorServicio() {
        preparedStatement = null;
        servicio = null;
        resultSet = null;
    }

    @Override
    public ArrayList listar() {
        ArrayList<Servicio> lista = new ArrayList<>();
        try {
            resultSet = this.openSQLQuery("select * from servicio");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String descripcion = resultSet.getString(2);
                float precio = resultSet.getFloat(3);
                servicio = new Servicio(id, descripcion, precio);
                lista.add(servicio);
            }
            this.closeSQLQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return lista;
    }

    public Servicio getServicioById(int idServicio) {
        try {
            resultSet = this.openSQLQuery("select * from servicio where idServicio = " + idServicio);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String descripcion = resultSet.getString(2);
                float precio = resultSet.getFloat(3);
                servicio = new Servicio(id, descripcion, precio);
            }
            this.closeSQLQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return servicio;
    }

    public int getIdServicioHabitacion(int idHabitacion, int idServicio) {
        int idServicioHabitacion = -1;
        try {
            preparedStatement = this.openSQLNoQuery("select * from servicioHabitacion where idHabitacion = ? and idServicio = ?");
            preparedStatement.setInt(1, idHabitacion);
            preparedStatement.setInt(2, idServicio);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                idServicioHabitacion = resultSet.getInt(1);
            }
            this.closeSQLQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return idServicioHabitacion;
    }

    public ArrayList getServiciosHabitacionById(int idHabitacion) {
        ArrayList<Servicio> lista = new ArrayList<>();
        try {
            resultSet = this.openSQLQuery("select s.idServicio, s.descripcion, s.precio from ServicioHabitacion sh join Servicio s on sh.idServicio = s.idServicio where idHabitacion = " + idHabitacion);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String descripcion = resultSet.getString(2);
                float precio = resultSet.getFloat(3);
                servicio = new Servicio(id, descripcion, precio);
                lista.add(servicio);
            }
            this.closeSQLQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return lista;
    }

    public void insertServiciosHabitacion(int idHabitacion, ArrayList<Servicio> servicios) {
        try {
            preparedStatement = this.openSQLNoQuery("insert into servicioHabitacion values (?,?)");
            for (Servicio s : servicios) {
                if (s != null) {
                    preparedStatement.setInt(1, s.getId());
                    preparedStatement.setInt(2, idHabitacion);
                    preparedStatement.execute();
                }
            }
            this.closeSQLNoQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void updateServiciosHabitacion(int idServicio, int idHabitacion, int idServicioHabitacion) {
        try {
            preparedStatement = this.openSQLNoQuery("update servicioHabitacion set idServicio = ?, idHabitacion = ? where idServicioHabitacion = ?");
            preparedStatement.setInt(1, idServicio);
            preparedStatement.setInt(2, idHabitacion);
            preparedStatement.setInt(3, idServicioHabitacion);
            preparedStatement.execute();
            this.closeSQLNoQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void insert(Object objeto) {
        try {
            servicio = (Servicio) objeto;
            preparedStatement = this.openSQLNoQuery("insert into servicio values (?,?)");
            preparedStatement.setString(1, servicio.getDescripcion());
            preparedStatement.setFloat(2, servicio.getPrecio());
            preparedStatement.execute();
            this.closeSQLNoQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void update(Object objeto) {
        try {
            servicio = (Servicio) objeto;
            preparedStatement = this.openSQLNoQuery("update servicio set descripcion = ?, precio = ? where idServicio = ?");
            preparedStatement.setString(1, servicio.getDescripcion());
            preparedStatement.setFloat(2, servicio.getPrecio());
            preparedStatement.setInt(3, servicio.getId());
            preparedStatement.execute();
            this.closeSQLNoQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void delete(Object objeto) {
        try {
            servicio = (Servicio) objeto;
            preparedStatement = this.openSQLNoQuery("delete servicio where idServicio = ?");
            preparedStatement.setInt(1, servicio.getId());
            preparedStatement.execute();
            this.closeSQLNoQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

}
