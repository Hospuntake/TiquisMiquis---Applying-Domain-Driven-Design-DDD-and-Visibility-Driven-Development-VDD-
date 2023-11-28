package implementacio;

/**
 *
 * @author Joa
 */
public class Historic {
    Nivell NivellHistoric;
    float NotaMitjana;
    int Reutilitzats;
    float nombre;
    
    Historic(Nivell niv){
        
        NivellHistoric=niv;
        this.NotaMitjana=0;
        this.Reutilitzats=0;
        this.nombre=0;
    }

    void ActualitzaNota(float nota){
        this.NotaMitjana=(NotaMitjana*nombre + nota )/nombre+1;
        ++nombre;
    }
    void SumaReut(){
        ++this.Reutilitzats;
    }
    
    

    public float getNotaMitjana() {
        return NotaMitjana;
    }

    public int getReutilitzats() {
        return Reutilitzats;
    }

    public float getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }
            
    
}
