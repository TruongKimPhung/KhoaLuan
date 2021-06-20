package com.dtu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtu.model.DanhMucSanPham;
import com.dtu.model.SanPham;
import com.dtu.repository.DanhMucSanPhamRepository;
import com.fasterxml.jackson.databind.JsonNode;

@Service
public class DanhMucService implements DanhMucSanPhamRepository {

	@Autowired
	DanhMucSanPhamRepository danhMucSanPhamImp;

	@Override
	public List<DanhMucSanPham> LayDanhMuc(int batdau) {
		return danhMucSanPhamImp.LayDanhMuc(batdau);
	}

	@Override
	public boolean ThemDanhMuc(String tendanhmuc, String madanhmuccha) {
		return danhMucSanPhamImp.ThemDanhMuc(tendanhmuc, madanhmuccha);
	}

	@Override
	public boolean UpdateDanhMuc(JsonNode jsonObject) {
		// TODO Auto-generated method stub
		return danhMucSanPhamImp.UpdateDanhMuc(jsonObject);
	}

	@Override
	public boolean XoaDanhMucTheoMaDanhMuc(int madanhmuc) {
		// TODO Auto-generated method stub
		return danhMucSanPhamImp.XoaDanhMucTheoMaDanhMuc(madanhmuc);
	}

	@Override
	public DanhMucSanPham getDanhMucCha(int madanhmuc) {
		// TODO Auto-generated method stub
		return danhMucSanPhamImp.getDanhMucCha(madanhmuc);
	}

	@Override
	public List<DanhMucSanPham> LayDanhMucCha(int madanhmuc) {
		// TODO Auto-generated method stub
		return danhMucSanPhamImp.LayDanhMucCha(madanhmuc);
	}

	@Override
	public List<SanPham> getDistintRomOfDanhMuc(int madanhmuc) {
		// TODO Auto-generated method stub
		return danhMucSanPhamImp.getDistintRomOfDanhMuc(madanhmuc);
	}

	@Override
	public List<SanPham> getDistintRamOfDanhMuc(int madanhmuc) {
		// TODO Auto-generated method stub
		return danhMucSanPhamImp.getDistintRamOfDanhMuc(madanhmuc);
	}

	@Override
	public List<DanhMucSanPham> getDanhMucChu(int madanhmuccha) {
		// TODO Auto-generated method stub
		return danhMucSanPhamImp.getDanhMucChu(madanhmuccha);
	}

}
