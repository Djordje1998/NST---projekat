package nst.springboot.restexample01.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nst.springboot.restexample01.dto.DepartmentRoleHistoryDto;
import nst.springboot.restexample01.service.impl.DepartmentRoleHistoryServiceImpl;

@RestController
@RequestMapping("/department-role-history")
public class DepartmentRoleHistoryController {

    private final DepartmentRoleHistoryServiceImpl departmentRoleHistoryService;

    @Autowired
    public DepartmentRoleHistoryController(DepartmentRoleHistoryServiceImpl departmentRoleHistoryService) {
        this.departmentRoleHistoryService = departmentRoleHistoryService;
    }

    @GetMapping
    public ResponseEntity<List<DepartmentRoleHistoryDto>> getAll() {
        return ResponseEntity.ok(departmentRoleHistoryService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentRoleHistoryDto> findById(@PathVariable Long id) throws NoSuchElementException {
        return ResponseEntity.ok(departmentRoleHistoryService.findById(id));
    }
}
