package nst.springboot.restexample01.service;

import java.util.List;
import java.util.NoSuchElementException;

import nst.springboot.restexample01.dto.MemberDto;

public interface MemberService {

    MemberDto save(MemberDto memberDto) throws IllegalArgumentException;
    List<MemberDto> getAll();
    boolean delete(Long id) throws IllegalArgumentException, NoSuchElementException;
    MemberDto update(MemberDto memberDto) throws NoSuchElementException;
    MemberDto findById(Long id) throws NoSuchElementException;
 
}
