package com.alknslm.services.impl;

import com.alknslm.dto.DtoAddress;
import com.alknslm.dto.DtoCustomer;
import com.alknslm.entities.Address;
import com.alknslm.entities.Customer;
import com.alknslm.repository.AddressRepository;
import com.alknslm.repository.CustomerRepository;
import com.alknslm.services.IAddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements IAddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public DtoAddress findAddressById(Long id) {
        DtoAddress dtoAddress = new DtoAddress();
        DtoCustomer dtoCustomer = new DtoCustomer();

        Optional<Address> optional = addressRepository.findById(id);
        if(optional.isEmpty()){
            return null;
        }

        Address address = optional.get();
        Customer customer = optional.get().getCustomer();

        BeanUtils.copyProperties(address, dtoAddress);
        BeanUtils.copyProperties(customer, dtoCustomer);

//        dtoCustomer.setAddress(dtoAddress);
        dtoAddress.setCustomer(dtoCustomer);
        return dtoAddress;
    }
}
