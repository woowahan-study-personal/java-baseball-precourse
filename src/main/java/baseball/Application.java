package baseball;

import java.util.Scanner;
import utils.RandomUtils;
import utils.ReGame;
import view.InputView;

public class Application {
    private static final int NUMBER_OF_DIGIT = 3;
    private static final int START_OF_RAND_NUMBER = 0;
    private static final int END_OF_RAND_NUMBER = 9;
    private static final int LENGTH_OF_POSSIBLE_NUMBER = 10;

    public static int[] getRandomNumbers() {
        int[] numbers = new int[NUMBER_OF_DIGIT];
        boolean[] visitNumbers = new boolean[LENGTH_OF_POSSIBLE_NUMBER];
        for (int i = 0; i < NUMBER_OF_DIGIT; i++) {
            int validNumber = makeValidNum(i, visitNumbers);
            numbers[i] = validNumber;
            visitNumbers[validNumber] = true;
        }
        return numbers;
    }

    public static int makeValidNum(int idx, boolean[] visitNumbers) {
        while (true) {
            int number = RandomUtils.nextInt(START_OF_RAND_NUMBER, END_OF_RAND_NUMBER);
            if (idx == 0 & number == 0) {
                continue;
            }
            if (visitNumbers[number]) {
                continue;
            }
            return number;
        }
    }

    public static int[] userNumbersToArray(int userNumbers) {
        int[] userNumberArray = new int[NUMBER_OF_DIGIT];
        for (int i=0; i < NUMBER_OF_DIGIT; i++) {
            userNumberArray[i] = (int) (userNumbers / Math.pow(10, NUMBER_OF_DIGIT-1-i));
            userNumbers %= Math.pow(10, NUMBER_OF_DIGIT-1-i);
        }
        return userNumberArray;
    }

    public static void duplicateCheck(int[] userNumberArray) {
        if (userNumberArray[0] == userNumberArray[1] || userNumberArray[0] == userNumberArray[2] || userNumberArray[1] == userNumberArray[2]) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }
    }

    public static int[] getUserNumbers(Scanner scanner) {
        InputView.printGetNumbers();
        int userNumbers = scanner.nextInt();
        validNumOfDigit(userNumbers);
        int[] userNumberArray = userNumbersToArray(userNumbers);
        duplicateCheck(userNumberArray);
        return userNumberArray;
    }

    public static void validNumOfDigit(int userNumbers) {
        if (userNumbers >= Math.pow(10, NUMBER_OF_DIGIT) || userNumbers < Math.pow(10, NUMBER_OF_DIGIT - 1)) {
            throw new IllegalArgumentException(NUMBER_OF_DIGIT + "자리 숫자를 입력해주세요");
        }
    }

    public static boolean checkStrike(int userNumber, int randomNumber) {
        return userNumber == randomNumber;
    }

    public static boolean checkBall(int userNumbers, int[] randomNumbers) {
        for (int randomNumber : randomNumbers) {
            if (userNumbers == randomNumber) {
                return true;
            }
        }
        return false;
    }

    public static int[] getResult(int[] userNumbers, int[] randomNumbers) {
        int[] result = new int[2];
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < NUMBER_OF_DIGIT; i++) {
            if (checkStrike(userNumbers[i], randomNumbers[i])) {
                strike++;
            } else if (checkBall(userNumbers[i], randomNumbers)){
                ball++;
            }
        }
        result[0] = strike;
        result[1] = ball;
        return result;
    }

    public static void printResult(int ball, int strike) {
        String text = "";
        if (ball == 0 & strike == 0) {
            text = "낫싱";
        } else if (strike == NUMBER_OF_DIGIT) {
          text += Integer.toString(NUMBER_OF_DIGIT) + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
        } else {
            if (ball != 0) {
                text += Integer.toString(ball) + "볼 ";
            }
            if (strike != 0) {
                text += Integer.toString(strike) + "스트라이크";
            }
        }
        System.out.println(text);
    }

    public static boolean isReGame(boolean flag, Scanner scanner) {
        InputView.printIsRegame();
        int reGameFlag = scanner.nextInt();
        if (reGameFlag != ReGame.REGAME.getValue() & reGameFlag != ReGame.STOP.getValue()) {
            throw new IllegalArgumentException("1이나 2를 입력해주세요!");
        } else if (reGameFlag == ReGame.STOP.getValue()) {
            flag = false;
        }
        return flag;
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            int strike = 0;
            int[] randomNumbers = getRandomNumbers();
//            for (int i = 0; i < NUMBER_OF_DIGIT; i++) {
//                System.out.println(randomNumbers[i]);
//            }
            while (strike != NUMBER_OF_DIGIT) {
                int[] userNumbers = getUserNumbers(scanner);
                int[] result = getResult(userNumbers, randomNumbers);
                strike = result[0];
                int ball = result[1];
                printResult(ball, strike);
            }
            flag = isReGame(flag, scanner);
        }
    }
}
