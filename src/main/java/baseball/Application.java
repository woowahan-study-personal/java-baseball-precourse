package baseball;

import java.util.Scanner;
import utils.RandomUtils;

public class Application {
    public static final int NUMBER_OF_DIGIT = 3;
    public static final int START_OF_RAND_NUMBER = 0;
    public static final int END_OF_RAND_NUMBER = 9;
    public static final int LENGTH_OF_POSSIBLE_NUMBER = 10;

    public static int[] getRandomNumbers() {
        int[] numbers = new int[NUMBER_OF_DIGIT];
        boolean[] visitNumbers = new boolean[LENGTH_OF_POSSIBLE_NUMBER];
        for (int i = 0; i < NUMBER_OF_DIGIT; i++) {
            while (true) {
                int number = RandomUtils.nextInt(START_OF_RAND_NUMBER, END_OF_RAND_NUMBER);
                if (i == 0 & number == 0) {
                    continue;
                }
                if (visitNumbers[number]) {
                    continue;
                }
                numbers[i] = number;
                visitNumbers[number] = true;
                break;
            }
        }
        return numbers;
    }

    public static int[] getUserNumbers() {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        int userNumbers = sc.nextInt();
        if (userNumbers >= Math.pow(10, NUMBER_OF_DIGIT) || userNumbers < Math.pow(10, NUMBER_OF_DIGIT - 1)) {
            throw new IllegalArgumentException("세 자리 숫자를 입력해주세요");
        }
        int[] userNumberArray = new int[NUMBER_OF_DIGIT];
        userNumberArray[0] = userNumbers / 100;
        userNumbers %= 100;
        userNumberArray[1] = userNumbers / 10;
        userNumbers %= 10;
        userNumberArray[2] = userNumbers;
        if (userNumberArray[0] == userNumberArray[1] || userNumberArray[0] == userNumberArray[2] || userNumberArray[1] == userNumberArray[2]) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }
        return userNumberArray;
    }

    public static int[] checkResult(int[] userNumbers, int[] randomNumbers) {
        int[] result = new int[2];
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < NUMBER_OF_DIGIT; i++) {
            if (userNumbers[i] == randomNumbers[i]) {
                strike++;
            } else {
                for (int randomNumber : randomNumbers) {
                    if (userNumbers[i] == randomNumber) {
                        ball++;
                        break;
                    }
                }
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

    public static boolean isReGame(boolean flag) {
        Scanner sc = new Scanner(System.in);
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int reGameFlag = sc.nextInt();
        if (reGameFlag != 1 & reGameFlag != 2) {
            throw new IllegalArgumentException("1이나 2를 입력해주세요!");
        } else if (reGameFlag == 2) {
            flag = false;
        }
        return flag;
    }

    public static void main(String[] args) {
        boolean flag = true;
        while (flag) {
            int strike = 0;
            int[] randomNumbers = getRandomNumbers();
            for (int i = 0; i < NUMBER_OF_DIGIT; i++) {
                System.out.println(randomNumbers[i]);
            }
            while (strike != NUMBER_OF_DIGIT) {
                int[] userNumbers = getUserNumbers();
                int[] result = checkResult(userNumbers, randomNumbers);
                strike = result[0];
                int ball = result[1];
                printResult(ball, strike);
            }
            flag = isReGame(flag);
        }
    }
}
