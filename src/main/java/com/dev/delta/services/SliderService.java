package com.dev.delta.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Slider;
import com.dev.delta.repositories.SliderRepository;

@Service
public class SliderService {

	/**
	 * sliderRepository
	 */
	@Autowired
	private SliderRepository sliderRepository;
	

	/**
	 * getSliders
	 * @return
	 */
	public List<Slider> getSliders()
	{
		return sliderRepository.findAll();
	}
	
	/**
	 * getCount
	 * @return
	 */
	public long getCount()
	{
		return sliderRepository.count();
	}

	/**
	 * save
	 * @param slider
	 */
	public void save(Slider slider)
	{
		sliderRepository.save(slider);
	}

    /**
     * findById
     * @param id
     * @return
     */
	public Optional<Slider> findById(Long id) {
		return sliderRepository.findById(id);
	}

	/**
	 * delete
	 * @param id
	 */
	public void delete(Long id) {
		sliderRepository.delete(sliderRepository.findById(id).get());
	}
}
