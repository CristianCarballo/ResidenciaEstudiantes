package Controlador;

import Modelo.Alquiler;
import Modelo.DetalleAlquiler;
import Modelo.Inquilino;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class GestorDetalleAlquiler extends Gestor {

    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private DetalleAlquiler detalleAlquiler;
    private Alquiler alquiler;
    private Inquilino inquilino;
    private final GestorAlquiler gestorAlquiler;
    private final GestorInquilino gestorInquilino;

    public GestorDetalleAlquiler() {
        preparedStatement = null;
        resultSet = null;
        detalleAlquiler = null;
        alquiler = null;
        inquilino = null;
        gestorAlquiler = new GestorAlquiler();
        gestorInquilino = new GestorInquilino();
    }

    @Override
    public ArrayList listar() {
        ArrayList<DetalleAlquiler> lista = new ArrayList<>();
        try {
            resultSet = this.openSQLQuery("select * from detalleAlquiler");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int idAlquiler = resultSet.getInt(2);
                alquiler = gestorAlquiler.getAlquilerById(idAlquiler);
                int idInquilino = resultSet.getInt(3);
                inquilino = gestorInquilino.getInquilinoById(idInquilino);
                Date fechaIngreso = resultSet.getDate(4);
                Date fechaSalida = resultSet.getDate(5);
                detalleAlquiler = new DetalleAlquiler(id, alquiler, inquilino, fechaIngreso, fechaSalida);
                lista.add(detalleAlquiler);
            }
            this.closeSQLQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return lista;
    }

    public ArrayList listaSinPago() {
        ArrayList<DetalleAlquiler> lista = new ArrayList<>();
        try {
            resultSet = this.openSQLQuery("select * from vw_alquileresSinPago");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int idAlquiler = resultSet.getInt(2);
                alquiler = gestorAlquiler.getAlquilerById(idAlquiler);
                int idInquilino = resultSet.getInt(3);
                inquilino = gestorInquilino.getInquilinoById(idInquilino);
                Date fechaIngreso = resultSet.getDate(4);
                Date fechaSalida = resultSet.getDate(5);
                detalleAlquiler = new DetalleAlquiler(id, alquiler, inquilino, fechaIngreso, fechaSalida);
                lista.add(detalleAlquiler);
            }
            this.closeSQLQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return lista;
    }
    
    public DetalleAlquiler getDetalleAlquilerByIdAlquiler(int idAlq) {
        try {
            resultSet = this.openSQLQuery("select * from DetalleAlquiler where idAlquiler = " + idAlq);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int idAlquiler = resultSet.getInt(2);
                alquiler = gestorAlquiler.getAlquilerById(idAlquiler);
                int idInquilino = resultSet.getInt(3);
                inquilino = gestorInquilino.getInquilinoById(idInquilino);
                Date fechaIngreso = resultSet.getDate(4);
                Date fechaSalida = resultSet.getDate(5);
                detalleAlquiler = new DetalleAlquiler(id, alquiler, inquilino, fechaIngreso, fechaSalida);
            }
            this.closeSQLQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return detalleAlquiler;
    }

    @Override
    public void insert(Object objeto) {
        try {
            detalleAlquiler = (DetalleAlquiler) objeto;
            preparedStatement = this.openSQLNoQuery("insert into detalleAlquiler values (?,?,?,?)");
            preparedStatement.setInt(1, detalleAlquiler.getAlquiler().getId());
            preparedStatement.setInt(2, detalleAlquiler.getInquilino().getId());
            preparedStatement.setDate(3, (java.sql.Date) detalleAlquiler.getFechaIngreso());
            preparedStatement.setDate(4, (java.sql.Date) detalleAlquiler.getFechaSalida());
            preparedStatement.execute();
            this.closeSQLNoQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void update(Object objeto) {
        try {
            detalleAlquiler = (DetalleAlquiler) objeto;
            preparedStatement = this.openSQLNoQuery("update detalleAlquiler set idAlquiler = ?, idInquilino = ?, fechaIngreso = ?, fechaSalida = ? where idDetalleAlquiler = ?");
            preparedStatement.setInt(1, detalleAlquiler.getAlquiler().getId());
            preparedStatement.setInt(2, detalleAlquiler.getInquilino().getId());
            preparedStatement.setDate(3, (java.sql.Date) detalleAlquiler.getFechaIngreso());
            preparedStatement.setDate(4, (java.sql.Date) detalleAlquiler.getFechaSalida());
            preparedStatement.setInt(5, detalleAlquiler.getId());
            preparedStatement.execute();
            this.closeSQLNoQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void delete(Object objeto) {
        try {
            detalleAlquiler = (DetalleAlquiler) objeto;
            preparedStatement = this.openSQLNoQuery("delete detalleAlquiler where idDetalleAlquiler = ?");
            preparedStatement.setInt(1, detalleAlquiler.getId());
            preparedStatement.execute();
            this.closeSQLNoQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

}
