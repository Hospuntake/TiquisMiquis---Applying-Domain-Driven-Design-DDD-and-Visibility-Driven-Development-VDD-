package implementacio;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Joa
 */

public class Grup {
    String Criteri;
    Professor ProfessorCreador;
    Nivell NivellGrup;
    HashMap<Integer,Test> DirTest;
    HashMap<String,Estudiant> DirEstudiant;
    Grup(String Criteri,Professor prof,Nivell niv){
        ProfessorCreador=prof;
        NivellGrup=niv;
        this.Criteri=Criteri;
        DirTest = new HashMap<Integer,Test>();
        DirEstudiant = new HashMap<String,Estudiant>();
        brossa(niv);
        
    }
void brossa(Nivell niv){
    DirEstudiant.put("JoaquimHervas", new Estudiant("JoaquimHervas",niv));
    DirEstudiant.put("Gelat", new Estudiant("Gelat",niv));
    DirEstudiant.put("Cristina", new Estudiant("Cristina",niv));
    DirEstudiant.put("JosepMaria", new Estudiant("JosepMaria",niv));
    DirEstudiant.put("Sergi", new Estudiant("Sergi",niv));
}
    //------------------------------------------------    
    //---------------DONA PERMIS----------------------
    void NouGrup(Test tes){
        DirTest.put(tes.getNumero(),tes);
    }
    void NouPermis(Test tes){
        for(Map.Entry<String, Estudiant> mO : this.DirEstudiant.entrySet()) {
            mO.getValue().PermisEst(tes);//No se si aqui puede petarXD
        }
    }



    //---------------DONA PERMIS----------------------    
    
    
    
    
    
    
    
    public String getCriteri() {
        return Criteri;
    }
}
