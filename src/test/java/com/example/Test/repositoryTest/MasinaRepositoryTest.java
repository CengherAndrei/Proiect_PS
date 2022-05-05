package com.example.Test.repositoryTest;

import com.example.accessingdatamysql.Model.Masina;
import com.example.accessingdatamysql.Repository.MasinaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest(classes = Test.class)
public class MasinaRepositoryTest {

    @Mock
    MasinaRepository masinaRepository;

    /**
     * Testing repository for find an object
     */
    @Test
    public void getMasinaByIdTest(){
        Masina masina = new Masina("WVWZZZ3CZEE508234",1,"VW","Golf",2009,"negru",1400,"Benzina");

        when(masinaRepository.findById("WVWZZZ3CZEE508234")).thenReturn(java.util.Optional.of(masina));

        Masina result = masinaRepository.findById("WVWZZZ3CZEE508234").get();
        assertThat(result.getSerie()).isEqualTo(masina.getSerie());
    }

    /**
     * Testing for getting all object from the table
     */
    @Test
    public void findAllMasiniTest(){
        Masina masina1 = new Masina("WVWZZZ3CZEE508234",1,"VW","Golf",2009,"negru",1400,"Benzina");
        Masina masina2 = new Masina("WVWZZZ2AZEE508234",2,"VW","Golf",2019,"alb",2000,"Benzina");
        List<Masina> masini = new ArrayList<>();
        masini.add(masina1);
        masini.add(masina2);

        when(masinaRepository.findAll()).thenReturn(masini);

        List<Masina> result = (List<Masina>)masinaRepository.findAll();

        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getSerie()).isEqualTo(masina1.getSerie());
        assertThat(result.get(1).getSerie()).isEqualTo(masina2.getSerie());
    }

    /**
     * Testing repository for delete an object
     */
    @Test
    public void deleteMasinaByIdTest(){
        Masina masina = new Masina("WVWZZZ3CZEE508234",1,"VW","Golf",2009,"negru",1400,"Benzina");
        masinaRepository.deleteById("WVWZZZ3CZEE508234");

        Optional<Masina> result = masinaRepository.findById("WVWZZZ3CZEE508234");

        assertThat(result.isEmpty()).isEqualTo(true);
    }

    /**
     * Testing for saving an object in the table
     */
    @Test
    public void saveMasinaTest(){
        Masina masina = new Masina("WVWZZZ3CZEE508234",1,"VW","Golf",2009,"negru",1400,"Benzina");
        when(masinaRepository.save(any())).thenReturn(masina);

        Masina result = masinaRepository.save(masina);

        assertThat(result.getSerie()).isEqualTo(masina.getSerie());
    }
}