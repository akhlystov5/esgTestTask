package info.fa.console.util;

import info.fa.model.dto.CustomerDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {

    Converter converter = new Converter();

    @Test
    void convertNull() {
        RuntimeException thrown = assertThrows(
                RuntimeException.class,
                () -> converter.convert(null),
                "Expected convert() to throw, but it didn't"
        );
        assertEquals("values array is null", thrown.getMessage());
    }

    @Test
    void convertEmpty() {
        RuntimeException thrown = assertThrows(
                RuntimeException.class,
                () -> converter.convert(new String[]{}),
                "Expected convert() to throw, but it didn't"
        );
        assertEquals("invalid array", thrown.getMessage());
    }

    @Test
    void convert4columns() {
        RuntimeException thrown = assertThrows(
                RuntimeException.class,
                () -> converter.convert(new String[]{}),
                "Expected convert() to throw, but it didn't"
        );
        assertEquals("invalid array", thrown.getMessage());
    }

    @Test
    void convert1row() {
        CustomerDto customerDto = converter.convert(new String[]{"ref1","Jake Green","Flat 2A","234 Ballards Lane","Finchley","Greater London","UK","N3 2LY"});
        assertEquals(CustomerDto.builder().customerRef("ref1")
                .customerName("Jake Green").addressLine1("Flat 2A")
                .addressLine2("234 Ballards Lane")
                .town("Finchley")
                .county("Greater London")
                .country("UK")
                .postcode("N3 2LY").build(), customerDto);
    }

}