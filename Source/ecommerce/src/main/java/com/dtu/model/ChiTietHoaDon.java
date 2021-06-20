package com.dtu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "CHITIETHOADON")
public class ChiTietHoaDon{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int machitiethoadon;

	private int soluong;
	private String giatien;
	private String tongtien;
	private String ngaylaphoadon;

	@OneToOne()
	@JoinColumn(name = "mahoadon")
	private HoaDon hoadon;

	@OneToOne()
	@JoinColumn(name = "masanpham")
	private SanPham sanpham;

	public SanPham getSanpham() {
		return sanpham;
	}

	public void setSanpham(SanPham sanpham) {
		this.sanpham = sanpham;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public String getGiatien() {
		return giatien;
	}

	public void setGiatien(String giatien) {
		this.giatien = giatien;
	}

	public String getTongtien() {
		return tongtien;
	}

	public void setTongtien(String tongtien) {
		this.tongtien = tongtien;
	}

	public int getMachitiethoadon() {
		return machitiethoadon;
	}

	public void setMachitiethoadon(int machitiethoadon) {
		this.machitiethoadon = machitiethoadon;
	}

	public HoaDon getHoadon() {
		return hoadon;
	}

	public void setHoadon(HoaDon hoadon) {
		this.hoadon = hoadon;
	}

	public String getNgaylaphoadon() {
		return ngaylaphoadon;
	}

	public void setNgaylaphoadon(String ngaylaphoadon) {
		this.ngaylaphoadon = ngaylaphoadon;
	}

}
