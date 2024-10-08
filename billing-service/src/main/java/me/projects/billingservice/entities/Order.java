package me.projects.billingservice.entities;

import jakarta.persistence.*;
import lombok.*;
import me.projects.billingservice.enums.OrderStatus;
import me.projects.billingservice.models.Customer;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Builder @ToString
@Table(name = "order_table")

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date created;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    private Long customerId;
    @Transient
    private Customer customer;
    @OneToMany(mappedBy = "order")
    private List<ProductItem> productItems;
}
