package nst.springboot.restexample01.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import nst.springboot.restexample01.converter.DtoEntityConverter;
import nst.springboot.restexample01.domain.EntityObject;
import nst.springboot.restexample01.dto.DtoObject;
import nst.springboot.restexample01.utils.ExceptionMessagesConstants;

public class AbstractCrudServiceImpl<D extends DtoObject, E extends EntityObject> {

    private final DtoEntityConverter<D, E> converter;

    private final JpaRepository<E, Long> repository;

    @Autowired
    public AbstractCrudServiceImpl(DtoEntityConverter<D, E> converter, JpaRepository<E, Long> repository) {
        this.converter = converter;
        this.repository = repository;
    }

    public D save(D dto) throws NoSuchElementException {
        dto.setId(null);
        return converter.toDto(repository.save(converter.toEntity(dto)));
    }

    public List<D> getAll() {
        return repository.findAll().stream()
                .map(converter::toDto).toList();
    }

    public D findById(Long id) throws NoSuchElementException {
        return converter.toDto(repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(ExceptionMessagesConstants.ENTITY_NOT_EXIST)));
    }

    public D update(D dto) throws NoSuchElementException {
        if (dto == null || dto.getId() == null) {
            throw new NoSuchElementException(ExceptionMessagesConstants.ENTITY_NOT_NULL);
        }
        if (repository.findById(dto.getId()).isEmpty()) {
            throw new NoSuchElementException(ExceptionMessagesConstants.ENTITY_NOT_EXIST);
        }
        return converter.toDto(repository.save(converter.toEntity(dto)));
    }

    public void delete(Long id) throws NoSuchElementException {
        E entity = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(ExceptionMessagesConstants.ENTITY_NOT_EXIST));
        repository.delete(entity);
    }

}
