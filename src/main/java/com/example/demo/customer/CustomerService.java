package com.example.demo.customer;

import com.example.demo.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CustomerService {
    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerService(@Qualifier("fake") CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    List<Customer> getCustomer() {
        return customerRepo.getCustomer();
    }
    Customer getCustomerById(Long id){
            return getCustomer()
                    .stream()
                    .filter(customer -> Objects.equals(customer.getId(), id))
                    .findFirst()
                    .orElseThrow(()->new NotFoundException("customer with id "+id+" not found"));
    }

    public Object[]  updateNewCustomer(Long id, String name) {
        System.out.println("put request sent");
        Customer customerNewNameData= getCustomerById(id);
        Customer customerOldNameData= getCustomerById(id);
        customerNewNameData.setName(name);
        return new Object[]{customerNewNameData,customerOldNameData};
    }
}
