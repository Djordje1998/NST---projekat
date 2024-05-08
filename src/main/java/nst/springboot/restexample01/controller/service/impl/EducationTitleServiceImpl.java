package nst.springboot.restexample01.controller.service.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import nst.springboot.restexample01.controller.domain.EducationTitle;
import nst.springboot.restexample01.converter.DtoEntityConverter;
import nst.springboot.restexample01.dto.EducationTitleDto;

@Service
public class EducationTitleServiceImpl extends AbstractCrudServiceImpl<EducationTitleDto, EducationTitle> {

    public EducationTitleServiceImpl(DtoEntityConverter<EducationTitleDto, EducationTitle> converter,
            JpaRepository<EducationTitle, Long> repository) {
        super(converter, repository);
    }

}
