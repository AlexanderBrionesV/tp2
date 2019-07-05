/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author USER
 */
public class itenSucursal {
 private static Connection cn = null;
    private static PreparedStatement ps = null;
    private static Statement st = null;
    private static CallableStatement cs = null;
    private static ResultSet rs = null;
    
    public static String colsultarbaseItenSucursales() {
        String sql, mensaje = null;
        try {
            cn = Conexion.establecerConexion();
            sql = "{call sp_insertarSucursal(?,?,?,?,?)}";
            cs = cn.prepareCall(sql);
            cs.setString(1, sucursal.getCodigo());
            cs.setString(2, sucursal.getNombre());
            cs.setString(3, sucursal.getCiudad());
            cs.setString(4, sucursal.getDireccion());
            cs.setInt(5, sucursal.getContcuenta());
            cs.executeUpdate();
        } catch(ClassNotFoundException | SQLException ex) {
            mensaje = ex.getMessage();
        } finally {
            try {
                cs.close();
                cn.close();
            } catch(SQLException ex) {
                mensaje = ex.getMessage();
            }            
        }
        return mensaje;
    }   
}
