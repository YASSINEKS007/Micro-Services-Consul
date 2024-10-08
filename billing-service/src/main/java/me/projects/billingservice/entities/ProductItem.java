package me.projects.billingservice.entities;

import jakarta.persistence.*;
import lombok.*;
import me.projects.billingservice.models.Product;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class ProductItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private Double price;
    private Integer quantity;
    private Double discount;
    @Transient
    private Product product;
    @ManyToOne
    private Order order;
}
