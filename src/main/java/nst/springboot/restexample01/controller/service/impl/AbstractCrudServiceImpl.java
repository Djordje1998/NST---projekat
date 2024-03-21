package nst.springboot.restexample01.controller.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import nst.springboot.restexample01.controller.domain.EntityObject;
import nst.springboot.restexample01.converter.DtoEntityConverter;
import nst.springboot.restexample01.dto.DtoObject; 

public class AbstractCrudServiceImpl<D extends DtoObject, E extends EntityObject> {

    @Autowired
    private DtoEntityConverter<D, E> converter;

    @Autowired
    private JpaRepository<E, Long> repository;

    public D save(D dto) throws Exception {
        return converter.toDto(repository.save(converter.toEntity(dto)));
    }

    public List<D> getAll() {
        return repository.findAll().stream()
                .map(entity -> converter.toDto(entity)).collect(Collectors.toList());
    }

    public D findById(Long id) throws Exception {
        return converter.toDto(repository.findById(id)
                .orElseThrow(() -> new Exception("Entity does not exist")));
    }

    public D update(D dto) throws Exception {
        if (dto == null || dto.getId() == null) {
            throw new IllegalArgumentException("Entity cannot be null!");
        }
        repository.findById(dto.getId())
                .orElseThrow(() -> new Exception("Entity does not exist"));
        return converter.toDto(repository.save(converter.toEntity(dto)));
    }

    public boolean delete(Long id) throws Exception {
        E entity = repository.findById(id)
                .orElseThrow(() -> new Exception("Entity does not exist"));
        repository.delete(entity);
        return true;
    }

}
