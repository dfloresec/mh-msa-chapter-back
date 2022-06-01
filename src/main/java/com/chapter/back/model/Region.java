package com.chapter.back.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Region implements Serializable {

  @Id
  @Column(name = "region_id")
  private Integer regionId;

  private String regionName;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "region", cascade = CascadeType.ALL)
  private Set<Country> countries;
}
