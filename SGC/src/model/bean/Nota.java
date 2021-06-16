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
public class Nota {
    private int id;
    private String dataEntrega;
    private String dataNota;
    private int desconto;
    private double valorTotal;
    private double valorEntrada;
    private String formaPagamento;
    private String statusPagamento;
    private String dataEncerramento;
    
    public Nota(){
        this.id = -1;
        this.dataEntrega = "";
        this.dataNota = "";
        this.desconto = -1;
        this.valorTotal = -1.0;
        this.valorEntrada = -1.0;
        this.formaPagamento = "";
        this.statusPagamento = "";
        this.dataEncerramento = "";
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
     * @return the dataEntrega
     */
    public String getDataEntrega() {
        return dataEntrega;
    }

    /**
     * @param dataEntrega the dataEntrega to set
     */
    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    /**
     * @return the dataNota
     */
    public String getDataNota() {
        return dataNota;
    }

    /**
     * @param dataNota the dataNota to set
     */
    public void setDataNota(String dataNota) {
        this.dataNota = dataNota;
    }

    /**
     * @return the desconto
     */
    public int getDesconto() {
        return desconto;
    }

    /**
     * @param desconto the desconto to set
     */
    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }

    /**
     * @return the valorTotal
     */
    public double getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * @return the valorEntrada
     */
    public double getValorEntrada() {
        return valorEntrada;
    }

    /**
     * @param valorEntrada the valorEntrada to set
     */
    public void setValorEntrada(double valorEntrada) {
        this.valorEntrada = valorEntrada;
    }

    /**
     * @return the formaPagamento
     */
    public String getFormaPagamento() {
        return formaPagamento;
    }

    /**
     * @param formaPagamento the formaPagamento to set
     */
    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    /**
     * @return the statusPagamento
     */
    public String getStatusPagamento() {
        return statusPagamento;
    }

    /**
     * @param statusPagamento the statusPagamento to set
     */
    public void setStatusPagamento(String statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    /**
     * @return the dataEncerramento
     */
    public String getDataEncerramento() {
        return dataEncerramento;
    }

    /**
     * @param dataEncerramento the dataEncerramento to set
     */
    public void setDataEncerramento(String dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }
}
