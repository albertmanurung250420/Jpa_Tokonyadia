package com.mandiri.jpatokonyadia.controller;

import com.mandiri.jpatokonyadia.dto.CustomPage;
import com.mandiri.jpatokonyadia.dto.CustomersOrderDTO;
import com.mandiri.jpatokonyadia.entity.Customer;
import com.mandiri.jpatokonyadia.entity.Store;
import com.mandiri.jpatokonyadia.service.CustomerService;
import com.mandiri.jpatokonyadia.service.FilterStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @Autowired
    FilterStorageService fileStorageService;

    @GetMapping("/customers")
    public CustomPage<Customer> getAllStore(@RequestParam(defaultValue = "1") Integer page,
                                         @RequestParam(defaultValue = "5") Integer size){
        Pageable pageable = PageRequest.of(page-1,size);
        Page<Customer> customerPage = customerService.findAll(pageable);
        CustomPage<Customer> customPage = new CustomPage<>(customerPage);
        return customPage;
    }

    @PostMapping("/customer")
    public void createNewCustomer(@RequestBody Customer customer){
        customerService.createNew(customer);
    }

    @GetMapping("/customer/ordersCount")
    public List<CustomersOrderDTO> getCustomersOrderCount(){
        return customerService.getCustomerOrderCount();
    }

    @GetMapping("/email/{email}")
    public List<Customer> getAllCustomerByEmail(@PathVariable String email){
        return customerService.getAllCustomerByEmail(email);
    }

    @PostMapping("/image")
    public void uploadNewImage(@RequestPart(name = "uploadImage") MultipartFile multipartFile) throws IOException {
        fileStorageService.saveImage(multipartFile);
    }
}
