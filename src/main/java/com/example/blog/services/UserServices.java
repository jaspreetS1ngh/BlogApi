package com.example.blog.services;

import java.util.List;

import com.example.blog.payloads.UserDTO;

public interface UserServices {
	
	UserDTO createUser(UserDTO user);
	UserDTO updateUser(UserDTO user,Integer userId);
	UserDTO getUserById(Integer userId);
	List<UserDTO> getAllUsers();
	void deleteUser(Integer userId);
	

}
