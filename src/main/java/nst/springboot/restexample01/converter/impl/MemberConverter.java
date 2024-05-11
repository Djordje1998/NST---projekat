package nst.springboot.restexample01.converter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nst.springboot.restexample01.converter.DtoEntityConverter;
import nst.springboot.restexample01.domain.Member;
import nst.springboot.restexample01.dto.MemberDto;

@Component
public class MemberConverter implements DtoEntityConverter<MemberDto, Member> {

    private final DepartmentConverter departmentConverter;

    private final EducationTitleConverter educationTitleConverter;

    private final AcademicTitleConverter academicTitleConverter;

    private final ScientificFieldConverter scientificFieldConverter;

    @Autowired
    public MemberConverter(DepartmentConverter departmentConverter, EducationTitleConverter educationTitleConverter,
            AcademicTitleConverter academicTitleConverter, ScientificFieldConverter scientificFieldConverter) {
        this.departmentConverter = departmentConverter;
        this.educationTitleConverter = educationTitleConverter;
        this.academicTitleConverter = academicTitleConverter;
        this.scientificFieldConverter = scientificFieldConverter;
    }

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
