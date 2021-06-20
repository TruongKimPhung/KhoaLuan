package com.dtu.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.dtu.model.ChiTietHoaDon;
import com.dtu.model.SanPham;
import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

public class PdfUserListReportView extends AbstractPdfView {

 @Override
 protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request,
   HttpServletResponse response) throws Exception {
  
	  response.setHeader("Content-Disposition", "attachment; filename=\"sanpham_list.pdf\"");
	  
	  @SuppressWarnings("unchecked")
	  List<SanPham> list = (List<SanPham>) model.get("sanpham");
	  
	  Table table = new Table(5);
	  table.addCell("Tên sản phẩm");
	  table.addCell("Số lượng");
	  table.addCell("Giá tiền");
	  table.addCell("Tổng số lượng bán ra");
	  table.addCell("Doanh thu");
	  int total_soluong = 0, total_slban = 0, total_doanhthu = 0;
	  for(SanPham sanphams : list){
		  int soluong = 0, tongtien = 0;
		   table.addCell(sanphams.getTensanpham() + " " + sanphams.getRom() + " GB");
		   table.addCell(String.valueOf(sanphams.getSoluong()));
		   total_soluong += sanphams.getSoluong();
		   table.addCell(String.valueOf(sanphams.getGiatien()));
		   for (ChiTietHoaDon ct : sanphams.getChitiethoadon()) {
			   soluong = soluong + ct.getSoluong();
			   tongtien = tongtien + Integer.parseInt(ct.getTongtien());
			   
		   }
		   table.addCell(String.valueOf(soluong));
		   table.addCell(String.valueOf(tongtien));
		   total_slban += soluong;
		   total_doanhthu += tongtien;
	  }
	  table.addCell("Total: ");
	  table.addCell(String.valueOf(total_soluong));
	  table.addCell("");
	  table.addCell(String.valueOf(total_slban));
	  table.addCell(String.valueOf(total_doanhthu));
	  document.add(table);
 	}

}