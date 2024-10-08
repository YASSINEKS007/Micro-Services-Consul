package me.projects.inventoryservice.repositories;

import me.projects.inventoryservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;

@Repository
//@RepositoryRestController
public interface ProductRepository extends JpaRepository<Product, Long> {
}
