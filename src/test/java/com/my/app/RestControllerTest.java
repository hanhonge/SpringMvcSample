package com.my.app;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.mock.http.client.MockClientHttpRequest;
import org.springframework.mock.http.client.MockClientHttpResponse;

import com.my.app.junit.cfg.JunitConfig;

public class RestControllerTest extends JunitConfig {
			
//	@Test
	public void test1() throws Exception {
		this.mockMvc.perform(get("/rest/case1"))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
//	@Test
	public void test2() throws Exception {
		this.mockMvc.perform(get("/rest/case2"))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	//@Test
	public void test3() throws Exception {
		this.mockMvc.perform(get("/rest/case3"))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	@Test
	public void test4() throws Exception {
//		MockClientHttpRequest request = new MockClientHttpRequest();
//		MockClientHttpResponse response = new MockClientHttpResponse(body, statusCode)
	}

}
