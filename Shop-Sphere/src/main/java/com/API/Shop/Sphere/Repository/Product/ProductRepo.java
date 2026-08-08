package com.API.Shop.Sphere.Repository.Product;

import com.API.Shop.Sphere.Model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface ProductRepo extends JpaRepository<Products , Integer> {

   List< Products >findByname(String name);

}
