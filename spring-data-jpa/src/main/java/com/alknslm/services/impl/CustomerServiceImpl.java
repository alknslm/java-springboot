package com.alknslm.services.impl;

import com.alknslm.dto.DtoAddress;
import com.alknslm.dto.DtoCustomer;
import com.alknslm.entities.Address;
import com.alknslm.entities.Customer;
import com.alknslm.repository.CustomerRepository;
import com.alknslm.services.ICustomerService;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public DtoCustomer findCustomerById(Long id) {
        DtoCustomer dtoCustomer = new DtoCustomer();
        DtoAddress dtoAddress = new DtoAddress();

        Optional<Customer> optional = customerRepository.findById(id);
        if(optional.isEmpty()){
            return null;
        }

        Customer customer = optional.get();
        Address address = optional.get().getAddress();

        BeanUtils.copyProperties(customer,dtoCustomer);
        BeanUtils.copyProperties(address,dtoAddress);

        dtoCustomer.setAddress(dtoAddress);

        return dtoCustomer;
    }
}
