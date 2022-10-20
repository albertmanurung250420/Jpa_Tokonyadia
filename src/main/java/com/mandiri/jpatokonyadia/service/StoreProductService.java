package com.mandiri.jpatokonyadia.service;


import com.mandiri.jpatokonyadia.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreProductService {

    @Autowired
    ProductService productService;
    @Autowired
    StoreService storeService;

    public List<Product> getAllProductByStoreId(String shopId){
        storeService.getById(shopId);
        return productService.getAllProductsInStore(shopId);
    }
}
