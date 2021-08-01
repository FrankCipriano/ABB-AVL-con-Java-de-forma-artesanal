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
public class ArbolAVL {
    private Nodo raiz;
    public ArbolAVL() {
        this.raiz = null;
    }
    //METODO GETTER
    public Nodo getRaiz(){
        return raiz;
    }
    //METODO PARA BUSCAR UN NODO EN EL ARBOL
    public Nodo buscar(int edad,Nodo raiz){
        if(raiz==null){
            return null;
        }else if(raiz.edad==edad){
            return raiz;
        }else if(raiz.edad<edad){
            return buscar(edad,raiz.hijoDerecho);
        }else{
            return buscar(edad,raiz.hijoIzquierdo);
        }
    }
    //METODO PARA OBTENER EL FACTOR EQUILIBRIO
    public int factorEquilibrio(Nodo n){
        if(n==null){
            return -1;
        }else{
            return n.FE;
        }
    }
    //ROTACION SIMPLE IZQUIERDA
    public Nodo rotacionIzquierda(Nodo n){
        Nodo auxiliar=n.hijoIzquierdo;
        n.hijoIzquierdo=auxiliar.hijoDerecho;
        auxiliar.hijoDerecho=n;
        n.FE=Math.max(factorEquilibrio(n.hijoIzquierdo),factorEquilibrio(n.hijoDerecho))+1;
        auxiliar.FE=Math.max(factorEquilibrio(auxiliar.hijoIzquierdo),factorEquilibrio(auxiliar.hijoDerecho))+1;
        return auxiliar;
    }
    //ROTACION SIMPLE DERECHA
    public Nodo rotacionDerecha(Nodo n){
        Nodo auxiliar=n.hijoDerecho;
        n.hijoDerecho=auxiliar.hijoIzquierdo;
        auxiliar.hijoIzquierdo=n;
        n.FE=Math.max(factorEquilibrio(n.hijoIzquierdo),factorEquilibrio(n.hijoDerecho))+1;
        auxiliar.FE=Math.max(factorEquilibrio(auxiliar.hijoIzquierdo),factorEquilibrio(auxiliar.hijoDerecho))+1;
        return auxiliar;
    }
    //ROTACION DOBLE A LA DERECHA
    public Nodo rotacionDobleIzquierda(Nodo n){
        Nodo auxiliar;
        n.hijoIzquierdo=rotacionDerecha(n.hijoIzquierdo);
        auxiliar=rotacionIzquierda(n);
        return auxiliar;
    }
    //ROTACION DOBLE A LA IZQUIERDA
    public Nodo rotacionDobleDerecha(Nodo n){
        Nodo auxiliar;
        n.hijoDerecho=rotacionIzquierda(n.hijoDerecho);
        auxiliar=rotacionDerecha(n);
        return auxiliar;
    }
    //METODO PARA INSERTAR UN NODO EN EL ARBOL AVL
    public Nodo insertarAVL(Nodo nuevo,Nodo sub_arbol){
        Nodo nuevo_padre=sub_arbol;
        if(nuevo.edad<sub_arbol.edad){
            if(sub_arbol.hijoIzquierdo==null){
                sub_arbol.hijoIzquierdo=nuevo;
            }else{
                sub_arbol.hijoIzquierdo=insertarAVL(nuevo,sub_arbol.hijoIzquierdo);
                if((factorEquilibrio(sub_arbol.hijoIzquierdo)-factorEquilibrio(sub_arbol.hijoDerecho))==2){
                    if(nuevo.edad<sub_arbol.hijoIzquierdo.edad){
                        nuevo_padre=rotacionIzquierda(sub_arbol);
                    }else{
                        nuevo_padre=rotacionDobleIzquierda(sub_arbol);
                    }
                }
            }
        }else if(nuevo.edad>sub_arbol.edad){
            if(sub_arbol.hijoDerecho==null){
                sub_arbol.hijoDerecho=nuevo;
            }else{
                sub_arbol.hijoDerecho=insertarAVL(nuevo,sub_arbol.hijoDerecho);
                if((factorEquilibrio(sub_arbol.hijoDerecho)-factorEquilibrio(sub_arbol.hijoIzquierdo))==2){
                    if(nuevo.edad>sub_arbol.hijoDerecho.edad){
                        nuevo_padre=rotacionDerecha(sub_arbol);
                    }else{
                        nuevo_padre=rotacionDobleDerecha(sub_arbol);
                    }
                }
            }
        }else{
            System.out.println("Nodo Duplicado");
        }
        //-ACTUALIZAR LA ALTURA O EL FACTOR EQUILIBRIO
        if((sub_arbol.hijoIzquierdo==null)&&(sub_arbol.hijoDerecho!=null)){
            sub_arbol.FE=sub_arbol.hijoDerecho.FE+1;
        }else if((sub_arbol.hijoDerecho==null)&&(sub_arbol.hijoIzquierdo!=null)){
            sub_arbol.FE=sub_arbol.hijoIzquierdo.FE+1;
        }else{
            sub_arbol.FE=Math.max(factorEquilibrio(sub_arbol.hijoIzquierdo), factorEquilibrio(sub_arbol.hijoDerecho))+1;
        }
        return nuevo_padre;
    }
    //METODO PARA INSERTAR
    public void insertar(int edad){
        Nodo nuevo=new Nodo(edad);
        if(raiz==null){
            raiz=nuevo;
        }else{
            raiz=insertarAVL(nuevo,raiz);
        }
    }
    //METODOS PARA RECORRER EL ARBOL
    //-inOrden
    public void inOrden(Nodo raiz){
        if(raiz!=null){
            inOrden(raiz.hijoIzquierdo);
            System.out.print(raiz.edad+", ");
            inOrden(raiz.hijoDerecho);
        }
    }
    //-preOrden
    public void preOrden(Nodo raiz){
        if(raiz!=null){
            System.out.print(raiz.edad+", ");
            preOrden(raiz.hijoIzquierdo);
            preOrden(raiz.hijoDerecho);
        }
    }
    //-postOrden
    public void postOrden(Nodo raiz){
        if(raiz!=null){
            postOrden(raiz.hijoIzquierdo);
            postOrden(raiz.hijoDerecho);
            System.out.print(raiz.edad+", ");
        }
    }
}
