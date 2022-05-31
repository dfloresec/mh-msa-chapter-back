package com.chapter.back.model;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "table_product")
public class ProductEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private BigDecimal price;

  private Integer stock;
  
//  @CreationTimestamp
//  @Column(updatable = false)
//  Timestamp dateCreated;
//  
//  @UpdateTimestamp
//  Timestamp lastModified;

  public ProductEntity(String name, BigDecimal price) {
    super();
    this.name = name;
    this.price = price;
  }

  public ProductEntity(String name, BigDecimal price, Integer stock) {
    super();
    this.name = name;
    this.price = price;
    this.stock = stock;
  }
  
  
}
