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

import com.dev.delta.entities.Service;
import com.dev.delta.services.ServiceService;

@Controller
public class ServiceController {
	/**
	 * serviceService
	 */
	@Autowired
	private ServiceService serviceService;

	@GetMapping("/addservice")
	public String addd(Model model) {
		return "service/add";
	}

	/**
	 * getCountries
	 * @param model
	 * @return
	 */
	@GetMapping("/servicess")
	public String getCountries(Model model) {
		List<Service> countrries = serviceService.getServices();
		model.addAttribute("services", countrries);
		return "service/index";
	}

	/**
	 * addService
	 * @param service
	 * @param model
	 * @return
	 */
	@PostMapping("/addservice")
	public String addService(Service service, Model model) {
		serviceService.save(service);
		return "redirect:/servicess";
	}

	/**
	 * findById
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/service/{id}")
	public String findById(@PathVariable("id") Long id, Model model) {

		Service service = serviceService.findById(id).get();
		model.addAttribute("media", service);

		return "service/edit";
	}

	/**
	 * updateService
	 * @param id
	 * @param service
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/updateservice/{id}")
	public String updateService(@PathVariable("id") long id, @Validated Service service,
			BindingResult result,
			Model model) {

		serviceService.save(service);
		return "redirect:/servicess";
	}

	/**
	 * deleteService
	 * @param id
	 * @return
	 */
	@GetMapping("/deleteservice/{id}")
	@Transactional
	public String deleteService(@PathVariable("id") Long id) {
		serviceService.delete(id);
		return "redirect:/servicess";
	}
}
