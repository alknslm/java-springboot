package com.alknslm.services;

import com.alknslm.dto.DtoCustomer;

public interface ICustomerService {

    public DtoCustomer findCustomerById(Long id);
}
