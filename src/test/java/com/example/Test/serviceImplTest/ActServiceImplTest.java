package com.example.Test.serviceImplTest;


import com.example.accessingdatamysql.Model.Act;
import com.example.accessingdatamysql.Repository.ActRepository;
import com.example.accessingdatamysql.Service.ActServiceImpl;
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
public class ActServiceImplTest {

    @InjectMocks
    ActServiceImpl actService;

    @Mock
    private ActRepository actRepository;

    /**
     * Testing to retrieve an object with a specific id
     */
    @Test
    public void getActIdTest(){
        Act act1 = new Act(1,"Asigurare","MS202", "2021-5-4","2022-5-4",270);
        act1.setIdAct(1);

        when(actRepository.findById(1)).thenReturn(java.util.Optional.of(act1));

        Act result = actService.getActById(1);

        assertThat(result.getSERIE()).isEqualTo(act1.getSERIE());
    }

    /**
     * Testing to retrieve all objects of this type
     */
    @Test
    public void getAllActeTest(){
        Act act1 = new Act(1,"Asigurare","MS202", "2021-5-4","2022-5-4",270);
        Act act2 = new Act(2,"Asigurare","MS203", "2021-3-4","2022-3-4",200);
        List<Act> acte = new ArrayList<>();
        acte.add(act1);
        acte.add(act2);

        when(actRepository.findAll()).thenReturn(acte);

        List<Act> result = actService.getAllActe();

        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getSERIE()).isEqualTo(act1.getSERIE());
        assertThat(result.get(1).getSERIE()).isEqualTo(act2.getSERIE());
    }

    /**
     * Testing for creating an object
     */
    @Test
    public void createActTest(){
        Act act1 = new Act(1,"Asigurare","MS202", "2021-5-4","2022-5-4",270);
        act1.setIdAct(1);

        when(actRepository.save(any())).thenReturn(act1);

        Act result = actService.addNewAct(act1);

        assertThat(result.getSERIE()).isEqualTo(act1.getSERIE());
    }

    /**
     * Test for delete an object with a specific Id
     */
    @Test
    public void deleteActIdTest(){
        Act act1 = new Act(1,"Asigurare","MS202", "2021-5-4","2022-5-4",270);
        act1.setIdAct(1);
        actService.addNewAct(act1);
        actService.deleteAct(1);

        assertThat(act1.getIdAct()).isEqualTo(1);
    }

}