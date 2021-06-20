package com.dtu.controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.dtu.model.DanhMucSanPham;
import com.dtu.model.SanPham;
import com.dtu.service.DanhMucService;
import com.dtu.service.SanPhamService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class SanPhamController {

	@Autowired
	DanhMucService danhMucService;

	@Autowired
	SanPhamService sanPhamService;

	@RequestMapping("/sanpham")
	public String SanPham(Principal principal,ModelMap modelMap) {
		if (principal != null) {
			modelMap.addAttribute("username", principal.getName());
		}
		List<SanPham> listSanPhams = sanPhamService.SanPham_All_Paging(0);
		List<SanPham> allSanPham = sanPhamService.SanPham_All_Paging(-1);
		double tongsopage = Math.ceil((double) allSanPham.size() / 5);
		List<DanhMucSanPham> danhMucSanPhams = danhMucService.LayDanhMuc(-1);
		modelMap.addAttribute("listSanPham", listSanPhams);
		modelMap.addAttribute("danhmuc", danhMucSanPhams);
		modelMap.addAttribute("tongsopage", tongsopage);
		modelMap.addAttribute("allSanPham", allSanPham);
		System.out.println(allSanPham.size() + " tongsopage: " + tongsopage);
		return "sanpham2";
	}

	@GetMapping(path = "/LaySanPhamLimit", produces = "text/plain; charset=utf-8")
	@ResponseBody
	public String LaySanPhamPaging(@RequestParam int spbatdau) {

		String html = "";

		List<SanPham> listSanPhams = sanPhamService.SanPham_All_Paging(spbatdau);
		for (SanPham sanPham : listSanPhams) {
			String href = "/ecommerce/updatesanpham/" + sanPham.getMasanpham() + "/" + sanPham.getTensanpham();
			html += "<tr>";
			html += "<td><div class='checkbox'><label><input class='checkboxsanpham' type='checkbox' value='"
					+ sanPham.getMasanpham() + "'></label></div></td>";
			html += "<td class='tensp' data-masp='" + sanPham.getMasanpham() + "'>" + sanPham.getTensanpham() + "</td>";
			html += "<td class='danhmuc' >" + sanPham.getDanhmucsanpham().getTendanhmuc() + "</td>";
			html += "<td class='giatien' >" + sanPham.getGiatien() + "</td>";
			html += "<td class='mota'>" + sanPham.getMota() + "</td>";
			html += "<td><a href=" + href + " class='btn btn-warning fa fa-edit' ></a></td>";
			html += "</tr>";
		}
		return html;
	}

	@GetMapping(path = "/SanPhamTheoDanhMuc", produces = "text/plain; charset=utf-8")
	@ResponseBody
	public String SanPhamTheoDanhMucPaging(@RequestParam int spbatdau, @RequestParam int madanhmuc) {
		String html = "";

		List<SanPham> listSanPhams = sanPhamService.DanhSachSanPhamTheoDanhMuc(spbatdau, madanhmuc, null, null, null);
		for (SanPham sanpham : listSanPhams) {
			String href = "/ecommerce/resources/images/product/large-size/" + sanpham.getHinhsanpham();
			html += "<div class='col-lg-4 col-md-4 col-sm-6 mt-40'>";
			html += "<div class='single-product-wrap'>";
			html += "<div class='product-image'>";
			html += "<a href='single-product.html'> <img src=" + href
					+ " alt='Li's Product Image'/></a> <span class='sticker'>New</span></div>";
			html += "<div class='product_desc'>";
			html += "<div class='product_desc_info'>";
			html += "<h4>";
			html += "<a class='product_name' href='single-product.html'>" + sanpham.getTensanpham() + "</a>";
			html += "</h4>";
			html += "<div class='price-box'>";
			html += "<span class='new-price'>$" + sanpham.getGiatien() + "</span>";
			html += "</div>";
			html += "</div>";
			html += "<div class='add-actions'>";
			html += "<ul class='add-actions-link'>";
			html += "<li class='add-cart active'><a";
			html += "href='shopping-cart.html'>Add to cart</a></li>";
			html += "<li><a href='#' title='quick view'";
			html += "class='quick-view-btn' data-toggle='modal'";
			html += "data-target='#exampleModalCenter'><i";
			html += "class='fa fa-eye'></i></a></li>";
			html += "<li><a class='links-details' href='wishlist.html'><i";
			html += "class='fa fa-heart-o'></i></a></li>";
			html += "</ul>";
			html += "</div>";
			html += "</div>";
			html += "</div>";
			html += "</div>";
		}
		return html;
	}

	@GetMapping("/XoaSanPham")
	@ResponseBody
	public String XoaSanPhamTheoMaSanPham(@RequestParam int masp) {
		sanPhamService.XoaSanPhamTheoMaSanPham(masp);
		return "true";
	}

	@PostMapping("/themsanpham")
	@ResponseBody
	public int themsanpham1(@RequestParam String dataJson) throws ParseException {
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonObject;
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			LocalDateTime now = LocalDateTime.now();
			Date date = formatter.parse(dtf.format(now));

			SanPham sanPham = new SanPham();
			jsonObject = objectMapper.readTree(dataJson);
			DanhMucSanPham dmsp = new DanhMucSanPham();
			dmsp.setMadanhmuc(jsonObject.get("danhmucsanpham").get("madanhmuc").asInt());

			String tensp = jsonObject.get("tensanpham").asText();
			int giatien = jsonObject.get("giatien").asInt();
			String mota = jsonObject.get("mota").asText();
			String hinhsanpham = jsonObject.get("hinhsanpham").asText();
			String soluong = jsonObject.get("soluong").asText();
			String manhinh = jsonObject.get("manhinh").asText();
			String hedieuhanh = jsonObject.get("hedieuhanh").asText();
			String camerasau = jsonObject.get("camerasau").asText();
			String cameratruoc = jsonObject.get("cameratruoc").asText();
			String cpu = jsonObject.get("cpu").asText();
			String ram = jsonObject.get("ram").asText();
			String rom = jsonObject.get("rom").asText();
			String dungluongpin = jsonObject.get("dungluongpin").asText();
			
			sanPham.setGiatien(giatien);
			sanPham.setTensanpham(tensp);
			sanPham.setMota(mota);
			sanPham.setHinhsanpham(hinhsanpham);
			sanPham.setDanhmucsanpham(dmsp);
			sanPham.setNgaynhap(date);
			if(soluong == null) {
				sanPham.setSoluong(0);
			}
			sanPham.setSoluong(Integer.parseInt(soluong));
			sanPham.setManhinh(manhinh);
			sanPham.setHedieuhanh(hedieuhanh);
			sanPham.setCamerasau(camerasau);
			sanPham.setCameratruoc(cameratruoc);
			sanPham.setCpu(cpu);
			sanPham.setRam(Integer.parseInt(ram));
			sanPham.setRom(Integer.parseInt(rom));
			sanPham.setDungluongpin(dungluongpin);

			sanPhamService.ThemSanPham(sanPham);
			return 1;
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@RequestMapping("/themsanpham")
	public String ThemSanPham(ModelMap modelMap) {
		List<DanhMucSanPham> danhMucSanPhams = danhMucService.LayDanhMuc(-1);
		modelMap.addAttribute("danhmuc", danhMucSanPhams);
		return "admin/themsanpham";
	}

	@RequestMapping("admin/updatesanpham/{masanpham}/{tensanpham}")
	public String UpdateSanPham(ModelMap modelMap, @PathVariable int masanpham, @PathVariable String tensanpham) {
		SanPham sanPham = sanPhamService.GetSanPham_MaSanPham(masanpham);
		List<DanhMucSanPham> danhMucSanPhams = danhMucService.LayDanhMucCha(sanPham.getDanhmucsanpham().getMadanhmuc());
		modelMap.addAttribute("tensanpham", tensanpham);
		modelMap.addAttribute("madanhmuc", sanPham.getDanhmucsanpham().getMadanhmuc());
		modelMap.addAttribute("sanPham", sanPham);
		modelMap.addAttribute("danhmuc", danhMucSanPhams);
		return "admin/sanpham-updatesanpham";
	}

	@PostMapping("capnhatsanpham")
	@ResponseBody
	public int capnhatsanpham(@RequestParam String dataJson) {
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonObject;
		try {
			jsonObject = objectMapper.readTree(dataJson);
			sanPhamService.UpdateSanPham(jsonObject);
			return 1;
		} catch (IOException e) {
			e.printStackTrace();

		}
		return 0;
	}

	@Autowired
	ServletContext context;

	@PostMapping("UploadFile")
	@ResponseBody
	public String UploadFile(MultipartHttpServletRequest request) {

		String path_save_file = context.getRealPath("/resources/images/product/large-size/");

		Iterator<String> listNames = request.getFileNames();
		MultipartFile mpf = request.getFile(listNames.next());

		File file_save = new File(path_save_file + mpf.getOriginalFilename());
		try {
			mpf.transferTo(file_save);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "true";
	}

}
