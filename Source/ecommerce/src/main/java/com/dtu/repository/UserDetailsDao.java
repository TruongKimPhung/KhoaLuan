package com.dtu.repository;

import com.dtu.model.User;

public interface UserDetailsDao {
	User findUserByUsername(String username);
}
