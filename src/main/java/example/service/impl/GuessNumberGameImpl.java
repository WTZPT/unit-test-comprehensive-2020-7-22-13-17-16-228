package example.service.impl;

import example.service.GenerateNumberService;
import example.service.GuessNumberGame;
import example.service.vo.CheckedResult;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public class GuessNumberGameImpl implements GuessNumberGame {

    public static final String FOUR_NUMBER_REGEX = "\\d{4}";
    private GenerateNumberService generateTargetNumberHandle;
    private String[] targetNumber;
    private String targetNumberStr;
    private int surPlusTimes;
    private final int challenge = 6;
    public static final String WRONG_INPUT = "Wrong Input,Input again";
    public static final String SUR_PLUS_ZERO = "no challenge time!";

    public GuessNumberGameImpl(GenerateNumberService generateTargetNumberHandle) {
        this.generateTargetNumberHandle = generateTargetNumberHandle;
        initGuessNumberGame();
    }

    public int getSurPlusTimes() {
        return surPlusTimes;
    }

    public String getTargetNumberStr() {
        return targetNumberStr;
    }

    @Override
    public void initGuessNumberGame() {
        targetNumberStr = this.generateTargetNumberHandle.generateNumber();
        targetNumber = Arrays.stream(targetNumberStr.split("")).toArray(String[]::new);
        this.surPlusTimes = challenge;
    }

    @Override
    public String start(String guessNumber) {
        CheckedResult checkedResult = checkLegal(guessNumber);
        if (checkedResult.isLegal()) {
            return targetNumber.equals(guessNumber) ? "4A0B" : guessAlgorithmProcess(guessNumber);
        } else {
            return checkedResult.getMsg();
        }
    }

    private CheckedResult checkLegal(String guessNumber) {

        if (!checkSurplusTimes()) {
            return new CheckedResult(false, SUR_PLUS_ZERO);
        } else if (!checkNumberFormat(guessNumber)) {
            return new CheckedResult(false, WRONG_INPUT);
        }

        return new CheckedResult(true);
    }

    private boolean checkNumberFormat(String guessNumber) {
        return (guessNumber.length() == 4 && figureChecking(guessNumber) && duplicateChecking(guessNumber));
    }

    private boolean figureChecking(String guessNumber) {
        Pattern pattern = compile(FOUR_NUMBER_REGEX);
        return pattern.matcher(guessNumber).find();
    }

    private boolean duplicateChecking(String guessNumber) {
        return Arrays.stream(guessNumber.split("")).distinct().count() == 4;
    }

    private boolean checkSurplusTimes() {
        if (surPlusTimes > 1) {
            surPlusTimes--;
            return true;
        }
        return false;
    }

    private String guessAlgorithmProcess(String guessNumber) {

        String[] guess = Arrays.stream(guessNumber.split("")).toArray(String[]::new);
        int valueAccordCount = (int) Arrays.stream(targetNumber).filter(o -> o.equals(guess[0]) || o.equals(guess[1])
                || o.equals(guess[2]) || o.equals(guess[3])).count();
        int valueAndPositionAccordCount = 0;
        for (int i = 0; i < 4; i++) {
            if (targetNumber[i].equals(guess[i])) {
                valueAndPositionAccordCount++;
            }
        }
        valueAccordCount = valueAccordCount - valueAndPositionAccordCount;
        return MessageFormat.format("{0}A{1}B", valueAndPositionAccordCount, valueAccordCount);
    }

}
