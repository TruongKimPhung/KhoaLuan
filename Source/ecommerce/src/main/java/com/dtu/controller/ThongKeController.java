package com.dtu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dtu.model.SanPham;
import com.dtu.service.HoaDonService;
import com.dtu.service.SanPhamService;
import com.dtu.service.UserService;
import com.dtu.view.ExcelDanhMucListReportView;
import com.dtu.view.PdfUserListReportView;

@Controller
public class ThongKeController {

	@Autowired
	HoaDonService hoaDonService;

	@Autowired
	SanPhamService sanPhamService;

	@Autowired
	UserService userService;

	@RequestMapping(value = "/thongke", method = RequestMethod.GET)
	public ModelAndView Default(ModelMap modelMap, HttpServletRequest req, HttpServletResponse res) {
		String typeReport = req.getParameter("type");
		List<SanPham> sanphamctr = sanPhamService.ThongKeSanPham("all", null, null);
		if (typeReport != null && typeReport.equals("xls")) {
			return new ModelAndView(new ExcelDanhMucListReportView(), "sanpham", sanphamctr);
		} else if (typeReport != null && typeReport.equals("pdf")) {
			return new ModelAndView(new PdfUserListReportView(), "sanpham", sanphamctr);
		}
		return new ModelAndView("thongke", "sanpham", sanphamctr);
	}

	@RequestMapping(value = "/thongke/all", method = RequestMethod.GET)
	public ModelAndView all(ModelMap modelMap, HttpServletRequest req, HttpServletResponse res) {
		String typeReport = req.getParameter("type");
		List<SanPham> sanphamctr = sanPhamService.ThongKeSanPham("all", null, null);
		if (typeReport != null && typeReport.equals("xls")) {
			return new ModelAndView(new ExcelDanhMucListReportView(), "sanpham", sanphamctr);
		} else if (typeReport != null && typeReport.equals("pdf")) {
			return new ModelAndView(new PdfUserListReportView(), "sanpham", sanphamctr);
		}
		return new ModelAndView("thongke-all", "sanpham", sanphamctr);
	}

	@RequestMapping(value = "/thongke/week", method = RequestMethod.GET)
	public ModelAndView Week(ModelMap modelMap, HttpServletRequest req, HttpServletResponse res) {
		String typeReport = req.getParameter("type");
		List<SanPham> sanphamctr = sanPhamService.ThongKeSanPham("week", null, null);
		if (typeReport != null && typeReport.equals("xls")) {
			return new ModelAndView(new ExcelDanhMucListReportView(), "sanpham", sanphamctr);
		} else if (typeReport != null && typeReport.equals("pdf")) {
			return new ModelAndView(new PdfUserListReportView(), "sanpham", sanphamctr);
		}
		return new ModelAndView("thongke-week", "sanpham", sanphamctr);
	}

	@RequestMapping(value = "/thongke/month", method = RequestMethod.GET)
	public ModelAndView month(ModelMap modelMap, HttpServletRequest req, HttpServletResponse res) {
		String typeReport = req.getParameter("type");
		List<SanPham> sanphamctr = sanPhamService.ThongKeSanPham("month", null, null);
		if (typeReport != null && typeReport.equals("xls")) {
			return new ModelAndView(new ExcelDanhMucListReportView(), "sanpham", sanphamctr);
		} else if (typeReport != null && typeReport.equals("pdf")) {
			return new ModelAndView(new PdfUserListReportView(), "sanpham", sanphamctr);
		}
		return new ModelAndView("thongke-month", "sanpham", sanphamctr);
	}

	@RequestMapping(value = "/thongke/year", method = RequestMethod.GET)
	public ModelAndView year(ModelMap modelMap, HttpServletRequest req, HttpServletResponse res) {
		String typeReport = req.getParameter("type");
		List<SanPham> sanphamctr = sanPhamService.ThongKeSanPham("year", null, null);
		if (typeReport != null && typeReport.equals("xls")) {
			return new ModelAndView(new ExcelDanhMucListReportView(), "sanpham", sanphamctr);
		} else if (typeReport != null && typeReport.equals("pdf")) {
			return new ModelAndView(new PdfUserListReportView(), "sanpham", sanphamctr);
		}
		return new ModelAndView("thongke-year", "sanpham", sanphamctr);
	}

	@RequestMapping(value = "/thongke/day", method = RequestMethod.GET)
	public ModelAndView day(ModelMap modelMap, HttpServletRequest req, HttpServletResponse res) {
		String typeReport = req.getParameter("type");
		List<SanPham> sanphamctr = sanPhamService.ThongKeSanPham("day", null, null);
		if (typeReport != null && typeReport.equals("xls")) {
			return new ModelAndView(new ExcelDanhMucListReportView(), "sanpham", sanphamctr);
		} else if (typeReport != null && typeReport.equals("pdf")) {
			return new ModelAndView(new PdfUserListReportView(), "sanpham", sanphamctr);
		}
		return new ModelAndView("thongke-day", "sanpham", sanphamctr);
	}

}
