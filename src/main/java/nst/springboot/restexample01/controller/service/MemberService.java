package nst.springboot.restexample01.controller.service;

import java.util.List;
import nst.springboot.restexample01.dto.MemberDto;

public interface MemberService {

    MemberDto save(MemberDto memberDto) throws Exception;
    List<MemberDto> getAll();
    boolean delete(Long id) throws Exception;
    MemberDto update(MemberDto memberDto) throws Exception;
    MemberDto findById(Long id) throws Exception;
 
}
