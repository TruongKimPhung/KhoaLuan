package com.dtu.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "SANPHAM")
public class SanPham {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int masanpham;

	@OneToOne()
	@JoinColumn(name = "madanhmuc")
	DanhMucSanPham danhmucsanpham;

	String tensanpham;
	int giatien;
	private String mota;
	String hinhsanpham;
	private int soluong;
	private Date ngaynhap;
	private String manhinh;
	private String hedieuhanh;
	private String camerasau;
	private String cameratruoc;
	private String cpu;
	private int ram;
	private int rom;
	private String dungluongpin;
	private int isdelete;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "masanpham")
	@JsonIgnore
	Set<ChiTietHoaDon> chitiethoadon;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "masanpham")
	@JsonIgnore
	Set<KhuyenMai> khuyenmai;

	public int getMasanpham() {
		return masanpham;
	}

	public void setMasanpham(int masanpham) {
		this.masanpham = masanpham;
	}

	public DanhMucSanPham getDanhmucsanpham() {
		return danhmucsanpham;
	}

	public void setDanhmucsanpham(DanhMucSanPham danhmucsanpham) {
		this.danhmucsanpham = danhmucsanpham;
	}

	public String getTensanpham() {
		return tensanpham;
	}

	public void setTensanpham(String tensanpham) {
		this.tensanpham = tensanpham;
	}

	public int getGiatien() {
		return giatien;
	}

	public void setGiatien(int giatien) {
		this.giatien = giatien;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getHinhsanpham() {
		return hinhsanpham;
	}

	public void setHinhsanpham(String hinhsanpham) {
		this.hinhsanpham = hinhsanpham;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public Date getNgaynhap() {
		return ngaynhap;
	}

	public void setNgaynhap(Date ngaynhap) {
		this.ngaynhap = ngaynhap;
	}

	public String getManhinh() {
		return manhinh;
	}

	public void setManhinh(String manhinh) {
		this.manhinh = manhinh;
	}

	public String getHedieuhanh() {
		return hedieuhanh;
	}

	public void setHedieuhanh(String hedieuhanh) {
		this.hedieuhanh = hedieuhanh;
	}

	public String getCamerasau() {
		return camerasau;
	}

	public void setCamerasau(String camerasau) {
		this.camerasau = camerasau;
	}

	public String getCameratruoc() {
		return cameratruoc;
	}

	public void setCameratruoc(String cameratruoc) {
		this.cameratruoc = cameratruoc;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public int getRom() {
		return rom;
	}

	public void setRom(int rom) {
		this.rom = rom;
	}

	public String getDungluongpin() {
		return dungluongpin;
	}

	public void setDungluongpin(String dungluongpin) {
		this.dungluongpin = dungluongpin;
	}

	public int getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}

	public Set<ChiTietHoaDon> getChitiethoadon() {
		return chitiethoadon;
	}

	public void setChitiethoadon(Set<ChiTietHoaDon> chitiethoadon) {
		this.chitiethoadon = chitiethoadon;
	}

	@SuppressWarnings("unchecked")
	public JSONObject getJSONObject() {
		JSONObject obj = new JSONObject();
		obj.put("tensanpham", tensanpham);
		obj.put("soluong", soluong);
		return obj;
	}

	public Set<KhuyenMai> getKhuyenmai() {
		return khuyenmai;
	}

	public void setKhuyenmai(Set<KhuyenMai> khuyenmai) {
		this.khuyenmai = khuyenmai;
	}

}