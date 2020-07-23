package example;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GuessNumberGameTest {

    private GenerateGuessGameTargetNumberHandle generateGuessGameTargetNumberHandle = mock(GenerateGuessGameTargetNumberHandle.class);


    @Test
    void should_Return_4A0B_when_Given_1234() {
        when(generateGuessGameTargetNumberHandle.generateNumber()).thenReturn("1234");
        GuessNumberGame guessNumberGame = new GuessNumberGame(generateGuessGameTargetNumberHandle);
        String except = "4A0B";
        String guessNumber = "1234";
        assertEquals(except,guessNumberGame.start(guessNumber));
    }


}
