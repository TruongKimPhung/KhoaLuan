package com.dtu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtu.model.Authorities;
import com.dtu.model.User;
import com.dtu.repository.UserRepository;
import com.fasterxml.jackson.databind.JsonNode;

@Service
public class UserService implements UserRepository {

	@Autowired
	UserRepository userRepository;

	@Override
	public boolean ThemNhanVien(User nhanVien) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> getUser() {
		// TODO Auto-generated method stub
		return userRepository.getUser();
	}

	@Override
	public User getUserById(String username) {
		return userRepository.getUserById(username);
	}

	@Override
	public List<User> ListHoaDonById(String username) {
		// TODO Auto-generated method stub
		return userRepository.ListHoaDonById(username);
	}

	@Override
	public boolean UpdateUser(JsonNode jsonObject, String username, String updatepassword) {
		// TODO Auto-generated method stub
		return userRepository.UpdateUser(jsonObject, username, updatepassword);
	}

	@Override
	public boolean UpdateUserAdmin(JsonNode jsonObject, String username) {
		// TODO Auto-generated method stub
		return userRepository.UpdateUserAdmin(jsonObject, username);
	}

	@Override
	public boolean XoaUserTheoMaUser(String username) {
		// TODO Auto-generated method stub
		return userRepository.XoaUserTheoMaUser(username);
	}

	@Override
	public boolean AddUser(String username, String hoten, String email, String password) {
		// TODO Auto-generated method stub
		return userRepository.AddUser(username, hoten, email, password);
	}

	@Override
	public List<Authorities> lstAuthorities(String username) {
		// TODO Auto-generated method stub
		return userRepository.lstAuthorities(username);
	}

	@Override
	public User checkEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.checkEmail(email);
	}

	@Override
	public ArrayList<Long> ThongKeUserMoiThang() {
		return userRepository.ThongKeUserMoiThang();
	}

	@Override
	public boolean UpdateNewPassword(String username, String password) {
		// TODO Auto-generated method stub
		return userRepository.UpdateNewPassword(username, password);
	}

}
