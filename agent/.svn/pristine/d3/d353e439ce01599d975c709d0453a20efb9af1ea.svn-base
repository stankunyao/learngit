package com.harmony.themis.commons.util;

import org.apache.commons.lang.StringUtils;

/**
 * @author 何军伟
 *
 */
public class SqlUtil {

	public static String escapeSqlLike(String param) {
		if(param == null || param.trim().equals("")) {
			return "";
		}
		String retStr = StringUtils.replace(param, "_", "/_");
		retStr = StringUtils.replace(param, "%", "/%");
		//retStr = StringUtils.replace(param, "?", "_");
		//retStr = StringUtils.replace(param, "*", "%");
		return retStr;
	}
}

