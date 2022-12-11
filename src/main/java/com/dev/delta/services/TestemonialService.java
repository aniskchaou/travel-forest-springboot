package com.dev.delta.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Testemonial;
import com.dev.delta.repositories.TestemonialRepository;

@Service
public class TestemonialService {

	/**
	 * testimonialRepository
	 */
	@Autowired
	private TestemonialRepository testimonialRepository;
	

	/**
	 * getTestimonials
	 * @return
	 */
	public List<Testemonial> getTestimonials()
	{
		return testimonialRepository.findAll();
	}
	
	/**
	 * getCount
	 * @return
	 */
	public long getCount()
	{
		return testimonialRepository.count();
	}

	/**
	 * save
	 * @param testimonial
	 */
	public void save(Testemonial testimonial)
	{
		testimonialRepository.save(testimonial);
	}

    /**
     * findById
     * @param id
     * @return
     */
	public Optional<Testemonial> findById(Long id) {
		return testimonialRepository.findById(id);
	}

	/**
	 * delete
	 * @param id
	 */
	public void delete(Long id) {
		testimonialRepository.delete(testimonialRepository.findById(id).get());
	}
}
