package com.penny.controller;

import com.penny.entity.Customer;
import com.penny.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAll();
    }

    @GetMapping("{customerId}")
    public Customer getCustomer(@PathVariable("customerId") long customerId) {
        return customerService.getById(customerId);
    }

    @PostMapping
    public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer){
        customerService.add(customer);
        Customer savedCustomer = customerService.getByEmail(customer.getEmail());
        return  new ResponseEntity<Customer>(savedCustomer, HttpStatus.CREATED);
    }

    @PutMapping("{customerId}")
    public Customer updateCustomer(
            @PathVariable("customerId") long customerId,
            @RequestBody Customer customer) {
        return customerService.update(customerId, customer);
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") long customerId) {
        customerService.deleteById(customerId);
    }
}
