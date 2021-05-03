package baseball.views;

import baseball.elements.NumberTools;
import java.util.Scanner;

public class PlayerInput {

    private static final int runNewGame = 1;
    private static final int quitGame = 2;

    private PlayerInput() {
    }

    public static boolean askNewGame(Scanner sc) {
        int number;
        boolean result = false;

        try {
            PlayMessages.askPlayNewGameMessage();
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

    public static String askPlayerNumber(Scanner sc) throws IllegalArgumentException {
        PlayMessages.askNumberInputMessage();

        int playerNumber = sc.nextInt();

        while (!NumberTools.verify(playerNumber)) {
            PlayMessages.notAllowedNumberRangeMessage();
            playerNumber = sc.nextInt();
        }

        return Integer.toString(playerNumber);
    }
}
