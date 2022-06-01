package com.chapter.back.constant.dto;

import java.io.Serializable;
import java.util.Set;
import lombok.Data;

@Data
public class DepartmentDto implements Serializable {

  private final String departmentName;
  private final Set<EmployeeDto> employees;
  private final LocationDto location;
}
