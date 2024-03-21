package nst.springboot.restexample01.dto;

public class MemberDto implements DtoObject{

    private Long id;
    private String firstName;
    private String lastName;
    private DepartmentDto department;
    private EducationTitleDto educationTitle;
    private AcademicTitleDto academicTitle;
    private ScientificFieldDto scientificField;

    public MemberDto() {
    }

    public MemberDto(Long id, String firstName, String lastName, DepartmentDto department, EducationTitleDto educationTitle, AcademicTitleDto academicTitle, ScientificFieldDto scientificField) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.educationTitle = educationTitle;
        this.academicTitle = academicTitle;
        this.scientificField = scientificField;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public DepartmentDto getDepartment() {
        return department;
    }

    public EducationTitleDto getEducationTitle() {
        return educationTitle;
    }

    public AcademicTitleDto getAcademicTitle() {
        return academicTitle;
    }

    public ScientificFieldDto getScientificField() {
        return scientificField;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDepartment(DepartmentDto department) {
        this.department = department;
    }

    public void setEducationTitle(EducationTitleDto educationTitle) {
        this.educationTitle = educationTitle;
    }

    public void setAcademicTitle(AcademicTitleDto academicTitle) {
        this.academicTitle = academicTitle;
    }

    public void setScientificField(ScientificFieldDto scientificField) {
        this.scientificField = scientificField;
    }
    
}
