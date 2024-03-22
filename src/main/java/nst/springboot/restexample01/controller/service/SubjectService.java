package nst.springboot.restexample01.controller.service;

import java.util.List;
import nst.springboot.restexample01.dto.SubjectDto;

public interface SubjectService {
    SubjectDto save(SubjectDto subjectDto)throws Exception;
    List<SubjectDto> getAll();
    void delete(Long id) throws Exception;
    SubjectDto update(SubjectDto subjectDto)throws Exception;
    SubjectDto findById(Long id)throws Exception;
}
