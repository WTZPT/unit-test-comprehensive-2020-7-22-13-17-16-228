package example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeneratGuessGameTargetNumberTest {
    private  GenerateNumber guessTargetNumber = new GenerateGuessGameTargetNumberHandle();

    @Test
    void should_Return_4A0B_when_Given_1234() {
        assertEquals(4,guessTargetNumber.generateNumber().length());
    }
}
