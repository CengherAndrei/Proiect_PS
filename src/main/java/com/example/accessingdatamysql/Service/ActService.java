package com.example.accessingdatamysql.Service;

import com.example.accessingdatamysql.Model.Act;

import java.util.List;

/**
 * Interfata care declara metodele aplicate pe tabelul Act
 */
public interface ActService {
    /**
     * @param act
     * @return Act
      */
    Act addNewAct(Act act);
    /**
     * @return List<Act>
     */
    List<Act> getAllActe();
    /**
     * @param id_act
     * @return Iterable<Act>
     */
    Iterable<Act> deleteAct(Integer id_act);
    /**
     * @param id_act
     * @return Act
     */
    Act getActById(Integer id_act);
}
