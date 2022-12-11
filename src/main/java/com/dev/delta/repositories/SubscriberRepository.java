package com.dev.delta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.delta.entities.Subscriber;

public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {

}
