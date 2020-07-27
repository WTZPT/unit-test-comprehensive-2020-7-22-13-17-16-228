package example.service.impl;

import example.service.GenerateNumberService;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GenerateTargetNumberHandleTest {
    private GenerateNumberService generateGuessGameTargetNumberHandle = new GenerateTargetNumberHandle();


    @Test
    void should_length_4_when_valid_target_number_length() {
        assertEquals(4, generateGuessGameTargetNumberHandle.generateNumber().length());
        assertEquals(4, generateGuessGameTargetNumberHandle.generateNumber().length());
        assertEquals(4, generateGuessGameTargetNumberHandle.generateNumber().length());
        assertEquals(4, generateGuessGameTargetNumberHandle.generateNumber().length());
    }

    @Test
    void should_four_numbers_when_valid_target_number() {
        String numberRegular = "\\d{4}";
        Pattern targetNumberPattern = Pattern.compile(numberRegular);
        assertTrue(targetNumberPattern.matcher(generateGuessGameTargetNumberHandle.generateNumber()).find());
        assertTrue(targetNumberPattern.matcher(generateGuessGameTargetNumberHandle.generateNumber()).find());
        assertTrue(targetNumberPattern.matcher(generateGuessGameTargetNumberHandle.generateNumber()).find());
        assertTrue(targetNumberPattern.matcher(generateGuessGameTargetNumberHandle.generateNumber()).find());
        assertTrue(targetNumberPattern.matcher(generateGuessGameTargetNumberHandle.generateNumber()).find());
        assertTrue(targetNumberPattern.matcher(generateGuessGameTargetNumberHandle.generateNumber()).find());
        assertTrue(targetNumberPattern.matcher(generateGuessGameTargetNumberHandle.generateNumber()).find());
        assertTrue(targetNumberPattern.matcher(generateGuessGameTargetNumberHandle.generateNumber()).find());
        assertTrue(targetNumberPattern.matcher(generateGuessGameTargetNumberHandle.generateNumber()).find());
        assertTrue(targetNumberPattern.matcher(generateGuessGameTargetNumberHandle.generateNumber()).find());
        assertTrue(targetNumberPattern.matcher(generateGuessGameTargetNumberHandle.generateNumber()).find());
        assertTrue(targetNumberPattern.matcher(generateGuessGameTargetNumberHandle.generateNumber()).find());
    }
}
