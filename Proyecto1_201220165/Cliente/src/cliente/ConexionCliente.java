/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.net.*;
import java.io.*;

/**
 *
 * @author oscar
 */
public class ConexionCliente {
    String Host = "localhost";
    int Puerto = 9000;
    Socket cliente;
    BufferedReader entradas;
    PrintStream salida;
    Result result;
    Ventana ventana;
    
    public ConexionCliente(Ventana v){
        this.ventana = v;
    }
    
    public void Inicio(String entrada){
        try{
            cliente = new Socket(Host, Puerto);
            salida = new PrintStream(cliente.getOutputStream());
            //salida.println(entrada);
            if(entrada.equals("Termino Proyecto 2")){
                entradas = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                String aux = entrada.replace("\n", "*saltodelinea*");
                //System.out.println("entrada");
                //System.out.println(aux);
                salida.println(aux);
                String msg = entradas.readLine();
                msg = msg.replace("*/saltodelinea/*", "\n");
                //System.out.println(msg);
                if(!msg.contains("errores")){
                    result = new Result();
                    lexico scanner = new lexico(new BufferedReader(new StringReader(msg)));
                    sintactico parser = new sintactico(scanner);
                    parser.LimpiarResult();
                    parser.parse();
                    result = parser.getReultado();
                    //ImprimirResultados(result);
                    ventana.ObtenerResultados(result);
                }else{
                    ventana.ObtenerResultados(null);
                }
                entradas.close();
                salida.close();
                cliente.close();
            }else{
                String aux = entrada.replace("\n", "*saltodelinea*");
                salida.println(aux);
                salida.close();
                cliente.close();
            }
            
        }catch(Exception e){
            
        }
    }
    
    public void ImprimirResultados(Result result){
        //System.out.println("DATOS DEL RESULT");
        //System.out.println("Score:");
        //System.out.println(result.getScore());
        //System.out.println("Variables:");
        for(int i = 0; i < result.getVariables().size(); i++){
            System.out.println("    Clase:" + result.getVariables().get(i).getClase() + " Funcion:" + result.getVariables().get(i).getFuncion() + " Nombre:" + result.getVariables().get(i).getNombre() + " Tipo:" + result.getVariables().get(i).getTipo());
        }
        System.out.println("Metodos:");
        for(int i = 0; i < result.getMetodos().size(); i++){
            System.out.println("    Nombre:" + result.getMetodos().get(i).getNombre() + " Tipo:" + result.getMetodos().get(i).getTipo() + " Numero de parametros:" + result.getMetodos().get(i).getParametros());
        }
        System.out.println("Clases:");
        for(int i = 0; i < result.getClases().size(); i++){
            System.out.println("    Nombre:" + result.getClases().get(i).getNombre());
        }
        System.out.println("Comentarios:");
        for(int i = 0; i < result.getComentarios().size(); i++){
            System.out.println("    Texto:" + result.getComentarios().get(i).getTexto());
        }
    }
}
