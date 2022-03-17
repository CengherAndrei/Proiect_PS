package com.example.accessingdatamysql.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
/**
 * Clasa pentru modelul Masina din baza de date
 */
@Entity
public class Masina {
    @Id
    String serie;
    int idProprietar;
    String marca;
    String model;
    int an_fabricatie;
    String culoare;
    int motor;
    String combustibil;

    public Masina() {

    }
    /**
     * @param idProprietar
     * @param SERIE
     * @param marca
     * @param model
     * @param an_fabricatie
     * @param culoare
     * @param motor
     * @param combustibil
     */
    public Masina(String SERIE, int idProprietar, String marca, String model, int an_fabricatie, String culoare, int motor, String combustibil) {
        this.serie = SERIE;
        this.idProprietar = idProprietar;
        this.marca = marca;
        this.model = model;
        this.an_fabricatie = an_fabricatie;
        this.culoare = culoare;
        this.motor = motor;
        this.combustibil = combustibil;
    }
    /**
     * @return String
     */
    public String getSERIE() {
        return serie;
    }
    /**
     * @param SERIE
     */
    public void setSERIE(String SERIE) {
        this.serie = SERIE;
    }
    /**
     * @return Int
     */
    public int getIdProprietar() {
        return idProprietar;
    }
    /**
     * @param idProprietar
     */
    public void setIdProprietar(int idProprietar) {
        this.idProprietar = idProprietar;
    }
    /**
     * @return String
     */
    public String getMarca() {
        return marca;
    }
    /**
     * @param marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }
    /**
     * @return String
     */
    public String getModel() {
        return model;
    }
    /**
     * @param model
     */
    public void setModel(String model) {
        this.model = model;
    }
    /**
     * @return Int
     */
    public int getAn_fabricatie() {
        return an_fabricatie;
    }
    /**
     * @param an_fabricatie
     */
    public void setAn_fabricatie(int an_fabricatie) {
        this.an_fabricatie = an_fabricatie;
    }
    /**
     * @return String
     */
    public String getCuloare() {
        return culoare;
    }
    /**
     * @param culoare
     */
    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }
    /**
     * @return Int
     */
    public int getMotor() {
        return motor;
    }
    /**
     * @param motor
     */
    public void setMotor(int motor) {
        this.motor = motor;
    }
    /**
     * @return String
     */
    public String getCombustibil() {
        return combustibil;
    }
    /**
     * @param combustibil
     */
    public void setCombustibil(String combustibil) {
        this.combustibil = combustibil;
    }
}
