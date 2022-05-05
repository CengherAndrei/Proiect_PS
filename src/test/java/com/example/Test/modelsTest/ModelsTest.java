package com.example.Test.modelsTest;

import com.example.accessingdatamysql.Model.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest(classes = Test.class)
public class ModelsTest {

    @Mock
    Proprietar proprietar;

    /**
     * Testing for creating an object
     */
    @Test
    public void assertProprietarBasicTest(){
        ProprietarFactory factoryPr = new ProprietarFactory("Andrei","5003123151635","Tg.Mures","07498355498","andrei@yahoo.com");
        Proprietar proprietar = factoryPr.create(EnumProprietari.ProprietarBasic);
        ProprietarBasic proprietar1= new ProprietarBasic("Andrei","5003123151635","Tg.Mures","07498355498","andrei@yahoo.com");
        proprietar.setIdProprietar(1);

        assertEquals("Rezultatul: ", proprietar.getNume(), proprietar1.getNume());
        assertEquals("Rezultatul: ", proprietar.getCNP(), proprietar1.getCNP());
        assertEquals("Rezultatul: ", proprietar.getAdresa(), proprietar1.getAdresa());
        assertEquals("Rezultatul: ", proprietar.getNrTelefon(), proprietar1.getNrTelefon());
        assertEquals("Rezultatul: ", proprietar.getEmail(), proprietar1.getEmail());
    }
    /**
     * Testing for creating an object
     */
    @Test
    public void assertProprietarPremiumTest(){
        ProprietarFactory factoryPr = new ProprietarFactory("Andrei","5003123151635","Tg.Mures","07498355498","andrei@yahoo.com");
        Proprietar proprietar = factoryPr.create(EnumProprietari.ProprietarPremium);
        ProprietarPremium proprietar1= new ProprietarPremium("Andrei","5003123151635","Tg.Mures","07498355498","andrei@yahoo.com");
        proprietar.setIdProprietar(1);

        assertEquals("Rezultatul: ", proprietar.getNume(), proprietar1.getNume());
        assertEquals("Rezultatul: ", proprietar.getCNP(), proprietar1.getCNP());
        assertEquals("Rezultatul: ", proprietar.getAdresa(), proprietar1.getAdresa());
        assertEquals("Rezultatul: ", proprietar.getNrTelefon(), proprietar1.getNrTelefon());
        assertEquals("Rezultatul: ", proprietar.getEmail(), proprietar1.getEmail());
    }
    /**
     * Testing for creating an object
     */
    @Test
    public void assertProprietarAdminTest(){
        ProprietarFactory factoryPr = new ProprietarFactory("Andrei","5003123151635","Tg.Mures","07498355498","andrei@yahoo.com");
        Proprietar proprietar = factoryPr.create(EnumProprietari.ProprietarAdmin);
        ProprietarAdmin proprietar1= new ProprietarAdmin("Andrei","5003123151635","Tg.Mures","07498355498","andrei@yahoo.com");
        proprietar.setIdProprietar(1);

        assertEquals("Rezultatul: ", proprietar.getNume(), proprietar1.getNume());
        assertEquals("Rezultatul: ", proprietar.getCNP(), proprietar1.getCNP());
        assertEquals("Rezultatul: ", proprietar.getAdresa(), proprietar1.getAdresa());
        assertEquals("Rezultatul: ", proprietar.getNrTelefon(), proprietar1.getNrTelefon());
        assertEquals("Rezultatul: ", proprietar.getEmail(), proprietar1.getEmail());
    }
    /**
     * Testing for creating an object
     */
    @Test
    public void assertMasinaTest(){
        Masina masina = new Masina("WVWZZZ3CZEE508234",1,"VW","Golf",2009,"negru",1400,"Benzina");
        assertEquals("Rezultatul: ",masina.getSerie(),"WVWZZZ3CZEE508234");
        assertEquals("Rezultatul: ",masina.getIdProprietar(), 1);
        assertEquals("Rezultatul: ",masina.getMarca(), "VW");
        assertEquals("Rezultatul: ",masina.getModel(), "Golf");
        assertEquals("Rezultatul: ",masina.getAn_fabricatie(), 2009);
        assertEquals("Rezultatul: ",masina.getCuloare(), "negru");
        assertEquals("Rezultatul: ",masina.getMotor(), 1400);
        assertEquals("Rezultatul: ",masina.getCombustibil(), "Benzina");
    }

    /**
     * Testing for creating an object
     */
    @Test
    public void assertActTest(){
        Act act = new Act(1,"Asigurare","MS202", "2021-5-4","2022-5-4",270.0);
        assertEquals("Rezultatul: ",act.getIdAct(),1);
        assertEquals("Rezultatul: ",act.getTipAct(), "Asigurare");
        assertEquals("Rezultatul: ",act.getSERIE(), "MS202");
        assertEquals("Rezultatul: ",act.getValabil_de_la(), "2021-5-4");
        assertEquals("Rezultatul: ",act.getValabil_pana_la(), "2022-5-4");
        assertEquals("Rezultatul: ",(int) act.getpret(),(int) 270.0);
    }

}