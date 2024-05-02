package info.fa;

import org.junit.jupiter.api.Test;

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

    @Test
    void testAdd2numbers() {
        assertEquals(5, calculator.add("1", "4"));
    }

    @Test
    void testAddComplexNumbers() {
        assertEquals(10, calculator.add("1", "4,5"));
    }

    @Test
    void testAddComplexNumbersWhitespaces() {
        assertEquals(5, calculator.add("1", "4\\n,5"));
    }

}