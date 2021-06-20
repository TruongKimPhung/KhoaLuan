package com.dtu.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dtu.model.DanhMucSanPham;
import com.dtu.model.SanPham;
import com.dtu.repository.DanhMucSanPhamRepository;
import com.fasterxml.jackson.databind.JsonNode;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DanhMucDAO implements DanhMucSanPhamRepository {

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<DanhMucSanPham> LayDanhMuc(int batdau) {
		List<DanhMucSanPham> danhMucSanPhams = new ArrayList<DanhMucSanPham>();
		Session session = sessionFactory.getCurrentSession();
		if (batdau < 0) {
			String query = "select dm from DANHMUCSANPHAM dm where dm.isdelete = " + 0 + " and dm.madanhmuccha = "+ 0;
			danhMucSanPhams = (List<DanhMucSanPham>) session.createQuery(query).getResultList();
		}  else {
			String query = "select dm from DANHMUCSANPHAM dm where dm.isdelete = " + 0 + "";
			danhMucSanPhams = (List<DanhMucSanPham>) session.createQuery(query).setFirstResult(batdau).setMaxResults(10)
					.getResultList();
		}
		return danhMucSanPhams;
	}

	@Override
	@Transactional
	public boolean ThemDanhMuc(String tendanhmuc, String madanhmuccha) {
		Session session = sessionFactory.getCurrentSession();
		DanhMucSanPham danhMucSanPham = new DanhMucSanPham();
		danhMucSanPham.setTendanhmuc(tendanhmuc);
		if (madanhmuccha.equals("")) {
			danhMucSanPham.setMadanhmuccha(0);
		} else {
			danhMucSanPham.setMadanhmuccha(Integer.valueOf(madanhmuccha));
		}
		int id = (int) session.save(danhMucSanPham);
		if (id > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	@Transactional
	public boolean UpdateDanhMuc(JsonNode jsonObject) {
		Session session = sessionFactory.getCurrentSession();
		String tendanhmuc = jsonObject.get("tendanhmuc").asText();
		String madanhmuccha = jsonObject.get("madanhmuccha").get("madanhmuc").asText();
		int madanhmuc = jsonObject.get("madanhmuc").asInt();
		DanhMucSanPham danhMucSanPham = session.find(DanhMucSanPham.class, madanhmuc);
		if (madanhmuccha.equals("")) {
			danhMucSanPham.setMadanhmuccha(0);
		} else {
			danhMucSanPham.setMadanhmuccha(Integer.valueOf(madanhmuccha));
		}
		danhMucSanPham.setTendanhmuc(tendanhmuc);
		session.update(danhMucSanPham);
		return false;
	}

	@Override
	@Transactional
	public boolean XoaDanhMucTheoMaDanhMuc(int madanhmuc) {
		Session session = sessionFactory.getCurrentSession();
		session.createQuery("update DANHMUCSANPHAM set isdelete = " + 1 + " WHERE madanhmuc=" + madanhmuc)
				.executeUpdate();
		return false;
	}

	@Override
	@Transactional
	public DanhMucSanPham getDanhMucCha(int madanhmuc) {
		Session session = sessionFactory.getCurrentSession();
		String query = "from DANHMUCSANPHAM where isdelete = " + 0 + " and madanhmuc=" + madanhmuc + "";
		DanhMucSanPham danhMucSanPhams = (DanhMucSanPham) session.createQuery(query).getSingleResult();
		int madanhmuccha = danhMucSanPhams.getMadanhmuccha();
		if (madanhmuccha == 0) {
			return null;
		}
		String queryDMcha = "from DANHMUCSANPHAM where isdelete = " + 0 + " and madanhmuc=" + madanhmuccha + "";
		DanhMucSanPham danhMucSP = (DanhMucSanPham) session.createQuery(queryDMcha).getSingleResult();
		return danhMucSP;

	}

	@Override
	@Transactional
	public List<DanhMucSanPham> LayDanhMucCha(int madanhmuc) {
		Session session = sessionFactory.getCurrentSession();
		String query;
		if (madanhmuc == 0) {
			query = "select dm from DANHMUCSANPHAM dm where dm.isdelete = " + 0 + "";
		} else {
			query = "select dm from DANHMUCSANPHAM dm where dm.isdelete = " + 0 + " and not dm.madanhmuc= '" + madanhmuc + "'";
		}
		@SuppressWarnings("unchecked")
		List<DanhMucSanPham> danhMucSanPhams = session.createQuery(query).getResultList();

 		return danhMucSanPhams;
	}

	@Override
	@Transactional
	public List<SanPham> getDistintRomOfDanhMuc(int madanhmuc) {
		Session session = sessionFactory.getCurrentSession();
		String query = "select sp from SANPHAM sp where sp.danhmucsanpham.madanhmuc=" + madanhmuc + " "
				+ "and sp.isdelete = " + 0 +" group by sp.rom order by sp.rom ASC";
		@SuppressWarnings("unchecked")
		List<SanPham> listSanPhams = (List<SanPham>) session.createQuery(query).getResultList();
		return listSanPhams;
	}

	@Override
	@Transactional
	public List<SanPham> getDistintRamOfDanhMuc(int madanhmuc) {
		Session session = sessionFactory.getCurrentSession();
		String query = "select sp from SANPHAM sp where sp.danhmucsanpham.madanhmuc=" + madanhmuc + " "
				+ "and sp.isdelete = " + 0 +" group by sp.ram order by sp.ram ASC";
		@SuppressWarnings("unchecked")
		List<SanPham> listSanPhams = (List<SanPham>) session.createQuery(query).getResultList();
		return listSanPhams;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<DanhMucSanPham> getDanhMucChu(int madanhmuccha) {
		List<DanhMucSanPham> danhMucSanPhams = new ArrayList<DanhMucSanPham>();
		Session session = sessionFactory.getCurrentSession();
		String query = "select dm from DANHMUCSANPHAM dm where dm.isdelete = " + 0 + " and dm.madanhmuccha = "+ madanhmuccha;
		danhMucSanPhams = (List<DanhMucSanPham>) session.createQuery(query).getResultList();
		return danhMucSanPhams;
	}

}
