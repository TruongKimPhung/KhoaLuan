package com.dtu.controller;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dtu.model.ChiTietHoaDon;
import com.dtu.model.DanhMucSanPham;
import com.dtu.model.GioHang;
import com.dtu.model.HoaDon;
import com.dtu.model.SanPham;
import com.dtu.model.User;
import com.dtu.service.ChiTietHoaDonService;
import com.dtu.service.DanhMucService;
import com.dtu.service.HoaDonService;
import com.dtu.service.SanPhamService;

@Controller
@SessionAttributes({ "thanhtoan" })
public class ThanhToanController {

	@Autowired
	ChiTietHoaDonService chiTietHoaDonService;

	@Autowired
	HoaDonService hoaDonService;

	@Autowired
	SanPhamService sanPhamService;

	@Autowired
	DanhMucService danhMucService;

	@RequestMapping("/thanhtoan")
	public String Default(Principal principal, HttpSession httpSession, ModelMap modelMap) {
		if (principal != null) {
			modelMap.addAttribute("username", principal.getName());
		}
		List<DanhMucSanPham> danhMucSanPhams = danhMucService.LayDanhMuc(-1);
		try {
			@SuppressWarnings("unchecked")
			List<GioHang> lstGioHangs = (List<GioHang>) httpSession.getAttribute("cart");
			modelMap.addAttribute("danhmuc", danhMucSanPhams);
			if (lstGioHangs != null) {
				modelMap.addAttribute("countCart", lstGioHangs.size());
				modelMap.addAttribute("giohangs", lstGioHangs);
				return "thanhtoan/thanhtoan";

			} else {
				return "redirect:cart";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:cart";

	}

	@RequestMapping("/thanhtoansuccess")
	public String thanhtoansuccess(Principal principal, HttpSession httpSession, ModelMap modelMap) {
		if (principal != null) {
			modelMap.addAttribute("username", principal.getName());
		}
		int countCart = 0;
		List<DanhMucSanPham> danhMucSanPhams = danhMucService.LayDanhMuc(-1);
		try {
			@SuppressWarnings("unchecked")
			List<GioHang> lstGioHangs = (List<GioHang>) httpSession.getAttribute("cart");

			modelMap.addAttribute("danhmuc", danhMucSanPhams);
			if (lstGioHangs != null) {
				countCart = lstGioHangs.size();
				modelMap.addAttribute("giohangs", lstGioHangs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelMap.addAttribute("countCart", countCart);
		return "thanhtoan/thanhtoan-success";
	}

	@RequestMapping(value = "thanhtoangiohang", method = RequestMethod.POST)
	public String ThanhToanGioHang(Principal principal, ModelMap modelMap, HttpSession httpSession,
			@RequestParam String tenkhachhang, @RequestParam String sodt, @RequestParam String diachigiaohang,
			@RequestParam String ghichu) {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		if (httpSession.getAttribute("cart") != null) {
			@SuppressWarnings("unchecked")
			List<GioHang> gioHangs = (List<GioHang>) httpSession.getAttribute("cart");
			User user = new User();
			user.setUsername(principal.getName());
			HoaDon hoaDon = new HoaDon();
			hoaDon.setTenkhachhang(tenkhachhang);
			hoaDon.setSodt(sodt);
			hoaDon.setDiachigiaohang(diachigiaohang);
			try {
				Date date = formatter.parse(dtf.format(now));
				hoaDon.setNgaylap(date);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}

			hoaDon.setGhichu(ghichu);
			hoaDon.setUser(user);
			int idHoaDon = hoaDonService.ThemHoaDon(hoaDon);
			if (idHoaDon > 0) {
				@SuppressWarnings("unused")
				Set<ChiTietHoaDon> listchiTietHoaDons = new HashSet<>();
				for (int i = 0; i < gioHangs.size();) {
					// for (GioHang gioHang : gioHangs) {
					System.out.println(gioHangs.size());
					ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
					chiTietHoaDon.setGiatien(gioHangs.get(i).getGiatien().toString());
					chiTietHoaDon.setSoluong(gioHangs.get(i).getSoluong());

					int giatien = Integer.parseInt(gioHangs.get(i).getGiatien());
					int soluong = gioHangs.get(i).getSoluong();
					chiTietHoaDon.setTongtien(String.valueOf(giatien * soluong));
					SanPham sanPham = new SanPham();
					HoaDon hoadoncreate = new HoaDon();
					hoadoncreate.setMahoadon(hoaDon.getMahoadon());
					sanPham.setMasanpham(gioHangs.get(i).getMasp());
					chiTietHoaDon.setSanpham(sanPham);
					chiTietHoaDon.setHoadon(hoadoncreate);
					chiTietHoaDon.setNgaylaphoadon(dtf.format(now));
					chiTietHoaDonService.ThemChiTietHoaDon(chiTietHoaDon);
					sanPhamService.UpdateSoluongSP_ThanhToan(gioHangs.get(i).getMasp(), soluong);
					try {
						int check = RemoveCart(httpSession, gioHangs.get(i).getMasp(), 1);
						// int check = 0;
						if (check == -1) {
							System.out.println("xoa all gio hang that bai");
							@SuppressWarnings("unchecked")
							List<GioHang> gioHangs123 = (List<GioHang>) httpSession.getAttribute("cart");
							System.out.println(gioHangs123.size());
						} else {
							@SuppressWarnings("unchecked")
							List<GioHang> gioHangs123 = (List<GioHang>) httpSession.getAttribute("cart");
							System.out.println(gioHangs123.size());
							System.out.println("xoa all gio hang");
						}

					} catch (ConcurrentModificationException e) {
						e.printStackTrace();
					}

					// }
				}
			} else {
				System.out.println("Them tb");
			}
		}
		return "redirect:thanhtoansuccess";
	}

	private int KiemTraSanPhamDaTonTaiGioHang(List<GioHang> listGioHangs, HttpSession httpSession, int masp) {

		for (int i = 0; i < listGioHangs.size(); i++) {
			if (listGioHangs.get(i).getMachitiet() == masp) {
				return i;
			}
		}

		return -1;
	}

	public int RemoveCart(HttpSession httpSession, @RequestParam int masp, @RequestParam int wishlisted) {
		try {
			if (httpSession.getAttribute("cart") != null) {
				@SuppressWarnings("unchecked")
				List<GioHang> listGioHangs = (List<GioHang>) httpSession.getAttribute("cart");
				int vitri = KiemTraSanPhamDaTonTaiGioHang(listGioHangs, httpSession, masp);

				listGioHangs.remove(vitri);
				System.out.println("Xóa WishList thành công " + masp);
				return listGioHangs.size();
			}
		} catch (Exception e) {
			e.getStackTrace();
			return -1;
		}

		return -1;
	}

}
