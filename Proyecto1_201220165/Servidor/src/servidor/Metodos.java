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
public class Metodos {
    private String nombre;
    private ArrayList<Parametros> parametros;
    private int cantlineas;
    private String tipo;
    private ArrayList<Variables> variables;
    boolean yaexiste;

    public void Metodos(){
        yaexiste = false;
    }
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the parametros
     */
    public ArrayList<Parametros> getParametros() {
        return parametros;
    }

    /**
     * @param parametros the parametros to set
     */
    public void setParametros(ArrayList<Parametros> parametros) {
        this.parametros = parametros;
    }

    /**
     * @return the cantlineas
     */
    public int getCantlineas() {
        return cantlineas;
    }

    /**
     * @param cantlineas the cantlineas to set
     */
    public void setCantlineas(int cantlineas) {
        this.cantlineas = cantlineas;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the variables
     */
    public ArrayList<Variables> getVariables() {
        return variables;
    }

    /**
     * @param variables the variables to set
     */
    public void setVariables(ArrayList<Variables> variables) {
        this.variables = variables;
    }
}
