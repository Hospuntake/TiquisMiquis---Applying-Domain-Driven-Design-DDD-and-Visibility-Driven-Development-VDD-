package implementacio;

import java.util.HashMap;

/**
 *
 * @author Joa
 */
public class Nivell {
    HashMap<String,Pregunta> DirPregunta;
    HashMap<Integer,Test> DirTest;
    HashMap<String,Estudiant> DirEstudiant;
    
    String Curs;
    
    Nivell(String Curs){
        DirPregunta = new HashMap<String,Pregunta>();
        DirTest = new HashMap<Integer,Test>();
        DirEstudiant = new HashMap<String,Estudiant>();
        this.Curs=Curs;   
    }
    //---------------INTRODUIR PREGUNTA---------------
    
    void sumaPreg(Pregunta Pg){
        DirPregunta.put(Pg.getEnu(),Pg);
        
    }   
    //---------------INTRODUIR PREGUNTA--------------
    //------------------------------------------------
    //---------------CREA TEST------------------------
    
    void afegirTest(Test T){
        DirTest.put(T.getNumero(),T);
    }
    
    //---------------CREA TEST------------------------
    //------------------------------------------------    
    //------------------NETEJA------------------------
    void EsborraNivellActual(){
        DirEstudiant = new HashMap<String,Estudiant>();
    }
    
    
    
    
    
    
    
    
    
    
    
    public String getCurs() {
        return Curs;
    }
    
}
