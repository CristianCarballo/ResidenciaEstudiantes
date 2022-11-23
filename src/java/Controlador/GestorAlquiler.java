package Controlador;

import Modelo.Alquiler;
import Modelo.DetalleAlquiler;
import Modelo.Habitacion;
import Modelo.Pago;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class GestorAlquiler extends Gestor {

    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private Alquiler alquiler;
    private Habitacion habitacion;
    private final GestorHabitacion gestorHabitacion;
    private final GestorPago gestorPago;
    private Pago pago;

    public GestorAlquiler() {
        preparedStatement = null;
        resultSet = null;
        alquiler = null;
        habitacion = null;
        gestorHabitacion = new GestorHabitacion();
        gestorPago = new GestorPago();
        pago = null;
    }

    public int cantidadDias(Date fechaInicio, Date fechaSalida) {
        long startTime = fechaInicio.getTime();
        long endTime = fechaSalida.getTime();
        long diffTime = endTime - startTime;
        long diffDays = diffTime / (1000 * 60 * 60 * 24);
        return (int) diffDays;
    }

    @Override
    public ArrayList listar() {
        ArrayList<Alquiler> lista = new ArrayList<>();
        try {
            resultSet = this.openSQLQuery("select * from alquiler");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int idHabitacion = resultSet.getInt(2);
                habitacion = gestorHabitacion.getHabitacionById(idHabitacion);
                Date fecha = resultSet.getDate(3);
                float precio = resultSet.getFloat(4);
                if (pago != null) {
                    pago = gestorPago.getPagoByIdAlquiler(id);
                } else {
                    pago = null;
                }
                alquiler = new Alquiler(id, habitacion, fecha, precio, pago);
                lista.add(alquiler);
            }
            this.closeSQLQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return lista;
    }

    public Alquiler getAlquilerById(int idAlquiler) {
        try {
            resultSet = this.openSQLQuery("select * from alquiler a full join Pago p on p.idAlquiler = a.idAlquiler where a.idAlquiler = " + idAlquiler);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int idHabitacion = resultSet.getInt(2);
                habitacion = gestorHabitacion.getHabitacionById(idHabitacion);
                Date fecha = resultSet.getDate(3);
                float precio = resultSet.getFloat(4);
                int idPago = resultSet.getInt(5);
                pago = gestorPago.getPagoByIdAlquiler(idPago);
                alquiler = new Alquiler(id, habitacion, fecha, precio, pago);
            }
            this.closeSQLQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return alquiler;
    }

    public void insert(Alquiler a, DetalleAlquiler da) {
        try {
            preparedStatement = this.openSQLNoQuery("exec sp_realizarAlquiler ?,?,?,?,?");
            preparedStatement.setInt(1, a.getHabitacion().getId());
            preparedStatement.setInt(2, da.getInquilino().getId());
            java.util.Date utilStartDate = da.getFechaIngreso();
            java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());
            preparedStatement.setDate(3, sqlStartDate);
            java.util.Date utilEndDate = da.getFechaSalida();
            java.sql.Date sqlEndDate = new java.sql.Date(utilEndDate.getTime());
            preparedStatement.setDate(4, sqlEndDate);
            preparedStatement.setFloat(5, a.getPrecio());
            preparedStatement.executeUpdate();
            this.closeSQLNoQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void update(Object objeto) {
        try {
            alquiler = (Alquiler) objeto;
            preparedStatement = this.openSQLNoQuery("update alquiler set idHabitacion = ?, fecha = ?, precio = ? where idAlquiler = ?");
            preparedStatement.setInt(1, alquiler.getHabitacion().getId());
            preparedStatement.setDate(2, (java.sql.Date) alquiler.getFecha());
            preparedStatement.setFloat(3, alquiler.getPrecio());
            preparedStatement.setInt(4, alquiler.getId());
            preparedStatement.execute();
            this.closeSQLNoQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void delete(Object objeto) {
        try {
            alquiler = (Alquiler) objeto;
            preparedStatement = this.openSQLNoQuery("delete alquiler where idAlquiler = ?");
            preparedStatement.setInt(1, alquiler.getId());
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

}
