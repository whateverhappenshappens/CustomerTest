package com.example.demo.customer;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository(value = "fake")
@Primary
public class CustomerFakeRepository implements CustomerRepo{

    @Override
    public List<Customer> getCustomer() {
        return Arrays.asList(
                new Customer(1L,"james", "password789", "email@gmail.com"),
                new Customer(2L,"help", "password890", "email@gmail.com")
        );
    }

//    @Override
//    public Customer getCustomerById(Long id) {
//        return getCustomer()
//                .stream()
//                .filter(customer -> Objects.equals(customer.getId(), id))
//                .findFirst()
//                .orElseThrow(()->new IllegalStateException("customer not found"));
}
