package com.dtu.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.dtu.model.SanPham;
import com.fasterxml.jackson.databind.JsonNode;

public interface SanPhamRepository {

	boolean UpdateSoluongSP_ThanhToan(int machitietsp, int soluong);

	List<SanPham> ListSanPhamConpare(String giatien);

	List<SanPham> SanPham_All_Paging(int spbatdau);
	List<SanPham> getSoLuong_SP();

	List<SanPham> ThongKeSanPham(String select, LocalDate start, LocalDate end);

	List<SanPham> DanhSachSanPhamTheoDanhMuc(int spbatdau, int masp, String dungluong, String dungluongram, String giatien);

	SanPham GetSanPham_MaSanPham(int masanpham);
	SanPham GetSanPham_MutilImageById(int masanpham);

	List<SanPham> LayDanhSachSanPhamTheoDanhMuc(int madanhmuc);

	boolean XoaSanPhamTheoMaSanPham(int masanpham);

	boolean ThemSanPham(SanPham sanPham);

	boolean UpdateSanPham(JsonNode jsonObject);
	//thongke trang admin
	ArrayList<Double> ThongKeDoanhThuMoiThang();
	ArrayList<Long> ThongKeSoLuongMoiThang();
	
	// test
	List<SanPham> Test(String idtendanhmuc);
}
