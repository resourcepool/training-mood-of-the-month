package io.takima.dao.models;

import java.time.LocalDate;

import lombok.*;


@Setter
@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class MOTM {

    private Integer uuid;
    private String title;
    private String message_template;
    private String page_template;
    private LocalDate created_at;
    private LocalDate updated_at;

    public MOTM(Integer uuid, String title, String message_template, String page_template) {
        this.uuid = uuid;
        this.title = title;
        this.message_template = message_template;
        this.page_template = page_template;
        this.created_at = java.time.LocalDate.now();
    }
}

