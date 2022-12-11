package com.dev.delta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.delta.entities.Packages;

public interface PackagesRepository extends JpaRepository<Packages, Long> {

}
