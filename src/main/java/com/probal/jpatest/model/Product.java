package com.probal.jpatest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_product")
//@SQLDelete(sql = "update t_product product set deleted = true where product.id = ? and version = ?")
//@Where(clause = "deleted = false")
public class Product extends BaseEntity<Long> {
    private String name;
    private Double price;
    private String description;
}
