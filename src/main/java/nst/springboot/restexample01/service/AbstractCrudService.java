package nst.springboot.restexample01.service;

import java.util.List;
import java.util.NoSuchElementException;

import nst.springboot.restexample01.dto.DtoObject;

public interface AbstractCrudService<D extends DtoObject> {

    D save(D dto) throws NoSuchElementException;
    List<D> getAll();
    D findById(Long id) throws NoSuchElementException;
    D update(D dto) throws NoSuchElementException;
    void delete(Long id) throws NoSuchElementException;

}
