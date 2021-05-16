package baseball;

import java.util.List;

public class ResultTell {

    public static String HowResult(int a, int num, List computerList, List playerList) {
        String result = "";
        int strike = 0;
        if (a == 0) {
            return "낫싱";
        }
        for (int i = 0; i < num; i++) {
            if (playerList.get(i) == computerList.get(i)) {
                strike++;
            }
        }
        int ball = a - strike;
        if (ball > 0) {
            result += ball + "볼 ";
        }
        if (strike > 0) {
            result += strike + "스트라이크";
        }
        return result;
    }
}
