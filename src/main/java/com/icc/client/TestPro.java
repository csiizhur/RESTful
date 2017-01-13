package com.icc.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class TestPro {

	private static HttpEntity<String> prepareGet(MediaType type){
		
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(type);
		HttpEntity<String> entity=new HttpEntity<String>(headers);
		return entity;
	}
	
	/**
	 * restTemplet
	 */
	private static RestTemplate getTem(){
		ApplicationContext act=new ClassPathXmlApplicationContext("classpath:/xml/spring.xml");
		RestTemplate tem=(RestTemplate) act.getBean("restTemplate");
		return tem;
	}
	
	public static void testHeaders(RestTemplate tem){
		HttpEntity entity=prepareGet(MediaType.APPLICATION_JSON);
		//tem.exchange("http://localhost:8081/geohey/api/pro", HttpMethod.GET, entity,"");
		String resp=(String) tem.getForObject("http://localhost:8081/geohey/api/pro1", String.class, new String[]{});
		System.err.println(resp);
	}
	
	public static void main(String[] args) {
		RestTemplate tem=getTem();
		testHeaders(tem);
	}
}
