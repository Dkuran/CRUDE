/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package questions;

import java.io.Serializable;

/**
 *
 * @author Dkuran
 */
public class ClsPersona implements Serializable{
    
    private int id;
    private String nombre;
    private String apellido;
    private String perfil;
    private String cedula;
    private String usuario;
    private String contraseña;
    private double puntaje;
    
    
    public ClsPersona(int id, String nombre, String apellido, String perfil, String cedula, String contraseña){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.perfil = perfil;
        this.cedula = cedula;
        this.usuario = cedula;
        this.contraseña = contraseña;
        this.puntaje = 0.00;
    }
    
    public ClsPersona(){

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
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    @Override
    public String toString(){
        return this.id + " "+ this.nombre +" "+ this.apellido;
    }
    
    public String imprimir(){
        return this.id + " "+ this.nombre +" "+ this.apellido+" "+this.perfil;
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
     * @return the perfil
     */
    public String getPerfil() {
        return perfil;
    }

    /**
     * @param perfil the perfil to set
     */
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    /**
     * @return the cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * @return the puntaje
     */
    public double getPuntaje() {
        return puntaje;
    }

    /**
     * @param puntaje the puntaje to set
     */
    public void setPuntaje(double puntaje) {
        this.puntaje = puntaje;
    }
    
}
