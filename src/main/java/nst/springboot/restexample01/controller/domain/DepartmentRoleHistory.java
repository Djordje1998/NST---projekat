package nst.springboot.restexample01.controller.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "department_role_history")
public class DepartmentRoleHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @ManyToOne()
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne()
    @JoinColumn(name = "department_id")
    private Department department;

    private String role;

    public DepartmentRoleHistory() {
    }

    public DepartmentRoleHistory(Long id, Date startDate, Date endDate, Member member, Department department, String role) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.member = member;
        this.department = department;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
