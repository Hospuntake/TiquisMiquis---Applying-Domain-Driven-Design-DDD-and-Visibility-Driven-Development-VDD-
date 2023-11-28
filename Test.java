package implementacio;

import java.util.HashMap;

/**
 *
 * @author Joa
 */
public class Test {
    Integer Repeticions;
    Integer Numero;
    Integer Estat;
    Professor ProfessorCreador;
    Nivell NivellTest;
    HashMap<String,Grup> DirGrup;//Hay que generarlo en el MAIN o donde sea!!!!
    HashMap<String,Pregunta> DirPregunta;//Hay que generarlo en el MAIN o donde sea!!!!
    HashMap<String,Estudiant> DirEstudiant;//Hay que generarlo en el MAIN o donde sea!!!!

    
    Test(Integer Numero,Professor prof,Nivell niv){
        this.Repeticions=0;
        this.Numero=Numero;
        this.Estat=0;
        ProfessorCreador=prof;
        NivellTest=niv;
        DirPregunta = new HashMap<String,Pregunta>();
        DirGrup = new HashMap<String,Grup>();
        DirEstudiant = new HashMap<String,Estudiant>();
        
        
    }

    public Professor getProfessorCreador() {
        return ProfessorCreador;
    }
    
    
    //------------------------------------------------
    //---------------CREA TEST------------------------
    void PreguntaTest(Pregunta pre){
        DirPregunta.put(pre.getEnu(),pre);
        pre.AfegirTest(this);
    }
    //---------------CREA TEST------------------------
    //------------------------------------------------    
    //---------------DONA PERMIS----------------------
    void PermisTest(Grup gru){
        DirGrup.put(gru.getCriteri(),gru);
        gru.NouGrup(this);
        gru.NouPermis(this);
    }
    void PermisEst(Estudiant est){
        Estudiant e=DirEstudiant.get(est.getNom());
        if(e==null)DirEstudiant.put(est.getNom(),est);
    }
    //---------------DONA PERMIS----------------------
    //------------------------------------------------    
    //-------------AVALUA ESTUDIANT-------------------
    Nivell PeticioNiv(){
        return this.NivellTest;
    }
    void SumaRep(){
        ++this.Repeticions;
    }
    Integer AgafaEstat(){
        return this.Estat;
    }
    
    
    //-------------AVALUA ESTUDIANT-------------------
     //------------------------------------------------    
    //------------------NETEJA------------------------
    void CanviaEstat(){
        this.Estat=1;
    }
    
    
    public Integer getRepeticions() {
        return Repeticions;
    }

    public Integer getNumero() {
        return Numero;
    }

    public Integer getEstat() {
        return Estat;
    }
    
}
