package com.dtu.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dtu.model.SanPham;
import com.dtu.service.ChiTietHoaDonService;
import com.dtu.service.SanPhamService;
import com.fasterxml.jackson.core.io.JsonEOFException;

@Controller  
public class MemberController {
	@Autowired 
	ChiTietHoaDonService chiTietHoaDonService;

	@Autowired
	SanPhamService sanPhamService;

	@GetMapping("/member")
	public String member(Model model, Principal principal) throws JsonEOFException {
		SanPham sanpham = sanPhamService.GetSanPham_MaSanPham(1);
		model.addAttribute("sanpham", sanpham);
		return "member";
	}

}
