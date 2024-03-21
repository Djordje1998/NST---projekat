package nst.springboot.restexample01.dto;

public class ScientificFieldDto implements DtoObject{

    private Long id;
    private String name;

    public ScientificFieldDto() {
    }

    public ScientificFieldDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

}
