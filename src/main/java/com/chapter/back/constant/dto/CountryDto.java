package com.chapter.back.constant.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class CountryDto implements Serializable {

  private final String countryName;
  private final String countryCode;
  private final RegionDto region;
}
