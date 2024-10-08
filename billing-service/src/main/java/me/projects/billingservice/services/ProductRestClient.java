package me.projects.billingservice.services;

import me.projects.billingservice.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "inventory-service")
public interface ProductRestClient {

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable Long id);

    @GetMapping("/products")
    public List<Product> getProducts();
}
