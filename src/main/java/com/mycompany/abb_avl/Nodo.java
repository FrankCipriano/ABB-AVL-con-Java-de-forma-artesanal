/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.abb_avl;

/**
 *
 * @author frankdev
 */
public class Nodo {
    int edad,FE;
    Nodo hijoIzquierdo,hijoDerecho;
    public Nodo(int edad){
        this.edad=edad;
        this.FE=0;
        this.hijoIzquierdo=null;
        this.hijoDerecho=null;
    }
}
