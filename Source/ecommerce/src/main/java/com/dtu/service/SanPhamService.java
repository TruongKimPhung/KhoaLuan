package com.dtu.service;

import static java.time.temporal.TemporalAdjusters.firstDayOfYear;
import static java.time.temporal.TemporalAdjusters.lastDayOfYear;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtu.model.SanPham;
import com.dtu.repository.SanPhamRepository;
import com.fasterxml.jackson.databind.JsonNode;

@Service
public class SanPhamService implements SanPhamRepository {

	@Autowired
	SanPhamRepository sanPhamDAO;

	@Override
	public List<SanPham> SanPham_All_Paging(int spbatdau) {
		SanPham sanphams = new SanPham();
		List<SanPham> lstsp = new ArrayList<SanPham>();
		for (SanPham sanPham : sanPhamDAO.SanPham_All_Paging(spbatdau)) {
			String[] words = sanPham.getHinhsanpham().split(",");
			ArrayList<String> list = new ArrayList<String>(Arrays.asList(words));
			sanphams = sanPham;
			sanphams.setHinhsanpham(list.get(0));
			lstsp.add(sanphams);
		}
		return lstsp;
	}

	@SuppressWarnings("null")
	@Override
	public List<SanPham> DanhSachSanPhamTheoDanhMuc(int spbatdau, int masp, String dungluong, String dungluongram, String giatien) {
		SanPham sanphams = new SanPham();
		List<SanPham> lstsp = new ArrayList<SanPham>();
		for (SanPham sanPham : sanPhamDAO.DanhSachSanPhamTheoDanhMuc(spbatdau, masp, dungluong, dungluongram, giatien)) {
			String[] words = sanPham.getHinhsanpham().split(",");
			ArrayList<String> list = new ArrayList<String>(Arrays.asList(words));
			sanphams = sanPham;
			sanphams.setHinhsanpham(list.get(0));
			lstsp.add(sanphams);
		}
		return lstsp;
		//return sanPhamDAO.LayDanhSachSanPhamPaging(spbatdau, masp);
	}

	@Override
	public SanPham GetSanPham_MaSanPham(int masanpham) {
		SanPham sanphams = sanPhamDAO.GetSanPham_MaSanPham(masanpham);
		String[] words = sanphams.getHinhsanpham().split(",");
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(words));
		sanphams.setHinhsanpham(list.get(0));
		return sanphams;
	}

	@Override
	public List<SanPham> LayDanhSachSanPhamTheoDanhMuc(int madanhmuc) {

		SanPham sanphams = new SanPham();
		List<SanPham> lstsp = new ArrayList<SanPham>();
		for (SanPham sanPham : sanPhamDAO.LayDanhSachSanPhamTheoDanhMuc(madanhmuc)) {
			String[] words = sanPham.getHinhsanpham().split(",");
			ArrayList<String> list = new ArrayList<String>(Arrays.asList(words));
			sanphams = sanPham;
			sanphams.setHinhsanpham(list.get(0));
			lstsp.add(sanphams);
		}
		return lstsp;
	}

	@Override
	public boolean XoaSanPhamTheoMaSanPham(int masanpham) {
		return sanPhamDAO.XoaSanPhamTheoMaSanPham(masanpham);
	}

	@Override
	public boolean ThemSanPham(SanPham sanPham) {
		return sanPhamDAO.ThemSanPham(sanPham);
	}

	@Override
	public boolean UpdateSanPham(JsonNode jsonObject) {
		return sanPhamDAO.UpdateSanPham(jsonObject);
	}

	@Override
	public List<SanPham> ThongKeSanPham(String select, LocalDate start, LocalDate end) {
		if (select.equals("week")) {
			Calendar c = Calendar.getInstance();
			c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			LocalDate date_start = LocalDate.parse(df.format(c.getTime()));
			for (int i = 0; i < 6; i++) {
				c.add(Calendar.DATE, 1);
			}
			LocalDate date_end = LocalDate.parse(df.format(c.getTime()));
			return sanPhamDAO.ThongKeSanPham(select, date_start, date_end);
		} else if(select.equals("month")) {
			LocalDate date = java.time.LocalDate.now();
		    Calendar c = Calendar.getInstance();
		    c.set(Calendar.DAY_OF_MONTH, 1);
		    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			LocalDate date_start = LocalDate.parse(df.format(c.getTime()));
		    System.out.println(date_start); 
		    
		    String date1111 = date.toString();
		    LocalDate date_end = LocalDate.parse(date1111, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		    date_end = date_end.withDayOfMonth(
		    		date_end.getMonth().length(date_end.isLeapYear()));
		    return sanPhamDAO.ThongKeSanPham(select, date_start, date_end);
		} else if(select.equals("year")) {
			LocalDate now = LocalDate.now();
			LocalDate firstDay = now.with(firstDayOfYear());
			LocalDate lastDay = now.with(lastDayOfYear());
			 return sanPhamDAO.ThongKeSanPham(select, firstDay, lastDay);
		} else if(select.equals("day")){
			LocalDate now = LocalDate.now();
			return sanPhamDAO.ThongKeSanPham(select, now, now);
		} else {
			return sanPhamDAO.ThongKeSanPham(select, null, null);
		}
	}

	@Override
	public List<SanPham> ListSanPhamConpare(String giatien) {
		SanPham sanphams = new SanPham();
		List<SanPham> lstsp = new ArrayList<SanPham>();
		for (SanPham sanPham : sanPhamDAO.ListSanPhamConpare(giatien)) {
			String[] words = sanPham.getHinhsanpham().split(",");
			ArrayList<String> list = new ArrayList<String>(Arrays.asList(words));
			sanphams = sanPham;
			sanphams.setHinhsanpham(list.get(0));
			lstsp.add(sanphams);
		}
		return lstsp;
	}

	@Override
	public boolean UpdateSoluongSP_ThanhToan(int machitietsp, int soluong) {
		return sanPhamDAO.UpdateSoluongSP_ThanhToan(machitietsp, soluong);
	}

	@Override
	public ArrayList<Double> ThongKeDoanhThuMoiThang() {
		return sanPhamDAO.ThongKeDoanhThuMoiThang();
	}

	@Override
	public ArrayList<Long> ThongKeSoLuongMoiThang() {
		// TODO Auto-generated method stub
		return sanPhamDAO.ThongKeSoLuongMoiThang();
	}

	@Override
	public List<SanPham> Test(String idtendanhmuc) {
		// TODO Auto-generated method stub
		return sanPhamDAO.Test(idtendanhmuc);
	}

	@Override
	public SanPham GetSanPham_MutilImageById(int masanpham) {
		// TODO Auto-generated method stub
		return sanPhamDAO.GetSanPham_MaSanPham(masanpham);
	}

	@Override
	public List<SanPham> getSoLuong_SP() {
		SanPham sanphams = new SanPham();
		List<SanPham> lstsp = new ArrayList<SanPham>();
		for (SanPham sanPham : sanPhamDAO.getSoLuong_SP()) {
			String[] words = sanPham.getHinhsanpham().split(",");
			ArrayList<String> list = new ArrayList<String>(Arrays.asList(words));
			sanphams = sanPham;
			sanphams.setHinhsanpham(list.get(0));
			lstsp.add(sanphams);
		}
		return lstsp;
	}


}
