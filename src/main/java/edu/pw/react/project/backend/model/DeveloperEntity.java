package edu.pw.react.project.backend.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "developer", schema = "public")
@Data
public class DeveloperEntity {
    private static final long serialVersionUID = -1098893507296828343L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;
    @Column(name = "login")
    private String login;
    @Column(name = "active")
    private boolean active;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}