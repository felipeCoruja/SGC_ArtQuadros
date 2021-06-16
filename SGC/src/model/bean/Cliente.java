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
public class Cliente {

   
    private int id;
    private String nome;
    private String cpf;
    private String IncEstadual;
    private String cnpj;
    private String email;
    private List<String> listaTelefone;
    private List<Endereco> listaEndereco;
    
    
    public Cliente(){
        this.id = -1;
        this.nome = "";
        this.cpf = "";
        this.IncEstadual = "";
        this.cnpj = "";
        this.email = "";
        this.listaTelefone = new ArrayList<>();
        this.listaEndereco = new ArrayList<>();
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
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the IncEstadual
     */
    public String getIncEstadual() {
        return IncEstadual;
    }

    /**
     * @param IncEstadual the IncEstadual to set
     */
    public void setIncEstadual(String IncEstadual) {
        this.IncEstadual = IncEstadual;
    }

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the listaTelefone
     */
    public List<String> getListaTelefone() {
        return listaTelefone;
    }

    /**
     * @param listaTelefone the listaTelefone to set
     */
    public void setListaTelefone(List<String> listaTelefone) {
        this.listaTelefone = listaTelefone;
    }

    /**
     * @return the listaEndereco
     */
    public List<Endereco> getListaEndereco() {
        return listaEndereco;
    }

    /**
     * @param listaEndereco the listaEndereco to set
     */
    public void setListaEndereco(List<Endereco> listaEndereco) {
        this.listaEndereco = listaEndereco;
    }
}
