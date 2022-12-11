package com.dev.delta.dto;

import com.dev.delta.entities.Role;
import com.dev.delta.entities.User;

public interface DTO {

	User user=new User();
	Role role=new Role();
	public void populate();
}
