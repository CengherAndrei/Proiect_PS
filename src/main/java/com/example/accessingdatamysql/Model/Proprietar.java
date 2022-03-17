package com.example.accessingdatamysql.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Clasa pentru modelul Proprietar din baza de date
 */
@Entity
public class Proprietar {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Integer idProprietar;
    String nume;
    String CNP;
    String adresa;
    String nrTelefon;
    String email;

    public Proprietar() {

    }
    /**
     * @param nume
     * @param CNP
     * @param adresa
     * @param nrTelefon
     * @param email
     */
    public Proprietar(String nume, String CNP, String adresa, String nrTelefon, String email) {
        this.nume = nume;
        this.CNP = CNP;
        this.adresa = adresa;
        this.nrTelefon = nrTelefon;
        this.email = email;
    }
    /**
     * @return Integer
     */
    public Integer getIdProprietar() {
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
    public String getNume() {
        return nume;
    }
    /**
     * @param nume
     */
    public void setNume(String nume) {
        this.nume = nume;
    }
    /**
     * @return String
     */
    public String getCNP() {
        return CNP;
    }
    /**
     * @param CNP
     */
    public void setCNP(String CNP) {
        this.CNP = CNP;
    }
    /**
     * @return String
     */
    public String getAdresa() {
        return adresa;
    }
    /**
     * @param adresa
     */
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
    /**
     * @return String
     */
    public String getNrTelefon() {
        return nrTelefon;
    }
    /**
     * @param nrTelefon
     */
    public void setNrTelefon(String nrTelefon) {
        this.nrTelefon = nrTelefon;
    }
    /**
     * @return String
     */
    public String getEmail() {
        return email;
    }
    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
