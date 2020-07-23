package example;

import java.util.Random;

public class GenerateGuessGameTargetNumber implements GenerateNumber {
    @Override
    public String generateNumber() {

        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
        int result = 0;
        Random random = new Random();
        for (int i = 0, len = 9, index = 0; i < 4; i++) {
            index = random.nextInt(len);
            result = result * 10 + array[index];
            array[index] = array[len--];
        }

        return String.valueOf(result);
    }
}
