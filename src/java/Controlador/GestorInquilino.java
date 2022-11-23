package Controlador;

import Modelo.Inquilino;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GestorInquilino extends Gestor {

    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private Inquilino inquilino;

    public GestorInquilino() {
        resultSet = null;
        preparedStatement = null;
        inquilino = null;
    }

    @Override
    public ArrayList listar() {
        ArrayList<Inquilino> lista = new ArrayList<>();
        try {
            resultSet = this.openSQLQuery("select * from inquilino");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String nombre = resultSet.getString(2);
                String apellido = resultSet.getString(3);
                String dni = resultSet.getString(4);
                String direccion = resultSet.getString(5);
                String telefono = resultSet.getString(6);
                inquilino = new Inquilino(id, nombre, apellido, dni, direccion, telefono);
                lista.add(inquilino);
            }
            this.closeSQLQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return lista;
    }

    public ArrayList listarNoAlojados() {
        ArrayList<Inquilino> lista = new ArrayList<>();
        try {
            resultSet = this.openSQLQuery("select * from vw_inquilinosNoAlojados order by apellido");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String nombre = resultSet.getString(2);
                String apellido = resultSet.getString(3);
                String dni = resultSet.getString(4);
                String direccion = resultSet.getString(5);
                String telefono = resultSet.getString(6);
                inquilino = new Inquilino(id, nombre, apellido, dni, direccion, telefono);
                lista.add(inquilino);
            }
            this.closeSQLQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return lista;
    }

    public Inquilino getInquilinoById(int idInquilino) {
        try {
            resultSet = this.openSQLQuery("select * from inquilino where idInquilino = " + idInquilino);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String nombre = resultSet.getString(2);
                String apellido = resultSet.getString(3);
                String dni = resultSet.getString(4);
                String direccion = resultSet.getString(5);
                String telefono = resultSet.getString(6);
                inquilino = new Inquilino(id, nombre, apellido, dni, direccion, telefono);
            }
            this.closeSQLQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return inquilino;
    }

    @Override
    public void insert(Object objeto) {
        try {
            inquilino = (Inquilino) objeto;
            preparedStatement = this.openSQLNoQuery("insert into inquilino values (?,?,?,?,?)");
            preparedStatement.setString(1, inquilino.getNombre());
            preparedStatement.setString(2, inquilino.getApellido());
            preparedStatement.setString(3, inquilino.getDni());
            preparedStatement.setString(4, inquilino.getDireccion());
            preparedStatement.setString(5, inquilino.getTelefono());
            preparedStatement.execute();
            this.closeSQLNoQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void update(Object objeto) {
        try {
            inquilino = (Inquilino) objeto;
            preparedStatement = this.openSQLNoQuery("update inquilino set nombre = ?, apellido = ?, dni = ?, domicilio = ?, telefono = ? where idInquilino = ?");
            preparedStatement.setString(1, inquilino.getNombre());
            preparedStatement.setString(2, inquilino.getApellido());
            preparedStatement.setString(3, inquilino.getDni());
            preparedStatement.setString(4, inquilino.getDireccion());
            preparedStatement.setString(5, inquilino.getTelefono());
            preparedStatement.setInt(6, inquilino.getId());
            preparedStatement.execute();
            this.closeSQLNoQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void delete(Object objeto) {
        try {
            inquilino = (Inquilino) objeto;
            preparedStatement = this.openSQLNoQuery("delete inquilino where idInquilino = ?");
            preparedStatement.setInt(1, inquilino.getId());
            preparedStatement.execute();
            this.closeSQLNoQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

}
