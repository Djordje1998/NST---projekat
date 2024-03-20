package nst.springboot.restexample01.converter.impl;

import nst.springboot.restexample01.controller.domain.AcademicTitle;
import nst.springboot.restexample01.converter.DtoEntityConverter;
import nst.springboot.restexample01.dto.AcademicTitleDto;

public class AcademicTitleConverter implements DtoEntityConverter<AcademicTitleDto, AcademicTitle>{

    @Override
    public AcademicTitleDto toDto(AcademicTitle e) {
        return new AcademicTitleDto(e.getId(), e.getName());
    }

    @Override
    public AcademicTitle toEntity(AcademicTitleDto t) {
        return new AcademicTitle(t.getId(), t.getName());
    }

}
