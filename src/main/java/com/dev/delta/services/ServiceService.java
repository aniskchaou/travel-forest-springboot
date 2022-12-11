package com.dev.delta.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.dev.delta.entities.Service;
import com.dev.delta.repositories.ServiceRepository;

@org.springframework.stereotype.Service
public class ServiceService {

	/**
	 * serviceRepository
	 */
	@Autowired
	private ServiceRepository serviceRepository;
	

	/**
	 * getServices
	 * @return
	 */
	public List<Service> getServices()
	{
		return serviceRepository.findAll();
	}
	
	/**
	 * getCount
	 * @return
	 */
	public long getCount()
	{
		return serviceRepository.count();
	}

	/**
	 * save
	 * @param service
	 */
	public void save(Service service)
	{
		serviceRepository.save(service);
	}

    /**
     * findById
     * @param id
     * @return
     */
	public Optional<Service> findById(Long id) {
		return serviceRepository.findById(id);
	}

	/**
	 * delete
	 * @param id
	 */
	public void delete(Long id) {
		serviceRepository.delete(serviceRepository.findById(id).get());
	}
}
