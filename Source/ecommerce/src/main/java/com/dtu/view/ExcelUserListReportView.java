package com.dtu.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.dtu.model.SanPham;


public class ExcelUserListReportView extends AbstractXlsView {

 @Override
 protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
   HttpServletResponse response) throws Exception {
  
  response.setHeader("Content-disposition", "attachment; filename=\"user_list.xls\"");
  
  @SuppressWarnings("unchecked")
  List<SanPham> list = (List<SanPham>) model.get("userList");
  
  Sheet sheet = workbook.createSheet("User List");
  
  Row header = sheet.createRow(0);
  header.createCell(0).setCellValue("ID");
  header.createCell(1).setCellValue("USERNAME");
  header.createCell(2).setCellValue("FIRST NAME");
  header.createCell(3).setCellValue("LAST NAME");
  
  int rowNum = 1;
  
  for(SanPham user : list){
   Row row = sheet.createRow(rowNum++);
   row.createCell(0).setCellValue(user.getTensanpham());
   row.createCell(1).setCellValue(user.getGiatien());
   row.createCell(2).setCellValue(user.getMota());
   row.createCell(3).setCellValue(user.getHinhsanpham());
  }
  
 }

}