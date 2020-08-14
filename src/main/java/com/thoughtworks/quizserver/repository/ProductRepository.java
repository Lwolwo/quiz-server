package com.thoughtworks.quizserver.repository;

import com.thoughtworks.quizserver.dto.*;
import org.springframework.data.repository.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

public interface ProductRepository extends CrudRepository<ProductDto, Integer> {
    List<ProductDto> findAll();
}