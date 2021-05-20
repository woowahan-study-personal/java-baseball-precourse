package game;

import game.ball.Transforming;
import views.View;

import java.util.List;
import java.util.Scanner;

public class Round {

    public static void Rounds(int numberLength, List<Integer> computerList, Scanner scanner){
        View.Start(); // 숫자 입력
        // while
        int playerNumber = scanner.nextInt();
        if (!Check.ValidBalls(playerNumber)) {
            View.DuplicateError();
            return ;
        } else if (Integer.toString(playerNumber).length() != numberLength) {
            View.LengthError(numberLength);
            return;
        }
        List<Integer> playerList = Transforming.NumbertoList(playerNumber);
        System.out.println(Check.SB(playerList,computerList));
    }
}
