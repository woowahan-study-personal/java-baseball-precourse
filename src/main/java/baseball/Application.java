package baseball;

import utils.RandomUtils;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Application {
    private static final int NUMBERS_LENGTH = 3;
    private static boolean correctNumbers = false;
    private static int[] numbers = new int[NUMBERS_LENGTH];
    private static int[] userInputNumbers = new int[NUMBERS_LENGTH];

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

    // userInputNumber를 for문(세번) 돌면서
    // numbers에 userInputNumber가 있는지 확인하는 기능
    public static String compareNumbers() {
        for (int i = 0; i < NUMBERS_LENGTH; i++) {
            int userInputNumber = userInputNumbers[i];
            boolean compareResult = (IntStream.of(numbers).anyMatch(x -> x == userInputNumber));
        }
        return "";
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        String MESSAGE = "숫자를 입력해주세요 : ";
        int userInput;

        setRandomNumbers();
        // 여기서 while문 시작
        // modUserInput에서 correctNumbers가 true값으로 바뀌면 while문 종료
        while (!correctNumbers) {
            System.out.print(MESSAGE);
            userInput = scanner.nextInt();
            // userInput으로 Exception 띄우기
            // => 숫자 아닌 문자열일 때, 세자리 초과 숫자일 때, 같은 숫자 중복 입력했을 때

            modUserInput(userInput);

            compareNumbers();
        }
    }
}
