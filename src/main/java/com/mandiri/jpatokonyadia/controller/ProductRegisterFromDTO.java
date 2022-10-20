package com.mandiri.jpatokonyadia.controller;

import com.mandiri.jpatokonyadia.entity.Store;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Date;

public class ProductRegisterFromDTO {

    private String id;
    private String name;
    private BigDecimal price;
    private String description;
    private Integer stock;
    private Date createdDate;
    private String storeId;

    public ProductRegisterFromDTO(String id, String name, BigDecimal price, String description, Integer stock, Date createdDate, String storeId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.stock = stock;
        this.createdDate = createdDate;
        this.storeId = storeId;
    }

    public ProductRegisterFromDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }
}
