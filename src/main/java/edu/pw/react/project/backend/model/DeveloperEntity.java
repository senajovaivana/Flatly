package edu.pw.react.project.backend.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "developer", schema = "public")
@Data
@Deprecated
public class DeveloperEntity {

    private static final long serialVersionUID = -1098893507296828343L;

    public static DeveloperEntity EMPTY = new DeveloperEntity();
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @Column(name = "login")
    @Size(min = 3, max = 100)
    private String login;

    @Column(name = "active")
    @Size(min = 1, max = 1)
    private boolean active;
}