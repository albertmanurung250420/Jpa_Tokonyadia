package com.mandiri.jpatokonyadia.repository;

import com.mandiri.jpatokonyadia.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrderRepo extends JpaRepository<Order, String>, JpaSpecificationExecutor<Order> {
}
