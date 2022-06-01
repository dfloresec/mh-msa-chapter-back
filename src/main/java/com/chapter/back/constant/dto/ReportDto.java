package com.chapter.back.constant.dto;

import lombok.Data;

@Data
public class ReportDto {

  private final String departmentName;
  private final String firstName;
  private final String lastName;
  private final String countryName;
  private final String city;
  private final String regionName;

}
