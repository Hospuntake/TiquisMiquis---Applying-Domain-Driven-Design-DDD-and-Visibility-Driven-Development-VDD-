package implementacio;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Joa
 */
public class Intent {
    Test TestIntent;
    float Nota;
    HashMap<String,Avaluacio> DirAvaluacio;
    
    Intent(Test tes){
        TestIntent=tes;
        this.Nota=0;
        DirAvaluacio = new HashMap<String,Avaluacio>();
    }

    
    
    
    void responPreg(Pregunta pre,Resposta res){
        int OrdCorrecte=pre.teSolucio();
        Avaluacio a= new Avaluacio(OrdCorrecte,res);
        DirAvaluacio.put(pre.getEnu(),a);
    }
    
    void SumaRep(){
        TestIntent.SumaRep();
    }
    Integer AgafaEstat(){
        int estat = TestIntent.AgafaEstat();
        return estat;
    }
    float CalculaNota(){
        float sum=0;
        for(Map.Entry<String, Avaluacio> mO : this.DirAvaluacio.entrySet()){
            sum=sum+mO.getValue().getCorrecte();}
        this.Nota =sum*10/TestIntent.DirPregunta.size();
        return this.Nota;
    }
    
    

    public float getNota() {
        return Nota;
    }
    public Test getTestIntent() {
        return TestIntent;
    }
}
