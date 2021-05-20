package game;

import game.ball.Transforming;

import java.util.ArrayList;
import java.util.List;

public class Check {

    public static void PlayerNumber(int num) {
        List<Integer> plyaerList = Transforming.NumbertoList(num);


    }

    public static boolean TobeContinue(int num) {
        if (num == 1) {
            return true;
        } else {
            return false;
        }
    }
}
