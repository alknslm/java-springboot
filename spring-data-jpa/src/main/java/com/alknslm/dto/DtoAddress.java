package com.alknslm.dto;

import com.alknslm.entities.Customer;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoAddress {

    private Long id;

    private String description;

    private DtoCustomer customer;
}
