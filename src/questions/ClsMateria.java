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
public class ClsMateria implements Serializable {
    private int id;
    private String nombre;
    
    public ClsMateria(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }
    
    public ClsMateria(){
    
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
    
    public String toString(){
        return this.id +" "+ this.nombre;
    }
}
