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

import com.dev.delta.entities.Subscriber;
import com.dev.delta.services.SubscriberService;

@Controller
public class SubscriberController {
	/**
	 * subscriberService
	 */
	@Autowired
	private SubscriberService subscriberService;

	/**
	 * getCountries
	 * @param model
	 * @return
	 */
	@GetMapping("/subscribers")
	public String getSubscribers(Model model) {
		List<Subscriber> countrries = subscriberService.getSubscribers();
		model.addAttribute("countries", countrries);
		return "subscriber";
	}

	/**
	 * addSubscriber
	 * @param subscriber
	 * @param model
	 * @return
	 */
	@PostMapping("/addsubscriber")
	public String addSubscriber(Subscriber subscriber, Model model) {
		subscriberService.save(subscriber);
		return "redirect:/countries";
	}

	/**
	 * findById
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/subscriber/{id}")
	public String findById(@PathVariable("id") Long id, Model model) {

		Subscriber subscriber = subscriberService.findById(id).get();
		model.addAttribute("subscriber", subscriber);

		return "editSubscriber";
	}

	/**
	 * updateSubscriber
	 * @param id
	 * @param subscriber
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/updatesubscriber/{id}")
	public String updateSubscriber(@PathVariable("id") long id,
			@Validated Subscriber subscriber, BindingResult result,
			Model model) {

		subscriberService.save(subscriber);
		return "redirect:/countries";
	}

	/**
	 * deleteSubscriber
	 * @param id
	 * @return
	 */
	@GetMapping("/deletesubscriber/{id}")
	@Transactional
	public String deleteSubscriber(@PathVariable("id") Long id) {
		subscriberService.delete(id);
		return "redirect:/countries";
	}
}
