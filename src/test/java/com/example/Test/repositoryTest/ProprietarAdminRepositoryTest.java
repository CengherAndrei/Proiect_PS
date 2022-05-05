package com.example.Test.repositoryTest;

import com.example.accessingdatamysql.Model.Proprietar;
import com.example.accessingdatamysql.Model.ProprietarAdmin;
import com.example.accessingdatamysql.Repository.ProprietarRepository;
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
public class ProprietarAdminRepositoryTest {

    @Mock
    ProprietarRepository proprietarRepository;

    /**
     * Testing repository for find an object
     */
    @Test
    public void getProprietarAdminByIdTest(){
        ProprietarAdmin proprietar1 = new ProprietarAdmin("Andrei","5003123151635","Tg.Mures","07498355498","andrei@yahoo.com");
        proprietar1.setIdProprietar(1);
        when(proprietarRepository.findById(1)).thenReturn(java.util.Optional.of(proprietar1));

        Proprietar result = proprietarRepository.findById(1).get();
        assertThat(result.getCNP()).isEqualTo(proprietar1.getCNP());
    }

    /**
     * Testing for getting all object from the table
     */
    @Test
    public void findAllProprietarAdminTest(){
        ProprietarAdmin proprietar1 = new ProprietarAdmin("Andrei","5003123151635","Tg.Mures","07498355498","andrei@yahoo.com");
        ProprietarAdmin proprietar2 = new ProprietarAdmin("Mihai","5003145851635","Tg.Mures","0757498498","mihai@yahoo.com");
        List<Proprietar> proprietars = new ArrayList<>();
        proprietars.add(proprietar1);
        proprietars.add(proprietar2);

        when(proprietarRepository.findAll()).thenReturn(proprietars);

        List<Proprietar> result = (List<Proprietar>)proprietarRepository.findAll();

        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getCNP()).isEqualTo(proprietar1.getCNP());
        assertThat(result.get(1).getCNP()).isEqualTo(proprietar2.getCNP());
    }

    /**
     * Testing repository for delete an object
     */
    @Test
    public void deleteProprietarAdminByIdTest(){
        ProprietarAdmin proprietar = new ProprietarAdmin("Andrei","5003123151635","Tg.Mures","07498355498","andrei@yahoo.com");
        proprietar.setIdProprietar(1);
        proprietarRepository.deleteById(1);

        Optional<Proprietar> result = proprietarRepository.findById(1);

        assertThat(result.isEmpty()).isEqualTo(true);
    }

    /**
     * Testing for saving an object in the table
     */
    @Test
    public void saveProprietarAdminTest(){
        ProprietarAdmin proprietar = new ProprietarAdmin("Andrei","5003123151635","Tg.Mures","07498355498","andrei@yahoo.com");
        when(proprietarRepository.save(any())).thenReturn(proprietar);

        Proprietar result = proprietarRepository.save(proprietar);

        assertThat(result.getCNP()).isEqualTo(proprietar.getCNP());
    }
}