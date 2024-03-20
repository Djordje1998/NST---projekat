package nst.springboot.restexample01.converter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import nst.springboot.restexample01.controller.domain.DepartmentRoleHistory;
import nst.springboot.restexample01.converter.DtoEntityConverter;
import nst.springboot.restexample01.dto.DepartmentRoleHistoryDto;

public class DepartmentRoleHistoryConverter
        implements DtoEntityConverter<DepartmentRoleHistoryDto, DepartmentRoleHistory> {

    @Autowired
    private DepartmentConverter departmentConverter;

    @Autowired
    private MemberConverter memberConverter;

    @Override
    public DepartmentRoleHistoryDto toDto(DepartmentRoleHistory e) {
        return new DepartmentRoleHistoryDto(
                e.getId(),
                e.getStartDate(),
                e.getEndDate(),
                departmentConverter.toDto(e.getDepartment()),
                memberConverter.toDto(e.getMember()),
                e.getRole());
    }

    @Override
    public DepartmentRoleHistory toEntity(DepartmentRoleHistoryDto t) {
        return new DepartmentRoleHistory(
                t.getId(),
                t.getStartDate(),
                t.getEndDate(),
                departmentConverter.toEntity(t.getDepartment()),
                memberConverter.toEntity(t.getMember()),
                t.getRole());
    }

}
