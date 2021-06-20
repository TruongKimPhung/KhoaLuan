package com.dtu.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dtu.model.ChiTietHoaDon;
import com.dtu.repository.ChiTietHoaDonRepository;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ChiTietHoaDonDAO implements ChiTietHoaDonRepository {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public boolean ThemChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
		Session session = sessionFactory.getCurrentSession();
		int id = (int) session.save(chiTietHoaDon);
		if (id > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	@Transactional
	public Long lstChiTietHoaDon(int masanpham, int check) throws NullPointerException{
		Session session = sessionFactory.getCurrentSession();
		Long tongsoluong = (long) 0;
		String query = null;
		if(check == 0) {
			query = "SELECT sum(ct.soluong) from CHITIETHOADON ct where ct.sanpham.masanpham = " + masanpham;
		} else if(check == 1) {
			query = "SELECT sum(ct.soluong) from CHITIETHOADON ct";
		}
		try {
			long soluong = (long) session.createQuery(query).getSingleResult();
			tongsoluong = soluong;
		} catch (NullPointerException e) {
			tongsoluong = (long) 0;
		}
		return tongsoluong;
	}

}
