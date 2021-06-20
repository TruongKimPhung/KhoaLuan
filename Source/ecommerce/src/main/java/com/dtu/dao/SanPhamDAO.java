package com.dtu.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dtu.model.SanPham;
import com.dtu.repository.SanPhamRepository;
import com.fasterxml.jackson.databind.JsonNode;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SanPhamDAO implements SanPhamRepository {

	@Autowired
	SessionFactory sessionFactory;

	// spbatdau > 0 : lay danh sach de phan trang
	// spbatdau > 0 : lay tat ca san pham
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<SanPham> SanPham_All_Paging(int spbatdau) {
		Session session = sessionFactory.getCurrentSession();
		List<SanPham> listSanPhams = new ArrayList<>();
		String query = "select sp from SANPHAM sp where sp.isdelete =" + 0 +" and sp.soluong > "+0;
		if (spbatdau == 0) {
			// lay all san pham
			listSanPhams = (List<SanPham>) session.createQuery(query).getResultList();
		} else if (spbatdau == -1) {
			// lay 10 san pham new arrival
			query += " order by sp.ngaynhap DESC";
			listSanPhams = (List<SanPham>) session.createQuery(query).setFirstResult(spbatdau).setMaxResults(10)
					.getResultList();
		} else if (spbatdau == -2) {
			String query1 = "select sp from SANPHAM sp " + "left join sp.khuyenmai km ";
			// + "where sp.isdelete =" + 0 +" order by km.giamgia DESC";
			// lay 10 san pham bestSeller
			listSanPhams = (List<SanPham>) session.createQuery(query1).setFirstResult(spbatdau).setMaxResults(10)
					.getResultList();
		} else if (spbatdau == -3) {
			String query1 = "select sp from SANPHAM sp " + "left join sp.chitiethoadon cthd where sp.isdelete = " + 0
					+ " group by sp.tensanpham";
			listSanPhams = (List<SanPham>) session.createQuery(query1).setFirstResult(spbatdau).setMaxResults(10)
					.getResultList();
		}
		return listSanPhams;
	}

	// update so luong san pham khi thanh toan
	@Override
	@Transactional
	public boolean UpdateSoluongSP_ThanhToan(int machitietsp, int soluong) {
		Session session = sessionFactory.getCurrentSession();
		SanPham sanPham = session.find(SanPham.class, machitietsp);
		int soluongold = sanPham.getSoluong();
		int soluongnew = soluongold - soluong;
		sanPham.setSoluong(soluongnew);
		session.update(sanPham);
		return false;
	}

	// get danh sach san pham theo danh muc : dienthoai, laptop
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<SanPham> DanhSachSanPhamTheoDanhMuc(int spbatdau, int masp, String dungluong, String dungluongram,
			String giatien) {
		Session session = sessionFactory.getCurrentSession();
		List<SanPham> listSanPhams = new ArrayList<>();

		String query = "select sp from SANPHAM sp where sp.danhmucsanpham.madanhmuc = " + masp + " and sp.isdelete = "
				+ 0 + " and sp.soluong > " + 0;
		if (giatien != null) {
			if (giatien.equals("100")) {
				query += " and sp.giatien < " + 100;
			} else if (giatien.equals("500")) {
				query += " and sp.giatien BETWEEN  100 and 500";
			} else if (giatien.equals("1000")) {
				query += " and sp.giatien BETWEEN  501 and 1000";
			} else if (giatien.equals("1000m")) {
				query += " and sp.giatien > " + 1000;
			}
		}

		if (dungluongram != null) {
			query += " and (  ";
			String[] dungluongsp = dungluongram.split(",");
			for (int i = 0; i < dungluongsp.length; i++) {
				if (i == 0) {
					query += " sp.ram = " + dungluongsp[i];
				} else {
					query += " or sp.ram = " + dungluongsp[i];
				}
			}
			query += " ) ";
		}

		if (dungluong != null) {
			query += " and (  ";
			String[] dungluongsp = dungluong.split(",");
			for (int i = 0; i < dungluongsp.length; i++) {
				if (i == 0) {
					query += " sp.rom = " + dungluongsp[i];
				} else {
					query += " or sp.rom = " + dungluongsp[i];
				}
			}
			query += " ) ";
		}

		if (spbatdau == -1) {
			query += " order by sp.tensanpham ASC";
		} else if (spbatdau == -2) {
			query += " order by sp.tensanpham DESC";
		} else if (spbatdau == -3) {
			query += " order by sp.giatien ASC";
		} else if (spbatdau == -4) {
			query += " order by sp.giatien DESC";
		} else if (spbatdau == 0) {
			query += " ";
		}
		listSanPhams = (List<SanPham>) session.createQuery(query).getResultList();
		return listSanPhams;
	}

	// get danh sach san pham theo ma san pham
	@Override
	@Transactional
	public SanPham GetSanPham_MaSanPham(int masanpham) {
		Session session = sessionFactory.getCurrentSession();
		String query = "select sp from SANPHAM sp where sp.masanpham=" + masanpham + " and sp.isdelete = " + 0 + " and sp.soluong > " + 0;
		SanPham sanPhams = (SanPham) session.createQuery(query).getSingleResult();

		return sanPhams;
	}

	// get danh sach san pham theo ma danh muc
	@Override
	@Transactional
	public List<SanPham> LayDanhSachSanPhamTheoDanhMuc(int madanhmuc) {
		Session session = sessionFactory.getCurrentSession();
		String query = "select sp from SANPHAM sp where sp.danhmucsanpham.madanhmuc=" + madanhmuc
				+ " and sp.isdelete = " + 0;
		@SuppressWarnings("unchecked")
		List<SanPham> listSanPhams = (List<SanPham>) session.createQuery(query).getResultList();
		return listSanPhams;
	}

	// Xoa san pham theo ma san pham
	@Override
	@Transactional
	public boolean XoaSanPhamTheoMaSanPham(int masanpham) {
		Session session = sessionFactory.getCurrentSession();
		SanPham sanPham = session.get(SanPham.class, masanpham);
		sanPham.setIsdelete(1);
		session.update(sanPham);
		return false;
	}

	// Them san pham
	@Override
	@Transactional
	public boolean ThemSanPham(SanPham sanPham) {
		Session session = sessionFactory.getCurrentSession();
		int id = (int) session.save(sanPham);
		if (id > 0) {
			return true;
		} else {
			return false;
		}
	}

	// update san pham
	@Override
	@Transactional
	public boolean UpdateSanPham(JsonNode jsonObject) {
		Session session = sessionFactory.getCurrentSession();
		String tensanpham = jsonObject.get("tensanpham").asText();
		String giatien = jsonObject.get("giatien").asText();
		int masanpham = jsonObject.get("masanpham").asInt();
		SanPham sanPham = session.find(SanPham.class, masanpham);
		sanPham.setTensanpham(tensanpham);
		sanPham.setGiatien(Integer.valueOf(giatien));
		//sanPham.setHinhsanpham("2.jpg");
		session.update(sanPham);
		return false;
	}

	// thong ke theo all, day, week, month, year
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<SanPham> ThongKeSanPham(String select, LocalDate start, LocalDate end) {
		Session session = sessionFactory.getCurrentSession();
		List<SanPham> listSanPhams = new ArrayList<>();
		if (start == null && end == null) {
			String query = "SELECT sp from SANPHAM sp";
			listSanPhams = (List<SanPham>) session.createQuery(query).getResultList();
		} else {
			String query = "SELECT sp " + "from SANPHAM sp " + "inner join sp.chitiethoadon cthd "
					+ "inner join cthd.hoadon hd " + "where hd.ngaylap between '" + start + "' and '" + end
					+ "' group by sp.tensanpham order by cthd.soluong DESC";
			listSanPhams = (List<SanPham>) session.createQuery(query).getResultList();
		}
		return listSanPhams;
	}

	// get danh sach san pham compare
	@Override
	@Transactional
	public List<SanPham> ListSanPhamConpare(String giatien) {
		int tientruoc = Integer.parseInt(giatien) - 300;
		int tiensau = Integer.parseInt(giatien) + 300;
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<SanPham> lstSanPham = (List<SanPham>) session
				.createQuery("select sp from SANPHAM sp WHERE sp.giatien between '" + tientruoc + "' and  '" + tiensau
						+ "' and not sp.giatien = '" + giatien + "'")
				.getResultList();
		return lstSanPham;
	}

	// thong ke tong doanh thu moi thang trong mot nam
	@Override
	@Transactional
	public ArrayList<Double> ThongKeDoanhThuMoiThang() throws NullPointerException {
		Session session = sessionFactory.getCurrentSession();
		ArrayList<Double> doanhthu = new ArrayList<Double>();
		try {
			for (int i = 1; i < 13; i++) {
				String query = "SELECT SUM(cthd.tongtien) from SANPHAM sp " + "left join sp.chitiethoadon cthd "
						+ "left join cthd.hoadon hd " + "where YEAR(ngaylap) = 2020 and MONTH(ngaylap) = " + i;
				String a = (String) session.createQuery(query).getSingleResult();
				if (a == null) {
					a = "0";
					double amount = Double.parseDouble(a);
					doanhthu.add(amount);
				} else {
					double amount = Double.parseDouble(a);
					doanhthu.add(amount);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doanhthu;
	}

	// thong ke so luong moi thang trong 1 nam
	@Override
	@Transactional
	public ArrayList<Long> ThongKeSoLuongMoiThang() throws NullPointerException{
		Session session = sessionFactory.getCurrentSession();
		ArrayList<Long> doanhthu = new ArrayList<Long>();
		try {
			for (int i = 1; i < 13; i++) {
				String query = "SELECT SUM(cthd.soluong) from SANPHAM sp " + "left join sp.chitiethoadon cthd "
						+ "left join cthd.hoadon hd " + "where YEAR(ngaylap) = 2020 and MONTH(ngaylap) = " + i;
				//long soluong = (long) session.createQuery(query).getSingleResult();
				Query x = session.createQuery(query);
				long soluong = 0;
				if(x.getSingleResult() == null) {
					soluong = 0;
				} else {
					soluong = (long) x.getSingleResult();
				}
				doanhthu.add(soluong);
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return doanhthu;
	}

	@Override
	@Transactional
	public List<SanPham> Test(String idtendanhmuc) {
		Session session = sessionFactory.getCurrentSession();
		String query = "SELECT dm FROM DANHMUCSANPHAM dm where dm.idtendanhmuc = '"+idtendanhmuc+"'";
		Query x = session.createQuery(query);
		if(x.getSingleResult() != null) {
			return null;
		} else {
			return null; 
		}
	}

	@Override
	@Transactional
	public SanPham GetSanPham_MutilImageById(int masanpham) {
		Session session = sessionFactory.getCurrentSession();
		String query = "select sp from SANPHAM sp where sp.masanpham=" + masanpham + " and sp.isdelete = " + 0 + " and sp.soluong > " + 5;
		SanPham sanPhams = (SanPham) session.createQuery(query).getSingleResult();

		return sanPhams;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<SanPham> getSoLuong_SP() {
		Session session = sessionFactory.getCurrentSession();
		List<SanPham> listSanPhams = new ArrayList<>();
		String query = "select sp from SANPHAM sp where sp.isdelete =" + 0;
		listSanPhams = (List<SanPham>) session.createQuery(query).getResultList();
		return listSanPhams;
	}

}
