package com.dtu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dtu.model.SanPham;
import com.dtu.service.SearchService;

@Controller
@RequestMapping("search/")
public class SearchController {
	
	@Autowired
	SearchService searchService;

	@PostMapping("auto")
	@ResponseBody
	public List<SanPham> search(@RequestParam String term) {
		List<SanPham> listSanPhams = searchService.SearchSanPhamLimit(term);
		System.out.println(term);
		return listSanPhams;
	}
}
