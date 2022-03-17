package com.example.accessingdatamysql.Controller;

import com.example.accessingdatamysql.Model.Proprietar;
import com.example.accessingdatamysql.Service.ProprietarService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Apeleaza clasele din business logic (ProprietarService)
 */
@Component// This means that this class is a Controller
@RequestMapping("/proprietar")
public class ProprietarController {

    ProprietarService proprietarService;

    /**
     * @param proprietarService
     */
    public ProprietarController(ProprietarService proprietarService) {
        this.proprietarService = proprietarService;
    }
    /**
     * @param proprietar
     * @return Proprietar
     */
    @PostMapping // Map ONLY POST Requests
    public ResponseEntity<Proprietar> addnewProprietar(@RequestBody Proprietar proprietar){
        Proprietar proprietar1 = proprietarService.addNewProprietar(proprietar);
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("proprietar", "proprietar"+proprietar1.getIdProprietar().toString());
        return new ResponseEntity<>(proprietar1, httpHeaders, HttpStatus.CREATED);
    }
    /**
     * @param idProprietar
     * @return Proprietar
     */
    @GetMapping({"/{idProprietar}"})
    public ResponseEntity<Proprietar> getProprietarByID(@PathVariable Integer idProprietar){
        return new ResponseEntity<>(proprietarService.getProprietarByID(idProprietar), HttpStatus.OK);
    }
    /**
     * @return <List<Proprietar>>
     */
    @GetMapping
    public @ResponseBody ResponseEntity<List<Proprietar>> getAllProprietari() {
        List<Proprietar> proprietars = proprietarService.getAllProprietari();
        return new ResponseEntity<>(proprietars, HttpStatus.OK);
    }
    /**
     * @param idProprietar
     * @return Proprietar
     */
    @DeleteMapping("/{idProprietar}")
    public ResponseEntity<Proprietar> deleteProprietar(@PathVariable("idProprietar") int idProprietar) {
        proprietarService.deleteProprietar(idProprietar);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}