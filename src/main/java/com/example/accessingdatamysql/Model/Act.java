package com.example.accessingdatamysql.Model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
/**
 * Clasa pentru modelul Act din baza de date
 */
@Entity
public class Act {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    int idAct;
    String tipAct;
    String serie;
    Date valabil_de_la;
    Date valabil_pana_la;
    double pret;
    /**
     * @param idAct
     * @param SERIE
     * @param valabil_de_la
     * @param valabil_pana_la
     * @param tipAct
     * @param pret
     */
    public Act(int idAct, String tipAct, String SERIE, Date valabil_de_la, Date valabil_pana_la, double pret) {
        this.idAct = idAct;
        this.tipAct = tipAct;
        this.serie = SERIE;
        this.valabil_de_la = valabil_de_la;
        this.valabil_pana_la = valabil_pana_la;
        this.pret = pret;
    }
    public Act() {

    }
    /**
     * @return Int
     */
    public int getIdAct() {
        return idAct;
    }
    public void setIdAct(int idAct) {
        this.idAct = idAct;
    }
    /**
     * @return String
     */
    public String getTipAct() {
        return tipAct;
    }
    /**
     * @param tipAct
     */
    public void setTipAct(String tipAct) {
        this.tipAct = tipAct;
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
     * @return Date
     */
    public Date getValabil_de_la() {
        return valabil_de_la;
    }
    /**
     * @param valabil_de_la
     */
    public void setValabil_de_la(Date valabil_de_la) {
        this.valabil_de_la = valabil_de_la;
    }
    /**
     * @return Date
     */
    public Date getValabil_pana_la() {
        return valabil_pana_la;
    }
    /**
     * @param valabil_pana_la
     */
    public void setValabil_pana_la(Date valabil_pana_la) {
        this.valabil_pana_la = valabil_pana_la;
    }
    /**
     * @return Double
     */
    public double getpret() {
        return pret;
    }
    /**
     * @param pret
     */
    public void setpret(double pret) {
        this.pret = pret;
    }
}
