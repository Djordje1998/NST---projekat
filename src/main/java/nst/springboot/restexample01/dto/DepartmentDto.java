package nst.springboot.restexample01.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class DepartmentDto implements DtoObject {

    private Long id;
    @NotNull
    @Size(min = 5, max = 20, message = "Number of characters [5-20]")
    private String name;
    @NotNull
    @Size(min = 2, max = 5, message = "number of characters [2-5]")
    private String shortName;
    private Long managerId;
    private Long secretaryId;

    public DepartmentDto() {
    }

    public DepartmentDto(Long id, String name, String shortName, Long managerId, Long secretaryId) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
        this.managerId = managerId;
        this.secretaryId = secretaryId;
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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public Long getSecretaryId() {
        return secretaryId;
    }

    public void setSecretaryId(Long secretaryId) {
        this.secretaryId = secretaryId;
    }

}
