package game;

import game.ball.Check;
import game.ball.Transforming;
import views.ViewError;
import views.View;

import java.util.List;
import java.util.Scanner;

public class Round {

    public static String rounds(int numberLength, List<Integer> computerList, Scanner scanner) {
        String result = null;
        View.start(); // 숫자 입력
        int playerNumber = scanner.nextInt();
        if (valid(playerNumber, numberLength)) {
            List<Integer> playerList = Transforming.numberList(playerNumber);
            List<Integer> SandB = Check.sb(playerList, computerList);
            result = View.result(SandB);
            System.out.println(result);
        }
        return result;
    }

    public static boolean valid(int playerNumber, int numberLength) {
        if (!Check.validBalls(playerNumber)) {
            ViewError.duplicateError();
            return false;
        } else if (Integer.toString(playerNumber).length() != numberLength) {
            ViewError.lengthError(numberLength);
            return false;
        }
        return true;
    }
}
