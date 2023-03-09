package io.takima.ProjectMOTM;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;


@Getter
@Setter
@EqualsAndHashCode
public class Employee {
    private Integer uuid;
    private String name;
    private String email;
    private Date birthdate;
    private LocalDate created_at;
    private LocalDate updated_at;
    public Employee(Integer uuid, String name, String email, Date dateBirth) {
        this.uuid = uuid;
        this.name = name;
        this.email = email;
        this.birthdate = dateBirth;
        this.created_at = java.time.LocalDate.now();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + uuid + '\'' +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthdate=" + birthdate +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
