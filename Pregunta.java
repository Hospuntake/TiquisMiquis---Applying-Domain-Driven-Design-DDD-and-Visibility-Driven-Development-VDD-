package implementacio;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Joa
 */
public class Pregunta {
    String enu;
    String des;
    String tex;
    int Aparicions;
    HashMap<String,Nivell> DirNivell;
    HashMap<String,Categoria> DirCategoria;
    HashMap<Integer,Resposta> DirResposta;
    HashMap<Integer,Test> DirTest;
    Resposta SolucioResposta;
    int auxOrdinal;
    

    
    Pregunta(String enu,String des,String tex){
        this.enu=enu;
        this.des=des;
        this.tex=tex;
        this.Aparicions=0;
        SolucioResposta=null;
        DirNivell = new HashMap<String, Nivell>();	
	DirCategoria = new HashMap<String, Categoria>();
	DirResposta = new HashMap<Integer, Resposta>();
        DirTest = new HashMap<Integer, Test>();
        auxOrdinal=0;
    }
    
    
    
    
    //---------------INTRODUIR PREGUNTA---------------
    void NivPreg(Nivell niv){
        niv.sumaPreg(this);
        DirNivell.put(niv.getCurs(),niv);
    }
    void catPreg(Categoria cat){
        cat.sumaCat(this);
        DirCategoria.put(cat.getTema(),cat);
    }
    int respostaPregunta(String tex){
        Resposta Res = new Resposta(auxOrdinal,tex,this);
        ++auxOrdinal;
        DirResposta.put(Res.getOrdinal(),Res);
        return Res.getOrdinal();
    }
    void solucioPregunta(Integer sol){
        SolucioResposta=DirResposta.get(sol);
    }
    //---------------INTRODUIR PREGUNTA---------------
    void AfegirTest(Test T){
        ++this.Aparicions;
        DirTest.put(T.getNumero(), T);
    }
    
    
    //------------------------------------------------    
    //-------------AVALUA ESTUDIANT-------------------
    Resposta ResponPreg(Integer ord){
        return DirResposta.get(ord);
    }
    Integer teSolucio(){
        return SolucioResposta.getOrdinal();
    }
    
    
    
    
    //-------------AVALUA ESTUDIANT-------------------
    
    
    void SumaCat(Professor pf){
        for(Map.Entry<String, Categoria> mO : this.DirCategoria.entrySet()) {
            mO.getValue().PregCat(pf);//No se si aqui puede petarXD
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public String getEnu() {
        return enu;
    }

    public String getDes() {
        return des;
    }

    public Resposta getSolucioResposta() {
        return SolucioResposta;
    }

    public int getAparicions() {
        return Aparicions;
    }

    public String getTex() {
        return tex;
    }

}
