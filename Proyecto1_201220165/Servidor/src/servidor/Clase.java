/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.util.ArrayList;

/**
 *
 * @author oscar
 */
public class Clase {

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the metodos
     */
    public ArrayList<Metodos> getMetodos() {
        return metodos;
    }

    /**
     * @param metodos the metodos to set
     */
    public void setMetodos(ArrayList<Metodos> metodos) {
        this.metodos = metodos;
    }
    private String id;
    private ArrayList<Metodos> metodos;
    
    public boolean Compararmetodos(ArrayList<Metodos> metodosclase1,  ArrayList<Metodos> metodosclase2){
        if(metodosclase1.size() == metodosclase2.size() && metodosclase1.size() > 0){
            boolean[] todoslosmetodos = new boolean[metodosclase1.size()];
            for(int i = 0; i < todoslosmetodos.length; i++){
                todoslosmetodos[i] = false;
            }
            for(int i = 0; i < metodosclase1.size(); i++){
                for(int j = 0; j < metodosclase2.size(); i++){
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
    
    public void setYaexiste(){
        for(int i = 0; i < this.metodos.size(); i++){
            this.metodos.get(i).yaexiste = false;
        }
    }
}
