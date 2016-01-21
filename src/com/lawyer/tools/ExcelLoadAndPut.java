package com.lawyer.tools;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
public class ExcelLoadAndPut {
	private final String ss="Sheet1";
	
		
	 /**
	  * ������д�뵽ָ����Ŀ¼��excel����
	  * @param fliepath �ļ�·��
	  * @param sheetName ָ���ı� Ĭ��Ϊsheet1
	  * @param list<Object[]> д��������ݼ��� 
	  */
	
	 @SuppressWarnings("hiding")
	public void PutExcel(String fliePath,String sheetName,List<Object[]> 

	list){
		 
		 HSSFWorkbook workbook=new HSSFWorkbook();
		 
		 FileOutputStream fos=null;
		 
		 try{
			 
			 fos=new FileOutputStream(fliePath);
			 
		 }catch(FileNotFoundException e){
			 
			 e.printStackTrace();
			 
		 }catch(IOException e){
			 
			 e.printStackTrace();
		 }
		 
		 HSSFSheet sheet=null;
		 
		 if(sheetName==null||sheetName.equals("")){
			 
			 sheet=workbook.createSheet(ss);
		 }else{
			 
			 sheet=workbook.createSheet(sheetName); 
		 }
		 
		 HSSFRow row = sheet.createRow(0);
		 
		 
		 for(int i=0;i<list.size();i++){
			 
			 Object[] obj=list.get(i);
			 
			 row = sheet.createRow(i);
			 
			 for(int m=0;m<obj.length;m++){
				 
				 HSSFCell cell = row.createCell(m); 
//				 ((Object) cell).setEncoding(HSSFCell.ENCODING_UTF_16);
				 
			     cell.setCellValue(obj[m].toString()); 
			 }	
		 }
		try {
			
			workbook.write(fos);
			
			fos.close();  
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	 }
	 
}
