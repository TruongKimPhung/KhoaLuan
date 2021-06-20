
package com.dtu.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dtu.model.DanhMucSanPham;
import com.dtu.model.GioHang;
import com.dtu.model.SanPham;
import com.dtu.service.DanhMucService;
import com.dtu.service.SanPhamService;
import com.dtu.service.SearchService;

@Controller
public class TrangChuController {

	@Autowired
	DanhMucService danhMucService;

	@Autowired
	SanPhamService sanPhamService;

	@Autowired
	SearchService searchService;

	@GetMapping("/")
	@Transactional
	public String index(ModelMap model, Principal principal, HttpSession session) throws NullPointerException {
		long start = System.currentTimeMillis();
		int countCart = 0;
		// get all danh muc : madanhmuccha = 0
		List<DanhMucSanPham> danhMucSanPhams = danhMucService.LayDanhMuc(-1);
		// get 10 san pham
		List<SanPham> listSanPhams_NewArrival = sanPhamService.SanPham_All_Paging(-1);
		List<SanPham> listSanPhams_bestseller = sanPhamService.SanPham_All_Paging(-2);
		if (principal != null) {
			model.addAttribute("username", principal.getName());
		}
		try {
			@SuppressWarnings("unchecked")
			List<GioHang> lstGioHangs = (List<GioHang>) session.getAttribute("cart");
			if (lstGioHangs != null) {
				countCart = lstGioHangs.size();
				model.addAttribute("giohangs", lstGioHangs);
			} else {
				System.out.println("chua co gio hang duoc tao controller");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		//dien thoai = 1
		List<SanPham> listdienthoai = sanPhamService.DanhSachSanPhamTheoDanhMuc(0, 1, null, null, null);
		model.addAttribute("listdienthoai", listdienthoai);
		model.addAttribute("countCart", countCart);
		model.addAttribute("listSanPhams_NewArrival", listSanPhams_NewArrival);
		model.addAttribute("listSanPhams_bestseller", listSanPhams_bestseller);
		model.addAttribute("danhmuc", danhMucSanPhams);
		
		long end = System.currentTimeMillis();
		long t = end - start;
		System.out.println("Tổng thời gian: " + t + " millisecond");
		
		return "index";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
		httpSession.invalidate();
		return "dangnhap";
	}

}
