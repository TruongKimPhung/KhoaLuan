package com.dtu.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dtu.model.DanhMucSanPham;
import com.dtu.model.GioHang;
import com.dtu.model.SanPham;
import com.dtu.service.DanhMucService;
import com.dtu.service.SanPhamService;

@Controller
@RequestMapping("compare")
public class CompareController {

	@Autowired
	SanPhamService sanPhamService;

	@Autowired
	DanhMucService danhMucService;

	@GetMapping("/{tensanpham}")
	public String Compare(Principal principal, @PathVariable String tensanpham, ModelMap modelMap,
			HttpSession session) {
		List<DanhMucSanPham> danhMucSanPhams = danhMucService.LayDanhMuc(-1);
		try {
			@SuppressWarnings("unchecked")
			List<GioHang> lstGioHangs = (List<GioHang>) session.getAttribute("cart");
			if (lstGioHangs != null) {
				modelMap.addAttribute("giohangs", lstGioHangs);
				modelMap.addAttribute("countCart", lstGioHangs.size());

			} else {
				System.out.println("chua co gio hang duoc tao controller");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (principal != null) {
			modelMap.addAttribute("username", principal.getName());
		}

		int masanpham = Integer.parseInt(tensanpham.substring(0, tensanpham.indexOf(" ")));
		int maspcompare = Integer.parseInt(tensanpham.substring(tensanpham.indexOf(" ") + 1,
				tensanpham.indexOf(" ", tensanpham.indexOf(" ") + 1)));
		SanPham sp = sanPhamService.GetSanPham_MaSanPham(masanpham);
		SanPham spCompare = sanPhamService.GetSanPham_MaSanPham(maspcompare);

		modelMap.addAttribute("danhmuc", danhMucSanPhams);
		modelMap.addAttribute("sp", sp);
		modelMap.addAttribute("spCompare", spCompare);
		return "compare/compare";
	}
}
