/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author oscar
 */
public class Conexion extends Thread{
    
    ServerSocket server;
    Socket socket;
    int puerto = 9000;
    DataOutputStream salida;
    BufferedReader entrada;
    String proyecto1 = "";
    String proyecto2 = "";
    String claseactual = "";
    String proyectoactual = "Proyecto 1";
    String proy = "";
    public static ArrayList<String> errores = new ArrayList();
    Proyecto proyecto1contenido = new Proyecto();
    Proyecto proyecto2contenido = new Proyecto();
    JTextArea textarea = new JTextArea();
    String respuesta = "{Score: ";
    double score = 0;
    String clasesrepetidas = "Clases: [";
    String variablesrepetidas = "Variables: [";
    String metodosrepetidos = "Metodos: [";
    String comentariosrepetidos = "Comentarios: [";
    boolean cosasrepetidas = false;
    JTable tabla = new JTable();
    DefaultTableModel modelo;
    JTextArea label = new JTextArea();
    int numlinea = 1;
    
    public Conexion(String ms){
        super(ms);
    }
    
    public void setTextarea(JTextArea area, JTextArea num){
        this.textarea = area;
        this.label = num;
    }
    
    public void setTabla(JTable tablaerrores){
        this.tabla = tablaerrores;
    }
    
    @Override
    public void run(){
        try{
            server = new ServerSocket(puerto);
            while(true){
                socket = server.accept();
                entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String mensaje = entrada.readLine();
                String aux = mensaje.replace("*saltodelinea*", "\n");
                if(aux.contains("Inicio Proyecto 1")){
                    claseactual = "";
                    proyecto1 = "";
                    proyecto2 = "";
                    proyectoactual = "";
                    proy = "";
                    proyecto1 = aux.split(",")[1];
                    proyectoactual = "Proyecto 1";
                    proy = proyecto1;
                    textarea.append("***** ESTABLECIENDO CONEXION *****\n");
                    label.append(String.valueOf(numlinea));
                    textarea.append("******** RECIBIENDO DATOS ********\n");
                    numlinea++;
                    label.append("\n" + numlinea);
                    textarea.append("****** RECIBIENDO PROYECTO 1 ******\n");
                    numlinea++;
                    label.append("\n" + numlinea);
                    textarea.append("Inicio el analisis del proyecto: " + proy + "\n");
                    numlinea++;
                    label.append("\n" + String.valueOf(numlinea));
                    proyecto1contenido = new Proyecto();
                    proyecto2contenido = new Proyecto();
                    respuesta = "{Score: ";
                    clasesrepetidas = "Clases: [";
                    variablesrepetidas = "Variables: [";
                    metodosrepetidos = "Metodos: [";
                    comentariosrepetidos = "Comentarios: [";
                    cosasrepetidas = false;
                    score = 0;
                    errores.clear();
                    int filas = tabla.getRowCount();
                    modelo = (DefaultTableModel)tabla.getModel();
                    for(int i = 0; i < filas; i++){
                        modelo.removeRow(0);
                    }
                }else if(aux.contains("Inicio clase")){
                    claseactual = aux.split(",")[1];
                    textarea.append("   Inicio el analisis de la clase: " + claseactual + "\n");
                    numlinea++;
                    label.append("\n" + numlinea);
                }else if(aux.contains("Inicio Proyecto 2")){
                    proyecto2 = aux.split(",")[1];
                    proyectoactual = "Proyecto 2";
                    textarea.append("Finalizo el analisis del proyecto: " + proy + "\n");
                    textarea.append("******** FIN DE PROYECTO 1 ********\n");
                    textarea.append("****** RECIBIENDO PROYECTO 2 ******\n");
                    numlinea++;
                    label.append("\n" + numlinea);
                    numlinea++;
                    label.append("\n" + numlinea);
                    numlinea++;
                    label.append("\n" + numlinea);
                    claseactual = "";
                    proy =  proyecto2;
                    textarea.append("Inicio el analisis del proyecto: " + proy + "\n");
                    numlinea++;
                    label.append("\n" + numlinea);
                }else if(aux.contains("Termino Proyecto 2")){
                    textarea.append("Finalizo el analisis del proyecto: " + proy + "\n");
                    numlinea++;
                    label.append("\n" + numlinea);
                    textarea.append("******** FIN DE PROYECTO 2 ********\n");
                    numlinea++;
                    label.append("\n" + numlinea);
                    textarea.append("******** CERRANDO CONEXION ********\n");
                    numlinea++;
                    label.append("\n" + numlinea);
                    //RecorrerComentariosProyectos();
                    
                    if(errores.isEmpty()){
                        ArmarJson();
                        //System.out.println(clasesrepetidas);
                        //System.out.println(variablesrepetidas);
                        //System.out.println(metodosrepetidos);
                        //System.out.println(comentariosrepetidos);
                        //System.out.println(score);
                        BigDecimal auxscore = new BigDecimal(score);
                        auxscore = auxscore.setScale(2, RoundingMode.HALF_UP);
                        //System.out.println(auxscore.doubleValue());
                        respuesta += "[" + auxscore.doubleValue() + "],\n";
                        respuesta += clasesrepetidas + ",\n";
                        respuesta += variablesrepetidas + ",\n";
                        respuesta += metodosrepetidos + ",\n";
                        respuesta += comentariosrepetidos + "\n}";
                        System.out.println(respuesta);
                        salida = new DataOutputStream(socket.getOutputStream());
                        respuesta = respuesta.replace("\n", "*/saltodelinea/*");
                        salida.writeBytes(respuesta);
                        salida.close();
                        socket.close();
                        
                        if(cosasrepetidas){
                            textarea.append("Se han encontrado elementos repetidos entre los proyectos\n");
                            numlinea++;
                            label.append("\n" + numlinea + "\n");
                            numlinea++;
                        }else{
                            textarea.append("No se han encontrado elementos repetidos entre los proyectos\n");
                            numlinea++;
                            label.append("\n" + numlinea + "\n");
                            numlinea++;
                        }
                        
                    }else{
                        salida = new DataOutputStream(socket.getOutputStream());
                        salida.writeBytes("errores");
                        salida.close();
                        socket.close();
                        for(int i = 0; i < errores.size();  i++){
                            String datos[] = errores.get(i).split("-");
                            modelo.addRow(datos);
                        }
                    }
                }else{
                    try{
                        lexico scanner = new lexico(new BufferedReader(new StringReader(aux)), claseactual, proyectoactual, proy);
                        sintactico parser = new sintactico(scanner, scanner.getProyecto1(), scanner.getProyecto2(), claseactual, proyectoactual, proy);
                        parser.parse();
                        if(Conexion.errores.isEmpty()){
                            textarea.append("   Analisis de la clase: " + claseactual + " terminado con exito\n");
                            numlinea++;
                            label.append("\n" + numlinea);
                            if(proyectoactual.equals("Proyecto 1")){
                                proyecto1contenido.setComentarios(parser.getProyecto1().getComentarios());
                                proyecto1contenido.setVariables(parser.getProyecto1().getVariables());
                                proyecto1contenido.setMetodos(parser.getProyecto1().getMetodos());
                                proyecto1contenido.setClases(parser.getProyecto1().getClases());
                            }else{
                                proyecto2contenido.setComentarios(parser.getProyecto2().getComentarios());
                                proyecto2contenido.setVariables(parser.getProyecto2().getVariables());
                                proyecto2contenido.setMetodos(parser.getProyecto2().getMetodos());
                                proyecto2contenido.setClases(parser.getProyecto2().getClases());
                            }
                        }else{
                            textarea.append("   Se han encontrado errores en el analisis de la clase: " + claseactual + ". Para mayor informacion verifique la seccion de abajo.\n");
                            numlinea++;
                            label.append("\n" + numlinea);
                        }
                    }catch(Exception e){
                        System.out.println("catch" + e.getMessage());
                    }
                }
            }
        }catch(Exception e){}
    }
    
    public void ArmarJson(){
        //verifica clases repetidas
        int numero = 0;
        int proyecto1num = 0;
        int proyecto2num = 0;
        for(int i = 0; i < proyecto1contenido.getClases().size(); i++){
            for(int j = 0; j < proyecto2contenido.getClases().size(); j++){
                if(proyecto1contenido.getClases().get(i).getId().equals(proyecto2contenido.getClases().get(j).getId())){
                    if(Compararmetodos(proyecto1contenido.getClases().get(i).getMetodos(), proyecto2contenido.getClases().get(j).getMetodos())){
                        if(clasesrepetidas.equals("Clases: [")){
                            clasesrepetidas += " {";
                        }else{
                            clasesrepetidas += ", ";
                        }
                        clasesrepetidas += "Nombre: \"" + proyecto2contenido.getClases().get(j).getId() + "\"";
                        numero++;
                        cosasrepetidas = true;
                    }
                }
            }
        }
        if(!clasesrepetidas.equals("Clases: [")){
            clasesrepetidas += "}";
        }
        clasesrepetidas += "]";
        
        double valorclasesrepetidas = 0.0;
        
        proyecto1num = proyecto1contenido.getClases().size();
        proyecto2num = proyecto2contenido.getClases().size();
        
        if(numero != 0){
            valorclasesrepetidas = numero;
            valorclasesrepetidas = valorclasesrepetidas/(proyecto1num + proyecto2num);
            valorclasesrepetidas = valorclasesrepetidas * 0.25;
        }
        numero = 0;
        for(int i = 0; i < proyecto1contenido.getVariables().size(); i++){
            for(int j = 0; j < proyecto2contenido.getVariables().size(); j++){
                if(proyecto1contenido.getVariables().get(i).getIdentificador().equals(proyecto2contenido.getVariables().get(j).getIdentificador()) && proyecto1contenido.getVariables().get(i).getTipo().equals(proyecto2contenido.getVariables().get(j).getTipo())){
                    if((proyecto1contenido.getVariables().get(i).getAmbito().equals("global") && proyecto2contenido.getVariables().get(j).getAmbito().equals("global")) || (!proyecto1contenido.getVariables().get(i).getAmbito().equals("global") && !proyecto2contenido.getVariables().get(j).getAmbito().equals("global"))){
                        if(variablesrepetidas.equals("Variables: [")){
                            variablesrepetidas += " {";
                        }else{
                            variablesrepetidas += "}, {";
                        }
                        variablesrepetidas += "Nombre: \"" + proyecto2contenido.getVariables().get(j).getIdentificador() + "\", Tipo: \"" + proyecto2contenido.getVariables().get(j).getTipo() + "\", " ;
                        variablesrepetidas += "Funcion: \"" + proyecto2contenido.getVariables().get(j).getAmbito() + "\", Clase: \"" + proyecto2contenido.getVariables().get(j).getProyecto() + "\"";
                        cosasrepetidas = true;
                        numero++;
                    }
                }
            }
        }
        if(!variablesrepetidas.equals("Variables: [")){
            variablesrepetidas += "}";
        }
        variablesrepetidas += "]";
        double valorvariablesrepetidas = 0.0;
        proyecto1num = proyecto1contenido.getVariables().size();
        proyecto2num = proyecto2contenido.getVariables().size();
        if(numero != 0){
            valorvariablesrepetidas = numero;
            valorvariablesrepetidas = valorvariablesrepetidas/(proyecto1num + proyecto2num);
            valorvariablesrepetidas = valorvariablesrepetidas * 0.25;
        }
        
        numero = 0;
        for(int i = 0; i < proyecto1contenido.getMetodos().size(); i++){
            for(int j = 0; j < proyecto2contenido.getMetodos().size(); j++){
                if(proyecto1contenido.getMetodos().get(i).getNombre().equals(proyecto2contenido.getMetodos().get(j).getNombre())){
                    if(true){
                        if(Compararvariablesmetodos(proyecto1contenido.getMetodos().get(i).getVariables(), proyecto2contenido.getMetodos().get(j).getVariables())){
                            if(proyecto1contenido.getMetodos().get(i).getParametros().size() == proyecto2contenido.getMetodos().get(j).getParametros().size() && Compararparametrosmetodos(proyecto1contenido.getMetodos().get(i).getParametros(), proyecto2contenido.getMetodos().get(j).getParametros()) && !proyecto1contenido.getMetodos().get(i).getNombre().equals("main")){
                                if(metodosrepetidos.equals("Metodos: [")){
                                    metodosrepetidos += " {";
                                }else{
                                    metodosrepetidos += "}, {";
                                }
                                metodosrepetidos += "Nombre: \"" + proyecto2contenido.getMetodos().get(j).getNombre() + "\", Tipo: \"" + proyecto2contenido.getMetodos().get(j).getTipo() + "\", Parametros: \"" + proyecto2contenido.getMetodos().get(j).getParametros().size() + "\"";
                                cosasrepetidas = true;
                                numero++;
                            }
                        }
                    }
                }
            }
        }
        if(!metodosrepetidos.equals("Metodos: [")){
            metodosrepetidos += "}";
        }
        metodosrepetidos += "]";
        
        double valormetodosrepetidos = 0.0;
        proyecto1num = proyecto1contenido.getMetodos().size();
        proyecto2num = proyecto2contenido.getMetodos().size();
        if(numero  != 0){
            valormetodosrepetidos = numero;
            valormetodosrepetidos = valormetodosrepetidos/(proyecto1num + proyecto2num);
            valormetodosrepetidos = valormetodosrepetidos * 0.25;
        }
        numero = 0;
        for(int i = 0; i < proyecto1contenido.getComentarios().size(); i++){
            for(int j = 0; j < proyecto2contenido.getComentarios().size(); j++){
                if(proyecto1contenido.getComentarios().get(i).getTexto().equals(proyecto2contenido.getComentarios().get(j).getTexto())){
                    if(comentariosrepetidos.equals("Comentarios: [")){
                        comentariosrepetidos += "{";
                    }else{
                        comentariosrepetidos += "}, {";
                    }
                    comentariosrepetidos += "Texto: " + proyecto2contenido.getComentarios().get(j).getTexto().replace("\n", "");
                    numero++;
                    cosasrepetidas = true;
                }
            }
        }
        if(!comentariosrepetidos.equals("Comentarios: [")){
            comentariosrepetidos += "}";
        }
        comentariosrepetidos += "]";
        double valorcomentariosrepetidos = 0.0;
        proyecto1num = proyecto1contenido.getComentarios().size();
        proyecto2num = proyecto2contenido.getComentarios().size();
        if(numero != 0){
            valorcomentariosrepetidos = numero;
            valorcomentariosrepetidos = valorcomentariosrepetidos/(proyecto1num + proyecto2num);
            valorcomentariosrepetidos = valorcomentariosrepetidos * 0.25;
        }
        score = valorclasesrepetidas + valorvariablesrepetidas + valormetodosrepetidos + valorcomentariosrepetidos;
        
    }
    
    public boolean Compararvariablesmetodos(ArrayList<Variables> variablesmetodo1, ArrayList<Variables> variablesmetodo2){
        for(int i = 0; i < variablesmetodo1.size(); i++){
            variablesmetodo1.get(i).yaexiste = false;
        }
        for(int i = 0; i < variablesmetodo2.size(); i++){
            variablesmetodo2.get(i).yaexiste = false;
        }
        if(variablesmetodo1.size() == variablesmetodo2.size() && variablesmetodo1.size() > 0){
            boolean[] todaslasvariables = new boolean[variablesmetodo1.size()];
            for(int i = 0; i < variablesmetodo1.size(); i++){
                for(int j = 0; j < variablesmetodo2.size(); j++){
                    if(variablesmetodo1.get(i).getIdentificador().equals(variablesmetodo2.get(j).getIdentificador())){
                        todaslasvariables[i] = true;
                        variablesmetodo1.get(i).yaexiste = true;
                        variablesmetodo2.get(j).yaexiste = true;
                    }
                }
            }
            for(int i = 0; i < todaslasvariables.length; i++){
                if(todaslasvariables[i] == false){
                    return false;
                }
            }
            return true;
        }else return variablesmetodo1.size() == variablesmetodo2.size() && variablesmetodo1.isEmpty();
    }
    
    public boolean Compararparametrosmetodos(ArrayList<Parametros> parametrosmetodo1, ArrayList<Parametros> parametrosmetodo2){
        for(int i = 0; i < parametrosmetodo1.size(); i++){
            parametrosmetodo1.get(i).yaexiste = false;
        }
        for(int i = 0; i < parametrosmetodo2.size(); i++){
            parametrosmetodo2.get(i).yaexiste = false;
        }
        if(parametrosmetodo1.size() == parametrosmetodo2.size() && parametrosmetodo1.size() > 0){
            boolean[] todoslosparametros = new boolean[parametrosmetodo1.size()];
            for(int i = 0; i < parametrosmetodo1.size(); i++){
                for(int j = 0; j < parametrosmetodo2.size(); j++){
                    if(parametrosmetodo1.get(i).getNombre().equals(parametrosmetodo2.get(j).getNombre()) && parametrosmetodo1.get(i).getTipo().equals(parametrosmetodo2.get(j).getTipo())){
                        todoslosparametros[i] = true;
                        parametrosmetodo1.get(i).yaexiste = true;
                        parametrosmetodo2.get(j).yaexiste = true;
                    }
                }
            }
            for(int i = 0; i < todoslosparametros.length; i++){
                if(todoslosparametros[i] == false){
                    return false;
                }
            }
            return true;
        }else return parametrosmetodo1.size() == parametrosmetodo2.size() && parametrosmetodo1.isEmpty();
    }
    
    public boolean Compararmetodos(ArrayList<Metodos> metodosclase1,  ArrayList<Metodos> metodosclase2){
        for(int i = 0; i < metodosclase1.size(); i++){
            metodosclase1.get(i).yaexiste = false;
        }
        for(int i = 0; i < metodosclase2.size(); i++){
            metodosclase2.get(i).yaexiste = false;
        }
        if(metodosclase1.size() == metodosclase2.size() && metodosclase1.size() > 0){
            boolean[] todoslosmetodos = new boolean[metodosclase1.size()];
            for(int i = 0; i < metodosclase1.size(); i++){
                for(int j = 0; j < metodosclase2.size(); j++){
                    if(metodosclase1.get(i).getNombre().equals(metodosclase2.get(j).getNombre()) && !metodosclase1.get(i).yaexiste && !metodosclase2.get(j).yaexiste){
                        todoslosmetodos[i] = true;
                        metodosclase1.get(i).yaexiste = true;
                        metodosclase2.get(j).yaexiste = true;
                    }
                }
            }
            for(int i = 0; i < todoslosmetodos.length; i++){
                if(todoslosmetodos[i] == false){
                    return false;
                }
            }
            return true;
        }else return metodosclase1.size() == metodosclase2.size() && metodosclase1.isEmpty();
    }
    
    public void RecorrerComentariosProyectos(){
        //System.out.println("Proyecto1: " + proyecto1);
        //System.out.println("Clases ");
        for(int i = 0; i < proyecto1contenido.getClases().size(); i++){
            //System.out.println(proyecto1contenido.getClases().get(i).getId());
            //System.out.println("    Metodo");
            for(int j = 0; j < proyecto1contenido.getClases().get(i).getMetodos().size(); j++){
                //System.out.println("    " + proyecto1contenido.getClases().get(i).getMetodos().get(j).getTipo() + " " + proyecto1contenido.getClases().get(i).getMetodos().get(j).getNombre());
            }
        }
        System.out.println("Comentarios ");
        for(int i = 0; i < proyecto1contenido.getComentarios().size(); i++){
            System.out.println(proyecto1contenido.getComentarios().get(i).getTexto());
        }
        System.out.println("Variables ");
        for(int i = 0; i < proyecto1contenido.getVariables().size(); i++){
            System.out.println(proyecto1contenido.getVariables().get(i).getIdentificador() + " " + proyecto1contenido.getVariables().get(i).getAmbito() + " " + proyecto1contenido.getVariables().get(i).getTipo() + " " + proyecto1contenido.getVariables().get(i).getProyecto());
        }
        System.out.println("Metodos ");
        for(int i = 0; i < proyecto1contenido.getMetodos().size(); i++){
            System.out.println(proyecto1contenido.getMetodos().get(i).getNombre() + " " + proyecto1contenido.getMetodos().get(i).getTipo());
            System.out.println("    Parametros:");
            for(int j = 0; j < proyecto1contenido.getMetodos().get(i).getParametros().size(); j++){
                System.out.println("    " + proyecto1contenido.getMetodos().get(i).getParametros().get(j).getTipo() + " " + proyecto1contenido.getMetodos().get(i).getParametros().get(j).getNombre());
            }
            System.out.println("    Variables:");
            for(int j = 0; j < proyecto1contenido.getMetodos().get(i).getVariables().size(); j++){
                System.out.println("    " + proyecto1contenido.getMetodos().get(i).getVariables().get(j).getTipo() + " " + proyecto1contenido.getMetodos().get(i).getVariables().get(j).getIdentificador());
            }
            System.out.println("    Numero de lineas:" + proyecto1contenido.getMetodos().get(i).getCantlineas());
        }
        
        System.out.println("Proyecto2: " + proyecto2);
        System.out.println("Clases ");
        for(int i = 0; i < proyecto2contenido.getClases().size(); i++){
            System.out.println(proyecto2contenido.getClases().get(i).getId());
            System.out.println("    Metodo");
            for(int j = 0; j < proyecto2contenido.getClases().get(i).getMetodos().size(); j++){
                System.out.println("    " + proyecto2contenido.getClases().get(i).getMetodos().get(j).getTipo() + " " + proyecto2contenido.getClases().get(i).getMetodos().get(j).getNombre());
            }
        }
        System.out.println("Comentarios ");
        for(int i = 0; i < proyecto2contenido.getComentarios().size(); i++){
            System.out.println(proyecto2contenido.getComentarios().get(i).getTexto());
        }
        System.out.println("Variables ");
        for(int i = 0; i < proyecto2contenido.getVariables().size(); i++){
            System.out.println(proyecto2contenido.getVariables().get(i).getIdentificador() + " " + proyecto2contenido.getVariables().get(i).getAmbito() + " " + proyecto2contenido.getVariables().get(i).getTipo() + " " + proyecto2contenido.getVariables().get(i).getProyecto());
        }
        System.out.println("Metodos ");
        for(int i = 0; i < proyecto2contenido.getMetodos().size(); i++){
            System.out.println(proyecto2contenido.getMetodos().get(i).getNombre() + " " + proyecto2contenido.getMetodos().get(i).getTipo());
            System.out.println("    Parametros:");
            for(int j = 0; j < proyecto2contenido.getMetodos().get(i).getParametros().size(); j++){
                System.out.println("    " + proyecto2contenido.getMetodos().get(i).getParametros().get(j).getTipo() + " " + proyecto2contenido.getMetodos().get(i).getParametros().get(j).getNombre());
            }
            System.out.println("    Variables:");
            for(int j = 0; j < proyecto2contenido.getMetodos().get(i).getVariables().size(); j++){
                System.out.println("    " + proyecto2contenido.getMetodos().get(i).getVariables().get(j).getTipo() + " " + proyecto2contenido.getMetodos().get(i).getVariables().get(j).getIdentificador());
            }
        }
    }
}
