package nst.springboot.restexample01.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import nst.springboot.restexample01.dto.AcademicTitleDto;
import nst.springboot.restexample01.dto.DepartmentDto;
import nst.springboot.restexample01.dto.EducationTitleDto;
import nst.springboot.restexample01.dto.MemberDto;
import nst.springboot.restexample01.dto.ScientificFieldDto;
import nst.springboot.restexample01.dto.SubjectDto;
import nst.springboot.restexample01.service.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class MemberControllerTest {

    @Mock
    private MemberService memberService;

    @InjectMocks
    private MemberController memberController;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    private MemberDto memberDto;
    private MemberDto memberDto2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(memberController).build();
        objectMapper = new ObjectMapper();

        DepartmentDto departmentDto = new DepartmentDto(1L, "Department1", "DEP1", null, null);
        EducationTitleDto educationTitleDto = new EducationTitleDto(1L, "Education1");
        AcademicTitleDto academicTitleDto = new AcademicTitleDto(1L, "Academic1");
        ScientificFieldDto scientificFieldDto = new ScientificFieldDto(1L, "Scientific1");

        this.memberDto = new MemberDto(1L, "John", "Doe", departmentDto, educationTitleDto, academicTitleDto, scientificFieldDto);
        this.memberDto2 = new MemberDto(2L, "John2", "Doe2", departmentDto, educationTitleDto, academicTitleDto, scientificFieldDto);
    }

    @Test
    void testSave() throws Exception {

        when(memberService.save(any(MemberDto.class))).thenReturn(memberDto);

        mockMvc.perform(post("/member")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(memberDto)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(memberDto.getId()))
                .andExpect(jsonPath("$.firstName").value(memberDto.getFirstName()))
                .andExpect(jsonPath("$.lastName").value(memberDto.getLastName()))
                .andExpect(jsonPath("$.department.name").value(memberDto.getDepartment().getName()))
                .andExpect(jsonPath("$.educationTitle.name").value(memberDto.getEducationTitle().getName()));
    }

    @Test
    void testGetAll() throws Exception {

        List<MemberDto> memberDtos = new ArrayList<>();
        memberDtos.add(memberDto);
        memberDtos.add(memberDto2);

        when(memberService.getAll()).thenReturn(memberDtos);

        mockMvc.perform(get("/member"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(memberDtos.size()));
    }

    @Test
    void testFindById() throws Exception {

        Long memberId = 1L;

        when(memberService.findById(memberId)).thenReturn(memberDto);

        mockMvc.perform(get("/member/{id}", memberId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(memberDto.getId()))
                .andExpect(jsonPath("$.firstName").value(memberDto.getFirstName()))
                .andExpect(jsonPath("$.lastName").value(memberDto.getLastName()))
                .andExpect(jsonPath("$.department.name").value(memberDto.getDepartment().getName()))
                .andExpect(jsonPath("$.educationTitle.name").value(memberDto.getEducationTitle().getName()));
    }

    @Test
    void testUpdate() throws Exception {

        when(memberService.update(any(MemberDto.class))).thenReturn(memberDto);

        mockMvc.perform(patch("/member")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(memberDto)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(memberDto.getId()))
                .andExpect(jsonPath("$.firstName").value(memberDto.getFirstName()))
                .andExpect(jsonPath("$.lastName").value(memberDto.getLastName()))
                .andExpect(jsonPath("$.department.name").value(memberDto.getDepartment().getName()))
                .andExpect(jsonPath("$.educationTitle.name").value(memberDto.getEducationTitle().getName()));
    }

    @Test
    void testDelete() throws Exception {
        Long memberId = 1L;

        mockMvc.perform(delete("/member/{id}", memberId))
                .andExpect(status().isOk())
                .andExpect(content().string("Member removed!"));
    }
}
