package game;

import game.ball.ComputerBalls;
import game.ball.Transforming;
import org.junit.runner.Computer;
import views.View;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PlayGame {

    public static void PlayGame(int numberLength, Scanner scanner) {
        List<Integer> computerList = Transforming.NumbertoList(ComputerBalls.ComputerBall(numberLength));
        System.out.println(computerList);

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



//        System.out.println(playerList);
//        System.out.println(computerList);
        }
    }
