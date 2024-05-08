package nst.springboot.restexample01.controller.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import nst.springboot.restexample01.controller.domain.Subject;
import nst.springboot.restexample01.controller.repository.DepartmentRepository;
import nst.springboot.restexample01.controller.repository.SubjectRepository;
import nst.springboot.restexample01.controller.service.SubjectService;
import nst.springboot.restexample01.converter.impl.DepartmentConverter;
import nst.springboot.restexample01.converter.impl.SubjectConverter;
import nst.springboot.restexample01.dto.SubjectDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final DepartmentConverter departmentConverter;

    private final DepartmentRepository departmentRepository;

    private final SubjectConverter subjectConverter;

    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectServiceImpl(DepartmentConverter departmentConverter, DepartmentRepository departmentRepository,
            SubjectConverter subjectConverter, SubjectRepository subjectRepository) {
        this.departmentConverter = departmentConverter;
        this.departmentRepository = departmentRepository;
        this.subjectConverter = subjectConverter;
        this.subjectRepository = subjectRepository;
    }

    @Override
    public SubjectDto save(SubjectDto subjectDto) throws Exception {
        subjectDto.setId(null); // transform save or update to save
        Optional<Subject> byName = subjectRepository.findByName(subjectDto.getName());
        if (byName.isPresent()) {
            throw new Exception("Subject with that name already exists!");
        }

        subjectDto.setDepartmentDto(
                departmentConverter.toDto(departmentRepository.findById(subjectDto.getDepartmentDto().getId())
                        .orElseThrow(() -> new Exception("Department does not exist!"))));
        return subjectConverter.toDto(subjectRepository.save(subjectConverter.toEntity(subjectDto)));
    }

    @Override
    public List<SubjectDto> getAll() {
        return subjectRepository
                .findAll()
                .stream().map(entity -> subjectConverter.toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public SubjectDto findById(Long id) throws Exception {
        Subject subject = subjectRepository.findById(id).orElseThrow(() -> new Exception("Subject does not exist!"));
        return subjectConverter.toDto(subject);
    }

    @Override
    public SubjectDto update(SubjectDto subjectDto) throws Exception {
        Subject existingSubject = subjectRepository.findById(subjectDto.getId())
                .orElseThrow(() -> new Exception("Subject does not exist!"));

        Optional<Subject> existingName = subjectRepository.findByName(subjectDto.getName());

        if (existingName.isPresent() && !existingName.get().getId().equals(existingSubject.getId())) {
            throw new Exception("Subject with the updated name already exists!");
        }

        return subjectConverter.toDto(subjectRepository.save(subjectConverter.toEntity(subjectDto)));
    }

    @Override
    public void delete(Long id) throws Exception {
        Subject subject = subjectRepository.findById(id).orElseThrow(() -> new Exception("Subject does not exist!"));
        subjectRepository.delete(subject);
    }

}
