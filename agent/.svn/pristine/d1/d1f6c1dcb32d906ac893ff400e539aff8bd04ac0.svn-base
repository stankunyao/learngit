
package com.harmony.themis.excel.exportexcel;
 
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.stereotype.Service;
import com.harmony.themis.excel.importexcel.ImportExcelAnnotation;

@Service("excelExportByColumnIndex")
public class ExcelExportByColumnIndex<T>   {
	
	 Class<T> clazz;   
	 POIFSFileSystem fs = null;;
     // 创建工作簿 
     HSSFWorkbook workbook = null; ;
	 int startrow =0; //从第几行开始
	//filedname,A3
	 Map<String,String> filedname_cellnum_map = new HashMap<String,String>();
	 public void init_filedname_cellnum_map(Map<String,String> filedname_cellnum_map) {
			this.filedname_cellnum_map = filedname_cellnum_map; 
			
		}
	 HSSFCellStyle style = null;
	 //从a3得到英文
	 public String getEnglish(String cellnum){
		 return cellnum.replaceAll("\\d+", "");
	 }
	 //从a3得到数字
	 public String getNum(String cellnum){
		 return cellnum.replaceAll("\\D+", "");
	 }
	 /**  
      * 类反射得到调用方法  
      * 
      * //{A=public void com.harmony.newduty.domain.Duty.getDutyPersonName(java.lang.String),
      *  B=public void com.harmony.newduty.domain.Duty.getDutyDate(java.lang.String), 
      *   
      */  
	public Map<String,Method> initFieldMap(){
		Map<String,Method> map = new HashMap<String,Method>();
		 
        // 得到目标目标类的所有的字段列表   
        Field filed[] = clazz.getDeclaredFields();   
        // 将所有标有Annotation的字段，也就是允许导入数据的字段,放入到一个map中   
         
        // 循环读取所有字段   
        for (int i = 0; i < filed.length; i++) {   
            Field f = filed[i];   
            // 得到单个字段上的Annotation   
            ImportExcelAnnotation exa = f.getAnnotation(ImportExcelAnnotation.class);   
            String fieldname = f.getName();
            // 如果标识了Annotationd的话   
            if (exa != null) {   
                // 构造设置了Annotation的字段的getter方法   
                   
                String getMethodName = "get"  
                        + fieldname.substring(0, 1).toUpperCase()   
                        + fieldname.substring(1);   
                // 构造调用的method，   
                Method getMethod = null;
				try {
					getMethod = clazz.getMethod(getMethodName,   
					        new Class[] {});
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				}   
                // 将这个method以Annotaion的名字为key来存入。   
                map.put(exa.columnIndex(), getMethod);   
            } else{
            	if(this.filedname_cellnum_map.containsKey(fieldname)){
            		String getMethodName = "get"  
                        + fieldname.substring(0, 1).toUpperCase()   
                        + fieldname.substring(1);   
                // 构造调用的method，   
                Method getMethod = null;
            				try {
            					getMethod = clazz.getMethod(getMethodName,   
            					        new Class[] {});
            					} catch (SecurityException e) {
            							e.printStackTrace();
            						} catch (NoSuchMethodException e) {
            								e.printStackTrace();
            							}   
                // 将这个method以Annotaion的名字为key来存入。   
                map.put(this.filedname_cellnum_map.get(fieldname), getMethod);  
            	}  
            	}
        }   
		return map;
		
	}
	/**  
     * 通过cell得到A3 B6  
     */ 
	public String getRowColmunNumByCell(Cell cell){
		if(cell==null)
			return "";
		String res="";
		String alpha = "abcdefghijklmnopqrstuvwxyz";
		int row=cell.getRowIndex();
		int col=cell.getColumnIndex()+1;
		while(true){
			int a=col%26;
			if(a==0){
				a = 26;
			}
			res=alpha.charAt(a-1)+res;
			col=(col-a)/26;
			if(col==0)
				break;
		}
		res+=row;
		return res.toUpperCase();
	 
	}
	public HSSFWorkbook initworkbook (InputStream is){
		try {
			this.fs = new POIFSFileSystem(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.workbook = new HSSFWorkbook(fs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return this.workbook;
	}
	 public void exportExcel(String title, Collection<T> dataset, HttpServletResponse out ,Map<String,String> argsMap ,InputStream is,Map<String,String> titleMap )
	  {
	    try
	    {
	     	if(is!=null && workbook == null){
	     		initworkbook (is);
	     	}
	    	
            if (dataset == null || dataset.isEmpty()) {
	    	  throw new Exception("传入的数据是null");
	        }
	        Iterator<T> it = dataset.iterator();
	        if ((dataset == null) || (!it.hasNext()) || (title == null) || (out == null))
	        {
	          throw new Exception("传入的数据不对！(dataset == null) || (!its.hasNext()) || (title == null) || (out == null)");
	        }
 
	         
	       HSSFSheet sheet = workbook.getSheetAt(0);
	       if(argsMap.containsKey("sheetnum")){
			    sheet =  workbook.getSheetAt(Integer.parseInt(argsMap.get("sheetnum"))); 
			} 
 
	         
	        
	         
	        int index = this.startrow;
	        //更改标题等
	        this.setCellsByMap(    sheet ,  titleMap);
	      //循环行 从起始行startrow开始
	        while (it.hasNext()) {
	          
	        	HSSFRow row = sheet.createRow(index);
	            //如果参数map中有rowHeight
	            if(argsMap.containsKey("rowHeight")){
	            	row.setHeight(Short.parseShort(argsMap.get("rowHeight")) );
	            }else{ //如果参数map中没有有rowHeight 则默认为上一行的高度
	            	row.setHeight(getlastHeight(row,sheet));
	            }
	           
	          
	          Map<String,Method> fieldmap = this.initFieldMap();
	          T t = it.next();
	          //为一行的每一cell赋值
	          this.setCell(  row,  sheet, fieldmap ,  t);
	          
	          
	          index++;
	        }

	      //屏幕输出
          this.output(out, title, workbook);
	    
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }
	 //为一行的每一cell赋值
	 public void setCell(HSSFRow row,HSSFSheet sheet,Map<String,Method> fieldmap ,T it){
		 //循环列
         for (int k = 0; k < fieldmap.size()+10; k++) {
       	  HSSFCell cell = row.createCell(k);
            
        // 这里得到此列的对应的标题   
             String titleString = this.getRowColmunNumByCell(cell);   
             if(this.style==null){//如果没有指定style 则默认为cell正上方cell的style
	 	    	    if(this.getUpCellStyle(   row,     sheet , k )!=null){
	 	    	    	cell.setCellStyle(this.getUpCellStyle(   row,     sheet , k )); 
	 	    	    }
	 	    	   
	 	       	}
             else{
           	  cell.setCellStyle(this.style);
             }
           
             if (!fieldmap.containsKey(this.getEnglish(titleString) )) {   
           	  cell.setCellValue("");
           	  continue;
             }  
             // 如果这一列的标题和类中的某一列的Annotation相同，那么则调用此类的的get方法，进行设值   
             Method  getMethod =   fieldmap.get(this.getEnglish(titleString));
         
             
           Object value = "";
		try {
			value = getMethod.invoke(it, new Object[0]);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

           String textValue = getValue(value);

           HSSFRichTextString richString = new HSSFRichTextString(textValue);
          
           cell.setCellValue(richString);
         }
	 }
	 public String getValue(Object value) {
		    String textValue = "";
		    if (value == null) {
		      return textValue;
		    }
		    if ((value instanceof Boolean)) {
		      boolean bValue = ((Boolean)value).booleanValue();
		      textValue = "是";
		      if (!bValue)
		        textValue = "否";
		    }
		    else if ((value instanceof Date)) {
		      Date date = (Date)value;
		      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		      textValue = sdf.format(date);
		    } else {
		      textValue = value.toString();
		    }
		    return textValue;
		  }
    public void initstartrow(int i){
    	this.startrow = i-1;
    }
 
	public void initclsaa(Class clazz) {
		this.clazz = clazz; 
		
	}  
	public void initstyle(HSSFCellStyle style) {
		this.style = style; 
		
	} 
	
private ServletOutputStream  getOutPutStream(HttpServletResponse response,String fileName){
		
		ServletOutputStream out = null;
		response.setHeader("Cache-Control", "public");
		response.setHeader("Pragma", "public");
		response.setContentType("application/txt");
		 
		try {
			response.setHeader("Content-Disposition", "attachment; filename=\""
					+ new String((fileName+".xls").getBytes(), "ISO8859-1") + "\"");
			response.setContentType("text/excel;charset=utf-8");
			out = response.getOutputStream();
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return out;
	}
	//打印到前台
	public void  output(HttpServletResponse response,String fileName ,HSSFWorkbook workbook){
		
		ServletOutputStream out = this.getOutPutStream(response, fileName);
		try {
			workbook.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
	}
	//得到上一行的高度 如果上一行没有高度则默认700
	public short getlastHeight(HSSFRow row ,   HSSFSheet sheet ){
		short i = 700;
		if(sheet.getRow(row.getRowNum()-1)==null){
			return  i;
		}
		//if(sheet.getRow(row.getRowNum()-1).getHeight()==0){
			i = sheet.getRow(row.getRowNum()-1).getHeight();
		//	return  i;
		//}
		return	sheet.getRow(row.getRowNum()-1).getHeight();
		
	} 
	//得到正上方cell的stlye
	public HSSFCellStyle getUpCellStyle(HSSFRow row,   HSSFSheet sheet ,int cellNum){
		//String titleString = this.getRowColmunNumByCell(cell).substring(1);   
		HSSFRow row1 = sheet.getRow(row.getRowNum()-1);
		if(null == row1){
			return null;
		}
		if(null ==  row1.getCell(cellNum)){
			return null;
		}
		return row1.getCell(cellNum).getCellStyle();
         
	}
	//默认cell样式
	public HSSFCellStyle getDefaultStyle(HSSFWorkbook wb) {
	    HSSFCellStyle style =  wb.createCellStyle();

	     

	    //设置边框样式
	     style.setBorderTop(HSSFCellStyle.BORDER_THIN);
	     style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
	     style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
	     style.setBorderRight(HSSFCellStyle.BORDER_THIN); 
	      
	      
	    return style;
	  }
	public void setCellsByMap(  HSSFSheet sheet ,Map<String ,String> map){
		for(String cellNum : map.keySet()){
			setCellByNum(  cellNum ,   map.get(cellNum) ,   sheet);
		}
		
	}
	//通过cell的num 如A3 B6  得到cell 并赋值
	public void setCellByNum(String cellNum , String cellValue , HSSFSheet sheet ){

		int rownum = Integer.parseInt(this.getNum(cellNum))-1;
		int cellnum = this.parseAlpha(cellNum);
		HSSFRow row1 = sheet.getRow(rownum);
		row1.getCell(cellnum).setCellValue(cellValue);
	}
	public int parseAlpha(String s){
		if(s==null || s.isEmpty())
			return -1;
		int res=0;
		s=s.replaceAll("\\d+", "");
		s=s.toLowerCase();
		String alpha="abcdefghijklmnopqrstuvwxyz";
		for(int i=0;i<s.length();i++){
			res=res*26+alpha.indexOf(s.charAt(i))+1;
		}
		return res-1;
	}

	
}
