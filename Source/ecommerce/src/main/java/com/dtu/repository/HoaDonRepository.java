package com.dtu.repository;

import java.util.List;

import com.dtu.model.ChiTietHoaDon;
import com.dtu.model.HoaDon;

public interface HoaDonRepository {

	int ThemHoaDon(HoaDon hoaDon);
	List<HoaDon> lstHoaDon();
	List<ChiTietHoaDon> lstChiTietHoaDon(String select, String start, String end);
	List<HoaDon> lstHoaDonTheoUsername(String username);
}

