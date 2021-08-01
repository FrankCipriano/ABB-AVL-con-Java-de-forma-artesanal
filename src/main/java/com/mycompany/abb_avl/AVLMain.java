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
public class AVLMain {
    public static void main(String args[]){
        ArbolAVL arbol=new ArbolAVL();
        arbol.insertar(10);
        arbol.insertar(5);
        arbol.insertar(13);
        arbol.insertar(1);
        arbol.insertar(6);
        arbol.insertar(17);
        arbol.insertar(16);
        arbol.preOrden(arbol.getRaiz());
        System.out.println("");
        arbol.postOrden(arbol.getRaiz());
        System.out.println("");
        arbol.inOrden(arbol.getRaiz());
        System.out.println(arbol.buscar(6, arbol.getRaiz()));
        //algoritmo para eliminar un nodo 
        //http://163.10.22.82/OAS/AVL_Eliminacion/definicin.html
    }
}
