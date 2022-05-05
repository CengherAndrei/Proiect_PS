package com.example.Test.controllersTest;
import com.example.accessingdatamysql.Controller.ActController;
import com.example.accessingdatamysql.Model.Act;
import com.example.accessingdatamysql.Service.ActService;
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
public class ActControllerTest {
    @InjectMocks
    ActController actController;

    @Mock
    ActService actService;

    /**
     * Test to get all objects
     */
    @Test
    public void testFindAll() {
        Act act1 = new Act(1,"Asigurare","MS202", "2021-5-4","2022-5-4",270);
        Act act2 = new Act(2,"Asigurare","MS203", "2021-3-4","2022-3-4",200);
        List<Act> acte = new ArrayList<>();
        acte.add(act1);
        acte.add(act2);

        when(actService.getAllActe()).thenReturn(acte);

        ResponseEntity<List<Act>> result = actController.getAllActe();

        assertThat(result.getBody().size()).isEqualTo(2);
        assertThat(result.getBody().get(0).getSERIE()).isEqualTo(act1.getSERIE());
        assertThat(result.getBody().get(1).getSERIE()).isEqualTo(act2.getSERIE());
    }

    /**
     * Test for get a single object by id of item
     */
    @Test
    public void getActbyIdTest(){
        Act act1 = new Act(1,"Asigurare","MS202", "2021-5-4","2022-5-4",270);

        when(actService.getActById(1)).thenReturn(act1);

        ResponseEntity<Act> result = actController.getActByserie(1);

        assertThat(result.getBody().getSERIE()).isEqualTo(act1.getSERIE());
    }

    /**
     * Test of creating an object
     */
    @Test
    public void createActTest(){
        Act act1 = new Act(1,"Asigurare","MS202", "2021-5-4","2022-5-4",270);
        act1.setIdAct(1);
        when(actService.addNewAct(act1)).thenReturn(act1);

        ResponseEntity<Act> result = actController.addnewAct(act1);

        assertThat(result.getBody().getSERIE()).isEqualTo(act1.getSERIE());
    }

    /**
     * Testing for delete an object by id
     */
    @Test
    public void deleteActTest(){
        Act act1 = new Act(1,"Asigurare","MS202", "2021-5-4","2022-5-4",270);
        actService.deleteAct(1);

        ResponseEntity<Act> result = actController.deleteAct(1);

        assertThat(result.getStatusCode().toString()).isEqualTo("204 NO_CONTENT");
    }
}