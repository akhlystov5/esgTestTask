package info.fa.util;

import info.fa.model.dto.CustomerDto;
import info.fa.rest.enitity.Customer;
import org.springframework.stereotype.Component;

@Component
public class Converter {
    public CustomerDto convertArray(String[] values) {
        if (values == null) {
            throw new RuntimeException("values array is null");
        }
        if (values.length != 8) {
            throw new RuntimeException("invalid array");
        }
        return new CustomerDto(values[0], values[1], values[2],values[3]
                ,values[4], values[5], values[6], values[7]);
    }

    public CustomerDto convert(Customer customer) {
        CustomerDto customerDto = new CustomerDto(customer.getCustomerRef(), customer.getCustomerName(),
                customer.getAddressLine1(), customer.getAddressLine2(), customer.getTown(), customer.getCounty(),
                customer.getCountry(), customer.getPostcode());
        return customerDto;
    }

}
