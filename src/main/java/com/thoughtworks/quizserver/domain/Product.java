package com.thoughtworks.quizserver.domain;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    private String name;
    private int price;
    private String type;
    private String picUrl;
}
