package example;

public class main {
    public static void main(String[] args) {
        GenerateNumber generateNumber = new GenerateGuessGameTargetNumberHandle();
        GuessNumberGame guessNumberGame = new GuessNumberGame(generateNumber);
        guessNumberGame.manMachineInteractionStart();
    }
}
