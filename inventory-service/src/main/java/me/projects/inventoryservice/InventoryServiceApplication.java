package me.projects.inventoryservice;

import me.projects.inventoryservice.entities.Product;
import me.projects.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            for (int i = 1; i <= 10; i++) {
                productRepository.save(Product.builder()
                        .name("Product " + i)
                        .quantity(i)
                        .price(i * 1000D)
                        .build());
            }
        };
    }
}
