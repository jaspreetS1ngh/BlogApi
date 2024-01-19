package com.example.blog.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog.payloads.UserDTO;
import com.example.blog.services.UserServices;


@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserServices userService;
    @PostMapping("/")
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDto){

		UserDTO CreatedUser=this.userService.createUser(userDto);

		return new ResponseEntity<>(CreatedUser, HttpStatus.CREATED);

	}


}
