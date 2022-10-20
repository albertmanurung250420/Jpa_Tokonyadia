package com.mandiri.jpatokonyadia.controller;

import com.mandiri.jpatokonyadia.dto.CustomPage;
import com.mandiri.jpatokonyadia.entity.Order;
import com.mandiri.jpatokonyadia.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/order")
    public CustomPage<Order> getAllOrder(@RequestParam(defaultValue = "1") Integer page,
                                         @RequestParam(defaultValue = "5") Integer size){
        Pageable pageable = PageRequest.of(page-1,size);
        Page<Order> orderPage = orderService.findAll(pageable);
        CustomPage<Order> customPage = new CustomPage<>(orderPage);
        return customPage;
    }

    @PostMapping("/orders")
    public void createNewOrder(@RequestBody Order order){
        orderService.createNew(order);
    }

}
