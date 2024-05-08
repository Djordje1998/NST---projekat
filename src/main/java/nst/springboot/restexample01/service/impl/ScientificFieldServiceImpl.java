package nst.springboot.restexample01.service.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import nst.springboot.restexample01.converter.DtoEntityConverter;
import nst.springboot.restexample01.domain.ScientificField;
import nst.springboot.restexample01.dto.ScientificFieldDto;

@Service
public class ScientificFieldServiceImpl extends AbstractCrudServiceImpl<ScientificFieldDto, ScientificField>{

    public ScientificFieldServiceImpl(DtoEntityConverter<ScientificFieldDto, ScientificField> converter,
            JpaRepository<ScientificField, Long> repository) {
        super(converter, repository);
    }

}
