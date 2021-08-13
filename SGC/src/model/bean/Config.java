/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Felipe
 */
public class Config {
    private double vidro_metro;
    private double eucatex_metro;
    private double espelho_metro;
    private double mao_de_obra;
    
    public Config(){
        this.vidro_metro = -1.0;
        this.eucatex_metro = -1.0;
        this.espelho_metro = -1.0;
        this.mao_de_obra = -1.0;
    }

    public double getVidro_metro() {
        return vidro_metro;
    }

    public void setVidro_metro(double vidro_metro) {
        this.vidro_metro = vidro_metro;
    }

    public double getEucatex_metro() {
        return eucatex_metro;
    }

    public void setEucatex_metro(double eucatex_metro) {
        this.eucatex_metro = eucatex_metro;
    }

    public double getEspelho_metro() {
        return espelho_metro;
    }

    public void setEspelho_metro(double espelho_metro) {
        this.espelho_metro = espelho_metro;
    }

    public double getMao_de_obra() {
        return mao_de_obra;
    }

    public void setMao_de_obra(double mao_de_obra) {
        this.mao_de_obra = mao_de_obra;
    }
}
