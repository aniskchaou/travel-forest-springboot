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

import com.dev.delta.entities.Slider;
import com.dev.delta.services.SliderService;

@Controller
public class SliderController {
	/**
	 * sliderService
	 */
	@Autowired
	private SliderService sliderService;

	/**
	 * getCountries
	 * @param model
	 * @return
	 */
	@GetMapping("/sliders")
	public String getCountries(Model model) {
		List<Slider> countrries = sliderService.getSliders();
		model.addAttribute("countries", countrries);
		return "slider/index";
	}

	/**
	 * addSlider
	 * @param slider
	 * @param model
	 * @return
	 */
	@PostMapping("/addslider")
	public String addSlider(Slider slider, Model model) {
		sliderService.save(slider);
		return "redirect:/countries";
	}

	/**
	 * findById
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/slider/{id}")
	public String findById(@PathVariable("id") Long id, Model model) {

		Slider slider = sliderService.findById(id).get();
		model.addAttribute("slider", slider);

		return "editSlider";
	}

	/**
	 * updateSlider
	 * @param id
	 * @param slider
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/updateslider/{id}")
	public String updateSlider(@PathVariable("id") long id, @Validated Slider slider,
			BindingResult result,
			Model model) {

		sliderService.save(slider);
		return "redirect:/countries";
	}

	/**
	 * deleteSlider
	 * @param id
	 * @return
	 */
	@GetMapping("/deleteslider/{id}")
	@Transactional
	public String deleteSlider(@PathVariable("id") Long id) {
		sliderService.delete(id);
		return "redirect:/countries";
	}
}
