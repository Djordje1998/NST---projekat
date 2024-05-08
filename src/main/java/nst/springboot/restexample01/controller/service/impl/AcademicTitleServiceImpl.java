package nst.springboot.restexample01.controller.service.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import nst.springboot.restexample01.controller.domain.AcademicTitle;
import nst.springboot.restexample01.converter.DtoEntityConverter;
import nst.springboot.restexample01.dto.AcademicTitleDto;

@Service
public class AcademicTitleServiceImpl extends AbstractCrudServiceImpl<AcademicTitleDto, AcademicTitle>{

    public AcademicTitleServiceImpl(DtoEntityConverter<AcademicTitleDto, AcademicTitle> converter,
            JpaRepository<AcademicTitle, Long> repository) {
        super(converter, repository);
    }

}
