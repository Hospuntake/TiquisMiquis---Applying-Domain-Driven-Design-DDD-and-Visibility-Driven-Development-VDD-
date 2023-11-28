
package implementacio;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Joa
 */
public class K {
    Pregunta PreguntaDiferenciada;
    Professor ProfessorDiferenciat;
    Estudiant EstudiantDiferenciat;
    HashMap<String,Pregunta> DirPregunta;
    HashMap<String,Nivell> DirNivell;
    HashMap<String,Categoria> DirCategoria;
    HashMap<String,Professor> DirProfessor;
    HashMap<String,Grup> DirGrup;
    HashMap<String,Estudiant> DirEstudiant;
    
    
    void MoltaBrossa(){
        Nivell basico=new Nivell("basico");
        Nivell intermedio=new Nivell("intermedio");
        Nivell avanzado=  new Nivell("avanzado")   ;   
           
        Categoria lengua=new Categoria("lengua");
        Categoria religion=new Categoria("religion");
        Categoria mates=new Categoria("mates");
        Estudiant uno=new Estudiant("JoaquimHervas",new Nivell("basico"));
        Estudiant dos=new Estudiant("Gelat",new Nivell("basico"));
        Estudiant tres=new Estudiant("Cristina",new Nivell("basico"));
        DirNivell.put("basico", basico);
        DirNivell.put("intermedio", intermedio);
        DirNivell.put("avanzado", avanzado);
        DirCategoria.put("lengua", lengua);
        DirCategoria.put("religion", religion);
        DirCategoria.put("mates", mates);
        Professor joa= new Professor("47264083A",DirCategoria);
        Professor cris=new Professor("12345678A",DirCategoria);
        Professor gelat=new Professor("123",DirCategoria);
        DirProfessor.put("47264083A",joa );
        DirProfessor.put("12345678A",cris );
        DirProfessor.put("123", gelat);
        DirEstudiant.put("JoaquimHervas", uno);
        DirEstudiant.put("Gelat", dos);
        DirEstudiant.put("Cristina",tres );
        DirGrup.put("primeroA", new Grup("primeroA",joa,new Nivell("basico")));
        DirGrup.put("primeroB", new Grup("primeroB",joa,new Nivell("basico")));
        DirGrup.put("sextoD", new Grup("sextoD",joa,new Nivell("intermedio")));
    }
    K(){
        this.PreguntaDiferenciada = null;
        this.ProfessorDiferenciat = null;
        EstudiantDiferenciat = null;
        DirPregunta = new HashMap<String,Pregunta>();
        DirNivell = new HashMap<String,Nivell>();
        DirCategoria = new HashMap<String,Categoria>();
        DirGrup = new  HashMap<String,Grup>();
        DirProfessor = new HashMap<String,Professor>();
        DirEstudiant = new HashMap<String,Estudiant>();
        MoltaBrossa();
    }
    
    //---------------INTRODUIR PREGUNTA---------------
    void IdPreg(String enu,String des,String tex){
        PreguntaDiferenciada=new Pregunta(enu,des,tex);
        DirPregunta.put(enu,PreguntaDiferenciada );
    }
    void NivPreg(String idniv){
        Nivell niv =DirNivell.get(idniv);
        PreguntaDiferenciada.NivPreg(niv);
    }
    void CatPreg(String idcat){
        Categoria cat =DirCategoria.get(idcat);
        PreguntaDiferenciada.catPreg(cat);
    }
    int respostaPregunta(String tex){
        return PreguntaDiferenciada.respostaPregunta(tex);
    }
    void solucioPregunta(Integer sol){
        PreguntaDiferenciada.solucioPregunta(sol);
        PreguntaDiferenciada=null;
    }

    //---------------INTRODUIR PREGUNTA---------------
    //------------------------------------------------
    //---------------CREA TEST------------------------
    void DadesTest(String IdPro,Integer num,String IdNiv){
        ProfessorDiferenciat =DirProfessor.get(IdPro);
        Nivell niv = DirNivell.get(IdNiv);
        ProfessorDiferenciat.DadesTest(num,niv);
    }
    void PreguntaTest(String IdPreg){
        Pregunta pre=DirPregunta.get(IdPreg);
        ProfessorDiferenciat.PreguntaTest(pre);
    }
    void FinalCreaTest(){
        ProfessorDiferenciat.FinalCreaTest();
        ProfessorDiferenciat=null;
    }
    //---------------CREA TEST------------------------
    //------------------------------------------------    
    //---------------DONA PERMIS----------------------
    void DadesPermis(String IdPro,Integer IdTest){
        ProfessorDiferenciat=DirProfessor.get(IdPro);
        ProfessorDiferenciat.DadesPermis(IdTest);    
    }
    void PermisTest(String IdGru){
        
        ProfessorDiferenciat.PermisTest(IdGru);
        
    }
    void FinalDonaPermis(){
        ProfessorDiferenciat.FinalDonaPermis();
        ProfessorDiferenciat=null;
    }
    
    
    //---------------DONA PERMIS----------------------
    //------------------------------------------------    
    //-------------AVALUA ESTUDIANT-------------------
    
    
    void identificaEstTes(String IdEst,Integer IdTes,String IdPro){
        EstudiantDiferenciat=DirEstudiant.get(IdEst);
        Professor pro=DirProfessor.get(IdPro);
        EstudiantDiferenciat.IdentificaTes(IdTes,pro);
    }
    void responPreg(String IdPre,Integer ord){
        Pregunta pre=DirPregunta.get(IdPre);
        Resposta res=pre.ResponPreg(ord);
        EstudiantDiferenciat.responPreg(pre,res);
    }
    float fiIntent(){
        float nota = EstudiantDiferenciat.fiIntent();
        EstudiantDiferenciat=null;
        return nota;
    }
    //-------------AVALUA ESTUDIANT-------------------
    //------------------------------------------------    
    //------------------NETEJA------------------------
    void NovaNeteja(){
        DirGrup = new  HashMap<String,Grup>();  
        for(Map.Entry<String, Professor> mO : DirProfessor.entrySet()) mO.getValue().CanviaEstat();
        for(Map.Entry<String, Nivell> mO : DirNivell.entrySet()) mO.getValue().EsborraNivellActual();
        
        
    }      
    //------------------NETEJA------------------------
        
    

    
}
