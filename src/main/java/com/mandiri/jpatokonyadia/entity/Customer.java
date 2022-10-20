package com.mandiri.jpatokonyadia.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer")
@Getter @Setter @NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;
    @NotNull
    private String name;
    @NotNull
    @Column(name = "birth_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birth;
    private String email;
    private String phoneNumber;
    private String address;
    @NotNull
    private String gender;

/*  Cara Pertana many to many
    @ManyToMany
    @JoinTable(name = "order_generated",
                joinColumns = @JoinColumn(name = "product_id"),
                inverseJoinColumns = @JoinColumn(name = "customer_id"))
    List<Product> products = new ArrayList<>();*/


    public Customer(String id, String name, Date birth, String email, String phoneNumber, String address, String gender) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.gender = gender;
    }
}
