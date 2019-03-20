/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package questions;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dkuran
 */
public class ClsIOManager {
    
    public void crear(String fichero){
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(fichero));
            oos.close();
            ClsProperties propiedad = new ClsProperties();
            propiedad.escribir(1, "personas");
            propiedad.escribir(1, "materias");
            propiedad.escribir(1, "preguntas");
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    public void insertar(String fichero, ArrayList<Object> elementos){
        //ClsProperties propiedad = new ClsProperties();
        //int registro = (int)propiedad.leer(property);
        //System.out.println(registro);
        
        try
        {
            ObjectOutputStream oos;
            oos = new ObjectOutputStream(new FileOutputStream(fichero));
            for (int i = 0; i <elementos.size(); i++)
            {
                // ojo, se hace un new por cada Persona. El new dentro
                // del bucle.
                Object elemento = new Object();
                elemento = elementos.get(i);
                //System.out.println(p.ToString()); 
                oos.writeObject(elemento);
            }
            oos.close();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
    
    }
    
    
    public ArrayList<Object>  extraer (String fichero)
    {
        ArrayList<Object> objetos = new ArrayList<Object>();
        try
        {
            // Se crea un ObjectInputStream
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(fichero));
            
            // Se lee el primer objeto
            Object aux = ois.readObject();
            // Mientras haya objetos
            while (aux!=null)
            {
                
                //if (aux instanceof ClsPersona)
                objetos.add(aux);
                    //System.out.println(aux.toString());
                aux = ois.readObject();
            }
            ois.close();
            
        }
        catch (FileNotFoundException ex) {
            crear(fichero);
        } 
        catch (EOFException e1)
        {
            //System.out.println ("Fin de fichero");
        }
        catch (Exception e2)
        {
            e2.printStackTrace();
        }
        return objetos;
    }
    
    
    
    
    public ArrayList<Object>  listar (String fichero, int id)
    {
        ArrayList<Object> objetos = new ArrayList<Object>();
        try
        {
            // Se crea un ObjectInputStream
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(fichero));
            
            // Se lee el primer objeto
            Object aux = ois.readObject();
            // Mientras haya objetos
            while (aux!=null)
            {
                ClsPregunta pregunta = (ClsPregunta)aux;
                
                if (pregunta.getMateria() == id){
                    objetos.add(aux);
                    //System.out.println(pregunta.toString());
                } 
                aux = ois.readObject();
            }
            ois.close();
            
        }
        catch (FileNotFoundException ex) {
            crear(fichero);
        } 
        catch (EOFException e1)
        {
            //System.out.println ("Fin de fichero");
        }
        catch (Exception e2)
        {
            e2.printStackTrace();
        }
        return objetos;
    }
    
    
        public Object  login (String fichero, String user, String pass)
    {
        //ArrayList<Object> objetos = new ArrayList<Object>();
        Object usuario = new Object();
        usuario = null;
        try
        {
            // Se crea un ObjectInputStream
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(fichero));
            
            // Se lee el primer objeto
            Object aux = ois.readObject();
            // Mientras haya objetos
            while (aux!=null)
            {
                ClsPersona persona = (ClsPersona)aux;
                
                if (persona.getUsuario().equals(user) && persona.getContraseña().equals(pass)){
                    //objetos.add(aux);
                    usuario = aux;
                    //System.out.println(pregunta.toString());
                } 
                aux = ois.readObject();
            }
            ois.close();
            
        }
        catch (FileNotFoundException ex) {
            crear(fichero);
        } 
        catch (EOFException e1)
        {
            //System.out.println ("Fin de fichero");
        }
        catch (Exception e2)
        {
            e2.printStackTrace();
        }
        return usuario;
    }
    
    
    /*
    public void anhadeFichero (String fichero, ClsPersona persona1)
    {
        ClsProperties propiedad = new ClsProperties();
        int registro = (int)propiedad.leer();
        System.out.println(registro);
        
        try
        {
            //propiedad.escribir(0);
            if(registro == 0){
                ObjectOutputStream oos1;
                oos1 = new ObjectOutputStream(new FileOutputStream(fichero));
                oos1.close();
                propiedad.escribir(registro+=1);
                //System.out.println("hola");
            }

            // Se usa un ObjectOutputStream que no escriba una cabecera en
            // el stream.
            ClsOutPutStream oos = new ClsOutPutStream(
                    new FileOutputStream(fichero,true));
            // Se hace el new fuera del bucle, sÛlo hay una instancia de persona.
            // Se debe usar entonces writeUnshared().
            ClsPersona p = new ClsPersona(persona1.getId(), persona1.getNombre(),persona1.getApellido());
            oos.writeUnshared(p);
            propiedad.escribir(registro+=1);
            
            for (int i = 5; i < 10; i++)
            {
                //p.setPersona(i);   // Se rellenan los datos de Persona.
                oos.writeUnshared(p);
                propiedad.escribir(registro+=1);
            }
            oos.close();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }

    }
    
    public void escribeFichero(String fichero)
    {
        try
        {
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(fichero));
            for (int i = 0; i <5; i++)
            {
                // ojo, se hace un new por cada Persona. El new dentro
                // del bucle.
                //ClsPersona p = new ClsPersona("Andres","Duran");
                //System.out.println(p.ToString()); 
               // oos.writeObject(p);
            }
            oos.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Object>  leeFichero(String fichero)
    {
        ArrayList<Object> personas = new ArrayList<Object>();
        try
        {
            // Se crea un ObjectInputStream
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(fichero));
            
            // Se lee el primer objeto
            Object aux = ois.readObject();
            // Mientras haya objetos
            while (aux!=null)
            {
                
                if (aux instanceof ClsPersona)
                    personas.add(aux);
                    //System.out.println(aux.toString());
                aux = ois.readObject();
            }
            ois.close();
            
        }
        catch (EOFException e1)
        {
            //System.out.println ("Fin de fichero");
        }
        catch (Exception e2)
        {
            e2.printStackTrace();
        }
        return personas;
    }
    
    public Object  encuentraFichero(String fichero, int id)
    {
        ClsPersona persona = new ClsPersona();
        try
        {
            // Se crea un ObjectInputStream
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(fichero));
            
            // Se lee el primer objeto
            Object aux = ois.readObject();
            // Mientras haya objetos
            while (aux!=null)
            {
                
                if (aux instanceof ClsPersona){
                    persona = (ClsPersona)aux;
                    //System.out.println("id objeto encontrado: " + persona.getId());
                    //System.out.println("id ingresado: " + id);
                    if(persona.getId() == id){
                        return persona;
                    } 
                }
                aux = ois.readObject();
            }
            ois.close();
            
        }
        catch (EOFException e1)
        {
            //System.out.println ("Fin de fichero");
        }
        catch (Exception e2)
        {
            e2.printStackTrace();
        }
        return persona;
    }
    
    */
}
