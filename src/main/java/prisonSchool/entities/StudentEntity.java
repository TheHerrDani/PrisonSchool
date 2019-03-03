package prisonSchool.entities;

import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer studentId;

    @Length(min = 1)
    private String name;

    @UpdateTimestamp
    private LocalDateTime dateOfModification;

    public StudentEntity() {
    }

    public StudentEntity(@Length(min = 1) String name) {
        this.name = name;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getDateOfModification() {
        return dateOfModification;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public void setDateOfModification(LocalDateTime dateOfModification) {
        this.dateOfModification = dateOfModification;
    }
}
