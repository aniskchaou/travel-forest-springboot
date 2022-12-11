package com.dev.delta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.delta.entities.Destination;

public interface DestinationRepository extends JpaRepository<Destination, Long> {

}
