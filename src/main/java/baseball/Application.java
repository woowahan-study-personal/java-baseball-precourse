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

    public static int[] getUserNumbers() {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        int userNumbers = sc.nextInt();
        if (userNumbers >= 1000 || userNumbers < 100) {
            throw new IllegalArgumentException("세 자리 숫자를 입력해주세요");
        }
        int[] userNumberArray = new int[3];
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

//    public static String checkResult() {
//
//    }

    public static void main(String[] args) {
//        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        int[] num = getUserNumbers();
        System.out.println(num[0]);
    }
}
