package com.dev.delta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.delta.entities.Traveller;

public interface TravellerRepository extends JpaRepository<Traveller, Long> {

}
