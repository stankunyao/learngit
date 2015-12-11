
package com.harmony.themis.excel.importexcel;
/**  
 * 注意日期不要设置为自定义格式
 *   
 */  
 
import java.text.ParseException;
import java.text.SimpleDateFormat;
 
import java.util.Date;
 

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
 
import org.apache.poi.ss.usermodel.Cell;
 
import org.springframework.stereotype.Service;

@Service("excelImport")
public class ExcelImportUtil<T>   {
	
	  public static String getStringByCell(Cell cell){
		   
		  //字符串型
		  if(cell.getCellType()==Cell.CELL_TYPE_STRING){  
			  return cell.getStringCellValue();
            }
		  //数值型
            else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC){
         	   if (HSSFDateUtil.isCellDateFormatted(cell)) {  
                   	
                    SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");

                       Date dt = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());    
                       return dateformat.format(dt); 
                   }else{
                 	  cell.setCellType(1);
                 	 return cell.getStringCellValue();
                   }
            	  
            }
		//公式型
            else if(cell.getCellType()==Cell.CELL_TYPE_FORMULA){
            	return "";
             }
		//空值
            else if(cell.getCellType()==Cell.CELL_TYPE_BLANK ){
            	return "";
             }
		//布尔型
            else if(cell.getCellType()==Cell.CELL_TYPE_BOOLEAN  ){
          	  cell.setCellType(1);
          	return   cell.getStringCellValue();
          }
		  //错误 
            else if(cell.getCellType()==Cell.CELL_TYPE_ERROR   ){
            	return "error";
            }
		return "";
	  }
	  public static Date getDateByCell(Cell cell , String format){
		  if(cell.getStringCellValue()==null || cell.getStringCellValue().equals("")){
			  return null;
		  }
		  //字符串型
		  if(cell.getCellType()==Cell.CELL_TYPE_STRING){ 
			//用来格式化日期的DateFormat   
	            SimpleDateFormat sf;   
	            sf=new SimpleDateFormat(format);     
	            try {
					return sf.parse(cell.getStringCellValue());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
            }
		  //数值型
            else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC){
         	   if (HSSFDateUtil.isCellDateFormatted(cell)) {  
//                   	
//                    SimpleDateFormat dateformat = new SimpleDateFormat(format);

                       Date dt = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());    
                       return  dt ; 
                   } 
            	  
            }
		return null;
		 
	  }
	  public static int getIntegerByCell(Cell cell){
		   
		  //字符串型
		  if(cell.getCellType()==Cell.CELL_TYPE_STRING){ 
			 
	            return (int)cell.getNumericCellValue();
			  
            }
		  //数值型
            else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC){
            	 return (int)cell.getNumericCellValue();
            	  
            }
		return 0;
		 
	  }
	  public static Boolean getBooleanByCell(Cell cell){
		  Boolean bl= true;   
          
			  if(cell.getStringCellValue().equals("否"))   
              {   
                return false;   
              }  
			  return true;
      }
	  
	  public static Double getDoubleByCell(Cell cell){
		  if(cell.getCellType() == Cell.CELL_TYPE_STRING){
			  if(cell.getStringCellValue() == null || "".equals(cell.getStringCellValue())){
				  return 0.0;
			  }else{
				  return new Double(cell.getStringCellValue());
			  }
		  }
		  return 0.0;
	  }
		   
}
         
 
