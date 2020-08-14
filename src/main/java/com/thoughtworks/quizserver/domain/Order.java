package com.thoughtworks.quizserver.domain;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
    private String name;
    private int price;
    private String type;
    private int quantity;
}
