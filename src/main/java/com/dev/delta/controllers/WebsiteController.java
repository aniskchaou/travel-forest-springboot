package com.dev.delta.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class WebsiteController {
	@GetMapping("/")
	public String home(Model model) {
		System.out.println("ljhkjhlk");
		return "root/index";
	}
	
	@GetMapping("/tours")
	public String tours(Model model) {
		System.out.println("ljhkjhlk");
		return "root/tours";
	}
	
	@GetMapping("/contact")
	public String contact(Model model) {
		System.out.println("ljhkjhlk");
		return "root/contact";
	}
	
	
	@GetMapping("/about")
	public String about(Model model) {
		System.out.println("ljhkjhlk");
		return "root/about";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
	
		System.out.println("ljhkjhlk");
		return "auth/login";
	}

	@GetMapping("/dashboard")
	public String dashboard(Model model) {


		return "dashboard/dashboard";
	}

	@GetMapping("/profile")
	public String profile(Model model) {
		return "profile/profile";
	}
}
