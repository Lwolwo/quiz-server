package com.thoughtworks.quizserver.repository;

import com.thoughtworks.quizserver.dto.*;
import jdk.nashorn.internal.runtime.options.*;
import org.springframework.data.repository.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

public interface ProductRepository extends CrudRepository<ProductDto, Integer> {
    List<ProductDto> findAll();
    Optional<ProductDto> findByName(String name);

}