package com.fptu.swp.ppr.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "place")
@Getter
@Setter
@NoArgsConstructor
public class Place implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "description")
    private String description;

    @Column(name="image_path")
    private String imagePath;

    @Column(name = "image_vr_path")
    private String imageVrPath;

    @Column(name = "type")
    @Enumerated(EnumType.ORDINAL)
    private PlaceType type;

    @Getter
    public enum PlaceType {
        MEETING_ROOM(0), CONFERENCE_ROOM(1), HALL(2);
        PlaceType(int value) {
            this.value = value;
        }
        private final int value;
    }

}
