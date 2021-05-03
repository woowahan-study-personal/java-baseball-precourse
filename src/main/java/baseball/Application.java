package baseball;

import utils.RandomUtils;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Application {
    private static final int NUMBERS_LENGTH = 3;
    private static boolean correctNumbers = false;
    private static int[] numbers = new int[NUMBERS_LENGTH];
    private static int[] userInputNumbers = new int[NUMBERS_LENGTH];
    private static int ball = 0;
    private static int strike = 0;

    public static int getRandomNumber() {
        int START_NUMBER = 1;
        int END_NUMBER = 9;
        int number = RandomUtils.nextInt(START_NUMBER, END_NUMBER);
        return number;
    }

    public static boolean checkRandomNumber(int number) {
        return (IntStream.of(numbers).anyMatch(x -> x == number));
    }

    public static int[] setRandomNumbers() {
        int i = 0;
        while (i < NUMBERS_LENGTH) {
            int number = getRandomNumber();
            if (checkRandomNumber(number) == false) {
                numbers[i] = number;
                i++;
            }
        }
        for (int j = 0; j < 3; j++) {
            System.out.println(numbers[j]);
        }

        return numbers;
    }

    public static int[] modUserInput(int userInput) {
        int MINIMUM = 0;
        int i = (NUMBERS_LENGTH - 1);

        while (MINIMUM < userInput) {
            userInputNumbers[i] = userInput % 10;
            userInput = userInput / 10;
            i--;
        }

        for (int j = 0; j < NUMBERS_LENGTH; j++) {
            System.out.println(userInputNumbers[j]);
        }

        return userInputNumbers;
    }

    public static StringBuilder printResult() {
        StringBuilder message = new StringBuilder("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        StringBuilder result = new StringBuilder("");

        if (strike == NUMBERS_LENGTH) {
            correctNumbers = true;
            ball = 0;
            strike = 0;
            System.out.println(message);
            return message;
        } if (ball != 0) {
            result.append(ball + "볼 ");
        } if (strike != 0) {
            result.append(strike + "스트라이크");
        } if (ball == 0 && strike ==0) {
            result.append("낫싱");
        }

        ball = 0;
        strike = 0;
        System.out.println(result);
        return result;
    }

    public static int findNumberIndex(int userInputNumber) {
        int numberIndex = 0;
        for (int i = 0; i < NUMBERS_LENGTH; i++) {
            if (numbers[i] == userInputNumber) {
                numberIndex = i;
            }
        }
        return numberIndex;
    }

    public static String checkStrikeAndBall(boolean compareResult, int userInputNumber, int userInputIndex) {
        int numbersIndex = findNumberIndex(userInputNumber);

        if (compareResult == true) {
            if (numbersIndex == userInputIndex) {
                strike += 1;
            } else {
                ball += 1;
            }
        }
        return "";
    }

    public static String compareNumbers() {
        for (int i = 0; i < NUMBERS_LENGTH; i++) {
            int userInputNumber = userInputNumbers[i];
            boolean compareResult = (IntStream.of(numbers).anyMatch(x -> x == userInputNumber));
            checkStrikeAndBall(compareResult, userInputNumber, i);
        }
        return "";
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        String MESSAGE = "숫자를 입력해주세요 : ";
        int userInput;

        setRandomNumbers();
        while (!correctNumbers) {
            System.out.print(MESSAGE);
            userInput = scanner.nextInt();

            modUserInput(userInput);

            compareNumbers();

            printResult();
        }
    }
}
