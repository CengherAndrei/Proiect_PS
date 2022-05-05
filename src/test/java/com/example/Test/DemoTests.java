package com.example.Test;

import com.example.accessingdatamysql.Test.BasicUser;
import com.example.accessingdatamysql.Test.Colaborator;
import com.example.accessingdatamysql.Test.Enum;
import com.example.accessingdatamysql.Test.FactoryUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = Test.class)
class DemoTests {

    @Test
    void contextLoads() {
        FactoryUser fu = new FactoryUser();
        BasicUser basic = fu.createObj(Enum.Colaborator);
        BasicUser expectedResult = new Colaborator("A","C");
        assertEquals(expectedResult,basic);
    }

}
