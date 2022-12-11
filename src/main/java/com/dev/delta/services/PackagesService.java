package com.dev.delta.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Packages;
import com.dev.delta.repositories.PackagesRepository;

@Service
public class PackagesService {

	/**
	 * packageRepository
	 */
	@Autowired
	private PackagesRepository packageRepository;
	

	/**
	 * getPackages
	 * @return
	 */
	public List<Packages> getPackages()
	{
		return packageRepository.findAll();
	}
	
	/**
	 * getCount
	 * @return
	 */
	public long getCount()
	{
		return packageRepository.count();
	}

	/**
	 * save
	 * @param package
	 */
	public void save(Packages pacckage)
	{
		packageRepository.save(pacckage);
	}

    /**
     * findById
     * @param id
     * @return
     */
	public Optional<Packages> findById(Long id) {
		return packageRepository.findById(id);
	}

	/**
	 * delete
	 * @param id
	 */
	public void delete(Long id) {
		packageRepository.delete(packageRepository.findById(id).get());
	}
}
