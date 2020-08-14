package com.thoughtworks.quizserver.api;

import com.thoughtworks.quizserver.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.*;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/product")
    public ResponseEntity getProductList() {
        return ResponseEntity.ok(productService.getProductList());
    }

}
