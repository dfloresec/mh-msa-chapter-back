package com.chapter.back.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Location implements Serializable {

  @Id
  @Column(name = "location_id")
  private Integer locationId;

  private String streetAddress;
  private String postalCode;
  private String city;
  private String stateProvince;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "country_id")
  private Country country;

}
