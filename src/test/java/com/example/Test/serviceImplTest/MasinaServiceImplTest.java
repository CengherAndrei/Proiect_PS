package com.example.Test.serviceImplTest;


import com.example.accessingdatamysql.Model.Masina;
import com.example.accessingdatamysql.Repository.MasinaRepository;
import com.example.accessingdatamysql.Repository.MasinaRepository;
import com.example.accessingdatamysql.Service.MasinaServiceImpl;
import com.example.accessingdatamysql.Service.MasinaServiceImpl;
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
public class MasinaServiceImplTest {

    @InjectMocks
    MasinaServiceImpl masinaService;

    @Mock
    private MasinaRepository masinaRepository;

    /**
     * Testing to retrieve an object with a specific id
     */
    @Test
    public void getMasinaIdTest(){
        Masina masina1 = new Masina("WVWZZZ3CZEE508234",1,"VW","Golf",2009,"negru",1400,"Benzina");

        when(masinaRepository.findById("WVWZZZ3CZEE508234")).thenReturn(java.util.Optional.of(masina1));

        Masina result = masinaService.getMasinaBySerie("WVWZZZ3CZEE508234");

        assertThat(result.getSerie()).isEqualTo(masina1.getSerie());
    }

    /**
     * Testing to retrieve all objects of this type
     */
    @Test
    public void getAllMasiniTest(){
        Masina masina1 = new Masina("WVWZZZ3CZEE508234",1,"VW","Golf",2009,"negru",1400,"Benzina");
        Masina masina2 = new Masina("WVWZZZ2AZEE508234",2,"VW","Golf",2019,"alb",2000,"Benzina");
        List<Masina> masini = new ArrayList<>();
        masini.add(masina1);
        masini.add(masina2);

        when(masinaRepository.findAll()).thenReturn(masini);

        List<Masina> result = masinaService.getAllMasini();

        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getSerie()).isEqualTo(masina1.getSerie());
        assertThat(result.get(1).getSerie()).isEqualTo(masina2.getSerie());
    }

    /**
     * Testing for creating an object
     */
    @Test
    public void createMasinaTest(){
        Masina masina1 = new Masina("WVWZZZ3CZEE508234",1,"VW","Golf",2009,"negru",1400,"Benzina");

        when(masinaRepository.save(any())).thenReturn(masina1);

        Masina result = masinaService.addNewMasina(masina1);

        assertThat(result.getSerie()).isEqualTo(masina1.getSerie());
    }

    /**
     * Test for delete an object with a specific Id
     */
    @Test
    public void deleteMasinaIdTest(){
        Masina masina1 = new Masina("WVWZZZ3CZEE508234",1,"VW","Golf",2009,"negru",1400,"Benzina");
        masinaService.addNewMasina(masina1);
        masinaService.deleteMasina("WVWZZZ3CZEE508234");

        assertThat(masina1.getSerie()).isEqualTo("WVWZZZ3CZEE508234");
    }

}