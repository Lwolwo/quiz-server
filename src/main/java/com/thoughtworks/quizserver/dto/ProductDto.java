package com.thoughtworks.quizserver.dto;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class ProductDto {
    @Id @GeneratedValue private int id;
    private String name;
    private int price;
    private String type;
    private String picUrl;
}
