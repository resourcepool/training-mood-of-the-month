package io.takima.dao.models;

import lombok.*;
import java.util.Date;
import java.time.LocalDate;
import java.util.UUID;
//import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Id;


@Table(name="MOTM_Answer", schema="projectmotm")
@Setter
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class MOTM_Answer {

    // TODO : vérifier que dans la table Postgres on a une colonne MOTM_id

    // TODO : MOTM_Answer : corriger le constructeur

    public enum Grade {
        A(5.0),
        B(4.0),
        C(3.0),
        D(2.0),
        E(1.0);

        private double value;

        Grade(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }

        public static Grade fromValue(double value) {
            for (Grade grade : values()) {
                if (grade.value == value) {
                    return grade;
                }
            }
            throw new IllegalArgumentException("No grade with value " + value);
        }
    }
    private String uuid;
    private String message;
    private Grade grade;
    private String Employee_id;
    private String MOTM_id;
    private LocalDate created_at;
    private LocalDate updated_at;

    public MOTM_Answer(String message, Grade grade, String Employee_id, String MOTM_id, LocalDate created_at, LocalDate updated_at) {
        this.uuid = UUID.randomUUID().toString();
        this.message = message;
        this.grade = grade;
        this.Employee_id = Employee_id;
        if (MOTM_id != null) {
            this.MOTM_id = MOTM_id;
        } else
        {
            this.MOTM_id = "1";
        }
        this.created_at = java.time.LocalDate.now();
        this.updated_at = java.time.LocalDate.now();
    }

    public MOTM_Answer() {
        this.uuid = UUID.randomUUID().toString();
        this.MOTM_id = "1";
        this.created_at = java.time.LocalDate.now();
        this.updated_at = java.time.LocalDate.now();
    }
}