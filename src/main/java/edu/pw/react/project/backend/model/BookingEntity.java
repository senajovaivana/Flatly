package edu.pw.react.project.backend.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import edu.pw.react.project.backend.utils.JsonDateDeserializer;
import edu.pw.react.project.backend.utils.JsonDateSerializer;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "booking")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BookingEntity implements Serializable {

    public static BookingEntity EMPTY = new BookingEntity();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "owner_of_booking")
    private String owner_of_booking;

    @Column(name = "start_date", nullable = false)
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    private LocalDateTime start_date;
    @Column(name = "end_date", nullable = false)
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    private LocalDateTime end_date;

    @Column(name = "item_id", nullable = false)
    private int item_id;

    @Column(name = "active")
    private boolean active;


    public void setId(Long id) {
    }
}