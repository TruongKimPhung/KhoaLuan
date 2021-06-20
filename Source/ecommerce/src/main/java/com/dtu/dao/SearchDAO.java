package com.dtu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.dtu.model.SanPham;
import com.dtu.repository.SearchRepository;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class SearchDAO implements SearchRepository {

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<SanPham> SearchSanPhamLimit(String tensp) throws NullPointerException, StackOverflowError{
		Session session = sessionFactory.getCurrentSession();
		List<SanPham> listSanPhams = new ArrayList<>();
		try {
			String query = "SELECT sp from SANPHAM sp where sp.isdelete = 0 and sp.soluong > 0 and sp.tensanpham like '%"+tensp+"%' order by sp.ngaynhap DESC";
			System.out.println(query);
			listSanPhams = session.createQuery(query).setMaxResults(5).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return listSanPhams;
	}

}
