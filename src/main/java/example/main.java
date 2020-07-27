package example;

import example.service.GenerateNumberService;
import example.service.impl.GenerateTargetNumberHandle;

public class main {
    public static void main(String[] args) {
        GenerateNumberService generateNumberService = new GenerateTargetNumberHandle();
        ManMachineInteraction manMachineInteraction = new ManMachineInteraction(generateNumberService);
        manMachineInteraction.manMachineInteractionStart();
    }
}
