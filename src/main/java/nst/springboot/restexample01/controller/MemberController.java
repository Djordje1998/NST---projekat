package nst.springboot.restexample01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
    public ResponseEntity<MemberDto> save(MemberDto member) throws Exception {
        return ResponseEntity.ok(memberService.save(member));
    }

    public ResponseEntity<List<MemberDto>> getAll() {
        return ResponseEntity.ok(memberService.getAll());
    }

}
