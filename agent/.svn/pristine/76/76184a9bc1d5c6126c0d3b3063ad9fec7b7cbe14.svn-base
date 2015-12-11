/**
 * @author �����
 * ����:����QueryString
 */
package com.harmony.themis.commons;

import java.util.HashMap;
import java.util.Map;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;

public class QueryString{
	private HashMap h=null;
	public QueryString(HttpServletRequest request){
		h=new HashMap();
		String query=request.getQueryString();
		if (query == null) {
			return;
		}
		try {
			if(request.getCharacterEncoding()!=null){
				query=URLDecoder.decode(query,request.getCharacterEncoding());
			}else{
				query=URLDecoder.decode(query);
			}
			String[] keycollen=query.split("&");
			for(int i=0;i<keycollen.length;i++){
				String[] key=keycollen[i].split("=");
				if(key.length==1){
					h.put(key[0],"");
				}else{
					h.put(key[0],key[1]);
				}
				
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	public String getValue(String key){
		if(h.get(key)==null) return null;
		return h.get(key).toString();
	}
	
	public Map getQueryStringMap(){
		return h;
	}
}
