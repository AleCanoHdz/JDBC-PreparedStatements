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
public class Update {

    String url = "jdbc:mysql://localhost:3306/escuela";
    String user = "root";
    String pass = "140200";
    int id = 0;
    String nombre = "";

    public Update(int id, String nombre) throws SQLException {
        this.id = id;
        this.nombre = nombre;
        try(Connection conexion = DriverManager.getConnection(url, user, pass);PreparedStatement ps = conexion.prepareStatement("UPDATE alumnos set nombre = ? WHERE id_alumno = ?");){
            System.out.println("Conexion con exito");
            ps.setString(1, nombre);
            ps.setInt(2, id);
            
            //Para actualizar solo se usa executeUpdate() sobre el objeto del preparedStatement
            ps.executeUpdate();
            System.out.println("Se actualizaron los datos");
            
            /*
            while(rs.next()){
                int id_alumno = rs.getInt("id_alumno");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                Date fecha_nacimiento = rs.getDate("fecha_nac");
                System.out.println("ID: " + id_alumno + ", Nombre: " + nombre + ", Apellidos: " + apellidos + ", Fecha de nacimiento: " + fecha_nacimiento);
                
            }
            */
        
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws SQLException {
        Update c2 = new Update(1, "Juan");
    }

}
