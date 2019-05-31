package com.example.demo.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
