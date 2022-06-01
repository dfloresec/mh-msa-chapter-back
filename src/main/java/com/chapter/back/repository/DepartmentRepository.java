package com.chapter.back.repository;

import com.chapter.back.constant.dto.ReportDto;
import com.chapter.back.constant.dto.ReportView;
import com.chapter.back.model.Department;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

  @Query(nativeQuery = true,
      value = "Select * from Department d "
          + "join Employee e on d.department_id = e.department_id "
          + "join Location l on l.location_id = d.location_id "
          + "join Country c on l.country_id = c.country_id "
          + "join Region r on c.region_id= r.region_id "
          + "where r.region_name =:regionName "
          + "and c.country_code not in(:codes) ")
  List<Department> findByRegionNameAndCountryCodes(String regionName, List<String> codes);

  @Query(nativeQuery = true,
      value = "Select "
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
          + "and c.country_code not in(:codes) ")
  List<ReportView> getReportViewByRegionNameAndCountryCodes(String regionName, List<String> codes);


  @Query(nativeQuery = true,
      value = "Select "
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
          + "and c.country_code not in(:codes) ")
  List<ReportDto> getReportDtoByRegionNameAndCountryCodes(String regionName, List<String> codes);

  @Query(nativeQuery = true)
  List<ReportDto> findDepartmentByRegionNameAndCountryCodes(String regionName, List<String> codes);

}
