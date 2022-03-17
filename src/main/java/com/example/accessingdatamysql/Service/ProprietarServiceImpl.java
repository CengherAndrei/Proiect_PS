package com.example.accessingdatamysql.Service;

import com.example.accessingdatamysql.Model.Proprietar;
import com.example.accessingdatamysql.Repository.ProprietarRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * Implementarea interfetei ProprietarService
 */
@Service
public class ProprietarServiceImpl implements ProprietarService {

    com.example.accessingdatamysql.Repository.ProprietarRepository ProprietarRepository;
    /**
     * @param ProprietarRepository
     */
    public ProprietarServiceImpl(ProprietarRepository ProprietarRepository)
    {
        this.ProprietarRepository = ProprietarRepository;
    }
    /**
     * @param proprietar
     * @return Proprietar
     */
    public Proprietar addNewProprietar (Proprietar proprietar) {
        return ProprietarRepository.save(proprietar);
    }

    /**
     * @return List<Proprietar>
     */
    public List<Proprietar> getAllProprietari() {
        // This returns a JSON or XML with the users
        List<Proprietar> proprietars = new ArrayList<>();
        ProprietarRepository.findAll().forEach(proprietars::add);
        return proprietars;
    }
    /**
     * @param idProprietar
     * @return Proprietar
     */
    public Proprietar getProprietarByID(Integer idProprietar) {
        return ProprietarRepository.findById(idProprietar).get();
    }

    /**
     * @param idProprietar
     * @return Iterable<Proprietar>
     */
    public Iterable<Proprietar> deleteProprietar(Integer idProprietar) {
        // This returns a JSON or XML with the users
        Proprietar pr = ProprietarRepository.findById(idProprietar).orElseThrow();
        ProprietarRepository.delete(pr);
        System.out.println("Deleted");
        return ProprietarRepository.findAll();
    }
}
