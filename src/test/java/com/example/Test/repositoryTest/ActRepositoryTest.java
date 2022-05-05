package com.example.Test.repositoryTest;

import com.example.accessingdatamysql.Model.Act;
import com.example.accessingdatamysql.Repository.ActRepository;
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
public class ActRepositoryTest {

    @Mock
    ActRepository actRepository;

    /**
     * Testing repository for find an object
     */
    @Test
    public void getActByIdTest(){
        Act act = new Act(1,"Asigurare","MS202", "2021-5-4","2022-5-4",270);

        when(actRepository.findById(1)).thenReturn(java.util.Optional.of(act));

        Act result = actRepository.findById(1).get();
        assertThat(result.getSERIE()).isEqualTo(act.getSERIE());
    }

    /**
     * Testing for getting all object from the table
     */
    @Test
    public void findAllActeTest(){
        Act act1 = new Act(1,"Asigurare","MS202", "2021-5-4","2022-5-4",270);
        Act act2 = new Act(2,"Asigurare","MS203", "2021-3-4","2022-3-4",200);
        List<Act> acte = new ArrayList<>();
        acte.add(act1);
        acte.add(act2);

        when(actRepository.findAll()).thenReturn(acte);

        List<Act> result = (List<Act>)actRepository.findAll();

        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getSERIE()).isEqualTo(act1.getSERIE());
        assertThat(result.get(1).getSERIE()).isEqualTo(act2.getSERIE());
    }

    /**
     * Testing repository for delete an object
     */
    @Test
    public void deleteActByIdTest(){
        Act act = new Act(1,"Asigurare","MS202", "2021-5-4","2022-5-4",270);
        actRepository.deleteById(1);

        Optional<Act> result = actRepository.findById(1);

        assertThat(result.isEmpty()).isEqualTo(true);
    }

    /**
     * Testing for saving an object in the table
     */
    @Test
    public void saveActTest(){
        Act act = new Act(1,"Asigurare","MS202", "2021-5-4","2022-5-4",270);
        when(actRepository.save(any())).thenReturn(act);

        Act result = actRepository.save(act);

        assertThat(result.getSERIE()).isEqualTo(act.getSERIE());
    }
}