package com.chapter.back.constant.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class EmployeeDto implements Serializable {

  private final String firstName;
  private final String lastName;
  private final String email;
}
