package com.fptu.swp.ppr.entities.converters;

import com.fptu.swp.ppr.entities.UserInfo;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Objects;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class UserStatusConverter implements AttributeConverter<UserInfo.UserStatus, Integer> {
    @Override
    public Integer convertToDatabaseColumn(UserInfo.UserStatus attribute) {
        if (Objects.isNull(attribute))
            throw new IllegalArgumentException();
        return attribute.getValue();
    }

    @Override
    public UserInfo.UserStatus convertToEntityAttribute(Integer dbData) {
        if (Objects.isNull(dbData))
            throw new IllegalArgumentException();
        return Stream.of(UserInfo.UserStatus.values())
                .filter(value -> dbData.equals(value.getValue()))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
