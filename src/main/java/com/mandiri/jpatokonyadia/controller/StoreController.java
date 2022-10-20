package com.mandiri.jpatokonyadia.controller;

import com.mandiri.jpatokonyadia.dto.CustomPage;
import com.mandiri.jpatokonyadia.entity.Store;
import com.mandiri.jpatokonyadia.service.ProductService;
import com.mandiri.jpatokonyadia.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StoreController {

    @Autowired
    StoreService storeService;
    @Autowired
    ProductService productService;

    @GetMapping("/store")
    public CustomPage<Store> getAllStore(@RequestParam(defaultValue = "1") Integer page,
                                         @RequestParam(defaultValue = "5") Integer size,
                                         @RequestParam(defaultValue = "") String name,
                                         @RequestParam(defaultValue = "") String address,
                                         @RequestParam(defaultValue = "") String phone){
        Pageable pageable = PageRequest.of(page-1,size);
        Page<Store> storePage = storeService.findAll(pageable, name, address, phone);
        CustomPage<Store> customPage =
                new CustomPage<>(storePage);
        return customPage;
    }

    @GetMapping("/store/{id}")
    public Store getById(@PathVariable String id){
        return storeService.getById(id);
    }

    @PostMapping("/store")
    public void createNewStore(@RequestBody Store store){
        storeService.createNew(store);
    }

    @PutMapping("/store")
    public void update(@RequestBody Store store){
        storeService.update(store);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable String id){
        storeService.deleteById(id);
    }
    @GetMapping("/store/search")
    public List<Store> searchStores(@RequestParam String query){
        return storeService.searchStores(query);
    }

}
