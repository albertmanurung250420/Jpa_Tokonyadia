package com.mandiri.jpatokonyadia.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mandiri.jpatokonyadia.dto.Debit;
import com.mandiri.jpatokonyadia.dto.ProductSearchCriteria;
import com.mandiri.jpatokonyadia.entity.Customer;
import com.mandiri.jpatokonyadia.entity.Order;
import com.mandiri.jpatokonyadia.entity.Product;
import com.mandiri.jpatokonyadia.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

@Service
public class OrderService implements CRUDService<Order, String> {
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    ProductService productService;
    @Autowired
    CustomerService customerService;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    KafkaTemplate kafkaTemplate;
    @Autowired
    ObjectMapper objectMapper;


    @Override
    public Page<Order> findAll(Pageable pageable) {
        return orderRepo.findAll(pageable);
    }

    @Override
    public Page<Product> findAll(Pageable pageable, ProductSearchCriteria productSearchCriteria) {
        return null;
    }

    @Override
    public void createNew(Order order) {
//        Validasi
        Customer customer = customerService.getById(order.getCustomer().getId());
        customerService.getById(order.getCustomer().getId());
        Product product = productService.getById(order.getProduct().getId());
        product.setStock(product.getStock() - order.getQty());
        BigDecimal subTotal = product.getPrice().multiply(BigDecimal.valueOf(order.getQty()));
        Debit debit = new Debit(customer.getPhoneNumber(), order.getSubtotal());
        try {
            kafkaTemplate.send("gopal-debit",objectMapper.writeValueAsString(debit));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        // Pake HTTP  Rest
//        BigDecimal amount = product.getPrice().multiply(BigDecimal.valueOf(order.getQty()));
//
//        String url = "http://localhost:8081/wallet/debit";
//        Debit debit = new Debit(customer.getPhoneNumber(),amount.longValue());
//        restTemplate.put(url,debit);

        orderRepo.save(order);

    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public Order getById(String id) {
        if(!orderRepo.findById(id).isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return orderRepo.findById(id).get();
    }

    @Override
    public void update(Order order) {

    }
}
