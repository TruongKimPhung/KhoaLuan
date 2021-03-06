package com.dtu.model;

import java.io.Serializable;

public class WishList implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	int machitiet;
	int masp;
	int masize;
	int mamau;
	String tensp;
	String giatien;
	String tenmau;
	String tensize;
	int soluong;
	String hinhsanpham;
	int wishlist;

	public int getMachitiet() {
		return machitiet;
	}

	public void setMachitiet(int machitiet) {
		this.machitiet = machitiet;
	}

	public int getMasp() {
		return masp;
	}

	public void setMasp(int masp) {
		this.masp = masp;
	}

	public int getMasize() {
		return masize;
	}

	public void setMasize(int masize) {
		this.masize = masize;
	}

	public int getMamau() {
		return mamau;
	}

	public void setMamau(int mamau) {
		this.mamau = mamau;
	}

	public String getTensp() {
		return tensp;
	}

	public void setTensp(String tensp) {
		this.tensp = tensp;
	}

	public String getGiatien() {
		return giatien;
	}

	public void setGiatien(String giatien) {
		this.giatien = giatien;
	}

	public String getTenmau() {
		return tenmau;
	}

	public void setTenmau(String tenmau) {
		this.tenmau = tenmau;
	}

	public String getTensize() {
		return tensize;
	}

	public void setTensize(String tensize) {
		this.tensize = tensize;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public String getHinhsanpham() {
		return hinhsanpham;
	}

	public void setHinhsanpham(String hinhsanpham) {
		this.hinhsanpham = hinhsanpham;
	}

	public int getWishlist() {
		return wishlist;
	}

	public void setWishlist(int wishlist) {
		this.wishlist = wishlist;
	}

}
