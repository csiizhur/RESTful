package com.icc.common.db;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.icc.entity.TestData;
import com.icc.service.impl.TestServiceImpl;

public class TestController {

	@Autowired
	private TestServiceImpl testService;
	
	public String test(){
		List<TestData> l=testService.queryTestData();
		return "";
	}
}
