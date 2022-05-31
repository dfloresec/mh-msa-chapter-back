package com.chapter.back.constant.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductDTO implements Serializable {

  private static final long serialVersionUID = -3677455960012857440L;

  private Long id;

  @Pattern(regexp = "^[a-zA-Z ]+$", message = "description must be a string")
  private String name;

  @NotNull(message = "price is required")
  @Positive(message = "price must be positive")
  private BigDecimal price;

  private Integer stock;

}
