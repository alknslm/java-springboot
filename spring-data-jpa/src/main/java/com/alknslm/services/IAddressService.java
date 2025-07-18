package com.alknslm.services;

import com.alknslm.dto.DtoAddress;

public interface IAddressService {

    public DtoAddress findAddressById(Long id);
}
