package com.penny.service;

import com.penny.exception.ResourceDuplicateException;
import com.penny.exception.ResourceNotFoundException;
import com.penny.model.Customer;
import com.penny.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getById(long id) {
        return Optional.ofNullable(customerRepository.findById(id)).orElseThrow(
                () -> new ResourceNotFoundException("Customer with id [%s] not found".formatted(id))
        );
    }

    @Override
    public Customer add(Customer customer) {
        String email = customer.getEmail();
        Customer found = getByEmail(email);
        if (found != null) throw new ResourceDuplicateException("Email [%s] is duplicated".formatted(email));
        customerRepository.insert(customer);
        return getByEmail(email);
    }

    @Override
    public Customer getByEmail(String email) {
        return customerRepository.findByEmail(email);
    }
}
