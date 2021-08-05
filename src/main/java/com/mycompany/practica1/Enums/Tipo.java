/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica1.Enums;

/**
 *
 * @author manu
 */
public enum Tipo {
    IDENTIFICADOR( " es un Identificador"),
    NUM_ENTERO(" es un Numero Entero"), 
    NUM_DECIMAL(" es un Numero decimal"), 
    SIMBOLO(" es un Simbolo"), 
    ERROR(" es un Error, no coincide con ningun identificador");
    
    private String descripcion;
    
    private Tipo(String descripcion){
        this.descripcion = descripcion;
    }
    
    public String getDescripcion(){
        return this.descripcion;
    }
    
    
}
