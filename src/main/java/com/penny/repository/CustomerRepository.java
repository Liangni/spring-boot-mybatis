package com.penny.repository;

import com.penny.entity.Customer;
import org.apache.ibatis.annotations.*;
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

    @Update("UPDATE customer SET name = #{name}, " +
            " email = #{email}, age = #{age} WHERE id=#{id}"
    )
    void update(long id, String name, String email, int age);

    @Delete("DELETE FROM customer WHERE id = #{id}")
    boolean deleteById(long id);
}
