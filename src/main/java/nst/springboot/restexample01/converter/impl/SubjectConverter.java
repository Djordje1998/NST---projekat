package nst.springboot.restexample01.converter.impl;

import nst.springboot.restexample01.controller.domain.Subject;
import nst.springboot.restexample01.converter.DtoEntityConverter;
import nst.springboot.restexample01.dto.SubjectDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubjectConverter implements DtoEntityConverter<SubjectDto, Subject> {
    
    @Autowired
    private DepartmentConverter departmentConverter;

    @Override
    public SubjectDto toDto(Subject entity) {
        return new SubjectDto(
                entity.getId(),
                entity.getName(), entity.getEsbp(),
                departmentConverter.toDto(entity.getDepartment()));
    }

    @Override
    public Subject toEntity(SubjectDto dto) {
        return new Subject(
                dto.getId(),
                dto.getName(),
                dto.getEsbp(),
                departmentConverter.toEntity(dto.getDepartmentDto()));
    }

}
