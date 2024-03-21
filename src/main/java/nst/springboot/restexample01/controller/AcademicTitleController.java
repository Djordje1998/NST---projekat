package nst.springboot.restexample01.controller;

import java.util.List;

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
import nst.springboot.restexample01.controller.service.impl.AcademicTitleServiceImpl;
import nst.springboot.restexample01.dto.AcademicTitleDto;

@RestController
@RequestMapping("/academic-title")
public class AcademicTitleController {

    private AcademicTitleServiceImpl academicTitleService;

    public AcademicTitleController(AcademicTitleServiceImpl academicTitleService) {
        this.academicTitleService = academicTitleService;
        System.out.println("kreiran je konroller za academic title!");
    }

    @PostMapping
    public ResponseEntity<AcademicTitleDto> save(@Valid @RequestBody AcademicTitleDto academicTitleDto) throws Exception {
        System.out.println("Kreiranje " + academicTitleDto.getName());
        return ResponseEntity.ok(academicTitleService.save(academicTitleDto));
    }

    @GetMapping
    public ResponseEntity<List<AcademicTitleDto>> getAll() {
        return ResponseEntity.ok(academicTitleService.getAll());
    }

    @GetMapping("/{id}")
    public AcademicTitleDto findById(@PathVariable("id") Long id) throws Exception {
        return academicTitleService.findById(id);
    }

    @PatchMapping
    public AcademicTitleDto update(AcademicTitleDto academicTitleDto) throws Exception {
        return academicTitleService.update(academicTitleDto);
    }


    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) throws Exception {
        return academicTitleService.delete(id);
    }

}
