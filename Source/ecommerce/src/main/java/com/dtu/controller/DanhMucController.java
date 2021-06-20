package com.dtu.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dtu.model.DanhMucSanPham;
import com.dtu.service.DanhMucService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class DanhMucController {

	@Autowired
	DanhMucService danhMucService;

	// di chuyen toi trang quan ly danh muc
	@RequestMapping("admin/danhmuc")
	public String DanhMuc(ModelMap modelMap) {
		List<DanhMucSanPham> lstDanhMucSanPham = danhMucService.LayDanhMucCha(0);
		modelMap.addAttribute("listDanhMuc", lstDanhMucSanPham);
		return "admin/danhmuc";
	}

	// di chuyen toi trang them danh muc cua admin
	@RequestMapping("admin/themdanhmuc")
	public String ThemDanhMuc(ModelMap modelMap) {
		List<DanhMucSanPham> lstDanhMuc = danhMucService.LayDanhMucCha(0);
		modelMap.addAttribute("listDanhMuc", lstDanhMuc);
		return "admin/danhmuc-themdanhmuc";
	}

	// update danh muc
	@SuppressWarnings("null")
	@RequestMapping("admin/updatedanhmuc/{madanhmuc}/{tendanhmuc}")
	public String UpdateDanhMuc(ModelMap modelMap, @PathVariable String tendanhmuc, @PathVariable int madanhmuc)
			throws NullPointerException {
		List<DanhMucSanPham> lstDanhMucSanPham = null;
		DanhMucSanPham dmsp = danhMucService.getDanhMucCha(madanhmuc);
		try {
			if (dmsp != null) {
				modelMap.addAttribute("tendanhmucSelected", dmsp.getTendanhmuc());
				lstDanhMucSanPham = danhMucService.LayDanhMucCha(dmsp.getMadanhmuc());
			} else {
				lstDanhMucSanPham = danhMucService.LayDanhMucCha(madanhmuc);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		modelMap.addAttribute("tendanhmuc", tendanhmuc);
		modelMap.addAttribute("madanhmuc", madanhmuc);
		modelMap.addAttribute("listDanhMuc", lstDanhMucSanPham);
		return "admin/danhmuc-updatedanhmuc";
	}

	@PostMapping("capnhatdanhmuc")
	@ResponseBody
	public int capnhatdanhmuc(@RequestParam String dataJson) {
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonObject;
		try {
			jsonObject = objectMapper.readTree(dataJson);
			danhMucService.UpdateDanhMuc(jsonObject);
			return 1;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@PostMapping("/themdanhmuc")
	@ResponseBody
	public int themsanpham1(@RequestParam String dataJson) throws ParseException {
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonObject;
		try {
			jsonObject = objectMapper.readTree(dataJson);
			String tendanhmuc = jsonObject.get("tendanhmuc").asText();
			String madanhmuccha = jsonObject.get("madanhmuccha").get("madanhmuc").asText();
			danhMucService.ThemDanhMuc(tendanhmuc, madanhmuccha);
			return 1;
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@GetMapping("/XoaDanhMuc")
	@ResponseBody
	public String XoaDanhMuc(@RequestParam int madanhmuc) {
		danhMucService.XoaDanhMucTheoMaDanhMuc(madanhmuc);
		return "true";
	}

}
