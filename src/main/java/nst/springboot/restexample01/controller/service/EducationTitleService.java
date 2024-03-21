package nst.springboot.restexample01.controller.service;

import java.util.List;

import nst.springboot.restexample01.dto.EducationTitleDto;

public interface EducationTitleService {

    EducationTitleDto save(EducationTitleDto educationTitleDto) throws Exception;
    List<EducationTitleDto> getAll();
    EducationTitleDto findById(Long id) throws Exception;
    EducationTitleDto update(EducationTitleDto educationTitleDto) throws Exception;
    boolean delete(Long id) throws Exception;

}
