package me.projects.inventoryservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "fullProduct", types = Product.class)
public interface ProductProjection {
    Long getId();

    Double getPrice();

    Integer getQuantity();

    String getName();
}
