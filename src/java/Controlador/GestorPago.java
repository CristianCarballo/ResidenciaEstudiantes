package Controlador;

import Modelo.Alquiler;
import Modelo.Pago;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class GestorPago extends Gestor {

    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private Pago pago;

    public GestorPago() {
        preparedStatement = null;
        pago = null;
        resultSet = null;
    }

    @Override
    public ArrayList listar() {
        ArrayList<Pago> lista = new ArrayList<>();
        try {
            resultSet = this.openSQLQuery("select * from pago");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                Date fecha = resultSet.getDate(3);
                pago = new Pago(id, fecha);
                lista.add(pago);
            }
            this.closeSQLQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return lista;
    }

    public float getRecaudacionPorHabitacion(int idHabitacion) {
        float total = 0;
        try {
            resultSet = this.openSQLQuery("select dbo.fn_habitacion_recaudacion(" + idHabitacion + ")");
            while (resultSet.next()) {
                total = resultSet.getFloat(1);
            }
            this.closeSQLQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return total;
    }

    public float getRecaudacionPorInquilino(int idInquilino) {
        float total = 0;
        try {
            resultSet = this.openSQLQuery("select * from vw_inquilinos_total_pagado where idInquilino = " + idInquilino);
            while (resultSet.next()) {
                total = resultSet.getFloat("total pagado");
            }
            this.closeSQLQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return total;
    }

    public Pago getPagoByIdAlquiler(int idAlquiler) {
        try {
            resultSet = this.openSQLQuery("select * from pago where idAlquiler = " + idAlquiler);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                Date fecha = resultSet.getDate(3);
                pago = new Pago(id, fecha);
            }
            this.closeSQLQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return pago;
    }

    public void insert(Object objeto, Alquiler alquiler) {
        try {
            pago = (Pago) objeto;
            preparedStatement = this.openSQLNoQuery("insert into pago values (?,?)");
            preparedStatement.setInt(1, alquiler.getId());
            java.util.Date fechaPagoUtil = pago.getFecha();
            java.sql.Date fechaPagoSql = new java.sql.Date(fechaPagoUtil.getTime());
            preparedStatement.setDate(2, fechaPagoSql);
            preparedStatement.executeUpdate();
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

    @Override
    void delete(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
