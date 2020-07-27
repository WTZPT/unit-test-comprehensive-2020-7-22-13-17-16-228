package example.service.impl;

import example.service.GenerateNumberService;

import java.util.Random;

public class GenerateTargetNumberHandle implements GenerateNumberService {

    public static final int TARGET_NUMBER_LENGTH = 4;

    @Override
    public String generateNumber() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int result = 0;
        Random random = new Random();
        int len = 9,index;
        for (int i = 0; i < TARGET_NUMBER_LENGTH; i++) {
            index = random.nextInt(len);
            result = result * 10 + array[index];
            array[index] = array[len--];
        }

        return String.valueOf(result);
    }
}
