package com.mandiri.jpatokonyadia.controller;

import com.mandiri.jpatokonyadia.entity.Product;
import com.mandiri.jpatokonyadia.entity.Store;
import com.mandiri.jpatokonyadia.service.ProductService;
import com.mandiri.jpatokonyadia.service.StoreProductService;
import com.mandiri.jpatokonyadia.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StoreControllerProduct {

    @Autowired
    StoreProductService storeProductService;

    @Autowired
    ProductService productService;
    @Autowired
    StoreService storeService;

    @GetMapping("/store/{id}/products")
    public List<Product> getByIdProduct(@PathVariable String id){
        Store store = storeService.getById(id);
        List<Product> products = store.getProducts();
        return products;
    }

    /*@GetMapping("/store/{shopId}/products")
    public List<Product> getAllProductsInStore(@PathVariable String shopId,
                                               @RequestParam(defaultValue = "0") Integer page,
                                               @RequestParam(defaultValue = "3") Integer size){
        Pageable pageable = PageRequest.of(page,size);
        return productService.getAllProductsInStore(shopId);
    }*/
}
