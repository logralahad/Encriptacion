/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listacircular;

import java.io.*;
import java.util.Properties;
import java.util.Scanner;

/**
 *
 * @author logra
 */
public class Principal {
    
    public static final Integer EOF = -1;
    public static final Integer EOL = 10;
    public static final Integer SPACE = 32;

    /**
     * @param args the command line arguments
     */
    
    
    public static ListaCircular obtenerClave(){
        
        Scanner cod = new Scanner(System.in);
        System.out.print("\nDigite la clave (minimo 3 caracteres): ");
        String clave = cod.nextLine();
        
        if(clave.length() < 3) obtenerClave();
        
        ListaCircular lista = new ListaCircular();
        
        for(int i = 0; i < clave.length(); i++){
            int ascii = clave.charAt(i);
            lista.insertar(ascii);
        }
        
        return lista;
    }
    
    public static void BinaryFiles(ListaCircular lista, int modo){        
        try{
            String dir = System.getProperty("user.dir");
            
            Scanner str = new Scanner(System.in);
            System.out.print("Escriba la direccion del archivo: ");
            String direccion = str.nextLine();
            
            System.out.print("Escriba el nombre del archivo: ");
            String nombre = str.nextLine();
            
            
            File origen = new File(direccion, nombre);
            File destino = new File(dir, nombre);
            //C:\Users\logra\Desktop          
            
            FileInputStream input = new FileInputStream(origen);
            DataInputStream reader = new DataInputStream(input);
            
            FileOutputStream output = new FileOutputStream(destino);
            DataOutputStream writer = new DataOutputStream(output);
            
            int byteInfo = 0;
            int i = 0;
            int byteEscritura;
            
            if(modo == 0){
                while( (byteInfo = reader.read()) != EOF){
                    byteEscritura = byteInfo + lista.obtener();
                    writer.writeByte( byteEscritura <= 255 ? byteEscritura : byteEscritura - 255);
                }
                System.out.println("\nArchivo encriptado exitosamente.\nSu archivo esta en " + dir);
            }
            
            else{
                while( (byteInfo = reader.read()) != EOF){
                    byteEscritura = byteInfo - lista.obtener();
                    writer.writeByte( byteEscritura <= 0 ? byteEscritura + 255 : byteEscritura);
                }
                System.out.println("\nArchivo desencriptado exitosamente.\nSu archivo esta en " + dir);
            }
            
            
            reader.close();
            input.close();
            
            writer.close();
            output.close();
        }
        catch(Exception e){
            System.out.println("Hubo un error");
        }
    }
    
  
   
    public static void TxtFiles(ListaCircular lista, int modo){        
        try{
            String dir = System.getProperty("user.dir");
            
            Scanner str = new Scanner(System.in);
            System.out.print("\nEscriba la direccion del archivo: ");
            String direccion = str.nextLine();
            
            System.out.print("Escriba el nombre del archivo: ");
            String nombre = str.nextLine();
            
            
            File origen = new File(direccion, nombre);
            File destino = new File(dir, nombre);
                      
            
            FileReader reader = new FileReader(origen);
            FileWriter writer = new FileWriter(destino);
            
            int byteInfo = 0;
            int i = 0;
            int byteEscritura;
            
            if(modo == 0){
                while( (byteInfo = reader.read()) != EOF){
                    byteEscritura = byteInfo + lista.obtener();
                    writer.write( byteEscritura <= 255 ? byteEscritura : byteEscritura - 255);
                }
                System.out.println("\nArchivo encriptado exitosamente.\nSu archivo esta en " + dir);
            }
            
            else{
                while( (byteInfo = reader.read()) != EOF){
                    byteEscritura = byteInfo - lista.obtener();
                    writer.write( byteEscritura <= 0 ? byteEscritura + 255 : byteEscritura);
                }
                System.out.println("\nArchivo desencriptado exitosamente.\nSu archivo esta en " + dir);
            }
            
            
            reader.close();
            writer.close();
            
        }
        catch(Exception e){
            System.out.println("Hubo un error");
        }
    }
    
    
    public static void main(String[] args) {
             
        System.out.println("   Encryption String Program");
        System.out.println("[0]Binario\t[1]TXT");
        
        Scanner opc = new Scanner(System.in);
        System.out.print("Seleccione el tipo de archivo: ");
        int tipo = opc.nextInt();
        
        
        System.out.println("\n[0]Encriptado\t[1]Desencriptado");
        System.out.print("Seleccione el modo: ");
        int modo = opc.nextInt();
        
        ListaCircular key = obtenerClave();
        
        if(tipo == 0){
            BinaryFiles(key, modo);
        }
        else{
            TxtFiles(key, modo);
        }
    }
    
}
