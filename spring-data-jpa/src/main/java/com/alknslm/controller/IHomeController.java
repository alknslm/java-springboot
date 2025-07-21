package com.alknslm.controller;

import com.alknslm.dto.DtoHome;

public interface IHomeController {

    public DtoHome findHomeById(Long id);
}
