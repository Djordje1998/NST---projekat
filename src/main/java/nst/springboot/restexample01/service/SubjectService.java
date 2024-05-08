package nst.springboot.restexample01.service;

import java.util.List;
import java.util.NoSuchElementException;

import jakarta.persistence.EntityExistsException;
import nst.springboot.restexample01.dto.SubjectDto;

public interface SubjectService {
    SubjectDto save(SubjectDto subjectDto)throws NoSuchElementException, EntityExistsException;
    List<SubjectDto> getAll();
    void delete(Long id) throws NoSuchElementException;
    SubjectDto update(SubjectDto subjectDto)throws NoSuchElementException;
    SubjectDto findById(Long id)throws NoSuchElementException;
}
