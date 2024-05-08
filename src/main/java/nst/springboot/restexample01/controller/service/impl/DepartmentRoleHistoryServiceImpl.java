package nst.springboot.restexample01.controller.service.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import nst.springboot.restexample01.controller.domain.DepartmentRoleHistory;
import nst.springboot.restexample01.converter.DtoEntityConverter;
import nst.springboot.restexample01.dto.DepartmentRoleHistoryDto;

@Service
public class DepartmentRoleHistoryServiceImpl extends AbstractCrudServiceImpl<DepartmentRoleHistoryDto, DepartmentRoleHistory>{

    public DepartmentRoleHistoryServiceImpl(DtoEntityConverter<DepartmentRoleHistoryDto, DepartmentRoleHistory> converter,
            JpaRepository<DepartmentRoleHistory, Long> repository) {
        super(converter, repository);
    }

}
