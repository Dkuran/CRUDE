/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package questions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 *
 * @author Dkuran
 */
public class ClsProperties {
    
    Properties propiedades = new Properties();
    InputStream entrada = null;
    OutputStream salida = null;
    
    public int leer(String propiedad){
        int registro = 0;
        try {
            
            entrada = new FileInputStream("configuracion.properties");

            // cargamos el archivo de propiedades
            propiedades.load(entrada);

            // obtenemos las propiedades y las imprimimos
            registro = Integer.parseInt(propiedades.getProperty(propiedad));


    } catch (IOException ex) {
        ex.printStackTrace();
    } finally {
        if (entrada != null) {
            try {
                entrada.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
        return registro;
    }
    public void escribir(int valor, String propiedad){
        try {
            salida = new FileOutputStream("configuracion.properties");

            // asignamos los valores a las propiedades
            propiedades.setProperty(propiedad, String.valueOf(valor));

            // guardamos el archivo de propiedades en la carpeta de aplicación
            propiedades.store(salida, null);

        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (salida != null) {
                try {
                    salida.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    
    }
}
