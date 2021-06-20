package com.dtu.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dtu.Commom.GetDate;
import com.dtu.model.Authorities;
import com.dtu.model.User;
import com.dtu.repository.UserRepository;
import com.fasterxml.jackson.databind.JsonNode;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserDao implements UserRepository {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean ThemNhanVien(User nhanVien) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transactional
	public List<User> getUser() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("SELECT a FROM User a where a.enabled = true", User.class).getResultList();
	}

	@Override
	@Transactional
	public User getUserById(String username) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.find(User.class, username);
		return user;
		//return sessionFactory.getCurrentSession().get(User.class, username);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<User> ListHoaDonById(String username) {
		// TODO Auto-generated method stub
		return (List<User>) sessionFactory.getCurrentSession().get(User.class, username);
	}

	@Override
	@Transactional
	public boolean UpdateUser(JsonNode jsonObject, String username, String updatepassword) {

		Session session = sessionFactory.getCurrentSession();
		User savedUser = session.find(User.class, username);
		if (updatepassword == null) {
			String hoten = jsonObject.get("hoten").asText();
			String diachi = jsonObject.get("diachi").asText();
			String gioitinh = jsonObject.get("gioitinh").asText();
			String cmnd = jsonObject.get("cmnd").asText();
			String email = jsonObject.get("email").asText();
			savedUser.setHoten(hoten);
			savedUser.setDiachi(diachi);
			savedUser.setGioitinh(gioitinh);
			savedUser.setCmnd(cmnd);
			savedUser.setEmail(email);
		} else {
			savedUser.setPassword(updatepassword);
		}
		session.update(savedUser);
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public boolean UpdateUserAdmin(JsonNode jsonObject, String username) {
		Session session = sessionFactory.getCurrentSession();
		User savedUser = session.find(User.class, username);
		String hoten = jsonObject.get("hoten").asText();
		String diachi = jsonObject.get("diachi").asText();
		String gioitinh = jsonObject.get("gioitinh").asText();
		String cmnd = jsonObject.get("cmnd").asText();
		String email = jsonObject.get("email").asText();
		String role = jsonObject.get("role").asText();
		savedUser.setHoten(hoten);
		savedUser.setDiachi(diachi);
		savedUser.setGioitinh(gioitinh);
		savedUser.setCmnd(cmnd);
		savedUser.setEmail(email);
		session.update(savedUser);
		List<Authorities> authorities = new ArrayList<Authorities>();
		String query = "from Authorities where username = '" + username + "'";
		authorities = (List<Authorities>) session.createQuery(query).getResultList();
		if (authorities.size() == 0) {
			Authorities au = new Authorities();
			au.setAuthority(role);
			au.setUser(savedUser);
			session.save(au);
		} else {
			session.createQuery("update Authorities set authority = '" + role + "' WHERE username= '" + username + "'")
					.executeUpdate();
		}

		return false;
	}

	@Override
	@Transactional
	public boolean XoaUserTheoMaUser(String username) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.find(User.class, username);
		user.setEnabled(false);
		session.update(user);
		return false;
	}
	
	private GetDate getdate;

	@Override
	@Transactional
	public boolean AddUser(String username, String hoten, String email, String password) {
		Session session = sessionFactory.getCurrentSession();
		User savedUser = new User();
		savedUser.setUsername(username);
		savedUser.setHoten(hoten);
		savedUser.setEmail(email);
		savedUser.setPassword(password);
		savedUser.setEnabled(true);
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			LocalDateTime now = LocalDateTime.now();
			Date date = formatter.parse(dtf.format(now));
			savedUser.setCreatedate(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String id1 = (String) session.save(savedUser);
		Authorities au = new Authorities();
		au.setAuthority("ROLE_MEMBER");
		au.setUser(savedUser);
		session.save(au);
		if (id1 != null) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Authorities> lstAuthorities(String username) {
		Session session = sessionFactory.getCurrentSession();

		if (username == null) {
			return session.createQuery("SELECT a FROM Authorities a", Authorities.class).getResultList();
		} else {
			List<Authorities> authorities = new ArrayList<Authorities>();
			String query = "from Authorities where username = '" + username + "'";
			authorities = (List<Authorities>) session.createQuery(query).getResultList();
			return authorities;
		}
	}

	@Override
	@Transactional
	public User checkEmail(String email) throws NullPointerException {
		User user = null;
		Session session = sessionFactory.getCurrentSession();
		String query = "SELECT a FROM User a where a.email = '" + email + "'";
		try {
			user = (User) session.createQuery(query).getSingleResult();
			if (user != null) {
				return user;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	@Transactional
	public ArrayList<Long> ThongKeUserMoiThang() {
		Session session = sessionFactory.getCurrentSession();
		ArrayList<Long> user = new ArrayList<Long>();
		try {
			for (int i = 1; i < 13; i++) {
				String query = "SELECT count(*) from User user "
						+ "where YEAR(createdate) = 2020 and MONTH(createdate) = " + i;
				long result = (long) session.createQuery(query).getSingleResult();
				user.add(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	@Transactional
	public boolean UpdateNewPassword(String username, String password) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.find(User.class, username);
		user.setPassword(password);
		session.update(user);
		return false;
	}

}
