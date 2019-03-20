/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questions;

import java.io.Serializable;

/**
 *
 * @author Duran
 */
public class ClsPregunta implements Serializable{
    
    private int id;
    private String texto;
    private int materia;
    
    public ClsPregunta(){
    
    }
    
    public ClsPregunta(int id, int materia, String texto){
        this.id = id;
        this.texto = texto;
        this.materia = materia;
    }
    
    public String toString(){
        return this.getId() + " " + this.getTexto();
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the texto
     */
    public String getTexto() {
        return texto;
    }

    /**
     * @param texto the texto to set
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    /**
     * @return the materia
     */
    public int getMateria() {
        return materia;
    }

    /**
     * @param materia the materia to set
     */
    public void setMateria(int materia) {
        this.materia = materia;
    }
    
}
