package com.fptu.swp.ppr.place.mapper;

import com.fptu.swp.ppr.entities.Place;
import com.fptu.swp.ppr.place.request.PlaceCreateRequest;
import com.fptu.swp.ppr.place.request.PlaceUpdateRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlaceMapper {
    Place requestCreateToEntity(PlaceCreateRequest request);
    Place requestUpdateToEntity(PlaceUpdateRequest request);
}
