package prisonSchool.controller.models;

import java.time.LocalDateTime;

public class StudentModel {
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
}
