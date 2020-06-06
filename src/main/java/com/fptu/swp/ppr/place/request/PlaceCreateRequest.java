package com.fptu.swp.ppr.place.request;

import com.fptu.swp.ppr.entities.Place;
import lombok.Data;

import java.io.Serializable;

@Data
public class PlaceCreateRequest implements Serializable {
    private String name;
    private String location;
    private String description;
    private String imagePath;
    private String imageVrPath;
    private Place.PlaceType type;
}
