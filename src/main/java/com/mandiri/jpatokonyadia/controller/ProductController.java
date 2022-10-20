package com.mandiri.jpatokonyadia.controller;

import com.mandiri.jpatokonyadia.dto.ProductSearchCriteria;
import com.mandiri.jpatokonyadia.entity.Product;
import com.mandiri.jpatokonyadia.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/product")
    public Page<Product> getAllStore(@RequestParam(defaultValue = "0") Integer page,
                                   @RequestParam(defaultValue = "5") Integer size,
                                   @RequestParam(required = false) String name,
                                   @RequestParam(required = false) String description,
                                   @RequestParam(required = false) BigDecimal price,
                                   @RequestParam(required = false) Integer stock,
                                   /*@RequestParam(required = false) Date createdDate*/
                                   @RequestParam(required = false) Date startDate,
                                   @RequestParam(required = false) Date endDate
                                     ){
        Pageable pageable = PageRequest.of(page,size);
        return productService.findAll(pageable, new ProductSearchCriteria(name, description, price, stock, startDate, endDate));
    }

    @GetMapping("/product/{id}")
    public Product getById(@PathVariable String id){
        return productService.getById(id);
    }

    @PostMapping("/product")
    public void createNewProduct(@Valid @RequestBody ProductRegisterFromDTO productForm){
        productService.createNew(productForm);
    }

    @PutMapping("/product")
    public void update(@RequestBody Product product){
        productService.update(product);
    }

    @DeleteMapping("/product/{id}")
    public void deleteById(@RequestParam String id){
        productService.deleteById(id);
    }

    @GetMapping("/product/search")
    public List<Product> searchProducts(@RequestParam String query){
        return null;
    }
}
