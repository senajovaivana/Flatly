package edu.pw.react.project.backend.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "booking", schema = "public")
@Data
public class BookingEntity {
    @Id
    @Column(name = "booking_id", updatable = false, nullable = false)
    private Long id;
    @Column(name = "owner_of_booking")
    private String owner_of_booking;
    @Column(name = "start_date")
    private Date start_date;
    @Column(name = "end_date")
    private Date end_date;
    @Column(name = "item_type")
    private char item_type;
    @Column(name = "item_id")
    private long item_id;
    @Column(name = "active")
    private char active;
}
