package com.penny.repository;

import com.penny.model.Customer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface CustomerRepository {
    @Select("SELECT * FROM customer")
    List<Customer> findAll();

    @Select("SELECT * FROM customer WHERE id = #{id}")
    Customer findById(long id);

    @Insert("INSERT INTO customer(name, email, age) " +
            " VALUES (#{name}, #{email}, #{age})")
    void insert (Customer customer);

    @Select("SELECT * FROM customer WHERE email = #{email}")
    Customer findByEmail(String email);
}
