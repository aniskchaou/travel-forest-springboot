package com.dev.delta.controllers;

import java.util.List;

import javax.transaction.Transactional;

import com.dev.delta.entities.TravelOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.delta.services.OrderService;

@Controller
public class OrderController {
	/**
	 * orderService
	 */
	@Autowired
	private OrderService orderService;

	@GetMapping("/addorder")
	public String addd(Model model) {
		return "order/add";
	}

	/**
	 * getCountries
	 * @param model
	 * @return
	 */
	@GetMapping("/orders")
	public String getCountries(Model model) {
		List<TravelOrder> countrries = orderService.getOrders();
		model.addAttribute("orders", countrries);
		return "order/index";
	}

	/**
	 * addOrder
	 * @param travelOrder
	 * @param model
	 * @return
	 */
	@PostMapping("/addorder")
	public String addOrder(TravelOrder travelOrder, Model model) {
		orderService.save(travelOrder);
		return "redirect:/orders";
	}

	/**
	 * findById
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/order/{id}")
	public String findById(@PathVariable("id") Long id, Model model) {

		TravelOrder travelOrder = orderService.findById(id).get();
		model.addAttribute("media", travelOrder);

		return "order/edit";
	}

	/**
	 * updateOrder
	 * @param id
	 * @param travelOrder
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/updateorder/{id}")
	public String updateOrder(@PathVariable("id") long id, @Validated TravelOrder travelOrder, BindingResult
	result,
							  Model model) {

		orderService.save(travelOrder);
		return "redirect:/orders";
	}

	/**
	 * deleteOrder
	 * @param id
	 * @return
	 */
	@GetMapping("/deleteorder/{id}")
	@Transactional
	public String deleteOrder(@PathVariable("id") Long id) {
		orderService.delete(id);
		return "redirect:/orders";
	}
}
