package com.mandiri.jpatokonyadia.repository;

import com.mandiri.jpatokonyadia.dto.CustomersOrderDTO;
import com.mandiri.jpatokonyadia.entity.Customer;
import com.mandiri.jpatokonyadia.entity.Order;
import com.mandiri.jpatokonyadia.service.CustomerService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer, String> , JpaSpecificationExecutor<Customer>{

    @Query("SELECT new com.mandiri.jpatokonyadia.dto.CustomersOrderDTO(c.id, c.name, c.email, count(o.id))" +
            "FROM Customer c LEFT JOIN Order o " +
            "ON c.id = o.customer " +
            "GROUP BY c.id")
    public List<CustomersOrderDTO> getCustomerOrders();

    @Query(value = "SELECT * FROM customer where customer.email = ?", nativeQuery = true)
    public  List<Customer> findByEmail(String email);
}
