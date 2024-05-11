package nst.springboot.restexample01.converter.impl;

import org.springframework.stereotype.Component;

import nst.springboot.restexample01.converter.DtoEntityConverter;
import nst.springboot.restexample01.domain.ScientificField;
import nst.springboot.restexample01.dto.ScientificFieldDto;

@Component
public class ScientificFieldConverter implements DtoEntityConverter<ScientificFieldDto, ScientificField>{

    @Override
    public ScientificFieldDto toDto(ScientificField e) {
        return new ScientificFieldDto(e.getId(), e.getName());
    }

    @Override
    public ScientificField toEntity(ScientificFieldDto t) {
        return new ScientificField(t.getId(), t.getName());
    }

}
