package com.dev.delta.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.repositories.BlogRepository;

@Service
public class BlogDTO implements DTO {

	@Autowired
	BlogRepository  blogRepository;
	
	@Override
	public void populate() {
		// TODO Auto-generated method stub
		
	}

}
