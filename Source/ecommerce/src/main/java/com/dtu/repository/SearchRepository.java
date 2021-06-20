package com.dtu.repository;

import java.util.List;

import com.dtu.model.SanPham;

public interface SearchRepository {

	List<SanPham> SearchSanPhamLimit(String tensp);
}
