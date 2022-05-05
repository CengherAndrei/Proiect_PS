package com.example;

import com.example.accessingdatamysql.Test.*;
import com.example.accessingdatamysql.Test.Enum;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.Basic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = Test.class)
class DemoApplicationTests {

	@Mock
	DataSource dataSource;
	@Test
	void contextLoads() {
		FactoryUser fu = new FactoryUser();
		BasicUser basic = fu.createObj(Enum.Colaborator);
		BasicUser expectedResult = new Colaborator("A","C");
		assertEquals(expectedResult,basic);
	}
	@Test
	void test2()
	{
		when(dataSource.zile()).thenReturn(12);

		FactoryUser fact = new FactoryUser();
		BasicUser p = fact.createObj(Enum.Colaborator);
		p.data = dataSource;
		int result = p.numarZile();
		assertEquals(72,result);
		verify(dataSource,times(1));

	}

}
