package com.dev.delta.repositories;

import com.dev.delta.entities.TravelOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<TravelOrder, Long> {

}
