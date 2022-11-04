package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RequestMapping(path = "api/v2/customer")
@RestController
public class CustomerControllerV2 {

    private final CustomerService customerService;
    @Autowired
    public CustomerControllerV2(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    List<Customer> getCustomer(){
       return  customerService.getCustomer();
    }

    @GetMapping(path = "{customerId}")
    Customer getCustomerById(@PathVariable("customerId")Long id){
        return customerService.getCustomerById(id);
    }

    @PostMapping(value = "newCustomer")
    void createNewCustomer(@Valid @RequestBody Customer customer){
        System.out.println("post request");
        System.out.println(customer);
    }
    @PutMapping(path = "/updateCustomerName/{customerId}")
    Object[] updateNewCustomer(@PathVariable("customerId") Long id,@RequestBody Customer customer){
       return customerService.updateNewCustomer(id, customer.getName());
    }
    @DeleteMapping(path = "{customerId}")
    void deleteUser(@PathVariable("customerId")Long id){
        System.out.println("delete request to delete customer by id:"+id);
    }


}
