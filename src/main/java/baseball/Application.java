package baseball;

import utils.RandomUtils;
import java.util.stream.IntStream;
import java.util.Scanner;

public class Application {
    private static final int NUMBERS_LENGTH = 3;
    private static final int[] numbers = new int[NUMBERS_LENGTH];

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

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        setRandomNumbers();
    }
}
