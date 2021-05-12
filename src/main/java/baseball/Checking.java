package baseball;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Checking {

    public static String CompareNumber(List computerList, int player) {
        LinkedList<Integer> playerList = new LinkedList<Integer>();
        while (player > 0) {
            playerList.push(player % 10);
            player /= 10;
        }
        int result = 0;
        for (int i = 0;i<3;i++) {

        }
        return null;
    }
}
