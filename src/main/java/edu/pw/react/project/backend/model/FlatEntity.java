package edu.pw.react.project.backend.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "room")
@Data
public class FlatEntity {
    private static final long serialVersionUID = -1098893507296828343L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "owner_of_room")
    private String owner_of_room;
    @Column(name = "name_of_room")
    private String name_of_room;
    @Column(name = "start_date")
    private Date start_date;
    @Column(name = "end_date")
    private Date end_date;
    @Column(name = "description")
    private String description;
    @Column(name = "city")
    private String city;
    @Column(name = "street")
    private String street;
    @Column(name = "number_of_street")
    private String number_of_street;
    @Column(name = "zip_code")
    private String zip_code;
    @Column(name = "country")
    private String country;
    @Column(name = "price")
    private int price;
    @Column(name = "check_in_from")
    private Time check_in_from;
    @Column(name = "check_in_to")
    private Time check_in_to;
    @Column(name = "check_out")
    private Time check_out;
    @Column(name = "limit_of_quests")
    private int limit_of_quests;

}
