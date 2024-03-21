package nst.springboot.restexample01.controller.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "department")
public class Department implements EntityObject{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message = "Name is mandatory field")
    @Size(min = 5, max = 20, message = "Number of characters is from 5 to 20")
    private String name;

    @NotEmpty(message = "ShortName is mandatory field")
    @Size(min = 2, max = 5, message = "Number of characters is from 2 to 5")
    @Column(name = "short_name")
    private String shortName;

    @OneToOne
    @JoinColumn(name = "manager_id")
    private Member manager;

    @OneToOne
    @JoinColumn(name = "secretary_id")
    private Member secretary;

    public Department() {
    }

    public Department(Long id, String name, String shortName) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
    
}
