package com.alknslm.controller;

import com.alknslm.dto.DtoAddress;

public interface IAddressController {
    public DtoAddress findAddressById(Long id);
}
