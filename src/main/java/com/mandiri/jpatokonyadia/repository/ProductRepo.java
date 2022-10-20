package com.mandiri.jpatokonyadia.repository;

import com.mandiri.jpatokonyadia.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, String >, JpaSpecificationExecutor<Product> {
//    public Optional<Product> findProductByNameAndShopId(String name,String shopId);

    public Page<Product> findAllByNameContainingAndDescriptionContainingAndPriceAndCreatedDateAndStock(String name, String description, BigDecimal price, Integer stock, Date createdDate, Pageable pageable);

//    public List<Product> findProductByShopId(String shopId);
}
