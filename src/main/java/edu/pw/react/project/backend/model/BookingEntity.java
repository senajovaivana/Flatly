package edu.pw.react.project.backend.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "booking", schema = "public")
@Data
public class BookingEntity {

    private static final long serialVersionUID = -1098893512396828343L;

    public static BookingEntity EMPTY = new BookingEntity();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "booking_id", updatable = false, nullable = false)
    private Long id;

    @NotNull(message = "Please provide the owner of booking.")
    @Column(name = "owner_of_booking")
    @Size(min = 3, max = 40)
    private String owner_of_booking;

    @NotNull(message = "Please provide the starting date for booking.")
    @Column(name = "start_date")
    private Date start_date;

    @NotNull(message = "Please provide the ending date for booking.")
    @Column(name = "end_date")
    private Date end_date;

    @NotNull(message = "Please provide item type equal to 'F'.")
    @Column(name = "item_type")
    private char item_type;

    @NotNull(message = "Please provide Apartment ID.")
    @Column(name = "item_id")
    private Long item_id;

    @NotNull(message = "Please provide active as 'T'")
    @Column(name = "active")
    private char active;
}
