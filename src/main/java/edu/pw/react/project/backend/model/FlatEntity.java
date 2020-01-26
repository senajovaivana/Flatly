package edu.pw.react.project.backend.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

@Entity

@Table(name = "room", schema = "public")
@Data
public class FlatEntity {
    private static final long serialVersionUID = -1098893507296828343L;

    @Id
    @Column(name = "room_id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "owner_of_room")
    private int owner_of_room;

    @Column(name = "name_of_room")
    private String name_of_room;

    @Column(name = "start_date")
    private Date start_date;

    @Column(name = "active")
    @Size(min = 1, max = 1)
    private char active;

    @Column(name = "end_date")
    private Date end_date;

    @Column(name = "description")
    @Size(min = 1, max = 2000)
    private String description;

    @Column(name = "city")
    @Size(min = 1, max = 50)
    private String city;

    @Column(name = "street")
    @Size(min = 0, max = 50)
    private String street;

    @Column(name = "number_of_street")
    @Size(min = 0, max = 50)
    private String number_of_street;

    @Column(name = "number_of_block")
    @Size(min = 0, max = 50)
    private String number_of_block;

    @Column(name = "zip_code")
    @Size(min = 0, max = 10)
    private String zip_code;

    @Column(name = "country")
    @Size(min = 1, max = 50)
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id", referencedColumnName = "room_id")
    private ImageEntity room_image;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "payment_method_of_room",
            joinColumns = { @JoinColumn(name = "room_id") },
            inverseJoinColumns = { @JoinColumn(name = "payment_method_id") }
    )
    Set<PaymentMethodsEntity> payment_methods = new HashSet<>();

    @OneToMany(mappedBy="item_id")
    private Set<BookingEntity> room_bookings;
}