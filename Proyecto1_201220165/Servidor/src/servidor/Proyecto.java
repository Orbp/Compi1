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
public class Proyecto {
    private ArrayList<Clase> clases;
    private ArrayList<Variables> variables;
    private ArrayList<Metodos> metodos;
    private ArrayList<Comentario> comentarios;

    public Proyecto(){
        this.clases = new ArrayList();
        this.variables = new ArrayList();
        this.metodos = new ArrayList();
        this.comentarios = new ArrayList();
    }
    
    /**
     * @return the clases
     */
    public ArrayList<Clase> getClases() {
        return clases;
    }
    
    public void AgregarComentario(Comentario comen){
        if(this.comentarios.isEmpty()){
            this.comentarios.add(comen);
        }else{
            boolean existe = false;
            for(int i = 0; i < this.comentarios.size(); i++){
                if(comen.getTexto().compareTo(this.comentarios.get(i).getTexto()) == 0){
                    existe = true;
                    break;
                }
            }
            if(!existe){
                this.comentarios.add(comen);
            }
        }
        
        System.out.println();
    }
    
    public void AgregarVariable(Variables variable){
        if(this.variables.isEmpty()){
            this.variables.add(variable);
        }else{
            boolean existe = false;
            for(int i = 0; i < this.variables.size(); i++){
                if(variable.getIdentificador().compareTo(this.variables.get(i).getIdentificador()) == 0 && variable.getTipo().compareTo(this.variables.get(i).getTipo()) == 0){
                    existe = true;
                    break;
                }
            }
            if(!existe){
                this.variables.add(variable);
            }
        }
    }
    
    public void AgregarMetodos(Metodos metodo){
        this.metodos.add(metodo);
    }

    public void AgregarClase(Clase clase){
        this.clases.add(clase);
    }
    
    /**
     * @param clases the clases to set
     */
    public void setClases(ArrayList<Clase> clases) {
        if(this.clases.isEmpty()){
            this.clases = clases;
        }else{
            for(int i = 0; i < clases.size(); i++){
                this.clases.add(clases.get(i));
            }
        }
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
        if(this.variables.isEmpty()){
            this.variables = variables;
        }else{
            for(int i = 0; i < variables.size(); i++){
                this.variables.add(variables.get(i));
            }
        }
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
        if(this.metodos.isEmpty()){
            this.metodos = metodos;
        }else{
            for(int i = 0; i < metodos.size(); i++){
                this.metodos.add(metodos.get(i));
            }
        }
    }

    /**
     * @return the comentarios
     */
    public ArrayList<Comentario> getComentarios() {
        return comentarios;
    }
    /**
     * @param comentarios the comentarios to set
     */
    public void setComentarios(ArrayList<Comentario> comentarios) {
        if(this.comentarios.isEmpty()){
            this.comentarios = comentarios;
        }else{
            for(int i = 0; i < comentarios.size(); i++){
                this.comentarios.add(comentarios.get(i));
            }
        }
    }
}
