package com.alknslm.dto;

import com.alknslm.entities.Address;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL) // null setlenen değerleri dönmme
public class DtoCustomer {

    private Long id;

    private String name;

    private DtoAddress address;
}
