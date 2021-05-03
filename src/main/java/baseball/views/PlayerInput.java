package baseball.views;

import java.util.Scanner;

public class PlayerInput {
    private static final int runNewGame = 1;
    private static final int quitGame = 2;

    private PlayerInput() {}

    public static boolean askNewGame(Scanner sc) {
        int number;
        boolean result = false;

        try {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            number = sc.nextInt();
        } catch (Exception e) {
            throw new IllegalArgumentException("올바른 값을 입력하시기 바랍니다");
        }

        if (number != runNewGame && number != quitGame) {
            throw new IllegalArgumentException("올바른 숫자를 입력하시기 바랍니다");
        }

        if (number == runNewGame) {
            result = true;
        }

        return result;
    }

    public static int askPlayerNumber(Scanner sc) throws IllegalArgumentException{
        System.out.print("숫자를 입력해주세요 : ");
        return sc.nextInt();
    }
}
