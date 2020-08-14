package com.thoughtworks.quizserver.api;

import com.thoughtworks.quizserver.repository.*;
import com.thoughtworks.quizserver.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/order")
    public ResponseEntity getOrderList() {
        return ResponseEntity.ok(orderService.getOrderList());
    }

    @DeleteMapping("/order/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        if (orderService.isOrderExist(id)) {
            orderService.deleteOrderById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

}
