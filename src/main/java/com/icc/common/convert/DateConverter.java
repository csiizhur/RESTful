package com.icc.common.convert;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 日期转换器
 * @description 
 * @author Administrator
 * @date 2017年1月13日下午3:12:43
 */
public class DateConverter implements Converter<Date, String> {

	@Override
	public String convert(Date source) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		return sdf.format(source);
	}


}