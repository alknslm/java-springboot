package com.alknslm.controller;

import com.alknslm.dto.DtoCustomer;

public interface ICustomerContoller {

    public DtoCustomer findCustomerById(Long id);
}
