import com.fasterxml.jackson.databind.ObjectMapper;
import nst.springboot.restexample01.controller.SubjectController;
import nst.springboot.restexample01.dto.DepartmentDto;
import nst.springboot.restexample01.dto.SubjectDto;
import nst.springboot.restexample01.service.SubjectService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class SubjectControllerTest {

    @InjectMocks
    private SubjectController subjectController;

    @Mock
    private SubjectService subjectService;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(subjectController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void testSave() throws Exception {
        SubjectDto subjectDto = new SubjectDto(1L, "Test1", 5, new DepartmentDto());

        when(subjectService.save(any(SubjectDto.class))).thenReturn(subjectDto);

        mockMvc.perform(post("/subject")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(subjectDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(subjectDto.getId()))
                .andExpect(jsonPath("$.name").value(subjectDto.getName()))
                .andExpect(jsonPath("$.esbp").value(subjectDto.getEsbp()));
    }

    @Test
    void testGetAll() throws Exception {
        List<SubjectDto> subjectDtoList = new ArrayList<>();
        subjectDtoList.add(new SubjectDto(1L, "Test1", 5, new DepartmentDto()));
        subjectDtoList.add(new SubjectDto(2L, "Test2", 6, new DepartmentDto()));

        when(subjectService.getAll()).thenReturn(subjectDtoList);

        mockMvc.perform(get("/subject"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(subjectDtoList.size()));
    }

    @Test
    void testFindById() throws Exception {
        Long id = 1L;
        SubjectDto subjectDto = new SubjectDto(1L, "Test", 5, new DepartmentDto());

        when(subjectService.findById(id)).thenReturn(subjectDto);

        mockMvc.perform(get("/subject/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(subjectDto.getId()))
                .andExpect(jsonPath("$.name").value(subjectDto.getName()));
    }

    @Test
    void testUpdate() throws Exception {
        SubjectDto subjectDto = new SubjectDto(1L, "Test", 5, new DepartmentDto());

        when(subjectService.update(any(SubjectDto.class))).thenReturn(subjectDto);

        mockMvc.perform(patch("/subject")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(subjectDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(subjectDto.getId()))
                .andExpect(jsonPath("$.name").value(subjectDto.getName()));
    }

    @Test
    void testDelete() throws Exception {
        Long id = 1L;

        mockMvc.perform(delete("/subject/{id}", id))
                .andExpect(status().isOk())
                .andExpect(content().string("Subject removed!"));
    }
}
