package com.dev.delta.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Subscriber;
import com.dev.delta.repositories.SubscriberRepository;

@Service
public class SubscriberService {

	/**
	 * subscriberRepository
	 */
	@Autowired
	private SubscriberRepository subscriberRepository;
	

	/**
	 * getSubscribers
	 * @return
	 */
	public List<Subscriber> getSubscribers()
	{
		return subscriberRepository.findAll();
	}
	
	/**
	 * getCount
	 * @return
	 */
	public long getCount()
	{
		return subscriberRepository.count();
	}

	/**
	 * save
	 * @param subscriber
	 */
	public void save(Subscriber subscriber)
	{
		subscriberRepository.save(subscriber);
	}

    /**
     * findById
     * @param id
     * @return
     */
	public Optional<Subscriber> findById(Long id) {
		return subscriberRepository.findById(id);
	}

	/**
	 * delete
	 * @param id
	 */
	public void delete(Long id) {
		subscriberRepository.delete(subscriberRepository.findById(id).get());
	}
}
