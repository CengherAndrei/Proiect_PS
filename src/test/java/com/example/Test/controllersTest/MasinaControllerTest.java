package com.example.Test.controllersTest;
import com.example.accessingdatamysql.Controller.MasinaController;
import com.example.accessingdatamysql.Model.Masina;
import com.example.accessingdatamysql.Service.MasinaService;
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
public class MasinaControllerTest {
    @InjectMocks
    MasinaController masinaController;

    @Mock
    MasinaService masinaService;

    /**
     * Test to get all objects
     */
    @Test
    public void testFindAll() {
        Masina masina1 = new Masina("WVWZZZ3CZEE508234",1,"VW","Golf",2009,"negru",1400,"Benzina");
        Masina masina2 = new Masina("WVWZZZ2AZEE508234",2,"VW","Golf",2019,"alb",2000,"Benzina");
        List<Masina> masini = new ArrayList<>();
        masini.add(masina1);
        masini.add(masina2);

        when(masinaService.getAllMasini()).thenReturn(masini);

        ResponseEntity<List<Masina>> result = masinaController.getAllMasini();

        assertThat(result.getBody().size()).isEqualTo(2);
        assertThat(result.getBody().get(0).getSerie()).isEqualTo(masina1.getSerie());
        assertThat(result.getBody().get(1).getSerie()).isEqualTo(masina2.getSerie());
    }

    /**
     * Test for get a single object by id of item
     */
    @Test
    public void getMasinabySerieTest(){
        Masina masina1 = new Masina("WVWZZZ3CZEE508234",1,"VW","Golf",2009,"negru",1400,"Benzina");

        when(masinaService.getMasinaBySerie("WVWZZZ3CZEE508234")).thenReturn(masina1);

        ResponseEntity<Masina> result = masinaController.getMasinaByserie("WVWZZZ3CZEE508234");

        assertThat(result.getBody().getSerie()).isEqualTo(masina1.getSerie());
    }

    /**
     * Test of creating an object
     */
    @Test
    public void createMasinaTest(){
        Masina masina1 = new Masina("WVWZZZ3CZEE508234",1,"VW","Golf",2009,"negru",1400,"Benzina");
        when(masinaService.addNewMasina(masina1)).thenReturn(masina1);

        ResponseEntity<Masina> result = masinaController.addnewMasina(masina1);

        assertThat(result.getBody().getSerie()).isEqualTo(masina1.getSerie());
    }

    /**
     * Testing for delete an object by id
     */
    @Test
    public void deleteMasinaTest(){
        Masina masina1 = new Masina("WVWZZZ3CZEE508234",1,"VW","Golf",2009,"negru",1400,"Benzina");
        masinaService.deleteMasina("WVWZZZ3CZEE508234");

        ResponseEntity<Masina> result = masinaController.deleteMasina("WVWZZZ3CZEE508234");

        assertThat(result.getStatusCode().toString()).isEqualTo("204 NO_CONTENT");
    }
}