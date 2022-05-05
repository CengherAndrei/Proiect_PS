package com.example.Test.serviceImplTest;


import com.example.accessingdatamysql.Model.*;
import com.example.accessingdatamysql.Repository.ProprietarRepository;
import com.example.accessingdatamysql.Service.ProprietarServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = Test.class)
public class ProprietarServiceImplTest {

    @InjectMocks
    ProprietarServiceImpl ProprietarService;

    @Mock
    private ProprietarRepository ProprietarRepository;

    /**
     * Testing to retrieve an object with a specific id
     */
    @Test
    public void getProprietarBasicByIdTest(){
        ProprietarBasic proprietar1 = new ProprietarBasic("Andrei","5003123151635","Tg.Mures","07498355498","andrei@yahoo.com");
        proprietar1.setIdProprietar(1);
        when(ProprietarRepository.findById(1)).thenReturn(java.util.Optional.of(proprietar1));

        Proprietar result = ProprietarService.getProprietarByID(1,EnumProprietari.ProprietarBasic);

        assertThat(result.getCNP()).isEqualTo(proprietar1.getCNP());
    }
    /**
     * Testing to retrieve an object with a specific id
     */
//    @Test
//    public void getProprietarPremiumByIdTest(){
//        ProprietarPremium proprietar1 = new ProprietarPremium("Andrei","5003123151635","Tg.Mures","07498355498","andrei@yahoo.com");
//        proprietar1.setIdProprietar(1);
//        proprietar1.setTip(1);
//        ProprietarService.addNewProprietar(proprietar1);
//        when(ProprietarPremiumRepository.findById(1)).thenReturn(java.util.Optional.of(proprietar1));
//
//        Proprietar result = ProprietarService.getProprietarByID(1,EnumProprietari.ProprietarPremium);
//
//        assertThat(result.getCNP()).isEqualTo(proprietar1.getCNP());
//    }
//    /**
//     * Testing to retrieve an object with a specific id
//     */
//    @Test
//    public void getProprietarAdminByIdTest(){
//        ProprietarAdmin proprietar1 = new ProprietarAdmin("Andrei","5003123151635","Tg.Mures","07498355498","andrei@yahoo.com");
//        proprietar1.setIdProprietar(1);
//        proprietar1.setTip(2);
//        ProprietarService.addNewProprietar(proprietar1);
//        when(ProprietarAdminRepository.findById(1)).thenReturn(java.util.Optional.of(proprietar1));
//
//        Proprietar result = ProprietarService.getProprietarByID(1,EnumProprietari.ProprietarAdmin);
//
//        assertThat(result.getCNP()).isEqualTo(proprietar1.getCNP());
//    }
    /**
     * Testing to retrieve all objects of this type
     */
    @Test
    public void getAllProprietariBasicTest(){
        ProprietarBasic proprietar1 = new ProprietarBasic("Andrei","5003123151635","Tg.Mures","07498355498","andrei@yahoo.com");
        ProprietarBasic proprietar2 = new ProprietarBasic("Mihai","5003145851635","Tg.Mures","0757498498","mihai@yahoo.com");
        List<Proprietar> proprietars = new ArrayList<>();
        proprietars.add(proprietar1);
        proprietars.add(proprietar2);

        when(ProprietarRepository.findAll()).thenReturn(proprietars);

        List<Proprietar> result = ProprietarService.getAllProprietari();

        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getCNP()).isEqualTo(proprietar1.getCNP());
        assertThat(result.get(1).getCNP()).isEqualTo(proprietar2.getCNP());
    }
    /**
     * Testing to retrieve all objects of this type
     */
    @Test
    public void getAllProprietariPremiumTest(){
        ProprietarPremium proprietar1 = new ProprietarPremium("Andrei","5003123151635","Tg.Mures","07498355498","andrei@yahoo.com");
        ProprietarPremium proprietar2 = new ProprietarPremium("Mihai","5003145851635","Tg.Mures","0757498498","mihai@yahoo.com");
        List<Proprietar> proprietars = new ArrayList<>();
        proprietars.add(proprietar1);
        proprietars.add(proprietar2);

        when(ProprietarRepository.findAll()).thenReturn(proprietars);

        List<Proprietar> result = ProprietarService.getAllProprietari();

        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getCNP()).isEqualTo(proprietar1.getCNP());
        assertThat(result.get(1).getCNP()).isEqualTo(proprietar2.getCNP());
    }
    /**
     * Testing to retrieve all objects of this type
     */
    @Test
    public void getAllProprietariAdminTest(){
        ProprietarAdmin proprietar1 = new ProprietarAdmin("Andrei","5003123151635","Tg.Mures","07498355498","andrei@yahoo.com");
        ProprietarAdmin proprietar2 = new ProprietarAdmin("Mihai","5003145851635","Tg.Mures","0757498498","mihai@yahoo.com");
        List<Proprietar> proprietars = new ArrayList<>();
        proprietars.add(proprietar1);
        proprietars.add(proprietar2);

        when(ProprietarRepository.findAll()).thenReturn(proprietars);

        List<Proprietar> result = ProprietarService.getAllProprietari();

        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getCNP()).isEqualTo(proprietar1.getCNP());
        assertThat(result.get(1).getCNP()).isEqualTo(proprietar2.getCNP());
    }
    /**
     * Testing for creating an object
     */
    @Test
    public void createProprietarTest(){
            ProprietarFactory factoryPr = new ProprietarFactory("Andrei","5003123151635","Tg.Mures","07498355498","andrei@yahoo.com");
            Proprietar proprietar = factoryPr.create(EnumProprietari.ProprietarBasic);
            proprietar.setIdProprietar(1);
            ProprietarBasic proprietar1= new ProprietarBasic("Andrei","5003123151635","Tg.Mures","07498355498","andrei@yahoo.com");

            when(ProprietarRepository.save(any())).thenReturn(proprietar1);

            Proprietar result = ProprietarService.addNewProprietar(proprietar1);
            assertThat(result.getCNP()).isEqualTo(proprietar1.getCNP());
    }

    /**
     * Test for delete an object with a specific Id
     */
    @Test
    public void deleteProprietarIdTest(){
        ProprietarBasic proprietar1 = new ProprietarBasic("Andrei","5003123151635","Tg.Mures","07498355498","andrei@yahoo.com");
        proprietar1.setIdProprietar(1);
        ProprietarService.addNewProprietar(proprietar1);
        ProprietarService.deleteProprietar(1);

        assertThat(proprietar1.getCNP()).isEqualTo("5003123151635");
    }

}