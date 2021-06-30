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
public class Moldura {
    private String id;
    private String cor;
    private String material;
    private String descricao;
    private double quantMetros;
    private double comprimentoVara;
    private double larguraVara;
    private double precoCusto;
    private double precoVenda;

    public Moldura() {
        this.id = "";
        this.cor = "";
        this.material = "";
        this.descricao = "";
        this.quantMetros = -1.0;
        this.comprimentoVara = -1.0;
        this.larguraVara = -1.0;
        this.precoCusto = -1.0;
        this.precoVenda = -1.0;
    } 

    public Moldura(Moldura m) {
        this.id = m.getId();
        this.cor = m.getCor();
        this.material = m.getMareial();
        this.descricao = m.getDescricao();
        this.quantMetros = m.getQuantMetros();
        this.comprimentoVara = m.getComprimentoVara();
        this.larguraVara = m.getLarguraVara();
        this.precoCusto = m.getPrecoCusto();
        this.precoVenda = m.getPrecoVenda();
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the cor
     */
    public String getCor() {
        return cor;
    }

    /**
     * @param cor the cor to set
     */
    public void setCor(String cor) {
        this.cor = cor;
    }

    /**
     * @return the mareial
     */
    public String getMareial() {
        return material;
    }

    /**
     * @param mareial the mareial to set
     */
    public void setMareial(String mareial) {
        this.material = mareial;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the quantMetros
     */
    public double getQuantMetros() {
        return quantMetros;
    }

    /**
     * @param quantMetros the quantMetros to set
     */
    public void setQuantMetros(double quantMetros) {
        this.quantMetros = quantMetros;
    }

    /**
     * @return the comprimentoVara
     */
    public double getComprimentoVara() {
        return comprimentoVara;
    }

    /**
     * @param comprimentoVara the comprimentoVara to set
     */
    public void setComprimentoVara(double comprimentoVara) {
        this.comprimentoVara = comprimentoVara;
    }

    /**
     * @return the larguraVara
     */
    public double getLarguraVara() {
        return larguraVara;
    }

    /**
     * @param larguraVara the larguraVara to set
     */
    public void setLarguraVara(double larguraVara) {
        this.larguraVara = larguraVara;
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

    /**
     * @return the precoVenda
     */
    public double getPrecoVenda() {
        return precoVenda;
    }

    /**
     * @param precoVenda the precoVenda to set
     */
    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }
}
