package com.thoughtworks.quizserver.repository;

import com.thoughtworks.quizserver.dto.*;
import org.springframework.data.repository.*;

import java.util.*;

public interface OrderRepository extends CrudRepository<OrderDto, Integer> {
    List<OrderDto> findAll();
    Optional<OrderDto> findByProdId(int id);

    void deleteById(int id);
}
