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
    
    private final String[] letras = new String[]{"a","b","c","d","e","f","g","h","i","j",
                                            "k","l","m","n","ñ","o","p","q","r","s","t",
                                            "u","v","w","x","y","z","A","B","C","D","E",
                                            "F","G","H","I","J","K","L","M","N","Ñ","O",
                                            "P","Q","R","S","T","U","V","W","X","Y","Z"};
    
    private final String[] numeros = new String[]{"0","1","2","3","4","5","6","7","8","9"};
    private final String[] simbolos = new String[]{"(",")","¿","?",";",":","{","}","[","]",
                                                "!","¡","#","%","$","/","=","*","+","-"};
    
    private final String punto = "."; 
    
    private Tipo tipo = Tipo.ERROR;
    private JTextArea areaT;
    private String[] letrasTexto;
    
    public LecturaDatos(JTextField palabras, JTextArea texto){
        this.letrasTexto = this.SeparacionLetras(palabras.getText());
        this.areaT = texto;
        
        this.Lectura(letrasTexto);
        
        
    }
    
    private String[] SeparacionLetras(String palabra){
        int tamaño = palabra.length();
        String[] cadenaTexto = new String[tamaño];
                
        char[] letra = palabra.toCharArray();
        for(int i = 0; i<tamaño; i++){
            cadenaTexto[i]=Character.toString(letra[i]);
        }
        return cadenaTexto;
        
    }
    
    private void Lectura(String[] letrasTexto){
        boolean letter = false; 
        boolean number= false; 
        boolean point = false; 
        boolean numberAfterPoint = false;
        boolean signal= false; 
        boolean error = false; 
        int first = 0;
       
        int auxStart = 0;
        int auxEnd = 0;
        int auxLarge = letrasTexto.length;
       
        for(int i = 0; i<auxLarge; i++){
            for(String x:this.letras){
                if(letrasTexto[i].equals(x)){
                    
                    if(first==0){
                       first = 1;
                    }
                    letter = true;
                }
            }
            for(String x:this.numeros){
                if(letrasTexto[i].equals(x)){
                    if(point == true && number == true){
                        numberAfterPoint = true;
                    }else{ 
                        if(first==0){
                            first = 2;                     
                        }
                        number = true;
                    }
                }
            }
             
            for(String x:this.simbolos){
                if(letrasTexto[i].equals(x)){
                    
                    if(first==0){
                       first = 3;
                    }
                    signal = true;
                }
            }
            if(letrasTexto[i].equals(this.punto)&& point==false){
                point = true;
                if(first == 0 ){
                    first = 4;
                }
            }
            
            else if(letrasTexto[i].equals(" ")){
                auxEnd = i;
                this.Token(letter, number, point, numberAfterPoint, signal, first);
                this.Show(auxStart, auxEnd);
                letter = false; 
                number= false; 
                point = false; 
                numberAfterPoint = false;
                signal= false; 
                error = false; 
                first = 0;
                this.tipo = Tipo.ERROR;
                auxStart = auxEnd++;
                
            }
        auxEnd = i;
            
        }
        System.out.println(first);
        Token(letter, number, point, numberAfterPoint, signal, first);
        this.Show(auxStart, auxEnd);
                
        auxStart = 0;
        auxEnd = 0;
       
       
        
    }
    
    private void Token(boolean l,boolean n,boolean p,boolean np,boolean s, int first){
        
        if(first==1&& l && n && !p && !np && !s){
            this.tipo = Tipo.IDENTIFICADOR;
        }else if(first==2){
            if(!l&& n && !p && !np && !s){
                this.tipo = Tipo.NUM_ENTERO;
            }else if(!l&& n && p && np && !s){
                this.tipo = Tipo.NUM_DECIMAL;
            }
        }else if(first == 3 && !l&& !n && !p && !np && s){
            this.tipo = Tipo.SIMBOLO;
        }else{
            this.tipo = Tipo.ERROR;
        }
    }
    
    
    //Proceso para mostrar las letras en el area de texto de abajo en la ventana
    
    private void Show (int inicio, int fin){
        int start = inicio;
        int end = fin;        
        for(int i = start; i<=end; i++){
            areaT.append(this.letrasTexto[i]);
        }      
        areaT.append(this.tipo.getDescripcion()+"\n");
    }
    
    private void Reset(boolean l,boolean n,boolean p,boolean np,boolean s, int first){
        
        first = 0;
        l = false;
        n = false;
        p = false;
        np = false;
        s = false;
        this.tipo = Tipo.ERROR;
    }
    
    
}
