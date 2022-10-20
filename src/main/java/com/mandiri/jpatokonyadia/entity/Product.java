package com.mandiri.jpatokonyadia.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mandiri.jpatokonyadia.controller.ProductRegisterFromDTO;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;
    private String name;
    private BigDecimal price;
    private String description;
    private Integer stock;
//    @Column(name = "shop_id")
//    private String shopId;
    @Column(name = "created_date")
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    /*@JsonIgnore*/
    private Store store;

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
    /*@JsonIgnore*/
    List<Order> orders = new ArrayList<>();

/*  //Cara Pertama Order Many to many
    @ManyToMany
    @JoinTable(name = "order_generated",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id"))
    List<Customer> customers  = new ArrayList<>();
*/

    public Product(){}

    public Product(ProductRegisterFromDTO productRegisterFromDTO) {
        this.id = productRegisterFromDTO.getId();
        this.name = productRegisterFromDTO.getName();
        this.price = productRegisterFromDTO.getPrice();
        this.description = productRegisterFromDTO.getDescription();
        this.stock = productRegisterFromDTO.getStock();
        this.createdDate = productRegisterFromDTO.getCreatedDate();
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

//    public String getShopId() {
//        return shopId;
//    }
//
//    public void setShopId(String shopId) {
//        this.shopId = shopId;
//    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
