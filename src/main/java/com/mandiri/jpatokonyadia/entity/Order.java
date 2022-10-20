package com.mandiri.jpatokonyadia.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "orders")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;
    @ManyToOne()
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;
    private Long subtotal;
    private Integer qty;
    @Column(name = "order_time")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Jakarta")
    @CreationTimestamp
    private Timestamp order_time;

}
