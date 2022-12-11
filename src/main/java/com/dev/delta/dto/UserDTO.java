package com.dev.delta.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Role;
import com.dev.delta.repositories.RoleRepository;
import com.dev.delta.repositories.UserRepository;

@Service
public class UserDTO implements DTO {
   
	@Autowired
	UserRepository  userRepository;
	
	@Autowired
	RoleRepository  roleRepository;
	
	@Override
	public void populate() {
		// TODO Auto-generated method stub

		user.setUsername("admin");
		user.setPassword("admin");
		user.setRole(role);
		role.setName("admin");
		roleRepository.save(role);
		userRepository.save(user);
	}

}
