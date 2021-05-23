package game;

import game.ball.ComputerBalls;
import game.ball.Transforming;
import views.View;
import views.ViewError;

import java.util.List;
import java.util.Scanner;

public class MainGame {
    private static final int CONTINUE_GAME = 1;
    private static final int GAMEOVER = 2;

    public static void playGame(int numberLength, Scanner scanner) {
        List<Integer> computerList = Transforming.numberList(ComputerBalls.computerBall(numberLength));
        String result = "";
        while (!result.equals(numberLength + "스트라이크")) {
            result = Round.rounds(numberLength, computerList, scanner);
        }
        View.endGame(numberLength);
        continueGame(numberLength, scanner);
    }

    public static void continueGame(int numberLength, Scanner scanner) {
        int coin = scanner.nextInt();
        try {
            if (coin == CONTINUE_GAME) {
                playGame(numberLength, scanner);
            } else if (coin != GAMEOVER) {
                ViewError.numberError();
                continueGame(numberLength, scanner);
            }
        } catch (Exception e) {
            ViewError.numberError();
            continueGame(numberLength, scanner);
        }
    }
}
