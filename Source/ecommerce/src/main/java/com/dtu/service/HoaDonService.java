package com.dtu.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtu.model.ChiTietHoaDon;
import com.dtu.model.HoaDon;
import com.dtu.repository.HoaDonRepository;

@Service
public class HoaDonService implements HoaDonRepository {

	@Autowired
	HoaDonRepository hoaDonDAO;

	@Override
	public int ThemHoaDon(HoaDon hoaDon) {
		return hoaDonDAO.ThemHoaDon(hoaDon);
	}

	@Override
	public List<HoaDon> lstHoaDon() {
		return hoaDonDAO.lstHoaDon();
	}

	@Override
	public List<ChiTietHoaDon> lstChiTietHoaDon(String select, String start, String end) {
		if (select.equals("all")) {
			Calendar c = Calendar.getInstance();
			c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			String starta = df.format(c.getTime());
			for (int i = 0; i < 6; i++) {
				c.add(Calendar.DATE, 1);
			}
			String startb = df.format(c.getTime());
			return hoaDonDAO.lstChiTietHoaDon(select, starta, startb);
		}
		return null;
	}

	@Override
	public List<HoaDon> lstHoaDonTheoUsername(String username) {
		// TODO Auto-generated method stub
		return hoaDonDAO.lstHoaDonTheoUsername(username);
	}
}
