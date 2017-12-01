/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genarffconsola;

import java.util.Scanner;

/**
 *
 * @author Blythe
 */
public class GenARFFConsola {

    /**
     * @param args the command line arguments
     */
    
    static String hebraTipo;                       // tipo de hebra, [ W | C ]
    static String tipo;                               // tipo de prueba [ EI | IE | ZE | EZ ]
    static String tipoFalso;                       // tipo de archivo falso [ cie | cei | cez | cze ]
    static int cant;  
    
    public static void main(String[] args) {
        // TODO code application logic here

            cargaParametros();
            Catalizador cat = new Catalizador();
            cat.initParam(hebraTipo,tipo,tipoFalso,cant);
            cat.exec();
        
    }
    
    
    
    
    // Cargar Parametros, ésta función es accesoria, es independiente de la clase Catalizador
    
    public static void cargaParametros(){
        // escojo el tipo de hebra
            Scanner s = new Scanner(System.in);     // lectura por teclado, solo para captar los parametros
            System.out.println("\nIngrese tipo de Hebra: \n\t[ W | C ]");
            do {
                
                hebraTipo = s.nextLine();
                if (hebraTipo.compareTo("W")!=0&&hebraTipo.compareTo("C")!=0)
                    System.out.println("\nDato no valido, ingrese una de las opciones \n\t[ W | C ]");
                
            } while (hebraTipo.compareTo("W")!=0&&hebraTipo.compareTo("C")!=0);
            
            // escojo el tipo de prueba
            System.out.println("\nIngrese tipo de prueba: \n\t[ EI | IE | ZE | EZ ]");
            do {
                
                tipo = s.nextLine();
                if (tipo.compareTo("EI")!=0&&tipo.compareTo("IE")!=0&&tipo.compareTo("ZE")!=0&&tipo.compareTo("EZ")!=0)
                    System.out.println("\nDato no valido, ingrese una de las opciones \n\t[ EI | IE | ZE | EZ ]");
                
            } while (tipo.compareTo("EI")!=0&&tipo.compareTo("IE")!=0&&tipo.compareTo("ZE")!=0&&tipo.compareTo("EZ")!=0);
            
            // escojo el tipo de archivo falso para la prueba
            System.out.println("\nIngrese tipo de archivo falso para la prueba: \n\t[ cie | cei | cez | cze ]");
            do {
                
                tipoFalso = s.nextLine();
                if ((tipoFalso.compareTo("cie")!=0&&tipoFalso.compareTo("cei")!=0&&tipoFalso.compareTo("cze")!=0&&tipoFalso.compareTo("cze")!=0)||tipoFalso.compareToIgnoreCase("c"+tipo)==0)
                    System.out.println("\nDato no valido, ingrese una de las opciones \n\t[ cie | cei | cez | cze ]");
                
            } while ((tipoFalso.compareTo("cie")!=0&&tipoFalso.compareTo("cei")!=0&&tipoFalso.compareTo("cze")!=0&&tipoFalso.compareTo("cze")!=0)||tipoFalso.compareToIgnoreCase("c"+tipo)==0);
        
            // escojo el tamaño de la subcadena
            System.out.println("\nIngrese tamaño de la subcadena: \n\t[ 1 - 10 ]");
            do {
                
                cant = s.nextInt();
                if (cant < 1 || cant > 10)
                    System.out.println("\nDato no valido, ingrese una de las opciones \n\t[ 1 - 10 ]");
                
            } while (cant < 1 || cant > 10);
    }
    
}
