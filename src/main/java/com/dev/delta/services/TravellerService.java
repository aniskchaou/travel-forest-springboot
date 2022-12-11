package com.dev.delta.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Traveller;
import com.dev.delta.repositories.TravellerRepository;

@Service
public class TravellerService {

	/**
	 * travellerRepository
	 */
	@Autowired
	private TravellerRepository travellerRepository;
	

	/**
	 * getTravellers
	 * @return
	 */
	public List<Traveller> getTravellers()
	{
		return travellerRepository.findAll();
	}
	
	/**
	 * getCount
	 * @return
	 */
	public long getCount()
	{
		return travellerRepository.count();
	}

	/**
	 * save
	 * @param traveller
	 */
	public void save(Traveller traveller)
	{
		travellerRepository.save(traveller);
	}

    /**
     * findById
     * @param id
     * @return
     */
	public Optional<Traveller> findById(Long id) {
		return travellerRepository.findById(id);
	}

	/**
	 * delete
	 * @param id
	 */
	public void delete(Long id) {
		travellerRepository.delete(travellerRepository.findById(id).get());
	}
}
