package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.math.BigDecimal;


@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name="db_book")
@Component("book")
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="bname",length = 30)
    private String name;
    private BigDecimal price;
}
