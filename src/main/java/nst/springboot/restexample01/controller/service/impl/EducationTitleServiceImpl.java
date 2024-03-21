package nst.springboot.restexample01.controller.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import nst.springboot.restexample01.controller.domain.EducationTitle;
import nst.springboot.restexample01.controller.repository.EducationTitleRepository;
import nst.springboot.restexample01.controller.service.EducationTitleService;
import nst.springboot.restexample01.converter.impl.EducationTitleConverter;
import nst.springboot.restexample01.dto.EducationTitleDto;

public class EducationTitleServiceImpl implements EducationTitleService {

    @Autowired
    private EducationTitleConverter educationTitleConverter;

    @Autowired
    private EducationTitleRepository educationTitleRepository;

    @Override
    public EducationTitleDto save(EducationTitleDto educationTitleDto) throws Exception {
        if (educationTitleDto == null) {
            throw new Exception("Education title cannot be null");
        }
        return educationTitleConverter
                .toDto(educationTitleRepository.save(educationTitleConverter.toEntity(educationTitleDto)));
    }

    @Override
    public List<EducationTitleDto> getAll() {
        return educationTitleRepository.findAll().stream()
                .map(entity -> educationTitleConverter.toDto(entity)).collect(Collectors.toList());
    }

    @Override
    public EducationTitleDto findById(Long id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public EducationTitleDto update(EducationTitleDto educationTitleDto) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(Long id) throws Exception {
        EducationTitle educationTitle = educationTitleRepository.findById(id)
                .orElseThrow(() -> new Exception("Education title does not exist"));
        educationTitleRepository.delete(educationTitle);
        return true;
    }

}
