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
public class Eucatex {
    private int id;
    private String tipo;
    private double alturaChapa;
    private double comprimentoChapa;
    private int quantidadeChapa;
    private double precoCusto;
    
    public Eucatex(){
        this.id = -1;
        this.tipo = "";
        this.alturaChapa = -1.0;
        this.comprimentoChapa = -1.0;
        this.quantidadeChapa = -1;
        this.precoCusto = -1.0;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the alturaChapa
     */
    public double getAlturaChapa() {
        return alturaChapa;
    }

    /**
     * @param alturaChapa the alturaChapa to set
     */
    public void setAlturaChapa(double alturaChapa) {
        this.alturaChapa = alturaChapa;
    }

    /**
     * @return the comprimentoChapa
     */
    public double getComprimentoChapa() {
        return comprimentoChapa;
    }

    /**
     * @param comprimentoChapa the comprimentoChapa to set
     */
    public void setComprimentoChapa(double comprimentoChapa) {
        this.comprimentoChapa = comprimentoChapa;
    }

    /**
     * @return the quantidadeChapa
     */
    public int getQuantidadeChapa() {
        return quantidadeChapa;
    }

    /**
     * @param quantidadeChapa the quantidadeChapa to set
     */
    public void setQuantidadeChapa(int quantidadeChapa) {
        this.quantidadeChapa = quantidadeChapa;
    }

    /**
     * @return the precoCusto
     */
    public double getPrecoCusto() {
        return precoCusto;
    }

    /**
     * @param precoCusto the precoCusto to set
     */
    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }
}
