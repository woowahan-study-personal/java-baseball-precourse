package game;

import game.ball.ComputerBalls;
import game.ball.Transforming;
import org.junit.runner.Computer;
import views.View;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainGame {

    public static void PlayGame(int numberLength, Scanner scanner) {
        List<Integer> computerList = Transforming.NumbertoList(ComputerBalls.ComputerBall(numberLength));
        Round.Rounds(numberLength, computerList, scanner);



//        System.out.println(playerList);
//        System.out.println(computerList);
        }
    }
