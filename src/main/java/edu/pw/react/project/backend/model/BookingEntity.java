package edu.pw.react.project.backend.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "booking", schema = "public")
@Data
public class BookingEntity {

    public static BookingEntity EMPTY = new BookingEntity();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "booking_id", updatable = false, nullable = false)
    private Long id;
    @Column(name = "owner_of_booking")
    @Size(min = 3, max = 40)
    private String owner_of_booking;
    @Column(name = "start_date")
    private Date start_date;
    @Column(name = "end_date")
    private Date end_date;
    @Column(name = "item_type")
    private char item_type;

    @Column(name = "item_id")
    private Long item_id;

    @Column(name = "active")
    private char active;

}
