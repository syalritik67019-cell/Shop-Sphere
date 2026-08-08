package com.API.Shop.Sphere.Service;

import com.API.Shop.Sphere.Exceptions.ResourceNotFound;
import com.API.Shop.Sphere.Model.Products;
import com.API.Shop.Sphere.Repository.Product.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class Productservice {
     @Autowired
    ProductRepo repo;
    public List<Products> getAll(){
    return repo.findAll();

    }

    public Products create(Products prod) {
        return repo.save(prod);
    }

    public Products update(Integer id ,Products prod) {
        Products Exist = repo.findById(id)
                .orElseThrow(()->
                        new ResourceNotFound("Product with id " + id + " not found "));

            prod.setId(Exist.getId());
            return repo.save(prod);

    }

    public void  delete(Integer id) {
        if (!repo.existsById(id)) {
            throw  new ResourceNotFound("Product with id " + id + " not found ");
        }
        repo.deleteById(id);
    }
    public Products getByID(Integer id) {
      return repo.findById(id)
              .orElseThrow(() ->
                    new ResourceNotFound("Product with id " + id + " not found "));
    }

    public List<Products> getbyname(String name) {
        List<Products> namecheck = repo.findByname(name);
        if(namecheck.isEmpty()){
            throw new ResourceNotFound("Product with this name " + name + " not found");
        }
        return repo.findByname(name);
    }
}
