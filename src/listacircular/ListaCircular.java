/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listacircular;

/**
 *
 * @author logra
 */
public class ListaCircular {
    
    Nodo inicio = null;
    Nodo pivote = null;
    
    public void insertar(int dato){
        Nodo nuevo = crearNodo(dato);
        if(inicio  == null){
            inicio = nuevo;
            pivote = nuevo;
        }
        else{
            Nodo aux = inicio;
            while(aux.siguiente != inicio){
                aux = aux.siguiente;
            }
            
            aux.siguiente = nuevo;
            nuevo.siguiente = inicio;
        }
        
    }
    
    public void recorrer(){
        
        if(inicio != null){
            
            Nodo aux = inicio;
            do{
                System.out.println(aux.dato);
                aux = aux.siguiente;
                        
            }while(aux != inicio);
        }        
    }
    
    Nodo crearNodo(int dato){
        Nodo nuevo = new Nodo();
        nuevo.dato = dato;
        nuevo.siguiente = nuevo;
        return nuevo;
    }
    
    public int obtener(){
        int resultado = pivote.dato;
        pivote = pivote.siguiente;
        return resultado;
    }
    
}
