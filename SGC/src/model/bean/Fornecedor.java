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
public class Fornecedor {

   
    private String cnpj;
    private String nome;
    private String descricao;
    private String email;
    private List<Endereco> listaEndereco;
    private List<String> listaTelefone;
    
    public Fornecedor(){
        this.cnpj = "";
        this.nome = "";
        this.descricao = "";
        this.email = "";
        this.listaEndereco = new ArrayList<>();
        this.listaTelefone = new ArrayList<>();
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
}
