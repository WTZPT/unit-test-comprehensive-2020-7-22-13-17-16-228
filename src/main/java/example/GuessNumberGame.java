package example;

import example.service.GenerateNumberService;

import java.text.MessageFormat;
import java.util.*;

public class GuessNumberGame {

    private GenerateNumberService generateTargetNumberHandle;
    private String[] targetNumber;
    private String targetNumberStr;
    private int surPlusTimes;
    private final int challenge = 6;
    private final String WRONG_INPUT = "Wrong Input，Input again";
    private final String SUR_PLUS_ZERO = "no challenge time! ";
    public GuessNumberGame(GenerateNumberService generateTargetNumberHandle) {
        this.generateTargetNumberHandle = generateTargetNumberHandle;
        initGuessNumberGame();
    }
    public void manMachineInteractionStart(){
        Scanner input = new Scanner(System.in);
        String inputVal= "";
        String res;
        do{
            System.out.println(MessageFormat.format("You have {0} chances left",this.surPlusTimes));
            inputVal = input.next();
            res = this.start(inputVal);
            if(res.equals(SUR_PLUS_ZERO)) {
                System.out.println(MessageFormat.format("The round of guessing game is over, and the target number is:{0}", targetNumberStr));
                initGuessNumberGame();
                System.out.println("-------------Into a new round---------------");
            }else if(res.equals("4A0B")){
                System.out.println(res);
                System.out.println(MessageFormat.format("Congratulations on your target number {0}",this.targetNumberStr));
                initGuessNumberGame();
                System.out.println("-------------Into a new round---------------");
            }else{
                System.out.println(res);
            }
        }while (!inputVal.equals("#"));
        System.out.println("You exit the game successfully!");
    }

    private void initGuessNumberGame(){
        targetNumberStr = this.generateTargetNumberHandle.generateNumber();
        targetNumber = Arrays.stream(targetNumberStr.split("")).toArray(String[]::new);
        this.surPlusTimes = challenge;
    }

    public String start(String guessNumber) {

        //TODO name
        CheckLegalVo checkLegalVo = checkLegal(guessNumber);
        if (checkLegalVo.isLegal()) {
            return targetNumber.equals(guessNumber) ? "4A0B" :  guessAlgorithmProcess(guessNumber);
        } else {
            return checkLegalVo.getMsg();
        }
    }

    private CheckLegalVo checkLegal(String guessNumber) {

        if(!checkSurplusTimes()){
            return new CheckLegalVo(false,SUR_PLUS_ZERO);
        } else if(!checkNumberFormat(guessNumber)){
            return new CheckLegalVo(false,WRONG_INPUT);
        }

        return new CheckLegalVo(true);
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
        if(surPlusTimes > 1 ) {
            surPlusTimes--;
            return true;
        }
        return false;
    }

    private String guessAlgorithmProcess(String guessNumber) {
        //TODO refactor ansA ansB
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


    class CheckLegalVo {
        private boolean isLegal;
        private String msg;

        public CheckLegalVo(boolean isLegal) {
            this.isLegal = isLegal;
        }

        public CheckLegalVo(boolean isLegal, String msg) {
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
