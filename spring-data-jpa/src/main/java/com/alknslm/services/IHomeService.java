package com.alknslm.services;

import com.alknslm.dto.DtoHome;

public interface IHomeService {

    public DtoHome findHomeById(Long id);
}
