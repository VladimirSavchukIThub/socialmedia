package com.example.socialmedia.Controllers;

import com.example.socialmedia.dal.DataAccessLayer;
import com.example.socialmedia.models.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/unauthorized")
public class MainController {
    private final DataAccessLayer dataAccessLayer;
    @Autowired
    public MainController(DataAccessLayer dataAccessLayer) {
        this.dataAccessLayer = dataAccessLayer;
    }


    @PostMapping("create/order/")
    public ResponseEntity<String> createOrder(@RequestBody Orders orders) {
        dataAccessLayer.createOrder(orders);
        return ResponseEntity.ok("Created!");
    }


    @GetMapping("/get/product/{id}")
    public ResponseEntity getProductById(@PathVariable("id") long id){
        return ResponseEntity.ok(dataAccessLayer.getProduct(id));
    }
    @GetMapping("/get/products")
    public ResponseEntity getProducts(){
        return ResponseEntity.ok(dataAccessLayer.getProducts());
    }
    @GetMapping("/get/order/{id}")
    public  ResponseEntity getOrderById(@PathVariable("id") long id){
        return ResponseEntity.ok(dataAccessLayer.getOrder(id));
    }
    @GetMapping("/get/orders")
    public  ResponseEntity getOrders(){
        return ResponseEntity.ok(dataAccessLayer.getOrders());
    }
    @GetMapping("/get/detail/{id}")
    public ResponseEntity getDetailById(@PathVariable("id") long id){
        return ResponseEntity.ok(dataAccessLayer.getDetail(id));
    }
    @GetMapping("/get/details")
    public ResponseEntity getDetails(){
        return ResponseEntity.ok(dataAccessLayer.getDetails());
    }
    @GetMapping("/get/category/{id}")
    public ResponseEntity getCategoryById(@PathVariable("id") long id){
        return ResponseEntity.ok(dataAccessLayer.getCategory(id));
    }
    @GetMapping("/get/categories")
    public ResponseEntity getCategories(){
        return ResponseEntity.ok(dataAccessLayer.getCategory());
    }
    @GetMapping("/get/review/{id}")
    public ResponseEntity getReviewById(@PathVariable("id") long id){
        return ResponseEntity.ok(dataAccessLayer.getReview(id));
    }
    @GetMapping("/get/reviews")
    public ResponseEntity getReviews(){
        return ResponseEntity.ok(dataAccessLayer.getReviews());
    }
    @GetMapping("/get/user/{id}")
    public ResponseEntity getUserById(@PathVariable("id") long id){
        return ResponseEntity.ok(dataAccessLayer.getUser(id));
    }
    @GetMapping("/get/users")
    public ResponseEntity getUsers(){
        return ResponseEntity.ok(dataAccessLayer.getUsers());
    }
}
