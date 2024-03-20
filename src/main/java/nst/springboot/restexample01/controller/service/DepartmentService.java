package nst.springboot.restexample01.controller.service;

import java.util.List;
import nst.springboot.restexample01.dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto save(DepartmentDto departmentDto) throws Exception;
    List<DepartmentDto> getAll();
    void delete(Long id) throws Exception;
    void update(DepartmentDto department) throws Exception;
    DepartmentDto findById(Long id) throws Exception;
}
