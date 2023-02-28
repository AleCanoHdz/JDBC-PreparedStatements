/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.preparedstatement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author comoc
 */
public class Select {

    Connection conexion = null;
    String url = "jdbc:mysql://localhost:3306/escuela";
    String user = "root";
    String pass = "140200";
    int id = 0;

    public Select(int id) throws SQLException {
        this.id = id;
        try{
            conexion = DriverManager.getConnection(url, user, pass);
            System.out.println("Comexion con exito");
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM alumnos where id_alumno = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int id_alumno = rs.getInt("id_alumno");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                Date fecha_nacimiento = rs.getDate("fecha_nac");
                System.out.println("ID: " + id_alumno + ", Nombre: " + nombre + ", Apellidos: " + apellidos + ", Fecha de nacimiento: " + fecha_nacimiento);
                
            }
        
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            conexion.close();
        }
    }
    
    public static void main(String[] args) throws SQLException {
        Select c1 = new Select(2);
    }

}
