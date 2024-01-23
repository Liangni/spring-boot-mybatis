package com.penny.service;

import com.penny.model.Customer;

import java.util.List;

public interface CustomerService
{
    Customer add(Customer customer);

    List<Customer> getAll();

    Customer getById(long id);

    Customer getByEmail(String email);
}
