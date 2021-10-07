/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author felip
 */
public class Pedido {
    private int id;
    private double altura;
    private double largura;
    private double valorUnitario;
    private String tipo;
    private int quantidade;
    
    private String moldura;
    private List<String> listaPaspatu;
    private String vidro;
    private int idVidro;
    private String eucatex;
    private int idEucatex;
    private boolean entreVidros;
    
    public Pedido(){
        this.id = -1;
        this.altura = -1.0;
        this.largura = -1.0;
        this.valorUnitario = -1.0;
        this.tipo = "";
        this.quantidade = -1;
        
        this.moldura = "";
        this.listaPaspatu = new ArrayList<>();
        this.vidro = "";
        this.eucatex = "";
        this.entreVidros = false;
        this.idVidro = -1;
        this.idEucatex = -1;
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
     * @return the altura
     */
    public double getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(double altura) {
        this.altura = altura;
    }

    /**
     * @return the largura
     */
    public double getLargura() {
        return largura;
    }

    /**
     * @param largura the largura to set
     */
    public void setLargura(double largura) {
        this.largura = largura;
    }

    /**
     * @return the valorUnitario
     */
    public double getValorUnitario() {
        return valorUnitario;
    }

    /**
     * @param valorUnitario the valorUnitario to set
     */
    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
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
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getMoldura() {
        return moldura;
    }

    public void setMoldura(String moldura) {
        this.moldura = moldura;
    }

    public List<String> getListaPaspatu() {
        return listaPaspatu;
    }

    public void setListaPaspatu(List<String> pasp) {
        this.listaPaspatu = pasp;
    }

    public String getVidro() {
        return vidro;
    }

    public void setVidro(String vidro) {
        this.vidro = vidro;
    }

    public String getEucatex() {
        return eucatex;
    }

    public void setEucatex(String eucatex) {
        this.eucatex = eucatex;
    }

    public boolean isEntreVidros() {
        return entreVidros;
    }

    public void setEntreVidros(boolean entreVidros) {
        this.entreVidros = entreVidros;
    }

    public int getIdVidro() {
        return idVidro;
    }

    public void setIdVidro(int idVidro) {
        this.idVidro = idVidro;
    }

    public int getIdEucatex() {
        return idEucatex;
    }

    public void setIdEucatex(int idEucatex) {
        this.idEucatex = idEucatex;
    }
}
