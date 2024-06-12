package com.example.socialmedia.Controllers;

import com.example.socialmedia.dal.DataAccessLayer;
import com.example.socialmedia.models.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/authorized")
public class AdminController {
    private final DataAccessLayer dataAccessLayer;
    @Autowired
    public AdminController(DataAccessLayer dataAccessLayer) {
        this.dataAccessLayer = dataAccessLayer;
    }

    @PostMapping("create/product/")
    public ResponseEntity<String> createProduct(@RequestBody Products products) {
        dataAccessLayer.createProduct(products);
        return ResponseEntity.ok("Created!");
    }

    @DeleteMapping("delete/product/{id}")
    public ResponseEntity deleteProductById(@PathVariable("id") long id) {
        dataAccessLayer.deleteProduct(id);
        return ResponseEntity.ok("Deleted!");
    }

    @PostMapping("update/product/{id}")
    public ResponseEntity updateProductById(@PathVariable("id") long id, @RequestBody Products newProduct) {
        dataAccessLayer.updateProduct(id, newProduct);
        return ResponseEntity.ok("Updated!");
    }
//    @PostMapping("create/order/")
//    public ResponseEntity<String> createOrder(@RequestBody Orders orders) {
//        dataAccessLayer.createOrder(orders);
//        return ResponseEntity.ok("Created!");
//    }
    @DeleteMapping("delete/order/{id}")
    public ResponseEntity deleteOrderById(@PathVariable("id") long id) {
        dataAccessLayer.deleteOrder(id);
        return ResponseEntity.ok("Deleted:  "+ id);
    }
    @PostMapping("update/order/{id}")
    public ResponseEntity updateOrderById(@PathVariable("id") long id, @RequestBody Orders updateOrder) {
        dataAccessLayer.updateOrder(id, updateOrder);
        return ResponseEntity.ok("Updated!");
    }
    @PostMapping("create/detail/")
    public ResponseEntity<String> createDetail(@RequestBody OrderDetails orderDetails) {
        dataAccessLayer.createDetail(orderDetails);
        return ResponseEntity.ok("Created!");
    }
    @DeleteMapping("delete/detail/{id}")
    public ResponseEntity deleteDetailById(@PathVariable("id") long id) {
        dataAccessLayer.deleteDetails(id);
        return ResponseEntity.ok("Deleted: "+ id);
    }
    @PostMapping("update/detail/{id}")
    public ResponseEntity updateDetailById(@PathVariable("id") long id, @RequestBody OrderDetails updateDetails) {
        dataAccessLayer.updateDetails(id, updateDetails);
        return ResponseEntity.ok("Updated!");
    }
    @PostMapping("create/category/")
    public ResponseEntity<String> createCategory(@RequestBody Categories categories) {
        dataAccessLayer.createCategory(categories);

        return ResponseEntity.ok("Created!");

    }
    @DeleteMapping("delete/category/{id}")
    public ResponseEntity deleteCategoryById(@PathVariable("id") long id) {
        dataAccessLayer.deleteCategory(id);
        return ResponseEntity.ok("Deleted: "+ id);
    }
    @PostMapping("update/category/{id}")
    public ResponseEntity updateCategoryById(@PathVariable("id") long id, @RequestBody Categories categories) {
        dataAccessLayer.updateCategory(id, categories);
        return ResponseEntity.ok("Updated!");
    }
    @PostMapping("create/review/")
    public ResponseEntity<String> createReview(@RequestBody Reviews reviews) {
        dataAccessLayer.createReview(reviews);
        return ResponseEntity.ok("Created!");
    }
    @DeleteMapping("delete/review/{id}")
    public ResponseEntity deleteReviewById(@PathVariable("id") long id) {
        dataAccessLayer.deleteReview(id);
        return ResponseEntity.ok("Deleted: "+ id);
    }
    @PostMapping("update/review/{id}")
    public ResponseEntity updateReviewById(@PathVariable("id") long id, @RequestBody Reviews reviews) {
        dataAccessLayer.updateReview(id, reviews);
        return ResponseEntity.ok("Updated!");
    }
    @PostMapping("create/user/")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        dataAccessLayer.createUser(user);
        return ResponseEntity.ok("Created!");
    }
    @DeleteMapping("delete/user/{id}")
    public ResponseEntity deleteRUserById(@PathVariable("id") long id) {
        dataAccessLayer.deleteUser(id);
        return ResponseEntity.ok("Deleted: "+ id);
    }
    @PostMapping("update/user/{id}")
    public ResponseEntity updateUserById(@PathVariable("id") long id, @RequestBody User user) {
        dataAccessLayer.updateUser(id, user);
        return ResponseEntity.ok("Updated!");
    }

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
    public void someMethod() {
        logger.debug("Debug message");
        logger.info("Info message");
        logger.warn("Warning message");
        logger.error("Error message");
    }
}
