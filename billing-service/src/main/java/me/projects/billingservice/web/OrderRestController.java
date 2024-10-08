package me.projects.billingservice.web;

import lombok.AllArgsConstructor;
import me.projects.billingservice.dtos.OrderDTO;
import me.projects.billingservice.entities.Order;
import me.projects.billingservice.mappers.BillMapper;
import me.projects.billingservice.models.Customer;
import me.projects.billingservice.models.Product;
import me.projects.billingservice.repositories.OrderRepository;
import me.projects.billingservice.services.CustomerRestClient;
import me.projects.billingservice.services.ProductRestClient;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class OrderRestController {
    private OrderRepository orderRepository;
    private BillMapper billMapper;
    private CustomerRestClient customerRestClient;
    private ProductRestClient productRestClient;

    @GetMapping("/orders/{id}")
    public OrderDTO getOrder(@PathVariable Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));

        // Optionally fetch the customer and products from external services
        Customer customer = customerRestClient.getCustomerById(order.getCustomerId());
        order.setCustomer(customer);

        order.getProductItems().forEach(productItem -> {
            Product product = productRestClient.getProduct(productItem.getProductId());
            productItem.setProduct(product);
        });

        // Map entity to DTO and return
        return billMapper.fromOrder(order);
    }
}
