package com.example.accessingdatamysql.Controller;

import com.example.accessingdatamysql.Model.Masina;
import com.example.accessingdatamysql.Service.MasinaService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Apeleaza clasele din business logic (MasinaService)
 */
@Component// This means that this class is a Controller
@RequestMapping("/masina")
public class MasinaController {

    MasinaService masinaService;
    /**
     * @param masinaService
     */
    public MasinaController(MasinaService masinaService) {
        this.masinaService = masinaService;
    }
    /**
     * @param masina
     * @return Masina
     */
    @PostMapping // Map ONLY POST Requests
    public ResponseEntity<Masina> addnewMasina(@RequestBody Masina masina){
        Masina masina1 = masinaService.addNewMasina(masina);
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("masina", "masina"+masina1.getIdProprietar());
        return new ResponseEntity<>(masina1, httpHeaders, HttpStatus.CREATED);
    }
    /**
     * @param serie
     * @return Masina
     */
    @GetMapping({"/{serie}"})
    public ResponseEntity<Masina> getMasinaByserie(@PathVariable String serie){
        return new ResponseEntity<>(masinaService.getMasinaBySerie(serie), HttpStatus.OK);
    }
    /**
     * @return <List<Masina>>
     */
    @GetMapping
    public @ResponseBody ResponseEntity<List<Masina>> getAllMasini() {
        List<Masina> masini = masinaService.getAllMasini();
        return new ResponseEntity<>(masini, HttpStatus.OK);
    }
    /**
     * @param serie
     * @return Masina
     */
    @DeleteMapping("/{serie}")
    public ResponseEntity<Masina> deleteMasina(@PathVariable("serie") String serie) {
        masinaService.deleteMasina(serie);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}