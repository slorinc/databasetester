package com.avinode;

import com.avinode.databasetester.DatabaseTesterApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DatabaseTesterApplication.class)
@WebAppConfiguration
public class DatabaseTesterApplicationTests {

	@Test
	public void contextLoads() {
	}

}
