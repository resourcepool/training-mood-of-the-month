package io.takima.ProjectMOTM;

import lombok.*;
import java.util.Date;
import java.time.LocalDate;


@Setter
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class MOTM_Answer {
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
    private Integer uuid;
    private String message;
    private Grade grade;
    private Integer Employee_id;
    private Integer MOTM_id;
    private LocalDate created_at;
    private LocalDate updated_at;

    public MOTM_Answer(Integer uuid, String message, Grade grade, Integer Employee_id, Integer MOTM_id) {
        this.uuid = uuid;
        this.message = message;
        this.grade = grade;
        this.Employee_id = Employee_id;
        this.MOTM_id = MOTM_id;
        this.created_at = java.time.LocalDate.now();
    }

}