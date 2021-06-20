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

import com.dtu.model.ChiTietHoaDon;
import com.dtu.model.HoaDon;
import com.dtu.repository.HoaDonRepository;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class HoaDonDAO implements HoaDonRepository{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public int ThemHoaDon(HoaDon hoaDon) {
		Session session = sessionFactory.getCurrentSession();
		int id = (int) session.save(hoaDon);
		if(id > 0) {
			return id;
		}else {
			return 0;
		}
	
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<HoaDon> lstHoaDon() {
		Session session = sessionFactory.getCurrentSession();
		List<HoaDon> listHoaDon = new ArrayList<>();
		
		String query = "from HOADON";
		listHoaDon = (List<HoaDon>) session.createQuery(query).getResultList();
		return listHoaDon;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<ChiTietHoaDon> lstChiTietHoaDon(String select, String start, String end) {
		Session session = sessionFactory.getCurrentSession();
		List<ChiTietHoaDon> listHoaDon = new ArrayList<>();
		//SELECT a FROM Author a JOIN a.books b 
		String query = "from CHITIETHOADON";
		listHoaDon = (List<ChiTietHoaDon>) session.createQuery(query).getResultList();
		return listHoaDon;
	}

	@Override
	@Transactional
	public List<HoaDon> lstHoaDonTheoUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		String query = "from HOADON a where a.usernameid = '"+username+"'";
		@SuppressWarnings("unchecked")
		List<HoaDon> listHoaDon = (List<HoaDon>) session.createQuery(query).getSingleResult();
		return listHoaDon;
	}

}
