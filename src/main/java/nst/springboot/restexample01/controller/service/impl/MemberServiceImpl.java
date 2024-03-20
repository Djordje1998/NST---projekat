package nst.springboot.restexample01.controller.service.impl;

import java.util.List;
import nst.springboot.restexample01.controller.service.MemberService;
import nst.springboot.restexample01.dto.MemberDto;

public class MemberServiceImpl implements MemberService{

    private MemberService memberService;

    public MemberServiceImpl(MemberService memberService) {
        this.memberService = memberService;
    }

    @Override
    public MemberDto save(MemberDto memberDto) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<MemberDto> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public MemberDto update(MemberDto memberDto) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public MemberDto delete(Long id) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public MemberDto findById(Long id) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

}
