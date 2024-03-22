package nst.springboot.restexample01.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import nst.springboot.restexample01.controller.service.impl.ScientificFieldServiceImpl;
import nst.springboot.restexample01.dto.ScientificFieldDto;

@RestController
@RequestMapping("/science-field")
public class ScienceFieldController {

    private ScientificFieldServiceImpl scientificFieldService;

    @PostMapping
    public ResponseEntity<ScientificFieldDto> save(@RequestBody ScientificFieldDto scientificFieldDto) throws Exception {
        System.out.println("Kreiranje " + scientificFieldDto.getName());
        return ResponseEntity.ok(scientificFieldService.save(scientificFieldDto));
    }

    @GetMapping
    public ResponseEntity<List<ScientificFieldDto>> getAll() {
        return ResponseEntity.ok(scientificFieldService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScientificFieldDto> findById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(scientificFieldService.findById(id));
    }

    @PatchMapping
    public ResponseEntity<ScientificFieldDto> update(ScientificFieldDto scientificFieldDto) throws Exception {
        return ResponseEntity.ok(scientificFieldService.update(scientificFieldDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) throws Exception{
        return ResponseEntity.ok(scientificFieldService.delete(id));
    }

}
