package me.projects.billingservice;

import me.projects.billingservice.entities.Order;
import me.projects.billingservice.entities.ProductItem;
import me.projects.billingservice.enums.OrderStatus;
import me.projects.billingservice.models.Customer;
import me.projects.billingservice.models.Product;
import me.projects.billingservice.repositories.OrderRepository;
import me.projects.billingservice.repositories.ProductItemRepository;
import me.projects.billingservice.services.CustomerRestClient;
import me.projects.billingservice.services.ProductRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(CustomerRestClient customerRestClient,
                                               ProductRestClient productRestClient,
                                               ProductItemRepository productItemRepository,
                                               OrderRepository billRepository) {
        return args -> {
            List<Customer> customers = customerRestClient.getCustomers();
            List<Product> products = productRestClient.getProducts();

            for (Customer customer : customers) {
                Order bill = new Order();
                bill.setCustomer(customer);
                bill.setCreated(new Date());
                bill.setCustomerId(customer.getId());
                bill.setOrderStatus(OrderStatus.CREATED);

                bill = billRepository.save(bill);

                List<ProductItem> productItems = new ArrayList<>();
                for (Product product : products) {
                    ProductItem productItem = new ProductItem();
                    productItem.setProductId(product.getId());
                    productItem.setOrder(bill);
                    productItem.setProduct(product);
                    productItem.setQuantity(1);
                    productItem.setDiscount(Math.random() * 100);
                    productItem.setPrice(Math.random() * 1000);
                    productItems.add(productItem);
                }
                productItemRepository.saveAll(productItems); // Now save all product items
            }
        };
    }
}
