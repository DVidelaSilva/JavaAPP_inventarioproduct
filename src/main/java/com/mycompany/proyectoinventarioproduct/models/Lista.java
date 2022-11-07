/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoinventarioproduct.models;

/**
 *
 * @author diegovidelasilva
 */
public class Lista {
    
    /*Por un principiio de buenas practicas las variables deben ser privadas siempre 
    para poder modificarlas de utilizan funciones get / set (publicas
    */
    
    private String id;
    private String codigo;
    private String producto;
    private String marca;
    private String descripcion;
    private String ubicacion;
    private String cantidad;
    
 //// FUNCIONES PARA DEVOLVER EL VALOR - GET
    
    public String getId() {
        return id;
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    public String getProducto() {
        return producto;
    }
    
    public String getMarca() {
        return marca;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public String getUbicacion() {
        return ubicacion;
    }
    
    public String getCantidad() {
        return cantidad;
    }
    
    public String getItemCompleto() {
        return codigo + "    " + producto + "    " + marca + "    " + descripcion + "    " + ubicacion + "    " + cantidad;
    }
    
    
 //// FUNCIONES PARA MODIFICAR EL VALOR - SET
    
    public void setId(String id) {
        this.id = id;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public void setProducto(String producto) {
        this.producto = producto;
    }
        
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
        
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
}
