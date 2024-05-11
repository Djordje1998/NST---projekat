package nst.springboot.restexample01.controller;

import jakarta.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

import nst.springboot.restexample01.dto.DepartmentDto;
import nst.springboot.restexample01.exception.DepartmentAlreadyExistException;
import nst.springboot.restexample01.exception.MyErrorDetails;
import nst.springboot.restexample01.service.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<DepartmentDto> save(@Valid @RequestBody DepartmentDto departmentDto) throws DepartmentAlreadyExistException {
        return new ResponseEntity<>(departmentService.save(departmentDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAll() {
        return new ResponseEntity<>(departmentService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public DepartmentDto findById(@PathVariable("id") Long id) throws NoSuchElementException {
        return departmentService.findById(id);
    }

    @PatchMapping
    public ResponseEntity<DepartmentDto> update(@Valid @RequestBody DepartmentDto department) throws NoSuchElementException {
        return new ResponseEntity<>(departmentService.update(department), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws NoSuchElementException {
        departmentService.delete(id);
        return new ResponseEntity<>("Department removed!", HttpStatus.OK);
    }

    @ExceptionHandler(DepartmentAlreadyExistException.class)
    public ResponseEntity<MyErrorDetails> handleException(DepartmentAlreadyExistException e) {
        MyErrorDetails myErrorDetails = new MyErrorDetails(e.getMessage());
        return new ResponseEntity<>(myErrorDetails, HttpStatus.BAD_REQUEST);
    }
}
