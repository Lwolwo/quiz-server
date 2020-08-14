package com.thoughtworks.quizserver.service;

import com.thoughtworks.quizserver.domain.*;
import com.thoughtworks.quizserver.dto.*;
import com.thoughtworks.quizserver.repository.*;
import org.aspectj.weaver.ast.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;

    public List getProductList() {
        return productRepository.findAll();
    }

    public void addProductToOrder(int id) {
        ProductDto productDto = productRepository.findById(id).get();
        if (orderRepository.findByProdId(id).isPresent()) {
            OrderDto orderDto = orderRepository.findByProdId(id).get();
            orderDto.setQuantity(orderDto.getQuantity() + 1);
            orderRepository.save(orderDto);
            return;
        }

        OrderDto orderDto = OrderDto.builder()
                .name(productDto.getName())
                .price(productDto.getPrice())
                .quantity(1)
                .type(productDto.getType())
                .prodId(id)
                .build();
        orderRepository.save(orderDto);
    }

    public void addProductToProRepository(Product product) {
        ProductDto productDto = ProductDto.builder()
                .name(product.getName())
                .price(product.getPrice())
                .type(product.getType())
                .picUrl(product.getPicUrl())
                .build();
        productRepository.save(productDto);
    }
}
