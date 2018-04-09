/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.util.ArrayList;

/**
 *
 * @author oscar
 */
public class Result {
    private double score;
    private ArrayList<ResultClases> clases;
    private ArrayList<ResultVariables> variables;
    private ArrayList<ResultMetodos> metodos;
    private ArrayList<ResultComentarios> comentarios;
    
    public Result(){
        this.clases = new ArrayList();
        this.variables = new ArrayList();
        this.metodos = new ArrayList();
        this.comentarios = new ArrayList();
    }
    
    public void AgregarClases(ResultClases clase){
        this.clases.add(clase);
        System.out.println();
    }

    public void AgregarVariables(ResultVariables variable){
        this.variables.add(variable);
        System.out.println();
    }
    
    public void AgregarMetodos(ResultMetodos metodo){
        this.metodos.add(metodo);
        System.out.println();
    }
    
    public void AgregarComentarios(ResultComentarios comentario){
        this.comentarios.add(comentario);
        System.out.println();
    }
    
    /**
     * @return the score
     */
    public double getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(double score) {
        this.score = score;
    }

    /**
     * @return the clases
     */
    public ArrayList<ResultClases> getClases() {
        return clases;
    }

    /**
     * @param clases the clases to set
     */
    public void setClases(ArrayList<ResultClases> clases) {
        this.clases = clases;
    }

    /**
     * @return the variables
     */
    public ArrayList<ResultVariables> getVariables() {
        return variables;
    }

    /**
     * @param variables the variables to set
     */
    public void setVariables(ArrayList<ResultVariables> variables) {
        this.variables = variables;
    }

    /**
     * @return the metodos
     */
    public ArrayList<ResultMetodos> getMetodos() {
        return metodos;
    }

    /**
     * @param metodos the metodos to set
     */
    public void setMetodos(ArrayList<ResultMetodos> metodos) {
        this.metodos = metodos;
    }

    /**
     * @return the comentarios
     */
    public ArrayList<ResultComentarios> getComentarios() {
        return comentarios;
    }

    /**
     * @param comentarios the comentarios to set
     */
    public void setComentarios(ArrayList<ResultComentarios> comentarios) {
        this.comentarios = comentarios;
    }
}
