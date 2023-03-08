package io.takima.ProjectMOTM;

import java.time.LocalDate;

import lombok.*;
import org.hibernate.annotations.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Id;


@Table(name="MOTM", schema="projectmotm")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MOTM {

    //@Column(name="uuid", unique = true, nullable = false)
    //@GeneratedValue
    //@Id
    //private Integer uuid;
    @Column(name="title", nullable = false)
    private String title;
    @Column(name="message_template", nullable = false)
    private String message_template;
    @Column(name="page_template", nullable = false)
    private String page_template;
    @Column(name="created_at", nullable = false)
    private LocalDate created_at;
    @Column(name="updated_at", nullable = false)
    private LocalDate updated_at;

    public MOTM(String title, String message_template, String page_template) {
        this.title = title;
        this.message_template = message_template;
        this.page_template = page_template;
        this.created_at = java.time.LocalDate.now();
    }

    @Override
    public String toString() {
        return "MOTM{" +
                ", title='" + title + '\'' +
                ", message_template='" + message_template + '\'' +
                ", page_template='" + page_template + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}

