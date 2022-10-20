package com.mandiri.jpatokonyadia.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "mst_store")
public class Store {

    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;

    @Column(name = "siup", nullable = false)
    private String siup;
    private String name;
    private String address;
    private String phone;
    @Column(nullable = false)
    private String npwp;


    @OneToMany(mappedBy = "store"/*, cascade = {CascadeType.PERSIST, CascadeType.REMOVE}*/, orphanRemoval = false)
    @JsonIgnore
    List<Product> products = new ArrayList<>();

    public Store(String id, String siup, String name, String address, String phone, String npwp) {
        this.id = id;
        this.siup = siup;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.npwp = npwp;
    }

    public Store(){}

    public String  getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSiup() {
        return siup;
    }

    public void setSiup(String siup) {
        this.siup = siup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNpwp() {
        return npwp;
    }

    public void setNpwp(String npwp) {
        this.npwp = npwp;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}


