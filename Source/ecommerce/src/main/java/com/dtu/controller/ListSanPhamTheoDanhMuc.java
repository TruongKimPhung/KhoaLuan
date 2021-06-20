package com.dtu.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dtu.model.DanhMucSanPham;
import com.dtu.model.GioHang;
import com.dtu.model.SanPham;
import com.dtu.service.DanhMucService;
import com.dtu.service.SanPhamService;

@Controller
public class ListSanPhamTheoDanhMuc {

	@Autowired
	DanhMucService danhMucService;

	@Autowired
	SanPhamService sanPhamService;

	@GetMapping("/{id}/{tendanhmuc}")
	public String SanPhamTheoDanhMuc(Principal principal, HttpSession session, ModelMap modelMap, @PathVariable int id,
			@PathVariable String tendanhmuc) {
		if (principal != null) {
			modelMap.addAttribute("username", principal.getName());
		}
		int countCart = 0;
		List<SanPham> listSanPham = sanPhamService.DanhSachSanPhamTheoDanhMuc(0, id, null, null, null);
		List<SanPham> getRom = danhMucService.getDistintRomOfDanhMuc(id);
		List<SanPham> getRam = danhMucService.getDistintRamOfDanhMuc(id);
		List<DanhMucSanPham> getDanhMucofMaDanhMuc = danhMucService.getDanhMucChu(id);
		List<DanhMucSanPham> danhMucSanPhams = danhMucService.LayDanhMuc(-1);
		try {
			@SuppressWarnings("unchecked")
			List<GioHang> lstGioHangs = (List<GioHang>) session.getAttribute("cart");
			if (lstGioHangs != null) {
				countCart = lstGioHangs.size();
				modelMap.addAttribute("giohangs", lstGioHangs);

			} else {
				System.out.println("chua co gio hang duoc tao controller");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		modelMap.addAttribute("danhmuc", danhMucSanPhams);
		modelMap.addAttribute("countCart", countCart);
		modelMap.addAttribute("tendanhmuc", tendanhmuc);
		modelMap.addAttribute("madanhmuc", id);
		modelMap.addAttribute("listSanPham", listSanPham);
		modelMap.addAttribute("getRom", getRom);
		modelMap.addAttribute("getRam", getRam);
		modelMap.addAttribute("getDanhMucofMaDanhMuc", getDanhMucofMaDanhMuc);
		return "danhmucsanpham/danhmuc";
	}

	@PostMapping("/danhmuc/LstTheoDanhMuc")
	@ResponseBody
	public String LstTheoDanhMuc(ModelMap modelMap, @RequestParam String valueSelected, @RequestParam int madanhmuc,
			@RequestParam String dungluong, @RequestParam String dungluongram, @RequestParam String giatien) {
		System.out.println(dungluong + " - " + valueSelected);
		List<SanPham> listSanPham = null;
		if (dungluong == "") {
			dungluong = null;
		}
		if (dungluongram == "") {
			dungluongram = null;
		}
		if (valueSelected.equals("default") || valueSelected.equals("")) {
			listSanPham = sanPhamService.DanhSachSanPhamTheoDanhMuc(0, madanhmuc, dungluong, dungluongram, giatien);
		} else if (valueSelected.equals("name_AZ")) {
			listSanPham = sanPhamService.DanhSachSanPhamTheoDanhMuc(-1, madanhmuc, dungluong, dungluongram, giatien);
		} else if (valueSelected.equals("name_ZA")) {
			listSanPham = sanPhamService.DanhSachSanPhamTheoDanhMuc(-2, madanhmuc, dungluong, dungluongram, giatien);
		} else if (valueSelected.equals("price_AZ")) {
			listSanPham = sanPhamService.DanhSachSanPhamTheoDanhMuc(-3, madanhmuc, dungluong, dungluongram, giatien);
		} else if (valueSelected.equals("price_ZA")) {
			listSanPham = sanPhamService.DanhSachSanPhamTheoDanhMuc(-4, madanhmuc, dungluong, dungluongram, giatien);
		}

		String html = "";
		for (SanPham sanpham : listSanPham) {
			String href = "/ecommerce/resources/images/product/large-size/" + sanpham.getHinhsanpham();
			String src_product = "/ecommerce/chitiet/"+sanpham.getMasanpham();
			html += "<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />";
			html += "<div class='col-lg-4 col-md-4 col-sm-6 mt-40'>";
			html += "<div class='single-product-wrap'>";
			html += "<div class='product-image'>";
			html += "<a href="+src_product+"> <img src=" + href
					+ " alt='Li's Product Image'/></a> <span class='sticker'>New</span></div>";
			html += "<div class='product_desc'>";
			html += "<div class='product_desc_info'>";
			html += "<h4>";
			html += "<a class='product_name' href="+src_product+">" + sanpham.getTensanpham() + "</a>";
			html += "</h4>";
			html += "<div class='price-box'>";
			html += "<span class='new-price'>$" + sanpham.getGiatien() + "</span>";
			html += "</div>";
			html += "</div>";
			html += "<div class='add-actions'>";
			html += "<ul class='add-actions-link'>";
			html += "<li class='add-cart active add-lstcart' data-dungluong= '"+sanpham.getRom()+"' data-hinhsanpham='"+sanpham.getHinhsanpham()+"' data-tiensanpham='"+sanpham.getGiatien()+"' data-machitiet='"+sanpham.getMasanpham()+"' data-tensanpham='"+sanpham.getTensanpham()+"'>";
			html += " Add to cart</li>";
			html += "</ul>";
			html += "</div>";
			html += "</div>";
			html += "</div>";
			html += "</div>";
		}
		return html;
	}
}
