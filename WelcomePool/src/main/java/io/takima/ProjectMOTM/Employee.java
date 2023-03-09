package io.takima.ProjectMOTM;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;


@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Employee {

    // TODO : vérifier que dans la table Postgres on a une colonne Employee_id sans maj
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

    public Employee(String name, String email, Date birthdate) {
        this.name = name;
        this.email = email;
        this.birthdate = birthdate;
    }
}
