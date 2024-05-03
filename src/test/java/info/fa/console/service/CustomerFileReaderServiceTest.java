package info.fa.console.service;

import info.fa.console.util.Converter;
import info.fa.model.dto.CustomerDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerFileReaderServiceTest {

    CustomerFileReaderService service = new CustomerFileReaderService("uri", new Converter());

    @Test
    void readFile() {
        List<CustomerDto> list = service.readFile("customer.test.csv");
        assertEquals(9, list.size());
        assertEquals(CustomerDto.builder().customerRef("ref1")
                .customerName("Jake Green").addressLine1("Flat 2A")
                .addressLine2("234 Ballards Lane")
                .town("Finchley")
                .county("Greater London")
                .country("UK")
                .postcode("N3 2LY").build(),list.get(0));
        assertEquals(CustomerDto.builder().customerRef("ref2")
                .customerName("Neo").addressLine1("Flat 2B")
                .addressLine2("234 Ballards Lane")
                .town("Finchley")
                .county("Greater London")
                .country("UK")
                .postcode("N3 2LY").build(),list.get(1));
        assertEquals(CustomerDto.builder().customerRef("ref9")
                .customerName("Gandalf the bearer of bad news").addressLine1("38 High Street")
                .addressLine2("Mountain Walk")
                .town("Exeter")
                .county("Devon")
                .country("UK")
                .postcode("EX4 3LN").build(),list.get(8));
    }
}