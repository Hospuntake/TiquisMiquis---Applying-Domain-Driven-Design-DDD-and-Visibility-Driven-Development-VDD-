/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementacio;

/**
 *
 * @author Joa
 */
public class Totals {
    Categoria CategoriaCreadora;
    Integer Vegades;
    
    Totals(Categoria CategoriaCreador){
        this.CategoriaCreadora=CategoriaCreador;
        this.Vegades=0; 
    }
    
    
    void sumaVegades(){
       ++this.Vegades;
    }
}
