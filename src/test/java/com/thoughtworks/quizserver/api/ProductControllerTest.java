package com.thoughtworks.quizserver.api;

import com.thoughtworks.quizserver.domain.*;
import com.thoughtworks.quizserver.domain.Order;
import com.thoughtworks.quizserver.dto.*;
import com.thoughtworks.quizserver.repository.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.context.*;
import org.springframework.test.web.servlet.*;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasKey;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderRepository orderRepository;

    @Test
    public void shouldGetProductList() throws Exception {
        ProductDto productDto = ProductDto.builder()
                .name("可乐")
                .price(1)
                .type("1")
                .picUrl("")
                .build();
        productRepository.save(productDto);

        mockMvc
                .perform(get("/product"))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is("可乐")))
                .andExpect(jsonPath("$[0].type", is("1")))
                .andExpect(jsonPath("$[0].picUrl", is("")))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldSaveProduct() throws Exception {
        OrderDto orderDto = OrderDto.builder().name("1").price(1).quantity(1).type("瓶").prodId(1).build();
        orderRepository.save(orderDto);
        mockMvc
                .perform(post("/product/1"))
                .andExpect(status().isOk());
    }
}
