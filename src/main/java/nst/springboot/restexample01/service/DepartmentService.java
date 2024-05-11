package nst.springboot.restexample01.service;

import java.util.List;
import java.util.NoSuchElementException;

import nst.springboot.restexample01.dto.DepartmentDto;
import nst.springboot.restexample01.exception.DepartmentAlreadyExistException;

public interface DepartmentService {
    DepartmentDto save(DepartmentDto departmentDto) throws DepartmentAlreadyExistException;
    List<DepartmentDto> getAll();
    void delete(Long id) throws NoSuchElementException;
    DepartmentDto update(DepartmentDto department) throws NoSuchElementException, DepartmentAlreadyExistException;
    DepartmentDto findById(Long id) throws NoSuchElementException;
}
