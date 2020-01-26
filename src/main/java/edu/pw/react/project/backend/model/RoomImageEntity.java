package edu.pw.react.project.backend.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "room_image", schema = "public")
@Data
public class RoomImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name="id_room", nullable=false)
    @Size(min = 1)
    private FlatEntity roomID;

    @Column(name = "content")
    @Lob
    private byte[] fileImage;
}
