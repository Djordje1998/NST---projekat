package nst.springboot.restexample01.controller.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nst.springboot.restexample01.controller.domain.Member;
import nst.springboot.restexample01.controller.repository.AcademicTitleRepository;
import nst.springboot.restexample01.controller.repository.DepartmentRepository;
import nst.springboot.restexample01.controller.repository.EducationTitleRepository;
import nst.springboot.restexample01.controller.repository.MemberRepository;
import nst.springboot.restexample01.controller.repository.ScientificFieldRepository;
import nst.springboot.restexample01.controller.service.MemberService;
import nst.springboot.restexample01.converter.impl.AcademicTitleConverter;
import nst.springboot.restexample01.converter.impl.DepartmentConverter;
import nst.springboot.restexample01.converter.impl.EducationTitleConverter;
import nst.springboot.restexample01.converter.impl.MemberConverter;
import nst.springboot.restexample01.converter.impl.ScientificFieldConverter;
import nst.springboot.restexample01.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberConverter memberConverter;

    @Autowired
    private EducationTitleConverter educationTitleConverter;

    @Autowired
    private EducationTitleRepository educationTitleRepository;

    @Autowired
    private AcademicTitleConverter academicTitleConverter;

    @Autowired
    private AcademicTitleRepository academicTitleRepository;

    @Autowired
    private ScientificFieldConverter scientificFieldConverter;

    @Autowired
    private ScientificFieldRepository scientificFieldRepository;

    @Autowired
    private DepartmentConverter departmentConverter;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public MemberDto save(MemberDto memberDto) throws Exception {
        if (memberDto == null) {
            throw new IllegalArgumentException("Member cannot be null!");
        }
        memberDto.setId(null);
        return memberConverter.toDto(memberRepository.save(memberConverter.toEntity(this.fillDto(memberDto))));
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
        memberRepository.save(memberConverter.toEntity(this.fillDto(memberDto)));
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

    private MemberDto fillDto(MemberDto memberDto) {
        memberDto.setEducationTitle(educationTitleConverter.toDto(educationTitleRepository
                .findById(memberDto.getEducationTitle().getId())
                .orElseThrow(() -> new NoSuchElementException("Education Title does not exist!"))));
        memberDto.setAcademicTitle(academicTitleConverter.toDto(academicTitleRepository
                .findById(memberDto.getAcademicTitle().getId())
                .orElseThrow(() -> new NoSuchElementException("Academic Title does not exist!"))));
        memberDto.setScientificField(scientificFieldConverter.toDto(scientificFieldRepository
                .findById(memberDto.getScientificField().getId())
                .orElseThrow(() -> new NoSuchElementException("Scientific Field does not exist!"))));
        memberDto.setDepartment(departmentConverter.toDto(departmentRepository
                .findById(memberDto.getDepartment().getId())
                .orElseThrow(() -> new NoSuchElementException("Department does not exist!"))));
        return memberDto;
    }
}
