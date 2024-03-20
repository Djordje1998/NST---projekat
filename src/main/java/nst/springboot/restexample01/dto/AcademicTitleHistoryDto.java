package nst.springboot.restexample01.dto;

import java.util.Date;

public class AcademicTitleHistoryDto {

    private Long id;
    private Date startDate;
    private Date endDate;
    private AcademicTitleDto academicTitle;
    private ScientificFieldDto scientificField;
    private MemberDto member;

    public AcademicTitleHistoryDto() {
    }

    public AcademicTitleHistoryDto(Long id, Date startDate, Date endDate, AcademicTitleDto academicTitle, ScientificFieldDto scientificField, MemberDto member) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.academicTitle = academicTitle;
        this.scientificField = scientificField;
        this.member = member;
    }

    public Long getId() {
        return id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public AcademicTitleDto getAcademicTitle() {
        return academicTitle;
    }

    public ScientificFieldDto getScientificField() {
        return scientificField;
    }

    public MemberDto getMember() {
        return member;
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

    public void setAcademicTitle(AcademicTitleDto academicTitle) {
        this.academicTitle = academicTitle;
    }

    public void setScientificField(ScientificFieldDto scientificField) {
        this.scientificField = scientificField;
    }

    public void setMember(MemberDto member) {
        this.member = member;
    }

}
