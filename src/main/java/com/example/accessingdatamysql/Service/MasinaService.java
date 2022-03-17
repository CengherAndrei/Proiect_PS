package com.example.accessingdatamysql.Service;

import com.example.accessingdatamysql.Model.Masina;

import java.util.List;
/**
 * Interfata care declara metodele aplicate pe tabelul Masina
 */
public interface MasinaService {

    /**
     * @param masina
     * @return Masina
     */
    Masina addNewMasina(Masina masina);
    /**
     * @return List<Masina>
     */
    List<Masina> getAllMasini();
    /**
     * @param serie
     * @return Iterable<Masina>
     */
    Iterable<Masina> deleteMasina(String serie);
    /**
     * @param serie
     * @return Masina
     */
    Masina getMasinaBySerie(String serie);
}
