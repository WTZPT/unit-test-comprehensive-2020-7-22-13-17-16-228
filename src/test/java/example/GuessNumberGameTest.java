package example;





import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GuessNumberGameTest {
    private final String WRONG_INPUT = "Wrong Input，Input again";
    private final String SUR_PLUS_ZERO = "no challenge time! ";
    private GenerateGuessGameTargetNumberHandle generateGuessGameTargetNumberHandle = mock(GenerateGuessGameTargetNumberHandle.class);

    @Test
   @DisplayName("存在全部的目标数,且位置全正确")
    void should_Return_4A0B_when_Given_1234() {
        when(generateGuessGameTargetNumberHandle.generateNumber()).thenReturn("1234");
        GuessNumberGame guessNumberGame = new GuessNumberGame(generateGuessGameTargetNumberHandle);
        String except = "4A0B";
        String guessNumber = "1234";
        assertEquals(except,guessNumberGame.start(guessNumber));
    }

    @Test
    @DisplayName("存在全部的目标数,但位置部分对")
    void should_Return_2A2B_when_Given_1243(){
        when(generateGuessGameTargetNumberHandle.generateNumber()).thenReturn("1234");
        GuessNumberGame guessNumberGame = new GuessNumberGame(generateGuessGameTargetNumberHandle);
        String except = "2A2B";
        String guessNumber = "1243";
        assertEquals(except,guessNumberGame.start(guessNumber));
    }

    @Test
    @DisplayName("存在部分的目标数,且位置部分对")
    void should_Return_1A2B_when_Given_1345(){
        when(generateGuessGameTargetNumberHandle.generateNumber()).thenReturn("1234");
        GuessNumberGame guessNumberGame = new GuessNumberGame(generateGuessGameTargetNumberHandle);
        String except = "1A2B";
        String guessNumber = "1345";
        assertEquals(except,guessNumberGame.start(guessNumber));
    }

    @Test
    @DisplayName("存在部分的目标数,且位置部分对")
    void should_Return_2A0B_when_Given_1256(){
        when(generateGuessGameTargetNumberHandle.generateNumber()).thenReturn("1234");
        GuessNumberGame guessNumberGame = new GuessNumberGame(generateGuessGameTargetNumberHandle);
        String except = "2A0B";
        String guessNumber = "1256";
        assertEquals(except,guessNumberGame.start(guessNumber));
    }

    @Test
    @DisplayName("存在全部的目标数,但位置都不对")
    void should_Return_0A4B_when_Given_4321(){
        when(generateGuessGameTargetNumberHandle.generateNumber()).thenReturn("1234");
        GuessNumberGame guessNumberGame = new GuessNumberGame(generateGuessGameTargetNumberHandle);
        String except = "0A4B";
        String guessNumber = "4321";
        assertEquals(except,guessNumberGame.start(guessNumber));
    }

    @Test
    @DisplayName("存在部分的目标数&且位置都不对")
    void should_Return_0A2B_when_Given_4378() {
        when(generateGuessGameTargetNumberHandle.generateNumber()).thenReturn("1234");
        GuessNumberGame guessNumberGame = new GuessNumberGame(generateGuessGameTargetNumberHandle);
        String except = "0A2B";
        String guessNumber = "4378";
        assertEquals(except,guessNumberGame.start(guessNumber));
    }

    @Test
    void should_Return_WRONG_INPUT_when_Given_123(){
        when(generateGuessGameTargetNumberHandle.generateNumber()).thenReturn("1234");
        GuessNumberGame guessNumberGame = new GuessNumberGame(generateGuessGameTargetNumberHandle);
        String except = WRONG_INPUT;
        String guessNumber = "123";
        assertEquals(except,guessNumberGame.start(guessNumber));
    }

}
