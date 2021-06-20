package com.dtu.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dtu.model.DanhMucSanPham;
import com.dtu.model.GioHang;
import com.dtu.model.SanPham;
import com.dtu.service.DanhMucService;
import com.dtu.service.SanPhamService;

@Controller
@RequestMapping("/chitiet")
@SessionAttributes("giohang")
public class ChiTietController {

	@Autowired
	SanPhamService sanPhamService;

	@Autowired
	DanhMucService danhMucService;

	@GetMapping("/{masanpham}")
	public String Default(Principal principal,@PathVariable int masanpham, ModelMap modelMap, HttpSession httpSession) {
		SanPham sanpham = sanPhamService.GetSanPham_MutilImageById(masanpham);
		List<SanPham> lstCompare = sanPhamService.ListSanPhamConpare(String.valueOf(sanpham.getGiatien()));
		String[] words = sanpham.getHinhsanpham().split(",");
		modelMap.addAttribute("hinhsanpham", words);
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(words));
		sanpham.setHinhsanpham(list.get(0));

		List<DanhMucSanPham> danhMucSanPhams = danhMucService.LayDanhMuc(-1);

		if (httpSession.getAttribute("cart") != null) {
			@SuppressWarnings("unchecked")
			List<GioHang> gioHangs = (List<GioHang>) httpSession.getAttribute("cart");
			modelMap.addAttribute("countCart", gioHangs.size());
			modelMap.addAttribute("giohangs", gioHangs);
		}
		if (principal != null) {
			modelMap.addAttribute("username", principal.getName());
		}

		modelMap.addAttribute("sanpham", sanpham);
		modelMap.addAttribute("danhmuc", danhMucSanPhams);
		modelMap.addAttribute("lstCompare", lstCompare);

		return "chitietsanpham/chitietsanpham";
	}

}
