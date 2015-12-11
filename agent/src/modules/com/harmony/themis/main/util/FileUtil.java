package com.harmony.themis.main.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileUtil {
	/**
	 * 针对TXT格式文件
	 * @throws IOException 
	 * */
   public static String getFileCode(InputStream inputStream) throws IOException{
	   String code = "gb2312";
	   byte[] head = new byte[3];          
	   inputStream.read(head);
	   if (head[0] == -1 && head[1] == -2 ){
		   code = "UTF-16"; 
	   }      
	   if (head[0] == -2 && head[1] == -1 ){
		   code = "Unicode";  
	   } 
	   if(head[0]==-17 && head[1]==-69 && head[2] ==-65){
		   code = "UTF-8";  
	   }
	   return code;
   }
   public static void main(String[] args){
	   String file = "E:\\新建文本文档 (2).txt";
	   try {
		byte[] buffer = new byte[1024];
		BufferedInputStream  bis = new BufferedInputStream(new FileInputStream(file));
		int b = -1;
		while((b  = bis.read(buffer)) != -1){
			String chunk = new String(buffer, 0, b);
			System.out.print(chunk);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
}
