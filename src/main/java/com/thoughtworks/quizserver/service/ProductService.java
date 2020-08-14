package com.thoughtworks.quizserver.service;

import com.thoughtworks.quizserver.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List getProductList() {
        return productRepository.findAll();
    }
}
