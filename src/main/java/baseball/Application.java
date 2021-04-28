package baseball;

import java.util.Scanner;
import utils.RandomUtils;

public class Application {
    final static int maxNumberLength = 3;

    public static int[] getRandomNumbers() {
        int[] numbers = new int[3];
        int[] visitNumbers = new int[10];
        for (int i = 0; i < maxNumberLength; i++) {
            while (true) {
                int number = RandomUtils.nextInt(0, 9);
                if (i == 0 & number == 0) {
                    continue;
                }
                if (visitNumbers[number] == 1) {
                    continue;
                }
                numbers[i] = number;
                visitNumbers[number] = 1;
                break;
            }
        }
        return numbers;
    }

    public static int getUserNumbers() {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        int userNumbers = sc.nextInt();
        return userNumbers;
    }

    public static void main(String[] args) {
//        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
    }
}
