package com.dev.delta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.delta.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
