package com.icc.util;

import java.security.Key;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import com.sun.crypto.provider.SunJCE;

/**
 * 
 * @description ���ܽ��ܹ�����-DESĬ�Ϲ�Կ���ܺ��Զ��幫Կ����
 * @author Administrator
 * @date 2016��8��30������4:09:14
 */
public class DESPlus {
	private static String strDefaultKey = "drt435@789!-DES234";

	private Cipher encryptCipher = null;

	private Cipher decryptCipher = null;

	/**
	 * Ĭ�Ϲ��췽����ʹ��Ĭ����Կ
	 * 
	 * @throws Exception
	 */
	public DESPlus() throws Exception {
		this(strDefaultKey);
	}

	/**
	 * ָ����Կ���췽��
	 * 
	 * @param strKey
	 *            ָ������Կ
	 * @throws Exception
	 */
	public DESPlus(String keyString) throws Exception {
		Security.addProvider(new SunJCE());
		Key key = getKey(keyString.getBytes());

		encryptCipher = Cipher.getInstance("DES");
		encryptCipher.init(Cipher.ENCRYPT_MODE, key);

		decryptCipher = Cipher.getInstance("DES");
		decryptCipher.init(Cipher.DECRYPT_MODE, key);
	}
	/**
	 * �����ַ���
	 * 
	 * @param str
	 *            ����ܵ��ַ���
	 * @return ���ܺ���ַ���
	 * @throws Exception
	 */
	public String encrypt(String str) throws Exception {
		return Converts.bytesToHexString(encryptCipher.doFinal(str.getBytes("utf8")));
	}

	/**
	 * �����ַ���
	 * 
	 * @param str ����ܵ��ַ���
	 * @return ���ܺ���ַ���
	 * @throws Exception
	 */
	public String decrypt(String str) throws Exception {
		return new String(decryptCipher.doFinal(Converts.hexStringToByte(new String(str.getBytes("utf8")))),"utf8");
	}

	/**
	 * ��ָ���ַ���������Կ����Կ������ֽ����鳤��Ϊ8λ ����8λʱ���油0������8λֻȡǰ8λ
	 * 
	 * @param array
	 *            ���ɸ��ַ������ֽ�����
	 * @return ���ɵ���Կ
	 * @throws java.lang.Exception
	 */
	private Key getKey(byte[] array) throws Exception {
		// ����һ���յ�8λ�ֽ����飨Ĭ��ֵΪ0��
		byte[] keyArray = new byte[8];

		// ��ԭʼ�ֽ�����ת��Ϊ8λ
		for (int i = 0; i < array.length && i < keyArray.length; i++) {
			keyArray[i] = array[i];
		}

		// ������Կ
		return new SecretKeySpec(keyArray, "DES");
	}
	
	public static void main(String[] args) {
		try {
			String str=new DESPlus().decrypt("422C78954DB2A51E");
			System.err.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}