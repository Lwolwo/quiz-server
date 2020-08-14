package com.thoughtworks.quizserver.service;

import com.thoughtworks.quizserver.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List getOrderList() {
        return orderRepository.findAll();
    }

    public void deleteOrderById(int id) {
        orderRepository.deleteById(id);
    }

    public boolean isOrderExist(int id) {
        return orderRepository.findById(id).isPresent();
    }
}
