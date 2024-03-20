package nst.springboot.restexample01.converter.impl;

import nst.springboot.restexample01.controller.domain.Member;
import nst.springboot.restexample01.converter.DtoEntityConverter;
import nst.springboot.restexample01.dto.MemberDto;

public class MemberConverter implements DtoEntityConverter<MemberDto, Member>{


    @Override
    public MemberDto toDto(Member e) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Member toEntity(MemberDto t) {
        // TODO Auto-generated method stub
        return null;
    }
}
