package com.dtu.repository;

import com.dtu.model.ChiTietHoaDon;

public interface ChiTietHoaDonRepository {
	boolean ThemChiTietHoaDon(ChiTietHoaDon chiTietHoaDon);
	Long lstChiTietHoaDon(int masanpham, int check);
	
}
