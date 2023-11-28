/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementacio;

/**
 *
 * @author Joa
 */
public class Resposta {
    int Ordinal;
    String text;
    Pregunta PreguntaResposta;
    
    Resposta(int Ordinal,String text,Pregunta res){
        PreguntaResposta=res;
        this.Ordinal=Ordinal;
        this.text=text;
    }

    
    
    
    public int getOrdinal() {
        return Ordinal;
    }

    public String getText() {
        return text;
    }
    
}
