package com.mandiri.jpatokonyadia.service;

import com.mandiri.jpatokonyadia.dto.ProductSearchCriteria;
import com.mandiri.jpatokonyadia.entity.Product;
import com.mandiri.jpatokonyadia.entity.Store;
import com.mandiri.jpatokonyadia.repository.StoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class StoreService implements CRUDService<Store,Integer>{

    @Autowired
    StoreRepo storeRepo;


    public Page<Store> findAll(Pageable pageable, String name, String address, String phone) {
        return storeRepo.findAllByNameContainingAndAddressContainingAndPhoneContaining(name,address,phone,pageable);
    }

    @Override
    public Page<Store> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Page<Product> findAll(Pageable pageable, ProductSearchCriteria productSearchCriteria) {
        return null;
    }

    @Override
    public Store getById(String id) {
            if(!storeRepo.findById(id).isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return storeRepo.findById(id).get();
    }

    @Override
    public void createNew(Store store) {
        store.getProducts().stream().forEach(product -> {product.setStore(store);});
        storeRepo.save(store);
    }

    @Override
    public void update(Store store) {
        storeRepo.save(store);
    }

    @Override
    public void deleteById(String s) {
        Store  store = getById(s);
        store.getProducts().stream().forEach(product -> {product.setStore(null);});
        storeRepo.deleteById(s);
    }

    public List<Store> searchStores(String query){
//        return storeRepo.searchStores(query);
        return  null;
    }


}
