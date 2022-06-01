package com.chapter.back.constant.mapper;

import com.chapter.back.constant.dto.DepartmentDto;
import com.chapter.back.model.Department;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

  DepartmentDto toDto(Department department);

}
