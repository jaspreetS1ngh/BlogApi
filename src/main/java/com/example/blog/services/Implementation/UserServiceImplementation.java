package com.example.blog.services.Implementation;

import java.util.List;

import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blog.entities.User;
import com.example.blog.payloads.UserDTO;
import com.example.blog.repositories.UserRepo;
import com.example.blog.services.UserServices;

@Service
public class UserServiceImplementation implements UserServices {
	
	@Autowired
	private UserRepo userRepo;

	

	@Override
	public UserDTO createUser(UserDTO user) {
		
		User user2=userRepo.save(userDtoToUser(user));
		
		
		return this.userToUserDTO(user2);
	}

	@Override
	public UserDTO updateUser(UserDTO user, Integer userId) {
		//User user1;
		try {
			User user1=this.userRepo.getReferenceById(userId);
		user1.setAbout(user.getAbout());
		user1.setName(user.getName());
		return userToUserDTO(user1);
		}catch(Exception e) {
			System.out.print("User Not Found!!!!!!!!!!!!");
		}
		
		return null;
		
		
		
	}

	@Override
	public UserDTO getUserById(Integer userId) {
		try {
			User user1=this.userRepo.getReferenceById(userId);
		
		return userToUserDTO(user1);
		}catch(Exception e) {
			System.out.print("User Not Found!!!!!!!!!!!!");
		}
		
		return null;
	}

	@Override
	public List<UserDTO> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> l= this.userRepo.findAll();
		
		List<UserDTO> l2=l.stream().map(user->this.userToUserDTO(user)).collect(Collectors.toList());
		return l2;
	}

	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		try {
			User user1=this.userRepo.getReferenceById(userId);
		
		this.userRepo.deleteById(userId);
		}catch(Exception e) {
			System.out.print("User Not Found!!!!!!!!!!!!");
		}
		
	}
	
	private User userDtoToUser(UserDTO user) {
		User u= new User();
		u.setId(user.getId());
		u.setAbout(user.getAbout());
		u.setName(user.getName());
		u.setPassword(user.getPassword());
		return u;
		
		
	}
	private UserDTO userToUserDTO(User user) {
		UserDTO u= new UserDTO();
		u.setId(user.getId());
		u.setAbout(user.getAbout());
		u.setName(user.getName());
		u.setPassword(user.getPassword());
		return u;
		
		
	}
	

}
