package implementacio;

/**
 *
 * @author Joa
 */
public class Avaluacio {
    int correcte;
    Resposta RespostaAvaluacio;
    
    Avaluacio(Integer Ordcorrecte,Resposta res){
        if(res.getOrdinal()==Ordcorrecte)correcte=1;
        else correcte=0;        
        RespostaAvaluacio=res;
    }

    public int getCorrecte() {
        return correcte;
    }
    
}
