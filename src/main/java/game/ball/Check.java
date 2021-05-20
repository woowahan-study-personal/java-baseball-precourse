package game.ball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Check {

    public static boolean ValidBalls(int num) {
        List<Integer> checkList = Transforming.NumberList(num);
        for (int i = 0; i < checkList.size() - 1; i++) {
            if (checkList.get(i + 1) == 0) {
                return false;
            }
            if (checkList.subList(i + 1, checkList.size()).contains(checkList.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> SB(List<Integer> PlayerList, List<Integer> ComputerList) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < PlayerList.size(); i++) {
            if (ComputerList.contains(PlayerList.get(i))) {
                ball++;
            }
            if (ComputerList.get(i).equals(PlayerList.get(i))) {
                strike++;
                ball--;
            }
        }
        return new ArrayList<>(Arrays.asList(strike, ball));
    }
}
