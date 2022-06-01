package com.chapter.back.model;

import com.chapter.back.constant.dto.ReportDto;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@NamedNativeQuery(name = "Department.findDepartmentByRegionNameAndCountryCodes",
    query = "Select "
        + "d.department_name as departmentName, "
        + "e.first_name as firstName, "
        + "e.last_name as lastName, "
        + "c.country_name as countryName, "
        + "l.city, "
        + "r.region_name as regionName "
        + "from Department d "
        + "join Employee e on d.department_id = e.department_id "
        + "join Location l on l.location_id = d.location_id "
        + "join Country c on l.country_id = c.country_id "
        + "join Region r on c.region_id= r.region_id "
        + "where r.region_name =:regionName "
        + "and c.country_code not in(:codes) ",
    resultSetMapping = "Mapping.ReportDto")
@SqlResultSetMapping(name = "Mapping.ReportDto",
    classes = @ConstructorResult(targetClass = ReportDto.class, columns = {
        @ColumnResult(name = "departmentName"), @ColumnResult(name = "firstName"),
        @ColumnResult(name = "lastName"), @ColumnResult(name = "countryName"),
        @ColumnResult(name = "city"), @ColumnResult(name = "regionName")}))
public class Department implements Serializable {

  @Id
  @Column(name = "department_id")
  private Integer departmentId;

  private String departmentName;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "department")
  private Set<Employee> employees;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "location_id")
  private Location location;

}
