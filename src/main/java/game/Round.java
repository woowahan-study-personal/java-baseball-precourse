package game;

import game.ball.Transforming;
import views.Error;
import views.View;

import java.util.List;
import java.util.Scanner;

public class Round {

    public static String Rounds(int numberLength, List<Integer> computerList, Scanner scanner) {
        String result = null;
        View.Start(); // 숫자 입력
        int playerNumber = scanner.nextInt();
        if (Valid(playerNumber, numberLength)) {
            List<Integer> playerList = Transforming.NumbertoList(playerNumber);
            List<Integer> SandB = Check.SB(playerList, computerList);
            result = View.Result(SandB);
            //
            System.out.println(result);
        }
        return result;
    }

    public static boolean Valid(int playerNumber, int numberLength) {
        if (!Check.ValidBalls(playerNumber)) {
            Error.DuplicateError();
            return false;
        } else if (Integer.toString(playerNumber).length() != numberLength) {
            Error.LengthError(numberLength);
            return false;
        }
        return true;
    }
}
