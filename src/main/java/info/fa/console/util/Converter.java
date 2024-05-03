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
        return CustomerDto.builder().customerRef(values[0]).customerName(values[1])
                .addressLine1(values[2]).addressLine2(values[3])
                .town(values[4]).county(values[5]).country(values[6]).postcode(values[7]).build();
    }
}
