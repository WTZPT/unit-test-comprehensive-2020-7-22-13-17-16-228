package example;

import java.text.MessageFormat;
import java.util.Arrays;

public class GuessNumberGame {

    private String[] targetNumber;

    public GuessNumberGame(GenerateNumber targetNumberHandle) {
        targetNumber = Arrays.stream(targetNumberHandle.generateNumber().split("")).toArray(String[]::new);
    }

    public String start(String guessNumber) {

        return targetNumber.equals(guessNumber) ? "4A0B" :  guessAlgorithmProcess(guessNumber);
    }

    private String guessAlgorithmProcess(String guessNumber) {
        String[] guess = Arrays.stream(guessNumber.split("")).toArray(String[]::new);
        int ansB = (int)Arrays.stream(targetNumber).filter(o-> o.equals(guess[0]) || o.equals(guess[1])
                || o.equals(guess[2]) || o.equals(guess[3]) ).count();
        int ansA = 0;
        for(int i = 0; i < 4; i++) {
            if(targetNumber[i].equals(guess[i])) {
                ansA++;
            }
        }
        ansB = ansB - ansA;
        return MessageFormat.format("{0}A{1}B",ansA,ansB);
    }
}
