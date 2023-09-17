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

import com.dev.delta.entities.Traveller;
import com.dev.delta.services.TravellerService;

@Controller
public class TravellerController {
	/**
	 * travellerService
	 */
	@Autowired
	private TravellerService travellerService;

	/**
	 * getCountries
	 * @param model
	 * @return
	 */
	@GetMapping("/travellers")
	public String getCountries(Model model) {
		List<Traveller> countrries = travellerService.getTravellers();
		model.addAttribute("travellers", countrries);
		return "traveller/index";
	}

	@GetMapping("/addtraveller")
	public String addd(Model model) {
		return "traveller/add";
	}

	/**
	 * addTraveller
	 * @param traveller
	 * @param model
	 * @return
	 */
	@PostMapping("/addtraveller")
	public String addTraveller(Traveller traveller, Model model) {
		travellerService.save(traveller);
		return "redirect:/travellers";
	}

	/**
	 * findById
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/traveller/{id}")
	public String findById(@PathVariable("id") Long id, Model model) {

		Traveller traveller = travellerService.findById(id).get();
		model.addAttribute("media", traveller);

		return "traveller/edit";
	}

	/**
	 * updateTraveller
	 * @param id
	 * @param traveller
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/updatetraveller/{id}")
	public String updateTraveller(@PathVariable("id") long id, @Validated Traveller traveller,
			BindingResult result,
			Model model) {

		travellerService.save(traveller);
		return "redirect:/travellers";
	}

	/**
	 * deleteTraveller
	 * @param id
	 * @return
	 */
	@GetMapping("/deletetraveller/{id}")
	@Transactional
	public String deleteTraveller(@PathVariable("id") Long id) {
		travellerService.delete(id);
		return "redirect:/travellers";
	}
}
