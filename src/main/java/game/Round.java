package game;

import game.ball.Check;
import game.ball.Transforming;
import views.ViewError;
import views.View;

import java.util.List;
import java.util.Scanner;

public class Round {

    public static String Rounds(int numberLength, List<Integer> computerList, Scanner scanner) {
        String result = null;
        View.Start(); // 숫자 입력
        int playerNumber = scanner.nextInt();
        if (Valid(playerNumber, numberLength)) {
            List<Integer> playerList = Transforming.NumberList(playerNumber);
            List<Integer> SandB = Check.SB(playerList, computerList);
            result = View.Result(SandB);
            System.out.println(result);
        }
        return result;
    }

    public static boolean Valid(int playerNumber, int numberLength) {
        if (!Check.ValidBalls(playerNumber)) {
            ViewError.DuplicateError();
            return false;
        } else if (Integer.toString(playerNumber).length() != numberLength) {
            ViewError.LengthError(numberLength);
            return false;
        }
        return true;
    }
}
