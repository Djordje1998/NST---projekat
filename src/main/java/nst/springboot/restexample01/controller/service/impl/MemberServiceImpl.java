package nst.springboot.restexample01.controller.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nst.springboot.restexample01.controller.domain.Member;
import nst.springboot.restexample01.controller.repository.MemberRepository;
import nst.springboot.restexample01.controller.service.MemberService;
import nst.springboot.restexample01.converter.impl.MemberConverter;
import nst.springboot.restexample01.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberConverter memberConverter;

    @Override
    public MemberDto save(MemberDto memberDto) throws Exception {
        if (memberDto == null) {
            throw new IllegalArgumentException("Member cannot be null!");
        }
        return memberConverter
                .toDto(memberRepository.save(memberConverter.toEntity(memberDto)));
    }

    @Override
    public List<MemberDto> getAll() {
        return memberRepository.findAll().stream()
                .map(entity -> memberConverter.toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public MemberDto update(MemberDto memberDto) throws Exception {
        if (memberDto == null || memberDto.getId() == null) {
            throw new IllegalArgumentException("Member Id cannot be null!");
        }
        memberRepository.findById(memberDto.getId())
                .orElseThrow(() -> new NoSuchElementException("Member does not exist!"));
        memberRepository.save(memberConverter.toEntity(memberDto));
        return memberDto;
    }

    @Override
    public boolean delete(Long id) throws Exception {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Member does not exist!"));
        memberRepository.delete(member);
        return true;
    }

    @Override
    public MemberDto findById(Long id) throws Exception {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Member does not exist!"));
        return memberConverter.toDto(member);
    }

}
