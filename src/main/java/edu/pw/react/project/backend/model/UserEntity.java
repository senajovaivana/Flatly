package edu.pw.react.project.backend.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user", schema = "public")
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "login")
    @Size(min = 3, max = 40)
    private String login;

    @Column(name = "password")
    @Size(min = 6, max = 80)
    private String password;

    @Column(name = "first_name")
    @Size(min = 0, max = 40)
    private String first_name;

    @Column(name = "last_name")
    @Size(min = 0, max = 40)
    private String last_name;

    @Column(name = "security_token")
    @Size(min = 200, max = 200)
    private String security_token;
}
