package com.icc.common.db;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.alibaba.druid.util.DruidPasswordCallback;
import com.icc.util.DESPlus;

/**
 * 
 * @description druid密码加解密
 * @author Administrator
 * @date 2017年1月13日下午2:58:36
 */
@SuppressWarnings("serial")
public class DBPasswordCallback extends DruidPasswordCallback {

	private static Logger log=LoggerFactory.getLogger(DBPasswordCallback.class);
	public void setProperties(Properties p) {
		super.setProperties(p);
		String pwd = p.getProperty("password");
		try {
			if (!StringUtils.isEmpty(pwd)) {
				String decrypt_pwd = new DESPlus().decrypt(pwd);
				setPassword(decrypt_pwd.toCharArray());
			}
			log.info(getPassword()+"this is dbpassword");
		} catch (Exception e) {
			setPassword(pwd.toCharArray());
			e.printStackTrace();
		}
	}

}
