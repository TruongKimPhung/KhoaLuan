package com.dtu.repository;

import java.util.List;

import com.dtu.model.DanhMucSanPham;
import com.dtu.model.SanPham;
import com.fasterxml.jackson.databind.JsonNode;


public interface DanhMucSanPhamRepository {
	List<DanhMucSanPham>  getDanhMucChu(int madanhmuccha);
	List<DanhMucSanPham>  LayDanhMuc(int batdau);
	boolean ThemDanhMuc(String tendanhmuc, String madanhmuccham);
	boolean UpdateDanhMuc(JsonNode jsonObject);
	boolean XoaDanhMucTheoMaDanhMuc(int madanhmuc);
	DanhMucSanPham getDanhMucCha(int madanhmuc);
	List<DanhMucSanPham>  LayDanhMucCha(int madanhmuc);
	List<SanPham> getDistintRomOfDanhMuc(int madanhmuc);
	List<SanPham> getDistintRamOfDanhMuc(int madanhmuc);
}
