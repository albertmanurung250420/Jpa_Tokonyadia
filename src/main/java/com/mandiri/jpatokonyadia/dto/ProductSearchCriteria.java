package com.mandiri.jpatokonyadia.dto;

import java.math.BigDecimal;
import java.sql.Date;

public class ProductSearchCriteria {
    private final String name;
    private final String description;
    private final BigDecimal price;
    private final Integer stock;

    /*private final Date createdDate;*/
    private final Date startDate;
    private final Date endDate;

    public ProductSearchCriteria(String name, String description, BigDecimal price, Integer stock, Date startDate, Date endDate) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.startDate = startDate;
        this.endDate = endDate;
        /*this.createdDate = createdDate;*/
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getStock() {
        return stock;
    }
/*
    public Date getCreatedDate() {
        return createdDate;
    }*/

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
