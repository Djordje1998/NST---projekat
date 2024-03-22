package nst.springboot.restexample01.controller;

import jakarta.validation.Valid;
import java.util.List;
import nst.springboot.restexample01.controller.service.SubjectService;
import nst.springboot.restexample01.dto.SubjectDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    //dodaj novi department
    @PostMapping
    public ResponseEntity<SubjectDto> save(@Valid @RequestBody SubjectDto subject) throws Exception {
        // return new ResponseEntity<>(subjectService.save(subject), HttpStatus.CREATED);
        return ResponseEntity.status(HttpStatus.CREATED).body(subjectService.save(subject));
    }

    @GetMapping
    public ResponseEntity<List<SubjectDto>> getAll() {
        // return new ResponseEntity<>(subjectService.getAll(), HttpStatus.OK);
        return ResponseEntity.ok(subjectService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubjectDto> findById(@PathVariable("id") Long id) throws Exception {
        // return new ResponseEntity<>(subjectService.findById(id), HttpStatus.OK);
        return ResponseEntity.ok(subjectService.findById(id));
    }

    //pronadji na osnovu ID/a
    //localhost:8080/department/query?id=1
    // @GetMapping("/query")
    // public SubjectDto queryById(@RequestParam("id") Long id) throws Exception {
    //     return subjectService.findById(id);
    // }

    @PatchMapping
    public ResponseEntity<SubjectDto> update(@Valid @RequestBody SubjectDto subject) throws Exception {
        return ResponseEntity.ok(subjectService.update(subject));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws Exception {
        /*
        try {
            departmentService.delete(id);
            return new ResponseEntity<>("Department removed!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(">>" + e.getMessage(), HttpStatus.NOT_FOUND);
        }*/
        
        subjectService.delete(id);
        return new ResponseEntity<>("Department removed!", HttpStatus.OK);

    }
    
    
}
