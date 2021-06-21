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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getAlturaChapa() {
        return alturaChapa;
    }

    public void setAlturaChapa(double alturaChapa) {
        this.alturaChapa = alturaChapa;
    }

    public double getComprimentoChapa() {
        return comprimentoChapa;
    }

    public void setComprimentoChapa(double comprimentoChapa) {
        this.comprimentoChapa = comprimentoChapa;
    }

    public int getEspessuraChapa() {
        return espessuraChapa;
    }

    public void setEspessuraChapa(int espessuraChapa) {
        this.espessuraChapa = espessuraChapa;
    }

    public int getQuantidadeChapas() {
        return quantidadeChapas;
    }

    public void setQuantidadeChapas(int quantidadeChapas) {
        this.quantidadeChapas = quantidadeChapas;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }
}
