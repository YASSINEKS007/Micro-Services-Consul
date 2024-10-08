package me.projects.billingservice.services;

import me.projects.billingservice.models.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "customer-service")
public interface CustomerRestClient {
    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable Long id);

    @GetMapping("/customers")
    public List<Customer> getCustomers();
}
