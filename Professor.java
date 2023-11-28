package implementacio;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Joa
 */
public class Professor {
    String DNI;
    HashMap<Integer,Test> DirTest;
    Test TestDiferenciat;
    HashMap<String,Grup> DirGrup;//Hay que generarlo en el MAIN o donde sea!!!!
//HACER EN CREA TEST HASHMAP TOTALS!!! EL CREADOR ES EL PROFE!!!SEGUIR DISEÑIO PLS
    HashMap<String,Totals> DirTotals;//Hay que generarlo en el MAIN o donde sea!!!!

    Professor(String DNI,HashMap<String,Categoria> DirCategoria){
        this.DNI=DNI;
        DirTest = new HashMap<Integer,Test>();
        this.TestDiferenciat=null;
        DirGrup = new HashMap<String,Grup>();
        DirTotals  = new HashMap<String,Totals>();
        DirGrup.put("primeroA", new Grup("primeroA",this,new Nivell("basico")));
        DirGrup.put("primeroB", new Grup("primeroB",this,new Nivell("basico")));
        DirGrup.put("sextoD", new Grup("sextoD",this,new Nivell("intermedio")));
        for(Map.Entry<String, Categoria> mO : DirCategoria.entrySet()) {
            Categoria cate=mO.getValue();
            DirTotals.put(cate.getTema(),new Totals(cate)   );
        }
    }
    
    //------------------------------------------------
    //---------------CREA TEST------------------------
    void DadesTest(Integer num,Nivell niv){
        TestDiferenciat = new Test(num,this,niv);
        DirTest.put(num,TestDiferenciat);
        niv.afegirTest(TestDiferenciat);
    }
    void PreguntaTest(Pregunta pre){
        TestDiferenciat.PreguntaTest(pre);
        pre.SumaCat(this);
    }
    void FinalCreaTest(){
        TestDiferenciat=null;
    }
    Totals buscaTot(Categoria cat){
        return DirTotals.get(cat.getTema());
    }
    //---------------CREA TEST------------------------
     //------------------------------------------------    
    //---------------DONA PERMIS----------------------
    void DadesPermis(Integer IdTest){
        TestDiferenciat=DirTest.get(IdTest);
    }
    void PermisTest(String IdGru){
        Grup gru=DirGrup.get(IdGru);
        TestDiferenciat.PermisTest(gru);
    }
    void FinalDonaPermis(){
        TestDiferenciat=null;
    }
    //---------------DONA PERMIS----------------------
    //------------------------------------------------
    //-------------AVALUA ESTUDIANT-------------------
    Test AgafaTest(int IdTes){
        return DirTest.get(IdTes);
    }
    
    
    
    //-------------AVALUA ESTUDIANT-------------------
     //------------------------------------------------    
    //------------------NETEJA------------------------
    void CanviaEstat(){
        for(Map.Entry<Integer, Test> mO : DirTest.entrySet()) mO.getValue().CanviaEstat();
    }
    
    
    
    
    public String getDNI() {
        return DNI;
    }
    
}
