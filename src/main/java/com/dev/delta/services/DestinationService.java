package com.dev.delta.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Destination;
import com.dev.delta.repositories.DestinationRepository;

@Service
public class DestinationService {

	/**
	 * destinationRepository
	 */
	@Autowired
	private DestinationRepository destinationRepository;
	

	/**
	 * getDestinations
	 * @return
	 */
	public List<Destination> getDestinations()
	{
		return destinationRepository.findAll();
	}
	
	/**
	 * getCount
	 * @return
	 */
	public long getCount()
	{
		return destinationRepository.count();
	}

	/**
	 * save
	 * @param destination
	 */
	public void save(Destination destination)
	{
		destinationRepository.save(destination);
	}

    /**
     * findById
     * @param id
     * @return
     */
	public Optional<Destination> findById(Long id) {
		return destinationRepository.findById(id);
	}

	/**
	 * delete
	 * @param id
	 */
	public void delete(Long id) {
		destinationRepository.delete(destinationRepository.findById(id).get());
	}
}
