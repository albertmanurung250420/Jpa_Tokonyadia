package com.mandiri.jpatokonyadia.service;

import com.mandiri.jpatokonyadia.controller.ProductRegisterFromDTO;
import com.mandiri.jpatokonyadia.dto.ProductSearchCriteria;
import com.mandiri.jpatokonyadia.entity.Product;
import com.mandiri.jpatokonyadia.entity.Store;
import com.mandiri.jpatokonyadia.repository.ProductRepo;
import com.mandiri.jpatokonyadia.repository.StoreRepo;
import com.mandiri.jpatokonyadia.spesification.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductService implements CRUDService<Product,String>  {
    @Autowired
    ProductRepo productRepo;
    @Autowired
    StoreService storeService;
    @Autowired
    StoreRepo storeRepo;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Page<Product> findAll(Pageable pageable, ProductSearchCriteria productSearchCriteria) {
        Specification<Product> specification = ProductSpecification.getSpecification(productSearchCriteria);
        return productRepo.findAll(specification, pageable);

    }
    @Override
    public Product getById(String id) {
        if(!productRepo.findById(id).isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return productRepo.findById(id).get();
    }

    @Override
    public void createNew(Product product) {
        storeService.getById(product.getStore().getId());
//        if (storeRepo.findById(product.getShopId()).isPresent()){
//            productRepo.save(product);
//        }else {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        }
//        /*Optional<Product> optionalProduct = productRepo.findProductByNameAndShopId(product.getName(),product.getShopId());
//        if (optionalProduct.isPresent()){
//            throw new ResponseStatusException(HttpStatus.CONFLICT);
//        }
        productRepo.save(product);
    }

    public void createNew(ProductRegisterFromDTO productRegisterFromDTO){
        Product product = new Product(productRegisterFromDTO);
        Store store = storeService.getById(productRegisterFromDTO.getStoreId());
        product.setStore(store);
        productRepo.save(product);
    }

    @Override
    public void update(Product product) {
        getById(product.getId());
        productRepo.save(product);
    }
    @Override
    public void deleteById(String s) {
    }

    public List<Product> getAllProductsInStore(String shopId) {
            return null;
//        return this.productRepo.findProductByShopId(shopId);
    }
}
