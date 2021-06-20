package com.dtu.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "DANHMUCSANPHAM")
public class DanhMucSanPham implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8476650393924852536L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int madanhmuc;
	private String tendanhmuc;
	private int madanhmuccha;
	private int isdelete;

	// @OneToMany(fetch = FetchType.EAGER,mappedBy = "danhmucsanpham", cascade =
	// CascadeType.ALL)

	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "madanhmuc")
	@JsonIgnore
	Set<SanPham> danhsachsanpham;

	public int getMadanhmuc() {
		return madanhmuc;
	}

	public void setMadanhmuc(int madanhmuc) {
		this.madanhmuc = madanhmuc;
	}

	public String getTendanhmuc() {
		return tendanhmuc;
	}

	public void setTendanhmuc(String tendanhmuc) {
		this.tendanhmuc = tendanhmuc;
	}

	public Set<SanPham> getDanhsachsanpham() {
		return danhsachsanpham;
	}

	public void setDanhsachsanpham(Set<SanPham> danhsachsanpham) {
		this.danhsachsanpham = danhsachsanpham;
	}

	public int getMadanhmuccha() {
		return madanhmuccha;
	}

	public void setMadanhmuccha(int madanhmuccha) {
		this.madanhmuccha = madanhmuccha;
	}

	public int getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}

}
