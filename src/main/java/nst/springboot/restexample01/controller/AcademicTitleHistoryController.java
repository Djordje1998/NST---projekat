package nst.springboot.restexample01.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nst.springboot.restexample01.dto.AcademicTitleHistoryDto;
import nst.springboot.restexample01.service.impl.AcademicTitleHistoryServiceImpl;

@RestController
@RequestMapping("/academic-title-history")
public class AcademicTitleHistoryController {

    private final AcademicTitleHistoryServiceImpl academicTitleHistoryService;

    @Autowired
    public AcademicTitleHistoryController(AcademicTitleHistoryServiceImpl academicTitleHistoryService) {
        this.academicTitleHistoryService = academicTitleHistoryService;
    }

    @GetMapping
    public ResponseEntity<List<AcademicTitleHistoryDto>> getAll() throws NoSuchElementException {
        return ResponseEntity.ok(academicTitleHistoryService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcademicTitleHistoryDto> findById(@PathVariable Long id) throws NoSuchElementException {
        return ResponseEntity.ok(academicTitleHistoryService.findById(id));
    }

}
