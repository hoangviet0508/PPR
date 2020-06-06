package com.fptu.swp.ppr.entities.converters;

import com.fptu.swp.ppr.entities.Place;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Objects;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class PlaceTypeConverter implements AttributeConverter<Place.PlaceType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Place.PlaceType attribute) {
        if (Objects.isNull(attribute)) {
            throw new IllegalArgumentException();
        }
        return attribute.getValue();
    }

    @Override
    public Place.PlaceType convertToEntityAttribute(Integer dbData) {
        if (Objects.isNull(dbData)) {
            throw new IllegalArgumentException();
        }
        return Stream.of(Place.PlaceType.values())
                .filter(val -> dbData.equals(val.getValue()))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
