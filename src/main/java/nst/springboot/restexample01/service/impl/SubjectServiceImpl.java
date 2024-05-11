package nst.springboot.restexample01.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import nst.springboot.restexample01.converter.impl.DepartmentConverter;
import nst.springboot.restexample01.converter.impl.SubjectConverter;
import nst.springboot.restexample01.domain.Subject;
import nst.springboot.restexample01.dto.SubjectDto;
import nst.springboot.restexample01.repository.DepartmentRepository;
import nst.springboot.restexample01.repository.SubjectRepository;
import nst.springboot.restexample01.service.SubjectService;
import nst.springboot.restexample01.utils.ExceptionMessagesConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityExistsException;

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
    public SubjectDto save(SubjectDto subjectDto) throws NoSuchElementException, EntityExistsException {
        subjectDto.setId(null); // transform save or update to save
        Optional<Subject> byName = subjectRepository.findByName(subjectDto.getName());
        if (byName.isPresent()) {
            throw new EntityExistsException("Subject with that name already exists!");
        }

        subjectDto.setDepartmentDto(
                departmentConverter.toDto(departmentRepository.findById(subjectDto.getDepartmentDto().getId())
                        .orElseThrow(() -> new NoSuchElementException("Department does not exist!"))));
        return subjectConverter.toDto(subjectRepository.save(subjectConverter.toEntity(subjectDto)));
    }

    @Override
    public List<SubjectDto> getAll() {
        return subjectRepository
                .findAll()
                .stream().map(subjectConverter::toDto).toList();
    }

    @Override
    public SubjectDto findById(Long id) throws NoSuchElementException {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(ExceptionMessagesConstants.SUBJECT_NOT_EXIST));
        return subjectConverter.toDto(subject);
    }

    @Override
    public SubjectDto update(SubjectDto subjectDto) throws NoSuchElementException {
        Subject existingSubject = subjectRepository.findById(subjectDto.getId())
                .orElseThrow(() -> new NoSuchElementException(ExceptionMessagesConstants.SUBJECT_NOT_EXIST));

        Optional<Subject> existingName = subjectRepository.findByName(subjectDto.getName());

        if (existingName.isPresent() && !existingName.get().getId().equals(existingSubject.getId())) {
            throw new EntityExistsException("Subject with the updated name already exists!");
        }

        return subjectConverter.toDto(subjectRepository.save(subjectConverter.toEntity(subjectDto)));
    }

    @Override
    public void delete(Long id) throws NoSuchElementException {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(ExceptionMessagesConstants.SUBJECT_NOT_EXIST));
        subjectRepository.delete(subject);
    }

}
