package example;

import example.service.GenerateNumberService;
import example.service.impl.GuessNumberGameImpl;

import java.text.MessageFormat;
import java.util.Scanner;

import static example.service.impl.GuessNumberGameImpl.SUR_PLUS_ZERO;

public class ManMachineInteraction {

    private GuessNumberGameImpl guessNumberGame;

    public ManMachineInteraction(GenerateNumberService generateNumberService) {
        this.guessNumberGame = new GuessNumberGameImpl(generateNumberService);
    }

    public void manMachineInteractionStart() {
        Scanner input = new Scanner(System.in);
        String inputVal = "";
        String res;
        do {
            System.out.println(MessageFormat.format("You have {0} chances left", this.guessNumberGame.getSurPlusTimes()));
            inputVal = input.next();
            res = this.guessNumberGame.start(inputVal);
            if (res.equals(SUR_PLUS_ZERO)) {
                System.out.println(MessageFormat.format("The round of guessing game is over, and the target number is:{0}", this.guessNumberGame.getTargetNumberStr()));
                this.guessNumberGame.initGuessNumberGame();
                System.out.println("-------------Into a new round---------------");
            } else if (res.equals("4A0B")) {
                System.out.println(res);
                System.out.println(MessageFormat.format("Congratulations on your target number {0}", this.guessNumberGame.getTargetNumberStr()));
                this.guessNumberGame.initGuessNumberGame();
                System.out.println("-------------Into a new round---------------");
            } else {
                System.out.println(res);
            }
        } while (!inputVal.equals("#"));
        System.out.println("You exit the game successfully!");
    }
}
