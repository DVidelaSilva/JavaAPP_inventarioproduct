/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoinventarioproduct.dao;

import com.mycompany.proyectoinventarioproduct.models.Lista;
import com.mysql.cj.util.StringUtils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diegovidelasilva
 */

//DAO - DATA ACCESS OBJECT ARCHIVO PARA CONFIGURACION DE CONEXION A BASE DE DATOS
// Este objeto recivira datos de la clase Lista (los datos del  formulario) y los 
//guardara en la base de datos

public class inventarioDao {
    
    
/////-------------------FUNCION CONECTAR-------------------/////
    
     public Connection conectar() {
    
        String baseDeDatos ="inventario";
        String usuario = "root";
        String password = "diegovidelasilva";
        String host = "127.0.0.1";
        String puerto = "3306";
        String driver = "com.mysql.cj.jdbc.Driver";
        String conexionUrl = "jdbc:mysql://" + host + ":" + puerto + "/" + baseDeDatos  + "?useSSL=false&allowPublicKeyRetrieval=true";
        
        Connection conexion = null;
               
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(conexionUrl, usuario, password);

           
        } catch (Exception ex) {
            Logger.getLogger(inventarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }       
       
        return conexion;
    }    
    

    
/////-------------------FUNCION AGREGAR-------------------/////
    
     public void agregar(Lista elemento) {
                  
        try {
            Connection conexion = conectar();
            
            String sql = "INSERT INTO invproductos (codigo, producto, marca, descripcion, ubicacion, cantidad) VALUES ('"+ elemento.getCodigo() +
                    "', '"+ elemento.getProducto() +"', '"+ elemento.getMarca() +"', '"+ elemento.getDescripcion() +"', '"+ elemento.getUbicacion() +"', '"+ elemento.getCantidad() +"');";
            Statement statement = conexion.createStatement();
            statement.execute(sql);
           
        } catch (Exception ex) {
            Logger.getLogger(inventarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }       
       
    }
     

/////-------------------FUNCION LISTAR-------------------/////
     
     public List<Lista> listar() {

        List<Lista> listado = new ArrayList<>();
               
        try {
            Connection conexion = conectar();
            String sql = "SELECT * FROM invproductos";
            
            
            Statement statement = conexion.createStatement();
            ResultSet resultado = statement.executeQuery(sql);
            
            while(resultado.next()) {
                Lista elemento = new Lista();
                elemento.setId(resultado.getString("id"));
                elemento.setCodigo(resultado.getString("codigo"));
                elemento.setProducto(resultado.getString("producto"));
                elemento.setMarca(resultado.getString("marca"));
                elemento.setDescripcion(resultado.getString("descripcion"));
                elemento.setUbicacion(resultado.getString("ubicacion"));
                elemento.setCantidad(resultado.getString("cantidad"));
                listado.add(elemento);
            }
           
        } catch (Exception ex) {
            Logger.getLogger(inventarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }       
       return listado;
    }
     
     
/////-------------------FUNCION ELIMINAR-------------------/////
    
     public void eliminar(String id) {
                  
        try {
            Connection conexion = conectar();
            
            String sql = "DELETE FROM invproductos WHERE id = " + id;
            
            Statement statement = conexion.createStatement();
            statement.execute(sql);
           
        } catch (Exception ex) {
            Logger.getLogger(inventarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }       
       
    }
     
/////-------------------FUNCION ACTUALIZAR-------------------/////
    
     public void actualizar(Lista elemento) {
                  
        try {
            Connection conexion = conectar();
            
            String sql = "UPDATE invproductos SET codigo = '"+ elemento.getCodigo() +"', producto = '"+ elemento.getProducto()+ "', marca = '"+ elemento.getMarca()+
                         "', descripcion = '"+ elemento.getDescripcion() +"', ubicacion = '"+ elemento.getUbicacion() +"', cantidad = '"+ elemento.getCantidad() +
                         "' WHERE id = "+ elemento.getId() +";";
            
            
            
            Statement statement = conexion.createStatement();
            statement.execute(sql);
           
        } catch (Exception ex) {
            Logger.getLogger(inventarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }       
       
    }

    public void guardar(Lista elemento) {
        
        if (StringUtils.isEmptyOrWhitespaceOnly(elemento.getId())) {
            agregar(elemento);
        } else {
            actualizar(elemento);
        }
        
    }
     

}