package nst.springboot.restexample01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nst.springboot.restexample01.controller.service.impl.DepartmentRoleHistoryServiceImpl;
import nst.springboot.restexample01.dto.DepartmentRoleHistoryDto;

@RestController
@RequestMapping("/department-role-history")
public class DepartmentRoleHistoryController {

    @Autowired
    private DepartmentRoleHistoryServiceImpl departmentRoleHistoryService;

    @GetMapping
    public ResponseEntity<List<DepartmentRoleHistoryDto>> getAll() throws Exception {
        return ResponseEntity.ok(departmentRoleHistoryService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentRoleHistoryDto> findById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(departmentRoleHistoryService.findById(id));
    }
}
