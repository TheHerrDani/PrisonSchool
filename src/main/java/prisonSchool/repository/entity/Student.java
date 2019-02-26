package prisonSchool.repository.entity;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer studentId;

    @Length(min = 1)
    private String name;

    @UpdateTimestamp
    private LocalDateTime dateOfModification;

    public Student() {
    }

    public Student(@Length(min = 1) String name) {
        this.name = name;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDateOfModification() {
        return dateOfModification;
    }
    
}
