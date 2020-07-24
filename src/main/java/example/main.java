package example;

import example.service.impl.GenerateTargetNumberHandle;
import example.service.GenerateNumberService;
import example.service.impl.GuessNumberGameImpl;

public class main {
    public static void main(String[] args) {
        GenerateNumberService generateNumberService = new GenerateTargetNumberHandle();
        GuessNumberGameImpl guessNumberGameImpl = new GuessNumberGameImpl(generateNumberService);
        guessNumberGameImpl.manMachineInteractionStart();
    }
}
