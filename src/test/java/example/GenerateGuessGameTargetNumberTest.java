package example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GenerateGuessGameTargetNumberTest {
    private  GenerateNumber generateGuessGameTargetNumberHandle = new GenerateGuessGameTargetNumberHandle();


    @Test
    void should_Return_length_4_when_generate_number() {
        assertEquals(4, generateGuessGameTargetNumberHandle.generateNumber().length());
    }
}
