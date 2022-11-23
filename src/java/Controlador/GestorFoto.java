package Controlador;

import Modelo.Foto;
import Modelo.Habitacion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GestorFoto extends Gestor {

    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private Foto foto;

    public GestorFoto() {
        resultSet = null;
        preparedStatement = null;
        foto = null;
    }

    public ArrayList getFotosById(int idHabitacion) {
        ArrayList<Foto> lista = new ArrayList<>();
        try {
            resultSet = this.openSQLQuery("select * from foto where idHabitacion = " + idHabitacion);
            while (resultSet.next()) {
                int idFoto = resultSet.getInt(1);
                String descripcion = resultSet.getString(3);
                foto = new Foto(idFoto, descripcion);
                lista.add(foto);
            }
            this.closeSQLQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return lista;
    }

    @Override
    public ArrayList listar() {
        ArrayList<Foto> lista = new ArrayList<>();
        try {
            resultSet = this.openSQLQuery("select * from foto");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String descripcion = resultSet.getString(3);
                foto = new Foto(id, descripcion);
                lista.add(foto);
            }
            this.closeSQLQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return lista;
    }

    public void insertFotosHabitacion(int idHabitacion, ArrayList<Foto> fotos) {
        try {
            preparedStatement = this.openSQLNoQuery("insert into foto values (?,?)");
            for (Foto f : fotos) {
                if (f != null) {
                    preparedStatement.setInt(1, idHabitacion);
                    preparedStatement.setString(2, f.getDescripcion());
                    preparedStatement.execute();
                }
            }
            this.closeSQLNoQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void update(Object objeto, Habitacion habitacion) {
        try {
            foto = (Foto) objeto;
            preparedStatement = this.openSQLNoQuery("update foto set idHabitacion = ?, descripcion = ? where idFoto = ?");
            preparedStatement.setInt(1, habitacion.getId());
            preparedStatement.setString(2, foto.getDescripcion());
            preparedStatement.setInt(3, foto.getId());
            preparedStatement.execute();
            this.closeSQLNoQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void delete(Object objeto) {
        try {
            foto = (Foto) objeto;
            preparedStatement = this.openSQLNoQuery("delete foto where idFoto = ?");
            preparedStatement.setInt(1, foto.getId());
            preparedStatement.execute();
            this.closeSQLNoQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    void insert(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void update(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
