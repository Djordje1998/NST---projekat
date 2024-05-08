package nst.springboot.restexample01.controller.service.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import nst.springboot.restexample01.controller.domain.AcademicTitleHistory;
import nst.springboot.restexample01.converter.DtoEntityConverter;
import nst.springboot.restexample01.dto.AcademicTitleHistoryDto;

@Service
public class AcademicTitleHistoryServiceImpl extends AbstractCrudServiceImpl<AcademicTitleHistoryDto, AcademicTitleHistory>{

    public AcademicTitleHistoryServiceImpl(DtoEntityConverter<AcademicTitleHistoryDto, AcademicTitleHistory> converter,
            JpaRepository<AcademicTitleHistory, Long> repository) {
        super(converter, repository);
    }

}
