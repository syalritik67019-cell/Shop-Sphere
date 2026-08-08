package com.API.Shop.Sphere.Controller;

import com.API.Shop.Sphere.Model.Products;
import com.API.Shop.Sphere.Service.Productservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Productcontroller {

    @Autowired
    Productservice service;

    @GetMapping("/products")
    public ResponseEntity<List<Products>> getAll() {
      List <Products> products = service.getAll();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Products> getByID(@PathVariable Integer id) {
        Products products = service.getByID(id);
       // if(products != null) {
            return ResponseEntity.ok(products);
   // }else {
       //      return ResponseEntity.notFound().build();
        //}
    }

    @GetMapping("/products/name/{name}")
    public ResponseEntity<List<Products>> getbyname(@PathVariable  String name){
      List <Products> getbyn = service.getbyname(name);
      //  if(getbyn.isEmpty()){
      //      return ResponseEntity.notFound().build();
      //  }else{
           return ResponseEntity.ok(getbyn);
     //   }
    }

    @PostMapping("/products")
    public ResponseEntity<Products> create(@Valid @RequestBody Products prod) {
        Products saved = service.create(prod);
        if(saved != null){
            return new ResponseEntity<>(saved,HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Products> update( @PathVariable Integer id ,@Valid @RequestBody  Products prod) {
        Products modified = service.update(id,prod);
    //    if(modified != null){
            return new ResponseEntity<>(modified ,HttpStatus.OK);
     //   }else{
       //     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      //  }
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity <Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return  ResponseEntity.noContent().build();


    }
}
