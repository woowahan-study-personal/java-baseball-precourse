package baseball;

import utils.RandomUtils;

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

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
    }
}
