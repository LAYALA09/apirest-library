package ar.com.ada.online.second.library.model.mapper.converter;

import org.mapstruct.BeanMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.TargetType;
import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.Year;
import java.util.IdentityHashMap;
import java.util.Map;

@Converter(autoApply = true)
public class YearAttributeConverter implements AttributeConverter<Year, Short> {

    @Override
    public Short convertToDatabaseColumn(Year year) {
        // Short.valueOf(year.toString());

        return year != null
                ? (short) year.getValue()
                : null;
    }


    @Override
    public Year convertToEntityAttribute(Short dbShort) {
        return dbShort != null
                ? Year.of(dbShort)
                : null;
    }
}






