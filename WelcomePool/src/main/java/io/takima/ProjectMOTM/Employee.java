package io.takima.ProjectMOTM;

import java.time.LocalDate;
import java.util.Date;
import org.hibernate.annotations.*;
import lombok.*;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Id;



@Table(name="Employee", schema="projectmotm")
@Setter
@Getter
@Entity
public class Employee {
    //@Column(name="uuid", unique = true, nullable = false)
    //@GeneratedValue
    //@Id
    //private Integer uuid;
    @Column(name="name", nullable = false)
    private String name;
    @Column(name="email", nullable = false)
    private String email;
    @Column(name="birthdate", nullable = false)
    private Date birthdate;
    @Column(name="created_at", nullable = false)
    private LocalDate created_at;
    @Column(name="updated_at", nullable = false)
    private LocalDate updated_at;

    public Employee(String name, String email, Date dateBirth) {
        this.name = name;
        this.email = email;
        this.birthdate = dateBirth;
        this.created_at = java.time.LocalDate.now();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthdate=" + birthdate +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
