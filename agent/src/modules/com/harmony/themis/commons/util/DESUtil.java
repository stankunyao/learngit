package com.harmony.themis.commons.util;

/* 
 * DesEncrypt.java 
 * 
 * Created on 2007-9-20, 16:10:47 
 * 
 * To change this template, choose Tools | Template Manager 
 * and open the template in the editor. 
 */
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

/**
 * 
 * 使用DES加密与解密,可对byte[],String类型进行加密与解密 密文可使用String,byte[]存储.
 * 
 * String getEncString(String strMing)对strMing进行加密,返回String密文
 * String getDecString(String strMi)对strMin进行解密,返回String明文
 * 
 * byte[] getEncCode(byte[] byteS)byte[]型的加密 
 * byte[] getDecCode(byte[] byteD)byte[]型的解密
 * 
 */
public class DESUtil {
	
		private Key key;
		private static DESUtil desTest = new DESUtil();

		private DESUtil() {
			try {
				KeyGenerator _generator = KeyGenerator.getInstance("DES");
				_generator.init(new SecureRandom("CSC;123".getBytes()));
				this.key = _generator.generateKey();
				_generator = null;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public static DESUtil getInstance(){
			return desTest;
		}

		/**
		 * 加密String明文输入,String密文输出
		 * 
		 * @param strMing
		 * @return
		 */
		public String getEncString(String strMing) {
			String strMi = "";
			try {
				if(strMing!=null&&!"".equals(strMing)){
					return byte2hex(getEncCode(strMing.getBytes()));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return strMi;
		}

		/**
		 * 解密 以String密文输入,String明文输出
		 * 
		 * @param strMi
		 * @return
		 */
		public String getDecString(String strMi) {
			String strMing = "";
			try {
				if(strMing!=null&&!"".equals(strMi)){
					return new String(getDecCode(hex2byte(strMi.getBytes())));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return strMing;
		}

		/**
		 * 加密以byte[]明文输入,byte[]密文输出
		 * 
		 * @param byteS
		 * @return
		 */
		private byte[] getEncCode(byte[] byteS) {
			byte[] byteFina = null;
			Cipher cipher;
			try {
				cipher = Cipher.getInstance("DES");
				cipher.init(Cipher.ENCRYPT_MODE, key);
				byteFina = cipher.doFinal(byteS);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				cipher = null;
			}
			return byteFina;
		}

		/**
		 * 解密以byte[]密文输入,以byte[]明文输出
		 * 
		 * @param byteD
		 * @return
		 */
		private byte[] getDecCode(byte[] byteD) {
			Cipher cipher;
			byte[] byteFina = null;
			try {
				cipher = Cipher.getInstance("DES");
				cipher.init(Cipher.DECRYPT_MODE, key);
				byteFina = cipher.doFinal(byteD);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				cipher = null;
			}
			return byteFina;
		}

		/**
		 * 二行制转字符串
		 * 
		 * @param b
		 * @return
		 */
		public String byte2hex(byte[] b) { // 一个字节的数，
			// 转成16进制字符串
			String hs = "";
			String stmp = "";
			for (int n = 0; n < b.length; n++) {
				// 整数转成十六进制表示
				stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
				if (stmp.length() == 1)
					hs = hs + "0" + stmp;
				else
					hs = hs + stmp;
			}
			return hs.toUpperCase(); // 转成大写
		}

		public byte[] hex2byte(byte[] b) {
			if ((b.length % 2) != 0)
				throw new IllegalArgumentException("长度不是偶数");
			byte[] b2 = new byte[b.length / 2];
			for (int n = 0; n < b.length; n += 2) {
				String item = new String(b, n, 2);
				// 两位一组，表示一个字节,把这样表示的16进制字符串，还原成一个进制字节
				b2[n / 2] = (byte) Integer.parseInt(item, 16);
			}

			return b2;
		}

		public static void main(String[] args) {
			DESUtil des = DESUtil.getInstance();// 实例化一个对像
			
			System.out.println("要加密的文字:"+"侯是笨蛋。。。");
			
			String strEnc = des.getEncString("侯是笨蛋。。。");// 加密字符串,返回String的密文
			System.out.println("加密后的密文:"+strEnc);

			String strDes = des.getDecString(strEnc);// 把String 类型的密文解密
			System.out.println("解密后的密文:"+strDes);
		}

}
