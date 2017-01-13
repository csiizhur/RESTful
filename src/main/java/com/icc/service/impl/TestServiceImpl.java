package com.icc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icc.dao.TestMapperDao;
import com.icc.entity.TestData;
import com.icc.service.TestService;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private TestMapperDao testMapper;
	
	@Override
	public List<TestData> queryTestData() {
		return testMapper.getDatas();
	}

}
