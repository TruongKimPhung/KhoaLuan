package com.dtu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtu.model.ChiTietHoaDon;
import com.dtu.repository.ChiTietHoaDonRepository;

@Service
public class ChiTietHoaDonService implements ChiTietHoaDonRepository {

	@Autowired
	ChiTietHoaDonRepository chiTietHoaDonDAO;

	@Override
	public boolean ThemChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {

		return chiTietHoaDonDAO.ThemChiTietHoaDon(chiTietHoaDon);
	}

	@Override
	public Long lstChiTietHoaDon(int masanpham, int check) {
		return chiTietHoaDonDAO.lstChiTietHoaDon(masanpham, check);
	}

}
