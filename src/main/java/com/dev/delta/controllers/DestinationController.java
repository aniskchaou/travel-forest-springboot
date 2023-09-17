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

import com.dev.delta.entities.Destination;
import com.dev.delta.services.DestinationService;

@Controller
public class DestinationController {
	/**
	 * destinationService
	 */
	@Autowired
	private DestinationService destinationService;

	@GetMapping("/adddestination")
	public String addd(Model model) {
		return "destination/add";
	}

	/**
	 * getCountries
	 * @param model
	 * @return
	 */
	@GetMapping("/destinations")
	public String getCountries(Model model) {
		List<Destination> countrries = destinationService.getDestinations();
		model.addAttribute("destinations", countrries);
		return "destination/index";
	}

	/**
	 * addDestination
	 * @param destination
	 * @param model
	 * @return
	 */
	@PostMapping("/adddestination")
	public String addDestination(Destination destination, Model model) {
		destinationService.save(destination);
		return "redirect:/destinations";
	}

	/**
	 * findById
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/destination/{id}")
	public String findById(@PathVariable("id") Long id, Model model) {

		Destination destination = destinationService.findById(id).get();
		model.addAttribute("media", destination);

		return "destination/edit";
	}

	/**
	 * updateDestination
	 * @param id
	 * @param destination
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/updatedestination/{id}")
	public String updateDestination(@PathVariable("id") long id, @Validated Destination destination, BindingResult result,
			Model model) {

		destinationService.save(destination);
		return "redirect:/destinations";
	}

	/**
	 * deleteDestination
	 * @param id
	 * @return
	 */
	@GetMapping("/deletedestination/{id}")
	@Transactional
	public String deleteDestination(@PathVariable("id") Long id) {
		destinationService.delete(id);
		return "redirect:/destinations";
	}
}
