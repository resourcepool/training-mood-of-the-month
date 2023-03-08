package io.takima.ProjectMOTM;

import lombok.*;
import org.hibernate.annotations.*;
import java.util.Date;
import java.time.LocalDate;
//import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Table;
//import javax.persistence.Id;


@Table(name="MOTM_Answer", schema="projectmotm")
@Setter
@Getter
@Entity
public class MOTM_Answer {

    /*@Column(name="uuid", unique = true, nullable = false)
    @GeneratedValue
    @Id
    private Integer uuid;*/
    @Column(name="message", nullable = false)
    private String message;
    @Column(name="grade", nullable = false)
    private Integer grade;
    @Column(name="Employee_id", nullable = false)
    private Integer Employee_id;
    @Column(name="MOTM_id", nullable = false)
    private Integer MOTM_id;
    @Column(name="created_at", nullable = false)
    private LocalDate created_at;
    @Column(name="updated_at", nullable = false)
    private Date updated_at;

    public MOTM_Answer(String message, Integer grade, Integer Employee_id, Integer MOTM_id) {
        this.message = message;
        this.grade = grade;
        this.Employee_id = Employee_id;
        this.MOTM_id = MOTM_id;
        this.created_at = java.time.LocalDate.now();
    }

}