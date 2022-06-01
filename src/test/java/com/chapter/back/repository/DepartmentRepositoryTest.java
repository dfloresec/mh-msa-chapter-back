package com.chapter.back.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.chapter.back.constant.mapper.DepartmentMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

@DataJpaTest
@ComponentScan(basePackageClasses = {DepartmentMapper.class})
class DepartmentRepositoryTest {

  @Autowired
  private DepartmentRepository departmentRepository;

  @Autowired
  private DepartmentMapper departmentMapper;

  @Test
  void whenFindByRegionNameAndCountryCodesThenReturnListEntity() {
    final var departments = departmentRepository
        .findByRegionNameAndCountryCodes("Europe", List.of("DE")).stream()
        .map(value -> departmentMapper.toDto(value))
        .collect(Collectors.toList());

    assertEquals(2, departments.size());
  }

  @Test
  void whenFindByRegionNameAndCountryCodesThenReturnReportView() {
    final var departments = departmentRepository
        .getReportViewByRegionNameAndCountryCodes("Europe", List.of("DE"));

    assertEquals(2, departments.size());
  }

  @Test
  void whenFindByRegionNameAndCountryCodesThenExceptionOccurs() {
    final var departments = departmentRepository
        .getReportDtoByRegionNameAndCountryCodes("Europe", List.of("DE"));

    assertEquals(2, departments.size());
  }

  @Test
  void whenFindByRegionNameAndCountryCodesThenReturnReportDto() {
    final var departments = departmentRepository
        .findDepartmentByRegionNameAndCountryCodes("Europe", List.of("DE"));

    assertEquals(2, departments.size());
  }
}
