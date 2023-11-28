package implementacio;
import java.util.Scanner;
import java.util.Map;
/**
 *
 * @author Joa
 */
public class Implementacio {
    public static boolean nomPreguntaValid(K k, String enu) {
	return (k.DirPregunta.get(enu) == null);
    }
    public static boolean NivellValid(K k, String niv) {
	return (k.DirNivell.get(niv) == null);
    }
    public static boolean NivellValidInsert(K k, String niv){
        return(k.PreguntaDiferenciada.DirNivell.get(niv)==null);
    }
    public static boolean CategoriaValid(K k, String cat) {
	return (k.DirCategoria.get(cat) == null);
    }
    public static boolean CategoriaValidInsert(K k, String cat){
        return(k.PreguntaDiferenciada.DirCategoria.get(cat)==null);
    }
    public static boolean SolucioValidInsert(K k, int sol){
        return(k.PreguntaDiferenciada.DirResposta.get(sol)==null);
    }
    public static boolean ProfessorValid(K k,String IdPro){
        return(k.DirProfessor.get(IdPro)==null);
    }
    public static boolean TestValid(K k,Integer num,String IdPro){
        return(k.DirProfessor.get(IdPro).DirTest.get(num)==null);
    }
    public static boolean GrupValid(K k,String Criteri,String IdPro){
        return(k.DirProfessor.get(IdPro).DirGrup.get(Criteri)==null);
    }
    public static boolean EstudiantValid(K k,String  nom){
        return(k.DirEstudiant.get(nom)==null);
    }
    public static boolean OrdinalValid(K k,String IdPreg,Integer ord){
        return (k.DirPregunta.get(IdPreg).DirResposta.get(ord)==null);
    }
    
    
    
    public static void mostraPreguntes(K k) {
	System.out.print("----------LLISTAT DE PREGUNTES AL SISTEMA!----------\n");
 	System.out.print("----------------------------------------------------\n");
                   	//MODIFICAR LA DIFERENCIACION , QUE SE ME HA OLVIDADO QUITARLO :(
	for(Map.Entry<String, Pregunta> mO : k.DirPregunta.entrySet()) {
            System.out.println("Enunciat: "+mO.getKey() + " | Descripcio: "+mO.getValue().getDes()+" Text: "+mO.getValue().getTex()+"\n");     
                for(Map.Entry<String, Nivell> mO2 : mO.getValue().DirNivell.entrySet()) {
                System.out.println("    Nivell "+mO2.getKey()+"\n");
                }
                for(Map.Entry<String, Categoria> mO3 : mO.getValue().DirCategoria.entrySet()) {
                System.out.println("    Categoria "+mO3.getKey()+"\n");
                }
                for(Map.Entry<Integer, Resposta> mO4 : mO.getValue().DirResposta.entrySet()) {
                    System.out.println("        Ordinal: "+mO4.getKey()+" Text: "+ mO4.getValue().getText()+"\n" );
                }
                System.out.println("    SOLUCIO: "+ mO.getValue().getSolucioResposta().getOrdinal()+" ---> "+mO.getValue().getSolucioResposta().getText()+"\n");
        }
        
        
    }
    public static void mostraTests(K k) {
	System.out.print("----LLISTAT DE PROFES AMB EL SEUS TEST AL SISTEMA!----\n");
 	System.out.print("------------------------------------------------------\n");
                   	
	for(Map.Entry<String, Professor> mO : k.DirProfessor.entrySet()) {
            System.out.println("DNI PROFESSOR: "+mO.getKey());    
            Professor Var=mO.getValue();
            for(Map.Entry<Integer, Test> mO2 : Var.DirTest.entrySet()) {
                System.out.println("    NumeroID test: "+mO2.getKey());   
                Test Var2=mO2.getValue();
                for(Map.Entry<String, Pregunta> mO3 : Var2.DirPregunta.entrySet()) {
                    Pregunta prep=mO3.getValue();
                    System.out.println("        Pregunta -->"+mO3.getKey());    
                    System.out.println("            Aparicions:"+prep.getAparicions());
                }
            }
        }  
    }
    public static void mostraPermisos(K k){
        System.out.print("----LLISTAT DE TESTOS AMB EL GRUPS AMB PERMIS AL SISTEMA!----\n");
 	System.out.print("------------------------------------------------------\n");
	for(Map.Entry<String, Professor> mO : k.DirProfessor.entrySet()) {        
        System.out.println("DNI PROFESSOR: "+mO.getKey());    
            Professor Var=mO.getValue();
            for(Map.Entry<Integer, Test> mO2 : Var.DirTest.entrySet()) {
                System.out.println("    NumeroID test: "+mO2.getKey());   
                Test Var2=mO2.getValue();
                if(Var2.getEstat()==0)System.out.println("          Historic: False");
                else System.out.println("          Historic: True");
                System.out.println("    GRUPS AMB PERMIS SOBRE AQUEST TEST -->");
                for(Map.Entry<String, Grup> mO3 : Var2.DirGrup.entrySet()){
                    Grup var3=mO3.getValue();
                    System.out.println("        "+var3.getCriteri());
                }
            }
        }
       
    }
    public static void mostraGrups(K k){
        System.out.print("----LLISTAT DE GRUPS AL SISTEMA!----\n");
        System.out.print("------------------------------------------------------\n");
        for(Map.Entry<String, Grup> mO : k.DirGrup.entrySet()) {        
            System.out.println("Criteri: "+mO.getKey());    
        }
        for(Map.Entry<String, Professor> mO : k.DirProfessor.entrySet()) {        
        System.out.println("DNI PROFESSOR: "+mO.getKey());    
            Professor Var=mO.getValue();
            for(Map.Entry<Integer, Test> mO2 : Var.DirTest.entrySet()) {
                System.out.println("    NumeroID test: "+mO2.getKey());   
                Test Var2=mO2.getValue();
                if(Var2.getEstat()==0)System.out.println("          Historic: False");
                else System.out.println("          Historic: True");
            }
        }
        
    }
    public static void mostraAvaluacions(K k){
        System.out.print("----LLISTAT DE INTENTS GUARDATS(NO HISTORICS) AMB NOTA AL SISTEMA!----\n");
        System.out.print("------------------------------------------------------\n");
        for(Map.Entry<String, Estudiant> mO : k.DirEstudiant.entrySet()) {        
            System.out.println("nom Estudiant: "+mO.getKey());    
            Estudiant Var=mO.getValue();
            for(Map.Entry<Integer, Intent> mO2 : Var.DirIntent.entrySet()) {
                System.out.println("    DNI Profe creador: "+mO2.getValue().getTestIntent().getProfessorCreador().getDNI());
                System.out.println("        Numero Test: "+mO2.getValue().getTestIntent().getNumero());   
                System.out.println("        Nota Intent: "+mO2.getValue().getNota());   
            }
        }  
        
        
        
    }
    public static void moltaBrossa(K k){
        k.IdPreg("Suma2+2","Una simple suma... Tendria que ser facil no?","Cuanto es 2+2");
        k.NivPreg("basico");
        k.CatPreg("mates");
        k.respostaPregunta("4");
        k.respostaPregunta("6");
        k.respostaPregunta("patatas");
        k.solucioPregunta(0);
        
        k.IdPreg("Suma4+4","Una simple suma... Tendria que ser facil no?","Cuanto es 4+4");
        k.NivPreg("basico");
        k.CatPreg("mates");
        k.respostaPregunta("2");
        k.respostaPregunta("8");
        k.respostaPregunta("Macarrones");
        k.solucioPregunta(1);
        
        k.IdPreg("Mul0x10","Una simple multiplicacion... Tendria que ser facil no?","Cuanto es 0x10");
        k.NivPreg("basico");
        k.CatPreg("mates");
        k.respostaPregunta("10");
        k.respostaPregunta("0");
        k.respostaPregunta("Profe , es demasiado dificil, jope.");
        k.solucioPregunta(1);
        
        k.IdPreg("Suma0+0","Una simple suma... Tendria que ser facil no?","Cuanto es 0+0");
        k.NivPreg("basico");
        k.CatPreg("mates");
        k.respostaPregunta("0");
        k.respostaPregunta("Infinito, lo he aprendido de JulioProfe");
        k.respostaPregunta("-1 (me lo he copiado de mi compañero)");
        k.solucioPregunta(0);
        //CREACIO TEST
        k.DadesTest("47264083A",1,"basico");
        k.PreguntaTest("Suma0+0");
        k.PreguntaTest("Suma4+4");
        k.FinalCreaTest();
        
        k.DadesTest("47264083A",2,"basico");
        k.PreguntaTest("Mul0x10");
        k.PreguntaTest("Suma4+4");
        k.FinalCreaTest();
        
        k.DadesTest("47264083A",3,"basico");
        k.PreguntaTest("Suma2+2");
        k.PreguntaTest("Suma4+4");
        k.FinalCreaTest();
        
        k.DadesTest("47264083A",4,"basico");
        k.PreguntaTest("Suma2+2");
        k.PreguntaTest("Mul0x10");
        k.FinalCreaTest();
    }

    //Esto será el MAIN
    public static void main(String[] args) {
        Integer counter=10;
        K k = new K();
        String introduirPregunta = "introduirPregunta";
        String creaTest = "creaTest";
        String donaPermis = "donaPermis";
        String avaluaEstudiant = "avaluaEstudiant";
        String novaNeteja = "novaNeteja";
        Scanner input = new Scanner(System.in);
        System.out.print("----------------------------------------------------------------\n");
        System.out.print("------------------------EXECUTABLE  AMEP------------------------\n");
        System.out.print("-------------------------REALITZAT  PER-------------------------\n");
        System.out.print("--------------------------JIA LE  CHEN--------------------------\n");
        System.out.print("----------------------CRISTINA SANCHEZ-MORA---------------------\n");
        System.out.print("-------------------------JOAQUIM HERVAS-------------------------\n");
        System.out.print("----------------------------------------------------------------\n");
        System.out.print("-----------------------COMANDES A EXECUTAR----------------------\n");
        System.out.print("--------------------- --> introduirPregunta --------------------\n");
        System.out.print("--------------------- --> creaTest -----------------------------\n");
        System.out.print("--------------------- --> donaPermis ---------------------------\n");
        System.out.print("--------------------- --> avaluaEstudiant ----------------------\n");
        System.out.print("--------------------- --> novaNeteja ---------------------------\n");
        System.out.print("----------------------------------------------------------------\n");
        System.out.print("<<IMPORTANT>> RECORDA ABANS D'EXECUTAR-HO LLEGIR EL README!!!!\n");

        // Solicitar entrada al usuario
        System.out.print("Quin CU vol executar?: ");
        String entrada = input.nextLine();
        //CREACIO DE  PREGUNTES
        moltaBrossa(k);
     
        
        while (!entrada.equals("sortir")) {
            if (entrada.equals(introduirPregunta)) {


                System.out.print("Executant introduirPregunta...\n");
                System.out.print("Introdueixi l'enunciat de la pregunta\n");
                String enu = input.nextLine();
                while(!nomPreguntaValid(k,enu)){
                    System.out.print("Ja existeix la pregunta :( Introdueixi l'enunciat de la pregunta\n");
                    enu = input.nextLine();
                }
                System.out.print("Introdueixi la descripció de la pregunta\n");
                String des = input.nextLine();
                System.out.print("Introdueixi el text de la pregunta\n");
                String tex = input.nextLine();
                //System.out.print("valors enu= "+enu+" des: "+des+" tex: "+tex);
                k.IdPreg(enu,des,tex);
                
                System.out.print("PREGUNTA CREADA CORRECTAMENT\n");

                
                String niv;
                String fi="";
                while(!fi.equals("S")){
                    System.out.print("Introdueixi el Nivell de la pregunta(basico,intermedio,avanzado)\n");
                    niv = input.nextLine();
                    while(NivellValid(k,niv) && NivellValidInsert(k,niv)){
                        System.out.print("No existeix el nivell :( Introdueix un altre Nivell (basico,intermedio,avanzado)\n");
                        niv = input.nextLine();
                    }
                    
                    k.NivPreg(niv);
                    
                    System.out.print("NIVELL AFEGIT CORRECTAMENT\n");
                    System.out.print("Has acabat  de introduir Nivells? Si (S) o No (N)\n");
                    fi = input.nextLine();     
                }
                fi="";
                String cat;
                while(!fi.equals("S")){
                    System.out.print("Introdueixi la categoria de la pregunta(mates,religion,lengua)\n");
                    cat = input.nextLine();
                    while(CategoriaValid(k,cat) && CategoriaValidInsert(k,cat)){
                        System.out.print("No existeix la categoria :( Introdueix un altre categoria (mates,religion,lengua)\n");
                        cat = input.nextLine();
                    }
                    System.out.print("CATEGORIA AFEGIDA CORRECTAMENT\n");
                    System.out.print("Has acabat  de introduir categories? Si (S) o No (N)\n");
                    fi = input.nextLine();
                    k.CatPreg(cat);
                }
                fi="";
                int aux=0;
                while(aux<=1 || !fi.equals("S")){
                    System.out.print("Introdueixi una resposta de la pregunta\n");
                    tex = input.nextLine();
                    System.out.print("RESPOSTA AFEGIDA CORRECTAMENT\n");
                    System.out.print(k.respostaPregunta(tex)+"\n");
                    if(aux>=1){
                        System.out.print("Has acabat  de introduir Respostes? Si (S) o No (N)\n");
                        fi = input.nextLine();     
                    }
                    ++aux;
                }
                System.out.print("Introdueix l'ordinal de la resposta correcta!\n");
                
                String sol = input.nextLine();
                while(SolucioValidInsert(k,Integer.parseInt(sol))){
                    System.out.print("Ordinal incorrecte. Introdueix un ordinal correcte \n");
                    sol = input.nextLine();
                }   
                k.solucioPregunta(Integer.valueOf(sol) );
                System.out.print("PREGUNTA COMPLETADA CORRECTAMENT!\n");
                
                mostraPreguntes(k);
            } 
            
            
            else if(entrada.equals(creaTest)){
                System.out.print("Executant creaTest...\n");
                System.out.print("Introdueix el Numero Identificatiu del Professor(47264083A,12345678A,123)...\n");
                String IdPro = input.nextLine();
                while(ProfessorValid(k,IdPro) ){
                    System.out.print("DNI del professor incorrecte... Introdueix el Numero Identificatiu del Professor...\n");
                    IdPro = input.nextLine(); 
                }
                Integer num=counter;
                ++counter;
                    
                System.out.print("Introdueix el Nom Identificatiu del Nivell...(basico,intermedio,avanzado)\n");
                String IdNiv = input.nextLine();
                while(NivellValid(k,IdNiv) ){
                    System.out.print("No existeix el nivell :( Introdueix un altre Nivell (basico,intermedio,avanzado)\n");
                    IdNiv = input.nextLine();
                }
                k.DadesTest(IdPro, num, IdNiv);
                String fi="";
                int aux=0;
                System.out.print("PREGUNTES DISPONIBLES AL SISTEMA: \n");
                for(Map.Entry<String, Pregunta> mO : k.DirPregunta.entrySet()) {
                    System.out.println("    -->"+mO.getKey()+"");
                }
                while(aux<=1 || !fi.equals("S")){
                    System.out.print("Introdueix el text Identificatiu de la Pregunta...\n");
                    String IdPreg = input.nextLine();

                    while(nomPreguntaValid(k,IdPreg) ){
                        System.out.print("No existeix la pregunta :( Introdueix un altre text Identificatiu de la Pregunta\n");
                        IdPreg = input.nextLine();
                    }
                    k.PreguntaTest(IdPreg);
                    if(aux>=1){
                        System.out.print("Has acabat  d'introduir Preguntes? Si (S) o No (N)\n");
                        fi = input.nextLine();     
                    }
                    ++aux;
                }
                k.FinalCreaTest();
                System.out.print("TEST CREAT CORRECTAMENT!!!!\n");
                mostraTests(k);     
            }
            else if(entrada.equals(donaPermis)){
                mostraPermisos(k);
                System.out.print("Executant donaPermis...\n");
                System.out.print("Introdueix el Numero Identificatiu del Professor(47264083A,12345678A,123)...\n");
                String IdPro = input.nextLine();
                while(ProfessorValid(k,IdPro) ){
                    System.out.print("DNI del professor incorrecte... Introdueix el Numero Identificatiu del Professor...(47264083A,12345678A,123)\n");
                    IdPro = input.nextLine(); 
                }
                System.out.println("LLista d'IDS dels tests!");
                for(Map.Entry<Integer, Test> mO : k.DirProfessor.get(IdPro).DirTest.entrySet()) {
                    System.out.println("    -->"+mO.getKey()+"");
                }
                System.out.print("Introdueix el Numero Identificatiu del Test...\n");
                String IdTest = input.nextLine();
                while(TestValid(k,Integer.valueOf(IdTest),IdPro)){
                    System.out.print("Valor Identificatiu del test ja existeix... Introdueix el Numero Identificatiu del Test...\n");
                    IdTest = input.nextLine();
                    
                }
                k.DadesPermis(IdPro,Integer.valueOf(IdTest));

                String fi="";
                while(!fi.equals("S")){
                    System.out.print("Introdueix el Criteri Identificatiu del Grup(primeroA,primeroB,sextoD)...\n");
                    String IdGru = input.nextLine();

                    while(GrupValid(k,IdGru,IdPro) ){
                    System.out.print("Criteri del grup incorrecte... Introdueix el Criteri Identificatiu del Grup(primeroA,primeroB,sextoD)...\n");
                    IdGru = input.nextLine(); 
                    }
                    k.PermisTest(IdGru);
                    System.out.print("Has acabat  d'introduir Grups? Si (S) o No (N)\n");
                    fi = input.nextLine();     
                }
                k.FinalDonaPermis();
                System.out.print("PERMISSOS CONCEDITS CORRECTAMENT!!!!\n");
                mostraPermisos(k);
                
            }
            else if(entrada.equals(avaluaEstudiant)){
                System.out.print("EXECUTANT AVALUA ESTUDIANT...\n");
                System.out.print("Introdueix el Nom Identificatiu de l'alumne(JoaquimHervas,Gelat,Cristina)...\n");
                String IdEst = input.nextLine();
                while(EstudiantValid(k,IdEst) ){
                    System.out.print("Nom incorrecte... Introdueix el Nom Identificatiu de l'alumne(JoaquimHervas,Gelat,Cristina)...\n");
                    IdEst = input.nextLine(); 
                }
                System.out.print("Introdueix el Numero Identificatiu del Professor(47264083A,12345678A,123)...\n");
                String IdPro = input.nextLine();
                while(ProfessorValid(k,IdPro) ){
                    System.out.print("DNI del professor incorrecte... Introdueix el Numero Identificatiu del Professor(47264083A,12345678A,123)...\n");
                    IdPro = input.nextLine(); 
                }
                System.out.println("LLista d'IDS dels tests!");
                for(Map.Entry<Integer, Test> mO : k.DirProfessor.get(IdPro).DirTest.entrySet()) {
                    System.out.println("    -->"+mO.getKey()+"");
                }
                System.out.print("Introdueix el Numero Identificatiu del Test...\n");
                String IdTest = input.nextLine();
                while(TestValid(k,Integer.valueOf(IdTest),IdPro)){
                    System.out.print("Valor Identificatiu del test ja existeix... Introdueix el Numero Identificatiu del Test...\n");
                    IdTest = input.nextLine();
                    
                }
                k.identificaEstTes(IdEst, Integer.valueOf(IdTest), IdPro);
                String fi="";
                System.out.println("LLista de preguntes del test!");
                for(Map.Entry<String, Pregunta> mO : k.DirProfessor.get(IdPro).DirTest.get(Integer.valueOf(IdTest)).DirPregunta.entrySet()) {
                    System.out.println("    -->"+mO.getKey()+"");
                }
                while(!fi.equals("S")){
                    
                    System.out.print("Introdueix el text Identificatiu de la Pregunta...\n");
                    String IdPreg = input.nextLine();

                    while(nomPreguntaValid(k,IdPreg) ){
                        System.out.print("No existeix la pregunta :( Introdueix un altre text Identificatiu de la Pregunta\n");
                        IdPreg = input.nextLine();
                    }
                    System.out.println("LLista de respostes del test!");
                    for(Map.Entry<Integer, Resposta> mO : k.DirProfessor.get(IdPro).DirTest.get(Integer.valueOf(IdTest)).DirPregunta.get(IdPreg).DirResposta.entrySet()) {
                        System.out.println("    -->"+mO.getKey()+" , "+mO.getValue().getText());
                    }
                    System.out.print("Introdueix l'ordinal Identificatiu de la Resposta...\n");
                    String ord = input.nextLine();

                    while(OrdinalValid(k,IdPreg,Integer.valueOf(ord)) ){
                    System.out.print("No existeix l'ordinal :( Introdueix un altre ordinal Identificatiu de la Resposta\n");
                    ord = input.nextLine();
                    }
                    k.responPreg(IdPreg,Integer.valueOf(ord));
                    System.out.print("Has acabat  de respondre Preguntes? Si (S) o No (N)\n");
                    fi = input.nextLine();    
                    System.out.print("PREGUNTES RESPOSTES CORRECTAMENT....AVALUANT-LES...\n");
                }
                System.out.print("-------------------------\n");
                System.out.print("-->NOTA DEL TEST: "+k.fiIntent()+"\n");
                System.out.print("-------------------------\n");  
                mostraAvaluacions(k);
            }
            else if(entrada.equals(novaNeteja)){
                System.out.print("ESCENARI PRE NETEJA!\n");
                mostraGrups(k);
                k.NovaNeteja();
                System.out.print("NETEJA REALITZADA CORRECTAMENT!\n");
                System.out.print("ESCENARI POST NETEJA!\n");
                mostraGrups(k);

            }
                
            
            
                
            
            
            
            System.out.print("----------------------------------------------------------------\n");
            System.out.print("-----------------------COMANDES A EXECUTAR----------------------\n");
            System.out.print("--------------------- --> introduirPregunta --------------------\n");
            System.out.print("--------------------- --> creaTest -----------------------------\n");
            System.out.print("--------------------- --> donaPermis ---------------------------\n");
            System.out.print("--------------------- --> avaluaEstudiant ----------------------\n");
            System.out.print("--------------------- --> novaNeteja ---------------------------\n");
            System.out.print("----------------------------------------------------------------\n");
            System.out.print("<<IMPORTANT>> RECORDA ABANS D'EXECUTAR-HO LLEGIR EL README!!!!\n");

            System.out.print("Quin CU vol executar?: ");
            entrada = input.nextLine();
        }

        // Cerrar el objeto Scanner
        input.close();
        
        
        
        
        
    }
}
