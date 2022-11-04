package com.example.demo.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.*;

public class Customer {
        private final Long id;
        @NotBlank(message = "name must be 5 characters long")
        @Size(min = 5)
        private  String name;
        @NotBlank
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        private final String password;
        @NotBlank(message = "email not valid")
        @Email
        private final String email;

        Customer(Long id, String name, String password, String email) {
            this.id = id;
            this.name = name;
            this.password = password;
            this.email = email;
        }
        @JsonProperty("customer_id")
        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
        public String getPassword() {return password;}

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
