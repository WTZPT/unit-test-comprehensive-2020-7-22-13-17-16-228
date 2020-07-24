package example;

import example.service.GenerateTargetNumberHandle;
import example.service.GenerateNumberService;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void should_four_numbers_when_valid_target_number(){
        String numberRegular = "\\d{4}";
        Pattern targetNumberPattern = Pattern.compile(numberRegular);
        assertEquals(true,targetNumberPattern.matcher(generateGuessGameTargetNumberHandle.generateNumber()).find());
        assertEquals(true,targetNumberPattern.matcher(generateGuessGameTargetNumberHandle.generateNumber()).find());
        assertEquals(true,targetNumberPattern.matcher(generateGuessGameTargetNumberHandle.generateNumber()).find());
        assertEquals(true,targetNumberPattern.matcher(generateGuessGameTargetNumberHandle.generateNumber()).find());
        assertEquals(true,targetNumberPattern.matcher(generateGuessGameTargetNumberHandle.generateNumber()).find());
        assertEquals(true,targetNumberPattern.matcher(generateGuessGameTargetNumberHandle.generateNumber()).find());
        assertEquals(true,targetNumberPattern.matcher(generateGuessGameTargetNumberHandle.generateNumber()).find());
        assertEquals(true,targetNumberPattern.matcher(generateGuessGameTargetNumberHandle.generateNumber()).find());
        assertEquals(true,targetNumberPattern.matcher(generateGuessGameTargetNumberHandle.generateNumber()).find());
        assertEquals(true,targetNumberPattern.matcher(generateGuessGameTargetNumberHandle.generateNumber()).find());
        assertEquals(true,targetNumberPattern.matcher(generateGuessGameTargetNumberHandle.generateNumber()).find());
        assertEquals(true,targetNumberPattern.matcher(generateGuessGameTargetNumberHandle.generateNumber()).find());
    }
}
