package example;

public class GuessNumberGame {

    private String targetNumber;

    public GuessNumberGame(GenerateNumber targetNumberHandle) {
        targetNumber = targetNumberHandle.generateNumber();
    }

    public String start(String guessNumber) {
        return "";
    }
}
