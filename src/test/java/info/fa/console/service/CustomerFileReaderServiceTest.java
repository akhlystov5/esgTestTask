package info.fa.console.service;

import info.fa.util.Converter;
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
        assertEquals(new CustomerDto("ref1"
                ,"Jake Green","Flat 2A"
                ,"234 Ballards Lane"
                ,"Finchley"
                ,"Greater London"
                ,"UK"
                ,"N3 2LY"),list.get(0));
        assertEquals(new CustomerDto( "ref2"
                ,"Neo","Flat 2B"
                ,"234 Ballards Lane"
                ,"Finchley"
                ,"Greater London"
                ,"UK"
                ,"N3 2LY"),list.get(1));
        assertEquals(new CustomerDto("ref9"
                ,"Gandalf the bearer of bad news","38 High Street"
                ,"Mountain Walk"
                ,"Exeter"
                ,"Devon"
                ,"UK"
                ,"EX4 3LN"),list.get(8));
    }
}