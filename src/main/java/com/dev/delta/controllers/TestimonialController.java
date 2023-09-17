package com.dev.delta.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.delta.entities.Testemonial;
import com.dev.delta.services.TestemonialService;

@Controller
public class TestimonialController {
	/**
	 * testimonialService
	 */
	@Autowired
	private TestemonialService testimonialService;

	@GetMapping("/addtestimonial")
	public String addd(Model model) {
		return "testimonial/add";
	}

	/**
	 * getCountries
	 * @param model
	 * @return
	 */
	@GetMapping("/testimonials")
	public String getCountries(Model model) {
		List<Testemonial> countrries = testimonialService.getTestimonials();
		model.addAttribute("testimonials", countrries);
		return "testimonial/index";
	}

	/**
	 * addTestimonial
	 * @param testimonial
	 * @param model
	 * @return
	 */
	@PostMapping("/addtestimonial")
	public String addTestimonial(Testemonial testimonial, Model model) {
		testimonialService.save(testimonial);
		return "redirect:/testimonials";
	}

	/**
	 * findById
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/testimonial/{id}")
	public String findById(@PathVariable("id") Long id, Model model) {

		Testemonial testimonial = testimonialService.findById(id).get();
		model.addAttribute("testimonial", testimonial);

		return "testimonial/edit";
	}

	/**
	 * updateTestimonial
	 * @param id
	 * @param testimonial
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/updatetestimonial/{id}")
	public String updateTestimonial(@PathVariable("id") long id, @Validated Testemonial
			testimonial, BindingResult result,
			Model model) {

		testimonialService.save(testimonial);
		return "redirect:/testimonials";
	}

	/**
	 * deleteTestimonial
	 * @param id
	 * @return
	 */
	@GetMapping("/deletetestimonial/{id}")
	@Transactional
	public String deleteTestimonial(@PathVariable("id") Long id) {
		testimonialService.delete(id);
		return "redirect:/testimonials";
	}
}
