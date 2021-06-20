package com.dtu.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.dtu.model.ChiTietHoaDon;
import com.dtu.model.SanPham;


public class ExcelDanhMucListReportView extends AbstractXlsView {

 @Override
 protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
   HttpServletResponse response) throws Exception {
  
	  response.setHeader("Content-disposition", "attachment; filename=\"sanpham_list.xls\"");
	  
	  @SuppressWarnings("unchecked")
	  List<SanPham> list = (List<SanPham>) model.get("sanpham");
	  
	  Sheet sheet = workbook.createSheet("User List");
	  Row header1 = sheet.createRow(0);
	  header1.createCell(0).setCellValue("");
	  header1.createCell(1).setCellValue("");
	  header1.createCell(2).setCellValue("Báo cáo/Report/Thống kê");
	  header1.createCell(3).setCellValue("");
	  header1.createCell(4).setCellValue("");
	  Row header = sheet.createRow(2);
	  header.createCell(0).setCellValue("Tên sản phẩm");
	  header.createCell(1).setCellValue("Số lượng");
	  header.createCell(2).setCellValue("Giá tiền");
	  header.createCell(3).setCellValue("Tổng số lượng bán ra");
	  header.createCell(4).setCellValue("Doanh thu");
	  
	  int rowNum = 3;
	  int total_soluong = 0, total_slban = 0, total_doanhthu = 0;
	  for(SanPham sanphams : list){
		  int soluong = 0, tongtien = 0;
		   Row row = sheet.createRow(rowNum++);
		   row.createCell(0).setCellValue(sanphams.getTensanpham() + " " + sanphams.getRom() + " GB");
		   row.createCell(1).setCellValue(sanphams.getSoluong());
		   total_soluong += sanphams.getSoluong();
		   row.createCell(2).setCellValue(sanphams.getGiatien());
		   for (ChiTietHoaDon ct : sanphams.getChitiethoadon()) {
			   soluong = soluong + ct.getSoluong();
			   tongtien = tongtien + Integer.parseInt(ct.getTongtien());
			   
		   }
		   row.createCell(3).setCellValue(soluong);
		   row.createCell(4).setCellValue(tongtien);
		   total_slban += soluong;
		   total_doanhthu += tongtien;
	  }
	  Row row = sheet.createRow(rowNum++);
	  row.createCell(0).setCellValue("Total: ");
	  row.createCell(1).setCellValue(total_soluong);
	  row.createCell(2).setCellValue("");
	  row.createCell(3).setCellValue(total_slban);
	  row.createCell(4).setCellValue(total_doanhthu);
  }

}