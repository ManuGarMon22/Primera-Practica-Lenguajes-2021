/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica1.Manejadores;

import com.mycompany.practica1.Enums.Tipo;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author manu
 */
public class LecturaDatos {
    
    private final char[] letras = new char[]{'a','b','c','d','e','f','g','h','i','j',
                            'k','l','m','n','ñ','o','p','q','r','s','t','u','v',
                            'w','x','y','z','A','B','C','D','E','F','G','H','I',
                            'J','K','L','M','N','Ñ','O','P','Q','R','S','T','U',
                            'V','W','X','Y','Z'};
    private final char[] numeros = new char[]{'1','2','3','4','5','6','7','8','9','0'};
    private final char[] simbolos = new char[]{'(',')','=','¿','?','{','}',';','!','¡'};
    
    private final char punto = '.'; 
    
    private Tipo tipo = Tipo.ERROR;
    private JTextArea t;
    private char[] letrasTexto;
    
    public LecturaDatos(JTextField palabras, JTextArea texto){
        this.letrasTexto = this.SeparacionLetras(palabras.getText());
        this.t = texto;
        
        
        
    }
    
    private char[] SeparacionLetras(String palabra){
        
        char[] letra = palabra.toCharArray();
        return letra;
        
    }
    
    private void Token(char[] letras){
       boolean letter, number, point, numberAfterPoint, signal, error = false;
        
       letter = PrimerLetra(letras[0], this.letras);
       number = PrimerLetra(letras[0], this.numeros);
       signal = PrimerLetra(letras[0], this.simbolos);
       
       
       
       
        
    }
    
    
    
    private boolean PrimerLetra(char l, char[] comparacion ){
        boolean x = false;
        
        for(char a: comparacion){
            if(l == a){
                x = true;
                break;
            }
        }
        return x;
    }
    
    private void Show (int inicio, int fin){
        int start = inicio;
        int end = fin;        
        for(int i = start; i<=end; i++){
            System.out.print(this.letrasTexto[i]);
        }
        
        System.out.println(this.tipo.getDescripcion());
    }
    
    
}
