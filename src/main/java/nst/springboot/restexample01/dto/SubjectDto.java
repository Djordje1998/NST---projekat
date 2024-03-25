package nst.springboot.restexample01.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class SubjectDto implements DtoObject {
     
    private Long id;
    @NotNull
    @Size(min = 2,max = 10, message = "Number of characters [2-10]")
    private String name;
    private int esbp;
    @NotNull
    private DepartmentDto departmentDto;

    public SubjectDto() {
    }

    public SubjectDto(Long id, String name, int esbp, DepartmentDto departmentDto) {
        this.id = id;
        this.name = name;
        this.esbp = esbp;
        this.departmentDto = departmentDto;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEsbp() {
        return esbp;
    }

    public void setEsbp(int esbp) {
        this.esbp = esbp;
    }

    public DepartmentDto getDepartmentDto() {
        return departmentDto;
    }

    public void setDepartmentDto(DepartmentDto departmentDto) {
        this.departmentDto = departmentDto;
    }

}
