package com.dev.delta.services;

import java.util.List;
import java.util.Optional;

import com.dev.delta.entities.TravelOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.repositories.OrderRepository;

@Service
public class OrderService {

	/**
	 * orderRepository
	 */
	@Autowired
	private OrderRepository orderRepository;
	

	/**
	 * getOrders
	 * @return
	 */
	public List<TravelOrder> getOrders()
	{
		return orderRepository.findAll();
	}
	
	/**
	 * getCount
	 * @return
	 */
	public long getCount()
	{
		return orderRepository.count();
	}

	/**
	 * save
	 * @param travelOrder
	 */
	public void save(TravelOrder travelOrder)
	{
		orderRepository.save(travelOrder);
	}

    /**
     * findById
     * @param id
     * @return
     */
	public Optional<TravelOrder> findById(Long id) {
		return orderRepository.findById(id);
	}

	/**
	 * delete
	 * @param id
	 */
	public void delete(Long id) {
		orderRepository.delete(orderRepository.findById(id).get());
	}
}
