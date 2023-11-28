package implementacio;

import java.util.HashMap;

/**
 *
 * @author Joa
 */
public class Estudiant {
    String Nom;
    Nivell NivellEstudiant;
    Intent IntentDiferenciat;
    Historic HistoricDiferenciat;
    HashMap<Integer,Intent> DirIntent;
    HashMap<String,Historic> DirHistoric;
    
    Estudiant(String Nom,Nivell niv){
        this.Nom=Nom;      
        NivellEstudiant=niv;
        IntentDiferenciat=null;
        HistoricDiferenciat=null;
        DirIntent = new HashMap<Integer,Intent>();
        DirHistoric = new HashMap<String,Historic>();
        DirHistoric.put(niv.getCurs(),new Historic(niv));
    }
    
    
    //------------------------------------------------    
    //---------------DONA PERMIS----------------------
    void PermisEst(Test tes){
        tes.PermisEst(this);
    }
    
    
    
    
    //---------------DONA PERMIS----------------------
    //------------------------------------------------    
    //-------------AVALUA ESTUDIANT-------------------
    void IdentificaTes(int IdTes,Professor pro){
        Test tes=pro.AgafaTest(IdTes);
        IntentDiferenciat=new Intent(tes);
        Nivell n=tes.PeticioNiv();
        if(tes.Estat==0)DirIntent.put(IdTes, IntentDiferenciat);
        if(DirHistoric.get(n.getCurs())!=null)HistoricDiferenciat=DirHistoric.get(n.getCurs());
    }
    
    void responPreg(Pregunta pre,Resposta res){
        IntentDiferenciat.responPreg(pre,res);
    }
    float fiIntent(){
        IntentDiferenciat.SumaRep();
        int estat=IntentDiferenciat.AgafaEstat();
        float nota = IntentDiferenciat.CalculaNota();
        if(estat==0)HistoricDiferenciat.ActualitzaNota(nota);
        else HistoricDiferenciat.SumaReut();
        IntentDiferenciat=null;
        HistoricDiferenciat=null;
        return nota;
    }
    
    
    
    
    
    //-------------AVALUA ESTUDIANT-------------------
    
    
    
    
    public String getNom() {
        return Nom;
    }
    
}
