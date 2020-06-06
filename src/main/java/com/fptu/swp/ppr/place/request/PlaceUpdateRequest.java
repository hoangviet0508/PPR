package com.fptu.swp.ppr.place.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fptu.swp.ppr.entities.Place;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PlaceUpdateRequest {
    private String name;
    private String location;
    private String description;
    private String imagePath;
    private String imageVrPath;
    private Place.PlaceType type;
}
