package com.my.app.service.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.my.app.dto.TestDTO;

@Mapper
public interface TestDAO {
	public List<TestDTO> getInfo(TestDTO dto);
}
