
package implementacio;

import java.util.HashMap;

/**
 *
 * @author Joa
 */
public class Categoria {
    
    HashMap<String,Pregunta> DirPregunta;
    HashMap<String,Totals> DirTotals;//CATEGORIA ES EL CREADOR  TNEGO QUE CREAR DIRSS AL CREAR CATS
    String Tema;
    
    Categoria(String Tema){
        DirPregunta = new HashMap<String,Pregunta>();
        DirTotals = new HashMap<String,Totals>();
        this.Tema=Tema;   
        //CREAR TOTALS AL CREAR CAT
    }
    //---------------INTRODUIR PREGUNTA---------------
    
    void sumaCat(Pregunta Pg){
        DirPregunta.put(Pg.getEnu(),Pg);
    }   
    //---------------INTRODUIR PREGUNTA--------------
    //------------------------------------------------
    //---------------CREA TEST------------------------
    void PregCat(Professor pf){
        Totals Tot=pf.buscaTot(this);
          
        Tot.sumaVegades();
    }
    
    
    
    //---------------CREA TEST------------------------
    
    public String getTema() {
        return Tema;
    }
    
    
}
