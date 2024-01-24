package com.penny.service;

import com.penny.entity.Customer;

import java.util.List;

public interface CustomerService
{
    Customer add(Customer customer);

    List<Customer> getAll();

    Customer getById(long id);

    Customer getByEmail(String email);

    Customer update(long id, Customer customer);

    void deleteById(long id);
}
