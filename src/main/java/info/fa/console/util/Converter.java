package info.fa.console.util;

import info.fa.model.dto.CustomerDto;
import org.springframework.stereotype.Component;

@Component
public class Converter {
    public CustomerDto convert(String[] values) {
        if (values == null) {
            throw new RuntimeException("values array is null");
        }
        if (values.length != 8) {
            throw new RuntimeException("invalid array");
        }
        return new CustomerDto(values[0], values[1], values[2],values[3]
                ,values[4], values[5], values[6], values[7]);
    }
}
