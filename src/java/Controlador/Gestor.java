package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public abstract class Gestor {

    private static final String connStr = "jdbc:sqlserver://CRISTIAN\\EQUIPO:1433;databaseName=UTNMotel";
    private static final String user = "sa";
    private static final String pass = "sa";
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    private void abrirConexion() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(connStr, user, pass);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    private void cerrarConexion() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    protected ResultSet openSQLQuery(String sql) {
        try {
            abrirConexion();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return resultSet;
    }

    @SuppressWarnings("empty-statement")
    protected void closeSQLQuery() {
        try {
            resultSet.close();;
            statement.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    protected PreparedStatement openSQLNoQuery(String sql) {
        try {
            abrirConexion();
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return preparedStatement;
    }

    protected void closeSQLNoQuery() {
        try {
            preparedStatement.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    abstract ArrayList listar();
    
    abstract void insert(Object objeto);

    abstract void update(Object objeto);

    abstract void delete(Object objeto);
}
