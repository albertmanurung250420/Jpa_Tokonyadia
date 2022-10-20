package com.mandiri.jpatokonyadia.service;

import com.mandiri.jpatokonyadia.dto.CustomersOrderDTO;
import com.mandiri.jpatokonyadia.dto.ProductSearchCriteria;
import com.mandiri.jpatokonyadia.entity.Customer;
import com.mandiri.jpatokonyadia.entity.Product;
import com.mandiri.jpatokonyadia.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CustomerService implements CRUDService<Customer, String> {
    @Autowired
    CustomerRepo customerRepo;
    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepo.findAll(pageable);
    }

    @Override
    public Customer getById(String id) {
        if(!customerRepo.findById(id).isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return customerRepo.findById(id).get();
    }

    @Override
    public void createNew(Customer customer) {
        customerRepo.save(customer);
    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void deleteById(String s) {

    }
    @Override
    public Page<Product> findAll(Pageable pageable, ProductSearchCriteria productSearchCriteria) {
        return null;
    }

    public List<CustomersOrderDTO> getCustomerOrderCount(){
        return customerRepo.getCustomerOrders();
    }

    public List<Customer> getAllCustomerByEmail(String email){
        return customerRepo.findByEmail(email);
    }
}
