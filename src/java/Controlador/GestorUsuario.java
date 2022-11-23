package Controlador;

import Modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GestorUsuario extends Gestor {

    private ResultSet resultSet;
    private PreparedStatement preparedStatement;

    public GestorUsuario() {
        preparedStatement = null;
        resultSet = null;
    }

    public boolean existe(Usuario usuario) {
        try {
            preparedStatement = this.openSQLNoQuery("select * from usuario where correoElectronico = ? AND contrasena = ?");
            preparedStatement.setString(1, usuario.getUsuario());
            preparedStatement.setString(2, usuario.getContraseña());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
            this.closeSQLNoQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }

    @Override
    ArrayList listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void insert(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void update(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void delete(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
