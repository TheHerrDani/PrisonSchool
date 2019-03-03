package prisonSchool.domains;

import java.time.LocalDateTime;

public class StudentDomain {
    private Integer studentId;

    private String name;

    private LocalDateTime dateOfModification;

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

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public void setDateOfModification(LocalDateTime dateOfModification) {
        this.dateOfModification = dateOfModification;
    }
}
