package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping(path = "api/v1/customer")
@RestController
@Deprecated 
public class CustomerController  {

    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping(value = "getallcustomers")
    List<Customer> getCustomer(){
       return  customerService.getCustomer();
    }
    @PostMapping(value = "newcustomer")
    void createNewCustomer(@RequestBody  Customer customer){
        System.out.println("post request");
        System.out.println(customer);
    }
    @PutMapping(value = "updatecustomer")
    void updateNewCustomer(@RequestBody  Customer customer){
        System.out.println("update request");
        System.out.println(customer);
    }
    @DeleteMapping(path = "{customerId}")
    void deleteUser(@PathVariable("customerId")Long id){
        System.out.println("delete request to delete customer by id:"+id);
    }


}
