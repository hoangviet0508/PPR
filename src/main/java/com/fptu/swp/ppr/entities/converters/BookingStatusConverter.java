package com.fptu.swp.ppr.entities.converters;

import com.fptu.swp.ppr.entities.Booking;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Objects;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class BookingStatusConverter implements AttributeConverter<Booking.BookingStatus,Integer> {
    @Override
    public Integer convertToDatabaseColumn(Booking.BookingStatus attribute) {
        if (Objects.isNull(attribute)) {
            throw new IllegalArgumentException();
        }
        return attribute.getValue();
    }

    @Override
    public Booking.BookingStatus convertToEntityAttribute(Integer dbData) {
        if (Objects.isNull(dbData)) {
            throw new IllegalArgumentException();
        }
        return Stream.of(Booking.BookingStatus.values())
                .filter(val -> dbData.equals(val.getValue()))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
