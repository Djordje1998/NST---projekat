package nst.springboot.restexample01.converter.impl;

import nst.springboot.restexample01.controller.domain.EducationTitle;
import nst.springboot.restexample01.converter.DtoEntityConverter;
import nst.springboot.restexample01.dto.EducationTitleDto;

public class EducationTitleConverter implements DtoEntityConverter<EducationTitleDto, EducationTitle>{

    @Override
    public EducationTitleDto toDto(EducationTitle e) {
        return new EducationTitleDto(e.getId(), e.getName());
    }

    @Override
    public EducationTitle toEntity(EducationTitleDto t) {
        return new EducationTitle(t.getId(), t.getName());
    }

}