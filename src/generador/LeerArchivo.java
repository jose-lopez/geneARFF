/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generador;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author cypres
 */
    
public class LeerArchivo {
    
    private String ruta;
    
    public LeerArchivo(){
        this.ruta = null;
    }
    
    public LeerArchivo(String rut){
        this.ruta = rut;
    }
    
    public void metodo (String ruta, String clase, EscribirArchivo arc) throws Exception{
        LeerArchivo arcp = new LeerArchivo(ruta);
            int lineas = arcp.CantidadLineas();
            String[] Data = new String[lineas];
            Data = arcp.AbrirArchivo();
            
            for (int i = 0; i < lineas; i++) {
                String linea = Data[i];
                if (linea.contains("p")) {
                    int j = linea.indexOf("p");
                    linea = linea.substring(j-10, j+11);
                    //linea = linea.replaceAll(",p,", ",");
                    arc.EscribirEnArchivo(linea+clase);
                }
            }
    }
    
    public String[] AbrirArchivo() throws Exception{
        
        FileReader fr = new FileReader(this.ruta);
        BufferedReader texto = new BufferedReader(fr);
        
        int numerolinea = CantidadLineas();
        String[] Datos = new String[numerolinea];
        
        for (int i = 0; i < numerolinea; i++) {
            Datos[i] = texto.readLine();
            ///System.out.println("LINEA "+ i + ": " + Datos[i]);
        }
        texto.close();
        return Datos;
    }
    public int CantidadLineas()throws Exception{
        FileReader fr = new FileReader(this.ruta);
        BufferedReader texto = new BufferedReader(fr);
        int cant = 0;
        String linea;
        
        while ((linea = texto.readLine()) != null) {            
            cant+=1;
        }
        texto.close();
        return cant;
    }
}
