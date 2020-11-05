package com.my.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.my.app.service.vo.RestResVO;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@GetMapping("/rest/case1")
	public String case1() {
		return "yes";
	}
	
	@RequestMapping(value = "/rest/case2", method = RequestMethod.GET)
	public RestResVO case2() {
		RestResVO resVO = new RestResVO();
		resVO.setId("id");
		resVO.setName("name");
		return resVO;
	}
	
	@RequestMapping(value = "/rest/case3", method = RequestMethod.GET)
	public List<String> case3() {		
		return Arrays.asList("a","b","c");
	}
}
