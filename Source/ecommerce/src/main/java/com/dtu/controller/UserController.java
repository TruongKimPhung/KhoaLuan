package com.dtu.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dtu.model.DanhMucSanPham;
import com.dtu.model.GioHang;
import com.dtu.model.User;
import com.dtu.service.DanhMucService;
import com.dtu.service.HoaDonService;
import com.dtu.service.UserService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	HoaDonService hoaDonService;

	@Autowired
	DanhMucService danhMucService;

	// di chuyen vao trang user
	@RequestMapping()
	public String Default(HttpSession httpSession, Principal principal, ModelMap modelMap) {
		if (principal != null) {
			modelMap.addAttribute("username", principal.getName());
		}
		User user = userService.getUserById(principal.getName());
		modelMap.addAttribute("user", user);

		int countCart = 0;
		List<DanhMucSanPham> danhMucSanPhams = danhMucService.LayDanhMuc(-1);
		modelMap.addAttribute("danhmuc", danhMucSanPhams);
		try {
			@SuppressWarnings("unchecked")
			List<GioHang> lstGioHangs = (List<GioHang>) httpSession.getAttribute("cart");

			modelMap.addAttribute("danhmuc", danhMucSanPhams);
			if (lstGioHangs != null) {
				countCart = lstGioHangs.size();
				modelMap.addAttribute("giohangs", lstGioHangs);
			} else {
				countCart = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelMap.addAttribute("countCart", countCart);
		return "user/user-index";
	}

	// di chuyen trang lich su mua hang
	@RequestMapping("/lichsumuahang")
	public String LichSuMuaHang(HttpSession httpSession, Principal principal, ModelMap modelMap) {
		if (principal != null) {
			modelMap.addAttribute("username", principal.getName());
		}
		User user = userService.getUserById(principal.getName());
		modelMap.addAttribute("user", user);
		int countCart = 0;
		List<DanhMucSanPham> danhMucSanPhams = danhMucService.LayDanhMuc(-1);
		modelMap.addAttribute("danhmuc", danhMucSanPhams);
		try {
			@SuppressWarnings("unchecked")
			List<GioHang> lstGioHangs = (List<GioHang>) httpSession.getAttribute("cart");

			modelMap.addAttribute("danhmuc", danhMucSanPhams);
			if (lstGioHangs != null) {
				countCart = lstGioHangs.size();
				modelMap.addAttribute("giohangs", lstGioHangs);
			} else {
				countCart = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelMap.addAttribute("countCart", countCart);
		return "user/user-history-shoping-cart";
	}

	// chi tiet username
	@RequestMapping("/{username}")
	public String UpdateUser(HttpSession httpSession, Principal principal, @PathVariable String username,
			ModelMap modelMap) {
		if (principal != null) {
			modelMap.addAttribute("username", principal.getName());
		}
		User user = userService.getUserById(principal.getName());
		modelMap.addAttribute("user", user);
		int countCart = 0;
		List<DanhMucSanPham> danhMucSanPhams = danhMucService.LayDanhMuc(-1);
		modelMap.addAttribute("danhmuc", danhMucSanPhams);
		try {
			@SuppressWarnings("unchecked")
			List<GioHang> lstGioHangs = (List<GioHang>) httpSession.getAttribute("cart");

			modelMap.addAttribute("danhmuc", danhMucSanPhams);
			if (lstGioHangs != null) {
				countCart = lstGioHangs.size();
				modelMap.addAttribute("giohangs", lstGioHangs);
			} else {
				countCart = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelMap.addAttribute("countCart", countCart);
		return "user/updateuser";
	}

	// di chuyen toi trang doi mat khau
	@RequestMapping("/doimatkhau")
	public String UpdatePW(HttpSession httpSession, Principal principal, ModelMap modelMap) {
		if (principal != null) {
			modelMap.addAttribute("username", principal.getName());
		}
		User user = userService.getUserById(principal.getName());
		modelMap.addAttribute("user", user);
		int countCart = 0;
		List<DanhMucSanPham> danhMucSanPhams = danhMucService.LayDanhMuc(-1);
		modelMap.addAttribute("danhmuc", danhMucSanPhams);
		try {
			@SuppressWarnings("unchecked")
			List<GioHang> lstGioHangs = (List<GioHang>) httpSession.getAttribute("cart");

			modelMap.addAttribute("danhmuc", danhMucSanPhams);
			if (lstGioHangs != null) {
				countCart = lstGioHangs.size();
				modelMap.addAttribute("giohangs", lstGioHangs);
			} else {
				countCart = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelMap.addAttribute("countCart", countCart);
		return "user/doimatkhau";
	}

	// update mat khau
	@SuppressWarnings("unused")
	@PostMapping("UpdateMatKhau")
	@ResponseBody
	public String DoiMatKhau(@RequestParam String dataJson) {
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonObject = null;
		String username = null, password = null, newpassword = null;
		String confirmpassword = null;
		String message = null;
		try {
			jsonObject = objectMapper.readTree(dataJson);
			JsonNode jsonChitiet = jsonObject.get("username");
			for (JsonNode objectChiTiet : jsonChitiet) {
				username = objectChiTiet.get("username").asText();
			}

			password = jsonObject.get("password").asText();
			newpassword = jsonObject.get("newpassword").asText();
			confirmpassword = jsonObject.get("confirmpassword").asText();
		} catch (IOException e) {
			e.printStackTrace();
		}
		User user = userService.getUserById(username);
		boolean valuate = BCrypt.checkpw(password, user.getPassword());
		String hash = BCrypt.hashpw(newpassword, BCrypt.gensalt(12));
		if (valuate == true) {
			if (newpassword != null && newpassword != "" && confirmpassword != null && confirmpassword != "") {
				if (newpassword.equals(confirmpassword)) {
					boolean checkupdate = userService.UpdateUser(jsonObject, username, hash);
					if (checkupdate == false) {
						message = "updateoke";
						return message;
					} else {
						message = "updatenook";
						return message;
					}
				} else {
					message = "messageconfirmsai";
					return message;
				}
			} else {
				message = "newpasswordblank";
				return message;
			}
		} else {
			message = "saimatkhaucu";
			return message;
		}
	}

	// cap nhat thong tin user
	@PostMapping("updatethongtinuser")
	@ResponseBody
	public int UpdateThongTinUser(@RequestParam String dataJson) {
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonObject;
		String username = null;
		String email = null;
		try {
			jsonObject = objectMapper.readTree(dataJson);
			JsonNode jsonChitiet = jsonObject.get("username");
			for (JsonNode objectChiTiet : jsonChitiet) {
				username = objectChiTiet.get("username").asText();
				email = jsonObject.get("email").asText();
			}
			User user = userService.getUserById(username);
			if(email.equals(user.getEmail())) {
				userService.UpdateUser(jsonObject, username, null);
				return 1;
			} else {
				User checkemail = userService.checkEmail(email);
				if (checkemail == null) {
					userService.UpdateUser(jsonObject, username, null);
					return 1;
				} else {
					return 2;
				}
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
