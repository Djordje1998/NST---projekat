package nst.springboot.restexample01.controller.service;

import java.util.List;

import nst.springboot.restexample01.dto.DtoObject;

public interface AbstractCrudService<D extends DtoObject> {

    D save(D dto) throws Exception;
    List<D> getAll();
    D findById(Long id) throws Exception;
    D update(D dto) throws Exception;
    void delete(Long id) throws Exception;

}
