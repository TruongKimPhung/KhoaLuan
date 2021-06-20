package com.dtu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dtu.model.SanPham;
import com.dtu.service.SanPhamService;
import com.dtu.view.ExcelUserListReportView;
import com.dtu.view.PdfUserListReportView;

@Controller
@RequestMapping(value="/")
public class ReportController {
	
	@Autowired
	SanPhamService sp;
 
 @RequestMapping(value="/report", method=RequestMethod.GET)
 public ModelAndView userListReport(HttpServletRequest req, HttpServletResponse res){
  
  String typeReport = req.getParameter("type");
  
  List<SanPham> list = sp.SanPham_All_Paging(-1);
  
  if(typeReport != null && typeReport.equals("xls")){
   return new ModelAndView(new ExcelUserListReportView(), "userList", list);
  } else if(typeReport != null && typeReport.equals("pdf")){
   return new ModelAndView(new PdfUserListReportView(), "userList", list);
  }
  
  return new ModelAndView("userListReport", "userList", list);
 }
}
