package io.takima.ProjectMOTM;

import java.util.UUID;
import java.util.Date;

public class Employee {
    private UUID uuid;
    private String name;
    private String email;
    private Date dateBirth;

    // Constructeur
    public Employee(String name, String email, Date dateBirth) {
        this.name = name;
        this.email = email;
        this.dateBirth = dateBirth;
        this.uuid = UUID.randomUUID();
    }

    // Getters et Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
