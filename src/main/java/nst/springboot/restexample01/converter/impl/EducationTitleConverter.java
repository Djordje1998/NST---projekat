package nst.springboot.restexample01.converter.impl;

import org.springframework.stereotype.Component;

import nst.springboot.restexample01.converter.DtoEntityConverter;
import nst.springboot.restexample01.domain.EducationTitle;
import nst.springboot.restexample01.dto.EducationTitleDto;

@Component
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
