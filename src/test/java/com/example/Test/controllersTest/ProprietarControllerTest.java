package com.example.Test.controllersTest;
import com.example.accessingdatamysql.Controller.ProprietarController;
import com.example.accessingdatamysql.Model.*;
import com.example.accessingdatamysql.Service.ProprietarService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;


@SpringBootTest(classes = Test.class)
public class ProprietarControllerTest {
    @InjectMocks
    ProprietarController proprietarController;

    @Mock
    ProprietarService proprietarService;

    /**
     * Test to get all objects
     */
    @Test
    public void getAllProprietarBasic() {
        ProprietarBasic proprietar1 = new ProprietarBasic("Andrei","5003123151635","Tg.Mures","07498355498","andrei@yahoo.com");
        ProprietarBasic proprietar2 = new ProprietarBasic("Mihai","5003145851635","Tg.Mures","0757498498","mihai@yahoo.com");
        List<Proprietar> proprietars = new ArrayList<>();
        proprietars.add(proprietar1);
        proprietars.add(proprietar2);

        when(proprietarService.getAllProprietari()).thenReturn(proprietars);

        ResponseEntity<List<Proprietar>> result = proprietarController.getAllProprietari();

        assertThat(result.getBody().size()).isEqualTo(2);
        assertThat(result.getBody().get(0).getCNP()).isEqualTo(proprietar1.getCNP());
        assertThat(result.getBody().get(1).getCNP()).isEqualTo(proprietar2.getCNP());
    }

    /**
     * Test to get all objects
     */
    @Test
    public void getAllProprietarPremium() {
        ProprietarPremium proprietar1 = new ProprietarPremium("Andrei","5003123151635","Tg.Mures","07498355498","andrei@yahoo.com");
        ProprietarPremium proprietar2 = new ProprietarPremium("Mihai","5003145851635","Tg.Mures","0757498498","mihai@yahoo.com");
        List<Proprietar> proprietars = new ArrayList<>();
        proprietars.add(proprietar1);
        proprietars.add(proprietar2);

        when(proprietarService.getAllProprietari()).thenReturn(proprietars);

        ResponseEntity<List<Proprietar>> result = proprietarController.getAllProprietari();

        assertThat(result.getBody().size()).isEqualTo(2);
        assertThat(result.getBody().get(0).getCNP()).isEqualTo(proprietar1.getCNP());
        assertThat(result.getBody().get(1).getCNP()).isEqualTo(proprietar2.getCNP());
    }
    /**
     * Test to get all objects
     */
    @Test
    public void getAllProprietarAdmin() {
        ProprietarAdmin proprietar1 = new ProprietarAdmin("Andrei","5003123151635","Tg.Mures","07498355498","andrei@yahoo.com");
        ProprietarAdmin proprietar2 = new ProprietarAdmin("Mihai","5003145851635","Tg.Mures","0757498498","mihai@yahoo.com");
        List<Proprietar> proprietars = new ArrayList<>();
        proprietars.add(proprietar1);
        proprietars.add(proprietar2);

        when(proprietarService.getAllProprietari()).thenReturn(proprietars);

        ResponseEntity<List<Proprietar>> result = proprietarController.getAllProprietari();

        assertThat(result.getBody().size()).isEqualTo(2);
        assertThat(result.getBody().get(0).getCNP()).isEqualTo(proprietar1.getCNP());
        assertThat(result.getBody().get(1).getCNP()).isEqualTo(proprietar2.getCNP());
    }
    /**
     * Test for get a single object by id of item
     */
    @Test
    public void getProprietarBasicbyIdTest(){
        ProprietarBasic proprietar1 = new ProprietarBasic("Andrei","5003123151635","Tg.Mures","07498355498","andrei@yahoo.com");
        proprietar1.setIdProprietar(1);
        when(proprietarService.getProprietarByID(1, EnumProprietari.ProprietarBasic)).thenReturn(proprietar1);

        ResponseEntity<Proprietar> result = proprietarController.getProprietarByID(1,EnumProprietari.ProprietarBasic);

        assertThat(result.getBody().getCNP()).isEqualTo(proprietar1.getCNP());
    }
    /**
     * Test for get a single object by id of item
     */
    @Test
    public void getProprietarPremiumbyIdTest(){
        ProprietarPremium proprietar1 = new ProprietarPremium("Andrei","5003123151635","Tg.Mures","07498355498","andrei@yahoo.com");
        proprietar1.setIdProprietar(1);
        when(proprietarService.getProprietarByID(1,EnumProprietari.ProprietarPremium)).thenReturn(proprietar1);

        ResponseEntity<Proprietar> result = proprietarController.getProprietarByID(1,EnumProprietari.ProprietarPremium);

        assertThat(result.getBody().getCNP()).isEqualTo(proprietar1.getCNP());
    }
    /**
     * Test for get a single object by id of item
     */
    @Test
    public void getProprietarAdminbyIdTest(){
        ProprietarAdmin proprietar1 = new ProprietarAdmin("Andrei","5003123151635","Tg.Mures","07498355498","andrei@yahoo.com");
        proprietar1.setIdProprietar(1);
        when(proprietarService.getProprietarByID(1,EnumProprietari.ProprietarAdmin)).thenReturn(proprietar1);

        ResponseEntity<Proprietar> result = proprietarController.getProprietarByID(1,EnumProprietari.ProprietarAdmin);

        assertThat(result.getBody().getCNP()).isEqualTo(proprietar1.getCNP());
    }
    /**
     * Test of creating an object
     */
    @Test
    public void createProprietarTest(){
        ProprietarBasic proprietar1 = new ProprietarBasic("Andrei","5003123151635","Tg.Mures","07498355498","andrei@yahoo.com");
        proprietar1.setIdProprietar(1);
        when(proprietarService.addNewProprietar(proprietar1)).thenReturn(proprietar1);

        ResponseEntity<Proprietar> result = proprietarController.addnewProprietar(proprietar1);

        assertThat(result.getBody().getCNP()).isEqualTo(proprietar1.getCNP());
    }

    /**
     * Testing for delete an object by id
     */
    @Test
    public void deleteProprietarTest(){
        ProprietarBasic proprietar1 = new ProprietarBasic("Andrei","5003123151635","Tg.Mures","07498355498","andrei@yahoo.com");
        proprietar1.setIdProprietar(1);
        proprietarService.deleteProprietar(1);

        ResponseEntity<Proprietar> result = proprietarController.deleteProprietar(1);

        assertThat(result.getStatusCode().toString()).isEqualTo("204 NO_CONTENT");
    }
}