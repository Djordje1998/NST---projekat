package nst.springboot.restexample01.converter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import nst.springboot.restexample01.controller.domain.Member;
import nst.springboot.restexample01.converter.DtoEntityConverter;
import nst.springboot.restexample01.dto.MemberDto;

public class MemberConverter implements DtoEntityConverter<MemberDto, Member> {

    @Autowired
    private DepartmentConverter departmentConverter;

    @Autowired
    private EducationTitleConverter educationTitleConverter;

    @Autowired
    private AcademicTitleConverter academicTitleConverter;

    @Autowired
    private ScientificFieldConverter scientificFieldConverter;

    @Override
    public MemberDto toDto(Member e) {
        return new MemberDto(
                e.getId(),
                e.getFirstName(),
                e.getLastName(),
                departmentConverter.toDto(e.getDepartment()),
                educationTitleConverter.toDto(e.getEducationTitle()),
                academicTitleConverter.toDto(e.getAcademicTitle()),
                scientificFieldConverter.toDto(e.getScientificField()));
    }

    @Override
    public Member toEntity(MemberDto t) {
        return new Member(
                t.getId(),
                t.getFirstName(),
                t.getLastName(),
                departmentConverter.toEntity(t.getDepartment()),
                academicTitleConverter.toEntity(t.getAcademicTitle()),
                educationTitleConverter.toEntity(t.getEducationTitle()),
                scientificFieldConverter.toEntity(t.getScientificField()));
    }
}
