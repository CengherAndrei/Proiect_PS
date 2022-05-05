package com.example.accessingdatamysql.Service;

import com.example.accessingdatamysql.Repository.ActRepository;
import com.example.accessingdatamysql.Model.Act;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementarea interfetei ActService
 */
@Service
public class ActServiceImpl implements ActService {

    ActRepository actRepository;

    /**
     * @param actRepository
     */
    public ActServiceImpl(ActRepository actRepository)
    {
        this.actRepository = actRepository;
    }
    /**
     * @param act
     * @return Act
     */
    public Act addNewAct (Act act) {
        return actRepository.save(act);
    }
    /**
     * @return List<Act>
     */
    public List<Act> getAllActe() {
        // This returns a JSON or XML with the users
        List<Act> acte = new ArrayList<>();
        actRepository.findAll().forEach(acte::add);
        return acte;
    }
    /**
     * @param id_act
     * @return Act
     */
    public Act getActById(Integer id_act) {
        if(actRepository.findById(id_act).get()!=null)
            return actRepository.findById(id_act).get();
        else
            return null;
    }
    /**
     * @param id_act
     * @return Iterable<Act>
     */
    public void deleteAct(Integer id_act) {
        actRepository.deleteById(id_act);

    }
}
