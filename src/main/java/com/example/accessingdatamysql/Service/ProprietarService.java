package com.example.accessingdatamysql.Service;

import com.example.accessingdatamysql.Model.Proprietar;

import java.util.List;
/**
 * Interfata care declara metodele aplicate pe tabelul Proprietar
 */
public interface ProprietarService {
    /**
     * @param proprietar
     * @return Proprietar
     */
    Proprietar addNewProprietar(Proprietar proprietar);
    /**
     * @return List<Proprietar>
     */
    List<Proprietar> getAllProprietari();
    /**
     * @param idProprietar
     * @return Iterable<Proprietar>
     */
    Iterable<Proprietar> deleteProprietar(Integer idProprietar);
    /**
     * @param idProprietar
     * @return Proprietar
     */
    Proprietar getProprietarByID(Integer idProprietar);
}
