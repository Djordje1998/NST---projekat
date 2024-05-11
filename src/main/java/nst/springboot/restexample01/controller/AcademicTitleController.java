package nst.springboot.restexample01.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import nst.springboot.restexample01.dto.AcademicTitleDto;
import nst.springboot.restexample01.service.impl.AcademicTitleServiceImpl;

@RestController
@RequestMapping("/academic-title")
public class AcademicTitleController {
    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(AcademicTitleController.class);

    private final AcademicTitleServiceImpl academicTitleService;

    @Autowired
    public AcademicTitleController(AcademicTitleServiceImpl academicTitleService) {
        this.academicTitleService = academicTitleService;
    }

    @PostMapping
    public ResponseEntity<AcademicTitleDto> save(@Valid @RequestBody AcademicTitleDto academicTitleDto)
            throws NoSuchElementException {
        LOGGER.info("Kreiranje {}", academicTitleDto.getName());
        return ResponseEntity.ok(academicTitleService.save(academicTitleDto));
    }

    @GetMapping
    public ResponseEntity<List<AcademicTitleDto>> getAll() {
        return ResponseEntity.ok(academicTitleService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcademicTitleDto> findById(@PathVariable("id") Long id) throws NoSuchElementException {
        return ResponseEntity.ok(academicTitleService.findById(id));
    }

    @PatchMapping
    public ResponseEntity<AcademicTitleDto> update(@Valid @RequestBody AcademicTitleDto academicTitleDto)
            throws NoSuchElementException {
        return ResponseEntity.ok(academicTitleService.update(academicTitleDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws NoSuchElementException {
        academicTitleService.delete(id);
        return ResponseEntity.ok("Academic title removed!");
    }

}
