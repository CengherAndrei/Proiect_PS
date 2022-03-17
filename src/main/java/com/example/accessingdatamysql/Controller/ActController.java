package com.example.accessingdatamysql.Controller;

import com.example.accessingdatamysql.Model.Act;
import com.example.accessingdatamysql.Model.Masina;
import com.example.accessingdatamysql.Service.ActService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Apeleaza clasele din business logic (ActService)
 */
@Component// This means that this class is a Controller
@RequestMapping("/act")
public class ActController {

    ActService actService;
    /**
     * @param actService
     */
    public ActController(ActService actService) {
        this.actService = actService;
    }
    /**
     * @param act
     * @return Act
     */
    @PostMapping // Map ONLY POST Requests
    public ResponseEntity<Act> addnewAct(@RequestBody Act act){
        Act act1 = actService.addNewAct(act);
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("act", "act"+act1.getIdAct());
        return new ResponseEntity<>(act1, httpHeaders, HttpStatus.CREATED);
    }
    /**
     * @param id_act
     * @return Act
     */
    @GetMapping({"/{id_act}"})
    public ResponseEntity<Act> getMasinaByserie(@PathVariable Integer id_act){
        return new ResponseEntity<>(actService.getActById(id_act), HttpStatus.OK);
    }
    /**
     * @return <List<Act>>
     */
    @GetMapping
    public @ResponseBody ResponseEntity<List<Act>> getAllActe() {
        List<Act> acte = actService.getAllActe();
        return new ResponseEntity<>(acte, HttpStatus.OK);
    }
    /**
     * @param id_act
     * @return Act
     */
    @DeleteMapping("/{id_act}")
    public ResponseEntity<Act> deleteAct(@PathVariable("id_act") Integer id_act) {
        actService.deleteAct(id_act);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}