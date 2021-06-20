package com.dtu.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtu.model.SanPham;
import com.dtu.repository.SearchRepository;

@Service
public class SearchService implements SearchRepository{
	
	@Autowired
	SearchRepository searchRepository;

	@Override
	public List<SanPham> SearchSanPhamLimit(String tensp) {
		SanPham sanphams = new SanPham();
		List<SanPham> lstsp = new ArrayList<SanPham>();
		for (SanPham sanPham : searchRepository.SearchSanPhamLimit(tensp)) {
			String[] words = sanPham.getHinhsanpham().split(",");
			ArrayList<String> list = new ArrayList<String>(Arrays.asList(words));
			sanphams = sanPham;
			sanphams.setHinhsanpham(list.get(0));
			lstsp.add(sanphams);
		}
		return lstsp;
	}

}
