/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author felip
 */
public class Vidro {
    private int id;
    private String tipo;
    private double alturaChapa;
    private double comprimentoChapa;
    private int espessuraChapa;//Milímetros
    private int quantidadeChapas;
    private double precoCusto;// Por metro quadrado
    
    
    public Vidro(){
        this.id = -1;
        this.tipo = "";
        this.alturaChapa = -1.0;
        this.comprimentoChapa = -1.0;
        this.espessuraChapa = -1;
        this.quantidadeChapas = -1;
        this.precoCusto = -1.0;
    }
}
