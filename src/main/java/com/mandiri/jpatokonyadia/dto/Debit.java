package com.mandiri.jpatokonyadia.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Debit {
    private String phoneNumber;
    private Long amount;
}
