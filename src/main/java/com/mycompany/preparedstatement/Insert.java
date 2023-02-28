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
import java.text.DateFormat;
import java.text.SimpleDateFormat;


/**
 *
 * @author comoc
 */
public class Insert {

    String url = "jdbc:mysql://localhost:3306/escuela";
    String user = "root";
    String pass = "140200";
    int id = 0;
    String nombre = "";
    String apellido = "";
    Date fecha;

    public Insert(int id, String nombre, String apellido) throws SQLException {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha = fecha;
        try(Connection conexion = DriverManager.getConnection(url, user, pass);PreparedStatement ps = conexion.prepareStatement("INSERT INTO profesores VALUES (?,?,?)");){
            System.out.println("Conexion con exito");
            ps.setInt(1, id);
            ps.setString(2, nombre);
            ps.setString(3, apellido);
            
            //Para insertar solo se usa executeUpdate() sobre el objeto del preparedStatement al igual que cuando se actualiza
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
        
        
        Insert c2 = new Insert(6, "Juan","Nieves");
    }

}
