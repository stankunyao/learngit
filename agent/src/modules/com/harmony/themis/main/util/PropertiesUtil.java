/**
 * 该类用于读取配置文件
 */
package com.harmony.themis.main.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.Logger;
/**
 * @author DaoKun
 *
 */
public class PropertiesUtil {
	private static final Logger log = Logger.getLogger(PropertiesUtil.class);
	private static PropertiesUtil instance = null;

	public static PropertiesUtil getInstance() {
		if(null == instance){
			instance = new PropertiesUtil();
		}
		return instance;
	}
	/**
	 * 
	 * @param sourceFileName配置文件名，如果为空，则默认读取Application.properties
	 * 如果db则是db/db.properties
	 * @param key要读取的键
	 * @return 字符串
	 */
	public String getPro(String sourceFileName,String key){
		if(null == sourceFileName || sourceFileName == "" || sourceFileName.trim().length() == 0){
			sourceFileName = "/Application.properties";
		}
		if(!sourceFileName.startsWith("/")){
			sourceFileName = "/"+sourceFileName;
		}
		InputStream f = PropertiesUtil.class.getResourceAsStream(sourceFileName);
		Properties p = new Properties();
		try {
			p.load(f);
		} catch (IOException e) {
			log.error("读取配置文件失败", e);
		}
		return p.get(key)==null?null:p.get(key).toString();
	}
//	public static void main(String[] args) {
//		Object xx = PropertiesUtil.getInstace().getPro("/db/db.properties", "jdbc.driverClassName");
//		System.out.println(xx.toString());
//	}
}
