
package com.harmony.themis.excel.importexcel;
/**  
 * 注意日期不要设置为自定义格式
 *   
 */  
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
 
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Service;

@Service("excelImportByColumnIndex")
public class ExcelImportByColumnIndex<T>   {
	
	 Class<T> clazz;
	 int startrow =0; //从第几行开始
	 //A3,filedname
	 Map<String,String> filedname_cellnum_map = new HashMap<String,String>();
	 /**  
      * 类反射得到调用方法  
      * 
      * //{A=public void com.harmony.newduty.domain.Duty.setDutyPersonName(java.lang.String),
      *  B=public void com.harmony.newduty.domain.Duty.setDutyDate(java.lang.String), 
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
                // 构造设置了Annotation的字段的Setter方法   
                 
                String setMethodName = "set"  
                        + fieldname.substring(0, 1).toUpperCase()   
                        + fieldname.substring(1);   
                // 构造调用的method，   
                Method setMethod = null;
				try {
					setMethod = clazz.getMethod(setMethodName,   
					        new Class[] { f.getType() });
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				}   
                // 将这个method以Annotaion的名字为key来存入。   
                map.put(exa.columnIndex(), setMethod);   
            }else{
            	if(this.filedname_cellnum_map.containsKey(fieldname)){
            		String setMethodName = "set"  
                        + fieldname.substring(0, 1).toUpperCase()   
                        + fieldname.substring(1);   
            		// 构造调用的method，   
            			Method setMethod = null;
            				try {
            						setMethod = clazz.getMethod(setMethodName,   
					        new Class[] { f.getType() });
            					} catch (SecurityException e) {
            							e.printStackTrace();
            						} catch (NoSuchMethodException e) {
            								e.printStackTrace();
            							}   
                // 将这个method以Annotaion的名字为key来存入。   
                map.put(this.filedname_cellnum_map.get(fieldname), setMethod);
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
	 /**  
     * excel的解析方法
     * 用法：
     * 数据开始行数
     * excelImportByColumnIndex.initstartrow(5);
     * 加入需要导入后list内的元素类型
	 *	excelImportByColumnIndex.initclsaa(StandingBook.class);
	 * 参数 都用默认就不用put直接传入map即可
	 *	Map<String,String> map = new HashMap<String,String>();
	 *	页数 默认为0 第一页
	 * map.put("sheetnum", "0");
	 * 日期类型 默认为 dateformat = "yyyy-MM-dd"
	 *	map.put("dateformat", "0");
     */ 
	    public Collection<T> importExcel(File file ,Map<String,String> map) {   
	        Collection<T> dist = new ArrayList();   
	        Map fieldmap = this.initFieldMap();   //{值班人=public void com.harmony.newduty.domain.Duty.setDutyPersonName(java.lang.String), 值班日期=public void com.harmony.newduty.domain.Duty.setDutyDate(java.lang.String), 值班电话=public void com.harmony.newduty.domain.Duty.setDutyTel(java.lang.String)}
	         
	        // 将传入的File构造为FileInputStream;   
            FileInputStream in = null;
			try {
				in = new FileInputStream(file);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}   
            // // 得到工作表   
            HSSFWorkbook book = null;
			try {
				book = new HSSFWorkbook(in);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}   
			HSSFSheet sheet ;
            // 得到页数 默认为第一页   
			if(map.containsKey("sheetnum")){
			    sheet = book.getSheetAt(Integer.parseInt(map.get("sheetnum"))); 
			}else{
				sheet = book.getSheetAt(0);   
			}
           
            // 得到第一面的所有行   
            Iterator<Row> rowIterator = sheet.rowIterator();  
           
           this.startrowbyrownum(rowIterator);
            
            
	        try {   
	           
	           
	            /**  
	             * 解析内容行  
	             */  

	            while (rowIterator.hasNext()) {   
	            	 
	                Row rown = rowIterator.next();   
	  
	                // 行的所有列   
	                Iterator<Cell> cellbody = rown.cellIterator();   
	                // 得到传入类的实例   
	                T tObject = clazz.newInstance(); 
	                 
	                // 遍历一行的列   
	                while (cellbody.hasNext()) {   
	                    Cell cell = cellbody.next();  
	                  
	                    // 这里得到此列的对应的标题   
	                    String titleString = this.getRowColmunNumByCell(cell);   
	                    // 如果这一列的标题和类中的某一列的Annotation相同，那么则调用此类的的set方法，进行设值   
	                    if (fieldmap.containsKey(this.getEnglish(titleString))) {   
	                    	 Method setMethod = (Method) fieldmap.get(this.getEnglish(titleString));   
	                    	this.cellToObject(setMethod, cell, tObject,map);
	                    }   
	                    
	                }   
	                dist.add(tObject);   
	            }   
	        } catch (Exception e) {   
	            e.printStackTrace();   
	            return null;   
	        }   
	        return dist;   
	    }  
    
    public void cellToObject(Method setMethod , Cell cell ,T tObject ,Map<String,String> argsmap) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, ParseException{
    	  
        //得到setter方法的参数   
        Class<?>[] ts = setMethod.getParameterTypes();   
        //只要一个参数   
        Class<?> xclass = ts[0];
        //判断参数类型   
        if(String.class.getName().equals(xclass.getName()))   
        {   
        	 String strdate = ExcelImportUtil.getStringByCell(cell);
                
            setMethod.invoke(tObject, strdate);   
        }   
        else if(Date.class.getName().equals(xclass.getName()))   
        {   
        	 
        	//用来格式化日期的DateFormat   
            String dateformat ;
            if(argsmap.containsKey("dateformat")){
            	dateformat = argsmap.get("dateformat");
            }
            else{//默认
            	dateformat = "yyyy-MM-dd";
            }
            if( ExcelImportUtil.getDateByCell(cell,dateformat)==null){
             	return;
             }
            setMethod.invoke(tObject, ExcelImportUtil.getDateByCell(cell,dateformat));   
        } 
        else if(Integer.class.getName().equals(xclass.getName()))   
        {   
            setMethod.invoke(tObject,ExcelImportUtil.getIntegerByCell(cell));   
        } 
        else if(Boolean.class.getName().equals(xclass.getName()))   
        {   
            
            setMethod.invoke(tObject,ExcelImportUtil.getBooleanByCell(cell) );   
        }else if(Double.class.getName().equals(xclass.getName())){
        	
        	setMethod.invoke(tObject,ExcelImportUtil.getDoubleByCell(cell));
        } 
    }
    //数据起始行
    public void startrowbyrownum( Iterator<Row> rowIterator){
      
        int x =0;
        while (rowIterator.hasNext() && x<this.startrow){
        	rowIterator.next();
        	x++;
        }
    }
    public void initstartrow(int i){
    	this.startrow = i-1;
    }
 
	public void initclsaa(Class clazz) {
		this.clazz = clazz; 
		
	}
	public void init_filedname_cellnum_map(Map<String,String> filedname_cellnum_map) {
		this.filedname_cellnum_map = filedname_cellnum_map; 
		
	}
	 //从a3得到英文
	 public String getEnglish(String cellnum){
		 return cellnum.replaceAll("\\d+", "");
	 }
	 //从a3得到数字
	 public String getNum(String cellnum){
		 return cellnum.replaceAll("\\D+", "");
	 }
}
