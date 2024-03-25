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

import nst.springboot.restexample01.controller.service.MemberService;
import nst.springboot.restexample01.dto.MemberDto;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping
    public ResponseEntity<MemberDto> save(@RequestBody MemberDto member) throws Exception {
        return ResponseEntity.ok(memberService.save(member));
    }

    @GetMapping
    public ResponseEntity<List<MemberDto>> getAll() {
        return ResponseEntity.ok(memberService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberDto> findById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(memberService.findById(id));
    }

    @PatchMapping
    public ResponseEntity<MemberDto> update(@RequestBody MemberDto member) throws Exception {
        return ResponseEntity.ok(memberService.update(member));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws Exception {
        memberService.delete(id);
        return ResponseEntity.ok("Member removed!");
    }

}
