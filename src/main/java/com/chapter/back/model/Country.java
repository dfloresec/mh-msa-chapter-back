package com.chapter.back.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Country implements Serializable {

  @Id
  @Column(name = "country_id")
  private Integer countryId;

  private String countryName;
  private String countryCode;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "region_id")
  private Region region;
}
