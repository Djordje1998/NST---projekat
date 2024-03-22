package nst.springboot.restexample01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nst.springboot.restexample01.controller.service.impl.AcademicTitleHistoryServiceImpl;
import nst.springboot.restexample01.dto.AcademicTitleHistoryDto;

@RestController
@RequestMapping("/academic-title-history")
public class AcademicTitleHistoryController {

    @Autowired
    private AcademicTitleHistoryServiceImpl academicTitleHistoryService;

    @GetMapping
    public ResponseEntity<List<AcademicTitleHistoryDto>> getAll() throws Exception{
        return ResponseEntity.ok(academicTitleHistoryService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcademicTitleHistoryDto> findById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(academicTitleHistoryService.findById(id));
    }

}
