package edu.pw.react.project.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import edu.pw.react.project.backend.utils.JsonDateDeserializer;
import edu.pw.react.project.backend.utils.JsonDateSerializer;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "booking")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BookingEntity implements Serializable {

    public static BookingEntity EMPTY = new BookingEntity();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @Column(name = "owner_of_booking")
    @Size(min = 3, max = 40)
    private String login;

    @Column(name = "start_date", nullable = false)
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    private LocalDateTime start_date;

    @Column(name = "end_date", nullable = false)
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    private LocalDateTime end_date;

    @Column(name = "item_type")
    @Size(min = 1, max = 1)
    private String itemType;

    @ManyToOne
    @Size(min = 1)
    private BookingEntity itemId;

    @Column(name = "active")
    @Size(min = 1, max = 1)
    private String active;
}