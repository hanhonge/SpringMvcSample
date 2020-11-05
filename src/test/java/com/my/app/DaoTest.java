package com.my.app;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.my.app.dto.TestDTO;
import com.my.app.junit.cfg.JunitConfig;
import com.my.app.service.dao.TestDAO;

public class DaoTest extends JunitConfig {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private TestDAO testDAO;
			
	@Test
	public void test() throws Exception {	
//		Connection conn = DataSourceUtils.getConnection(dataSource);
//		System.out.println("conn:" + conn.toString());
		
		List<TestDTO> list = testDAO.getInfo(new TestDTO());
		System.out.println("list:" + list.size());	
	}

}
