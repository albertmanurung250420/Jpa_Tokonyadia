package com.mandiri.jpatokonyadia.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class CustomersOrderDTO {

    private String id;
    private String customerName;
    private String email;
    private Long orders;
}
