package me.projects.billingservice.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class Product {
    private Long id;
    private String name;
    private Double price;
    private Integer quantity;
}
