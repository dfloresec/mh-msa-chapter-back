package com.chapter.back.constant.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class LocationDto implements Serializable {

  private final String streetAddress;
  private final String postalCode;
  private final String city;
  private final String stateProvince;
  private final CountryDto country;
}
