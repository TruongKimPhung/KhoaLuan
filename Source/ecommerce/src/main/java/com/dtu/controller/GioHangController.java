package com.dtu.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dtu.model.DanhMucSanPham;
import com.dtu.model.GioHang;
import com.dtu.model.SanPham;
import com.dtu.service.DanhMucService;
import com.dtu.service.SanPhamService;

@Controller
@RequestMapping("cart")
@SessionAttributes({ "cart" })
public class GioHangController {

	@Autowired
	SanPhamService sanPhamService;
	
	@Autowired
	DanhMucService danhMucService;

	@GetMapping
	public String Default(Principal principal,HttpSession httpSession, ModelMap modelMap) throws NullPointerException {
		if (principal != null) {
			modelMap.addAttribute("username", principal.getName());
		}
		try {
			if (httpSession.getAttribute("cart") != null) {
				@SuppressWarnings("unchecked")
				List<GioHang> gioHangs = (List<GioHang>) httpSession.getAttribute("cart");
				modelMap.addAttribute("countCart", gioHangs.size());
				modelMap.addAttribute("giohangs", gioHangs);
			} else {
				System.out.println("chua co gio hang");
			}
		} catch (Exception e) {
			System.out.println("loi null roi");
		}
		List<DanhMucSanPham> danhMucSanPhams = danhMucService.LayDanhMuc(-1);
		modelMap.addAttribute("danhmuc", danhMucSanPhams);
		return "giohang/shopping-cart";

	}
	@GetMapping("/AddCart")
	@ResponseBody
	public List<String> AddCart(@RequestParam int dungluong, @RequestParam String tensanpham, @RequestParam int machitietsanpham,
			@RequestParam int soluong, @RequestParam String hinhsanpham, @RequestParam String giatien,
			HttpSession httpSession) {
		List<String> value = new ArrayList<String>();
		String html = "";
		int check = 0;
		if (httpSession.getAttribute("cart") == null) {
			List<GioHang> gioHangs = new ArrayList<GioHang>();
			GioHang gioHang = new GioHang();
			gioHang.setTensp(tensanpham);
			gioHang.setHinhsanpham(hinhsanpham);
			gioHang.setGiatien(giatien);
			gioHang.setSoluong(soluong);
			gioHang.setMasp(machitietsanpham);
			gioHang.setMachitiet(machitietsanpham);
			gioHang.setDungluong(dungluong);
			gioHangs.add(gioHang);
			httpSession.setAttribute("cart", gioHangs);
			String href = "/ecommerce/resources/images/product/large-size/"
					+ gioHang.getHinhsanpham();
			html += "<li>";
			html += "<a href='single-product.html' class='minicart-product-image'>";
			html += "<img src=" + href + " alt='cart products'>";
			html += "</a>";
			html += "<div class='minicart-product-details'>";
			html += "<h6>";
			html += "<a href='single-product.html'>" + gioHang.getTensp() + " </a>";
			html += "</h6>";
			html += "<span class=''>" + gioHang.getGiatien() + "</span>";
			html += "</div>";
			html += "<button data-masp=" + gioHang.getMasp()
					+ " class='close remove-listcart' title='Remove'>";
			html += "<i class='fa fa-close'></i>";
			html += "</button>";
			html += "</li>";
			value.add("1");
			value.add(html);
		} else {
			@SuppressWarnings("unchecked")
			List<GioHang> listGioHangs = (List<GioHang>) httpSession.getAttribute("cart");
			int vitri = KiemTraSanPhamDaTonTaiGioHang(listGioHangs, httpSession, machitietsanpham);
			if (vitri == -1) {

				GioHang gioHang = new GioHang();
				gioHang.setTensp(tensanpham);
				gioHang.setHinhsanpham(hinhsanpham);
				gioHang.setGiatien(giatien);
				gioHang.setMachitiet(machitietsanpham);
				gioHang.setMasp(machitietsanpham);
				gioHang.setDungluong(dungluong);
				gioHang.setSoluong(soluong);
				listGioHangs.add(gioHang);
				int countCart = listGioHangs.size();
				String href = "/ecommerce/resources/images/product/large-size/"
						+ gioHang.getHinhsanpham();
				html += "<li>";
				html += "<a href='single-product.html' class='minicart-product-image'>";
				html += "<img src=" + href + " alt='cart products'>";
				html += "</a>";
				html += "<div class='minicart-product-details'>";
				html += "<h6>";
				html += "<a href='single-product.html'>" + gioHang.getTensp() + " </a>";
				html += "</h6>";
				html += "<span class=''>" + gioHang.getGiatien() + "</span>";
				html += "</div>";
				html += "<button data-masp=" + gioHang.getMasp()
						+ " class='close remove-listcart' title='Remove'>";
				html += "<i class='fa fa-close'></i>";
				html += "</button>";
				html += "</li>";
				check = 1;
				value.add(String.valueOf(countCart));
				value.add(html);
			} else {
				SanPham checksl = sanPhamService.GetSanPham_MaSanPham(machitietsanpham);
				if(listGioHangs.get(vitri).getSoluong() == checksl.getSoluong()){
					check = 0;
					value.add("-1");
					value.add(null);
				} else if(listGioHangs.get(vitri).getSoluong() < checksl.getSoluong()){
					int soluongmoi = listGioHangs.get(vitri).getSoluong() + 1;
					listGioHangs.get(vitri).setSoluong(soluongmoi);
					value.add("-2");
					value.add(null);
				}
			}
		}
		if(check == 1) {
			return value;
		} else if(check == 0){
			return value;
		} else {
			return value;
		}
	}
	
	private int KiemTraSanPhamDaTonTaiGioHang(List<GioHang> listGioHangs, HttpSession httpSession, int masp) {

		for (int i = 0; i < listGioHangs.size(); i++) {
			if (listGioHangs.get(i).getMasp() == masp) {
				return i;
			}
		}

		return -1;
	}

	@GetMapping("RemoveCart")
	@ResponseBody
	public int RemoveCart(HttpSession httpSession, @RequestParam int masp, @RequestParam int wishlisted) {
		try {
			if (httpSession.getAttribute("cart") != null) {
				@SuppressWarnings("unchecked")
				List<GioHang> listGioHangs = (List<GioHang>) httpSession.getAttribute("cart");
				int vitri = KiemTraSanPhamDaTonTaiGioHang(listGioHangs, httpSession, masp);
				if(vitri != -1) {
					listGioHangs.remove(vitri);
					System.out.println("Xóa WishList thành công " + masp);
					httpSession.setAttribute("cart", null);
					return listGioHangs.size();
				}
			}
		} catch (Exception e) {
			e.getStackTrace();
		}

		return 0;
	}

	@GetMapping("/CountCart")
	@ResponseBody
	public String CountCart(HttpSession httpSession) {
		if (httpSession.getAttribute("cart") != null) {
			@SuppressWarnings("unchecked")
			List<GioHang> gioHangs = (List<GioHang>) httpSession.getAttribute("cart");
			return gioHangs.size() + "";
		}
		return null;
	}

	@GetMapping("/UpdateCart")
	@ResponseBody
	public int UpdateCart(HttpSession httpSession, @RequestParam int soluongupdate, @RequestParam int masanpham) {
		int checksoluong = 0;
		if (httpSession.getAttribute("cart") != null) {
			@SuppressWarnings("unchecked")
			List<GioHang> listGioHangs = (List<GioHang>) httpSession.getAttribute("cart");
			int vitri = KiemTraSanPhamDaTonTaiGioHang(listGioHangs, httpSession, masanpham);
			System.out.println("dang update so luong cua moi sang pham o gio hang");
			SanPham checksl = sanPhamService.GetSanPham_MaSanPham(masanpham);
			if(checksl.getSoluong() - soluongupdate >= 0) {
				checksoluong = -1;
				listGioHangs.get(vitri).setSoluong(soluongupdate);
			} else {
				checksoluong = checksl.getSoluong();
			}
		}
		return checksoluong;
	}

}
