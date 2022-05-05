package com.example.accessingdatamysql.Service;

import com.example.accessingdatamysql.Model.*;
import com.example.accessingdatamysql.Repository.ProprietarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * Implementarea interfetei ProprietarService
 */
@Service

public class ProprietarServiceImpl implements ProprietarService {
    @Autowired
    ProprietarRepository ProprietarRepository;

    //ProprietarRepoDate proprietarRepoDate;
    //ReadData rd = new ReadData();
    //List<Proprietar> proprietars;

//    public ProprietarServiceImpl(ProprietarRepository ProprietarRepository)
//    {
//        this.ProprietarRepository = ProprietarRepository;
//    }

//    public ProprietarServiceImpl()
//    {
//        proprietars = rd.readFromFile();
//    }
//    /**
//     * @param proprietar
//     * @return Proprietar
//     */
    public Proprietar addNewProprietar (Proprietar proprietar) {
        return ProprietarRepository.save(proprietar);
//        return ProprietarRepository.save(proprietar);
//        proprietars.add(proprietar);
//        try {
//            rd.writeDataInFile(proprietar);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//        return proprietar;
//    }
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
    public Proprietar getProprietarByID(Integer idProprietar, EnumProprietari tip) {
        return ProprietarRepository.findById(idProprietar).get();
    }

    /**
     * @param idProprietar
     * @return Iterable<Proprietar>
     */
    public void deleteProprietar(Integer idProprietar) {

        ProprietarRepository.deleteById(idProprietar);
//        for(Proprietar pr:proprietars)
//        {
//            if(pr.getIdProprietar().equals(idProprietar))
//            {
//                proprietars.remove(pr);
//                try {
//                    rd.deleteProprietarInFile(pr);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                break;
//            }
//        }
//        return proprietars;
    }
}
