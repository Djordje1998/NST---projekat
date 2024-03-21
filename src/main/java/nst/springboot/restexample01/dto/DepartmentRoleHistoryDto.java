package nst.springboot.restexample01.dto;

import java.util.Date;

public class DepartmentRoleHistoryDto implements DtoObject{

    private Long id;
    private Date startDate;
    private Date endDate;
    private DepartmentDto department;
    private MemberDto member;
    private String role;

    public DepartmentRoleHistoryDto() {
    }

    public DepartmentRoleHistoryDto(
            Long id,
            Date startDate,
            Date endDate,
            DepartmentDto department,
            MemberDto member,
            String role) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.department = department;
        this.member = member;
        this.role = role;
    }

    @Override
    public Long getId() {
        return id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public DepartmentDto getDepartment() {
        return department;
    }

    public MemberDto getMember() {
        return member;
    }

    public String getRole() {
        return role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setDepartment(DepartmentDto department) {
        this.department = department;
    }

    public void setMember(MemberDto member) {
        this.member = member;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
