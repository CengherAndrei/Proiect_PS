package com.example.accessingdatamysql.Service;

import com.example.accessingdatamysql.Repository.MasinaRepository;
import com.example.accessingdatamysql.Model.Masina;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * Implementarea interfetei MasinaService
 */
@Service
public class MasinaServiceImpl implements MasinaService {

    MasinaRepository masinaRepository;

    /**
     * @param masinaRepository
     */
    public MasinaServiceImpl(MasinaRepository masinaRepository)
    {
        this.masinaRepository = masinaRepository;
    }

    /**
     * @param masina
     * @return Masina
     */
    public Masina addNewMasina (Masina masina) {
        return masinaRepository.save(masina);
    }

    /**
     * @return List<Masina>
     */
    public List<Masina> getAllMasini() {
        // This returns a JSON or XML with the users
        List<Masina> masini = new ArrayList<>();
        masinaRepository.findAll().forEach(masini::add);
        return masini;
    }
    /**
     * @param serie
     * @return Masina
     */
    public Masina getMasinaBySerie(String serie) {
        return masinaRepository.findById(serie).get();
    }
    /**
     * @param serie
     * @return Iterable<Masina>
     */
    public void deleteMasina(String serie) {
        masinaRepository.deleteById(serie);
    }
}
