package com.dtu.controller;

import java.io.IOException;
import java.security.Principal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dtu.model.Authorities;
import com.dtu.model.DanhMucSanPham;
import com.dtu.model.SanPham;
import com.dtu.model.User;
import com.dtu.service.ChiTietHoaDonService;
import com.dtu.service.DanhMucService;
import com.dtu.service.HoaDonService;
import com.dtu.service.SanPhamService;
import com.dtu.service.UserService;
import com.dtu.view.ExcelDanhMucListReportView;
import com.dtu.view.PdfUserListReportView;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	UserService userService;

	@Autowired
	SanPhamService sanPhamService;

	@Autowired
	HoaDonService hoaDonService;

	@Autowired
	DanhMucService danhMucService;

	@Autowired
	ChiTietHoaDonService chiTietHoaDonService;

	// trang chu admin
	@RequestMapping()
	public String Default(ModelMap modelMap, Principal principal) {
		String pattern = "#,##,###";
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int month = localDate.getMonthValue();
		if (month == 1) {

		}
		DecimalFormat decimalFormat = new DecimalFormat(pattern);

		ArrayList<Double> tongdoanhthu = sanPhamService.ThongKeDoanhThuMoiThang();
		String phantram = format_phantram_double(tongdoanhthu.get(month), tongdoanhthu.get(month - 1));
		long doanhthu = (long) Math.floor(tongdoanhthu.get(month) + 0.5d);
		String format_doanhthu = decimalFormat.format(doanhthu);
		modelMap.addAttribute("doanhthu", format_doanhthu);
		modelMap.addAttribute("phantram", phantram);

		ArrayList<Long> thongkesoluong = sanPhamService.ThongKeSoLuongMoiThang();
		String phantram_soluong = format_phantram(thongkesoluong.get(month), thongkesoluong.get(month - 1));
		String soluong = decimalFormat.format(thongkesoluong.get(month));
		modelMap.addAttribute("soluong", soluong);
		modelMap.addAttribute("phantram_soluong", phantram_soluong);

		ArrayList<Long> thongkeuser = userService.ThongKeUserMoiThang();
		String phantram_user = format_phantram(thongkeuser.get(month), thongkeuser.get(month - 1));
		String soluong_user = decimalFormat.format(thongkeuser.get(month));
		modelMap.addAttribute("soluong_user", soluong_user);
		modelMap.addAttribute("phantram_user", phantram_user);
		modelMap.addAttribute("username", principal.getName());

		return "admin/index";
	}

	// Admin : quan ly san pham
	@RequestMapping("/sanpham")
	public String DataTable(ModelMap modelMap) {
		List<SanPham> allSanPham = sanPhamService.SanPham_All_Paging(0);
		modelMap.addAttribute("allSanPham", allSanPham);
		return "admin/sanpham";
	}

	// Admin : them san pham
	@RequestMapping("/themsanpham")
	public String ThemSanPham(ModelMap modelMap) {
		List<DanhMucSanPham> danhMucSanPhams = danhMucService.LayDanhMucCha(0);
		modelMap.addAttribute("danhmuc", danhMucSanPhams);
		return "admin/sanpham-themsanpham";
	}

	// Admin : thong ke san pham
	@RequestMapping("/thongke-sanpham")
	public ModelAndView Thongke_sanpham(ModelMap modelMap, HttpServletRequest req, HttpServletResponse res) {
		String typeReport = req.getParameter("type");
		List<SanPham> sanphamctr = sanPhamService.ThongKeSanPham("all", null, null);
		if (typeReport != null && typeReport.equals("xls")) {
			return new ModelAndView(new ExcelDanhMucListReportView(), "sanpham", sanphamctr);
		} else if (typeReport != null && typeReport.equals("pdf")) {
			return new ModelAndView(new PdfUserListReportView(), "sanpham", sanphamctr);
		}
		return new ModelAndView("admin/thongke-sanpham", "sanpham", sanphamctr);
	}

	// Admin : thong ke san pham - all
	@RequestMapping(value = "/thongke-sanpham-all", method = RequestMethod.GET)
	public ModelAndView all(ModelMap modelMap, HttpServletRequest req, HttpServletResponse res) {
		String typeReport = req.getParameter("type");
		List<SanPham> sanphamctr = sanPhamService.ThongKeSanPham("all", null, null);
		if (typeReport != null && typeReport.equals("xls")) {
			return new ModelAndView(new ExcelDanhMucListReportView(), "sanpham", sanphamctr);
		} else if (typeReport != null && typeReport.equals("pdf")) {
			return new ModelAndView(new PdfUserListReportView(), "sanpham", sanphamctr);
		}
		return new ModelAndView("admin/thongke-sanpham-all", "sanpham", sanphamctr);
	}

	// Admin : thongke-sanpham-week
	@RequestMapping(value = "/thongke-sanpham-week", method = RequestMethod.GET)
	public ModelAndView Week(ModelMap modelMap, HttpServletRequest req, HttpServletResponse res) {
		String typeReport = req.getParameter("type");
		List<SanPham> sanphamctr = sanPhamService.ThongKeSanPham("week", null, null);
		if (typeReport != null && typeReport.equals("xls")) {
			return new ModelAndView(new ExcelDanhMucListReportView(), "sanpham", sanphamctr);
		} else if (typeReport != null && typeReport.equals("pdf")) {
			return new ModelAndView(new PdfUserListReportView(), "sanpham", sanphamctr);
		}
		return new ModelAndView("admin/thongke-sanpham-week", "sanpham", sanphamctr);
	}

	// Admin : thongke-sanpham-month
	@RequestMapping(value = "/thongke-sanpham-month", method = RequestMethod.GET)
	public ModelAndView month(ModelMap modelMap, HttpServletRequest req, HttpServletResponse res) {
		String typeReport = req.getParameter("type");
		List<SanPham> sanphamctr = sanPhamService.ThongKeSanPham("month", null, null);
		if (typeReport != null && typeReport.equals("xls")) {
			return new ModelAndView(new ExcelDanhMucListReportView(), "sanpham", sanphamctr);
		} else if (typeReport != null && typeReport.equals("pdf")) {
			return new ModelAndView(new PdfUserListReportView(), "sanpham", sanphamctr);
		}
		return new ModelAndView("admin/thongke-sanpham-month", "sanpham", sanphamctr);
	}

	// Admin : thongke-sanpham-year
	@RequestMapping(value = "/thongke-sanpham-year", method = RequestMethod.GET)
	public ModelAndView year(ModelMap modelMap, HttpServletRequest req, HttpServletResponse res) {
		String typeReport = req.getParameter("type");
		List<SanPham> sanphamctr = sanPhamService.ThongKeSanPham("year", null, null);
		if (typeReport != null && typeReport.equals("xls")) {
			return new ModelAndView(new ExcelDanhMucListReportView(), "sanpham", sanphamctr);
		} else if (typeReport != null && typeReport.equals("pdf")) {
			return new ModelAndView(new PdfUserListReportView(), "sanpham", sanphamctr);
		}
		return new ModelAndView("admin/thongke-sanpham-year", "sanpham", sanphamctr);
	}

	// Admin : thongke-sanpham-day
	@RequestMapping(value = "/thongke-sanpham-day", method = RequestMethod.GET)
	public ModelAndView day(ModelMap modelMap, HttpServletRequest req, HttpServletResponse res) {
		String typeReport = req.getParameter("type");
		List<SanPham> sanphamctr = sanPhamService.ThongKeSanPham("day", null, null);
		if (typeReport != null && typeReport.equals("xls")) {
			return new ModelAndView(new ExcelDanhMucListReportView(), "sanpham", sanphamctr);
		} else if (typeReport != null && typeReport.equals("pdf")) {
			return new ModelAndView(new PdfUserListReportView(), "sanpham", sanphamctr);
		}
		return new ModelAndView("admin/thongke-sanpham-day", "sanpham", sanphamctr);
	}

	// admin : quan ly user
	@RequestMapping("/qluser")
	public String User(ModelMap modelMap) {
		List<User> user = userService.getUser();
		modelMap.addAttribute("user", user);
		return "admin/user";
	}

	// admin : update user
	@RequestMapping("qluser/{username}")
	public String Admin_UpdateUser(@PathVariable String username, ModelMap modelMap) {
		User user = userService.getUserById(username);
		List<Authorities> Authorities = userService.lstAuthorities(username);
		List<Authorities> AllAuthorities1 = userService.lstAuthorities(null);
		List<String> lstDistrin = new ArrayList<String>();
		List<String> AllAuthorities = new ArrayList<String>();
		if (Authorities.size() != 0) {
			for (Authorities authorities : Authorities) {
				modelMap.addAttribute("role", authorities.getAuthority());
			}
		} else {
			modelMap.addAttribute("role", null);
		}
		for (Authorities authorities : AllAuthorities1) {
			lstDistrin.add(authorities.getAuthority());
		}
		for (String element : lstDistrin) {
			if (!AllAuthorities.contains(element)) {
				AllAuthorities.add(element);
			}
		}
		modelMap.addAttribute("user", user);
		modelMap.addAttribute("AllAuthorities", AllAuthorities);
		return "admin/updateuser";
	}

	// Form : update user
	@PostMapping("updateuseradmin")
	@ResponseBody
	public int updateuseradmin(@RequestParam String dataJson) {
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonObject;
		String username = null;
		try {
			jsonObject = objectMapper.readTree(dataJson);
			JsonNode jsonChitiet = jsonObject.get("username");
			for (JsonNode objectChiTiet : jsonChitiet) {
				username = objectChiTiet.get("username").asText();
			}

			userService.UpdateUserAdmin(jsonObject, username);
			return 1;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// Admin : xoa user
	@GetMapping("/DeleteUser")
	@ResponseBody
	public String XoaDanhMuc(@RequestParam String username) {
		userService.XoaUserTheoMaUser(username);
		return "true";
	}

	// Thong ke doanh so trong nam
	@PostMapping("/getvalueChar_DoanhSo")
	@ResponseBody
	public int[] getvalueChar() {
		ArrayList<Double> tongdoanhthu = sanPhamService.ThongKeDoanhThuMoiThang();
		int[] ret = new int[tongdoanhthu.size()];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = tongdoanhthu.get(i).intValue();
		}
		return ret;
	}

	// Thong ke so luong trong nam
	@PostMapping("/getvalueChar_Soluong")
	@ResponseBody
	public int[] getvalueChar_Soluong() {
		ArrayList<Long> tongdoanhthu = sanPhamService.ThongKeSoLuongMoiThang();

		int[] ret = new int[tongdoanhthu.size()];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = tongdoanhthu.get(i).intValue();
		}
		return ret;
	}

	// Thong ke So luong ban cua moi san pham
	@SuppressWarnings("unchecked")
	@PostMapping("/getvalueChar_SanPham")
	@ResponseBody
	public JSONObject getvalueChar_User() {
		List<SanPham> list1 = sanPhamService.getSoLuong_SP();
		Long tongsoluong_sanpham = chiTietHoaDonService.lstChiTietHoaDon(0, 1);
		HashMap<String, String> hm_sanpham_soluong = new HashMap<String, String>();
		Long tongsoluong_conlai = (long) 0;
		int count = 0;
		for (int i = 0; i < list1.size(); i++) {
			Long tongsoluong = chiTietHoaDonService.lstChiTietHoaDon(list1.get(i).getMasanpham(), 0);
			if (tongsoluong > 0) {
				System.out.println(list1.get(i).getMasanpham());
				count++;

				if (count > 9) {
					tongsoluong_conlai += tongsoluong;
					continue;
				} else {
					String phantram = format_phantram(tongsoluong, tongsoluong_sanpham);
					hm_sanpham_soluong.put(phantram, list1.get(i).getTensanpham());
				}
			}
		}
		System.out.println(tongsoluong_sanpham + " tongsoluong_conlai " + tongsoluong_conlai);
		if (tongsoluong_conlai > 0) {
			String phantram_conlai = format_phantram(tongsoluong_conlai, tongsoluong_sanpham);
			hm_sanpham_soluong.put(phantram_conlai, "Sản phẩm khác");
		}
		JSONObject json = new JSONObject();
		json.putAll(hm_sanpham_soluong);
		System.out.println(json);
		return json;
	}

	// format phan tram kieu long
	public String format_phantram(long chia, long bichia) {
		String month_curent = String.valueOf(chia);
		String month_curent_1 = String.valueOf(bichia);
		String format_soluong = null;
		if (bichia == 0) {
			format_soluong = String.format("%.2f", Double.parseDouble(month_curent));
			return format_soluong;
		}
		Double phantram_soluong = (Double.parseDouble(month_curent) / Double.parseDouble(month_curent_1)) * 100;
		format_soluong = String.format("%.2f", phantram_soluong);
		return format_soluong;

	}

	// format phan tram kieu double
	public String format_phantram_double(double chia, double bichia) {
		String format_soluong = null;
		if (bichia == 0) {
			format_soluong = String.format("%.2f", chia);
			return format_soluong;
		}
		Double phantram_soluong = (chia / bichia) * 100;
		format_soluong = String.format("%.2f", phantram_soluong);
		return format_soluong;

	}

}
