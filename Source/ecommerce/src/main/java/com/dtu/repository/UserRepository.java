package com.dtu.repository;

import java.util.ArrayList;
import java.util.List;

import com.dtu.model.Authorities;
import com.dtu.model.User;
import com.fasterxml.jackson.databind.JsonNode;

public interface UserRepository {
	List<Authorities> lstAuthorities(String username);
	boolean ThemNhanVien(User nhanVien);
	boolean XoaUserTheoMaUser(String username);
	List<User> getUser();

	User getUserById(String username);
	User checkEmail(String email);

	List<User> ListHoaDonById(String username);

	boolean UpdateUser(JsonNode jsonObject, String username, String updatepassword);
	boolean AddUser(String username, String hoten, String email, String password);
	boolean UpdateUserAdmin(JsonNode jsonObject, String username);
	boolean UpdateNewPassword(String username, String password);
	// thong ke user so voi thang trc
	ArrayList<Long> ThongKeUserMoiThang();
}
