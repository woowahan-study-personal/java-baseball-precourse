package game;

import game.ball.ComputerBalls;
import game.ball.Transforming;
import views.View;
import views.ViewError;

import java.util.List;
import java.util.Scanner;

public class MainGame {
    private static final int continueGame = 1;
    private static final int gameover = 2;

    public static void PlayGame(int numberLength, Scanner scanner) {
        List<Integer> computerList = Transforming.NumberList(ComputerBalls.ComputerBall(numberLength));
        System.out.println(computerList); // 테스트를 위해서 넣었음
        String result = "";
        while (!result.equals(numberLength + "스트라이크")) {
            result = Round.Rounds(numberLength, computerList, scanner);
        }
        View.EndGame(numberLength);
        Continue(numberLength, scanner);
    }

    public static void Continue(int numberLength, Scanner scanner) {
        int coin = scanner.nextInt();
        try{
            if (coin == continueGame) {
                PlayGame(numberLength, scanner);
            } else if (coin != gameover) {
                ViewError.NumberError();
                Continue(numberLength, scanner);
            }
        } catch (Exception e) {
            ViewError.NumberError();
            Continue(numberLength, scanner);
        }

    }
}
