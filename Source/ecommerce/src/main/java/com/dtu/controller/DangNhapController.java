package com.dtu.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dtu.model.DanhMucSanPham;
import com.dtu.model.GioHang;
import com.dtu.model.User;
import com.dtu.service.DanhMucService;
import com.dtu.service.UserService;

@Controller
public class DangNhapController {

	@Autowired
	UserService userService;

	@Autowired
	DanhMucService danhMucService;

	private String confirm_email = null;
	private String username = null;
	private int randomNum = 0;

	// login
	@RequestMapping("login")
	public String DangNhap(HttpSession httpSession, Principal principal, ModelMap modelMap) {
		List<DanhMucSanPham> danhMucSanPhams = danhMucService.LayDanhMuc(-1);
		modelMap.addAttribute("danhmuc", danhMucSanPhams);
		try {
			@SuppressWarnings("unchecked")
			List<GioHang> lstGioHangs = (List<GioHang>) httpSession.getAttribute("cart");
			List<GioHang> lstGioHang = new ArrayList<GioHang>();

			modelMap.addAttribute("danhmuc", danhMucSanPhams);
			if (lstGioHangs != null) {
				modelMap.addAttribute("countCart", lstGioHang.size());
				modelMap.addAttribute("giohangs", lstGioHang);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (principal != null) {
			System.out.println(principal.getName());
			return "redirect:/";
		}
		return "dangnhap/login";
	}

	// di chuyen den trang quen mat khau
	@RequestMapping("/forgotpassword")
	public String ForgotPassword(HttpSession httpSession, ModelMap modelMap) {
		int countCart = 0;
		List<DanhMucSanPham> danhMucSanPhams = danhMucService.LayDanhMuc(-1);
		modelMap.addAttribute("danhmuc", danhMucSanPhams);
		try {
			@SuppressWarnings("unchecked")
			List<GioHang> lstGioHangs = (List<GioHang>) httpSession.getAttribute("cart");
			List<GioHang> lstGioHang = new ArrayList<GioHang>();

			modelMap.addAttribute("danhmuc", danhMucSanPhams);
			if (lstGioHangs != null) {
				countCart = lstGioHangs.size();
				modelMap.addAttribute("giohangs", lstGioHang);
			} else {
				countCart = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelMap.addAttribute("countCart", countCart);
		return "dangnhap/forgotpassword";
	}

	// Form tim tai khoang khi nhap username hoac email
	@PostMapping(value = "form-forgotpw")
	public String forgotPW(RedirectAttributes attr, @RequestParam String email)
			throws AddressException, MessagingException {
		User lstUser = userService.checkEmail(email);
		if (lstUser != null) {
			confirm_email = email;
			username = lstUser.getUsername();
			return "redirect:confirmuser";
		} else {
			attr.addFlashAttribute("error_email_user", "Kh??ng t??m th???y email, vui l??ng nh???p l???i ?????a ch??? email");
			return "redirect:forgotpassword";
		}
	}

	// chuyen den trang xac nhan user sau khi tim duoc username
	@RequestMapping("/confirmuser")
	public String confirmuser(HttpSession httpSession, ModelMap modelMap) {
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
		modelMap.addAttribute("email", confirm_email);
		modelMap.addAttribute("username", username);
		return "dangnhap/confirmuser";
	}

	// Gui ma code sau khi confirm user
	@PostMapping(value = "form-confirmuser")
	public String verifdypw(RedirectAttributes attr) throws AddressException, MessagingException {
		randomNum = ThreadLocalRandom.current().nextInt(100000, 999999 + 1);
		ForgotPW(confirm_email, randomNum);
		return "redirect:verifycode";
	}

	// di chuyen toi trang kiem ca ma code sau khi confirm user
	@RequestMapping("/verifycode")
	public String verifycode(HttpSession httpSession, ModelMap modelMap) {
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
		return "dangnhap/verify-code";
	}

	// Form verify code sau khi nhap ma code
	@PostMapping(value = "form-verifycode")
	public String formverifycode(RedirectAttributes attr, @RequestParam String code)
			throws AddressException, MessagingException {
		System.out.println(code);

		if (Integer.parseInt(code) == randomNum) {
			return "redirect:newpassword";
		} else {
			attr.addFlashAttribute("errors", "Nh???p sai m?? code, vui l??ng ki???m tra l???i m?? code trong ?????a ch??? email");
			ForgotPW(confirm_email, randomNum);
			return "redirect:verifycode";
		}

	}

	// di chuyen toi trang mat khau moi sau khi verify mat khau
	@RequestMapping("/newpassword")
	public String newpassword(HttpSession httpSession, Principal principal, ModelMap modelMap) {
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
		System.out.println(confirm_email);
		return "dangnhap/newpassword";
	}

	// Form tao mat khau moi
	@PostMapping(value = "form-newpassword")
	public String verifypw(RedirectAttributes attr, @RequestParam String newpassword,
			@RequestParam String confirmpassword) {
		if (newpassword.equals(confirmpassword)) {
			String hash = BCrypt.hashpw(newpassword, BCrypt.gensalt(12));
			boolean checkupdate = userService.UpdateNewPassword(username, hash);
			if (checkupdate == false) {
				return "redirect:login";
			} else {
				return "redirect:newpassword";
			}
		}
		attr.addFlashAttribute("errors", "Vui l??ng nh???p l???i m???t kh???u");
		return "redirect:newpassword";
	}

	@SuppressWarnings("static-access")
	public static void ForgotPW(String email, int randomNum) throws AddressException, MessagingException {
		SendGmail send = new SendGmail();
		send.sendText(email, randomNum);
	}

	// di chuyen toi trang dang ki
	@RequestMapping("/register")
	public String DangKi(HttpSession httpSession, ModelMap modelMap) {
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
		return "dangnhap/register";
	}

	// dang ki username
	@PostMapping(value = "form-register")
	public String registeruser(RedirectAttributes attr, @RequestParam String username, @RequestParam String hoten,
			@RequestParam String email, @RequestParam String password, @RequestParam String confirmpassword) {
		String message = null;
		if (username != null && username != "") {
			if (email != null && email != "") {
				User user = userService.getUserById(username);
				if (user == null) {
					User checkemail = userService.checkEmail(email);
					if (checkemail == null) {
						if (password.equals(confirmpassword)) {
							String hash = BCrypt.hashpw(password, BCrypt.gensalt(12));
							boolean checkregister = userService.AddUser(username, hoten, email, hash);
							if (checkregister == false) {
								return "redirect:login";
							} else {
								message = "L???i ????ng k?? user";
							}
						} else {
							message = "Nh???p l???i m???t kh???u";
						}
					} else {
						message = "Email ???? ???????c s??? d???ng, vui l??ng ch???n email kh??c";
					}

				} else {
					message = "Username ???? ???????c s??? d???ng, vui l??ng ch???n username kh??c";
				}
			} else {
				message = "Email kh??ng ???????c tr???ng";
			}

		} else {
			message = "Username kh??ng ???????c tr???ng";
		}

		attr.addFlashAttribute("errors", message);
		return "redirect:register";
	}

}
