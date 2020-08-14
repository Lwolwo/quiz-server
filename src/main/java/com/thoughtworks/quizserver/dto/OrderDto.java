package com.thoughtworks.quizserver.dto;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "myOrder")
public class OrderDto {
    @Id @GeneratedValue private int id;
    private String name;
    private int price;
    private String type;
    private int quantity;
    private int prodId;

}
