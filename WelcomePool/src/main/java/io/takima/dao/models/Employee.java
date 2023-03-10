package io.takima.dao.models;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;


@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Employee {

    // TODO : vérifier que dans la table Postgres on a une colonne Employee_id sans maj

    // TODO : corriger les Date en LocalDate

    private String uuid;
    private String name;
    private String email;
    private LocalDate birthdate;
    private LocalDate created_at;
    private LocalDate updated_at;

    public Employee(String uuid, String name, String email, LocalDate birthdate, LocalDate created_at, LocalDate updated_at) {
        this.uuid = uuid;
        this.name = name;
        this.email = email;
        this.birthdate = birthdate;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Employee(String name, String email, LocalDate birthdate) {
        this.uuid = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.birthdate = birthdate;
        this.created_at = LocalDate.now();
        this.updated_at = LocalDate.now();
    }
}
