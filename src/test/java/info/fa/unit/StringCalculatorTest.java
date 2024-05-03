package info.fa.unit;

import info.fa.unit.StringCalculator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class StringCalculatorTest {

    StringCalculator calculator = new StringCalculator();

    @Test
    void testAddEmpty() {
        assertEquals(0, calculator.add(""));
    }

    @Test
    void testAdd1number() {
        assertEquals(1, calculator.add("1"));
    }

    //1. Create a StringCalculator with a method Add(string numbers) that returns an integer.
    @Test
    void testAdd2numbers() {
        assertEquals(5, calculator.add("1", "4"));
    }

    //2. Allow the Add method to handle an unknown number of numbers (in the string).
    @Test
    void testAddComplexNumbers() {
        assertEquals(10, calculator.add("1", "4,5"));
    }

    //3. Allow the Add method to handle new lines between numbers (as well as commas):
    @Test
    void testAddComplexNumbersWhitespaces() {
        assertEquals(10, calculator.add("1", "4\n,5"));
    }

    //4. Allow the Add method to handle a different delimiter:
    @Test
    void testCustomDelimiter() {
        assertEquals(31, calculator.add("//;\n4;6", "//s\n4s6s10", "1"));
    }

    //5. Calling Add with a negative number will throw an exception "Negatives not allowed: " and then listing all negative numbers that were in the list of numbers.
    @Test
    void testNegativeNumber() {
        RuntimeException thrown = assertThrows(
                RuntimeException.class,
                () -> calculator.add("//;\n4;6", "//s\n4s6s10", "-1", "-3,4,-5"),
                "Expected doThing() to throw, but it didn't"
        );
        assertEquals("Negatives not allowed: [-1, -3, -5]", thrown.getMessage());
    }

    //6. Numbers greater than 1000 should be ignored.
    @Test
    void test1000plus() {
        assertEquals(2030, calculator.add("//;\n4;6", "//s\n4s6s10", "1001, 1000, 999", "1"));
    }

    //7. Delimiters can be any length, using this syntax: "//[|||]\n1|||2|||3" returns 6.
    @Test
    void testLongDelimiter() {
        assertEquals(31, calculator.add("//[;;;]\n4;;;6", "//s\n4s6s10", "1"));
    }

    //8. Allow multiple delimiters, using this syntax: "//[|][%]\n1|2%3" returns 6.
    //9. Handle multiple delimiters of any length.
    @Test
    void testLongDelimiters() {
        assertEquals(10, calculator.add("//[;;;][,,]\n1;;;2,,3", "4"));
    }


    //POC tests - not for PROD
    @Test
    void stringSplit() {
        List<String> result = Arrays.asList("1;;;2,,3".split("(;;;)|(,,)"));
        assertEquals("[1, 2, 3]", result.toString());
    }

    @Test
    void getOneDelimiters() {
        List<String> delimiters = calculator.getDelimiters(";");
        assertEquals(List.of(";"), delimiters);
        assertEquals(";",calculator.getDelimiterRegexp(delimiters));
    }

    @Test
    void getDelimiterInBrackets() {
        List<String> delimiters = calculator.getDelimiters("[;]");
        assertEquals(List.of(";"), delimiters);
        assertEquals(";",calculator.getDelimiterRegexp(delimiters));
    }

    @Test
    void get2DelimitersInBrackets() {
        List<String> delimiters = calculator.getDelimiters("[;;][,]");
        assertEquals(Arrays.asList(";;", ","), delimiters);
        assertEquals("(;;)|(,)",calculator.getDelimiterRegexp(delimiters));
    }

}