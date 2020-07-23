package example;

import java.text.MessageFormat;
import java.util.*;

public class GuessNumberGame {

    private GenerateNumber generateTargetNumberHandle;
    private String[] targetNumber;
    private int surPlusTimes;
    private final int challenge = 6;
    private final String WRONG_INPUT = "Wrong Input，Input again";
    private final String SUR_PLUS_ZERO = "no challenge time! ";
    public GuessNumberGame(GenerateNumber generateTargetNumberHandle) {
        this.generateTargetNumberHandle = generateTargetNumberHandle;
        initGuessNumberGame();
    }

    private void initGuessNumberGame(){
        targetNumber = Arrays.stream(this.generateTargetNumberHandle.generateNumber().split("")).toArray(String[]::new);
        this.surPlusTimes = challenge;
    }

    public String start(String guessNumber) {
        checkLegalVo checkLegalVo = checkLegal(guessNumber);
        if (checkLegalVo.isLegal()) {
            return targetNumber.equals(guessNumber) ? "4A0B" :  guessAlgorithmProcess(guessNumber);
        } else {
            return checkLegalVo.getMsg();
        }
    }

    private checkLegalVo checkLegal(String guessNumber) {

        if(!checkSurplusTimes()){
            return new checkLegalVo(false,SUR_PLUS_ZERO);
        } else if(!checkNumberFormat(guessNumber)){
            return new checkLegalVo(false,WRONG_INPUT);
        }

        return new checkLegalVo(true);
    }

    private boolean checkNumberFormat(String guessNumber) {
        return (guessNumber.length() == 4 && duplicateChecking(guessNumber) );
    }

    private boolean duplicateChecking(String guessNumber) {
        Set<String> guessNumberSet = new HashSet<>();
        for(String str : guessNumber.split("")){
            if(guessNumberSet.contains(str)) {
                return false;
            }
            guessNumberSet.add(str);
        }
        return true;
    }

    private boolean checkSurplusTimes() {
        if(surPlusTimes > 0 ) {
            surPlusTimes--;
            return true;
        }
        return false;
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


    class checkLegalVo{
        private boolean isLegal;
        private String msg;

        public checkLegalVo(boolean isLegal) {
            this.isLegal = isLegal;
        }

        public checkLegalVo(boolean isLegal, String msg) {
            this.isLegal = isLegal;
            this.msg = msg;
        }

        public boolean isLegal() {
            return isLegal;
        }

        public void setLegal(boolean legal) {
            isLegal = legal;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
}
