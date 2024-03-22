package nst.springboot.restexample01.controller;

import java.util.List;

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
import nst.springboot.restexample01.controller.service.impl.EducationTitleServiceImpl;
import nst.springboot.restexample01.dto.EducationTitleDto;

@RestController
@RequestMapping("/education-title")
public class EducationTitleController {

    @Autowired
    private EducationTitleServiceImpl educationTitleService;

    @PostMapping
    public ResponseEntity<EducationTitleDto> save(@Valid @RequestBody EducationTitleDto educationTitleDto)
            throws Exception {
        System.out.println("Kreiranje " + educationTitleDto.getName());
        return ResponseEntity.ok(educationTitleService.save(educationTitleDto));
    }

    @GetMapping
    public ResponseEntity<List<EducationTitleDto>> getAll() {
        return ResponseEntity.ok(educationTitleService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EducationTitleDto> findById(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(educationTitleService.findById(id));
    }

    @PatchMapping
    public ResponseEntity<EducationTitleDto> update(@Valid @RequestBody EducationTitleDto academicTitleDto)
            throws Exception {
        return ResponseEntity.ok(educationTitleService.update(academicTitleDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws Exception {
        educationTitleService.delete(id);
        return ResponseEntity.ok("Education title removed!");
    }

}
