package game;

import game.ball.ComputerBalls;
import game.ball.Transforming;

import java.util.List;
import java.util.Scanner;

public class MainGame {

    public static void PlayGame(int numberLength, Scanner scanner) {
        List<Integer> computerList = Transforming.NumbertoList(ComputerBalls.ComputerBall(numberLength));
        System.out.println(computerList);
        String result = "";
        while (!result.equals(numberLength+"스트라이크")) {
            result = Round.Rounds(numberLength, computerList, scanner);
        }
        System.out.println("종료");


    }
}
