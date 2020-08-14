package com.thoughtworks.quizserver.api;

import com.thoughtworks.quizserver.domain.*;
import com.thoughtworks.quizserver.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.*;

@CrossOrigin("http://localhost:3000")
@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/product")
    public ResponseEntity getProductList() {
        return ResponseEntity.ok(productService.getProductList());
    }

    @PostMapping("/product/{id}")
    public ResponseEntity addProductToOrder(@PathVariable int id) {
        productService.addProductToOrder(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/product")
    public ResponseEntity addProductToProRepository(@RequestBody Product product) {
        if (productService.isProductExist(product.getName())) {
            return ResponseEntity.badRequest().build();
        }
        productService.addProductToProRepository(product);
        return ResponseEntity.ok().build();
    }

}
